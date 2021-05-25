package d.a.l0.a.h0.l.g.n;

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
import d.a.l0.a.a1.e;
import d.a.l0.a.h0.d.a;
import d.a.l0.a.h0.l.e;
import d.a.l0.a.h0.l.g.j;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.h2.d;
import d.a.l0.a.k;
import d.a.l0.a.l0.g;
import d.a.l0.a.v2.o0;
import d.a.l0.a.v2.q0;
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
public class a implements d.a.l0.a.v1.c.f.a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f42278g = k.f43199a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f42279h;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f42283d;

    /* renamed from: e  reason: collision with root package name */
    public final int f42284e;

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue<PrefetchEvent> f42280a = new LinkedBlockingQueue();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f42281b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    public final int f42282c = 1;

    /* renamed from: f  reason: collision with root package name */
    public final List<Bundle> f42285f = new ArrayList();

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final int f42286e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f42287f;

        /* renamed from: g  reason: collision with root package name */
        public final BlockingQueue<PrefetchEvent> f42288g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f42289h;

        /* renamed from: i  reason: collision with root package name */
        public c f42290i;
        public int j = 0;

        public b(int i2, @NonNull BlockingQueue<PrefetchEvent> blockingQueue, @NonNull AtomicInteger atomicInteger) {
            this.f42286e = i2 <= 0 ? 30 : i2;
            this.f42287f = false;
            this.f42288g = blockingQueue;
            this.f42289h = atomicInteger;
        }

        public final void a() {
            this.f42287f = true;
            this.f42289h.decrementAndGet();
            b();
            if (a.f42278g) {
                Log.d("PreCodeCacheManager", "CodeCacheFillTask destroy");
            }
        }

        public final void b() {
            c cVar = this.f42290i;
            if (cVar != null) {
                cVar.k();
                this.f42290i = null;
            }
            if (a.f42278g) {
                Log.d("PreCodeCacheManager", "master destroy");
            }
        }

        public final void c(PrefetchEvent prefetchEvent) throws InterruptedException {
            if (this.f42290i == null) {
                this.f42290i = d();
            }
            if (this.f42290i == null) {
                a();
                return;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f42290i.l(prefetchEvent.appPath, prefetchEvent, countDownLatch);
            countDownLatch.await(3L, TimeUnit.SECONDS);
            f();
        }

        public final c d() {
            if (g.N().b0() && e()) {
                return new c();
            }
            if (a.f42278g) {
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
            while (!this.f42287f) {
                try {
                    try {
                        PrefetchEvent poll = this.f42288g.poll(this.f42286e, TimeUnit.SECONDS);
                        if (poll == null) {
                            a();
                        } else {
                            c(poll);
                        }
                    } catch (InterruptedException e2) {
                        if (a.f42278g) {
                            e2.printStackTrace();
                        }
                        a();
                    }
                } catch (Throwable th) {
                    if (a.f42278g) {
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
        public static final AtomicInteger f42291e = new AtomicInteger(1000);

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f42292a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.a.l0.a.h0.l.a f42293b;

        /* renamed from: c  reason: collision with root package name */
        public final List<j> f42294c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f42295d;

        /* renamed from: d.a.l0.a.h0.l.g.n.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0672a implements j {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42296a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ PrefetchEvent f42297b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f42298c;

            public C0672a(String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
                this.f42296a = str;
                this.f42297b = prefetchEvent;
                this.f42298c = countDownLatch;
            }

            @Override // d.a.l0.a.h0.l.g.j
            public void onReady() {
                d.a.l0.a.h0.f.a g2;
                if (c.this.f42293b != null && (g2 = c.this.f42293b.g()) != null && !g2.isDestroyed()) {
                    c.this.s(this.f42296a, g2);
                    c.this.r(g2, this.f42297b);
                    if (a.f42278g) {
                        Log.d("PreCodeCacheManager", "fill code cache finish for - " + this.f42296a);
                    }
                }
                CountDownLatch countDownLatch = this.f42298c;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b extends d.a.l0.a.h0.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f42300a;

            public b(long j) {
                this.f42300a = j;
            }

            @Override // d.a.l0.a.h0.b
            public void a(String str) {
                if (a.f42278g) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.d("PreCodeCacheManager", "create a new master cost - " + (currentTimeMillis - this.f42300a) + "ms");
                }
                super.a(str);
                c.this.f42292a = true;
                c.this.q();
            }
        }

        /* renamed from: d.a.l0.a.h0.l.g.n.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0673c extends e {

            /* renamed from: d.a.l0.a.h0.l.g.n.a$c$c$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0674a extends d.a.l0.a.h0.l.d {
                public C0674a(String str, String str2) {
                    super(str, str2);
                }

                @Override // d.a.l0.a.h0.l.d
                public d.a.l0.a.l0.g e() {
                    g.b bVar = new g.b();
                    bVar.c(1);
                    bVar.b(c.this.n());
                    return bVar.a();
                }
            }

            public C0673c(Context context) {
                super(context);
            }

            @Override // d.a.l0.a.h0.l.e
            public d.a.l0.a.h0.l.d j(String str) {
                return new C0674a(str, "runtime/index.js");
            }
        }

        public final synchronized void g(j jVar) {
            if (jVar == null) {
                return;
            }
            if (this.f42292a) {
                jVar.onReady();
                return;
            }
            if (!this.f42294c.contains(jVar)) {
                this.f42294c.add(jVar);
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
                String m = d.a.l0.a.a1.e.m(new File(file, "app.json"));
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
                String c3 = d.a.l0.a.c2.f.p0.j.c(f2, c2);
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

        public final d.a.l0.a.h0.l.a i() {
            long currentTimeMillis = a.f42278g ? System.currentTimeMillis() : 0L;
            d.a.l0.a.h0.l.a j = j();
            j.loadUrl(o0.w(d.a.l0.a.h0.u.g.N().R()));
            j.c(new b(currentTimeMillis));
            return j;
        }

        public final d.a.l0.a.h0.l.a j() {
            return new C0673c(AppRuntime.getAppContext());
        }

        public void k() {
            if (this.f42293b != null) {
                this.f42293b.destroy();
            }
        }

        public void l(String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
            if (this.f42293b == null) {
                this.f42293b = i();
            }
            this.f42295d.add(str);
            g(new C0672a(str, prefetchEvent, countDownLatch));
        }

        public final V8EngineConfiguration.CodeCacheSetting m() {
            V8EngineConfiguration.CodeCacheSetting codeCacheSetting = new V8EngineConfiguration.CodeCacheSetting();
            codeCacheSetting.id = "appjs";
            ArrayList<String> arrayList = new ArrayList<>();
            codeCacheSetting.pathList = arrayList;
            arrayList.addAll(this.f42295d);
            a.C0645a a2 = a.b.a();
            codeCacheSetting.maxCount = a2.f41959a;
            codeCacheSetting.sizeLimit = a2.f41960b;
            codeCacheSetting.diskCodeCacheSizeThreshold = a2.f41961c;
            return codeCacheSetting;
        }

        public final String n() {
            String str = "master" + f42291e.getAndIncrement();
            if (a.f42278g) {
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
            return d.a.l0.a.a1.e.z(file) && d.a.l0.a.a1.e.y(file);
        }

        public final boolean p(@NonNull SwanAppConfigData swanAppConfigData) {
            String str = swanAppConfigData.m;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return new JSONObject(str).has("_modules");
            } catch (JSONException e2) {
                if (a.f42278g) {
                    e2.printStackTrace();
                }
                return false;
            }
        }

        public final synchronized void q() {
            for (j jVar : this.f42294c) {
                if (jVar != null) {
                    jVar.onReady();
                }
            }
            this.f42294c.clear();
        }

        public final void r(@NonNull d.a.l0.a.h0.f.a aVar, PrefetchEvent prefetchEvent) {
            long currentTimeMillis = a.f42278g ? System.currentTimeMillis() : 0L;
            PrefetchEvent.c h2 = h(prefetchEvent, "preload");
            if (h2 != null) {
                d.a.l0.a.o0.a.a(aVar, h2);
                if (a.f42278g) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("PreCodeCacheManager", "send code cache msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                }
            }
        }

        public final void s(String str, d.a.l0.a.h0.f.a aVar) {
            if (aVar instanceof d.a.l0.a.l0.a) {
                ((d.a.l0.a.l0.a) aVar).C0(m());
            }
        }

        public c() {
            this.f42294c = new ArrayList();
            this.f42295d = new CopyOnWriteArrayList();
        }
    }

    public a() {
        d.a.l0.a.c1.a.Z().getSwitch("swan_preset_code_cache", 0);
        this.f42284e = 0;
        m();
        d.a.l0.a.e0.d.h("PreCodeCacheManager", "swan_preset_code_cache - " + this.f42284e);
        if (f42278g) {
            Log.d("PreCodeCacheManager", "max master size - " + this.f42282c);
        }
    }

    public static a i() {
        if (f42279h == null) {
            synchronized (a.class) {
                if (f42279h == null) {
                    f42279h = new a();
                }
            }
        }
        return f42279h;
    }

    @Override // d.a.l0.a.v1.c.f.a
    public void a(String str, d.a.l0.a.v1.c.f.c cVar) {
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
        if (!ProcessUtils.isMainProcess() || q0.G() || d.a.l0.a.c1.a.n0().c()) {
            int i2 = this.f42284e;
            if (i2 != 0) {
                if (i2 == 1) {
                    if (f42278g) {
                        Log.d("PreCodeCacheManager", "all device preset code cache is on");
                    }
                    z = true;
                } else if (i2 == 2) {
                    if (f42278g) {
                        Log.d("PreCodeCacheManager", "high performance device preset code cache is on");
                    }
                    z = !d.a.l0.a.c1.a.l0().a();
                }
                return !z ? false : false;
            } else if (f42278g) {
                Log.d("PreCodeCacheManager", "preset code cache is off");
            }
            z = false;
            return !z ? false : false;
        }
        return false;
    }

    public final void d(@NonNull PrefetchEvent prefetchEvent) {
        this.f42280a.offer(prefetchEvent);
        if (this.f42283d) {
            p();
        }
    }

    public final void e(String str, long j) {
        if (c(str, j) && !ProcessUtils.isMainProcess()) {
            if (f42278g) {
                Log.d("PreCodeCacheManager", "start to fill code cache app - " + str + " , version - " + j);
            }
            d(b(str, e.C0561e.i(str, String.valueOf(j)).getPath() + File.separator));
        }
    }

    public void f(String str, long j) {
        if (ProcessUtils.isMainProcess() && c(str, j)) {
            d.a.l0.a.v1.c.f.c h2 = h();
            if (h2 == null) {
                if (f42278g) {
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

    public final d.a.l0.a.v1.c.f.c h() {
        d.a.l0.a.v1.c.f.c e2 = d.a.l0.a.v1.c.f.e.k().e();
        if (e2 == null || e2.C()) {
            return null;
        }
        return e2;
    }

    public final b j() {
        return new b(30, this.f42280a, this.f42281b);
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
        this.f42285f.add(bundle);
        if (f42278g) {
            Log.d("PreCodeCacheManager", "add fill code cache msg to cache");
        }
    }

    public final void m() {
        if (ProcessUtils.isMainProcess()) {
            d.a.l0.a.v1.c.f.e.k().b(this);
        }
    }

    public final synchronized void n(d.a.l0.a.v1.c.f.c cVar) {
        if (this.f42285f.size() <= 0) {
            return;
        }
        if (f42278g) {
            Log.d("PreCodeCacheManager", "send msg from cache");
        }
        for (Bundle bundle : this.f42285f) {
            o(cVar, bundle);
        }
        this.f42285f.clear();
    }

    public final void o(d.a.l0.a.v1.c.f.c cVar, Bundle bundle) {
        d.a.l0.a.v1.c.a e2 = d.a.l0.a.v1.c.a.e();
        d.a.l0.a.v1.c.c cVar2 = new d.a.l0.a.v1.c.c(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, bundle);
        cVar2.b(cVar.f45331f);
        e2.h(cVar2);
        if (f42278g) {
            Log.d("PreCodeCacheManager", "current process - " + cVar.f45331f.index);
        }
    }

    public final void p() {
        if (this.f42280a.size() <= 0 || this.f42281b.get() >= this.f42282c) {
            return;
        }
        if (this.f42281b.incrementAndGet() > this.f42282c) {
            this.f42281b.decrementAndGet();
            return;
        }
        j().g();
        if (f42278g) {
            Log.d("PreCodeCacheManager", "start a new code cache fill task");
            Log.d("PreCodeCacheManager", "master size - " + this.f42281b.get());
        }
    }

    public void q() {
        this.f42283d = true;
        p();
    }

    @Override // d.a.l0.a.v1.c.f.a
    public void timeout() {
    }
}
