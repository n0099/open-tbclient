package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public interface b<T> {
    boolean LR();

    void a(d<T> dVar, Executor executor);

    boolean diN();

    @Nullable
    Throwable diP();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
