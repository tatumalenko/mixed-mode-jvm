package main

import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.builtins.list
import kotlinx.serialization.csv.Csv
import kotlinx.serialization.csv.CsvConfiguration
import kotlinx.serialization.serializer

class Decoder(
    configuration: CsvConfiguration
) {
    val csv = Csv(configuration)

    @ImplicitReflectionSerializer
    inline fun <reified T : Any> decode(input: String): List<T> {
        val sanitized = input.trimIndent().replace("\n", "\r\n")
        return csv.parse(T::class.serializer().list, sanitized)
    }
}
