package com.namchok.practiceapplication.model

import com.google.gson.annotations.SerializedName

data class ErrorResponseModel(
    @SerializedName("statusCode")
    var statusCode: String? = "",
    @SerializedName("message")
    var message: String = ""

)