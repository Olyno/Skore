package me.limeglass.skore.elements.effects;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import io.puharesource.mc.titlemanager.api.v2.TitleManagerAPI;
import me.limeglass.skore.Skore;
import me.limeglass.skore.lang.SkoreEffect;
import me.limeglass.skore.utils.annotations.Patterns;

@Name("Skoreboard - Setup")
@Description("Setup the Skoreboard for the player, tells the system their skoreboard.")
@Examples("setup skoreboard of player")
@Patterns("(1�(create|set[up])|2�(remove|reset|delete)) title[ ]manager default scoreboard (for|to|of) %players%")
public class EffSetupDefaultSkoreboard extends SkoreEffect {

	private TitleManagerAPI api = Skore.getTitleManagerAPI();

	@Override
	protected void execute(Event event) {
		if (areNull(event)) return;
		switch (patternMark) {
			case 1:
				for (Player player : expressions.getAll(event, Player.class)) {
					api.giveDefaultScoreboard(player);
				}
				break;
			case 2:
				for (Player player : expressions.getAll(event, Player.class)) {
					api.removeScoreboard(player);
				}
				break;
		}
	}

}
