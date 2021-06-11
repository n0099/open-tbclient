package d.a.l0.a.h0.l.g;

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
    public static final boolean k = d.a.l0.a.k.f46875a;
    public static final int l = 2;

    /* renamed from: d  reason: collision with root package name */
    public k f45945d;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<d.a.l0.a.o0.d.a> f45943b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public final List<d<a>> f45944c = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    public final g f45942a = new g(l);
    public final Object j = new Object();

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f45946e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f45947f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f45948g = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45950i = false;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f45949h = false;

    @Override // d.a.l0.a.h0.l.g.c
    public void b(d<a> dVar) {
        if (dVar == null) {
            return;
        }
        synchronized (this.j) {
            if (this.f45947f) {
                if (k) {
                    Log.d("SwanAppMasterProvider", "app already start , call back immediately");
                }
                dVar.a(this.f45949h, this.f45945d);
                return;
            }
            if (!this.f45944c.contains(dVar)) {
                this.f45944c.add(dVar);
            }
        }
    }

    @Override // d.a.l0.a.h0.l.g.b
    public void c(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        if (k) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + cVar);
        }
        d.a.l0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch master");
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
        } else if (this.f45947f) {
            d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
            if (Q == null) {
                return;
            }
            if (TextUtils.equals(str, Q.getAppId())) {
                d.a.l0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch after app start");
                this.f45945d.r(cVar, pMSAppInfo);
                if (k) {
                    Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                }
            } else if (k) {
                Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
            }
        } else if (!this.f45946e) {
            if (k) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.j) {
                if (this.f45947f) {
                    return;
                }
                k d2 = this.f45942a.d(str);
                if (d2 == null) {
                    d2 = k(false, this.f45950i);
                    this.f45942a.f(d2);
                }
                if (d2.w(pMSAppInfo, cVar)) {
                    this.f45942a.c(str);
                    d2 = k(false, this.f45950i);
                    this.f45942a.f(d2);
                }
                this.f45942a.g(Collections.singletonList(d2));
                d2.r(cVar, pMSAppInfo);
            }
        }
    }

    @Override // d.a.l0.a.h0.l.g.b
    public void d(d.a.l0.a.o0.d.a aVar) {
        if (aVar == null || this.f45947f) {
            return;
        }
        synchronized (this.j) {
            this.f45943b.add(aVar);
        }
    }

    @Override // d.a.l0.a.h0.l.g.c
    public boolean f() {
        return this.f45948g;
    }

    @Override // d.a.l0.a.h0.l.g.c
    public boolean g() {
        return this.f45947f;
    }

    @Override // d.a.l0.a.h0.l.g.c
    public boolean h() {
        return this.f45946e;
    }

    @Override // d.a.l0.a.h0.l.g.b
    public boolean i() {
        return this.f45950i;
    }

    @Override // d.a.l0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        if (!this.f45948g) {
            synchronized (this.j) {
                if (!this.f45948g) {
                    this.f45950i = z;
                    k k2 = k(true, z);
                    k2.c(this);
                    k2.c(jVar);
                    this.f45942a.f(k2);
                    this.f45948g = true;
                    return;
                }
            }
        }
        if (k) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        k d2 = this.f45947f ? this.f45945d : this.f45942a.d("_default_id_");
        if (d2 != null) {
            d2.c(jVar);
        }
    }

    public k k(boolean z, boolean z2) {
        return new k(z, z2);
    }

    public final void l() {
        if (!this.f45943b.isEmpty() && this.f45947f) {
            synchronized (this.j) {
                Iterator<d.a.l0.a.o0.d.a> it = this.f45943b.iterator();
                while (it.hasNext()) {
                    d.a.l0.a.o0.d.a next = it.next();
                    if (k) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.f47581a);
                    }
                    d.a.l0.a.h0.u.g.N().H0(next);
                }
                this.f45943b.clear();
            }
        }
    }

    public final void m(boolean z, k kVar, PMSAppInfo pMSAppInfo) {
        this.f45949h = z;
        this.f45945d = kVar;
        kVar.p(pMSAppInfo);
        this.f45947f = true;
        l();
        long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
        this.f45942a.a(Collections.singletonList(kVar));
        if (k) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        o(z, kVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.h0.l.g.c
    /* renamed from: n */
    public k a() {
        if (!this.f45947f) {
            if (k) {
                Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + f());
                Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
                return null;
            }
            return null;
        }
        return this.f45945d;
    }

    public final void o(boolean z, k kVar) {
        if (this.f45944c.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (d<a> dVar : this.f45944c) {
                dVar.a(z, kVar);
            }
            this.f45944c.clear();
        }
        if (k) {
            Log.d("SwanAppMasterProvider", "is hit prefetch env - " + z);
        }
    }

    @Override // d.a.l0.a.h0.l.g.j
    public void onReady() {
        this.f45946e = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.h0.l.g.c
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
        if (!this.f45946e && k) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        String str = pMSAppInfo == null ? null : pMSAppInfo.appId;
        if (this.f45947f) {
            return this.f45945d;
        }
        synchronized (this.j) {
            if (!this.f45947f) {
                boolean z = false;
                if (!TextUtils.isEmpty(str) && pMSAppInfo != null) {
                    d2 = this.f45942a.d(str);
                    if (d2 == null || !d2.n() || d2.w(pMSAppInfo, null)) {
                        d2 = this.f45942a.d("_default_id_");
                    } else {
                        z = true;
                    }
                    m(z, d2, pMSAppInfo);
                }
                d2 = this.f45942a.d("_default_id_");
                m(z, d2, pMSAppInfo);
            }
        }
        if (k) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("SwanAppMasterProvider", "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            StringBuilder sb = new StringBuilder();
            sb.append("final master id - ");
            sb.append(this.f45945d.i().b());
            Log.i("SwanAppMasterProvider", sb.toString());
        }
        return this.f45945d;
    }

    @Override // d.a.l0.a.h0.l.g.c
    public void reset() {
        this.f45946e = false;
        this.f45947f = false;
        this.f45948g = false;
        this.f45950i = false;
        this.f45949h = false;
        this.f45945d = null;
        this.f45942a.a(null);
        synchronized (this.j) {
            this.f45943b.clear();
            this.f45944c.clear();
        }
        e.c();
        h.b().d();
    }
}
