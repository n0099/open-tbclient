package com.kwad.sdk.core.e;

import android.util.Log;
/* loaded from: classes9.dex */
public final class a implements com.kwad.sdk.core.e.kwai.a {
    @Override // com.kwad.sdk.core.e.kwai.a
    public final void d(String str, String str2) {
        if (b.XL && com.kwad.kwai.kwai.a.aw.booleanValue()) {
            Log.d(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void e(String str, String str2) {
        if (b.XL) {
            Log.e(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void i(String str, String str2) {
        if (b.XL) {
            Log.i(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void printStackTraceOnly(Throwable th) {
        if (b.XL && com.kwad.kwai.kwai.a.aw.booleanValue() && th != null) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void v(String str, String str2) {
        if (b.XL && com.kwad.kwai.kwai.a.aw.booleanValue()) {
            Log.v(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void v(String str, String str2, boolean z) {
        Log.v(str, str2);
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void w(String str, String str2) {
        if (b.XL) {
            Log.w(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void w(String str, String str2, boolean z) {
        if (z) {
            Log.w(str, str2);
        }
    }
}
