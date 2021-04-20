package com.facebook.common.memory;
/* loaded from: classes5.dex */
public enum MemoryTrimType {
    OnCloseToDalvikHeapLimit(0.5d),
    OnSystemMemoryCriticallyLowWhileAppInForeground(1.0d),
    OnSystemLowMemoryWhileAppInForeground(0.5d),
    OnSystemLowMemoryWhileAppInBackground(1.0d),
    OnAppBackgrounded(1.0d);
    
    public double mSuggestedTrimRatio;

    MemoryTrimType(double d2) {
        this.mSuggestedTrimRatio = d2;
    }

    public double getSuggestedTrimRatio() {
        return this.mSuggestedTrimRatio;
    }
}
