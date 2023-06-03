package org.chromium.base.metrics;

import org.chromium.base.annotations.JNINamespace;
@JNINamespace("base::android")
/* loaded from: classes2.dex */
public final class StatisticsRecorderAndroid {

    /* loaded from: classes2.dex */
    public interface Natives {
        String toJson(int i);
    }

    public static String toJson(int i) {
        return StatisticsRecorderAndroidJni.get().toJson(i);
    }
}
