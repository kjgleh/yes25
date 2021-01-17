package me.kjgleh.yes25.order.command.domain

import me.kjgleh.yes25.common.model.Money
import javax.persistence.Embeddable

@Embeddable
class OrderLine(
    val productId: Long,

    @Suppress("JpaAttributeTypeInspection")
    val price: Money,

    val quantity: Int,

    @Suppress("JpaAttributeTypeInspection")
    val amounts: Money
)