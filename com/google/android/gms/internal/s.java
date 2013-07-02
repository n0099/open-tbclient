package com.google.android.gms.internal;

import android.util.Log;
/* loaded from: classes.dex */
public final class s {
    private final String a;

    public s(String str) {
        this.a = (String) x.a(str);
    }

    public void a(String str, String str2) {
        if (a(3)) {
            Log.d(str, str2);
        }
    }

    public void a(String str, String str2, Throwable th) {
        if (a(6)) {
            Log.e(str, str2, th);
        }
    }

    public boolean a(int i) {
        return Log.isLoggable(this.a, i);
    }

    public void b(String str, String str2) {
        if (a(5)) {
            Log.w(str, str2);
        }
    }
}
