package com.facebook.imagepipeline.b;

import android.app.ActivityManager;
import android.os.Build;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class i implements com.facebook.common.internal.j<q> {
    private final ActivityManager dRh;

    public i(ActivityManager activityManager) {
        this.dRh = activityManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: exo */
    public q get() {
        return new q(exp(), 256, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    private int exp() {
        int min = Math.min(this.dRh.getMemoryClass() * 1048576, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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
