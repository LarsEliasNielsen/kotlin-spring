package dk.lndesign.kotlinspring

import dk.lndesign.kotlinspring.model.repository.LocalSectionRepository
import dk.lndesign.kotlinspring.model.repository.RemoteSectionRepository
import dk.lndesign.kotlinspring.model.repository.SectionRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableAsync
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
@EnableCaching
@EnableAsync
@EnableSwagger2
class Application {

    // Default bean scope is singleton scope, only one instance per application.
    @Bean
    fun providesRestTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    @Qualifier(RemoteSectionRepository.REMOTE_SECTION_REPOSITORY)
    fun providesRemoteSectionRepository(): SectionRepository {
        return RemoteSectionRepository()
    }

    @Bean
    @Qualifier(LocalSectionRepository.LOCAL_SECTION_REPOSITORY)
    fun providesLocalSectionRepository(): SectionRepository {
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