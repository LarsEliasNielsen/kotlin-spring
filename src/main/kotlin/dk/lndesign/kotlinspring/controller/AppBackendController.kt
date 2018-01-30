package dk.lndesign.kotlinspring.controller

import dk.lndesign.kotlinspring.model.repository.LocalSectionRepository
import dk.lndesign.kotlinspring.model.repository.RemoteSectionRepository
import dk.lndesign.kotlinspring.model.repository.SectionRepository
import dk.lndesign.kotlinspring.model.response.Section
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger

@Api(tags = ["app-backend"], description = "Controller for app-backend.tv2.dk")
@RestController
@RequestMapping("/app-backend")
class AppBackendController {

    val LOG = Logger.getLogger(this.javaClass.name)

    // Auto inject singleton instance of repository.
    @Autowired
    @Qualifier(LocalSectionRepository.LOCAL_SECTION_REPOSITORY)
    lateinit var localSectionRepository: SectionRepository

    @Autowired
    @Qualifier(RemoteSectionRepository.REMOTE_SECTION_REPOSITORY)
    lateinit var remoteSectionRepository: SectionRepository

    // Mapping GET request to path.
    @ApiOperation(value = "Fetch remotely stored sections")
    @RequestMapping(value = ["/{appId}/sections/fetch"], method = [RequestMethod.GET], produces = ["application/json"])
    fun fetchSections(@PathVariable("appId") appId: String): List<Section> {
        LOG.info("Fetching sections from remote")

        // TODO: Handle errors and exceptions in response.
        return remoteSectionRepository.getAll(appId)
    }

    @ApiOperation(value = "Fetch locally stored sections")
    @RequestMapping(value = ["/{appId}/sections"], method = [RequestMethod.GET], produces = ["application/json"])
    fun getSections(@PathVariable("appId") appId: String): List<Section> {
        LOG.info("Fetching sections from local")

        // TODO: Handle errors and exceptions in response.
        return localSectionRepository.getAll(appId)
    }
}