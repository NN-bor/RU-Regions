package com.example.survey

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import android.text.Html

class Activity3 : ComponentActivity() {
    private var text = ""
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        val transition = intent

        val trueAnswersCount = transition.getStringExtra("trueAnsCt")
        val answersCount = transition.getStringExtra("answersCount")

        val testDescription: TextView = findViewById(R.id.testDescprition)
        val backButton: Button = findViewById(R.id.submButton)
        val resultText: TextView = findViewById(R.id.resultText)

        backButton.setOnClickListener {
            val sectransition = Intent(this, MainActivity2::class.java)
            startActivity(sectransition)
        }

        testDescription.text = "Вы ответили правильно на $trueAnswersCount вопросов из $answersCount."

        val trueAnswersCountInt = trueAnswersCount!!.toInt()
        val answersCountInt = answersCount!!.toInt()
        if (trueAnswersCountInt >= (answersCountInt - 1)) {
            text =
                "<b>Превосходные знания</b>: Вы настоящий эксперт по флагам субъектов Российской Федерации! Ваши знания впечатляют, вы отлично разбираетесь в символике регионов и их истории.\n" +
                "Глубокое понимание: Вы не просто узнаете флаги, но и, скорее всего, понимаете их значение и связь с историей и культурой регионов.\n" +
                "Возможность гордиться: Ваши знания могут быть поводом для гордости, ведь это говорит о вашей эрудиции и интересе к своей стране."
        }
        else if (trueAnswersCountInt >= (answersCountInt - 2)) {
            text =
                "<b>Хорошие знания</b>: У вас есть хорошая база знаний о флагах субъектов РФ, вы узнаете большинство из них.\n" +
                "<b>Небольшие пробелы</b>: Возможно, есть несколько флагов, которые вызывают у вас затруднения, но это нормально.\n" +
                "<b>Есть куда стремиться</b>: Это отличный результат, но всегда есть возможность узнать больше и расширить свои знания."
        }
        else if (trueAnswersCountInt >= (answersCountInt - 4)) {
            text = "<b>Средний уровень</b>: Ваши знания о флагах субъектов РФ находятся на среднем уровне.\n" +
                    "<b>Основы знакомы</b>: Вы, вероятно, узнаете самые известные флаги, но с более сложными можете испытывать трудности.\n" +
                    "<b>Есть потенциал</b>: У вас есть хорошая основа, чтобы улучшить свои знания, немного больше практики и изучения, и вы сможете достичь большего."
        }
        else if (trueAnswersCountInt >= (answersCountInt - 6)) {
            text = "<b>Начальный уровень</b>: Ваши знания о флагах субъектов РФ пока находятся на начальном уровне.\n" +
                    "<b>Некоторые знакомы</b>: Возможно, вы узнаете некоторые флаги, но многие остаются для вас незнакомыми.\n" +
                    "<b>Есть над чем работать</b>: Это отличная возможность начать изучать флаги регионов, узнать их историю и символику."
        }
        else {
            text = "<b>Нужно больше знаний</b>: Ваши знания о флагах субъектов РФ требуют дополнительного изучения.\n" +
                    "<b>Не беда</b>: Не расстраивайтесь, это всего лишь повод начать увлекательное путешествие в мир символики регионов России.\n" +
                    "<b>Всё в ваших руках</b>: Используйте различные ресурсы, чтобы изучить флаги, и со временем вы сможете значительно улучшить свой результат."
        }
        try {
            resultText.text = Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
        } catch (e: Exception) {
            resultText.text = "Ошибка отображения вывода."
            e.printStackTrace()
        }
    }
}
