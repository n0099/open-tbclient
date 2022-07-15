package com.kwad.components.core.j;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.response.model.AdResultData;
/* loaded from: classes5.dex */
public interface g<T extends AdResultData> {
    @WorkerThread
    void a(int i, String str);

    @WorkerThread
    void a(@NonNull T t);
}
