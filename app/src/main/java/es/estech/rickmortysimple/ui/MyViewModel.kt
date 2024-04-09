package es.estech.rickmortysimple.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.estech.rickmortysimple.data.Repositorio
import es.estech.rickmortysimple.data.modelos.Personaje
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val listData: MutableLiveData<ArrayList<Personaje>> = MutableLiveData()
    private val selectedCharacter = MutableLiveData<Personaje>()
    private val repositorio = Repositorio()

    fun getData() = listData

    fun loadData() {
        viewModelScope.launch{
            val response = repositorio.dameTodosPersonajes()

            if (response.isSuccessful) {
                val code = response.code()
                if (code == 200) {
                    val respuesta = response.body()
                    respuesta?.let {
                        listData.postValue(it.results as ArrayList<Personaje>?)
                    }
                }
            }
        }
    }

    fun setPersonaje(personaje: Personaje) {
        selectedCharacter.value = personaje
    }

    fun getPersonaje() = selectedCharacter

}