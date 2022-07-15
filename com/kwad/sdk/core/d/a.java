package com.kwad.sdk.core.d;

import android.util.Log;
/* loaded from: classes5.dex */
public final class a implements com.kwad.sdk.core.d.kwai.a {
    @Override // com.kwad.sdk.core.d.kwai.a
    public final void a(String str, String str2) {
        if (b.a && com.kwad.kwai.kwai.a.a.booleanValue()) {
            Log.v(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void a(String str, String str2, boolean z) {
        Log.v(str, str2);
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void a(Throwable th) {
        if (b.a && com.kwad.kwai.kwai.a.a.booleanValue() && th != null) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void b(String str, String str2) {
        if (b.a && com.kwad.kwai.kwai.a.a.booleanValue()) {
            Log.d(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void b(String str, String str2, boolean z) {
        if (z) {
            Log.w(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void c(String str, String str2) {
        if (b.a) {
            Log.i(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void d(String str, String str2) {
        if (b.a) {
            Log.w(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void e(String str, String str2) {
        if (b.a) {
            Log.e(str, str2);
        }
    }
}
