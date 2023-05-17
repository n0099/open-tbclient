package com.kwad.components.core.webview.b.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes9.dex */
public final class c implements com.kwad.sdk.core.webview.kwai.a {
    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        SdkConfigData rZ = com.kwad.sdk.core.config.d.rZ();
        if (rZ != null) {
            cVar.a(rZ);
        } else {
            cVar.onError(-1, "no config data");
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "getKsAdConfig";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}
