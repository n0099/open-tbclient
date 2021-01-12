package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public interface b<T> {
    void a(d<T> dVar, Executor executor);

    boolean apn();

    boolean eqE();

    @Nullable
    Throwable eqG();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
