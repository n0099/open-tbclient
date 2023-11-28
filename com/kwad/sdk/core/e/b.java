package com.kwad.sdk.core.e;

import android.util.Log;
/* loaded from: classes10.dex */
public final class b implements com.kwad.sdk.core.e.a.a {
    @Override // com.kwad.sdk.core.e.a.a
    public final void d(String str, String str2) {
        if (c.atd && a.mc.booleanValue()) {
            Log.d(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void e(String str, String str2) {
        if (c.atd) {
            Log.e(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void i(String str, String str2) {
        if (c.atd) {
            Log.i(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2) {
        if (c.atd && a.mc.booleanValue()) {
            Log.v(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2) {
        if (c.atd) {
            Log.w(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void printStackTraceOnly(Throwable th) {
        if (c.atd && a.mc.booleanValue() && th != null) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2, boolean z) {
        Log.v(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2, boolean z) {
        if (z) {
            Log.w(str, str2);
        }
    }
}
