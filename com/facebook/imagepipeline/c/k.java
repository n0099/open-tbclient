package com.facebook.imagepipeline.c;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class k implements com.facebook.common.internal.i<u> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bTI */
    public u get() {
        int bTJ = bTJ();
        return new u(bTJ, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, bTJ, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, bTJ / 8);
    }

    private int bTJ() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            return 1048576;
        }
        if (min < 33554432) {
            return 2097152;
        }
        return 4194304;
    }
}
