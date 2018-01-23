package dk.lndesign.kotlinspring.model.response

data class Section(val title: String?,
                   val identifier: String?,
                   val url: String?,
                   val hex_color: String?,
                   val type: String?,
                   val statistics: Statistics?) {
    constructor() : this(null, null, null, null, null, null)
}