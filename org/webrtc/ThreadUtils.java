package org.webrtc;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class ThreadUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: org.webrtc.ThreadUtils$1CaughtException  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class C1CaughtException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Exception f61010e;

        public C1CaughtException() {
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

    /* renamed from: org.webrtc.ThreadUtils$1Result  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class C1Result {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public V value;

        public C1Result() {
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

    /* loaded from: classes9.dex */
    public interface BlockingOperation {
        void run() throws InterruptedException;
    }

    /* loaded from: classes9.dex */
    public static class ThreadChecker {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public Thread thread;

        public ThreadChecker() {
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
            this.thread = Thread.currentThread();
        }

        public void checkIsOnValidThread() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.thread == null) {
                    this.thread = Thread.currentThread();
                }
                if (Thread.currentThread() != this.thread) {
                    throw new IllegalStateException("Wrong thread");
                }
            }
        }

        public void detachThread() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.thread = null;
            }
        }
    }

    public ThreadUtils() {
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
            executeUninterruptibly(new BlockingOperation(countDownLatch) { // from class: org.webrtc.ThreadUtils.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CountDownLatch val$latch;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {countDownLatch};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$latch = countDownLatch;
                }

                @Override // org.webrtc.ThreadUtils.BlockingOperation
                public void run() throws InterruptedException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$latch.await();
                    }
                }
            });
        }
    }

    public static void checkIsOnMainThread() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new IllegalStateException("Not on main thread!");
        }
    }

    public static StackTraceElement[] concatStackTraces(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, stackTraceElementArr, stackTraceElementArr2)) == null) {
            StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[stackTraceElementArr.length + stackTraceElementArr2.length];
            System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr3, 0, stackTraceElementArr.length);
            System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, stackTraceElementArr.length, stackTraceElementArr2.length);
            return stackTraceElementArr3;
        }
        return (StackTraceElement[]) invokeLL.objValue;
    }

    public static void executeUninterruptibly(BlockingOperation blockingOperation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, blockingOperation) == null) {
            boolean z = false;
            while (true) {
                try {
                    blockingOperation.run();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static <V> V invokeAtFrontUninterruptibly(Handler handler, Callable<V> callable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, handler, callable)) == null) {
            if (handler.getLooper().getThread() == Thread.currentThread()) {
                try {
                    return callable.call();
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            C1Result c1Result = new C1Result();
            C1CaughtException c1CaughtException = new C1CaughtException();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            handler.post(new Runnable(c1Result, callable, c1CaughtException, countDownLatch) { // from class: org.webrtc.ThreadUtils.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CountDownLatch val$barrier;
                public final /* synthetic */ Callable val$callable;
                public final /* synthetic */ C1CaughtException val$caughtException;
                public final /* synthetic */ C1Result val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1Result, callable, c1CaughtException, countDownLatch};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$result = c1Result;
                    this.val$callable = callable;
                    this.val$caughtException = c1CaughtException;
                    this.val$barrier = countDownLatch;
                }

                /* JADX WARN: Type inference failed for: r1v2, types: [V, java.lang.Object] */
                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.val$result.value = this.val$callable.call();
                        } catch (Exception e3) {
                            this.val$caughtException.f61010e = e3;
                        }
                        this.val$barrier.countDown();
                    }
                }
            });
            awaitUninterruptibly(countDownLatch);
            if (c1CaughtException.f61010e == null) {
                return c1Result.value;
            }
            RuntimeException runtimeException = new RuntimeException(c1CaughtException.f61010e);
            runtimeException.setStackTrace(concatStackTraces(c1CaughtException.f61010e.getStackTrace(), runtimeException.getStackTrace()));
            throw runtimeException;
        }
        return (V) invokeLL.objValue;
    }

    public static boolean joinUninterruptibly(Thread thread, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65545, null, thread, j2)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean z = false;
            long j3 = j2;
            while (j3 > 0) {
                try {
                    thread.join(j3);
                    break;
                } catch (InterruptedException unused) {
                    j3 = j2 - (SystemClock.elapsedRealtime() - elapsedRealtime);
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return !thread.isAlive();
        }
        return invokeLJ.booleanValue;
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, countDownLatch, j2)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean z = false;
            long j3 = j2;
            boolean z2 = false;
            do {
                try {
                    z = countDownLatch.await(j3, TimeUnit.MILLISECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z2 = true;
                    j3 = j2 - (SystemClock.elapsedRealtime() - elapsedRealtime);
                    if (j3 <= 0) {
                    }
                }
            } while (j3 <= 0);
            if (z2) {
                Thread.currentThread().interrupt();
            }
            return z;
        }
        return invokeLJ.booleanValue;
    }

    public static void joinUninterruptibly(Thread thread) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, thread) == null) {
            executeUninterruptibly(new BlockingOperation(thread) { // from class: org.webrtc.ThreadUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Thread val$thread;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {thread};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$thread = thread;
                }

                @Override // org.webrtc.ThreadUtils.BlockingOperation
                public void run() throws InterruptedException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$thread.join();
                    }
                }
            });
        }
    }

    public static void invokeAtFrontUninterruptibly(Handler handler, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, handler, runnable) == null) {
            invokeAtFrontUninterruptibly(handler, new Callable<Void>(runnable) { // from class: org.webrtc.ThreadUtils.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Runnable val$runner;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnable};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$runner = runnable;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        this.val$runner.run();
                        return null;
                    }
                    return (Void) invokeV.objValue;
                }
            });
        }
    }
}
