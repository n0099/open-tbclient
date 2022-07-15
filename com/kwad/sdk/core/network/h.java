package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
/* loaded from: classes5.dex */
public interface h<R extends g, T extends BaseResultData> {
    @WorkerThread
    void onError(@NonNull R r, int i, String str);

    @WorkerThread
    void onStartRequest(@NonNull R r);

    @WorkerThread
    void onSuccess(@NonNull R r, @NonNull T t);
}
