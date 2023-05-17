package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.os.Trace;
/* loaded from: classes9.dex */
public final class TraceUtil {
    public static void endSection() {
        if (Util.SDK_INT >= 18) {
            endSectionV18();
        }
    }

    @TargetApi(18)
    public static void endSectionV18() {
        Trace.endSection();
    }

    public static void beginSection(String str) {
        if (Util.SDK_INT >= 18) {
            beginSectionV18(str);
        }
    }

    @TargetApi(18)
    public static void beginSectionV18(String str) {
        Trace.beginSection(str);
    }
}
