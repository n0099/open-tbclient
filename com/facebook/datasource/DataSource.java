package com.facebook.datasource;

import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public interface DataSource {
    boolean close();

    @Nullable
    Map getExtras();

    @Nullable
    Throwable getFailureCause();

    float getProgress();

    @Nullable
    Object getResult();

    boolean hasFailed();

    boolean hasMultipleResults();

    boolean hasResult();

    boolean isClosed();

    boolean isFinished();

    void subscribe(DataSubscriber dataSubscriber, Executor executor);
}
