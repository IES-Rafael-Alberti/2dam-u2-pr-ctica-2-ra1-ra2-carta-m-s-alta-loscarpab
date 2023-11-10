package com.ccormor392.blackjack.classes

import androidx.compose.runtime.rememberCoroutineScope

class Baraja() {
    companion object{
        var listaBaraja = arrayListOf<Carta>()
        init {
            crearBaraja()
        }
        fun crearBaraja(){
            listaBaraja.clear()
            for (paloIterator in Palo.values()){
                for (numeroIterator in Naipe.values()){
                    val carta = Carta(paloIterator, numeroIterator)
                    listaBaraja.add(carta)
                }
            }
            barajar()
        }
        fun barajar(){
            listaBaraja.shuffle()
        }
        fun dameCarta():Carta{
            val ultimo = listaBaraja.last()
            listaBaraja.remove(ultimo)
            return ultimo
        }
    }
}