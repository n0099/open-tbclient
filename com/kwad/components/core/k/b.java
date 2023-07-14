package com.kwad.components.core.k;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.response.model.AdResultData;
/* loaded from: classes10.dex */
public abstract class b extends f {
    @WorkerThread
    public abstract void a(int i, String str, boolean z);

    @WorkerThread
    public abstract void a(@NonNull AdResultData adResultData, boolean z);
}
