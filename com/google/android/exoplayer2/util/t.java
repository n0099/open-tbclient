package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.os.Trace;
/* loaded from: classes4.dex */
public final class t {
    public static void beginSection(String str) {
        if (v.SDK_INT >= 18) {
            PY(str);
        }
    }

    public static void endSection() {
        if (v.SDK_INT >= 18) {
            dxv();
        }
    }

    @TargetApi(18)
    private static void PY(String str) {
        Trace.beginSection(str);
    }

    @TargetApi(18)
    private static void dxv() {
        Trace.endSection();
    }
}
