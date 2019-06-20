package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public interface b<T> {
    boolean Ab();

    void a(d<T> dVar, Executor executor);

    boolean cCe();

    @Nullable
    Throwable cCg();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
