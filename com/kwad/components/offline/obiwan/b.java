package com.kwad.components.offline.obiwan;

import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
/* loaded from: classes10.dex */
public final class b implements com.kwad.sdk.core.e.kwai.a {
    public final IObiwanLogcat Qi;

    public b(IObiwanLogcat iObiwanLogcat) {
        this.Qi = iObiwanLogcat;
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void d(String str, String str2) {
        this.Qi.d(str, str2);
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void e(String str, String str2) {
        this.Qi.e(str, str2);
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void i(String str, String str2) {
        this.Qi.i(str, str2);
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void printStackTraceOnly(Throwable th) {
        this.Qi.printStackTraceOnly(th);
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void v(String str, String str2) {
        this.Qi.v(str, str2);
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void v(String str, String str2, boolean z) {
        this.Qi.v(str, str2, true);
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void w(String str, String str2) {
        this.Qi.w(str, str2);
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void w(String str, String str2, boolean z) {
        this.Qi.w(str, str2, z);
    }
}
