package d.a.i0.a.h0.l.g.n;

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
import d.a.i0.a.a1.e;
import d.a.i0.a.h0.d.a;
import d.a.i0.a.h0.l.e;
import d.a.i0.a.h0.l.g.j;
import d.a.i0.a.h0.u.g;
import d.a.i0.a.h2.d;
import d.a.i0.a.k;
import d.a.i0.a.l0.g;
import d.a.i0.a.v2.o0;
import d.a.i0.a.v2.q0;
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
/* loaded from: classes2.dex */
public class a implements d.a.i0.a.v1.c.f.a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f42104g = k.f43025a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f42105h;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f42109d;

    /* renamed from: e  reason: collision with root package name */
    public final int f42110e;

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue<PrefetchEvent> f42106a = new LinkedBlockingQueue();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f42107b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    public final int f42108c = 1;

    /* renamed from: f  reason: collision with root package name */
    public final List<Bundle> f42111f = new ArrayList();

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final int f42112e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f42113f;

        /* renamed from: g  reason: collision with root package name */
        public final BlockingQueue<PrefetchEvent> f42114g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f42115h;

        /* renamed from: i  reason: collision with root package name */
        public c f42116i;
        public int j = 0;

        public b(int i2, @NonNull BlockingQueue<PrefetchEvent> blockingQueue, @NonNull AtomicInteger atomicInteger) {
            this.f42112e = i2 <= 0 ? 30 : i2;
            this.f42113f = false;
            this.f42114g = blockingQueue;
            this.f42115h = atomicInteger;
        }

        public final void a() {
            this.f42113f = true;
            this.f42115h.decrementAndGet();
            b();
            if (a.f42104g) {
                Log.d("PreCodeCacheManager", "CodeCacheFillTask destroy");
            }
        }

        public final void b() {
            c cVar = this.f42116i;
            if (cVar != null) {
                cVar.k();
                this.f42116i = null;
            }
            if (a.f42104g) {
                Log.d("PreCodeCacheManager", "master destroy");
            }
        }

        public final void c(PrefetchEvent prefetchEvent) throws InterruptedException {
            if (this.f42116i == null) {
                this.f42116i = d();
            }
            if (this.f42116i == null) {
                a();
                return;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f42116i.l(prefetchEvent.appPath, prefetchEvent, countDownLatch);
            countDownLatch.await(3L, TimeUnit.SECONDS);
            f();
        }

        public final c d() {
            if (g.N().b0() && e()) {
                return new c();
            }
            if (a.f42104g) {
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
            while (!this.f42113f) {
                try {
                    try {
                        PrefetchEvent poll = this.f42114g.poll(this.f42112e, TimeUnit.SECONDS);
                        if (poll == null) {
                            a();
                        } else {
                            c(poll);
                        }
                    } catch (InterruptedException e2) {
                        if (a.f42104g) {
                            e2.printStackTrace();
                        }
                        a();
                    }
                } catch (Throwable th) {
                    if (a.f42104g) {
                        th.printStackTrace();
                    }
                    a();
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: e  reason: collision with root package name */
        public static final AtomicInteger f42117e = new AtomicInteger(1000);

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f42118a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.a.i0.a.h0.l.a f42119b;

        /* renamed from: c  reason: collision with root package name */
        public final List<j> f42120c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f42121d;

        /* renamed from: d.a.i0.a.h0.l.g.n.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0661a implements j {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42122a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ PrefetchEvent f42123b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f42124c;

            public C0661a(String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
                this.f42122a = str;
                this.f42123b = prefetchEvent;
                this.f42124c = countDownLatch;
            }

            @Override // d.a.i0.a.h0.l.g.j
            public void onReady() {
                d.a.i0.a.h0.f.a g2;
                if (c.this.f42119b != null && (g2 = c.this.f42119b.g()) != null && !g2.isDestroyed()) {
                    c.this.s(this.f42122a, g2);
                    c.this.r(g2, this.f42123b);
                    if (a.f42104g) {
                        Log.d("PreCodeCacheManager", "fill code cache finish for - " + this.f42122a);
                    }
                }
                CountDownLatch countDownLatch = this.f42124c;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b extends d.a.i0.a.h0.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f42126a;

            public b(long j) {
                this.f42126a = j;
            }

            @Override // d.a.i0.a.h0.b
            public void a(String str) {
                if (a.f42104g) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.d("PreCodeCacheManager", "create a new master cost - " + (currentTimeMillis - this.f42126a) + "ms");
                }
                super.a(str);
                c.this.f42118a = true;
                c.this.q();
            }
        }

        /* renamed from: d.a.i0.a.h0.l.g.n.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0662c extends e {

            /* renamed from: d.a.i0.a.h0.l.g.n.a$c$c$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0663a extends d.a.i0.a.h0.l.d {
                public C0663a(String str, String str2) {
                    super(str, str2);
                }

                @Override // d.a.i0.a.h0.l.d
                public d.a.i0.a.l0.g e() {
                    g.b bVar = new g.b();
                    bVar.c(1);
                    bVar.b(c.this.n());
                    return bVar.a();
                }
            }

            public C0662c(Context context) {
                super(context);
            }

            @Override // d.a.i0.a.h0.l.e
            public d.a.i0.a.h0.l.d j(String str) {
                return new C0663a(str, "runtime/index.js");
            }
        }

        public final synchronized void g(j jVar) {
            if (jVar == null) {
                return;
            }
            if (this.f42118a) {
                jVar.onReady();
                return;
            }
            if (!this.f42120c.contains(jVar)) {
                this.f42120c.add(jVar);
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
                String m = d.a.i0.a.a1.e.m(new File(file, "app.json"));
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
                String c3 = d.a.i0.a.c2.f.p0.j.c(f2, c2);
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

        public final d.a.i0.a.h0.l.a i() {
            long currentTimeMillis = a.f42104g ? System.currentTimeMillis() : 0L;
            d.a.i0.a.h0.l.a j = j();
            j.loadUrl(o0.w(d.a.i0.a.h0.u.g.N().R()));
            j.c(new b(currentTimeMillis));
            return j;
        }

        public final d.a.i0.a.h0.l.a j() {
            return new C0662c(AppRuntime.getAppContext());
        }

        public void k() {
            if (this.f42119b != null) {
                this.f42119b.destroy();
            }
        }

        public void l(String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
            if (this.f42119b == null) {
                this.f42119b = i();
            }
            this.f42121d.add(str);
            g(new C0661a(str, prefetchEvent, countDownLatch));
        }

        public final V8EngineConfiguration.CodeCacheSetting m() {
            V8EngineConfiguration.CodeCacheSetting codeCacheSetting = new V8EngineConfiguration.CodeCacheSetting();
            codeCacheSetting.id = "appjs";
            ArrayList<String> arrayList = new ArrayList<>();
            codeCacheSetting.pathList = arrayList;
            arrayList.addAll(this.f42121d);
            a.C0634a a2 = a.b.a();
            codeCacheSetting.maxCount = a2.f41785a;
            codeCacheSetting.sizeLimit = a2.f41786b;
            codeCacheSetting.diskCodeCacheSizeThreshold = a2.f41787c;
            return codeCacheSetting;
        }

        public final String n() {
            String str = "master" + f42117e.getAndIncrement();
            if (a.f42104g) {
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
            return d.a.i0.a.a1.e.z(file) && d.a.i0.a.a1.e.y(file);
        }

        public final boolean p(@NonNull SwanAppConfigData swanAppConfigData) {
            String str = swanAppConfigData.m;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return new JSONObject(str).has("_modules");
            } catch (JSONException e2) {
                if (a.f42104g) {
                    e2.printStackTrace();
                }
                return false;
            }
        }

        public final synchronized void q() {
            for (j jVar : this.f42120c) {
                if (jVar != null) {
                    jVar.onReady();
                }
            }
            this.f42120c.clear();
        }

        public final void r(@NonNull d.a.i0.a.h0.f.a aVar, PrefetchEvent prefetchEvent) {
            long currentTimeMillis = a.f42104g ? System.currentTimeMillis() : 0L;
            PrefetchEvent.c h2 = h(prefetchEvent, "preload");
            if (h2 != null) {
                d.a.i0.a.o0.a.a(aVar, h2);
                if (a.f42104g) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("PreCodeCacheManager", "send code cache msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                }
            }
        }

        public final void s(String str, d.a.i0.a.h0.f.a aVar) {
            if (aVar instanceof d.a.i0.a.l0.a) {
                ((d.a.i0.a.l0.a) aVar).C0(m());
            }
        }

        public c() {
            this.f42120c = new ArrayList();
            this.f42121d = new CopyOnWriteArrayList();
        }
    }

    public a() {
        d.a.i0.a.c1.a.Z().getSwitch("swan_preset_code_cache", 0);
        this.f42110e = 0;
        m();
        d.a.i0.a.e0.d.h("PreCodeCacheManager", "swan_preset_code_cache - " + this.f42110e);
        if (f42104g) {
            Log.d("PreCodeCacheManager", "max master size - " + this.f42108c);
        }
    }

    public static a i() {
        if (f42105h == null) {
            synchronized (a.class) {
                if (f42105h == null) {
                    f42105h = new a();
                }
            }
        }
        return f42105h;
    }

    @Override // d.a.i0.a.v1.c.f.a
    public void a(String str, d.a.i0.a.v1.c.f.c cVar) {
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
        if (!ProcessUtils.isMainProcess() || q0.G() || d.a.i0.a.c1.a.n0().c()) {
            int i2 = this.f42110e;
            if (i2 != 0) {
                if (i2 == 1) {
                    if (f42104g) {
                        Log.d("PreCodeCacheManager", "all device preset code cache is on");
                    }
                    z = true;
                } else if (i2 == 2) {
                    if (f42104g) {
                        Log.d("PreCodeCacheManager", "high performance device preset code cache is on");
                    }
                    z = !d.a.i0.a.c1.a.l0().a();
                }
                return !z ? false : false;
            } else if (f42104g) {
                Log.d("PreCodeCacheManager", "preset code cache is off");
            }
            z = false;
            return !z ? false : false;
        }
        return false;
    }

    public final void d(@NonNull PrefetchEvent prefetchEvent) {
        this.f42106a.offer(prefetchEvent);
        if (this.f42109d) {
            p();
        }
    }

    public final void e(String str, long j) {
        if (c(str, j) && !ProcessUtils.isMainProcess()) {
            if (f42104g) {
                Log.d("PreCodeCacheManager", "start to fill code cache app - " + str + " , version - " + j);
            }
            d(b(str, e.C0550e.i(str, String.valueOf(j)).getPath() + File.separator));
        }
    }

    public void f(String str, long j) {
        if (ProcessUtils.isMainProcess() && c(str, j)) {
            d.a.i0.a.v1.c.f.c h2 = h();
            if (h2 == null) {
                if (f42104g) {
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

    public final d.a.i0.a.v1.c.f.c h() {
        d.a.i0.a.v1.c.f.c e2 = d.a.i0.a.v1.c.f.e.k().e();
        if (e2 == null || e2.C()) {
            return null;
        }
        return e2;
    }

    public final b j() {
        return new b(30, this.f42106a, this.f42107b);
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
        this.f42111f.add(bundle);
        if (f42104g) {
            Log.d("PreCodeCacheManager", "add fill code cache msg to cache");
        }
    }

    public final void m() {
        if (ProcessUtils.isMainProcess()) {
            d.a.i0.a.v1.c.f.e.k().b(this);
        }
    }

    public final synchronized void n(d.a.i0.a.v1.c.f.c cVar) {
        if (this.f42111f.size() <= 0) {
            return;
        }
        if (f42104g) {
            Log.d("PreCodeCacheManager", "send msg from cache");
        }
        for (Bundle bundle : this.f42111f) {
            o(cVar, bundle);
        }
        this.f42111f.clear();
    }

    public final void o(d.a.i0.a.v1.c.f.c cVar, Bundle bundle) {
        d.a.i0.a.v1.c.a e2 = d.a.i0.a.v1.c.a.e();
        d.a.i0.a.v1.c.c cVar2 = new d.a.i0.a.v1.c.c(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, bundle);
        cVar2.b(cVar.f45155f);
        e2.h(cVar2);
        if (f42104g) {
            Log.d("PreCodeCacheManager", "current process - " + cVar.f45155f.index);
        }
    }

    public final void p() {
        if (this.f42106a.size() <= 0 || this.f42107b.get() >= this.f42108c) {
            return;
        }
        if (this.f42107b.incrementAndGet() > this.f42108c) {
            this.f42107b.decrementAndGet();
            return;
        }
        j().g();
        if (f42104g) {
            Log.d("PreCodeCacheManager", "start a new code cache fill task");
            Log.d("PreCodeCacheManager", "master size - " + this.f42107b.get());
        }
    }

    public void q() {
        this.f42109d = true;
        p();
    }

    @Override // d.a.i0.a.v1.c.f.a
    public void timeout() {
    }
}
