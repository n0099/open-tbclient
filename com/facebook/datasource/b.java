package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public interface b<T> {
    void a(d<T> dVar, Executor executor);

    boolean abo();

    boolean dCV();

    @Nullable
    Throwable dCX();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
