package d.a.m0.a.h0.l.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class l implements b<a>, j {
    public static final boolean k = d.a.m0.a.k.f46983a;
    public static final int l = 2;

    /* renamed from: d  reason: collision with root package name */
    public k f46053d;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<d.a.m0.a.o0.d.a> f46051b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public final List<d<a>> f46052c = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    public final g f46050a = new g(l);
    public final Object j = new Object();

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f46054e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f46055f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f46056g = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46058i = false;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f46057h = false;

    @Override // d.a.m0.a.h0.l.g.c
    public void b(d<a> dVar) {
        if (dVar == null) {
            return;
        }
        synchronized (this.j) {
            if (this.f46055f) {
                if (k) {
                    Log.d("SwanAppMasterProvider", "app already start , call back immediately");
                }
                dVar.a(this.f46057h, this.f46053d);
                return;
            }
            if (!this.f46052c.contains(dVar)) {
                this.f46052c.add(dVar);
            }
        }
    }

    @Override // d.a.m0.a.h0.l.g.b
    public void c(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        if (k) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + cVar);
        }
        d.a.m0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch master");
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
        } else if (this.f46055f) {
            d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
            if (Q == null) {
                return;
            }
            if (TextUtils.equals(str, Q.getAppId())) {
                d.a.m0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch after app start");
                this.f46053d.r(cVar, pMSAppInfo);
                if (k) {
                    Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                }
            } else if (k) {
                Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
            }
        } else if (!this.f46054e) {
            if (k) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.j) {
                if (this.f46055f) {
                    return;
                }
                k d2 = this.f46050a.d(str);
                if (d2 == null) {
                    d2 = k(false, this.f46058i);
                    this.f46050a.f(d2);
                }
                if (d2.w(pMSAppInfo, cVar)) {
                    this.f46050a.c(str);
                    d2 = k(false, this.f46058i);
                    this.f46050a.f(d2);
                }
                this.f46050a.g(Collections.singletonList(d2));
                d2.r(cVar, pMSAppInfo);
            }
        }
    }

    @Override // d.a.m0.a.h0.l.g.b
    public void d(d.a.m0.a.o0.d.a aVar) {
        if (aVar == null || this.f46055f) {
            return;
        }
        synchronized (this.j) {
            this.f46051b.add(aVar);
        }
    }

    @Override // d.a.m0.a.h0.l.g.c
    public boolean f() {
        return this.f46056g;
    }

    @Override // d.a.m0.a.h0.l.g.c
    public boolean g() {
        return this.f46055f;
    }

    @Override // d.a.m0.a.h0.l.g.c
    public boolean h() {
        return this.f46054e;
    }

    @Override // d.a.m0.a.h0.l.g.b
    public boolean i() {
        return this.f46058i;
    }

    @Override // d.a.m0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        if (!this.f46056g) {
            synchronized (this.j) {
                if (!this.f46056g) {
                    this.f46058i = z;
                    k k2 = k(true, z);
                    k2.c(this);
                    k2.c(jVar);
                    this.f46050a.f(k2);
                    this.f46056g = true;
                    return;
                }
            }
        }
        if (k) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        k d2 = this.f46055f ? this.f46053d : this.f46050a.d("_default_id_");
        if (d2 != null) {
            d2.c(jVar);
        }
    }

    public k k(boolean z, boolean z2) {
        return new k(z, z2);
    }

    public final void l() {
        if (!this.f46051b.isEmpty() && this.f46055f) {
            synchronized (this.j) {
                Iterator<d.a.m0.a.o0.d.a> it = this.f46051b.iterator();
                while (it.hasNext()) {
                    d.a.m0.a.o0.d.a next = it.next();
                    if (k) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.f47689a);
                    }
                    d.a.m0.a.h0.u.g.N().H0(next);
                }
                this.f46051b.clear();
            }
        }
    }

    public final void m(boolean z, k kVar, PMSAppInfo pMSAppInfo) {
        this.f46057h = z;
        this.f46053d = kVar;
        kVar.p(pMSAppInfo);
        this.f46055f = true;
        l();
        long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
        this.f46050a.a(Collections.singletonList(kVar));
        if (k) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        o(z, kVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.h0.l.g.c
    /* renamed from: n */
    public k a() {
        if (!this.f46055f) {
            if (k) {
                Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + f());
                Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
                return null;
            }
            return null;
        }
        return this.f46053d;
    }

    public final void o(boolean z, k kVar) {
        if (this.f46052c.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (d<a> dVar : this.f46052c) {
                dVar.a(z, kVar);
            }
            this.f46052c.clear();
        }
        if (k) {
            Log.d("SwanAppMasterProvider", "is hit prefetch env - " + z);
        }
    }

    @Override // d.a.m0.a.h0.l.g.j
    public void onReady() {
        this.f46054e = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.h0.l.g.c
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
        if (!this.f46054e && k) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        String str = pMSAppInfo == null ? null : pMSAppInfo.appId;
        if (this.f46055f) {
            return this.f46053d;
        }
        synchronized (this.j) {
            if (!this.f46055f) {
                boolean z = false;
                if (!TextUtils.isEmpty(str) && pMSAppInfo != null) {
                    d2 = this.f46050a.d(str);
                    if (d2 == null || !d2.n() || d2.w(pMSAppInfo, null)) {
                        d2 = this.f46050a.d("_default_id_");
                    } else {
                        z = true;
                    }
                    m(z, d2, pMSAppInfo);
                }
                d2 = this.f46050a.d("_default_id_");
                m(z, d2, pMSAppInfo);
            }
        }
        if (k) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("SwanAppMasterProvider", "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            StringBuilder sb = new StringBuilder();
            sb.append("final master id - ");
            sb.append(this.f46053d.i().b());
            Log.i("SwanAppMasterProvider", sb.toString());
        }
        return this.f46053d;
    }

    @Override // d.a.m0.a.h0.l.g.c
    public void reset() {
        this.f46054e = false;
        this.f46055f = false;
        this.f46056g = false;
        this.f46058i = false;
        this.f46057h = false;
        this.f46053d = null;
        this.f46050a.a(null);
        synchronized (this.j) {
            this.f46051b.clear();
            this.f46052c.clear();
        }
        e.c();
        h.b().d();
    }
}
