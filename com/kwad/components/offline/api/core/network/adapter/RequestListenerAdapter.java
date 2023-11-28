package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.response.model.BaseResultData;
/* loaded from: classes10.dex */
public class RequestListenerAdapter<R extends IOfflineCompoRequest, T extends CommonOfflineCompoResultData> implements g<RequestAdapter<R>, ResultDataAdapter<T>> {
    public final IOfflineCompoRequestListener<R, T> mRequestListener;

    public RequestListenerAdapter(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mRequestListener = iOfflineCompoRequestListener;
    }

    public void onStartRequest(@NonNull RequestAdapter<R> requestAdapter) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onStartRequest(requestAdapter.getOfflineCompoRequest());
        }
    }

    public void onError(@NonNull RequestAdapter<R> requestAdapter, int i, String str) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onError(requestAdapter.getOfflineCompoRequest(), i, str);
        }
    }

    @Override // com.kwad.sdk.core.network.g
    public /* bridge */ /* synthetic */ void onError(@NonNull f fVar, int i, String str) {
        onError((RequestAdapter) ((RequestAdapter) fVar), i, str);
    }

    @Override // com.kwad.sdk.core.network.g
    public /* bridge */ /* synthetic */ void onStartRequest(@NonNull f fVar) {
        onStartRequest((RequestAdapter) ((RequestAdapter) fVar));
    }

    public void onSuccess(@NonNull RequestAdapter<R> requestAdapter, @NonNull ResultDataAdapter<T> resultDataAdapter) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onSuccess(requestAdapter.getOfflineCompoRequest(), resultDataAdapter.getOfflineCompoResultData());
        }
    }

    @Override // com.kwad.sdk.core.network.g
    public /* bridge */ /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
        onSuccess((RequestAdapter) ((RequestAdapter) fVar), (ResultDataAdapter) ((ResultDataAdapter) baseResultData));
    }
}
