package com.facebook.imagepipeline.c;

import android.app.ActivityManager;
import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class i implements com.facebook.common.internal.i<u> {
    private final ActivityManager kgv;

    public i(ActivityManager activityManager) {
        this.kgv = activityManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cFx */
    public u get() {
        return new u(cFy(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    private int cFy() {
        int min = Math.min(this.kgv.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (min < 33554432) {
            return 4194304;
        }
        if (min < 67108864) {
            return TbConfig.THREAD_GIF_MIN_USE_MEMORY;
        }
        if (Build.VERSION.SDK_INT < 11) {
            return 8388608;
        }
        return min / 4;
    }
}
