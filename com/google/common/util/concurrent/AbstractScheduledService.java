package com.google.common.util.concurrent;

import c.i.d.a.n;
import c.i.d.a.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.Service;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
/* loaded from: classes10.dex */
public abstract class AbstractScheduledService implements Service {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger logger;
    public transient /* synthetic */ FieldHolder $fh;
    public final AbstractService delegate;

    /* loaded from: classes10.dex */
    public static abstract class CustomScheduler extends Scheduler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes10.dex */
        public class ReschedulableCallable extends ForwardingFuture<Void> implements Callable<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Future<Void> currentFuture;
            public final ScheduledExecutorService executor;
            public final ReentrantLock lock;
            public final AbstractService service;
            public final /* synthetic */ CustomScheduler this$0;
            public final Runnable wrappedRunnable;

            public ReschedulableCallable(CustomScheduler customScheduler, AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {customScheduler, abstractService, scheduledExecutorService, runnable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = customScheduler;
                this.lock = new ReentrantLock();
                this.wrappedRunnable = runnable;
                this.executor = scheduledExecutorService;
                this.service = abstractService;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                    this.lock.lock();
                    try {
                        return this.currentFuture.cancel(z);
                    } finally {
                        this.lock.unlock();
                    }
                }
                return invokeZ.booleanValue;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean isCancelled() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    this.lock.lock();
                    try {
                        return this.currentFuture.isCancelled();
                    } finally {
                        this.lock.unlock();
                    }
                }
                return invokeV.booleanValue;
            }

            public void reschedule() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                    try {
                        Schedule nextSchedule = this.this$0.getNextSchedule();
                        Throwable th = null;
                        this.lock.lock();
                        try {
                            if (this.currentFuture == null || !this.currentFuture.isCancelled()) {
                                this.currentFuture = this.executor.schedule(this, nextSchedule.delay, nextSchedule.unit);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        this.lock.unlock();
                        if (th != null) {
                            this.service.notifyFailed(th);
                        }
                    } catch (Throwable th3) {
                        this.service.notifyFailed(th3);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    this.wrappedRunnable.run();
                    reschedule();
                    return null;
                }
                return (Void) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.util.concurrent.ForwardingFuture, c.i.d.c.h0
            public Future<Void> delegate() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
                }
                return (Future) invokeV.objValue;
            }
        }

        /* loaded from: classes10.dex */
        public static final class Schedule {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final long delay;
            public final TimeUnit unit;

            public Schedule(long j2, TimeUnit timeUnit) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Long.valueOf(j2), timeUnit};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.delay = j2;
                n.p(timeUnit);
                this.unit = timeUnit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomScheduler() {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public abstract Schedule getNextSchedule() throws Exception;

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        public final Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abstractService, scheduledExecutorService, runnable)) == null) {
                ReschedulableCallable reschedulableCallable = new ReschedulableCallable(this, abstractService, scheduledExecutorService, runnable);
                reschedulableCallable.reschedule();
                return reschedulableCallable;
            }
            return (Future) invokeLLL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class Scheduler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Scheduler newFixedDelaySchedule(long j2, long j3, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit})) == null) {
                n.p(timeUnit);
                n.h(j3 > 0, "delay must be > 0, found %s", j3);
                return new Scheduler(j2, j3, timeUnit) { // from class: com.google.common.util.concurrent.AbstractScheduledService.Scheduler.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long val$delay;
                    public final /* synthetic */ long val$initialDelay;
                    public final /* synthetic */ TimeUnit val$unit;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), timeUnit};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super();
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$initialDelay = j2;
                        this.val$delay = j3;
                        this.val$unit = timeUnit;
                    }

                    @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
                    public Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                        InterceptResult invokeLLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, abstractService, scheduledExecutorService, runnable)) == null) ? scheduledExecutorService.scheduleWithFixedDelay(runnable, this.val$initialDelay, this.val$delay, this.val$unit) : (Future) invokeLLL.objValue;
                    }
                };
            }
            return (Scheduler) invokeCommon.objValue;
        }

        public static Scheduler newFixedRateSchedule(long j2, long j3, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit})) == null) {
                n.p(timeUnit);
                n.h(j3 > 0, "period must be > 0, found %s", j3);
                return new Scheduler(j2, j3, timeUnit) { // from class: com.google.common.util.concurrent.AbstractScheduledService.Scheduler.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long val$initialDelay;
                    public final /* synthetic */ long val$period;
                    public final /* synthetic */ TimeUnit val$unit;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), timeUnit};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super();
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$initialDelay = j2;
                        this.val$period = j3;
                        this.val$unit = timeUnit;
                    }

                    @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
                    public Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                        InterceptResult invokeLLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, abstractService, scheduledExecutorService, runnable)) == null) ? scheduledExecutorService.scheduleAtFixedRate(runnable, this.val$initialDelay, this.val$period, this.val$unit) : (Future) invokeLLL.objValue;
                    }
                };
            }
            return (Scheduler) invokeCommon.objValue;
        }

        public abstract Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable);

        public Scheduler() {
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
    }

    /* loaded from: classes10.dex */
    public final class ServiceDelegate extends AbstractService {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile ScheduledExecutorService executorService;
        public final ReentrantLock lock;
        public volatile Future<?> runningTask;
        public final Runnable task;
        public final /* synthetic */ AbstractScheduledService this$0;

        /* loaded from: classes10.dex */
        public class Task implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ServiceDelegate this$1;

            public Task(ServiceDelegate serviceDelegate) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {serviceDelegate};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = serviceDelegate;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.this$1.lock.lock();
                    try {
                    } finally {
                        try {
                        } finally {
                        }
                    }
                    if (this.this$1.runningTask.isCancelled()) {
                        return;
                    }
                    this.this$1.this$0.runOneIteration();
                }
            }
        }

        public ServiceDelegate(AbstractScheduledService abstractScheduledService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractScheduledService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = abstractScheduledService;
            this.lock = new ReentrantLock();
            this.task = new Task(this);
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.executorService = MoreExecutors.renamingDecorator(this.this$0.executor(), new r<String>(this) { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ServiceDelegate this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // c.i.d.a.r
                    public String get() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return this.this$1.this$0.serviceName() + " " + this.this$1.state();
                        }
                        return (String) invokeV.objValue;
                    }
                });
                this.executorService.execute(new Runnable(this) { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ServiceDelegate this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$1.lock.lock();
                            try {
                                this.this$1.this$0.startUp();
                                this.this$1.runningTask = this.this$1.this$0.scheduler().schedule(this.this$1.this$0.delegate, this.this$1.executorService, this.this$1.task);
                                this.this$1.notifyStarted();
                            } finally {
                                try {
                                } finally {
                                }
                            }
                        }
                    }
                });
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.runningTask.cancel(false);
                this.executorService.execute(new Runnable(this) { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ServiceDelegate this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.this$1.lock.lock();
                                if (this.this$1.state() != Service.State.STOPPING) {
                                    this.this$1.lock.unlock();
                                    return;
                                }
                                this.this$1.this$0.shutDown();
                                this.this$1.lock.unlock();
                                this.this$1.notifyStopped();
                            } catch (Throwable th) {
                                this.this$1.notifyFailed(th);
                            }
                        }
                    }
                });
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.toString() : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(608537342, "Lcom/google/common/util/concurrent/AbstractScheduledService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(608537342, "Lcom/google/common/util/concurrent/AbstractScheduledService;");
                return;
            }
        }
        logger = Logger.getLogger(AbstractScheduledService.class.getName());
    }

    public AbstractScheduledService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.delegate = new ServiceDelegate();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, listener, executor) == null) {
            this.delegate.addListener(listener, executor);
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.delegate.awaitRunning();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.delegate.awaitTerminated();
        }
    }

    public ScheduledExecutorService executor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory(this) { // from class: com.google.common.util.concurrent.AbstractScheduledService.1ThreadFactoryImpl
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbstractScheduledService this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) ? MoreExecutors.newThread(this.this$0.serviceName(), runnable) : (Thread) invokeL.objValue;
                }
            });
            addListener(new Service.Listener(this, newSingleThreadScheduledExecutor) { // from class: com.google.common.util.concurrent.AbstractScheduledService.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbstractScheduledService this$0;
                public final /* synthetic */ ScheduledExecutorService val$executor;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, newSingleThreadScheduledExecutor};
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
                    this.val$executor = newSingleThreadScheduledExecutor;
                }

                @Override // com.google.common.util.concurrent.Service.Listener
                public void failed(Service.State state, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, state, th) == null) {
                        this.val$executor.shutdown();
                    }
                }

                @Override // com.google.common.util.concurrent.Service.Listener
                public void terminated(Service.State state) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, state) == null) {
                        this.val$executor.shutdown();
                    }
                }
            }, MoreExecutors.directExecutor());
            return newSingleThreadScheduledExecutor;
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.delegate.failureCause() : (Throwable) invokeV.objValue;
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.delegate.isRunning() : invokeV.booleanValue;
    }

    public abstract void runOneIteration() throws Exception;

    public abstract Scheduler scheduler();

    public String serviceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? AbstractScheduledService.class.getSimpleName() : (String) invokeV.objValue;
    }

    public void shutDown() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service startAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            this.delegate.startAsync();
            return this;
        }
        return (Service) invokeV.objValue;
    }

    public void startUp() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.delegate.state() : (Service.State) invokeV.objValue;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service stopAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            this.delegate.stopAsync();
            return this;
        }
        return (Service) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return serviceName() + " [" + state() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j2, TimeUnit timeUnit) throws TimeoutException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, timeUnit) == null) {
            this.delegate.awaitRunning(j2, timeUnit);
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j2, TimeUnit timeUnit) throws TimeoutException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048580, this, j2, timeUnit) == null) {
            this.delegate.awaitTerminated(j2, timeUnit);
        }
    }
}
