package es.estech.rickmortysimple.data.modelos


import com.google.gson.annotations.SerializedName

data class Respuesta(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Personaje>
)