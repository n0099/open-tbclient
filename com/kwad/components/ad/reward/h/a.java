package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class a implements com.kwad.sdk.core.webview.kwai.a {
    public InterfaceC0568a tJ;

    /* renamed from: com.kwad.components.ad.reward.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0568a {
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
