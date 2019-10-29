package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public interface b<T> {
    boolean FH();

    void a(d<T> dVar, Executor executor);

    boolean cDm();

    @Nullable
    Throwable cDo();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
