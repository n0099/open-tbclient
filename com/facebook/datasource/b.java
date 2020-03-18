package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public interface b<T> {
    boolean OG();

    void a(d<T> dVar, Executor executor);

    boolean dlD();

    @Nullable
    Throwable dlF();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
