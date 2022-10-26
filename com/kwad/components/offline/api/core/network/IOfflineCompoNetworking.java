package com.kwad.components.offline.api.core.network;

import com.kwad.sdk.core.network.c;
/* loaded from: classes7.dex */
public interface IOfflineCompoNetworking {
    void cancel();

    IOfflineCompoRequest createRequest();

    boolean enableMonitorReport();

    boolean isPostByJson();

    void onResponse(IOfflineCompoRequest iOfflineCompoRequest, c cVar);

    void request(IOfflineCompoRequestListener iOfflineCompoRequestListener);
}
