package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
@Experimental
/* loaded from: classes8.dex */
public interface SchedulerMultiWorkerSupport {

    /* loaded from: classes8.dex */
    public interface WorkerCallback {
        void onWorker(int i2, @NonNull Scheduler.Worker worker);
    }

    void createWorkers(int i2, @NonNull WorkerCallback workerCallback);
}
