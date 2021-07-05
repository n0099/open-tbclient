package com.google.common.util.concurrent;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import d.f.d.a.j;
import d.f.d.a.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes7.dex */
public class CycleDetectingLockFactory {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadLocal<ArrayList<LockGraphNode>> acquiredLocks;
    public static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, LockGraphNode>> lockGraphNodesPerType;
    public static final Logger logger;
    public transient /* synthetic */ FieldHolder $fh;
    public final Policy policy;

    /* loaded from: classes7.dex */
    public interface CycleDetectingLock {
        LockGraphNode getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    /* loaded from: classes7.dex */
    public final class CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LockGraphNode lockGraphNode;
        public final /* synthetic */ CycleDetectingLockFactory this$0;

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public LockGraphNode getLockGraphNode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.lockGraphNode : (LockGraphNode) invokeV.objValue;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public boolean isAcquiredByCurrentThread() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? isHeldByCurrentThread() : invokeV.booleanValue;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.this$0.aboutToAcquire(this);
                try {
                    super.lock();
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this);
                }
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.this$0.aboutToAcquire(this);
                try {
                    super.lockInterruptibly();
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this);
                }
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.this$0.aboutToAcquire(this);
                try {
                    return super.tryLock();
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this);
                }
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                try {
                    super.unlock();
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CycleDetectingReentrantLock(CycleDetectingLockFactory cycleDetectingLockFactory, LockGraphNode lockGraphNode, boolean z) {
            super(z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cycleDetectingLockFactory, lockGraphNode, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cycleDetectingLockFactory;
            n.p(lockGraphNode);
            this.lockGraphNode = lockGraphNode;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048581, this, j, timeUnit)) == null) {
                this.this$0.aboutToAcquire(this);
                try {
                    return super.tryLock(j, timeUnit);
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this);
                }
            }
            return invokeJL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LockGraphNode lockGraphNode;
        public final CycleDetectingReentrantReadLock readLock;
        public final /* synthetic */ CycleDetectingLockFactory this$0;
        public final CycleDetectingReentrantWriteLock writeLock;

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public LockGraphNode getLockGraphNode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.lockGraphNode : (LockGraphNode) invokeV.objValue;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public boolean isAcquiredByCurrentThread() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? isWriteLockedByCurrentThread() || getReadHoldCount() > 0 : invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory cycleDetectingLockFactory, LockGraphNode lockGraphNode, boolean z) {
            super(z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cycleDetectingLockFactory, lockGraphNode, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cycleDetectingLockFactory;
            this.readLock = new CycleDetectingReentrantReadLock(cycleDetectingLockFactory, this);
            this.writeLock = new CycleDetectingReentrantWriteLock(cycleDetectingLockFactory, this);
            n.p(lockGraphNode);
            this.lockGraphNode = lockGraphNode;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.ReadLock readLock() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.readLock : (ReentrantReadWriteLock.ReadLock) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.WriteLock writeLock() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.writeLock : (ReentrantReadWriteLock.WriteLock) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class ExampleStackTrace extends IllegalStateException {
        public static /* synthetic */ Interceptable $ic;
        public static final StackTraceElement[] EMPTY_STACK_TRACE;
        public static final ImmutableSet<String> EXCLUDED_CLASS_NAMES;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1575329211, "Lcom/google/common/util/concurrent/CycleDetectingLockFactory$ExampleStackTrace;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1575329211, "Lcom/google/common/util/concurrent/CycleDetectingLockFactory$ExampleStackTrace;");
                    return;
                }
            }
            EMPTY_STACK_TRACE = new StackTraceElement[0];
            EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), LockGraphNode.class.getName());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExampleStackTrace(LockGraphNode lockGraphNode, LockGraphNode lockGraphNode2) {
            super(lockGraphNode.getLockName() + LoadErrorCode.TOKEN_NEXT + lockGraphNode2.getLockName());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lockGraphNode, lockGraphNode2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (WithExplicitOrdering.class.getName().equals(stackTrace[i4].getClassName())) {
                    setStackTrace(EMPTY_STACK_TRACE);
                    return;
                } else if (!EXCLUDED_CLASS_NAMES.contains(stackTrace[i4].getClassName())) {
                    setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i4, length));
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class LockGraphNode {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<LockGraphNode, ExampleStackTrace> allowedPriorLocks;
        public final Map<LockGraphNode, PotentialDeadlockException> disallowedPriorLocks;
        public final String lockName;

        public LockGraphNode(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            MapMaker mapMaker = new MapMaker();
            mapMaker.l();
            this.allowedPriorLocks = mapMaker.i();
            MapMaker mapMaker2 = new MapMaker();
            mapMaker2.l();
            this.disallowedPriorLocks = mapMaker2.i();
            n.p(str);
            this.lockName = str;
        }

        private ExampleStackTrace findPathTo(LockGraphNode lockGraphNode, Set<LockGraphNode> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, lockGraphNode, set)) == null) {
                if (set.add(this)) {
                    ExampleStackTrace exampleStackTrace = this.allowedPriorLocks.get(lockGraphNode);
                    if (exampleStackTrace != null) {
                        return exampleStackTrace;
                    }
                    for (Map.Entry<LockGraphNode, ExampleStackTrace> entry : this.allowedPriorLocks.entrySet()) {
                        LockGraphNode key = entry.getKey();
                        ExampleStackTrace findPathTo = key.findPathTo(lockGraphNode, set);
                        if (findPathTo != null) {
                            ExampleStackTrace exampleStackTrace2 = new ExampleStackTrace(key, this);
                            exampleStackTrace2.setStackTrace(entry.getValue().getStackTrace());
                            exampleStackTrace2.initCause(findPathTo);
                            return exampleStackTrace2;
                        }
                    }
                    return null;
                }
                return null;
            }
            return (ExampleStackTrace) invokeLL.objValue;
        }

        public void checkAcquiredLock(Policy policy, LockGraphNode lockGraphNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, policy, lockGraphNode) == null) {
                n.A(this != lockGraphNode, "Attempted to acquire multiple locks with the same rank %s", lockGraphNode.getLockName());
                if (this.allowedPriorLocks.containsKey(lockGraphNode)) {
                    return;
                }
                PotentialDeadlockException potentialDeadlockException = this.disallowedPriorLocks.get(lockGraphNode);
                if (potentialDeadlockException != null) {
                    policy.handlePotentialDeadlock(new PotentialDeadlockException(lockGraphNode, this, potentialDeadlockException.getConflictingStackTrace()));
                    return;
                }
                ExampleStackTrace findPathTo = lockGraphNode.findPathTo(this, Sets.h());
                if (findPathTo == null) {
                    this.allowedPriorLocks.put(lockGraphNode, new ExampleStackTrace(lockGraphNode, this));
                    return;
                }
                PotentialDeadlockException potentialDeadlockException2 = new PotentialDeadlockException(lockGraphNode, this, findPathTo);
                this.disallowedPriorLocks.put(lockGraphNode, potentialDeadlockException2);
                policy.handlePotentialDeadlock(potentialDeadlockException2);
            }
        }

        public void checkAcquiredLocks(Policy policy, List<LockGraphNode> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, policy, list) == null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    checkAcquiredLock(policy, list.get(i2));
                }
            }
        }

        public String getLockName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.lockName : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static abstract class Policies implements Policy {
        public static final /* synthetic */ Policies[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Policies DISABLED;
        public static final Policies THROW;
        public static final Policies WARN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(784312314, "Lcom/google/common/util/concurrent/CycleDetectingLockFactory$Policies;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(784312314, "Lcom/google/common/util/concurrent/CycleDetectingLockFactory$Policies;");
                    return;
                }
            }
            THROW = new Policies("THROW", 0) { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
                public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, potentialDeadlockException) == null) {
                        throw potentialDeadlockException;
                    }
                }
            };
            WARN = new Policies("WARN", 1) { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
                public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, potentialDeadlockException) == null) {
                        CycleDetectingLockFactory.logger.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
                    }
                }
            };
            Policies policies = new Policies("DISABLED", 2) { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
                public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, potentialDeadlockException) == null) {
                    }
                }
            };
            DISABLED = policies;
            $VALUES = new Policies[]{THROW, WARN, policies};
        }

        public Policies(String str, int i2) {
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

        public static Policies valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Policies) Enum.valueOf(Policies.class, str) : (Policies) invokeL.objValue;
        }

        public static Policies[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? (Policies[]) $VALUES.clone() : (Policies[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface Policy {
        void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);
    }

    /* loaded from: classes7.dex */
    public static final class PotentialDeadlockException extends ExampleStackTrace {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ExampleStackTrace conflictingStackTrace;

        public ExampleStackTrace getConflictingStackTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.conflictingStackTrace : (ExampleStackTrace) invokeV.objValue;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuilder sb = new StringBuilder(super.getMessage());
                for (Throwable th = this.conflictingStackTrace; th != null; th = th.getCause()) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(th.getMessage());
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PotentialDeadlockException(LockGraphNode lockGraphNode, LockGraphNode lockGraphNode2, ExampleStackTrace exampleStackTrace) {
            super(lockGraphNode, lockGraphNode2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lockGraphNode, lockGraphNode2, exampleStackTrace};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((LockGraphNode) objArr2[0], (LockGraphNode) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.conflictingStackTrace = exampleStackTrace;
            initCause(exampleStackTrace);
        }
    }

    /* loaded from: classes7.dex */
    public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<E, LockGraphNode> lockGraphNodes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WithExplicitOrdering(Policy policy, Map<E, LockGraphNode> map) {
            super(policy);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {policy, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Policy) objArr2[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.lockGraphNodes = map;
        }

        public ReentrantLock newReentrantLock(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) ? newReentrantLock((WithExplicitOrdering<E>) e2, false) : (ReentrantLock) invokeL.objValue;
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2)) == null) ? newReentrantReadWriteLock((WithExplicitOrdering<E>) e2, false) : (ReentrantReadWriteLock) invokeL.objValue;
        }

        public ReentrantLock newReentrantLock(E e2, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2, z)) == null) ? this.policy == Policies.DISABLED ? new ReentrantLock(z) : new CycleDetectingReentrantLock(this.lockGraphNodes.get(e2), z) : (ReentrantLock) invokeLZ.objValue;
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E e2, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, e2, z)) == null) ? this.policy == Policies.DISABLED ? new ReentrantReadWriteLock(z) : new CycleDetectingReentrantReadWriteLock(this.lockGraphNodes.get(e2), z) : (ReentrantReadWriteLock) invokeLZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-310636536, "Lcom/google/common/util/concurrent/CycleDetectingLockFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-310636536, "Lcom/google/common/util/concurrent/CycleDetectingLockFactory;");
                return;
            }
        }
        MapMaker mapMaker = new MapMaker();
        mapMaker.l();
        lockGraphNodesPerType = mapMaker.i();
        logger = Logger.getLogger(CycleDetectingLockFactory.class.getName());
        acquiredLocks = new ThreadLocal<ArrayList<LockGraphNode>>() { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.1
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
            @Override // java.lang.ThreadLocal
            public ArrayList<LockGraphNode> initialValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Lists.l(3) : (ArrayList) invokeV.objValue;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aboutToAcquire(CycleDetectingLock cycleDetectingLock) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, cycleDetectingLock) == null) || cycleDetectingLock.isAcquiredByCurrentThread()) {
            return;
        }
        ArrayList<LockGraphNode> arrayList = acquiredLocks.get();
        LockGraphNode lockGraphNode = cycleDetectingLock.getLockGraphNode();
        lockGraphNode.checkAcquiredLocks(this.policy, arrayList);
        arrayList.add(lockGraphNode);
    }

    public static <E extends Enum<E>> Map<E, LockGraphNode> createNodes(Class<E> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) {
            EnumMap r = Maps.r(cls);
            E[] enumConstants = cls.getEnumConstants();
            int length = enumConstants.length;
            ArrayList l = Lists.l(length);
            int i2 = 0;
            for (E e2 : enumConstants) {
                LockGraphNode lockGraphNode = new LockGraphNode(getLockName(e2));
                l.add(lockGraphNode);
                r.put((EnumMap) e2, (E) lockGraphNode);
            }
            for (int i3 = 1; i3 < length; i3++) {
                ((LockGraphNode) l.get(i3)).checkAcquiredLocks(Policies.THROW, l.subList(0, i3));
            }
            while (i2 < length - 1) {
                i2++;
                ((LockGraphNode) l.get(i2)).checkAcquiredLocks(Policies.DISABLED, l.subList(i2, length));
            }
            return Collections.unmodifiableMap(r);
        }
        return (Map) invokeL.objValue;
    }

    public static String getLockName(Enum<?> r4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, r4)) == null) {
            return r4.getDeclaringClass().getSimpleName() + "." + r4.name();
        }
        return (String) invokeL.objValue;
    }

    public static Map<? extends Enum, LockGraphNode> getOrCreateNodes(Class<? extends Enum> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) {
            Map<? extends Enum, LockGraphNode> map = lockGraphNodesPerType.get(cls);
            if (map != null) {
                return map;
            }
            Map<? extends Enum, LockGraphNode> createNodes = createNodes(cls);
            return (Map) j.a(lockGraphNodesPerType.putIfAbsent(cls, createNodes), createNodes);
        }
        return (Map) invokeL.objValue;
    }

    public static void lockStateChanged(CycleDetectingLock cycleDetectingLock) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, cycleDetectingLock) == null) || cycleDetectingLock.isAcquiredByCurrentThread()) {
            return;
        }
        ArrayList<LockGraphNode> arrayList = acquiredLocks.get();
        LockGraphNode lockGraphNode = cycleDetectingLock.getLockGraphNode();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == lockGraphNode) {
                arrayList.remove(size);
                return;
            }
        }
    }

    public static CycleDetectingLockFactory newInstance(Policy policy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, policy)) == null) ? new CycleDetectingLockFactory(policy) : (CycleDetectingLockFactory) invokeL.objValue;
    }

    public static <E extends Enum<E>> WithExplicitOrdering<E> newInstanceWithExplicitOrdering(Class<E> cls, Policy policy) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, cls, policy)) == null) {
            n.p(cls);
            n.p(policy);
            return new WithExplicitOrdering<>(policy, getOrCreateNodes(cls));
        }
        return (WithExplicitOrdering) invokeLL.objValue;
    }

    public ReentrantLock newReentrantLock(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? newReentrantLock(str, false) : (ReentrantLock) invokeL.objValue;
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? newReentrantReadWriteLock(str, false) : (ReentrantReadWriteLock) invokeL.objValue;
    }

    public CycleDetectingLockFactory(Policy policy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {policy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        n.p(policy);
        this.policy = policy;
    }

    public ReentrantLock newReentrantLock(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) ? this.policy == Policies.DISABLED ? new ReentrantLock(z) : new CycleDetectingReentrantLock(new LockGraphNode(str), z) : (ReentrantLock) invokeLZ.objValue;
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) ? this.policy == Policies.DISABLED ? new ReentrantReadWriteLock(z) : new CycleDetectingReentrantReadWriteLock(new LockGraphNode(str), z) : (ReentrantReadWriteLock) invokeLZ.objValue;
    }

    /* loaded from: classes7.dex */
    public class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CycleDetectingReentrantReadWriteLock readWriteLock;
        public final /* synthetic */ CycleDetectingLockFactory this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CycleDetectingReentrantReadLock(CycleDetectingLockFactory cycleDetectingLockFactory, CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cycleDetectingLockFactory, cycleDetectingReentrantReadWriteLock};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ReentrantReadWriteLock) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cycleDetectingLockFactory;
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.aboutToAcquire(this.readWriteLock);
                try {
                    super.lock();
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
                }
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.aboutToAcquire(this.readWriteLock);
                try {
                    super.lockInterruptibly();
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
                }
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.this$0.aboutToAcquire(this.readWriteLock);
                try {
                    return super.tryLock();
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
                }
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                try {
                    super.unlock();
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
                }
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048579, this, j, timeUnit)) == null) {
                this.this$0.aboutToAcquire(this.readWriteLock);
                try {
                    return super.tryLock(j, timeUnit);
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
                }
            }
            return invokeJL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CycleDetectingReentrantReadWriteLock readWriteLock;
        public final /* synthetic */ CycleDetectingLockFactory this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CycleDetectingReentrantWriteLock(CycleDetectingLockFactory cycleDetectingLockFactory, CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cycleDetectingLockFactory, cycleDetectingReentrantReadWriteLock};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ReentrantReadWriteLock) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cycleDetectingLockFactory;
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.aboutToAcquire(this.readWriteLock);
                try {
                    super.lock();
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
                }
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.aboutToAcquire(this.readWriteLock);
                try {
                    super.lockInterruptibly();
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
                }
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.this$0.aboutToAcquire(this.readWriteLock);
                try {
                    return super.tryLock();
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
                }
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                try {
                    super.unlock();
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
                }
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048579, this, j, timeUnit)) == null) {
                this.this$0.aboutToAcquire(this.readWriteLock);
                try {
                    return super.tryLock(j, timeUnit);
                } finally {
                    CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
                }
            }
            return invokeJL.booleanValue;
        }
    }
}
