package com.kwad.components.offline.api.tk.jsbridge;
/* loaded from: classes7.dex */
public interface IOfflineCompoBridgeHandler {
    String getKey();

    void handleJsCall(String str, IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction);

    void onDestroy();
}
