package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;
/* loaded from: classes10.dex */
public final class f implements IOfflineCompoTKBridgeHandler {
    public final com.kwad.sdk.core.webview.c.g adc;

    public f(com.kwad.sdk.core.webview.c.g gVar) {
        this.adc = gVar;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler
    public final void callTKBridge(String str) {
        com.kwad.sdk.core.webview.c.g gVar = this.adc;
        if (gVar != null) {
            gVar.callTKBridge(str);
        }
    }
}
