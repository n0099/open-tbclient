package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public interface b<T> {
    boolean Mn();

    void a(d<T> dVar, Executor executor);

    boolean djO();

    @Nullable
    Throwable djQ();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
