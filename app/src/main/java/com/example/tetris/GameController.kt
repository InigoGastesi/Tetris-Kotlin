package com.example.tetris



class GameController {
    private lateinit var tablero: Array<IntArray>

    fun nuevoTablero(): Array<IntArray> {
        tablero =  Array(16, { IntArray(10) })
        return tablero
    }
}