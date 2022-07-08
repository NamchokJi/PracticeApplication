package com.namchok.practiceapplication.model

data class ResultService<T>(val isSuccess: Boolean, val message: String?, val data: T?) {
    companion object {
        fun <T> success(data: T?): ResultService<T> = ResultService(true, null, data)
        fun <T> error(message: String?): ResultService<T> = ResultService(false, message, null)
    }
}