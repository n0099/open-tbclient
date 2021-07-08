package com.google.common.util.concurrent;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public abstract class AggregateFutureState {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicHelper ATOMIC_HELPER;
    public static final Logger log;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int remaining;
    public volatile Set<Throwable> seenExceptions;

    /* renamed from: com.google.common.util.concurrent.AggregateFutureState$1  reason: invalid class name */
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

        public abstract void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2);

        public abstract int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState);

        public /* synthetic */ AtomicHelper(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class SafeAtomicHelper extends AtomicHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicIntegerFieldUpdater<AggregateFutureState> remainingCountUpdater;
        public final AtomicReferenceFieldUpdater<AggregateFutureState, Set<Throwable>> seenExceptionsUpdater;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReferenceFieldUpdater, atomicIntegerFieldUpdater};
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
            this.seenExceptionsUpdater = atomicReferenceFieldUpdater;
            this.remainingCountUpdater = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, aggregateFutureState, set, set2) == null) {
                this.seenExceptionsUpdater.compareAndSet(aggregateFutureState, set, set2);
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aggregateFutureState)) == null) ? this.remainingCountUpdater.decrementAndGet(aggregateFutureState) : invokeL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class SynchronizedAtomicHelper extends AtomicHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedAtomicHelper() {
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

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, aggregateFutureState, set, set2) == null) {
                synchronized (aggregateFutureState) {
                    if (aggregateFutureState.seenExceptions == set) {
                        aggregateFutureState.seenExceptions = set2;
                    }
                }
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState) {
            InterceptResult invokeL;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aggregateFutureState)) == null) {
                synchronized (aggregateFutureState) {
                    AggregateFutureState.access$310(aggregateFutureState);
                    i2 = aggregateFutureState.remaining;
                }
                return i2;
            }
            return invokeL.intValue;
        }

        public /* synthetic */ SynchronizedAtomicHelper(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        AtomicHelper synchronizedAtomicHelper;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(529587801, "Lcom/google/common/util/concurrent/AggregateFutureState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(529587801, "Lcom/google/common/util/concurrent/AggregateFutureState;");
                return;
            }
        }
        log = Logger.getLogger(AggregateFutureState.class.getName());
        Throwable th = null;
        try {
            synchronizedAtomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining"));
        } catch (Throwable th2) {
            synchronizedAtomicHelper = new SynchronizedAtomicHelper(null);
            th = th2;
        }
        ATOMIC_HELPER = synchronizedAtomicHelper;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    public AggregateFutureState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.seenExceptions = null;
        this.remaining = i2;
    }

    public static /* synthetic */ int access$310(AggregateFutureState aggregateFutureState) {
        int i2 = aggregateFutureState.remaining;
        aggregateFutureState.remaining = i2 - 1;
        return i2;
    }

    public abstract void addInitialException(Set<Throwable> set);

    public final int decrementRemainingAndGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ATOMIC_HELPER.decrementAndGetRemainingCount(this) : invokeV.intValue;
    }

    public final Set<Throwable> getOrInitSeenExceptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Set<Throwable> set = this.seenExceptions;
            if (set == null) {
                Set<Throwable> e2 = Sets.e();
                addInitialException(e2);
                ATOMIC_HELPER.compareAndSetSeenExceptions(this, null, e2);
                return this.seenExceptions;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }
}
