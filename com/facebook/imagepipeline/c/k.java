package com.facebook.imagepipeline.c;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class k implements com.facebook.common.internal.i<u> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cEq */
    public u get() {
        int cEr = cEr();
        return new u(cEr, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, cEr, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, cEr / 8);
    }

    private int cEr() {
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
