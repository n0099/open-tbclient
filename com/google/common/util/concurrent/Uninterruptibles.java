package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
/* loaded from: classes2.dex */
public final class Uninterruptibles {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Uninterruptibles() {
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

    public static void awaitUninterruptibly(CountDownLatch countDownLatch) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, countDownLatch) == null) {
            boolean z = false;
            while (true) {
                try {
                    countDownLatch.await();
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
        }
    }

    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, future)) == null) {
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

    public static void joinUninterruptibly(Thread thread) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, thread) == null) {
            boolean z = false;
            while (true) {
                try {
                    thread.join();
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
        }
    }

    public static <E> void putUninterruptibly(BlockingQueue<E> blockingQueue, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, blockingQueue, e2) == null) {
            boolean z = false;
            while (true) {
                try {
                    blockingQueue.put(e2);
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
        }
    }

    public static void sleepUninterruptibly(long j2, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65545, null, j2, timeUnit) == null) {
            boolean z = false;
            try {
                long nanos = timeUnit.toNanos(j2);
                long nanoTime = System.nanoTime() + nanos;
                while (true) {
                    try {
                        TimeUnit.NANOSECONDS.sleep(nanos);
                        break;
                    } catch (InterruptedException unused) {
                        z = true;
                        nanos = nanoTime - System.nanoTime();
                    }
                }
            } finally {
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static <E> E takeUninterruptibly(BlockingQueue<E> blockingQueue) {
        InterceptResult invokeL;
        E take;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, blockingQueue)) == null) {
            boolean z = false;
            while (true) {
                try {
                    take = blockingQueue.take();
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
            return take;
        }
        return (E) invokeL.objValue;
    }

    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{semaphore, Long.valueOf(j2), timeUnit})) == null) ? tryAcquireUninterruptibly(semaphore, 1, j2, timeUnit) : invokeCommon.booleanValue;
    }

    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, int i2, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{semaphore, Integer.valueOf(i2), Long.valueOf(j2), timeUnit})) == null) {
            boolean z = false;
            try {
                long nanos = timeUnit.toNanos(j2);
                while (true) {
                    try {
                        break;
                    } catch (InterruptedException unused) {
                        z = true;
                        nanos = (System.nanoTime() + nanos) - System.nanoTime();
                    }
                }
                return semaphore.tryAcquire(i2, nanos, TimeUnit.NANOSECONDS);
            } finally {
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{countDownLatch, Long.valueOf(j2), timeUnit})) == null) {
            boolean z = false;
            try {
                long nanos = timeUnit.toNanos(j2);
                while (true) {
                    try {
                        break;
                    } catch (InterruptedException unused) {
                        z = true;
                        nanos = (System.nanoTime() + nanos) - System.nanoTime();
                    }
                }
                return countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
            } finally {
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    public static <V> V getUninterruptibly(Future<V> future, long j2, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{future, Long.valueOf(j2), timeUnit})) == null) {
            boolean z = false;
            try {
                long nanos = timeUnit.toNanos(j2);
                while (true) {
                    try {
                        break;
                    } catch (InterruptedException unused) {
                        z = true;
                        nanos = (System.nanoTime() + nanos) - System.nanoTime();
                    }
                }
                return future.get(nanos, TimeUnit.NANOSECONDS);
            } finally {
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return (V) invokeCommon.objValue;
    }

    public static void joinUninterruptibly(Thread thread, long j2, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{thread, Long.valueOf(j2), timeUnit}) == null) {
            n.p(thread);
            boolean z = false;
            try {
                long nanos = timeUnit.toNanos(j2);
                long nanoTime = System.nanoTime() + nanos;
                while (true) {
                    try {
                        TimeUnit.NANOSECONDS.timedJoin(thread, nanos);
                        break;
                    } catch (InterruptedException unused) {
                        z = true;
                        nanos = nanoTime - System.nanoTime();
                    }
                }
            } finally {
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static boolean awaitUninterruptibly(Condition condition, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{condition, Long.valueOf(j2), timeUnit})) == null) {
            boolean z = false;
            try {
                long nanos = timeUnit.toNanos(j2);
                while (true) {
                    try {
                        break;
                    } catch (InterruptedException unused) {
                        z = true;
                        nanos = (System.nanoTime() + nanos) - System.nanoTime();
                    }
                }
                return condition.await(nanos, TimeUnit.NANOSECONDS);
            } finally {
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return invokeCommon.booleanValue;
    }
}
