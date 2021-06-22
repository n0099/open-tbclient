package d.a.m0.a.h0.l.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.a.a1.e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a {
    public static final boolean k = d.a.m0.a.k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.h0.l.a f46025a;

    /* renamed from: b  reason: collision with root package name */
    public final List<j> f46026b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public volatile PMSAppInfo f46027c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PrefetchEvent.c f46028d;

    /* renamed from: e  reason: collision with root package name */
    public volatile i f46029e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f46030f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f46031g;

    /* renamed from: h  reason: collision with root package name */
    public long f46032h;

    /* renamed from: i  reason: collision with root package name */
    public long f46033i;
    public final boolean j;

    /* renamed from: d.a.m0.a.h0.l.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0729a extends d.a.m0.a.h0.b {
        public C0729a() {
        }

        @Override // d.a.m0.a.h0.b
        public void a(String str) {
            super.a(str);
            if (a.k) {
                Log.d("BasePreloadMasterManager", "prepareMaster finish. url: " + str);
            }
            a.this.f46031g = true;
            a.this.f46033i = System.currentTimeMillis();
            a.this.o();
            if (a.k) {
                Log.d("BasePreloadMasterManager", "createBlankOne cost - " + a.this.f() + "ms");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f46035a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent.c f46036b;

        public b(PMSAppInfo pMSAppInfo, PrefetchEvent.c cVar) {
            this.f46035a = pMSAppInfo;
            this.f46036b = cVar;
        }

        @Override // d.a.m0.a.h0.l.g.j
        public void onReady() {
            d.a.m0.a.h0.l.a i2 = a.this.i();
            if (i2 == null || i2.g() == null || i2.g().isDestroyed()) {
                return;
            }
            a.this.q(this.f46035a);
            d.a.m0.a.o0.a.a(i2.g(), this.f46036b);
            d.a.m0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch master finish - " + this.f46036b.toString());
        }
    }

    public a(boolean z, boolean z2) {
        this.j = z2;
        this.f46030f = z;
        e();
    }

    public synchronized void c(j jVar) {
        if (jVar == null) {
            return;
        }
        if (this.f46031g) {
            if (k) {
                Log.d("BasePreloadMasterManager", "is Ready , call back immediately");
            }
            jVar.onReady();
            return;
        }
        if (!this.f46026b.contains(jVar)) {
            this.f46026b.add(jVar);
        }
    }

    public void d(PMSAppInfo pMSAppInfo) {
        this.f46027c = pMSAppInfo;
        h.b().c(this);
    }

    public final void e() {
        if (k) {
            Log.d("BasePreloadMasterManager", "start create a blank preload master manager, is default - " + this.f46030f + ",is v8 - " + this.j);
        }
        this.f46032h = System.currentTimeMillis();
        long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
        this.f46025a = d.a.m0.a.h0.u.g.N().t0(this.j, new C0729a());
        if (k) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("BasePreloadMasterManager", "create a new master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
    }

    public long f() {
        return this.f46033i - this.f46032h;
    }

    public PMSAppInfo g() {
        return this.f46027c;
    }

    public String h() {
        if (this.f46027c != null) {
            return this.f46027c.appId;
        }
        return null;
    }

    public d.a.m0.a.h0.l.a i() {
        return this.f46025a;
    }

    public boolean j() {
        return this.f46029e != null;
    }

    public boolean k(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        return false;
    }

    public boolean l() {
        return this.f46030f;
    }

    public boolean m(PrefetchEvent.c cVar, PrefetchEvent.c cVar2) {
        String str;
        if (cVar2 == null) {
            return false;
        }
        if (cVar == null) {
            d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
            str = Q != null ? Q.J().e("dynamicLibPath", null) : null;
        } else {
            str = cVar.h().get("dynamicLibPath");
        }
        String str2 = cVar2.h().get("dynamicLibPath");
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        return !TextUtils.equals(TextUtils.isEmpty(str2) ? null : str2, str);
    }

    public boolean n() {
        return this.f46031g;
    }

    public final synchronized void o() {
        if (k) {
            Log.d("BasePreloadMasterManager", "notifyAllReady, callback size " + this.f46026b.size());
        }
        for (j jVar : this.f46026b) {
            if (jVar != null) {
                jVar.onReady();
            }
        }
        this.f46026b.clear();
    }

    public void p(PMSAppInfo pMSAppInfo) {
        d(pMSAppInfo);
        this.f46029e = null;
        this.f46028d = null;
    }

    public void q(PMSAppInfo pMSAppInfo) {
        v(pMSAppInfo);
        d.a.m0.a.h0.q.a.e(pMSAppInfo.appId);
    }

    public void r(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        if (cVar == null) {
            if (k) {
                Log.e("BasePreloadMasterManager", "prefetch event is null");
            }
        } else if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
            if (this.f46025a == null) {
                if (k) {
                    Log.i("BasePreloadMasterManager", "mMasterManager not create yet, can not prefetch");
                }
            } else if (l() && this.f46027c == null) {
                if (k) {
                    Log.i("BasePreloadMasterManager", "default blank master can not use to prefetch");
                }
            } else if (k(cVar, pMSAppInfo)) {
            } else {
                d(pMSAppInfo);
                s(cVar);
                t(cVar, pMSAppInfo);
                u(cVar, pMSAppInfo);
            }
        } else if (k) {
            Log.e("BasePreloadMasterManager", "prefetch currentAppInfo is empty");
        }
    }

    public void s(PrefetchEvent.c cVar) {
        this.f46028d = cVar;
        if (k) {
            Log.d("BasePreloadMasterManager", "fire prefetch event name - " + cVar.f47689a);
        }
    }

    public final void t(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        if (cVar.i()) {
            this.f46029e = new i();
            this.f46029e.f46047a = pMSAppInfo.appId;
            this.f46029e.f46048b = pMSAppInfo;
            this.f46029e.f46049c = cVar;
        }
    }

    public void u(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        c(new b(pMSAppInfo, cVar));
        if (k) {
            Log.i("BasePreloadMasterManager", "fire prefetch event - " + pMSAppInfo.appId + ", version -" + pMSAppInfo.versionCode);
        }
    }

    public void v(PMSAppInfo pMSAppInfo) {
        d.a.m0.a.h0.l.a aVar = this.f46025a;
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || aVar == null) {
            return;
        }
        if (k) {
            Log.d("BasePreloadMasterManager", "set code cache setting before preload/prefetch");
        }
        d.a.m0.a.h0.f.a g2 = aVar.g();
        String str = e.C0620e.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)).getPath() + File.separator;
        if (g2 instanceof d.a.m0.a.l0.a) {
            ((d.a.m0.a.l0.a) g2).C0(d.a.m0.a.h0.d.a.a("appjs", str));
        } else if (g2 instanceof NgWebView) {
            ((NgWebView) g2).getSettings().setCodeCacheSetting(d.a.m0.a.h0.d.b.a("appjs", str));
        }
    }
}
