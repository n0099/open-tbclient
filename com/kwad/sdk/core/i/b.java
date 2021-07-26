package com.kwad.sdk.core.i;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f34816a = "GlobalThreadPools";

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, WeakReference<ExecutorService>> f34817b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements InterfaceC0419b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.kwad.sdk.core.i.b.InterfaceC0419b
        @NonNull
        public ExecutorService a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Executors.newSingleThreadExecutor() : (ExecutorService) invokeV.objValue;
        }
    }

    /* renamed from: com.kwad.sdk.core.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0419b {
        @NonNull
        ExecutorService a();
    }

    /* loaded from: classes6.dex */
    public static class c implements InterfaceC0419b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // com.kwad.sdk.core.i.b.InterfaceC0419b
        @NonNull
        public ExecutorService a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ThreadPoolExecutor(2, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "diskAndHttp")) : (ExecutorService) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final AtomicInteger f34818a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final ThreadGroup f34819b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f34820c;

        /* renamed from: d  reason: collision with root package name */
        public final String f34821d;

        /* renamed from: e  reason: collision with root package name */
        public final int f34822e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-384020364, "Lcom/kwad/sdk/core/i/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-384020364, "Lcom/kwad/sdk/core/i/b$d;");
                    return;
                }
            }
            f34818a = new AtomicInteger(1);
        }

        public d(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f34820c = new AtomicInteger(1);
            this.f34822e = i2;
            this.f34819b = Thread.currentThread().getThreadGroup();
            this.f34821d = "ksad-" + str + f34818a.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                ThreadGroup threadGroup = this.f34819b;
                Thread thread = new Thread(threadGroup, runnable, this.f34821d + this.f34820c.getAndIncrement(), 0L);
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                thread.setPriority(this.f34822e);
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements InterfaceC0419b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // com.kwad.sdk.core.i.b.InterfaceC0419b
        @NonNull
        public ExecutorService a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ThreadPoolExecutor(1, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(3, "uil-pool-")) : (ExecutorService) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements InterfaceC0419b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
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

        @Override // com.kwad.sdk.core.i.b.InterfaceC0419b
        @NonNull
        public ExecutorService a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "lruDiskCache")) : (ExecutorService) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static String f34823a = "lruDiskCache";

        /* renamed from: b  reason: collision with root package name */
        public static String f34824b = "ksImageLoaderTask";

        /* renamed from: c  reason: collision with root package name */
        public static String f34825c = "report";

        /* renamed from: d  reason: collision with root package name */
        public static String f34826d = "appInstallManager";

        /* renamed from: e  reason: collision with root package name */
        public static String f34827e = "diskAndHttpIO";

        /* renamed from: f  reason: collision with root package name */
        public static String f34828f = "async";

        /* renamed from: g  reason: collision with root package name */
        public static String f34829g = "async-schedule";
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-384020271, "Lcom/kwad/sdk/core/i/b$g;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-384020271, "Lcom/kwad/sdk/core/i/b$g;");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements InterfaceC0419b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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

        @Override // com.kwad.sdk.core.i.b.InterfaceC0419b
        @NonNull
        public ExecutorService a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Executors.newSingleThreadExecutor(new d(3, "report-")) : (ExecutorService) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1890101108, "Lcom/kwad/sdk/core/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1890101108, "Lcom/kwad/sdk/core/i/b;");
                return;
            }
        }
        f34817b = new ConcurrentHashMap();
    }

    public static ExecutorService a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            com.kwad.sdk.core.d.a.a(f34816a, "forDiskLruCache");
            return a(g.f34823a, new f());
        }
        return (ExecutorService) invokeV.objValue;
    }

    @NonNull
    public static ExecutorService a(String str, @NonNull InterfaceC0419b interfaceC0419b) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, interfaceC0419b)) == null) {
            if (str == null) {
                return interfaceC0419b.a();
            }
            WeakReference<ExecutorService> weakReference = f34817b.get(str);
            if (weakReference == null || weakReference.get() == null) {
                ExecutorService a2 = interfaceC0419b.a();
                f34817b.put(str, new WeakReference<>(a2));
                return a2;
            }
            return weakReference.get();
        }
        return (ExecutorService) invokeLL.objValue;
    }

    public static ExecutorService b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a(g.f34823a, new f()) : (ExecutorService) invokeV.objValue;
    }

    public static synchronized ExecutorService c() {
        InterceptResult invokeV;
        ExecutorService a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (b.class) {
                com.kwad.sdk.core.d.a.a(f34816a, "forKsImageLoaderTask");
                a2 = a(g.f34824b, new e());
            }
            return a2;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static synchronized ExecutorService d() {
        InterceptResult invokeV;
        ExecutorService a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            synchronized (b.class) {
                com.kwad.sdk.core.d.a.a(f34816a, "forKsImageLoaderCachedImages");
                a2 = a(g.f34824b, new e());
            }
            return a2;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            com.kwad.sdk.core.d.a.a(f34816a, "forKsImageLoaderTaskDistributor");
            return a(g.f34824b, new e());
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static synchronized ExecutorService f() {
        InterceptResult invokeV;
        ExecutorService a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            synchronized (b.class) {
                com.kwad.sdk.core.d.a.a(f34816a, "forBaseBatchReporter");
                a2 = a(g.f34825c, new h());
            }
            return a2;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static synchronized ExecutorService g() {
        InterceptResult invokeV;
        ExecutorService a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (b.class) {
                com.kwad.sdk.core.d.a.a(f34816a, "forAdReportManager");
                a2 = a(g.f34825c, new h());
            }
            return a2;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            com.kwad.sdk.core.d.a.a(f34816a, "forBaseNetwork");
            return a(g.f34827e, new c());
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            com.kwad.sdk.core.d.a.a(f34816a, "forFileHelper");
            return a(g.f34827e, new c());
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            com.kwad.sdk.core.d.a.a(f34816a, "forAppCacheManager");
            return a(g.f34826d, new a());
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            com.kwad.sdk.core.d.a.a(f34816a, "forAppInstallCheckManager");
            return a(g.f34826d, new a());
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            com.kwad.sdk.core.d.a.a(f34816a, "forHttpCacheServer");
            return a(g.f34827e, new c());
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            com.kwad.sdk.core.d.a.a(f34816a, "forAppStatusHelper");
            return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.kwad.sdk.core.i.b.1
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

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                        Thread thread = new Thread(runnable, "ksad-ashelper");
                        thread.setPriority(3);
                        return thread;
                    }
                    return (Thread) invokeL.objValue;
                }
            });
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            com.kwad.sdk.core.d.a.a(f34816a, "forAsync");
            return a(g.f34828f, new InterfaceC0419b() { // from class: com.kwad.sdk.core.i.b.2
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

                @Override // com.kwad.sdk.core.i.b.InterfaceC0419b
                @NonNull
                public ExecutorService a() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? new ThreadPoolExecutor(0, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, g.f34828f)) : (ExecutorService) invokeV2.objValue;
                }
            });
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ScheduledExecutorService o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            com.kwad.sdk.core.d.a.a(f34816a, "forAsyncSchedule");
            ExecutorService a2 = a(g.f34829g, new InterfaceC0419b() { // from class: com.kwad.sdk.core.i.b.3
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

                @Override // com.kwad.sdk.core.i.b.InterfaceC0419b
                @NonNull
                public ExecutorService a() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? new ScheduledThreadPoolExecutor(1, new d(5, g.f34829g)) : (ExecutorService) invokeV2.objValue;
                }
            });
            return a2 instanceof ScheduledExecutorService ? (ScheduledExecutorService) a2 : new ScheduledThreadPoolExecutor(1, new d(5, g.f34829g));
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }
}
