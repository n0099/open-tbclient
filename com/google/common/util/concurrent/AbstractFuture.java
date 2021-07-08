package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import d.f.d.a.n;
import d.f.d.a.s;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
/* loaded from: classes6.dex */
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final AtomicHelper ATOMIC_HELPER;
    public static final boolean GENERATE_CANCELLATION_CAUSES;
    public static final Object NULL;
    public static final long SPIN_THRESHOLD_NANOS = 1000;
    public static final Logger log;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Listener listeners;
    public volatile Object value;
    public volatile Waiter waiters;

    /* renamed from: com.google.common.util.concurrent.AbstractFuture$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static abstract class AtomicHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AtomicHelper() {
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

        public abstract boolean casListeners(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2);

        public abstract boolean casValue(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        public abstract boolean casWaiters(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2);

        public abstract void putNext(Waiter waiter, Waiter waiter2);

        public abstract void putThread(Waiter waiter, Thread thread);

        public /* synthetic */ AtomicHelper(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class Cancellation {
        public static /* synthetic */ Interceptable $ic;
        public static final Cancellation CAUSELESS_CANCELLED;
        public static final Cancellation CAUSELESS_INTERRUPTED;
        public transient /* synthetic */ FieldHolder $fh;
        public final Throwable cause;
        public final boolean wasInterrupted;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(736209772, "Lcom/google/common/util/concurrent/AbstractFuture$Cancellation;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(736209772, "Lcom/google/common/util/concurrent/AbstractFuture$Cancellation;");
                    return;
                }
            }
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                CAUSELESS_CANCELLED = null;
                CAUSELESS_INTERRUPTED = null;
                return;
            }
            CAUSELESS_CANCELLED = new Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new Cancellation(true, null);
        }

        public Cancellation(boolean z, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.wasInterrupted = z;
            this.cause = th;
        }
    }

    /* loaded from: classes6.dex */
    public static final class Failure {
        public static /* synthetic */ Interceptable $ic;
        public static final Failure FALLBACK_INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;
        public final Throwable exception;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2037962653, "Lcom/google/common/util/concurrent/AbstractFuture$Failure;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2037962653, "Lcom/google/common/util/concurrent/AbstractFuture$Failure;");
                    return;
                }
            }
            FALLBACK_INSTANCE = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // java.lang.Throwable
                public synchronized Throwable fillInStackTrace() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        synchronized (this) {
                        }
                        return this;
                    }
                    return (Throwable) invokeV.objValue;
                }
            });
        }

        public Failure(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            n.p(th);
            this.exception = th;
        }
    }

    /* loaded from: classes6.dex */
    public static final class Listener {
        public static /* synthetic */ Interceptable $ic;
        public static final Listener TOMBSTONE;
        public transient /* synthetic */ FieldHolder $fh;
        public final Executor executor;
        public Listener next;
        public final Runnable task;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1945636901, "Lcom/google/common/util/concurrent/AbstractFuture$Listener;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1945636901, "Lcom/google/common/util/concurrent/AbstractFuture$Listener;");
                    return;
                }
            }
            TOMBSTONE = new Listener(null, null);
        }

        public Listener(Runnable runnable, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, executor};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.task = runnable;
            this.executor = executor;
        }
    }

    /* loaded from: classes6.dex */
    public static final class SafeAtomicHelper extends AtomicHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReferenceFieldUpdater<AbstractFuture, Listener> listenersUpdater;
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;
        public final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        public final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        public final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> waitersUpdater;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReferenceFieldUpdater, atomicReferenceFieldUpdater2, atomicReferenceFieldUpdater3, atomicReferenceFieldUpdater4, atomicReferenceFieldUpdater5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casListeners(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, abstractFuture, listener, listener2)) == null) ? this.listenersUpdater.compareAndSet(abstractFuture, listener, listener2) : invokeLLL.booleanValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casValue(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abstractFuture, obj, obj2)) == null) ? this.valueUpdater.compareAndSet(abstractFuture, obj, obj2) : invokeLLL.booleanValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casWaiters(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, abstractFuture, waiter, waiter2)) == null) ? this.waitersUpdater.compareAndSet(abstractFuture, waiter, waiter2) : invokeLLL.booleanValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putNext(Waiter waiter, Waiter waiter2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, waiter, waiter2) == null) {
                this.waiterNextUpdater.lazySet(waiter, waiter2);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putThread(Waiter waiter, Thread thread) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, waiter, thread) == null) {
                this.waiterThreadUpdater.lazySet(waiter, thread);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class SetFuture<V> implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ListenableFuture<? extends V> future;
        public final AbstractFuture<V> owner;

        public SetFuture(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractFuture, listenableFuture};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.owner = abstractFuture;
            this.future = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.owner.value == this) {
                if (AbstractFuture.ATOMIC_HELPER.casValue(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
                    AbstractFuture.complete(this.owner);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class SynchronizedHelper extends AtomicHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedHelper() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casListeners(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, abstractFuture, listener, listener2)) == null) {
                synchronized (abstractFuture) {
                    if (abstractFuture.listeners == listener) {
                        abstractFuture.listeners = listener2;
                        return true;
                    }
                    return false;
                }
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casValue(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abstractFuture, obj, obj2)) == null) {
                synchronized (abstractFuture) {
                    if (abstractFuture.value == obj) {
                        abstractFuture.value = obj2;
                        return true;
                    }
                    return false;
                }
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casWaiters(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, abstractFuture, waiter, waiter2)) == null) {
                synchronized (abstractFuture) {
                    if (abstractFuture.waiters == waiter) {
                        abstractFuture.waiters = waiter2;
                        return true;
                    }
                    return false;
                }
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putNext(Waiter waiter, Waiter waiter2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, waiter, waiter2) == null) {
                waiter.next = waiter2;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putThread(Waiter waiter, Thread thread) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, waiter, thread) == null) {
                waiter.thread = thread;
            }
        }

        public /* synthetic */ SynchronizedHelper(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public interface Trusted<V> extends ListenableFuture<V> {
    }

    /* loaded from: classes6.dex */
    public static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public TrustedFuture() {
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

        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable runnable, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, executor) == null) {
                super.addListener(runnable, executor);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? super.cancel(z) : invokeZ.booleanValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get() throws InterruptedException, ExecutionException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (V) super.get() : (V) invokeV.objValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? super.isCancelled() : invokeV.booleanValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? super.isDone() : invokeV.booleanValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJL = interceptable.invokeJL(1048579, this, j, timeUnit)) == null) ? (V) super.get(j, timeUnit) : (V) invokeJL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class UnsafeAtomicHelper extends AtomicHelper {
        public static /* synthetic */ Interceptable $ic;
        public static final long LISTENERS_OFFSET;
        public static final Unsafe UNSAFE;
        public static final long VALUE_OFFSET;
        public static final long WAITERS_OFFSET;
        public static final long WAITER_NEXT_OFFSET;
        public static final long WAITER_THREAD_OFFSET;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            Unsafe unsafe;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1693911664, "Lcom/google/common/util/concurrent/AbstractFuture$UnsafeAtomicHelper;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1693911664, "Lcom/google/common/util/concurrent/AbstractFuture$UnsafeAtomicHelper;");
                    return;
                }
            }
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.security.PrivilegedExceptionAction
                    public Unsafe run() throws Exception {
                        InterceptResult invokeV;
                        Field[] declaredFields;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                        return (Unsafe) invokeV.objValue;
                    }
                });
            }
            try {
                WAITERS_OFFSET = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
                LISTENERS_OFFSET = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
                VALUE_OFFSET = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));
                WAITER_THREAD_OFFSET = unsafe.objectFieldOffset(Waiter.class.getDeclaredField("thread"));
                WAITER_NEXT_OFFSET = unsafe.objectFieldOffset(Waiter.class.getDeclaredField(UnitedSchemeConstants.UNITED_SCHEME_NEXT));
                UNSAFE = unsafe;
            } catch (Exception e3) {
                s.f(e3);
                throw new RuntimeException(e3);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnsafeAtomicHelper() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casListeners(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, abstractFuture, listener, listener2)) == null) ? UNSAFE.compareAndSwapObject(abstractFuture, LISTENERS_OFFSET, listener, listener2) : invokeLLL.booleanValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casValue(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abstractFuture, obj, obj2)) == null) ? UNSAFE.compareAndSwapObject(abstractFuture, VALUE_OFFSET, obj, obj2) : invokeLLL.booleanValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casWaiters(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, abstractFuture, waiter, waiter2)) == null) ? UNSAFE.compareAndSwapObject(abstractFuture, WAITERS_OFFSET, waiter, waiter2) : invokeLLL.booleanValue;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putNext(Waiter waiter, Waiter waiter2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, waiter, waiter2) == null) {
                UNSAFE.putObject(waiter, WAITER_NEXT_OFFSET, waiter2);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putThread(Waiter waiter, Thread thread) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, waiter, thread) == null) {
                UNSAFE.putObject(waiter, WAITER_THREAD_OFFSET, thread);
            }
        }

        public /* synthetic */ UnsafeAtomicHelper(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class Waiter {
        public static /* synthetic */ Interceptable $ic;
        public static final Waiter TOMBSTONE;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile Waiter next;
        public volatile Thread thread;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-779416979, "Lcom/google/common/util/concurrent/AbstractFuture$Waiter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-779416979, "Lcom/google/common/util/concurrent/AbstractFuture$Waiter;");
                    return;
                }
            }
            TOMBSTONE = new Waiter(false);
        }

        public Waiter(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                }
            }
        }

        public void setNext(Waiter waiter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, waiter) == null) {
                AbstractFuture.ATOMIC_HELPER.putNext(this, waiter);
            }
        }

        public void unpark() {
            Thread thread;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (thread = this.thread) == null) {
                return;
            }
            this.thread = null;
            LockSupport.unpark(thread);
        }

        public Waiter() {
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
            AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }
    }

    static {
        InterceptResult invokeClinit;
        AtomicHelper synchronizedHelper;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1625899101, "Lcom/google/common/util/concurrent/AbstractFuture;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1625899101, "Lcom/google/common/util/concurrent/AbstractFuture;");
                return;
            }
        }
        GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        log = Logger.getLogger(AbstractFuture.class.getName());
        Throwable th = null;
        try {
            synchronizedHelper = new UnsafeAtomicHelper(null);
            th = null;
        } catch (Throwable th2) {
            th = th2;
            try {
                synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, UnitedSchemeConstants.UNITED_SCHEME_NEXT), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));
            } catch (Throwable th3) {
                synchronizedHelper = new SynchronizedHelper(null);
                th = th3;
            }
        }
        ATOMIC_HELPER = synchronizedHelper;
        if (th != null) {
            log.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", th);
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    public AbstractFuture() {
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

    private void addDoneString(StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, sb) == null) {
            try {
                Object uninterruptibly = getUninterruptibly(this);
                sb.append("SUCCESS, result=[");
                sb.append(userObjectToString(uninterruptibly));
                sb.append(PreferencesUtil.RIGHT_MOUNT);
            } catch (CancellationException unused) {
                sb.append("CANCELLED");
            } catch (RuntimeException e2) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e2.getClass());
                sb.append(" thrown from get()]");
            } catch (ExecutionException e3) {
                sb.append("FAILURE, cause=[");
                sb.append(e3.getCause());
                sb.append(PreferencesUtil.RIGHT_MOUNT);
            }
        }
    }

    public static CancellationException cancellationExceptionWithCause(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, th)) == null) {
            CancellationException cancellationException = new CancellationException(str);
            cancellationException.initCause(th);
            return cancellationException;
        }
        return (CancellationException) invokeLL.objValue;
    }

    private Listener clearListeners(Listener listener) {
        Listener listener2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, listener)) == null) {
            do {
                listener2 = this.listeners;
            } while (!ATOMIC_HELPER.casListeners(this, listener2, Listener.TOMBSTONE));
            Listener listener3 = listener;
            Listener listener4 = listener2;
            while (listener4 != null) {
                Listener listener5 = listener4.next;
                listener4.next = listener3;
                listener3 = listener4;
                listener4 = listener5;
            }
            return listener3;
        }
        return (Listener) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0005 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.common.util.concurrent.AbstractFuture$AtomicHelper] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.common.util.concurrent.AbstractFuture<?>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.util.concurrent.AbstractFuture] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.google.common.util.concurrent.AbstractFuture<V>, com.google.common.util.concurrent.AbstractFuture] */
    public static void complete(AbstractFuture<?> abstractFuture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, abstractFuture) == null) {
            Listener listener = null;
            while (true) {
                abstractFuture.releaseWaiters();
                abstractFuture.afterDone();
                Listener clearListeners = abstractFuture.clearListeners(listener);
                while (clearListeners != null) {
                    listener = clearListeners.next;
                    Runnable runnable = clearListeners.task;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        abstractFuture = setFuture.owner;
                        if (abstractFuture.value == setFuture) {
                            if (ATOMIC_HELPER.casValue(abstractFuture, setFuture, getFutureValue(setFuture.future))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        executeListener(runnable, clearListeners.executor);
                    }
                    clearListeners = listener;
                }
                return;
            }
        }
    }

    public static void executeListener(Runnable runnable, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, runnable, executor) == null) {
            try {
                executor.execute(runnable);
            } catch (RuntimeException e2) {
                Logger logger = log;
                Level level = Level.SEVERE;
                logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object obj) throws ExecutionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, obj)) == null) {
            if (!(obj instanceof Cancellation)) {
                if (!(obj instanceof Failure)) {
                    if (obj == NULL) {
                        return null;
                    }
                    return obj;
                }
                throw new ExecutionException(((Failure) obj).exception);
            }
            throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) obj).cause);
        }
        return (V) invokeL.objValue;
    }

    public static Object getFutureValue(ListenableFuture<?> listenableFuture) {
        InterceptResult invokeL;
        Throwable tryInternalFastPathGetFailure;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, listenableFuture)) == null) {
            if (listenableFuture instanceof Trusted) {
                Object obj = ((AbstractFuture) listenableFuture).value;
                if (obj instanceof Cancellation) {
                    Cancellation cancellation = (Cancellation) obj;
                    return cancellation.wasInterrupted ? cancellation.cause != null ? new Cancellation(false, cancellation.cause) : Cancellation.CAUSELESS_CANCELLED : obj;
                }
                return obj;
            } else if ((listenableFuture instanceof InternalFutureFailureAccess) && (tryInternalFastPathGetFailure = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) listenableFuture)) != null) {
                return new Failure(tryInternalFastPathGetFailure);
            } else {
                boolean isCancelled = listenableFuture.isCancelled();
                if ((!GENERATE_CANCELLATION_CAUSES) & isCancelled) {
                    return Cancellation.CAUSELESS_CANCELLED;
                }
                try {
                    Object uninterruptibly = getUninterruptibly(listenableFuture);
                    if (!isCancelled) {
                        return uninterruptibly == null ? NULL : uninterruptibly;
                    }
                    return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture));
                } catch (CancellationException e2) {
                    if (!isCancelled) {
                        return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e2));
                    }
                    return new Cancellation(false, e2);
                } catch (ExecutionException e3) {
                    if (isCancelled) {
                        return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture, e3));
                    }
                    return new Failure(e3.getCause());
                } catch (Throwable th) {
                    return new Failure(th);
                }
            }
        }
        return invokeL.objValue;
    }

    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, future)) == null) {
            boolean z = false;
            while (true) {
                try {
                    v = future.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return v;
        }
        return (V) invokeL.objValue;
    }

    private void releaseWaiters() {
        Waiter waiter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            do {
                waiter = this.waiters;
            } while (!ATOMIC_HELPER.casWaiters(this, waiter, Waiter.TOMBSTONE));
            while (waiter != null) {
                waiter.unpark();
                waiter = waiter.next;
            }
        }
    }

    private void removeWaiter(Waiter waiter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, waiter) == null) {
            waiter.thread = null;
            while (true) {
                Waiter waiter2 = this.waiters;
                if (waiter2 == Waiter.TOMBSTONE) {
                    return;
                }
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.next;
                    if (waiter2.thread != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.next = waiter4;
                        if (waiter3.thread == null) {
                            break;
                        }
                    } else if (!ATOMIC_HELPER.casWaiters(this, waiter2, waiter4)) {
                        break;
                    }
                    waiter2 = waiter4;
                }
                return;
            }
        }
    }

    private String userObjectToString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, this, obj)) == null) ? obj == this ? "this future" : String.valueOf(obj) : (String) invokeL.objValue;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        Listener listener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, executor) == null) {
            n.q(runnable, "Runnable was null.");
            n.q(executor, "Executor was null.");
            if (!isDone() && (listener = this.listeners) != Listener.TOMBSTONE) {
                Listener listener2 = new Listener(runnable, executor);
                do {
                    listener2.next = listener;
                    if (ATOMIC_HELPER.casListeners(this, listener, listener2)) {
                        return;
                    }
                    listener = this.listeners;
                } while (listener != Listener.TOMBSTONE);
                executeListener(runnable, executor);
            }
            executeListener(runnable, executor);
        }
    }

    public void afterDone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) != null) {
            return invokeZ.booleanValue;
        }
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        Cancellation cancellation = GENERATE_CANCELLATION_CAUSES ? new Cancellation(z, new CancellationException("Future.cancel() was called.")) : z ? Cancellation.CAUSELESS_INTERRUPTED : Cancellation.CAUSELESS_CANCELLED;
        boolean z2 = false;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (ATOMIC_HELPER.casValue(abstractFuture, obj, cancellation)) {
                if (z) {
                    abstractFuture.interruptTask();
                }
                complete(abstractFuture);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).future;
                if (listenableFuture instanceof Trusted) {
                    abstractFuture = (AbstractFuture) listenableFuture;
                    obj = abstractFuture.value;
                    if (!(obj == null) && !(obj instanceof SetFuture)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    listenableFuture.cancel(z);
                    return true;
                }
            } else {
                obj = abstractFuture.value;
                if (!(obj instanceof SetFuture)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048580, this, j, timeUnit)) == null) {
            long nanos = timeUnit.toNanos(j);
            if (!Thread.interrupted()) {
                Object obj = this.value;
                if ((obj != null) & (!(obj instanceof SetFuture))) {
                    return getDoneValue(obj);
                }
                long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
                if (nanos >= 1000) {
                    Waiter waiter = this.waiters;
                    if (waiter != Waiter.TOMBSTONE) {
                        Waiter waiter2 = new Waiter();
                        do {
                            waiter2.setNext(waiter);
                            if (ATOMIC_HELPER.casWaiters(this, waiter, waiter2)) {
                                do {
                                    LockSupport.parkNanos(this, nanos);
                                    if (!Thread.interrupted()) {
                                        Object obj2 = this.value;
                                        if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                                            return getDoneValue(obj2);
                                        }
                                        nanos = nanoTime - System.nanoTime();
                                    } else {
                                        removeWaiter(waiter2);
                                        throw new InterruptedException();
                                    }
                                } while (nanos >= 1000);
                                removeWaiter(waiter2);
                            } else {
                                waiter = this.waiters;
                            }
                        } while (waiter != Waiter.TOMBSTONE);
                        return getDoneValue(this.value);
                    }
                    return getDoneValue(this.value);
                }
                while (nanos > 0) {
                    Object obj3 = this.value;
                    if ((obj3 != null) & (!(obj3 instanceof SetFuture))) {
                        return getDoneValue(obj3);
                    }
                    if (!Thread.interrupted()) {
                        nanos = nanoTime - System.nanoTime();
                    } else {
                        throw new InterruptedException();
                    }
                }
                String abstractFuture = toString();
                String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
                String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
                if (nanos + 1000 < 0) {
                    String str2 = str + " (plus ";
                    long j2 = -nanos;
                    long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                    long nanos2 = j2 - timeUnit.toNanos(convert);
                    int i2 = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
                    boolean z = i2 == 0 || nanos2 > 1000;
                    if (i2 > 0) {
                        String str3 = str2 + convert + " " + lowerCase;
                        if (z) {
                            str3 = str3 + ",";
                        }
                        str2 = str3 + " ";
                    }
                    if (z) {
                        str2 = str2 + nanos2 + " nanoseconds ";
                    }
                    str = str2 + "delay)";
                }
                if (isDone()) {
                    throw new TimeoutException(str + " but future completed as timeout expired");
                }
                throw new TimeoutException(str + " for " + abstractFuture);
            }
            throw new InterruptedException();
        }
        return (V) invokeJL.objValue;
    }

    public void interruptTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.value instanceof Cancellation : invokeV.booleanValue;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Object obj = this.value;
            return (!(obj instanceof SetFuture)) & (obj != null);
        }
        return invokeV.booleanValue;
    }

    public final void maybePropagateCancellationTo(Future<?> future) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, future) == null) {
            if ((future != null) && isCancelled()) {
                future.cancel(wasInterrupted());
            }
        }
    }

    public String pendingToString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Object obj = this.value;
            if (obj instanceof SetFuture) {
                return "setFuture=[" + userObjectToString(((SetFuture) obj).future) + PreferencesUtil.RIGHT_MOUNT;
            } else if (this instanceof ScheduledFuture) {
                return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
            } else {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean set(V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, v)) == null) {
            if (v == null) {
                v = (V) NULL;
            }
            if (ATOMIC_HELPER.casValue(this, null, v)) {
                complete(this);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean setException(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, th)) == null) {
            n.p(th);
            if (ATOMIC_HELPER.casValue(this, null, new Failure(th))) {
                complete(this);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        InterceptResult invokeL;
        Failure failure;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, listenableFuture)) == null) {
            n.p(listenableFuture);
            Object obj = this.value;
            if (obj == null) {
                if (listenableFuture.isDone()) {
                    if (ATOMIC_HELPER.casValue(this, null, getFutureValue(listenableFuture))) {
                        complete(this);
                        return true;
                    }
                    return false;
                }
                SetFuture setFuture = new SetFuture(this, listenableFuture);
                if (ATOMIC_HELPER.casValue(this, null, setFuture)) {
                    try {
                        listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                    } catch (Throwable th) {
                        try {
                            failure = new Failure(th);
                        } catch (Throwable unused) {
                            failure = Failure.FALLBACK_INSTANCE;
                        }
                        ATOMIC_HELPER.casValue(this, setFuture, failure);
                    }
                    return true;
                }
                obj = this.value;
            }
            if (obj instanceof Cancellation) {
                listenableFuture.cancel(((Cancellation) obj).wasInterrupted);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("[status=");
            if (isCancelled()) {
                sb.append("CANCELLED");
            } else if (isDone()) {
                addDoneString(sb);
            } else {
                try {
                    str = pendingToString();
                } catch (RuntimeException e2) {
                    str = "Exception thrown from implementation: " + e2.getClass();
                }
                if (str != null && !str.isEmpty()) {
                    sb.append("PENDING, info=[");
                    sb.append(str);
                    sb.append(PreferencesUtil.RIGHT_MOUNT);
                } else if (isDone()) {
                    addDoneString(sb);
                } else {
                    sb.append("PENDING");
                }
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.google.common.util.concurrent.internal.InternalFutureFailureAccess
    public final Throwable tryInternalFastPathGetFailure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this instanceof Trusted) {
                Object obj = this.value;
                if (obj instanceof Failure) {
                    return ((Failure) obj).exception;
                }
                return null;
            }
            return null;
        }
        return (Throwable) invokeV.objValue;
    }

    public final boolean wasInterrupted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Object obj = this.value;
            return (obj instanceof Cancellation) && ((Cancellation) obj).wasInterrupted;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        InterceptResult invokeV;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!Thread.interrupted()) {
                Object obj2 = this.value;
                if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                    return getDoneValue(obj2);
                }
                Waiter waiter = this.waiters;
                if (waiter != Waiter.TOMBSTONE) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.setNext(waiter);
                        if (ATOMIC_HELPER.casWaiters(this, waiter, waiter2)) {
                            do {
                                LockSupport.park(this);
                                if (!Thread.interrupted()) {
                                    obj = this.value;
                                } else {
                                    removeWaiter(waiter2);
                                    throw new InterruptedException();
                                }
                            } while (!((obj != null) & (!(obj instanceof SetFuture))));
                            return getDoneValue(obj);
                        }
                        waiter = this.waiters;
                    } while (waiter != Waiter.TOMBSTONE);
                    return getDoneValue(this.value);
                }
                return getDoneValue(this.value);
            }
            throw new InterruptedException();
        }
        return (V) invokeV.objValue;
    }
}
