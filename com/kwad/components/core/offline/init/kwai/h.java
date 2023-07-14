package com.kwad.components.core.offline.init.kwai;

import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
/* loaded from: classes10.dex */
public final class h implements IOfflineCompoLogcat {
    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void d(String str, String str2) {
        com.kwad.sdk.core.e.b.d(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void e(String str, String str2) {
        com.kwad.sdk.core.e.b.e(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void e(String str, String str2, Throwable th) {
        com.kwad.sdk.core.e.b.e(str, str2, th);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void i(String str, String str2) {
        com.kwad.sdk.core.e.b.i(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoLogcat
    public final boolean isLoggable() {
        return com.kwad.sdk.core.e.b.XL;
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void printStackTrace(Throwable th) {
        com.kwad.sdk.core.e.b.printStackTrace(th);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void printStackTraceOnly(Throwable th) {
        com.kwad.sdk.core.e.b.printStackTraceOnly(th);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void v(String str, String str2) {
        com.kwad.sdk.core.e.b.v(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void v(String str, String str2, boolean z) {
        if (!z) {
            com.kwad.sdk.core.e.b.v(str, str2);
            return;
        }
        com.kwad.sdk.core.e.b.bT(str + " " + str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void w(String str, String str2) {
        com.kwad.sdk.core.e.b.w(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void w(String str, String str2, boolean z) {
        if (z || com.kwad.components.core.a.aw.booleanValue()) {
            com.kwad.sdk.core.e.b.w(str, str2);
        }
    }
}
