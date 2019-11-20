package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public interface b<T> {
    boolean FI();

    void a(d<T> dVar, Executor executor);

    boolean cDk();

    @Nullable
    Throwable cDm();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
