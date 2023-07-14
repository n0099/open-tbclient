package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public class a implements com.kwad.sdk.core.webview.kwai.a {
    public InterfaceC0621a tJ;

    /* renamed from: com.kwad.components.ad.reward.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0621a {
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        ie();
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "callButtonImpressionWhenFinish";
    }

    public void ie() {
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.tJ = null;
    }
}
