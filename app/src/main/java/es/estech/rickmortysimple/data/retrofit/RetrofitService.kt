package es.estech.rickmortysimple.data.retrofit

import es.estech.rickmortysimple.data.modelos.Respuesta
import retrofit2.Response
import retrofit2.http.*


/**
 * Created by sergi on 19/04/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

interface RetrofitService {

    @GET("character")
    suspend fun damePersonajes(): Response<Respuesta>

}