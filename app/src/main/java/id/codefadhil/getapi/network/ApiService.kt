package id.codefadhil.getapi.network

import id.codefadhil.getapi.data.Agents
import id.codefadhil.getapi.data.DataItem
import id.codefadhil.getapi.data.Weapon
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("agents")
    fun getAllAgents() : Call<Agents>

    @GET("weapons")
    fun getAllWeapon() : Call<Weapon>
}