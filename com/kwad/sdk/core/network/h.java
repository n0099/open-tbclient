package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
/* loaded from: classes7.dex */
public interface h<R extends g, T extends BaseResultData> {
    @WorkerThread
    void a(@NonNull R r);

    @WorkerThread
    void a(@NonNull R r, int i2, String str);

    @WorkerThread
    void a(@NonNull R r, @NonNull T t);
}
