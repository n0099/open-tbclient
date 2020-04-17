package com.facebook.imagepipeline.c;

import com.facebook.common.memory.MemoryTrimType;
import com.facebook.imagepipeline.c.h;
/* loaded from: classes12.dex */
public class s implements h.a {
    @Override // com.facebook.imagepipeline.c.h.a
    public double b(MemoryTrimType memoryTrimType) {
        switch (memoryTrimType) {
            case OnCloseToDalvikHeapLimit:
                return 0.0d;
            case OnAppBackgrounded:
            case OnSystemLowMemoryWhileAppInForeground:
            case OnSystemLowMemoryWhileAppInBackground:
                return 1.0d;
            default:
                com.facebook.common.c.a.l("NativeMemoryCacheTrimStrategy", "unknown trim type: %s", memoryTrimType);
                return 0.0d;
        }
    }
}
