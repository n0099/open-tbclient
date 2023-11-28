package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.c;
/* loaded from: classes10.dex */
public class NormalResultDataAdapter<T extends NormalOfflineCompoResultData> extends NormalResultData {
    public final T mOfflineCompoResultData;

    public NormalResultDataAdapter(T t) {
        this.mOfflineCompoResultData = t;
    }

    @Override // com.kwad.sdk.core.network.NormalResultData
    public void parseResponse(c cVar) {
        super.parseResponse(cVar);
        this.mOfflineCompoResultData.parseResponse(cVar);
    }

    public T getOfflineCompoResultData() {
        return this.mOfflineCompoResultData;
    }
}
