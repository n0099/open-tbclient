package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public interface b<T> {
    void a(d<T> dVar, Executor executor);

    boolean ath();

    boolean eur();

    @Nullable
    Throwable eut();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
