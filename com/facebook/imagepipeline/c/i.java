package com.facebook.imagepipeline.c;

import android.app.ActivityManager;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes18.dex */
public class i implements com.facebook.common.internal.j<q> {
    private final ActivityManager dDl;

    public i(ActivityManager activityManager) {
        this.dDl = activityManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: enw */
    public q get() {
        return new q(enx(), 256, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    private int enx() {
        int min = Math.min(this.dDl.getMemoryClass() * 1048576, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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
