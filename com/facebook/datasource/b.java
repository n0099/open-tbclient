package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes19.dex */
public interface b<T> {
    void a(d<T> dVar, Executor executor);

    boolean arP();

    boolean eqo();

    @Nullable
    Throwable eqq();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
