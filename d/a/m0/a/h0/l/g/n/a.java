package d.a.m0.a.h0.l.g.n;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.m0.a.a1.e;
import d.a.m0.a.h0.d.a;
import d.a.m0.a.h0.l.e;
import d.a.m0.a.h0.l.g.j;
import d.a.m0.a.h0.u.g;
import d.a.m0.a.h2.d;
import d.a.m0.a.k;
import d.a.m0.a.l0.g;
import d.a.m0.a.v2.o0;
import d.a.m0.a.v2.q0;
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
/* loaded from: classes3.dex */
public class a implements d.a.m0.a.v1.c.f.a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f46062g = k.f46983a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f46063h;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f46067d;

    /* renamed from: e  reason: collision with root package name */
    public final int f46068e;

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue<PrefetchEvent> f46064a = new LinkedBlockingQueue();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f46065b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    public final int f46066c = 1;

    /* renamed from: f  reason: collision with root package name */
    public final List<Bundle> f46069f = new ArrayList();

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final int f46070e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f46071f;

        /* renamed from: g  reason: collision with root package name */
        public final BlockingQueue<PrefetchEvent> f46072g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f46073h;

        /* renamed from: i  reason: collision with root package name */
        public c f46074i;
        public int j = 0;

        public b(int i2, @NonNull BlockingQueue<PrefetchEvent> blockingQueue, @NonNull AtomicInteger atomicInteger) {
            this.f46070e = i2 <= 0 ? 30 : i2;
            this.f46071f = false;
            this.f46072g = blockingQueue;
            this.f46073h = atomicInteger;
        }

        public final void a() {
            this.f46071f = true;
            this.f46073h.decrementAndGet();
            b();
            if (a.f46062g) {
                Log.d("PreCodeCacheManager", "CodeCacheFillTask destroy");
            }
        }

        public final void b() {
            c cVar = this.f46074i;
            if (cVar != null) {
                cVar.k();
                this.f46074i = null;
            }
            if (a.f46062g) {
                Log.d("PreCodeCacheManager", "master destroy");
            }
        }

        public final void c(PrefetchEvent prefetchEvent) throws InterruptedException {
            if (this.f46074i == null) {
                this.f46074i = d();
            }
            if (this.f46074i == null) {
                a();
                return;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f46074i.l(prefetchEvent.appPath, prefetchEvent, countDownLatch);
            countDownLatch.await(3L, TimeUnit.SECONDS);
            f();
        }

        public final c d() {
            if (g.N().b0() && e()) {
                return new c();
            }
            if (a.f46062g) {
                Log.d("PreCodeCacheManager", "v8 master can not create");
            }
            return null;
        }

        public final boolean e() {
            boolean c2 = g.t.c();
            String R = g.N().R();
            return g.N().i0() && c2 && (!TextUtils.isEmpty(R) && new File(R).exists()) && d.c().b();
        }

        public final void f() {
            int i2 = this.j + 1;
            this.j = i2;
            if (i2 >= 10) {
                this.j = 0;
                b();
            }
        }

        public void g() {
            ExecutorUtilsExt.postOnElastic(this, "code_cache_fill_thread", 3);
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f46071f) {
                try {
                    try {
                        PrefetchEvent poll = this.f46072g.poll(this.f46070e, TimeUnit.SECONDS);
                        if (poll == null) {
                            a();
                        } else {
                            c(poll);
                        }
                    } catch (InterruptedException e2) {
                        if (a.f46062g) {
                            e2.printStackTrace();
                        }
                        a();
                    }
                } catch (Throwable th) {
                    if (a.f46062g) {
                        th.printStackTrace();
                    }
                    a();
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: e  reason: collision with root package name */
        public static final AtomicInteger f46075e = new AtomicInteger(1000);

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f46076a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.a.m0.a.h0.l.a f46077b;

        /* renamed from: c  reason: collision with root package name */
        public final List<j> f46078c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f46079d;

        /* renamed from: d.a.m0.a.h0.l.g.n.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0731a implements j {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f46080a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ PrefetchEvent f46081b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f46082c;

            public C0731a(String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
                this.f46080a = str;
                this.f46081b = prefetchEvent;
                this.f46082c = countDownLatch;
            }

            @Override // d.a.m0.a.h0.l.g.j
            public void onReady() {
                d.a.m0.a.h0.f.a g2;
                if (c.this.f46077b != null && (g2 = c.this.f46077b.g()) != null && !g2.isDestroyed()) {
                    c.this.s(this.f46080a, g2);
                    c.this.r(g2, this.f46081b);
                    if (a.f46062g) {
                        Log.d("PreCodeCacheManager", "fill code cache finish for - " + this.f46080a);
                    }
                }
                CountDownLatch countDownLatch = this.f46082c;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b extends d.a.m0.a.h0.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f46084a;

            public b(long j) {
                this.f46084a = j;
            }

            @Override // d.a.m0.a.h0.b
            public void a(String str) {
                if (a.f46062g) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.d("PreCodeCacheManager", "create a new master cost - " + (currentTimeMillis - this.f46084a) + "ms");
                }
                super.a(str);
                c.this.f46076a = true;
                c.this.q();
            }
        }

        /* renamed from: d.a.m0.a.h0.l.g.n.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0732c extends e {

            /* renamed from: d.a.m0.a.h0.l.g.n.a$c$c$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0733a extends d.a.m0.a.h0.l.d {
                public C0733a(String str, String str2) {
                    super(str, str2);
                }

                @Override // d.a.m0.a.h0.l.d
                public d.a.m0.a.l0.g e() {
                    g.b bVar = new g.b();
                    bVar.c(1);
                    bVar.b(c.this.n());
                    return bVar.a();
                }
            }

            public C0732c(Context context) {
                super(context);
            }

            @Override // d.a.m0.a.h0.l.e
            public d.a.m0.a.h0.l.d j(String str) {
                return new C0733a(str, "runtime/index.js");
            }
        }

        public final synchronized void g(j jVar) {
            if (jVar == null) {
                return;
            }
            if (this.f46076a) {
                jVar.onReady();
                return;
            }
            if (!this.f46078c.contains(jVar)) {
                this.f46078c.add(jVar);
            }
        }

        public final PrefetchEvent.c h(PrefetchEvent prefetchEvent, String str) {
            if (o(prefetchEvent)) {
                HashMap hashMap = new HashMap();
                hashMap.put("appKey", prefetchEvent.appId);
                hashMap.put("schema", prefetchEvent.schema);
                hashMap.put("state", prefetchEvent.state);
                hashMap.put("scene", prefetchEvent.scene);
                hashMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, prefetchEvent.appPath);
                hashMap.put("pageType", prefetchEvent.pageType);
                File file = new File(prefetchEvent.appPath);
                String m = d.a.m0.a.a1.e.m(new File(file, "app.json"));
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
                String c3 = d.a.m0.a.c2.f.p0.j.c(f2, c2);
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

        public final d.a.m0.a.h0.l.a i() {
            long currentTimeMillis = a.f46062g ? System.currentTimeMillis() : 0L;
            d.a.m0.a.h0.l.a j = j();
            j.loadUrl(o0.w(d.a.m0.a.h0.u.g.N().R()));
            j.c(new b(currentTimeMillis));
            return j;
        }

        public final d.a.m0.a.h0.l.a j() {
            return new C0732c(AppRuntime.getAppContext());
        }

        public void k() {
            if (this.f46077b != null) {
                this.f46077b.destroy();
            }
        }

        public void l(String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
            if (this.f46077b == null) {
                this.f46077b = i();
            }
            this.f46079d.add(str);
            g(new C0731a(str, prefetchEvent, countDownLatch));
        }

        public final V8EngineConfiguration.CodeCacheSetting m() {
            V8EngineConfiguration.CodeCacheSetting codeCacheSetting = new V8EngineConfiguration.CodeCacheSetting();
            codeCacheSetting.id = "appjs";
            ArrayList<String> arrayList = new ArrayList<>();
            codeCacheSetting.pathList = arrayList;
            arrayList.addAll(this.f46079d);
            a.C0704a a2 = a.b.a();
            codeCacheSetting.maxCount = a2.f45743a;
            codeCacheSetting.sizeLimit = a2.f45744b;
            codeCacheSetting.diskCodeCacheSizeThreshold = a2.f45745c;
            return codeCacheSetting;
        }

        public final String n() {
            String str = "master" + f46075e.getAndIncrement();
            if (a.f46062g) {
                Log.d("PreCodeCacheManager", "code cache master id - " + str);
            }
            return str;
        }

        public final boolean o(PrefetchEvent prefetchEvent) {
            if (prefetchEvent == null) {
                return false;
            }
            String str = prefetchEvent.appPath;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            return d.a.m0.a.a1.e.z(file) && d.a.m0.a.a1.e.y(file);
        }

        public final boolean p(@NonNull SwanAppConfigData swanAppConfigData) {
            String str = swanAppConfigData.m;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return new JSONObject(str).has("_modules");
            } catch (JSONException e2) {
                if (a.f46062g) {
                    e2.printStackTrace();
                }
                return false;
            }
        }

        public final synchronized void q() {
            for (j jVar : this.f46078c) {
                if (jVar != null) {
                    jVar.onReady();
                }
            }
            this.f46078c.clear();
        }

        public final void r(@NonNull d.a.m0.a.h0.f.a aVar, PrefetchEvent prefetchEvent) {
            long currentTimeMillis = a.f46062g ? System.currentTimeMillis() : 0L;
            PrefetchEvent.c h2 = h(prefetchEvent, "preload");
            if (h2 != null) {
                d.a.m0.a.o0.a.a(aVar, h2);
                if (a.f46062g) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("PreCodeCacheManager", "send code cache msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                }
            }
        }

        public final void s(String str, d.a.m0.a.h0.f.a aVar) {
            if (aVar instanceof d.a.m0.a.l0.a) {
                ((d.a.m0.a.l0.a) aVar).C0(m());
            }
        }

        public c() {
            this.f46078c = new ArrayList();
            this.f46079d = new CopyOnWriteArrayList();
        }
    }

    public a() {
        d.a.m0.a.c1.a.Z().getSwitch("swan_preset_code_cache", 0);
        this.f46068e = 0;
        m();
        d.a.m0.a.e0.d.h("PreCodeCacheManager", "swan_preset_code_cache - " + this.f46068e);
        if (f46062g) {
            Log.d("PreCodeCacheManager", "max master size - " + this.f46066c);
        }
    }

    public static a i() {
        if (f46063h == null) {
            synchronized (a.class) {
                if (f46063h == null) {
                    f46063h = new a();
                }
            }
        }
        return f46063h;
    }

    @Override // d.a.m0.a.v1.c.f.a
    public void a(String str, d.a.m0.a.v1.c.f.c cVar) {
        if (!TextUtils.equals(str, "event_puppet_online") || cVar.C()) {
            return;
        }
        n(cVar);
    }

    public final PrefetchEvent b(@NonNull String str, @NonNull String str2) {
        PrefetchEvent.b bVar = new PrefetchEvent.b();
        bVar.a(str);
        bVar.e("show");
        bVar.c("fill_code_cache");
        PrefetchEvent b2 = bVar.b();
        b2.appPath = str2;
        b2.pageType = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
        return b2;
    }

    public final boolean c(String str, long j) {
        boolean z;
        if (!ProcessUtils.isMainProcess() || q0.G() || d.a.m0.a.c1.a.n0().c()) {
            int i2 = this.f46068e;
            if (i2 != 0) {
                if (i2 == 1) {
                    if (f46062g) {
                        Log.d("PreCodeCacheManager", "all device preset code cache is on");
                    }
                    z = true;
                } else if (i2 == 2) {
                    if (f46062g) {
                        Log.d("PreCodeCacheManager", "high performance device preset code cache is on");
                    }
                    z = !d.a.m0.a.c1.a.l0().a();
                }
                return !z ? false : false;
            } else if (f46062g) {
                Log.d("PreCodeCacheManager", "preset code cache is off");
            }
            z = false;
            return !z ? false : false;
        }
        return false;
    }

    public final void d(@NonNull PrefetchEvent prefetchEvent) {
        this.f46064a.offer(prefetchEvent);
        if (this.f46067d) {
            p();
        }
    }

    public final void e(String str, long j) {
        if (c(str, j) && !ProcessUtils.isMainProcess()) {
            if (f46062g) {
                Log.d("PreCodeCacheManager", "start to fill code cache app - " + str + " , version - " + j);
            }
            d(b(str, e.C0620e.i(str, String.valueOf(j)).getPath() + File.separator));
        }
    }

    public void f(String str, long j) {
        if (ProcessUtils.isMainProcess() && c(str, j)) {
            d.a.m0.a.v1.c.f.c h2 = h();
            if (h2 == null) {
                if (f46062g) {
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
        if (bundle == null || bundle.size() <= 0 || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        e(bundle.getString("cc_app_id"), bundle.getLong("cc_app_version"));
    }

    public final d.a.m0.a.v1.c.f.c h() {
        d.a.m0.a.v1.c.f.c e2 = d.a.m0.a.v1.c.f.e.k().e();
        if (e2 == null || e2.C()) {
            return null;
        }
        return e2;
    }

    public final b j() {
        return new b(30, this.f46064a, this.f46065b);
    }

    public boolean k(String str) {
        int i2;
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

    public final synchronized void l(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.f46069f.add(bundle);
        if (f46062g) {
            Log.d("PreCodeCacheManager", "add fill code cache msg to cache");
        }
    }

    public final void m() {
        if (ProcessUtils.isMainProcess()) {
            d.a.m0.a.v1.c.f.e.k().b(this);
        }
    }

    public final synchronized void n(d.a.m0.a.v1.c.f.c cVar) {
        if (this.f46069f.size() <= 0) {
            return;
        }
        if (f46062g) {
            Log.d("PreCodeCacheManager", "send msg from cache");
        }
        for (Bundle bundle : this.f46069f) {
            o(cVar, bundle);
        }
        this.f46069f.clear();
    }

    public final void o(d.a.m0.a.v1.c.f.c cVar, Bundle bundle) {
        d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
        d.a.m0.a.v1.c.c cVar2 = new d.a.m0.a.v1.c.c(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, bundle);
        cVar2.b(cVar.f49113f);
        e2.h(cVar2);
        if (f46062g) {
            Log.d("PreCodeCacheManager", "current process - " + cVar.f49113f.index);
        }
    }

    public final void p() {
        if (this.f46064a.size() <= 0 || this.f46065b.get() >= this.f46066c) {
            return;
        }
        if (this.f46065b.incrementAndGet() > this.f46066c) {
            this.f46065b.decrementAndGet();
            return;
        }
        j().g();
        if (f46062g) {
            Log.d("PreCodeCacheManager", "start a new code cache fill task");
            Log.d("PreCodeCacheManager", "master size - " + this.f46065b.get());
        }
    }

    public void q() {
        this.f46067d = true;
        p();
    }

    @Override // d.a.m0.a.v1.c.f.a
    public void timeout() {
    }
}
