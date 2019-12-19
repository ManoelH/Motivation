package com.manoelh.motivation.mock

import com.manoelh.motivation.util.Constants

class Phrase(val phrase: String, val category: Int)

private fun Int.random() = java.util.Random().nextInt(this)


class Mock{

    private val ALL = Constants.PHRASE_CATEGORY.ALL
    private val GOOD_MORNING = Constants.PHRASE_CATEGORY.GOOD_MORNING
    private val HAPPY = Constants.PHRASE_CATEGORY.HAPPY

    private val phrases = listOf(
        Phrase("When you start each day with a grateful heart, light illuminates from within", GOOD_MORNING),
        Phrase("Your struggle is your strength. If you can resist becoming negative, bitter or hopeless, in time," +
                "your struggles will give you everything", GOOD_MORNING),
        Phrase("Wake up and to be awesome", GOOD_MORNING),
        Phrase("Just be happy, just live your life", HAPPY),
        Phrase("The purpose of our lives is to be happy", HAPPY),
        Phrase("Be happy. Be yourself. If others don't like it, then let them be. Happiness is a choice", HAPPY)
    )

    fun getPhrase(category: Int) :String{
        var phraseFiltered = phrases.filter { it.category == category || category == ALL }
        var valueRandom = phraseFiltered.size.random()
        return phraseFiltered[valueRandom].phrase
    }

}