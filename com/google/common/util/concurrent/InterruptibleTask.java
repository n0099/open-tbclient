package com.google.common.util.concurrent;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes10.dex */
public abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Runnable DONE;
    public static final Runnable INTERRUPTING;
    public static final int MAX_BUSY_WAIT_SPINS = 1000;
    public static final Runnable PARKED;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.common.util.concurrent.InterruptibleTask$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static final class DoNothingRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DoNothingRunnable() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public /* synthetic */ DoNothingRunnable(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1591365452, "Lcom/google/common/util/concurrent/InterruptibleTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1591365452, "Lcom/google/common/util/concurrent/InterruptibleTask;");
                return;
            }
        }
        DONE = new DoNothingRunnable(null);
        INTERRUPTING = new DoNothingRunnable(null);
        PARKED = new DoNothingRunnable(null);
    }

    public InterruptibleTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public abstract void afterRanInterruptibly(T t, Throwable th);

    public final void interruptTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = get();
            if ((runnable instanceof Thread) && compareAndSet(runnable, INTERRUPTING)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (getAndSet(DONE) == PARKED) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
    }

    public abstract boolean isDone();

    @Override // java.lang.Runnable
    public final void run() {
        T runInterruptibly;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Thread currentThread = Thread.currentThread();
            if (compareAndSet(null, currentThread)) {
                boolean z = !isDone();
                if (z) {
                    try {
                        runInterruptibly = runInterruptibly();
                    } catch (Throwable th) {
                        if (!compareAndSet(currentThread, DONE)) {
                            Runnable runnable = get();
                            boolean z2 = false;
                            int i2 = 0;
                            while (true) {
                                if (runnable != INTERRUPTING && runnable != PARKED) {
                                    break;
                                }
                                i2++;
                                if (i2 > 1000) {
                                    Runnable runnable2 = PARKED;
                                    if (runnable == runnable2 || compareAndSet(INTERRUPTING, runnable2)) {
                                        z2 = Thread.interrupted() || z2;
                                        LockSupport.park(this);
                                    }
                                } else {
                                    Thread.yield();
                                }
                                runnable = get();
                            }
                            if (z2) {
                                currentThread.interrupt();
                            }
                        }
                        if (z) {
                            afterRanInterruptibly(null, th);
                            return;
                        }
                        return;
                    }
                } else {
                    runInterruptibly = null;
                }
                if (!compareAndSet(currentThread, DONE)) {
                    Runnable runnable3 = get();
                    boolean z3 = false;
                    int i3 = 0;
                    while (true) {
                        if (runnable3 != INTERRUPTING && runnable3 != PARKED) {
                            break;
                        }
                        i3++;
                        if (i3 > 1000) {
                            Runnable runnable4 = PARKED;
                            if (runnable3 == runnable4 || compareAndSet(INTERRUPTING, runnable4)) {
                                z3 = Thread.interrupted() || z3;
                                LockSupport.park(this);
                            }
                        } else {
                            Thread.yield();
                        }
                        runnable3 = get();
                    }
                    if (z3) {
                        currentThread.interrupt();
                    }
                }
                if (z) {
                    afterRanInterruptibly(runInterruptibly, null);
                }
            }
        }
    }

    public abstract T runInterruptibly() throws Exception;

    public abstract String toPendingString();

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Runnable runnable = get();
            if (runnable == DONE) {
                str = "running=[DONE]";
            } else if (runnable == INTERRUPTING) {
                str = "running=[INTERRUPTED]";
            } else if (runnable instanceof Thread) {
                str = "running=[RUNNING ON " + ((Thread) runnable).getName() + PreferencesUtil.RIGHT_MOUNT;
            } else {
                str = "running=[NOT STARTED YET]";
            }
            return str + StringUtil.ARRAY_ELEMENT_SEPARATOR + toPendingString();
        }
        return (String) invokeV.objValue;
    }
}
