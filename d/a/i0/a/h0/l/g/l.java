package d.a.i0.a.h0.l.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class l implements b<a>, j {
    public static final boolean k = d.a.i0.a.k.f43025a;
    public static final int l = 2;

    /* renamed from: d  reason: collision with root package name */
    public k f42095d;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<d.a.i0.a.o0.d.a> f42093b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public final List<d<a>> f42094c = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    public final g f42092a = new g(l);
    public final Object j = new Object();

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f42096e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f42097f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f42098g = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42100i = false;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f42099h = false;

    @Override // d.a.i0.a.h0.l.g.c
    public void b(d<a> dVar) {
        if (dVar == null) {
            return;
        }
        synchronized (this.j) {
            if (this.f42097f) {
                if (k) {
                    Log.d("SwanAppMasterProvider", "app already start , call back immediately");
                }
                dVar.a(this.f42099h, this.f42095d);
                return;
            }
            if (!this.f42094c.contains(dVar)) {
                this.f42094c.add(dVar);
            }
        }
    }

    @Override // d.a.i0.a.h0.l.g.b
    public void c(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        if (k) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + cVar);
        }
        d.a.i0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch master");
        if (pMSAppInfo == null) {
            if (k) {
                Log.w("SwanAppMasterProvider", "prefetch currentAppInfo is empty");
                return;
            }
            return;
        }
        String str = pMSAppInfo.appId;
        if (TextUtils.isEmpty(str)) {
            if (k) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.f42097f) {
            d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
            if (Q == null) {
                return;
            }
            if (TextUtils.equals(str, Q.getAppId())) {
                d.a.i0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch after app start");
                this.f42095d.r(cVar, pMSAppInfo);
                if (k) {
                    Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                }
            } else if (k) {
                Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
            }
        } else if (!this.f42096e) {
            if (k) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.j) {
                if (this.f42097f) {
                    return;
                }
                k d2 = this.f42092a.d(str);
                if (d2 == null) {
                    d2 = k(false, this.f42100i);
                    this.f42092a.f(d2);
                }
                if (d2.w(pMSAppInfo, cVar)) {
                    this.f42092a.c(str);
                    d2 = k(false, this.f42100i);
                    this.f42092a.f(d2);
                }
                this.f42092a.g(Collections.singletonList(d2));
                d2.r(cVar, pMSAppInfo);
            }
        }
    }

    @Override // d.a.i0.a.h0.l.g.b
    public void d(d.a.i0.a.o0.d.a aVar) {
        if (aVar == null || this.f42097f) {
            return;
        }
        synchronized (this.j) {
            this.f42093b.add(aVar);
        }
    }

    @Override // d.a.i0.a.h0.l.g.c
    public boolean f() {
        return this.f42098g;
    }

    @Override // d.a.i0.a.h0.l.g.c
    public boolean g() {
        return this.f42097f;
    }

    @Override // d.a.i0.a.h0.l.g.c
    public boolean h() {
        return this.f42096e;
    }

    @Override // d.a.i0.a.h0.l.g.b
    public boolean i() {
        return this.f42100i;
    }

    @Override // d.a.i0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        if (!this.f42098g) {
            synchronized (this.j) {
                if (!this.f42098g) {
                    this.f42100i = z;
                    k k2 = k(true, z);
                    k2.c(this);
                    k2.c(jVar);
                    this.f42092a.f(k2);
                    this.f42098g = true;
                    return;
                }
            }
        }
        if (k) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        k d2 = this.f42097f ? this.f42095d : this.f42092a.d("_default_id_");
        if (d2 != null) {
            d2.c(jVar);
        }
    }

    public k k(boolean z, boolean z2) {
        return new k(z, z2);
    }

    public final void l() {
        if (!this.f42093b.isEmpty() && this.f42097f) {
            synchronized (this.j) {
                Iterator<d.a.i0.a.o0.d.a> it = this.f42093b.iterator();
                while (it.hasNext()) {
                    d.a.i0.a.o0.d.a next = it.next();
                    if (k) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.f43731a);
                    }
                    d.a.i0.a.h0.u.g.N().H0(next);
                }
                this.f42093b.clear();
            }
        }
    }

    public final void m(boolean z, k kVar, PMSAppInfo pMSAppInfo) {
        this.f42099h = z;
        this.f42095d = kVar;
        kVar.p(pMSAppInfo);
        this.f42097f = true;
        l();
        long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
        this.f42092a.a(Collections.singletonList(kVar));
        if (k) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        o(z, kVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.h0.l.g.c
    /* renamed from: n */
    public k a() {
        if (!this.f42097f) {
            if (k) {
                Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + f());
                Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
                return null;
            }
            return null;
        }
        return this.f42095d;
    }

    public final void o(boolean z, k kVar) {
        if (this.f42094c.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (d<a> dVar : this.f42094c) {
                dVar.a(z, kVar);
            }
            this.f42094c.clear();
        }
        if (k) {
            Log.d("SwanAppMasterProvider", "is hit prefetch env - " + z);
        }
    }

    @Override // d.a.i0.a.h0.l.g.j
    public void onReady() {
        this.f42096e = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.h0.l.g.c
    /* renamed from: p */
    public k e(PMSAppInfo pMSAppInfo) {
        k d2;
        long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
        if (pMSAppInfo == null && k) {
            Log.e("SwanAppMasterProvider", Log.getStackTraceString(new Exception("currentAppInfo can not be null")));
        }
        if (k) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + pMSAppInfo);
        }
        if (!this.f42096e && k) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        String str = pMSAppInfo == null ? null : pMSAppInfo.appId;
        if (this.f42097f) {
            return this.f42095d;
        }
        synchronized (this.j) {
            if (!this.f42097f) {
                boolean z = false;
                if (!TextUtils.isEmpty(str) && pMSAppInfo != null) {
                    d2 = this.f42092a.d(str);
                    if (d2 == null || !d2.n() || d2.w(pMSAppInfo, null)) {
                        d2 = this.f42092a.d("_default_id_");
                    } else {
                        z = true;
                    }
                    m(z, d2, pMSAppInfo);
                }
                d2 = this.f42092a.d("_default_id_");
                m(z, d2, pMSAppInfo);
            }
        }
        if (k) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("SwanAppMasterProvider", "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            StringBuilder sb = new StringBuilder();
            sb.append("final master id - ");
            sb.append(this.f42095d.i().b());
            Log.i("SwanAppMasterProvider", sb.toString());
        }
        return this.f42095d;
    }

    @Override // d.a.i0.a.h0.l.g.c
    public void reset() {
        this.f42096e = false;
        this.f42097f = false;
        this.f42098g = false;
        this.f42100i = false;
        this.f42099h = false;
        this.f42095d = null;
        this.f42092a.a(null);
        synchronized (this.j) {
            this.f42093b.clear();
            this.f42094c.clear();
        }
        e.c();
        h.b().d();
    }
}
