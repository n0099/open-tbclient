package org.chromium.base;

import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;
@JNINamespace("base::android")
@MainDex
/* loaded from: classes2.dex */
public class TimeUtils {
    public static final int NANOSECONDS_PER_MILLISECOND = 1000000;
    public static final int SECONDS_PER_DAY = 86400;
    public static final int SECONDS_PER_HOUR = 3600;
    public static final int SECONDS_PER_MINUTE = 60;

    /* loaded from: classes2.dex */
    public interface Natives {
        long getTimeTicksNowUs();
    }
}
