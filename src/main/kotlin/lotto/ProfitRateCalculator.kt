package lotto

class ProfitRateCalculator {
    fun calculateProfitRate(results: Map<LottoMatchType, Int>, purchaseAmount: Int): Double {
        val totalReward = calculateTotalReward(results)
        val profitRate = totalReward / purchaseAmount.toDouble() * 100
        return roundToTwoDecimalPlaces(profitRate)
    }

    private fun calculateTotalReward(results: Map<LottoMatchType, Int>): Int {
        return results.entries.sumOf { (matchType, count) ->
            parseRewardToInt(matchType.reward) * count
        }
    }

    private fun parseRewardToInt(reward: String): Int {
        return reward.replace(",", "").toInt()
    }

    private fun roundToTwoDecimalPlaces(value: Double): Double {
        return kotlin.math.round(value * 100) / 100
    }
}