package com.mobile.crossplatform.util

sealed class APIResponse<T>(val data: T? = null, val message: String? = null){
    class Success<T>(data: T): APIResponse<T>(data)
    class Error<T>(data: T? = null, message: String? = null): APIResponse<T>(data, message)
}