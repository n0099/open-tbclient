package com.bytedance.tea.crash.g;

import android.util.Log;
/* loaded from: classes6.dex */
public final class j {
    public static void a(String str) {
        if (com.bytedance.tea.crash.h.ery().d()) {
            Log.i("npth", str);
        }
    }

    public static void a(Throwable th) {
        if (com.bytedance.tea.crash.h.ery().d()) {
            Log.e("npth", "NPTH Catch Error", th);
        }
    }

    public static void b(Throwable th) {
        if (com.bytedance.tea.crash.h.ery().d()) {
            Log.w("npth", "NPTH Catch Error", th);
        }
    }
}
