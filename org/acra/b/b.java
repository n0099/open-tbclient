package org.acra.b;

import android.util.Log;
/* loaded from: classes.dex */
public final class b implements a {
    @Override // org.acra.b.a
    public int a(String str, String str2) {
        return Log.d(str, str2);
    }

    @Override // org.acra.b.a
    public int b(String str, String str2) {
        return Log.w(str, str2);
    }

    @Override // org.acra.b.a
    public int a(String str, String str2, Throwable th) {
        return Log.w(str, str2, th);
    }

    @Override // org.acra.b.a
    public int c(String str, String str2) {
        return Log.e(str, str2);
    }
}
