package my.study.advanced;

public enum DaysOfTheWeekFields {
    MONDAY(false), SUNDAY(true);

    private final boolean isWeekend;

    private DaysOfTheWeekFields(final boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public boolean isWeekend() {
        return isWeekend;
    }
}
