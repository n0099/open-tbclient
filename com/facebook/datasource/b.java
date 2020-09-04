package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public interface b<T> {
    void a(d<T> dVar, Executor executor);

    boolean ahA();

    boolean dPf();

    @Nullable
    Throwable dPh();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
