package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class x implements com.kwad.sdk.core.webview.kwai.a {
    public com.kwad.sdk.core.webview.kwai.c a;

    /* loaded from: classes4.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int a;

        public a(int i2) {
            this.a = i2;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "rewardTaskStatus";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.a = cVar;
    }

    public void a(boolean z) {
        if (this.a != null) {
            this.a.a(new a(z ? 1 : 0));
            return;
        }
        com.kwad.sdk.core.d.a.a("WebCardRewardTaskStatusHandler", "notifyTaskStatus , status:" + (z ? 1 : 0));
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
    }
}
