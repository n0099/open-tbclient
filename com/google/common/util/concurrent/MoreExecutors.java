package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import d.f.d.a.n;
import d.f.d.a.r;
import d.f.d.a.s;
import d.f.d.c.z0;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes6.dex */
public final class MoreExecutors {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.common.util.concurrent.MoreExecutors$5  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static class AnonymousClass5 implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean thrownFromDelegate;
        public final /* synthetic */ Executor val$delegate;
        public final /* synthetic */ AbstractFuture val$future;

        public AnonymousClass5(Executor executor, AbstractFuture abstractFuture) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {executor, abstractFuture};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.val$delegate = executor;
            this.val$future = abstractFuture;
            this.thrownFromDelegate = true;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                try {
                    this.val$delegate.execute(new Runnable(this, runnable) { // from class: com.google.common.util.concurrent.MoreExecutors.5.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass5 this$0;
                        public final /* synthetic */ Runnable val$command;

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
                            this.val$command = runnable;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.thrownFromDelegate = false;
                                this.val$command.run();
                            }
                        }
                    });
                } catch (RejectedExecutionException e2) {
                    if (this.thrownFromDelegate) {
                        this.val$future.setException(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class DirectExecutorService extends AbstractListeningExecutorService {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object lock;
        public int runningTasks;
        public boolean shutdown;

        public DirectExecutorService() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.lock = new Object();
            this.runningTasks = 0;
            this.shutdown = false;
        }

        private void endTask() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                synchronized (this.lock) {
                    int i2 = this.runningTasks - 1;
                    this.runningTasks = i2;
                    if (i2 == 0) {
                        this.lock.notifyAll();
                    }
                }
            }
        }

        private void startTask() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                synchronized (this.lock) {
                    if (!this.shutdown) {
                        this.runningTasks++;
                    } else {
                        throw new RejectedExecutionException("Executor already shutdown");
                    }
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) != null) {
                return invokeJL.booleanValue;
            }
            long nanos = timeUnit.toNanos(j);
            synchronized (this.lock) {
                while (true) {
                    if (this.shutdown && this.runningTasks == 0) {
                        return true;
                    }
                    if (nanos <= 0) {
                        return false;
                    }
                    long nanoTime = System.nanoTime();
                    TimeUnit.NANOSECONDS.timedWait(this.lock, nanos);
                    nanos -= System.nanoTime() - nanoTime;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                startTask();
                try {
                    runnable.run();
                } finally {
                    endTask();
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this.lock) {
                    z = this.shutdown;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                synchronized (this.lock) {
                    z = this.shutdown && this.runningTasks == 0;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                synchronized (this.lock) {
                    this.shutdown = true;
                    if (this.runningTasks == 0) {
                        this.lock.notifyAll();
                    }
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                shutdown();
                return Collections.emptyList();
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class ListeningDecorator extends AbstractListeningExecutorService {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ExecutorService delegate;

        public ListeningDecorator(ExecutorService executorService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {executorService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(executorService);
            this.delegate = executorService;
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? this.delegate.awaitTermination(j, timeUnit) : invokeJL.booleanValue;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                this.delegate.execute(runnable);
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.delegate.isShutdown() : invokeV.booleanValue;
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.delegate.isTerminated() : invokeV.booleanValue;
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.delegate.shutdown();
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.delegate.shutdownNow() : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ScheduledExecutorService delegate;

        /* loaded from: classes6.dex */
        public static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final ScheduledFuture<?> scheduledDelegate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ListenableScheduledTask(ListenableFuture<V> listenableFuture, ScheduledFuture<?> scheduledFuture) {
                super(listenableFuture);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {listenableFuture, scheduledFuture};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((ListenableFuture) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.scheduledDelegate = scheduledFuture;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                    boolean cancel = super.cancel(z);
                    if (cancel) {
                        this.scheduledDelegate.cancel(z);
                    }
                    return cancel;
                }
                return invokeZ.booleanValue;
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit timeUnit) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, timeUnit)) == null) ? this.scheduledDelegate.getDelay(timeUnit) : invokeL.longValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.lang.Comparable
            public int compareTo(Delayed delayed) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, delayed)) == null) ? this.scheduledDelegate.compareTo(delayed) : invokeL.intValue;
            }
        }

        /* loaded from: classes6.dex */
        public static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final Runnable delegate;

            public NeverSuccessfulListenableFutureTask(Runnable runnable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                n.p(runnable);
                this.delegate = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.delegate.run();
                    } catch (Throwable th) {
                        setException(th);
                        s.e(th);
                        throw null;
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scheduledExecutorService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ExecutorService) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(scheduledExecutorService);
            this.delegate = scheduledExecutorService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{runnable, Long.valueOf(j), Long.valueOf(j2), timeUnit})) == null) {
                NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
                return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
            }
            return (ListenableScheduledFuture) invokeCommon.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{runnable, Long.valueOf(j), Long.valueOf(j2), timeUnit})) == null) {
                NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
                return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
            }
            return (ListenableScheduledFuture) invokeCommon.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{runnable, Long.valueOf(j), timeUnit})) == null) {
                TrustedListenableFutureTask create = TrustedListenableFutureTask.create(runnable, null);
                return new ListenableScheduledTask(create, this.delegate.schedule(create, j, timeUnit));
            }
            return (ListenableScheduledFuture) invokeCommon.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{callable, Long.valueOf(j), timeUnit})) == null) {
                TrustedListenableFutureTask create = TrustedListenableFutureTask.create(callable);
                return new ListenableScheduledTask(create, this.delegate.schedule(create, j, timeUnit));
            }
            return (ListenableScheduledFuture) invokeCommon.objValue;
        }
    }

    public MoreExecutors() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void addDelayedShutdownHook(ExecutorService executorService, long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{executorService, Long.valueOf(j), timeUnit}) == null) {
            new Application().addDelayedShutdownHook(executorService, j, timeUnit);
        }
    }

    public static Executor directExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? DirectExecutor.INSTANCE : (Executor) invokeV.objValue;
    }

    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{threadPoolExecutor, Long.valueOf(j), timeUnit})) == null) ? new Application().getExitingExecutorService(threadPoolExecutor, j, timeUnit) : (ExecutorService) invokeCommon.objValue;
    }

    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{scheduledThreadPoolExecutor, Long.valueOf(j), timeUnit})) == null) ? new Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor, j, timeUnit) : (ScheduledExecutorService) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T invokeAnyImpl(ListeningExecutorService listeningExecutorService, Collection<? extends Callable<T>> collection, boolean z, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        InterceptResult invokeCommon;
        long nanoTime;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{listeningExecutorService, collection, Boolean.valueOf(z), Long.valueOf(j), timeUnit})) != null) {
            return (T) invokeCommon.objValue;
        }
        n.p(listeningExecutorService);
        n.p(timeUnit);
        int size = collection.size();
        n.d(size > 0);
        ArrayList<Future> l = Lists.l(size);
        LinkedBlockingQueue b2 = z0.b();
        long nanos = timeUnit.toNanos(j);
        if (z) {
            try {
                nanoTime = System.nanoTime();
            } catch (Throwable th) {
                for (Future future : l) {
                    future.cancel(true);
                }
                throw th;
            }
        } else {
            nanoTime = 0;
        }
        Iterator<? extends Callable<T>> it = collection.iterator();
        l.add(submitAndAddQueueListener(listeningExecutorService, it.next(), b2));
        int i2 = size - 1;
        ExecutionException executionException = null;
        int i3 = 1;
        while (true) {
            Future future2 = (Future) b2.poll();
            if (future2 == null) {
                if (i2 > 0) {
                    i2--;
                    l.add(submitAndAddQueueListener(listeningExecutorService, it.next(), b2));
                    i3++;
                } else if (i3 == 0) {
                    if (executionException == null) {
                        throw new ExecutionException((Throwable) null);
                    }
                    throw executionException;
                } else if (z) {
                    future2 = (Future) b2.poll(nanos, TimeUnit.NANOSECONDS);
                    if (future2 != null) {
                        j2 = System.nanoTime();
                        nanos -= j2 - nanoTime;
                        long j3 = nanos;
                        int i4 = i2;
                        if (future2 == null) {
                            i3--;
                            try {
                                T t = (T) future2.get();
                                for (Future future3 : l) {
                                    future3.cancel(true);
                                }
                                return t;
                            } catch (RuntimeException e2) {
                                executionException = new ExecutionException(e2);
                            } catch (ExecutionException e3) {
                                executionException = e3;
                            }
                        }
                        i2 = i4;
                        nanos = j3;
                        nanoTime = j2;
                    } else {
                        throw new TimeoutException();
                    }
                } else {
                    future2 = (Future) b2.take();
                }
            }
            j2 = nanoTime;
            long j32 = nanos;
            int i42 = i2;
            if (future2 == null) {
            }
            i2 = i42;
            nanos = j32;
            nanoTime = j2;
        }
    }

    public static boolean isAppEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (System.getProperty("com.google.appengine.runtime.environment") == null) {
                return false;
            }
            try {
                return Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) != null;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static ListeningExecutorService listeningDecorator(ExecutorService executorService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, executorService)) == null) {
            if (executorService instanceof ListeningExecutorService) {
                return (ListeningExecutorService) executorService;
            }
            return executorService instanceof ScheduledExecutorService ? new ScheduledListeningDecorator((ScheduledExecutorService) executorService) : new ListeningDecorator(executorService);
        }
        return (ListeningExecutorService) invokeL.objValue;
    }

    public static ListeningExecutorService newDirectExecutorService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? new DirectExecutorService() : (ListeningExecutorService) invokeV.objValue;
    }

    public static Executor newSequentialExecutor(Executor executor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, executor)) == null) ? new SequentialExecutor(executor) : (Executor) invokeL.objValue;
    }

    public static Thread newThread(String str, Runnable runnable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, runnable)) == null) {
            n.p(str);
            n.p(runnable);
            Thread newThread = platformThreadFactory().newThread(runnable);
            try {
                newThread.setName(str);
            } catch (SecurityException unused) {
            }
            return newThread;
        }
        return (Thread) invokeLL.objValue;
    }

    public static ThreadFactory platformThreadFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (!isAppEngine()) {
                return Executors.defaultThreadFactory();
            }
            try {
                return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e4);
            } catch (InvocationTargetException e5) {
                s.e(e5.getCause());
                throw null;
            }
        }
        return (ThreadFactory) invokeV.objValue;
    }

    public static Executor rejectionPropagatingExecutor(Executor executor, AbstractFuture<?> abstractFuture) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, executor, abstractFuture)) == null) {
            n.p(executor);
            n.p(abstractFuture);
            return executor == directExecutor() ? executor : new AnonymousClass5(executor, abstractFuture);
        }
        return (Executor) invokeLL.objValue;
    }

    public static Executor renamingDecorator(Executor executor, r<String> rVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, executor, rVar)) == null) {
            n.p(executor);
            n.p(rVar);
            return isAppEngine() ? executor : new Executor(executor, rVar) { // from class: com.google.common.util.concurrent.MoreExecutors.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Executor val$executor;
                public final /* synthetic */ r val$nameSupplier;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {executor, rVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$executor = executor;
                    this.val$nameSupplier = rVar;
                }

                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, runnable) == null) {
                        this.val$executor.execute(Callables.threadRenaming(runnable, this.val$nameSupplier));
                    }
                }
            };
        }
        return (Executor) invokeLL.objValue;
    }

    public static boolean shutdownAndAwaitTermination(ExecutorService executorService, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{executorService, Long.valueOf(j), timeUnit})) == null) {
            long nanos = timeUnit.toNanos(j) / 2;
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(nanos, TimeUnit.NANOSECONDS)) {
                    executorService.shutdownNow();
                    executorService.awaitTermination(nanos, TimeUnit.NANOSECONDS);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                executorService.shutdownNow();
            }
            return executorService.isTerminated();
        }
        return invokeCommon.booleanValue;
    }

    public static <T> ListenableFuture<T> submitAndAddQueueListener(ListeningExecutorService listeningExecutorService, Callable<T> callable, BlockingQueue<Future<T>> blockingQueue) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65557, null, listeningExecutorService, callable, blockingQueue)) == null) {
            ListenableFuture<T> submit = listeningExecutorService.submit((Callable) callable);
            submit.addListener(new Runnable(blockingQueue, submit) { // from class: com.google.common.util.concurrent.MoreExecutors.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ListenableFuture val$future;
                public final /* synthetic */ BlockingQueue val$queue;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {blockingQueue, submit};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$queue = blockingQueue;
                    this.val$future = submit;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$queue.add(this.val$future);
                    }
                }
            }, directExecutor());
            return submit;
        }
        return (ListenableFuture) invokeLLL.objValue;
    }

    public static void useDaemonThreadFactory(ThreadPoolExecutor threadPoolExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, threadPoolExecutor) == null) {
            threadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(threadPoolExecutor.getThreadFactory()).build());
        }
    }

    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadPoolExecutor)) == null) ? new Application().getExitingExecutorService(threadPoolExecutor) : (ExecutorService) invokeL.objValue;
    }

    public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService scheduledExecutorService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, scheduledExecutorService)) == null) ? scheduledExecutorService instanceof ListeningScheduledExecutorService ? (ListeningScheduledExecutorService) scheduledExecutorService : new ScheduledListeningDecorator(scheduledExecutorService) : (ListeningScheduledExecutorService) invokeL.objValue;
    }

    /* loaded from: classes6.dex */
    public static class Application {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Application() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void addDelayedShutdownHook(ExecutorService executorService, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{executorService, Long.valueOf(j), timeUnit}) == null) {
                n.p(executorService);
                n.p(timeUnit);
                addShutdownHook(MoreExecutors.newThread("DelayedShutdownHook-for-" + executorService, new Runnable(this, executorService, j, timeUnit) { // from class: com.google.common.util.concurrent.MoreExecutors.Application.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Application this$0;
                    public final /* synthetic */ ExecutorService val$service;
                    public final /* synthetic */ long val$terminationTimeout;
                    public final /* synthetic */ TimeUnit val$timeUnit;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, executorService, Long.valueOf(j), timeUnit};
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
                        this.val$service = executorService;
                        this.val$terminationTimeout = j;
                        this.val$timeUnit = timeUnit;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.val$service.shutdown();
                                this.val$service.awaitTermination(this.val$terminationTimeout, this.val$timeUnit);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }));
            }
        }

        public void addShutdownHook(Thread thread) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thread) == null) {
                Runtime.getRuntime().addShutdownHook(thread);
            }
        }

        public final ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{threadPoolExecutor, Long.valueOf(j), timeUnit})) == null) {
                MoreExecutors.useDaemonThreadFactory(threadPoolExecutor);
                ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
                addDelayedShutdownHook(threadPoolExecutor, j, timeUnit);
                return unconfigurableExecutorService;
            }
            return (ExecutorService) invokeCommon.objValue;
        }

        public final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{scheduledThreadPoolExecutor, Long.valueOf(j), timeUnit})) == null) {
                MoreExecutors.useDaemonThreadFactory(scheduledThreadPoolExecutor);
                ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
                addDelayedShutdownHook(scheduledThreadPoolExecutor, j, timeUnit);
                return unconfigurableScheduledExecutorService;
            }
            return (ScheduledExecutorService) invokeCommon.objValue;
        }

        public final ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadPoolExecutor)) == null) ? getExitingExecutorService(threadPoolExecutor, 120L, TimeUnit.SECONDS) : (ExecutorService) invokeL.objValue;
        }

        public final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, scheduledThreadPoolExecutor)) == null) ? getExitingScheduledExecutorService(scheduledThreadPoolExecutor, 120L, TimeUnit.SECONDS) : (ScheduledExecutorService) invokeL.objValue;
        }
    }

    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, scheduledThreadPoolExecutor)) == null) ? new Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor) : (ScheduledExecutorService) invokeL.objValue;
    }

    public static ExecutorService renamingDecorator(ExecutorService executorService, r<String> rVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, executorService, rVar)) == null) {
            n.p(executorService);
            n.p(rVar);
            return isAppEngine() ? executorService : new WrappingExecutorService(executorService, rVar) { // from class: com.google.common.util.concurrent.MoreExecutors.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ r val$nameSupplier;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(executorService);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {executorService, rVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((ExecutorService) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$nameSupplier = rVar;
                }

                @Override // com.google.common.util.concurrent.WrappingExecutorService
                public <T> Callable<T> wrapTask(Callable<T> callable) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callable)) == null) ? Callables.threadRenaming(callable, this.val$nameSupplier) : (Callable) invokeL.objValue;
                }

                @Override // com.google.common.util.concurrent.WrappingExecutorService
                public Runnable wrapTask(Runnable runnable) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) ? Callables.threadRenaming(runnable, this.val$nameSupplier) : (Runnable) invokeL.objValue;
                }
            };
        }
        return (ExecutorService) invokeLL.objValue;
    }

    public static ScheduledExecutorService renamingDecorator(ScheduledExecutorService scheduledExecutorService, r<String> rVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, scheduledExecutorService, rVar)) == null) {
            n.p(scheduledExecutorService);
            n.p(rVar);
            return isAppEngine() ? scheduledExecutorService : new WrappingScheduledExecutorService(scheduledExecutorService, rVar) { // from class: com.google.common.util.concurrent.MoreExecutors.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ r val$nameSupplier;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(scheduledExecutorService);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {scheduledExecutorService, rVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((ScheduledExecutorService) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$nameSupplier = rVar;
                }

                @Override // com.google.common.util.concurrent.WrappingExecutorService
                public <T> Callable<T> wrapTask(Callable<T> callable) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callable)) == null) ? Callables.threadRenaming(callable, this.val$nameSupplier) : (Callable) invokeL.objValue;
                }

                @Override // com.google.common.util.concurrent.WrappingExecutorService
                public Runnable wrapTask(Runnable runnable) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) ? Callables.threadRenaming(runnable, this.val$nameSupplier) : (Runnable) invokeL.objValue;
                }
            };
        }
        return (ScheduledExecutorService) invokeLL.objValue;
    }
}
