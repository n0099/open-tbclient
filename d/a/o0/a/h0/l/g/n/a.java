package d.a.o0.a.h0.l.g.n;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a1.e;
import d.a.o0.a.h0.d.a;
import d.a.o0.a.h0.l.e;
import d.a.o0.a.h0.l.g.j;
import d.a.o0.a.h0.u.g;
import d.a.o0.a.h2.d;
import d.a.o0.a.k;
import d.a.o0.a.l0.g;
import d.a.o0.a.v2.o0;
import d.a.o0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements d.a.o0.a.v1.c.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45414g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f45415h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue<PrefetchEvent> f45416a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f45417b;

    /* renamed from: c  reason: collision with root package name */
    public final int f45418c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f45419d;

    /* renamed from: e  reason: collision with root package name */
    public final int f45420e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Bundle> f45421f;

    /* renamed from: d.a.o0.a.h0.l.g.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C0748a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f45422e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f45423f;

        /* renamed from: g  reason: collision with root package name */
        public final BlockingQueue<PrefetchEvent> f45424g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f45425h;

        /* renamed from: i  reason: collision with root package name */
        public c f45426i;
        public int j;

        public b(int i2, @NonNull BlockingQueue<PrefetchEvent> blockingQueue, @NonNull AtomicInteger atomicInteger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), blockingQueue, atomicInteger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = 0;
            this.f45422e = i2 <= 0 ? 30 : i2;
            this.f45423f = false;
            this.f45424g = blockingQueue;
            this.f45425h = atomicInteger;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45423f = true;
                this.f45425h.decrementAndGet();
                b();
                if (a.f45414g) {
                    Log.d("PreCodeCacheManager", "CodeCacheFillTask destroy");
                }
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c cVar = this.f45426i;
                if (cVar != null) {
                    cVar.k();
                    this.f45426i = null;
                }
                if (a.f45414g) {
                    Log.d("PreCodeCacheManager", "master destroy");
                }
            }
        }

        public final void c(PrefetchEvent prefetchEvent) throws InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, prefetchEvent) == null) {
                if (this.f45426i == null) {
                    this.f45426i = d();
                }
                if (this.f45426i == null) {
                    a();
                    return;
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.f45426i.l(prefetchEvent.appPath, prefetchEvent, countDownLatch);
                countDownLatch.await(3L, TimeUnit.SECONDS);
                f();
            }
        }

        public final c d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (g.N().b0() && e()) {
                    return new c(null);
                }
                if (a.f45414g) {
                    Log.d("PreCodeCacheManager", "v8 master can not create");
                }
                return null;
            }
            return (c) invokeV.objValue;
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                boolean c2 = g.t.c();
                String R = g.N().R();
                return g.N().i0() && c2 && (!TextUtils.isEmpty(R) && new File(R).exists()) && d.c().b();
            }
            return invokeV.booleanValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                int i2 = this.j + 1;
                this.j = i2;
                if (i2 >= 10) {
                    this.j = 0;
                    b();
                }
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                ExecutorUtilsExt.postOnElastic(this, "code_cache_fill_thread", 3);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                while (!this.f45423f) {
                    try {
                        try {
                            PrefetchEvent poll = this.f45424g.poll(this.f45422e, TimeUnit.SECONDS);
                            if (poll == null) {
                                a();
                            } else {
                                c(poll);
                            }
                        } catch (InterruptedException e2) {
                            if (a.f45414g) {
                                e2.printStackTrace();
                            }
                            a();
                        }
                    } catch (Throwable th) {
                        if (a.f45414g) {
                            th.printStackTrace();
                        }
                        a();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final AtomicInteger f45427e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f45428a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.a.o0.a.h0.l.a f45429b;

        /* renamed from: c  reason: collision with root package name */
        public final List<j> f45430c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f45431d;

        /* renamed from: d.a.o0.a.h0.l.g.n.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0749a implements j {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f45432a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ PrefetchEvent f45433b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f45434c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ c f45435d;

            public C0749a(c cVar, String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str, prefetchEvent, countDownLatch};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45435d = cVar;
                this.f45432a = str;
                this.f45433b = prefetchEvent;
                this.f45434c = countDownLatch;
            }

            @Override // d.a.o0.a.h0.l.g.j
            public void onReady() {
                d.a.o0.a.h0.f.a g2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f45435d.f45429b != null && (g2 = this.f45435d.f45429b.g()) != null && !g2.isDestroyed()) {
                        this.f45435d.s(this.f45432a, g2);
                        this.f45435d.r(g2, this.f45433b);
                        if (a.f45414g) {
                            Log.d("PreCodeCacheManager", "fill code cache finish for - " + this.f45432a);
                        }
                    }
                    CountDownLatch countDownLatch = this.f45434c;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b extends d.a.o0.a.h0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f45436a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f45437b;

            public b(c cVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45437b = cVar;
                this.f45436a = j;
            }

            @Override // d.a.o0.a.h0.b
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    if (a.f45414g) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Log.d("PreCodeCacheManager", "create a new master cost - " + (currentTimeMillis - this.f45436a) + "ms");
                    }
                    super.a(str);
                    this.f45437b.f45428a = true;
                    this.f45437b.q();
                }
            }
        }

        /* renamed from: d.a.o0.a.h0.l.g.n.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0750c extends e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c k;

            /* renamed from: d.a.o0.a.h0.l.g.n.a$c$c$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0751a extends d.a.o0.a.h0.l.d {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0750c f45438e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0751a(C0750c c0750c, String str, String str2) {
                    super(str, str2);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0750c, str, str2};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], (String) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f45438e = c0750c;
                }

                @Override // d.a.o0.a.h0.l.d
                public d.a.o0.a.l0.g e() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                        g.b bVar = new g.b();
                        bVar.c(1);
                        bVar.b(this.f45438e.k.n());
                        return bVar.a();
                    }
                    return (d.a.o0.a.l0.g) invokeV.objValue;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0750c(c cVar, Context context) {
                super(context);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Context) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.k = cVar;
            }

            @Override // d.a.o0.a.h0.l.e
            public d.a.o0.a.h0.l.d j(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new C0751a(this, str, "runtime/index.js") : (d.a.o0.a.h0.l.d) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-422845481, "Ld/a/o0/a/h0/l/g/n/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-422845481, "Ld/a/o0/a/h0/l/g/n/a$c;");
                    return;
                }
            }
            f45427e = new AtomicInteger(1000);
        }

        public /* synthetic */ c(C0748a c0748a) {
            this();
        }

        public final synchronized void g(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                synchronized (this) {
                    if (jVar == null) {
                        return;
                    }
                    if (this.f45428a) {
                        jVar.onReady();
                        return;
                    }
                    if (!this.f45430c.contains(jVar)) {
                        this.f45430c.add(jVar);
                    }
                }
            }
        }

        public final PrefetchEvent.c h(PrefetchEvent prefetchEvent, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent, str)) == null) {
                if (o(prefetchEvent)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", prefetchEvent.appId);
                    hashMap.put("schema", prefetchEvent.schema);
                    hashMap.put("state", prefetchEvent.state);
                    hashMap.put("scene", prefetchEvent.scene);
                    hashMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, prefetchEvent.appPath);
                    hashMap.put("pageType", prefetchEvent.pageType);
                    File file = new File(prefetchEvent.appPath);
                    String m = d.a.o0.a.a1.e.m(new File(file, "app.json"));
                    prefetchEvent.appConfig = m;
                    hashMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, m);
                    SwanAppConfigData c2 = SwanAppConfigData.c(prefetchEvent.appConfig, file);
                    if (c2 == null || p(c2)) {
                        return null;
                    }
                    String e2 = c2.e();
                    prefetchEvent.pageUrl = e2;
                    hashMap.put("pageUrl", e2);
                    String f2 = o0.f(prefetchEvent.pageUrl);
                    String o = o0.o(prefetchEvent.pageUrl);
                    String c3 = d.a.o0.a.c2.f.p0.j.c(f2, c2);
                    if (!TextUtils.equals(f2, c3)) {
                        if (!TextUtils.isEmpty(o)) {
                            c3 = c3 + "?" + o;
                        }
                        hashMap.put("pageRoutePath", c3);
                    }
                    return new PrefetchEvent.c(hashMap, str);
                }
                return null;
            }
            return (PrefetchEvent.c) invokeLL.objValue;
        }

        public final d.a.o0.a.h0.l.a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                long currentTimeMillis = a.f45414g ? System.currentTimeMillis() : 0L;
                d.a.o0.a.h0.l.a j = j();
                j.loadUrl(o0.w(d.a.o0.a.h0.u.g.N().R()));
                j.c(new b(this, currentTimeMillis));
                return j;
            }
            return (d.a.o0.a.h0.l.a) invokeV.objValue;
        }

        public final d.a.o0.a.h0.l.a j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new C0750c(this, AppRuntime.getAppContext()) : (d.a.o0.a.h0.l.a) invokeV.objValue;
        }

        public void k() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f45429b == null) {
                return;
            }
            this.f45429b.destroy();
        }

        public void l(String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, str, prefetchEvent, countDownLatch) == null) {
                if (this.f45429b == null) {
                    this.f45429b = i();
                }
                this.f45431d.add(str);
                g(new C0749a(this, str, prefetchEvent, countDownLatch));
            }
        }

        public final V8EngineConfiguration.CodeCacheSetting m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                V8EngineConfiguration.CodeCacheSetting codeCacheSetting = new V8EngineConfiguration.CodeCacheSetting();
                codeCacheSetting.id = "appjs";
                ArrayList<String> arrayList = new ArrayList<>();
                codeCacheSetting.pathList = arrayList;
                arrayList.addAll(this.f45431d);
                a.C0722a a2 = a.b.a();
                codeCacheSetting.maxCount = a2.f45095a;
                codeCacheSetting.sizeLimit = a2.f45096b;
                codeCacheSetting.diskCodeCacheSizeThreshold = a2.f45097c;
                return codeCacheSetting;
            }
            return (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        public final String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                String str = "master" + f45427e.getAndIncrement();
                if (a.f45414g) {
                    Log.d("PreCodeCacheManager", "code cache master id - " + str);
                }
                return str;
            }
            return (String) invokeV.objValue;
        }

        public final boolean o(PrefetchEvent prefetchEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, prefetchEvent)) == null) {
                if (prefetchEvent == null) {
                    return false;
                }
                String str = prefetchEvent.appPath;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                File file = new File(str);
                return d.a.o0.a.a1.e.z(file) && d.a.o0.a.a1.e.y(file);
            }
            return invokeL.booleanValue;
        }

        public final boolean p(@NonNull SwanAppConfigData swanAppConfigData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, swanAppConfigData)) == null) {
                String str = swanAppConfigData.m;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                try {
                    return new JSONObject(str).has("_modules");
                } catch (JSONException e2) {
                    if (a.f45414g) {
                        e2.printStackTrace();
                    }
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public final synchronized void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                synchronized (this) {
                    for (j jVar : this.f45430c) {
                        if (jVar != null) {
                            jVar.onReady();
                        }
                    }
                    this.f45430c.clear();
                }
            }
        }

        public final void r(@NonNull d.a.o0.a.h0.f.a aVar, PrefetchEvent prefetchEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, prefetchEvent) == null) {
                long currentTimeMillis = a.f45414g ? System.currentTimeMillis() : 0L;
                PrefetchEvent.c h2 = h(prefetchEvent, "preload");
                if (h2 != null) {
                    d.a.o0.a.o0.a.a(aVar, h2);
                    if (a.f45414g) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        Log.d("PreCodeCacheManager", "send code cache msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                    }
                }
            }
        }

        public final void s(String str, d.a.o0.a.h0.f.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048588, this, str, aVar) == null) && (aVar instanceof d.a.o0.a.l0.a)) {
                ((d.a.o0.a.l0.a) aVar).C0(m());
            }
        }

        public c() {
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
            this.f45430c = new ArrayList();
            this.f45431d = new CopyOnWriteArrayList();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-322227338, "Ld/a/o0/a/h0/l/g/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-322227338, "Ld/a/o0/a/h0/l/g/n/a;");
                return;
            }
        }
        f45414g = k.f46335a;
    }

    public a() {
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
        this.f45416a = new LinkedBlockingQueue();
        this.f45417b = new AtomicInteger(0);
        this.f45418c = 1;
        this.f45421f = new ArrayList();
        d.a.o0.a.c1.a.Z().getSwitch("swan_preset_code_cache", 0);
        this.f45420e = 0;
        m();
        d.a.o0.a.e0.d.h("PreCodeCacheManager", "swan_preset_code_cache - " + this.f45420e);
        if (f45414g) {
            Log.d("PreCodeCacheManager", "max master size - " + this.f45418c);
        }
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f45415h == null) {
                synchronized (a.class) {
                    if (f45415h == null) {
                        f45415h = new a();
                    }
                }
            }
            return f45415h;
        }
        return (a) invokeV.objValue;
    }

    @Override // d.a.o0.a.v1.c.f.a
    public void a(String str, d.a.o0.a.v1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && TextUtils.equals(str, "event_puppet_online") && !cVar.C()) {
            n(cVar);
        }
    }

    public final PrefetchEvent b(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            PrefetchEvent.b bVar = new PrefetchEvent.b();
            bVar.a(str);
            bVar.e("show");
            bVar.c("fill_code_cache");
            PrefetchEvent b2 = bVar.b();
            b2.appPath = str2;
            b2.pageType = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
            return b2;
        }
        return (PrefetchEvent) invokeLL.objValue;
    }

    public final boolean c(String str, long j) {
        InterceptResult invokeLJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) {
            if (!ProcessUtils.isMainProcess() || q0.G() || d.a.o0.a.c1.a.n0().c()) {
                int i2 = this.f45420e;
                if (i2 != 0) {
                    if (i2 == 1) {
                        if (f45414g) {
                            Log.d("PreCodeCacheManager", "all device preset code cache is on");
                        }
                        z = true;
                    } else if (i2 == 2) {
                        if (f45414g) {
                            Log.d("PreCodeCacheManager", "high performance device preset code cache is on");
                        }
                        z = !d.a.o0.a.c1.a.l0().a();
                    }
                    return !z ? false : false;
                } else if (f45414g) {
                    Log.d("PreCodeCacheManager", "preset code cache is off");
                }
                z = false;
                return !z ? false : false;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public final void d(@NonNull PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, prefetchEvent) == null) {
            this.f45416a.offer(prefetchEvent);
            if (this.f45419d) {
                p();
            }
        }
    }

    public final void e(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048580, this, str, j) == null) && c(str, j) && !ProcessUtils.isMainProcess()) {
            if (f45414g) {
                Log.d("PreCodeCacheManager", "start to fill code cache app - " + str + " , version - " + j);
            }
            d(b(str, e.C0638e.i(str, String.valueOf(j)).getPath() + File.separator));
        }
    }

    public void f(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) && ProcessUtils.isMainProcess() && c(str, j)) {
            d.a.o0.a.v1.c.f.c h2 = h();
            if (h2 == null) {
                if (f45414g) {
                    Log.d("PreCodeCacheManager", "there is no blank client");
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("cc_app_id", str);
            bundle.putLong("cc_app_version", j);
            if (h2.H()) {
                o(h2, bundle);
            } else {
                l(bundle);
            }
        }
    }

    public void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) || bundle == null || bundle.size() <= 0 || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        e(bundle.getString("cc_app_id"), bundle.getLong("cc_app_version"));
    }

    public final d.a.o0.a.v1.c.f.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d.a.o0.a.v1.c.f.c e2 = d.a.o0.a.v1.c.f.e.k().e();
            if (e2 == null || e2.C()) {
                return null;
            }
            return e2;
        }
        return (d.a.o0.a.v1.c.f.c) invokeV.objValue;
    }

    public final b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new b(30, this.f45416a, this.f45417b) : (b) invokeV.objValue;
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("master")) {
                String substring = str.substring(6);
                if (TextUtils.isDigitsOnly(substring)) {
                    try {
                        i2 = Integer.parseInt(substring);
                    } catch (NumberFormatException unused) {
                        i2 = 0;
                    }
                    return i2 >= 1000;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final synchronized void l(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            synchronized (this) {
                if (bundle == null) {
                    return;
                }
                this.f45421f.add(bundle);
                if (f45414g) {
                    Log.d("PreCodeCacheManager", "add fill code cache msg to cache");
                }
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && ProcessUtils.isMainProcess()) {
            d.a.o0.a.v1.c.f.e.k().b(this);
        }
    }

    public final synchronized void n(d.a.o0.a.v1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            synchronized (this) {
                if (this.f45421f.size() <= 0) {
                    return;
                }
                if (f45414g) {
                    Log.d("PreCodeCacheManager", "send msg from cache");
                }
                for (Bundle bundle : this.f45421f) {
                    o(cVar, bundle);
                }
                this.f45421f.clear();
            }
        }
    }

    public final void o(d.a.o0.a.v1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, cVar, bundle) == null) {
            d.a.o0.a.v1.c.a e2 = d.a.o0.a.v1.c.a.e();
            d.a.o0.a.v1.c.c cVar2 = new d.a.o0.a.v1.c.c(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, bundle);
            cVar2.b(cVar.f48461f);
            e2.h(cVar2);
            if (f45414g) {
                Log.d("PreCodeCacheManager", "current process - " + cVar.f48461f.index);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f45416a.size() <= 0 || this.f45417b.get() >= this.f45418c) {
            return;
        }
        if (this.f45417b.incrementAndGet() > this.f45418c) {
            this.f45417b.decrementAndGet();
            return;
        }
        j().g();
        if (f45414g) {
            Log.d("PreCodeCacheManager", "start a new code cache fill task");
            Log.d("PreCodeCacheManager", "master size - " + this.f45417b.get());
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f45419d = true;
            p();
        }
    }

    @Override // d.a.o0.a.v1.c.f.a
    public void timeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }
}
