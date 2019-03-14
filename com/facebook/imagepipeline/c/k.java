package com.facebook.imagepipeline.c;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class k implements com.facebook.common.internal.i<u> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cwA */
    public u get() {
        int cwB = cwB();
        return new u(cwB, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, cwB, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, cwB / 8);
    }

    private int cwB() {
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
