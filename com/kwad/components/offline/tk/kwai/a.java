package com.kwad.components.offline.tk.kwai;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.core.webview.kwai.e;
import com.kwad.sdk.core.webview.kwai.f;
/* loaded from: classes10.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.c {
    public final IOfflineCompoCallBackFunction Qn;

    public a(IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.Qn = iOfflineCompoCallBackFunction;
    }

    @Override // com.kwad.sdk.core.webview.kwai.c
    public final void a(com.kwad.sdk.core.b bVar) {
        String jSONObject = new f(bVar).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.Qn;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onSuccess(jSONObject);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.c
    public final void onError(int i, String str) {
        String jSONObject = new e(i, str).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.Qn;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onError(jSONObject);
        }
    }
}
