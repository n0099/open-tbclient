package com.facebook.imagepipeline.c;

import android.app.ActivityManager;
import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes12.dex */
public class i implements com.facebook.common.internal.j<q> {
    private final ActivityManager jBF;

    public i(ActivityManager activityManager) {
        this.jBF = activityManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: cAV */
    public q get() {
        return new q(cAW(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    private int cAW() {
        int min = Math.min(this.jBF.getMemoryClass() * 1048576, Integer.MAX_VALUE);
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
