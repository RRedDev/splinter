package me.rred.splinter.client.sets;

import me.rred.splinter.Splinter;

import java.util.ArrayList;
import java.util.List;

public class SplinterSet {
    private String name;
    private List<Long> times = new ArrayList<>(); // for now, data will just be non-persistent
    private final boolean isGeneral;

    public SplinterSet(String name, boolean isGeneral) {
        this.name = name;
        this.isGeneral = isGeneral;
    }

    public void addTime(long ms) {
        times.add(ms);
        Splinter.LOGGER.info("time added to set '{}': {}ms, total runs: {}", name, ms, times.size());
    }

    public void removeTime(int idx) {
        if (idx < 0 || idx > times.size() - 1) {
            return;
        }
        times.remove((int) idx);
    }

    public List<Long> getTimes() {
        return times;
    }

    public long getAverage() {
        return (long) times.stream().mapToLong(Long::longValue).average().orElse(0);
    }

    public long getBest() {
        return (long) times.stream().mapToLong(Long::longValue).min().orElse(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public boolean isGeneral() {
        return isGeneral;
    }

}
