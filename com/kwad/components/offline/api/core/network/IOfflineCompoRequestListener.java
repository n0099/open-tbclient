package com.kwad.components.offline.api.core.network;

import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;
/* loaded from: classes7.dex */
public interface IOfflineCompoRequestListener {
    void onError(IOfflineCompoRequest iOfflineCompoRequest, int i, String str);

    void onStartRequest(IOfflineCompoRequest iOfflineCompoRequest);

    void onSuccess(IOfflineCompoRequest iOfflineCompoRequest, BaseOfflineCompoResultData baseOfflineCompoResultData);
}
