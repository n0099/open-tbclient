package com.kwad.components.offline.b;

import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
/* loaded from: classes10.dex */
public final class c implements com.kwad.sdk.core.e.a.a {
    public final IObiwanLogcat acE;

    public c(IObiwanLogcat iObiwanLogcat) {
        this.acE = iObiwanLogcat;
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void printStackTraceOnly(Throwable th) {
        this.acE.printStackTraceOnly(th);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void d(String str, String str2) {
        this.acE.d(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void e(String str, String str2) {
        this.acE.e(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void i(String str, String str2) {
        this.acE.i(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2) {
        this.acE.v(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2) {
        this.acE.w(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2, boolean z) {
        this.acE.v(str, str2, true);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2, boolean z) {
        this.acE.w(str, str2, z);
    }
}
