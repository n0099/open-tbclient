package com.facebook.common.executors;

import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes5.dex */
public interface HandlerExecutorService extends ScheduledExecutorService {
    boolean isHandlerThread();

    void quit();
}
