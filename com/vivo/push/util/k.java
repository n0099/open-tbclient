package com.vivo.push.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;
/* loaded from: classes3.dex */
public final class k implements l {
    private static final String a = "(" + Process.myPid() + ")";

    @Override // com.vivo.push.util.l
    public final int a(String str, String str2) {
        return Log.e("VivoPush." + str, a + str2);
    }

    @Override // com.vivo.push.util.l
    public final int a(String str, Throwable th) {
        return Log.e("VivoPush." + str, Log.getStackTraceString(th));
    }

    @Override // com.vivo.push.util.l
    public final int a(String str, String str2, Throwable th) {
        return Log.e("VivoPush." + str, a + str2, th);
    }

    @Override // com.vivo.push.util.l
    public final int b(String str, String str2) {
        return Log.w("VivoPush." + str, a + str2);
    }

    @Override // com.vivo.push.util.l
    public final int c(String str, String str2) {
        return Log.d("VivoPush." + str, a + str2);
    }

    @Override // com.vivo.push.util.l
    public final int d(String str, String str2) {
        if (m.a()) {
            return Log.i("VivoPush." + str, a + str2);
        }
        return -1;
    }

    @Override // com.vivo.push.util.l
    public final int b(String str, String str2, Throwable th) {
        if (m.a()) {
            return Log.i("VivoPush." + str, a + str2, th);
        }
        return -1;
    }

    @Override // com.vivo.push.util.l
    public final int e(String str, String str2) {
        if (m.a()) {
            return Log.v("VivoPush." + str, a + str2);
        }
        return -1;
    }

    @Override // com.vivo.push.util.l
    public final String a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    @Override // com.vivo.push.util.l
    public final void a(Context context, String str) {
        if (m.a()) {
            a(context, str, 0);
        }
    }

    @Override // com.vivo.push.util.l
    public final void b(Context context, String str) {
        if (m.a()) {
            a(context, str, 1);
        }
    }

    @Override // com.vivo.push.util.l
    public final void c(Context context, String str) {
        if (m.a()) {
            a(context, str, 2);
        }
    }

    private static void a(Context context, String str, int i) {
        com.vivo.push.b.n nVar = new com.vivo.push.b.n();
        nVar.b(str);
        nVar.a(i);
        if (w.a(context)) {
            nVar.a(true);
            for (String str2 : p.c(context)) {
                a(context, nVar, str2);
            }
            return;
        }
        nVar.a(false);
        a(context, nVar, context.getPackageName());
    }

    private static void a(Context context, com.vivo.push.b.n nVar, String str) {
        if (str.contains("test") || str.equals(p.b(context)) || "com.vivo.hybrid".equals(str)) {
            com.vivo.push.a.a.a(context, nVar, str);
        }
    }
}
