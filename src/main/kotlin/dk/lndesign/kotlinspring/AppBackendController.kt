package dk.lndesign.kotlinspring

import dk.lndesign.kotlinspring.model.repository.LocalSectionRepository
import dk.lndesign.kotlinspring.model.repository.RemoteSectionRepository
import dk.lndesign.kotlinspring.model.response.Section
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger

@RestController
class AppBackendController {

    val LOG = Logger.getLogger(this.javaClass.name)

    // Auto inject singleton instance of repository.
    @Autowired
    lateinit var localSectionRepository: LocalSectionRepository

    @Autowired
    lateinit var remoteSectionRepository: RemoteSectionRepository

    // Mapping GET request to path.
    @RequestMapping(value = ["/sections/fetch"], method = [RequestMethod.GET])
    fun fetchSections(): List<Section> {
        LOG.info("Fetching sections from remote")

        return remoteSectionRepository.getAll()
    }

    @RequestMapping(value = ["/sections"], method = [RequestMethod.GET])
    fun getSections(): List<Section> {
        LOG.info("Fetching sections from local")

        return localSectionRepository.getAll()
    }
}