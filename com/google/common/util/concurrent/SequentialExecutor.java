package com.google.common.util.concurrent;

import c.i.d.a.n;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;
/* loaded from: classes2.dex */
public final class SequentialExecutor implements Executor {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger log;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor executor;
    public final Deque<Runnable> queue;
    public final QueueWorker worker;
    public long workerRunCount;
    public WorkerRunningState workerRunningState;

    /* loaded from: classes2.dex */
    public final class QueueWorker implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SequentialExecutor this$0;

        public QueueWorker(SequentialExecutor sequentialExecutor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sequentialExecutor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sequentialExecutor;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE] complete} */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
            if (r1 == false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
            r3.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
            r4 = com.google.common.util.concurrent.SequentialExecutor.log;
            r5 = java.util.logging.Level.SEVERE;
            r4.log(r5, "Exception while executing runnable " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void workOnQueue() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    try {
                        synchronized (this.this$0.queue) {
                            if (!z) {
                                if (this.this$0.workerRunningState != WorkerRunningState.RUNNING) {
                                    SequentialExecutor.access$308(this.this$0);
                                    this.this$0.workerRunningState = WorkerRunningState.RUNNING;
                                    z = true;
                                }
                            }
                            Runnable runnable = (Runnable) this.this$0.queue.poll();
                            if (runnable == null) {
                                this.this$0.workerRunningState = WorkerRunningState.IDLE;
                            }
                        }
                        if (z2) {
                            return;
                        }
                        return;
                    } finally {
                        if (z2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    workOnQueue();
                } catch (Error e2) {
                    synchronized (this.this$0.queue) {
                        this.this$0.workerRunningState = WorkerRunningState.IDLE;
                        throw e2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class WorkerRunningState {
        public static final /* synthetic */ WorkerRunningState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final WorkerRunningState IDLE;
        public static final WorkerRunningState QUEUED;
        public static final WorkerRunningState QUEUING;
        public static final WorkerRunningState RUNNING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(459845324, "Lcom/google/common/util/concurrent/SequentialExecutor$WorkerRunningState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(459845324, "Lcom/google/common/util/concurrent/SequentialExecutor$WorkerRunningState;");
                    return;
                }
            }
            IDLE = new WorkerRunningState("IDLE", 0);
            QUEUING = new WorkerRunningState("QUEUING", 1);
            QUEUED = new WorkerRunningState("QUEUED", 2);
            WorkerRunningState workerRunningState = new WorkerRunningState("RUNNING", 3);
            RUNNING = workerRunningState;
            $VALUES = new WorkerRunningState[]{IDLE, QUEUING, QUEUED, workerRunningState};
        }

        public WorkerRunningState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static WorkerRunningState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (WorkerRunningState) Enum.valueOf(WorkerRunningState.class, str) : (WorkerRunningState) invokeL.objValue;
        }

        public static WorkerRunningState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (WorkerRunningState[]) $VALUES.clone() : (WorkerRunningState[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1952376746, "Lcom/google/common/util/concurrent/SequentialExecutor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1952376746, "Lcom/google/common/util/concurrent/SequentialExecutor;");
                return;
            }
        }
        log = Logger.getLogger(SequentialExecutor.class.getName());
    }

    public SequentialExecutor(Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.queue = new ArrayDeque();
        this.workerRunningState = WorkerRunningState.IDLE;
        this.workerRunCount = 0L;
        this.worker = new QueueWorker();
        n.p(executor);
        this.executor = executor;
    }

    public static /* synthetic */ long access$308(SequentialExecutor sequentialExecutor) {
        long j2 = sequentialExecutor.workerRunCount;
        sequentialExecutor.workerRunCount = 1 + j2;
        return j2;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            n.p(runnable);
            synchronized (this.queue) {
                if (this.workerRunningState != WorkerRunningState.RUNNING && this.workerRunningState != WorkerRunningState.QUEUED) {
                    long j2 = this.workerRunCount;
                    Runnable runnable2 = new Runnable(this, runnable) { // from class: com.google.common.util.concurrent.SequentialExecutor.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SequentialExecutor this$0;
                        public final /* synthetic */ Runnable val$task;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, runnable};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$task = runnable;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$task.run();
                            }
                        }
                    };
                    this.queue.add(runnable2);
                    this.workerRunningState = WorkerRunningState.QUEUING;
                    try {
                        this.executor.execute(this.worker);
                        if (this.workerRunningState != WorkerRunningState.QUEUING) {
                            return;
                        }
                        synchronized (this.queue) {
                            if (this.workerRunCount == j2 && this.workerRunningState == WorkerRunningState.QUEUING) {
                                this.workerRunningState = WorkerRunningState.QUEUED;
                            }
                        }
                        return;
                    } catch (Error | RuntimeException e2) {
                        synchronized (this.queue) {
                            if ((this.workerRunningState != WorkerRunningState.IDLE && this.workerRunningState != WorkerRunningState.QUEUING) || !this.queue.removeLastOccurrence(runnable2)) {
                                r8 = false;
                            }
                            if (!(e2 instanceof RejectedExecutionException) || r8) {
                                throw e2;
                            }
                        }
                        return;
                    }
                }
                this.queue.add(runnable);
            }
        }
    }
}
