package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public interface b<T> {
    boolean AI();

    void a(d<T> dVar, Executor executor);

    boolean cFA();

    @Nullable
    Throwable cFC();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
