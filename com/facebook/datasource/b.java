package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public interface b<T> {
    boolean Wu();

    void a(d<T> dVar, Executor executor);

    boolean dnw();

    @Nullable
    Throwable dny();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
