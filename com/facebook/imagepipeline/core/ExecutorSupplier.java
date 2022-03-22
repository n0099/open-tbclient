package com.facebook.imagepipeline.core;

import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public interface ExecutorSupplier {
    Executor forBackgroundTasks();

    Executor forDecode();

    Executor forLightweightBackgroundTasks();

    Executor forLocalStorageRead();

    Executor forLocalStorageWrite();
}
