package dk.lndesign.kotlinspring.model.repository

import dk.lndesign.kotlinspring.model.response.Section

interface SectionRepository {
    fun getAll(appId: String): List<Section>
}

const val NEWS_APP_ID = "nyhedscenter"
const val SPORT_APP_ID = "sport"