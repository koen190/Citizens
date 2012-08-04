package net.citizensnpcs.questers.quests.types;

import net.citizensnpcs.questers.QuestUtils;
import net.citizensnpcs.questers.quests.progress.ObjectiveProgress;
import net.citizensnpcs.questers.quests.progress.QuestUpdater;
import net.citizensnpcs.utils.StringUtils;

import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;

public class DestroyQuest implements QuestUpdater {
    @Override
    public Class<? extends Event>[] getEventTypes() {
        return EVENTS;
    }

    @Override
    public String getStatus(ObjectiveProgress progress) {
        return QuestUtils.defaultAmountProgress(progress, StringUtils.formatter(progress.getObjective().getMaterial())
                .wrap().plural(progress.getAmount())
                + " destroyed");
    }

    @Override
    public boolean update(Event event, ObjectiveProgress progress) {
        if (event instanceof BlockBreakEvent) {
            BlockBreakEvent ev = (BlockBreakEvent) event;
            if (ev.getBlock().getType() == progress.getObjective().getMaterial()) {
                progress.addAmount(1);
            }
        }
        return progress.getAmount() >= progress.getObjective().getAmount();
    }

    private static final Class<? extends Event>[] EVENTS = new Class[] { BlockBreakEvent.class };
}