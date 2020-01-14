package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.os.Trace;
/* loaded from: classes5.dex */
public final class t {
    public static void beginSection(String str) {
        if (v.SDK_INT >= 18) {
            Qj(str);
        }
    }

    public static void endSection() {
        if (v.SDK_INT >= 18) {
            dyH();
        }
    }

    @TargetApi(18)
    private static void Qj(String str) {
        Trace.beginSection(str);
    }

    @TargetApi(18)
    private static void dyH() {
        Trace.endSection();
    }
}
