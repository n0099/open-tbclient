package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class UiThreadImmediateExecutorService extends HandlerExecutorServiceImpl {
    @Nullable
    public static UiThreadImmediateExecutorService sInstance;

    public UiThreadImmediateExecutorService() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static UiThreadImmediateExecutorService getInstance() {
        if (sInstance == null) {
            sInstance = new UiThreadImmediateExecutorService();
        }
        return sInstance;
    }

    @Override // com.facebook.common.executors.HandlerExecutorServiceImpl, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (isHandlerThread()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
