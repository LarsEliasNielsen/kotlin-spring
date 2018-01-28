package dk.lndesign.kotlinspring.model.repository

import dk.lndesign.kotlinspring.model.response.Section
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.client.RestTemplate
import java.util.logging.Logger

/**
 * Providing copies of remotely stored sections.
 */
class RemoteSectionRepository: SectionRepository {

    val LOG = Logger.getLogger(this.javaClass.name)

    val NEWS_SECTIONS_VERSION = "6"
    val SPORT_SECTIONS_VERSION = "9"

    @Autowired
    lateinit var restTemplate: RestTemplate

    override fun getAll(appId: String): List<Section> {
        return when (appId) {
            NEWS_APP_ID -> getSections(appId, NEWS_SECTIONS_VERSION)
            SPORT_APP_ID -> getSections(appId, SPORT_SECTIONS_VERSION)
            else -> listOf()
        }
    }

    private fun getSections(appId: String, sectionsVersion: String): List<Section> {
        val responseEntity = restTemplate.getForEntity(
                "https://app-backend.api.tv2.dk/$appId/sections/v$sectionsVersion/",
                Array<Section>::class.java)
        val objects = responseEntity.body
        val contentType = responseEntity.headers.contentType
        val statusCode = responseEntity.statusCode

        LOG.info("Request finished; status code: ${statusCode.value()}, content type: $contentType")

        return objects.toList()
    }
}