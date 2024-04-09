package es.estech.rickmortysimple.data

import es.estech.rickmortysimple.data.retrofit.RetrofitHelper


/**
 * Created by sergi on 19/04/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

class Repositorio {

    private val retrofit = RetrofitHelper.retrofitService

    suspend fun dameTodosPersonajes() = retrofit.damePersonajes()
}