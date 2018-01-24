package dk.lndesign.kotlinspring.model.repository

import dk.lndesign.kotlinspring.SECTIONS_URL
import dk.lndesign.kotlinspring.model.response.Section
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.client.RestTemplate
import java.util.logging.Logger

/**
 * Providing copies of remotely stored sections.
 */
class RemoteSectionRepository: SectionRepository {

    val LOG = Logger.getLogger(this.javaClass.name)

    @Autowired
    lateinit var restTemplate: RestTemplate

    override fun getAll(): List<Section> {
        val responseEntity = restTemplate.getForEntity(SECTIONS_URL, Array<Section>::class.java)
        val objects = responseEntity.body
        val contentType = responseEntity.headers.contentType
        val statusCode = responseEntity.statusCode

        LOG.info("Request finished; status code: ${statusCode.value()}, content type: $contentType")

        return objects.toList()
    }
}