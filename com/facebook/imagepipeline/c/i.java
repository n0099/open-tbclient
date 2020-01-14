package com.facebook.imagepipeline.c;

import android.app.ActivityManager;
import android.os.Build;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes10.dex */
public class i implements com.facebook.common.internal.j<q> {
    private final ActivityManager jAN;

    public i(ActivityManager activityManager) {
        this.jAN = activityManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: czy */
    public q get() {
        return new q(czz(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    private int czz() {
        int min = Math.min(this.jAN.getMemoryClass() * 1048576, Integer.MAX_VALUE);
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
