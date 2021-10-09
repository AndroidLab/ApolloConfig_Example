package com.alab.common

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.AnyAdapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import java.lang.RuntimeException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Адаптер для преобразования Any в Date.
 */
val dateTimeAdapter = object : Adapter<Date> {
    override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters): Date {
        val source = reader.nextString()
        val date: Date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'", Locale.getDefault())
            .parse(source) ?: throw RuntimeException("Не удалось распарсить строку '${source}' в дату")
        return date
    }

    override fun toJson(writer: JsonWriter, customScalarAdapters: CustomScalarAdapters, value: Date) {
        AnyAdapter.toJson(writer, value)
    }
}