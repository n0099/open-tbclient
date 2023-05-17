package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.h;
/* loaded from: classes9.dex */
public class RequestListenerAdapter<R extends IOfflineCompoRequest, T extends BaseOfflineCompoResultData> implements h<RequestAdapter<R>, ResultDataAdapter<T>> {
    public final IOfflineCompoRequestListener<R, T> mRequestListener;

    public RequestListenerAdapter(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mRequestListener = iOfflineCompoRequestListener;
    }

    public void onError(@NonNull RequestAdapter<R> requestAdapter, int i, String str) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onError(requestAdapter.getOfflineCompoRequest(), i, str);
        }
    }

    @Override // com.kwad.sdk.core.network.h
    public /* bridge */ /* synthetic */ void onError(@NonNull g gVar, int i, String str) {
        onError((RequestAdapter) ((RequestAdapter) gVar), i, str);
    }

    public void onStartRequest(@NonNull RequestAdapter<R> requestAdapter) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onStartRequest(requestAdapter.getOfflineCompoRequest());
        }
    }

    @Override // com.kwad.sdk.core.network.h
    public /* bridge */ /* synthetic */ void onStartRequest(@NonNull g gVar) {
        onStartRequest((RequestAdapter) ((RequestAdapter) gVar));
    }

    public void onSuccess(@NonNull RequestAdapter<R> requestAdapter, @NonNull ResultDataAdapter<T> resultDataAdapter) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onSuccess(requestAdapter.getOfflineCompoRequest(), resultDataAdapter.getOfflineCompoResultData());
        }
    }

    @Override // com.kwad.sdk.core.network.h
    public /* bridge */ /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
        onSuccess((RequestAdapter) ((RequestAdapter) gVar), (ResultDataAdapter) ((ResultDataAdapter) baseResultData));
    }
}
