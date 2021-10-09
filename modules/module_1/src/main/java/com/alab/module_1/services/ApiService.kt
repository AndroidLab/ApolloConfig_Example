package com.alab.module_1.services

import com.alab.module_1.GetEmployeeQuery
import com.apollographql.apollo3.ApolloClient

/**
 * Представляет сервис запросов к api.
 * @param apolloClient Apollo client.
 */
class ApiService(
    private val apolloClient: ApolloClient,
) : IApiService {

    override suspend fun getEmployee(id: String): GetEmployeeQuery.Employee? {
        return apolloClient.query(GetEmployeeQuery(id)).data?.employee
    }

}