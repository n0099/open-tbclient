package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public interface b<T> {
    void a(d<T> dVar, Executor executor);

    boolean apO();

    boolean eto();

    @Nullable
    Throwable etq();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
