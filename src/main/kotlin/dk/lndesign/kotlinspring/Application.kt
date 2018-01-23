package dk.lndesign.kotlinspring

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

const val LATEST_NEWS_URL = "https://decms-api.tv2.dk/search?fq=type%3A(%22x-tv2%2Farticle%22+OR+%22x-tv2%2Fopinion%22+OR+%22x-tv2%2Fliveblog%22+OR+%22x-tv2%2Ffull-page%22+OR+%22x-tv2%2Fgallery%22)+vocabulary_section%3A(%22nyheder%22)+published%3A(%22true%22)+listed%3A(%22true%22)&sort=modified+desc&access_token=4200217aa432441c87b68306c7ef050c&rows=20&load_documents=yes"
const val SECTIONS_URL = "https://app-backend.api.tv2.dk/nyhedscenter/sections/v6/"