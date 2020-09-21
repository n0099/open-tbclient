package com.facebook.imagepipeline.c;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes25.dex */
public class k implements com.facebook.common.internal.j<q> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dVX */
    public q get() {
        int dVY = dVY();
        return new q(dVY, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, dVY, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, dVY / 8);
    }

    private int dVY() {
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
