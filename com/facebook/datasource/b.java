package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public interface b<T> {
    void a(d<T> dVar, Executor executor);

    boolean aam();

    boolean dzJ();

    @Nullable
    Throwable dzL();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
