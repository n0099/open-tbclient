package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public interface b<T> {
    void a(d<T> dVar, Executor executor);

    boolean bVd();

    @Nullable
    Throwable bVf();

    boolean bVg();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
