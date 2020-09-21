package model

import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.csv.CsvConfiguration
import main.Decoder

@Serializable
data class DiPdoAudience(
    val campaignCategory: String?,
    val institution: String?,
    val transit: String?,
    val account: String?
) {
    @ImplicitReflectionSerializer
    companion object {
        private val decoder = Decoder(CsvConfiguration(hasHeaderRecord = false))

        fun decode(input: String): List<DiPdoAudience> {
            return decoder.decode(input)
        }
    }
}
