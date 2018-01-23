package dk.lndesign.kotlinspring.model.response

data class Statistics(
        val chartbeat: Chartbeat?
) {
    constructor() : this(null)
    data class Chartbeat(
            val viewid: String?,
            val title: String?
    ) {
        constructor() : this(null, null)
    }
}