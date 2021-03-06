package net.citizensnpcs.traders;

import net.citizensnpcs.Economy;
import net.citizensnpcs.utils.MessageUtils;
import net.citizensnpcs.utils.StringUtils;

import org.bukkit.ChatColor;

public class TraderMessageUtils {

	// Formats the price message for an ItemPrice.
	public static String getPriceMessage(ItemPrice price, ChatColor colour) {
		return StringUtils
				.wrap(Economy.format(price.getPrice()), colour);
	}

	// Formats the ItemStack contained in a stockable to a string.
	public static String getStockableMessage(Stockable s, ChatColor colour) {
		return MessageUtils.getStackString(s.getStocking(), colour) + " for "
				+ getPriceMessage(s.getPrice(), colour);
	}
}
