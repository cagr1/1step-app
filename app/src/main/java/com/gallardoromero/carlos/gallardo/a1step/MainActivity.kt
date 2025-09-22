package com.gallardoromero.carlos.gallardo.a1step

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.gallardoromero.carlos.gallardo.a1step.data.AppDatabase
import com.gallardoromero.carlos.gallardo.a1step.models.Habit
import com.gallardoromero.carlos.gallardo.a1step.ui.theme._1StepTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gallardoromero.carlos.gallardo.a1step.ui.HabitAdapter

class MainActivity : ComponentActivity() {
   private lateinit var db: AppDatabase
    private lateinit var adapter: HabitAdapter
    private lateinit var rvHabits: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        rvHabits = findViewById(R.id.rvHabits)
        rvHabits.layoutManager = LinearLayoutManager(this)

        adapter = HabitAdapter(listOf()) { habit ->
            Toast.makeText(this,"HELP Clicked: ${habit.name}", Toast.LENGTH_SHORT).show()

        }

        rvHabits.adapter = adapter

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "1step-db"
        ).build()

        GlobalScope.launch {
            val habit = Habit(name = "Hacer ejercicio 10 min")
            db.habitDao().insertHabit(habit)

            val allHabits = db.habitDao().getAllHabits()
            Log.d("DB_TEST","Habits en DB: $allHabits")
        }

        val btnAddHabit = findViewById<Button>(R.id.btnAddHabit)

        btnAddHabit.setOnClickListener{
            Toast.makeText(this,"Aqui",Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _1StepTheme {
        Greeting("Android")
    }
}