package dk.lndesign.kotlinspring.model.repository

import dk.lndesign.kotlinspring.model.response.Section
import dk.lndesign.kotlinspring.model.response.Statistics

/**
 * Providing copies of locally stored sections.
 */
class LocalSectionRepository: SectionRepository {

    override fun getAll(appId: String): List<Section> {
        return getSections(appId)
    }

    private fun getSections(appId: String): List<Section> {
        return when (appId) {
            NEWS_APP_ID -> {
                listOf(Section(
                            "Tophistorier",
                            "1",
                            "https://tv2.dk/",
                            "d11f1f",
                            "topstory",
                            Statistics(Statistics.Chartbeat(
                                    "section/tophistorier",
                                    "Tophistorier - TV 2 Nyheder"
                            ))),
                        Section(
                            "Seneste nyt",
                            "2",
                            "https://tv2.dk/",
                            "d11f1f",
                            "latest",
                            Statistics(Statistics.Chartbeat(
                                    "section/seneste_nyt",
                                    "Seneste nyt - TV 2 Nyheder"
                            ))),
                        Section(
                            "Mest sete",
                            "33",
                            "https://tv2.dk/",
                            "d11f1f",
                            "mostread",
                            Statistics(Statistics.Chartbeat(
                                    "section/mest_sete",
                                    "Mest sete - TV 2 Nyheder"
                            )))
                )
            }
            SPORT_APP_ID -> {
                listOf(Section(
                            "Forside",
                            "4",
                            "https://tv2.dk/",
                            "0267f5",
                            "topstory",
                            Statistics(Statistics.Chartbeat(
                                    "section/forside",
                                    "Forside - TV 2 Sport"
                            ))),
                    Section(
                            "Seneste nyt",
                            "28",
                            "https://tv2.dk/",
                            "0267f5",
                            "latest",
                            Statistics(Statistics.Chartbeat(
                                    "section/seneste_nyt",
                                    "Seneste nyt - TV 2 Sport"
                            ))),
                    Section(
                            "Håndbold",
                            "12",
                            "https://tv2.dk/",
                            "0267f5",
                            "sport",
                            Statistics(Statistics.Chartbeat(
                                    "section/håndbold",
                                    "Håndbold - TV 2 Sport"
                            )))
                )
            }
            else -> listOf()
        }
    }
}