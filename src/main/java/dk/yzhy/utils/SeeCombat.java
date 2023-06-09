package dk.yzhy.utils;

import dk.yzhy.Combat;
import dk.yzhy.tasks.CombatSystem;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class SeeCombat {
    public static void seeCombat(Player player, Integer a) {
        if (player.hasMetadata("InCombat")) {
            player.setMetadata("InCombat", new FixedMetadataValue(Combat.getInstance(), a));
        }else {
            player.setMetadata("InCombat", new FixedMetadataValue(Combat.getInstance(), a));
            CombatSystem.combatTag(player);
            if (Boolean.parseBoolean(ConfigLoader.getString("Beskeder.Enabled"))) {
                String m = ConfigLoader.getString("Beskeder.CombatEnable").replaceAll("%tid%", ConfigLoader.getString("Combat.Tid"));
                player.sendMessage(m);
            }
        }
    }
}
