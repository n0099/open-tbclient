package com.google.common.util.concurrent;

import c.i.c.a.n;
import c.i.c.c.z0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes7.dex */
public final class ListenerCallQueue<L> {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger logger;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<PerListenerQueue<L>> listeners;

    /* loaded from: classes7.dex */
    public interface Event<L> {
        void call(L l);
    }

    /* loaded from: classes7.dex */
    public static final class PerListenerQueue<L> implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Executor executor;
        public boolean isThreadScheduled;
        public final Queue<Object> labelQueue;
        public final L listener;
        public final Queue<Event<L>> waitQueue;

        public PerListenerQueue(L l, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l, executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.waitQueue = z0.a();
            this.labelQueue = z0.a();
            n.p(l);
            this.listener = l;
            n.p(executor);
            this.executor = executor;
        }

        public synchronized void add(Event<L> event, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, event, obj) == null) {
                synchronized (this) {
                    this.waitQueue.add(event);
                    this.labelQueue.add(obj);
                }
            }
        }

        public void dispatch() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this) {
                    z = true;
                    if (this.isThreadScheduled) {
                        z = false;
                    } else {
                        this.isThreadScheduled = true;
                    }
                }
                if (z) {
                    try {
                        this.executor.execute(this);
                    } catch (RuntimeException e2) {
                        synchronized (this) {
                            this.isThreadScheduled = false;
                            Logger logger = ListenerCallQueue.logger;
                            Level level = Level.SEVERE;
                            logger.log(level, "Exception while running callbacks for " + this.listener + " on " + this.executor, (Throwable) e2);
                            throw e2;
                        }
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
            r2.call(r9.listener);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
            r4 = com.google.common.util.concurrent.ListenerCallQueue.logger;
            r5 = java.util.logging.Level.SEVERE;
            r4.log(r5, "Exception while executing callback: " + r9.listener + " " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Throwable th;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                while (true) {
                    boolean z2 = true;
                    try {
                        synchronized (this) {
                            try {
                                n.w(this.isThreadScheduled);
                                Event<L> poll = this.waitQueue.poll();
                                Object poll2 = this.labelQueue.poll();
                                if (poll == null) {
                                    this.isThreadScheduled = false;
                                    try {
                                        return;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z = false;
                                        while (true) {
                                            try {
                                                try {
                                                    break;
                                                } catch (Throwable th3) {
                                                    boolean z3 = z;
                                                    th = th3;
                                                    z2 = z3;
                                                    if (z2) {
                                                        synchronized (this) {
                                                            this.isThreadScheduled = false;
                                                        }
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                z = true;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        if (z2) {
                        }
                        throw th;
                    }
                    throw th;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-998331729, "Lcom/google/common/util/concurrent/ListenerCallQueue;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-998331729, "Lcom/google/common/util/concurrent/ListenerCallQueue;");
                return;
            }
        }
        logger = Logger.getLogger(ListenerCallQueue.class.getName());
    }

    public ListenerCallQueue() {
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
        this.listeners = Collections.synchronizedList(new ArrayList());
    }

    private void enqueueHelper(Event<L> event, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, event, obj) == null) {
            n.q(event, "event");
            n.q(obj, "label");
            synchronized (this.listeners) {
                for (PerListenerQueue<L> perListenerQueue : this.listeners) {
                    perListenerQueue.add(event, obj);
                }
            }
        }
    }

    public void addListener(L l, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, l, executor) == null) {
            n.q(l, "listener");
            n.q(executor, "executor");
            this.listeners.add(new PerListenerQueue<>(l, executor));
        }
    }

    public void dispatch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.listeners.size(); i2++) {
                this.listeners.get(i2).dispatch();
            }
        }
    }

    public void enqueue(Event<L> event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, event) == null) {
            enqueueHelper(event, event);
        }
    }

    public void enqueue(Event<L> event, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, event, str) == null) {
            enqueueHelper(event, str);
        }
    }
}
