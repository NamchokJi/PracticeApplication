package com.namchok.practiceapplication.datasource

import com.google.gson.Gson
import com.namchok.practiceapplication.model.ErrorResponseModel
import com.namchok.practiceapplication.model.ResultService
import kotlinx.coroutines.Deferred
import retrofit2.Response

abstract class BaseDataSource {
    protected suspend fun <T> getResult(deferred: Deferred<Response<T>>): ResultService<T> {
        try {

            val response = deferred.await()

            if (response.code() == 200) {
                response.body()
                return ResultService.success(response.body())
            } else {

                val jsonString = response.errorBody()?.charStream()
                val data = Gson().fromJson(jsonString, ErrorResponseModel::class.java)
                return ResultService.error(data.message)
            }
        } catch (e: Exception) {
            return ResultService.error(e.message)
        }
    }
}