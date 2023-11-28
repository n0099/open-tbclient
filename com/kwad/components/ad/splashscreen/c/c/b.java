package com.kwad.components.ad.splashscreen.c.c;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.webview.tachikoma.i;
/* loaded from: classes10.dex */
public final class b extends i {
    public b(Context context, int i, int i2) {
        super(context, i, i2);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void f(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(com.kwad.sdk.core.response.b.b.dq(sz()))) {
            com.kwad.components.ad.splashscreen.monitor.b.kO().c(sz(), str2);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void g(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(com.kwad.sdk.core.response.b.b.dq(sz()))) {
            com.kwad.components.ad.splashscreen.monitor.b.kO().d(sz(), str2);
        }
    }
}
