package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public interface b<T> {
    boolean OD();

    void a(d<T> dVar, Executor executor);

    boolean dlg();

    @Nullable
    Throwable dli();

    float getProgress();

    @Nullable
    T getResult();

    boolean isFinished();
}
