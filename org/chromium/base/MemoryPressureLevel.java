package org.chromium.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes2.dex */
public @interface MemoryPressureLevel {
    public static final int CRITICAL = 2;
    public static final int MAX_VALUE = 2;
    public static final int MODERATE = 1;
    public static final int NONE = 0;
}
