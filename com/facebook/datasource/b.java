package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public interface b<T> {
    boolean Wv();

    void a(d<T> dVar, Executor executor);

    @Nullable
    Throwable dnA();

    boolean dny();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
