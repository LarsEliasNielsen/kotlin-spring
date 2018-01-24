package dk.lndesign.kotlinspring.model.repository

import dk.lndesign.kotlinspring.model.response.Section
import dk.lndesign.kotlinspring.model.response.Statistics

/**
 * Providing copies of locally stored sections.
 */
class LocalSectionRepository: SectionRepository {

    override fun getAll(): List<Section> {
        return listOf(
                Section(
                        "Tophistorier",
                        "1",
                        "http://app-backend.api.tv2.dk/nyhedscenter/topstories/v1/?count=5",
                        "d11f1f",
                        "topstory",
                        Statistics(Statistics.Chartbeat(
                                "section/tophistorier",
                                "Tophistorier - TV 2 Nyheder"
                        ))),
                Section(
                        "Seneste nyt",
                        "2",
                        "https://decms-api.tv2.dk/search?fq=type%3A(%22x-tv2%2Farticle%22+OR+%22x-tv2%2Fopinion%22+OR+%22x-tv2%2Fliveblog%22+OR+%22x-tv2%2Ffull-page%22+OR+%22x-tv2%2Fgallery%22)+vocabulary_section%3A(%22nyheder%22)+published%3A(%22true%22)+listed%3A(%22true%22)&sort=modified+desc&access_token=4200217aa432441c87b68306c7ef050c&rows=20&load_documents=yes",
                        "d11f1f",
                        "latest",
                        Statistics(Statistics.Chartbeat(
                                "section/seneste_nyt",
                                "Seneste nyt - TV 2 Nyheder"
                        ))),
                Section(
                        "Mest sete",
                        "33",
                        "http://app-backend.api.tv2.dk/nyhedscenter/mostread/v1/?count=20",
                        "d11f1f",
                        "mostread",
                        Statistics(Statistics.Chartbeat(
                                "section/mest_sete",
                                "Mest sete - TV 2 Nyheder"
                        )))
        )
    }
}