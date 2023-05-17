package com.facebook.imagepipeline.common;

import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public enum Priority {
    LOW,
    MEDIUM,
    HIGH;

    public static Priority getHigherPriority(@Nullable Priority priority, @Nullable Priority priority2) {
        if (priority == null) {
            return priority2;
        }
        if (priority2 == null) {
            return priority;
        }
        if (priority.ordinal() > priority2.ordinal()) {
            return priority;
        }
        return priority2;
    }
}
