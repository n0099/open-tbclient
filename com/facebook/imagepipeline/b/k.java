package com.facebook.imagepipeline.b;

import androidx.appcompat.widget.ActivityChooserView;
/* loaded from: classes5.dex */
public class k implements com.facebook.common.internal.j<q> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: ewM */
    public q get() {
        int ewN = ewN();
        return new q(ewN, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ewN, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ewN / 8);
    }

    private int ewN() {
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
