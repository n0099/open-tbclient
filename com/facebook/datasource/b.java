package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public interface b<T> {
    void a(d<T> dVar, Executor executor);

    boolean apL();

    boolean esX();

    @Nullable
    Throwable esZ();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
