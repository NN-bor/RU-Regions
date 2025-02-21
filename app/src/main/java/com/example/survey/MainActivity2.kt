package com.example.survey

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners


class MainActivity2 : ComponentActivity() {

    private var countries = mutableListOf(
        Pair("Чечня", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Flag_of_the_Chechen_Republic.svg/1200px-Flag_of_the_Chechen_Republic.svg.png"),
        Pair("Башкирия", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Flag_of_Bashkortostan.svg/640px-Flag_of_Bashkortostan.svg.png"),
        Pair("Татарстан", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/28/Flag_of_Tatarstan.svg/1200px-Flag_of_Tatarstan.svg.png"),
        Pair("Санкт-Петербург", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Flag_of_Saint_Petersburg.svg/1200px-Flag_of_Saint_Petersburg.svg.png"),
        Pair("Московская область", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Russia_flag_of_Moscow_oblast.svg/1200px-Russia_flag_of_Moscow_oblast.svg.png"),
        Pair("Дагестан", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Flag_of_Dagestan.svg/1200px-Flag_of_Dagestan.svg.png"),
        Pair("Крым", "https://www.pnp.ru/upload/entities/2021/09/23/16/article/detailPicture/e6/fd/a5/dc/3f768b48f5356bd9f483d5bf240d891f.jpg"),
        Pair("Мордовия", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Flag_of_Mordovia.svg/1200px-Flag_of_Mordovia.svg.png"),
        Pair("Бурятия", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Flag_of_Komi.svg/1200px-Flag_of_Komi.svg.png"),
        Pair("Тыва", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Flag_of_Tuva.svg/1200px-Flag_of_Tuva.svg.png"),
        Pair("Красноярский край", "https://www.prlib.ru/sites/default/files/book_preview/a8f1857e-703d-4015-ac01-9cd26d4d2cda/259435_doc1_6F920D9A-14A1-4356-A008-AB5DDE3BF0D4.jpg"),
        Pair("Марий Эл", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/Flag_of_Mari_El.svg/1200px-Flag_of_Mari_El.svg.png"),
        Pair("Алтайский край", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Flag_of_Altai_Krai.svg/1200px-Flag_of_Altai_Krai.svg.png"),
        Pair("Камчатский край", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/Flag_of_Kamchatka_Krai.svg/1200px-Flag_of_Kamchatka_Krai.svg.png"),
        Pair("Адыгея", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Flag_of_Adygea.svg/1200px-Flag_of_Adygea.svg.png"),
        Pair("Калмыкия", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Flag_of_Kalmykia.svg/1200px-Flag_of_Kalmykia.svg.png"),
        Pair("Чувашская республика", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Flag_of_Chuvashia.svg/1200px-Flag_of_Chuvashia.svg.png"),
        Pair("Владимирская область", "https://f-gl.ru/images/flag/Russia/VladimirskayaObl/FlagVladimira.jpg"),
        Pair("Волгоградская область", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Flag_of_Volgograd_Oblast.svg/640px-Flag_of_Volgograd_Oblast.svg.png"),
        Pair("Ивановская область", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Flag_of_Ivanovo_Oblast.svg/1200px-Flag_of_Ivanovo_Oblast.svg.png"),
        Pair("Калужская область", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Flag_of_Kaluga_Oblast.svg/1200px-Flag_of_Kaluga_Oblast.svg.png"),
        Pair("Кемеровская область", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Flag_of_Kemerovo_Oblast.svg/1200px-Flag_of_Kemerovo_Oblast.svg.png"),
        Pair("Курская область", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/Flag_of_Kursk_Oblast.svg/1200px-Flag_of_Kursk_Oblast.svg.png"),
        Pair("Нижегородская область", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Flag_of_Nizhny_Novgorod_Region.svg/1200px-Flag_of_Nizhny_Novgorod_Region.svg.png"),
        Pair("Новосибирская область", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Flag_of_Novosibirsk_oblast.svg/1200px-Flag_of_Novosibirsk_oblast.svg.png"),
        Pair("Омская область", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/Flag_of_Omsk_Oblast.svg/1200px-Flag_of_Omsk_Oblast.svg.png")
    )

    private val firstCountriesCount = 10
    private var answersCount: Int = 1
    private var trueAnswersCount: Int = 0

    private val answers: List<String> = listOf(
        "Архангельская область",
        "Владимирская область",
        "Волгоградская область",
        "Ивановская область",
        "Калининградская область",
        "Калужская область",
        "Кемеровская область",
        "Костромская область",
        "Курская область",
        "Липецкая область",
        "Липецкая область",
        "Мурманская область",
        "Нижегородская область",
        "Новгородская область",
        "Новосибирская область",
        "Омская область",
        "Чечня",
        "Башкирия",
        "Удмуртия",
        "Калмыкия",
        "Санкт-Петербург",
        "Татарстан",
        "Московская область",
        "Бурятия",
        "Мордовия",
        "Крым",
        "Дагестан",
        "Республика Коми",
        "Тыва",
        "Красноярский край",
        "Марий Эл",
        "Алтайский край",
        "Камчатский край",
        "Адыгея",
        "Чувашская республика",
    )

    private var currentCountryIndex: Int = 1

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val flagImageView: ImageView = findViewById(R.id.flagImageView)
        val ansList: RadioGroup = findViewById(R.id.ansList)
        val ansCost: TextView = findViewById(R.id.ansCost)
        ansCost.text = "Вопрос $answersCount/$firstCountriesCount"


        countries.shuffle()
        showRandomFlag(flagImageView, countries)



        setRandomAnswersText(ansList, answers, currentCountryIndex)


        val confirmButton: Button = findViewById(R.id.confirmButton)
        confirmButton.setOnClickListener {
            isAnswerCorrect(flagImageView, ansList, ansCost)
        }
    }

    private fun setRandomAnswersText(
        ansList: RadioGroup,
        texts: List<String>,
        currentCountryIndex: Int
    ) {
        val currentCountryText = countries[currentCountryIndex].first
        val filteredTexts = texts.filter { it != currentCountryText }
        val answers = filteredTexts.shuffled().take(3) + currentCountryText
        val finalAnswers = answers.shuffled()

        for (n in finalAnswers.indices) {
            val radioButton = ansList.getChildAt(n) as RadioButton
            radioButton.text = finalAnswers[n]
        }
        return
    }

    private fun showRandomFlag(flagImageView: ImageView, countries: List<Pair<String, String>>) {
        val flagRes = countries[currentCountryIndex].second
        Glide.with(this )
            .load(flagRes)
            .transform(RoundedCorners(20))
            .into(flagImageView)
    }

    @SuppressLint("SetTextI18n")
    private fun isAnswerCorrect(flagImageView: ImageView, ansList: RadioGroup, ansCost: TextView) {

        val selectedButtonId = ansList.checkedRadioButtonId

        if (selectedButtonId == -1) {
            val toast = Toast.makeText(
                applicationContext,
                "Выберите 1 из вариантов ответа.",
                Toast.LENGTH_SHORT
            )
            toast.show()
            return
        }

        if (answersCount == 10) {
            val transition = Intent(this, Activity3::class.java)
            val strTrueAnsCt = trueAnswersCount.toString()
            val strAnsCt = answersCount.toString()
            transition.putExtra("trueAnsCt", strTrueAnsCt)
            transition.putExtra("answersCount", strAnsCt)
            startActivity(transition)
            return
        }

        val checkedButtonId = ansList.checkedRadioButtonId
        val trueCountryName = countries[currentCountryIndex].first
        val checkedButtonName = findViewById<RadioButton>(checkedButtonId).text

        if (checkedButtonName == trueCountryName) {
            trueAnswersCount += 1
        }

        countries.removeAt(currentCountryIndex)

        if (countries.isNotEmpty()) {
            currentCountryIndex = (currentCountryIndex % countries.size)
            setRandomAnswersText(ansList, answers, currentCountryIndex)
            showRandomFlag(flagImageView, countries)
            ansList.clearCheck()
        }
        answersCount += 1
        ansCost.text = "Вопрос $answersCount/$firstCountriesCount"
    }
}
