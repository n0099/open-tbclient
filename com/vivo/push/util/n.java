package com.vivo.push.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;
/* loaded from: classes3.dex */
public final class n implements o {
    private static final String a = "(" + Process.myPid() + ")";

    @Override // com.vivo.push.util.o
    public final int a(String str, String str2) {
        return Log.e("VivoPush." + str, a + str2);
    }

    @Override // com.vivo.push.util.o
    public final int a(String str, Throwable th) {
        return Log.e("VivoPush." + str, Log.getStackTraceString(th));
    }

    @Override // com.vivo.push.util.o
    public final int a(String str, String str2, Throwable th) {
        return Log.e("VivoPush." + str, a + str2, th);
    }

    @Override // com.vivo.push.util.o
    public final int b(String str, String str2) {
        return Log.w("VivoPush." + str, a + str2);
    }

    @Override // com.vivo.push.util.o
    public final int c(String str, String str2) {
        return Log.d("VivoPush." + str, a + str2);
    }

    @Override // com.vivo.push.util.o
    public final int d(String str, String str2) {
        if (p.a()) {
            return Log.i("VivoPush." + str, a + str2);
        }
        return -1;
    }

    @Override // com.vivo.push.util.o
    public final int b(String str, String str2, Throwable th) {
        if (p.a()) {
            return Log.i("VivoPush." + str, a + str2, th);
        }
        return -1;
    }

    @Override // com.vivo.push.util.o
    public final int e(String str, String str2) {
        if (p.a()) {
            return Log.v("VivoPush." + str, a + str2);
        }
        return -1;
    }

    @Override // com.vivo.push.util.o
    public final String a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    @Override // com.vivo.push.util.o
    public final void a(Context context, String str) {
        if (p.a()) {
            a(context, str, 0);
        }
    }

    @Override // com.vivo.push.util.o
    public final void b(Context context, String str) {
        if (p.a()) {
            a(context, str, 1);
        }
    }

    @Override // com.vivo.push.util.o
    public final void c(Context context, String str) {
        if (p.a()) {
            a(context, str, 2);
        }
    }

    private void a(Context context, String str, int i) {
        com.vivo.push.b.p pVar = new com.vivo.push.b.p();
        pVar.b(str);
        pVar.a(i);
        if (i > 0) {
            d("LogController", str);
        }
        if (z.a(context)) {
            pVar.a(true);
            for (String str2 : s.c(context)) {
                a(context, pVar, str2);
            }
            return;
        }
        pVar.a(false);
        a(context, pVar, context.getPackageName());
    }

    private static void a(Context context, com.vivo.push.b.p pVar, String str) {
        if (str.contains("test") || str.equals(s.b(context))) {
            com.vivo.push.a.a.a(context, pVar, str);
        }
    }
}
