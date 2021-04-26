package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;
/* loaded from: classes6.dex */
public class TimeSource {
    public static final TimeSource SYSTEM_TIME_SOURCE = new TimeSource(null, null);
    @Nullable
    public final Long fixedTimeMs;
    @Nullable
    public final TimeZone fixedTimeZone;

    public TimeSource(@Nullable Long l, @Nullable TimeZone timeZone) {
        this.fixedTimeMs = l;
        this.fixedTimeZone = timeZone;
    }

    public static TimeSource fixed(long j, @Nullable TimeZone timeZone) {
        return new TimeSource(Long.valueOf(j), timeZone);
    }

    public static TimeSource system() {
        return SYSTEM_TIME_SOURCE;
    }

    public Calendar now() {
        return now(this.fixedTimeZone);
    }

    public static TimeSource fixed(long j) {
        return new TimeSource(Long.valueOf(j), null);
    }

    public Calendar now(@Nullable TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.fixedTimeMs;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        return calendar;
    }
}
