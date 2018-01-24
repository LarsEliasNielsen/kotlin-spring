package dk.lndesign.kotlinspring.model.repository

import dk.lndesign.kotlinspring.model.response.Section

interface SectionRepository {
    fun getAll(): List<Section>
}