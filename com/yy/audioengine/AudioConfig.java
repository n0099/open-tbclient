package com.yy.audioengine;
/* loaded from: classes4.dex */
public class AudioConfig {
    private static boolean mIsEnableLowLatencyPlayBack;

    public static void enableLowLatencyPlayBack(boolean z) {
        mIsEnableLowLatencyPlayBack = z;
    }

    public static boolean isEnableLowLatencyPlayBack() {
        return mIsEnableLowLatencyPlayBack;
    }
}
