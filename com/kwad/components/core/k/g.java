package com.kwad.components.core.k;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.response.model.AdResultData;
/* loaded from: classes5.dex */
public interface g<T extends AdResultData> {
    @WorkerThread
    void a(@NonNull T t);

    @WorkerThread
    void onError(int i, String str);
}
