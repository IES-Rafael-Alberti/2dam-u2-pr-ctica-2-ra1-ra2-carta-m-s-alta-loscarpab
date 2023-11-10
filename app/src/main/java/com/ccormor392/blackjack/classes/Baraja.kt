package com.ccormor392.blackjack.classes


class Baraja {
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
        private fun barajar(){
            listaBaraja.shuffle()
        }
        fun dameCarta():Carta?{
            if (listaBaraja.size > 0) {
                val ultimo = listaBaraja.last()
                listaBaraja.remove(ultimo)
                return ultimo
            }
            return null
        }
    }
}