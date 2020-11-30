package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.csuf.cpsc411.hw2.MainActivity
import java.lang.reflect.Type

//Introduce ctx parameter
class ClaimService (val ctx : MainActivity){

    //var claimList : MutableList<Claim> = mutableListOf()
    //var currentIndx : Int = 0
    var isOnline:Boolean=true
    companion object { //Unwrapping, define claimservice as optional type
        //When you return, the return point is claim service
        private var cService : ClaimService? = null
        fun getInstance(act : MainActivity) : ClaimService {
            if (cService == null) {
                cService = ClaimService(act)
            }
            return cService!! //Unwrapping operation
        }
    }
    inner class addServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            if (responseBody != null) {
                val respStr = String(responseBody)
                Log.d("Claim Service", "Response from addService: ${respStr}")
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            //isOnline = false
            //Log.d("Claim Service", "Failed to connect")
            TODO("Not yet implemented")
        }
    }
    //Creates a claim to add to post.
    fun addClaim(cObj : Claim) {
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.56.1:8080/ClaimService/addClaim"
        // 1. Convert the pObj into JSON string
        val pJsonString= Gson().toJson(cObj)
        // 2. Send the post request
        val entity = StringEntity(pJsonString)

        // cxt is an Android Application Context object
        //Sending the post
        client.post(ctx, requestUrl, entity,"application/json", addServiceRespHandler())
        Log.d("addClaim", "Adding claim")
    }
}