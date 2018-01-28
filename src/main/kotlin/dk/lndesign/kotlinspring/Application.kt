package dk.lndesign.kotlinspring

import dk.lndesign.kotlinspring.model.repository.LocalSectionRepository
import dk.lndesign.kotlinspring.model.repository.RemoteSectionRepository
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import springfox.documentation.builders.PathSelectors.regex
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


/**
 * Sprint Boot application configuration.
 */
@SpringBootApplication
@EnableSwagger2
class Application {

    // Default bean scope is singleton scope, only one instance per application.
    @Bean
    fun providesRestTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    fun providesRemoteSectionRepository(): RemoteSectionRepository {
        return RemoteSectionRepository()
    }

    @Bean
    fun providesLocalSectionRepository(): LocalSectionRepository {
        return LocalSectionRepository()
    }

    @Bean
    fun productApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("dk.lndesign.kotlinspring"))
                .paths(regex("/.*"))
                .build()

    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}