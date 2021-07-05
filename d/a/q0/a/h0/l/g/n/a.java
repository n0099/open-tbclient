package d.a.q0.a.h0.l.g.n;

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
import d.a.q0.a.a1.e;
import d.a.q0.a.h0.d.a;
import d.a.q0.a.h0.l.e;
import d.a.q0.a.h0.l.g.j;
import d.a.q0.a.h0.u.g;
import d.a.q0.a.h2.d;
import d.a.q0.a.k;
import d.a.q0.a.l0.g;
import d.a.q0.a.v2.o0;
import d.a.q0.a.v2.q0;
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
/* loaded from: classes8.dex */
public class a implements d.a.q0.a.v1.c.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f48212g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f48213h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue<PrefetchEvent> f48214a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f48215b;

    /* renamed from: c  reason: collision with root package name */
    public final int f48216c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f48217d;

    /* renamed from: e  reason: collision with root package name */
    public final int f48218e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Bundle> f48219f;

    /* renamed from: d.a.q0.a.h0.l.g.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C0790a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f48220e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f48221f;

        /* renamed from: g  reason: collision with root package name */
        public final BlockingQueue<PrefetchEvent> f48222g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f48223h;

        /* renamed from: i  reason: collision with root package name */
        public c f48224i;
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
            this.f48220e = i2 <= 0 ? 30 : i2;
            this.f48221f = false;
            this.f48222g = blockingQueue;
            this.f48223h = atomicInteger;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48221f = true;
                this.f48223h.decrementAndGet();
                b();
                if (a.f48212g) {
                    Log.d("PreCodeCacheManager", "CodeCacheFillTask destroy");
                }
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c cVar = this.f48224i;
                if (cVar != null) {
                    cVar.k();
                    this.f48224i = null;
                }
                if (a.f48212g) {
                    Log.d("PreCodeCacheManager", "master destroy");
                }
            }
        }

        public final void c(PrefetchEvent prefetchEvent) throws InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, prefetchEvent) == null) {
                if (this.f48224i == null) {
                    this.f48224i = d();
                }
                if (this.f48224i == null) {
                    a();
                    return;
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.f48224i.l(prefetchEvent.appPath, prefetchEvent, countDownLatch);
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
                if (a.f48212g) {
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
                while (!this.f48221f) {
                    try {
                        try {
                            PrefetchEvent poll = this.f48222g.poll(this.f48220e, TimeUnit.SECONDS);
                            if (poll == null) {
                                a();
                            } else {
                                c(poll);
                            }
                        } catch (InterruptedException e2) {
                            if (a.f48212g) {
                                e2.printStackTrace();
                            }
                            a();
                        }
                    } catch (Throwable th) {
                        if (a.f48212g) {
                            th.printStackTrace();
                        }
                        a();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final AtomicInteger f48225e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f48226a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.a.q0.a.h0.l.a f48227b;

        /* renamed from: c  reason: collision with root package name */
        public final List<j> f48228c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f48229d;

        /* renamed from: d.a.q0.a.h0.l.g.n.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0791a implements j {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f48230a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ PrefetchEvent f48231b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f48232c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ c f48233d;

            public C0791a(c cVar, String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
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
                this.f48233d = cVar;
                this.f48230a = str;
                this.f48231b = prefetchEvent;
                this.f48232c = countDownLatch;
            }

            @Override // d.a.q0.a.h0.l.g.j
            public void onReady() {
                d.a.q0.a.h0.f.a g2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f48233d.f48227b != null && (g2 = this.f48233d.f48227b.g()) != null && !g2.isDestroyed()) {
                        this.f48233d.s(this.f48230a, g2);
                        this.f48233d.r(g2, this.f48231b);
                        if (a.f48212g) {
                            Log.d("PreCodeCacheManager", "fill code cache finish for - " + this.f48230a);
                        }
                    }
                    CountDownLatch countDownLatch = this.f48232c;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b extends d.a.q0.a.h0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f48234a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f48235b;

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
                this.f48235b = cVar;
                this.f48234a = j;
            }

            @Override // d.a.q0.a.h0.b
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    if (a.f48212g) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Log.d("PreCodeCacheManager", "create a new master cost - " + (currentTimeMillis - this.f48234a) + "ms");
                    }
                    super.a(str);
                    this.f48235b.f48226a = true;
                    this.f48235b.q();
                }
            }
        }

        /* renamed from: d.a.q0.a.h0.l.g.n.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0792c extends e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c k;

            /* renamed from: d.a.q0.a.h0.l.g.n.a$c$c$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C0793a extends d.a.q0.a.h0.l.d {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0792c f48236e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0793a(C0792c c0792c, String str, String str2) {
                    super(str, str2);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0792c, str, str2};
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
                    this.f48236e = c0792c;
                }

                @Override // d.a.q0.a.h0.l.d
                public d.a.q0.a.l0.g e() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                        g.b bVar = new g.b();
                        bVar.c(1);
                        bVar.b(this.f48236e.k.n());
                        return bVar.a();
                    }
                    return (d.a.q0.a.l0.g) invokeV.objValue;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0792c(c cVar, Context context) {
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

            @Override // d.a.q0.a.h0.l.e
            public d.a.q0.a.h0.l.d j(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new C0793a(this, str, "runtime/index.js") : (d.a.q0.a.h0.l.d) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1877977109, "Ld/a/q0/a/h0/l/g/n/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1877977109, "Ld/a/q0/a/h0/l/g/n/a$c;");
                    return;
                }
            }
            f48225e = new AtomicInteger(1000);
        }

        public /* synthetic */ c(C0790a c0790a) {
            this();
        }

        public final synchronized void g(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                synchronized (this) {
                    if (jVar == null) {
                        return;
                    }
                    if (this.f48226a) {
                        jVar.onReady();
                        return;
                    }
                    if (!this.f48228c.contains(jVar)) {
                        this.f48228c.add(jVar);
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
                    String m = d.a.q0.a.a1.e.m(new File(file, "app.json"));
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
                    String c3 = d.a.q0.a.c2.f.p0.j.c(f2, c2);
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

        public final d.a.q0.a.h0.l.a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                long currentTimeMillis = a.f48212g ? System.currentTimeMillis() : 0L;
                d.a.q0.a.h0.l.a j = j();
                j.loadUrl(o0.w(d.a.q0.a.h0.u.g.N().R()));
                j.c(new b(this, currentTimeMillis));
                return j;
            }
            return (d.a.q0.a.h0.l.a) invokeV.objValue;
        }

        public final d.a.q0.a.h0.l.a j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new C0792c(this, AppRuntime.getAppContext()) : (d.a.q0.a.h0.l.a) invokeV.objValue;
        }

        public void k() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f48227b == null) {
                return;
            }
            this.f48227b.destroy();
        }

        public void l(String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, str, prefetchEvent, countDownLatch) == null) {
                if (this.f48227b == null) {
                    this.f48227b = i();
                }
                this.f48229d.add(str);
                g(new C0791a(this, str, prefetchEvent, countDownLatch));
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
                arrayList.addAll(this.f48229d);
                a.C0764a a2 = a.b.a();
                codeCacheSetting.maxCount = a2.f47893a;
                codeCacheSetting.sizeLimit = a2.f47894b;
                codeCacheSetting.diskCodeCacheSizeThreshold = a2.f47895c;
                return codeCacheSetting;
            }
            return (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        public final String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                String str = "master" + f48225e.getAndIncrement();
                if (a.f48212g) {
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
                return d.a.q0.a.a1.e.z(file) && d.a.q0.a.a1.e.y(file);
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
                    if (a.f48212g) {
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
                    for (j jVar : this.f48228c) {
                        if (jVar != null) {
                            jVar.onReady();
                        }
                    }
                    this.f48228c.clear();
                }
            }
        }

        public final void r(@NonNull d.a.q0.a.h0.f.a aVar, PrefetchEvent prefetchEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, prefetchEvent) == null) {
                long currentTimeMillis = a.f48212g ? System.currentTimeMillis() : 0L;
                PrefetchEvent.c h2 = h(prefetchEvent, "preload");
                if (h2 != null) {
                    d.a.q0.a.o0.a.a(aVar, h2);
                    if (a.f48212g) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        Log.d("PreCodeCacheManager", "send code cache msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                    }
                }
            }
        }

        public final void s(String str, d.a.q0.a.h0.f.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048588, this, str, aVar) == null) && (aVar instanceof d.a.q0.a.l0.a)) {
                ((d.a.q0.a.l0.a) aVar).C0(m());
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
            this.f48228c = new ArrayList();
            this.f48229d = new CopyOnWriteArrayList();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1343295692, "Ld/a/q0/a/h0/l/g/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1343295692, "Ld/a/q0/a/h0/l/g/n/a;");
                return;
            }
        }
        f48212g = k.f49133a;
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
        this.f48214a = new LinkedBlockingQueue();
        this.f48215b = new AtomicInteger(0);
        this.f48216c = 1;
        this.f48219f = new ArrayList();
        d.a.q0.a.c1.a.Z().getSwitch("swan_preset_code_cache", 0);
        this.f48218e = 0;
        m();
        d.a.q0.a.e0.d.h("PreCodeCacheManager", "swan_preset_code_cache - " + this.f48218e);
        if (f48212g) {
            Log.d("PreCodeCacheManager", "max master size - " + this.f48216c);
        }
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f48213h == null) {
                synchronized (a.class) {
                    if (f48213h == null) {
                        f48213h = new a();
                    }
                }
            }
            return f48213h;
        }
        return (a) invokeV.objValue;
    }

    @Override // d.a.q0.a.v1.c.f.a
    public void a(String str, d.a.q0.a.v1.c.f.c cVar) {
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
            if (!ProcessUtils.isMainProcess() || q0.G() || d.a.q0.a.c1.a.n0().c()) {
                int i2 = this.f48218e;
                if (i2 != 0) {
                    if (i2 == 1) {
                        if (f48212g) {
                            Log.d("PreCodeCacheManager", "all device preset code cache is on");
                        }
                        z = true;
                    } else if (i2 == 2) {
                        if (f48212g) {
                            Log.d("PreCodeCacheManager", "high performance device preset code cache is on");
                        }
                        z = !d.a.q0.a.c1.a.l0().a();
                    }
                    return !z ? false : false;
                } else if (f48212g) {
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
            this.f48214a.offer(prefetchEvent);
            if (this.f48217d) {
                p();
            }
        }
    }

    public final void e(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048580, this, str, j) == null) && c(str, j) && !ProcessUtils.isMainProcess()) {
            if (f48212g) {
                Log.d("PreCodeCacheManager", "start to fill code cache app - " + str + " , version - " + j);
            }
            d(b(str, e.C0680e.i(str, String.valueOf(j)).getPath() + File.separator));
        }
    }

    public void f(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) && ProcessUtils.isMainProcess() && c(str, j)) {
            d.a.q0.a.v1.c.f.c h2 = h();
            if (h2 == null) {
                if (f48212g) {
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

    public final d.a.q0.a.v1.c.f.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d.a.q0.a.v1.c.f.c e2 = d.a.q0.a.v1.c.f.e.k().e();
            if (e2 == null || e2.C()) {
                return null;
            }
            return e2;
        }
        return (d.a.q0.a.v1.c.f.c) invokeV.objValue;
    }

    public final b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new b(30, this.f48214a, this.f48215b) : (b) invokeV.objValue;
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
                this.f48219f.add(bundle);
                if (f48212g) {
                    Log.d("PreCodeCacheManager", "add fill code cache msg to cache");
                }
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && ProcessUtils.isMainProcess()) {
            d.a.q0.a.v1.c.f.e.k().b(this);
        }
    }

    public final synchronized void n(d.a.q0.a.v1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            synchronized (this) {
                if (this.f48219f.size() <= 0) {
                    return;
                }
                if (f48212g) {
                    Log.d("PreCodeCacheManager", "send msg from cache");
                }
                for (Bundle bundle : this.f48219f) {
                    o(cVar, bundle);
                }
                this.f48219f.clear();
            }
        }
    }

    public final void o(d.a.q0.a.v1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, cVar, bundle) == null) {
            d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
            d.a.q0.a.v1.c.c cVar2 = new d.a.q0.a.v1.c.c(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, bundle);
            cVar2.b(cVar.f51259f);
            e2.h(cVar2);
            if (f48212g) {
                Log.d("PreCodeCacheManager", "current process - " + cVar.f51259f.index);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f48214a.size() <= 0 || this.f48215b.get() >= this.f48216c) {
            return;
        }
        if (this.f48215b.incrementAndGet() > this.f48216c) {
            this.f48215b.decrementAndGet();
            return;
        }
        j().g();
        if (f48212g) {
            Log.d("PreCodeCacheManager", "start a new code cache fill task");
            Log.d("PreCodeCacheManager", "master size - " + this.f48215b.get());
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f48217d = true;
            p();
        }
    }

    @Override // d.a.q0.a.v1.c.f.a
    public void timeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }
}
