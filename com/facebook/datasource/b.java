package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public interface b<T> {
    void a(d<T> dVar, Executor executor);

    boolean abo();

    boolean dCW();

    @Nullable
    Throwable dCY();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
