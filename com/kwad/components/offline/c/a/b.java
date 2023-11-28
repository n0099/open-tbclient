package com.kwad.components.offline.c.a;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.utils.ap;
/* loaded from: classes10.dex */
public final class b implements IOfflineCompoBridgeHandler {
    public final com.kwad.sdk.core.webview.c.a acV;

    public b(com.kwad.sdk.core.webview.c.a aVar) {
        ap.checkNotNull(aVar);
        this.acV = aVar;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    @NonNull
    public final String getKey() {
        return this.acV.getKey();
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    public final void onDestroy() {
        this.acV.onDestroy();
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    public final void handleJsCall(String str, @NonNull IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.acV.a(str, new a(iOfflineCompoCallBackFunction));
    }
}
