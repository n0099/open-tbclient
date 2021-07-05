package com.kwad.sdk.glide.load.engine.b;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a implements ExecutorService {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final long f38006a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile int f38007b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f38008c;

    /* renamed from: com.kwad.sdk.glide.load.engine.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class ThreadFactoryC0465a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b f38009a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f38010b;

        /* renamed from: c  reason: collision with root package name */
        public final String f38011c;

        /* renamed from: d  reason: collision with root package name */
        public int f38012d;

        public ThreadFactoryC0465a(String str, b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38011c = str;
            this.f38009a = bVar;
            this.f38010b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            InterceptResult invokeL;
            Thread thread;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                synchronized (this) {
                    thread = new Thread(this, runnable, "glide-" + this.f38011c + "-thread-" + this.f38012d) { // from class: com.kwad.sdk.glide.load.engine.b.a.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ThreadFactoryC0465a f38013a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(runnable, r10);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, runnable, r10};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((Runnable) objArr2[0], (String) objArr2[1]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f38013a = this;
                        }

                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Process.setThreadPriority(9);
                                if (this.f38013a.f38010b) {
                                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                                }
                                try {
                                    super.run();
                                } catch (Throwable th) {
                                    this.f38013a.f38009a.a(th);
                                }
                            }
                        }
                    };
                    this.f38012d = this.f38012d + 1;
                }
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f38014a = new b() { // from class: com.kwad.sdk.glide.load.engine.b.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
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

            @Override // com.kwad.sdk.glide.load.engine.b.a.b
            public void a(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                }
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final b f38015b = new b() { // from class: com.kwad.sdk.glide.load.engine.b.a.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
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

            @Override // com.kwad.sdk.glide.load.engine.b.a.b
            public void a(Throwable th) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, th) == null) && th != null && Log.isLoggable(GlideExecutor.TAG, 6)) {
                    Log.e(GlideExecutor.TAG, "Request threw uncaught throwable", th);
                }
            }
        };

        /* renamed from: c  reason: collision with root package name */
        public static final b f38016c = new b() { // from class: com.kwad.sdk.glide.load.engine.b.a.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
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

            @Override // com.kwad.sdk.glide.load.engine.b.a.b
            public void a(Throwable th) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, th) == null) && th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };

        /* renamed from: d  reason: collision with root package name */
        public static final b f38017d = f38015b;

        void a(Throwable th);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-403805552, "Lcom/kwad/sdk/glide/load/engine/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-403805552, "Lcom/kwad/sdk/glide/load/engine/b/a;");
                return;
            }
        }
        f38006a = TimeUnit.SECONDS.toMillis(10L);
    }

    @VisibleForTesting
    public a(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38008c = executorService;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a(1, GlideExecutor.DEFAULT_DISK_CACHE_EXECUTOR_NAME, b.f38017d) : (a) invokeV.objValue;
    }

    public static a a(int i2, b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, bVar)) == null) ? new a(new ThreadPoolExecutor(0, i2, f38006a, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0465a("animation", bVar, true))) : (a) invokeIL.objValue;
    }

    public static a a(int i2, String str, b bVar) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(65540, null, i2, str, bVar)) == null) ? new a(new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0465a(str, bVar, true))) : (a) invokeILL.objValue;
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? b(e(), "source", b.f38017d) : (a) invokeV.objValue;
    }

    public static a b(int i2, String str, b bVar) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(AdIconUtil.BAIDU_LOGO_ID, null, i2, str, bVar)) == null) ? new a(new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0465a(str, bVar, false))) : (a) invokeILL.objValue;
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f38006a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC0465a(GlideExecutor.SOURCE_UNLIMITED_EXECUTOR_NAME, b.f38017d, false))) : (a) invokeV.objValue;
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return a(e() >= 4 ? 2 : 1, b.f38017d);
        }
        return (a) invokeV.objValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f38007b == 0) {
                f38007b = Math.min(4, com.kwad.sdk.glide.load.engine.b.b.a());
            }
            return f38007b;
        }
        return invokeV.intValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? this.f38008c.awaitTermination(j, timeUnit) : invokeJL.booleanValue;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            this.f38008c.execute(runnable);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) ? this.f38008c.invokeAll(collection) : (List) invokeL.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{collection, Long.valueOf(j), timeUnit})) == null) ? this.f38008c.invokeAll(collection, j, timeUnit) : (List) invokeCommon.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, collection)) == null) ? (T) this.f38008c.invokeAny(collection) : (T) invokeL.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{collection, Long.valueOf(j), timeUnit})) == null) ? (T) this.f38008c.invokeAny(collection, j, timeUnit) : (T) invokeCommon.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38008c.isShutdown() : invokeV.booleanValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f38008c.isTerminated() : invokeV.booleanValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f38008c.shutdown();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f38008c.shutdownNow() : (List) invokeV.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, runnable)) == null) ? this.f38008c.submit(runnable) : (Future) invokeL.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, runnable, t)) == null) ? this.f38008c.submit(runnable, t) : (Future) invokeLL.objValue;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, callable)) == null) ? this.f38008c.submit(callable) : (Future) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f38008c.toString() : (String) invokeV.objValue;
    }
}
