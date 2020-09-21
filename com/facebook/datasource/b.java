package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes17.dex */
public interface b<T> {
    void a(d<T> dVar, Executor executor);

    boolean aik();

    boolean dTd();

    @Nullable
    Throwable dTf();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
