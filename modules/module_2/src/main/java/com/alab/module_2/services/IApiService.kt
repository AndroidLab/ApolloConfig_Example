package com.alab.module_2.services

import com.alab.module_2.GetEmployeeQuery


/**
 * Описывает методы запросов к api.
 */
interface IApiService {

    /**
     * Возвращает сотрудника по указанному id.
     * @param id Идентификатор сотрудника.
     */
    suspend fun getEmployee(id: String): GetEmployeeQuery.Employee?

}