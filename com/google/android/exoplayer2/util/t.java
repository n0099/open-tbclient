package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.os.Trace;
/* loaded from: classes6.dex */
public final class t {
    public static void beginSection(String str) {
        if (v.SDK_INT >= 18) {
            Qw(str);
        }
    }

    public static void endSection() {
        if (v.SDK_INT >= 18) {
            dzT();
        }
    }

    @TargetApi(18)
    private static void Qw(String str) {
        Trace.beginSection(str);
    }

    @TargetApi(18)
    private static void dzT() {
        Trace.endSection();
    }
}
