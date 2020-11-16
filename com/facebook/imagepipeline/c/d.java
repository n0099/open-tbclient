package com.facebook.imagepipeline.c;

import android.os.Build;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.imagepipeline.c.h;
/* loaded from: classes17.dex */
public class d implements h.a {
    @Override // com.facebook.imagepipeline.c.h.a
    public double b(MemoryTrimType memoryTrimType) {
        switch (memoryTrimType) {
            case OnCloseToDalvikHeapLimit:
                if (Build.VERSION.SDK_INT >= 21) {
                    return MemoryTrimType.OnCloseToDalvikHeapLimit.getSuggestedTrimRatio();
                }
                return 0.0d;
            case OnAppBackgrounded:
            case OnSystemLowMemoryWhileAppInForeground:
            case OnSystemLowMemoryWhileAppInBackground:
                return 1.0d;
            default:
                com.facebook.common.c.a.k("BitmapMemoryCacheTrimStrategy", "unknown trim type: %s", memoryTrimType);
                return 0.0d;
        }
    }
}
