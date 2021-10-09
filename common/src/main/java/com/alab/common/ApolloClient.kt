package com.alab.common

import com.alab.common.type.DateTime
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.http.HttpNetworkTransport
import okhttp3.Interceptor
import okhttp3.OkHttpClient

/**
 * Представляет клиент Apollo.
 */
val apolloClient = ApolloClient(
    networkTransport = HttpNetworkTransport(
        serverUrl = "https://your_url.com/api/graphQl",   //Адресс Вашего Api
        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(Interceptor { chain ->
                val newRequestBuilder = chain.request().newBuilder()
                newRequestBuilder.apply {
                    addHeader(
                        "Authorization",
                        "Bearer <Your Token>"   //Ваш токен
                    )
                    addHeader("Content-Type", "application/json")
                        .build()
                }
                val newRequest = newRequestBuilder.build()
                return@Interceptor chain.proceed(newRequest)
            }).build()
    ) )
    .withCustomScalarAdapter(DateTime.type, dateTimeAdapter)