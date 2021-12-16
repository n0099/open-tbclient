package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public final class Monitor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Guard activeGuards;
    public final boolean fair;
    public final ReentrantLock lock;

    /* loaded from: classes3.dex */
    public static abstract class Guard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Condition condition;
        public final Monitor monitor;
        public Guard next;
        public int waiterCount;

        public Guard(Monitor monitor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {monitor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.waiterCount = 0;
            n.q(monitor, "monitor");
            this.monitor = monitor;
            this.condition = monitor.lock.newCondition();
        }

        public abstract boolean isSatisfied();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Monitor() {
        this(false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void await(Guard guard, boolean z) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, this, guard, z) == null) {
            if (z) {
                signalNextWaiter();
            }
            beginWaitingFor(guard);
            do {
                try {
                    guard.condition.await();
                } finally {
                    endWaitingFor(guard);
                }
            } while (!guard.isSatisfied());
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private boolean awaitNanos(Guard guard, long j2, boolean z) throws InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{guard, Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            boolean z2 = true;
            while (j2 > 0) {
                if (z2) {
                    if (z) {
                        try {
                            signalNextWaiter();
                        } finally {
                            if (!z2) {
                                endWaitingFor(guard);
                            }
                        }
                    }
                    beginWaitingFor(guard);
                    z2 = false;
                }
                j2 = guard.condition.awaitNanos(j2);
                if (guard.isSatisfied()) {
                    if (!z2) {
                        endWaitingFor(guard);
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private void awaitUninterruptibly(Guard guard, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, this, guard, z) == null) {
            if (z) {
                signalNextWaiter();
            }
            beginWaitingFor(guard);
            do {
                try {
                    guard.condition.awaitUninterruptibly();
                } finally {
                    endWaitingFor(guard);
                }
            } while (!guard.isSatisfied());
        }
    }

    private void beginWaitingFor(Guard guard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, guard) == null) {
            int i2 = guard.waiterCount;
            guard.waiterCount = i2 + 1;
            if (i2 == 0) {
                guard.next = this.activeGuards;
                this.activeGuards = guard;
            }
        }
    }

    private void endWaitingFor(Guard guard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, guard) == null) {
            int i2 = guard.waiterCount - 1;
            guard.waiterCount = i2;
            if (i2 == 0) {
                Guard guard2 = this.activeGuards;
                Guard guard3 = null;
                while (guard2 != guard) {
                    guard3 = guard2;
                    guard2 = guard2.next;
                }
                if (guard3 == null) {
                    this.activeGuards = guard2.next;
                } else {
                    guard3.next = guard2.next;
                }
                guard2.next = null;
            }
        }
    }

    public static long initNanoTime(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65544, null, j2)) == null) {
            if (j2 <= 0) {
                return 0L;
            }
            long nanoTime = System.nanoTime();
            if (nanoTime == 0) {
                return 1L;
            }
            return nanoTime;
        }
        return invokeJ.longValue;
    }

    private boolean isSatisfied(Guard guard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, guard)) == null) {
            try {
                return guard.isSatisfied();
            } catch (Throwable th) {
                signalAllWaiters();
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    public static long remainingNanos(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (j3 <= 0) {
                return 0L;
            }
            return j3 - (System.nanoTime() - j2);
        }
        return invokeCommon.longValue;
    }

    private void signalAllWaiters() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
                guard.condition.signalAll();
            }
        }
    }

    private void signalNextWaiter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
                if (isSatisfied(guard)) {
                    guard.condition.signal();
                    return;
                }
            }
        }
    }

    public static long toSafeNanos(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65549, null, j2, timeUnit)) == null) {
            long nanos = timeUnit.toNanos(j2);
            if (nanos <= 0) {
                return 0L;
            }
            if (nanos > 6917529027641081853L) {
                return 6917529027641081853L;
            }
            return nanos;
        }
        return invokeJL.longValue;
    }

    public void enter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.lock.lock();
        }
    }

    public boolean enterIf(Guard guard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, guard)) == null) {
            if (guard.monitor == this) {
                ReentrantLock reentrantLock = this.lock;
                reentrantLock.lock();
                try {
                    boolean isSatisfied = guard.isSatisfied();
                    if (!isSatisfied) {
                    }
                    return isSatisfied;
                } finally {
                    reentrantLock.unlock();
                }
            }
            throw new IllegalMonitorStateException();
        }
        return invokeL.booleanValue;
    }

    public boolean enterIfInterruptibly(Guard guard) throws InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, guard)) == null) {
            if (guard.monitor == this) {
                ReentrantLock reentrantLock = this.lock;
                reentrantLock.lockInterruptibly();
                try {
                    boolean isSatisfied = guard.isSatisfied();
                    if (!isSatisfied) {
                    }
                    return isSatisfied;
                } finally {
                    reentrantLock.unlock();
                }
            }
            throw new IllegalMonitorStateException();
        }
        return invokeL.booleanValue;
    }

    public void enterInterruptibly() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.lock.lockInterruptibly();
        }
    }

    public void enterWhen(Guard guard) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, guard) == null) {
            if (guard.monitor == this) {
                ReentrantLock reentrantLock = this.lock;
                boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
                reentrantLock.lockInterruptibly();
                try {
                    if (guard.isSatisfied()) {
                        return;
                    }
                    await(guard, isHeldByCurrentThread);
                    return;
                } catch (Throwable th) {
                    leave();
                    throw th;
                }
            }
            throw new IllegalMonitorStateException();
        }
    }

    public void enterWhenUninterruptibly(Guard guard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, guard) == null) {
            if (guard.monitor == this) {
                ReentrantLock reentrantLock = this.lock;
                boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
                reentrantLock.lock();
                try {
                    if (guard.isSatisfied()) {
                        return;
                    }
                    awaitUninterruptibly(guard, isHeldByCurrentThread);
                    return;
                } catch (Throwable th) {
                    leave();
                    throw th;
                }
            }
            throw new IllegalMonitorStateException();
        }
    }

    public int getOccupiedDepth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.lock.getHoldCount() : invokeV.intValue;
    }

    public int getQueueLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.lock.getQueueLength() : invokeV.intValue;
    }

    public int getWaitQueueLength(Guard guard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, guard)) == null) {
            if (guard.monitor == this) {
                this.lock.lock();
                try {
                    return guard.waiterCount;
                } finally {
                    this.lock.unlock();
                }
            }
            throw new IllegalMonitorStateException();
        }
        return invokeL.intValue;
    }

    public boolean hasQueuedThread(Thread thread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, thread)) == null) ? this.lock.hasQueuedThread(thread) : invokeL.booleanValue;
    }

    public boolean hasQueuedThreads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.lock.hasQueuedThreads() : invokeV.booleanValue;
    }

    public boolean hasWaiters(Guard guard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, guard)) == null) ? getWaitQueueLength(guard) > 0 : invokeL.booleanValue;
    }

    public boolean isFair() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.fair : invokeV.booleanValue;
    }

    public boolean isOccupied() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.lock.isLocked() : invokeV.booleanValue;
    }

    public boolean isOccupiedByCurrentThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.lock.isHeldByCurrentThread() : invokeV.booleanValue;
    }

    public void leave() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ReentrantLock reentrantLock = this.lock;
            try {
                if (reentrantLock.getHoldCount() == 1) {
                    signalNextWaiter();
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public boolean tryEnter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.lock.tryLock() : invokeV.booleanValue;
    }

    public boolean tryEnterIf(Guard guard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, guard)) == null) {
            if (guard.monitor == this) {
                ReentrantLock reentrantLock = this.lock;
                if (reentrantLock.tryLock()) {
                    try {
                        boolean isSatisfied = guard.isSatisfied();
                        if (!isSatisfied) {
                        }
                        return isSatisfied;
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                return false;
            }
            throw new IllegalMonitorStateException();
        }
        return invokeL.booleanValue;
    }

    public void waitFor(Guard guard) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, guard) == null) {
            if ((guard.monitor == this) & this.lock.isHeldByCurrentThread()) {
                if (guard.isSatisfied()) {
                    return;
                }
                await(guard, true);
                return;
            }
            throw new IllegalMonitorStateException();
        }
    }

    public void waitForUninterruptibly(Guard guard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, guard) == null) {
            if ((guard.monitor == this) & this.lock.isHeldByCurrentThread()) {
                if (guard.isSatisfied()) {
                    return;
                }
                awaitUninterruptibly(guard, true);
                return;
            }
            throw new IllegalMonitorStateException();
        }
    }

    public Monitor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.activeGuards = null;
        this.fair = z;
        this.lock = new ReentrantLock(z);
    }

    public boolean enter(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        boolean tryLock;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, timeUnit)) != null) {
            return invokeJL.booleanValue;
        }
        long safeNanos = toSafeNanos(j2, timeUnit);
        ReentrantLock reentrantLock = this.lock;
        boolean z = true;
        if (!this.fair && reentrantLock.tryLock()) {
            return true;
        }
        boolean interrupted = Thread.interrupted();
        try {
            long nanoTime = System.nanoTime();
            long j3 = safeNanos;
            while (true) {
                try {
                    try {
                        tryLock = reentrantLock.tryLock(j3, TimeUnit.NANOSECONDS);
                        break;
                    } catch (Throwable th) {
                        th = th;
                        if (z) {
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    j3 = remainingNanos(nanoTime, safeNanos);
                    interrupted = true;
                }
            }
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
            return tryLock;
        } catch (Throwable th2) {
            th = th2;
            z = interrupted;
        }
    }

    public boolean enterInterruptibly(long j2, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048583, this, j2, timeUnit)) == null) ? this.lock.tryLock(j2, timeUnit) : invokeJL.booleanValue;
    }

    public boolean waitFor(Guard guard, long j2, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{guard, Long.valueOf(j2), timeUnit})) == null) {
            long safeNanos = toSafeNanos(j2, timeUnit);
            if ((guard.monitor == this) & this.lock.isHeldByCurrentThread()) {
                if (guard.isSatisfied()) {
                    return true;
                }
                if (!Thread.interrupted()) {
                    return awaitNanos(guard, safeNanos, true);
                }
                throw new InterruptedException();
            }
            throw new IllegalMonitorStateException();
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean waitForUninterruptibly(Guard guard, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{guard, Long.valueOf(j2), timeUnit})) != null) {
            return invokeCommon.booleanValue;
        }
        long safeNanos = toSafeNanos(j2, timeUnit);
        boolean z = true;
        if ((guard.monitor == this) & this.lock.isHeldByCurrentThread()) {
            if (guard.isSatisfied()) {
                return true;
            }
            long initNanoTime = initNanoTime(safeNanos);
            boolean interrupted = Thread.interrupted();
            long j3 = safeNanos;
            boolean z2 = true;
            while (true) {
                try {
                    try {
                        boolean awaitNanos = awaitNanos(guard, j3, z2);
                        if (interrupted) {
                            Thread.currentThread().interrupt();
                        }
                        return awaitNanos;
                    } catch (Throwable th) {
                        th = th;
                        if (z) {
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    if (guard.isSatisfied()) {
                        Thread.currentThread().interrupt();
                        return true;
                    }
                    j3 = remainingNanos(initNanoTime, safeNanos);
                    interrupted = true;
                    z2 = false;
                } catch (Throwable th2) {
                    th = th2;
                    z = interrupted;
                    if (z) {
                    }
                    throw th;
                }
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean enterIf(Guard guard, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{guard, Long.valueOf(j2), timeUnit})) == null) {
            if (guard.monitor == this) {
                if (enter(j2, timeUnit)) {
                    try {
                        boolean isSatisfied = guard.isSatisfied();
                        if (!isSatisfied) {
                        }
                        return isSatisfied;
                    } finally {
                        this.lock.unlock();
                    }
                }
                return false;
            }
            throw new IllegalMonitorStateException();
        }
        return invokeCommon.booleanValue;
    }

    public boolean enterIfInterruptibly(Guard guard, long j2, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{guard, Long.valueOf(j2), timeUnit})) == null) {
            if (guard.monitor == this) {
                ReentrantLock reentrantLock = this.lock;
                if (reentrantLock.tryLock(j2, timeUnit)) {
                    try {
                        boolean isSatisfied = guard.isSatisfied();
                        if (!isSatisfied) {
                        }
                        return isSatisfied;
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                return false;
            }
            throw new IllegalMonitorStateException();
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
        if (awaitNanos(r11, r0, r3) != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0050 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean enterWhen(Guard guard, long j2, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeCommon;
        long initNanoTime;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{guard, Long.valueOf(j2), timeUnit})) != null) {
            return invokeCommon.booleanValue;
        }
        long safeNanos = toSafeNanos(j2, timeUnit);
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            boolean z = false;
            try {
                if (!this.fair) {
                    if (!Thread.interrupted()) {
                        if (reentrantLock.tryLock()) {
                            initNanoTime = 0;
                            if (!guard.isSatisfied()) {
                                if (initNanoTime != 0) {
                                    safeNanos = remainingNanos(initNanoTime, safeNanos);
                                }
                            }
                            z = true;
                            if (!z) {
                            }
                            return z;
                        }
                    } else {
                        throw new InterruptedException();
                    }
                }
                if (!guard.isSatisfied()) {
                }
                z = true;
                if (!z) {
                }
                return z;
            } catch (Throwable th) {
                if (!isHeldByCurrentThread) {
                    try {
                        signalNextWaiter();
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                throw th;
            }
            initNanoTime = initNanoTime(safeNanos);
            if (!reentrantLock.tryLock(j2, timeUnit)) {
                return false;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f A[Catch: all -> 0x0077, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0077, blocks: (B:7:0x0017, B:9:0x001e, B:26:0x004f, B:31:0x005d, B:32:0x0060, B:13:0x0027, B:15:0x002c, B:17:0x0034, B:22:0x003f, B:24:0x0049, B:23:0x0045), top: B:51:0x0017, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean enterWhenUninterruptibly(Guard guard, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        long initNanoTime;
        long remainingNanos;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{guard, Long.valueOf(j2), timeUnit})) != null) {
            return invokeCommon.booleanValue;
        }
        long safeNanos = toSafeNanos(j2, timeUnit);
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            boolean interrupted = Thread.interrupted();
            boolean z = true;
            try {
                if (!this.fair && reentrantLock.tryLock()) {
                    initNanoTime = 0;
                    while (!guard.isSatisfied()) {
                        try {
                            if (initNanoTime == 0) {
                                initNanoTime = initNanoTime(safeNanos);
                                remainingNanos = safeNanos;
                            } else {
                                remainingNanos = remainingNanos(initNanoTime, safeNanos);
                            }
                            z = awaitNanos(guard, remainingNanos, isHeldByCurrentThread);
                        } catch (InterruptedException unused) {
                            isHeldByCurrentThread = false;
                            interrupted = true;
                        } catch (Throwable th) {
                            reentrantLock.unlock();
                            throw th;
                        }
                    }
                    if (!z) {
                        reentrantLock.unlock();
                    }
                    if (interrupted) {
                        Thread.currentThread().interrupt();
                    }
                    return z;
                }
                initNanoTime = initNanoTime(safeNanos);
                long j3 = safeNanos;
                while (true) {
                    try {
                        try {
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            interrupted = true;
                            if (interrupted) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    } catch (InterruptedException unused2) {
                        j3 = remainingNanos(initNanoTime, safeNanos);
                        interrupted = true;
                    }
                }
                if (!reentrantLock.tryLock(j3, TimeUnit.NANOSECONDS)) {
                    if (interrupted) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                }
                while (!guard.isSatisfied()) {
                }
                if (!z) {
                }
                if (interrupted) {
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }
}
