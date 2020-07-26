package com.example.tetris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.IntArray as IntArray

abstract class MainActivity : AppCompatActivity() {
    
    private val gameController = GameController()
    private lateinit var tablero: Array<IntArray>
    private var gameOver = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarPartida()
        inicializarFicha()
        dibujarFicha()
        println(Arrays.deepToString(tablero))

    }
    
    private fun inicializarPartida(){
        tablero = gameController.nuevoTablero()
        gameOver = false
    }

    private fun inicializarFicha(){
        var pieza = Cuadrado()
        var ficha = pieza.forma
        sum(tablero, ficha, pieza)

    }


    private fun dibujarFicha(){
        /*for(i in 0 until tableroLayout.childCount){
            val fila = tableroLayout[i] as LinearLayout
            for(j in 0 until fila.childCount){
                val ficha = fila[j] as ImageView
            }
        }*/
        for(i in 0..15){
            for(j in 0..9){
                val fila = tableroLayout[i] as LinearLayout
                val ficha = fila[j] as ImageView
                if(tablero[i][j]==1){
                    ficha.setImageDrawable(getDrawable(R.drawable.block))
                }
                else{
                    ficha.setImageDrawable(getDrawable(R.drawable.background))
                }
            }
        }
    }

    private fun sum(tablero: Array<IntArray>, ficha: Array<IntArray>, pieza: Cuadrado){


        for(i:Int in 0 until ficha.size){
            for(j:Int in 0 until ficha[i].size){
                tablero[i+pieza.posY][j+pieza.posX] = ficha[i][j] + tablero[i+pieza.posY][j+pieza.posX]
            }
        }
    }
    
}

