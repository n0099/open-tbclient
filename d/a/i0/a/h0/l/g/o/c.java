package d.a.i0.a.h0.l.g.o;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.i0.a.a2.e;
import d.a.i0.a.h0.l.g.d;
import d.a.i0.a.h0.l.g.h;
import d.a.i0.a.h0.l.g.j;
import d.a.i0.a.h0.l.g.o.a;
import d.a.i0.a.h0.u.g;
import d.a.i0.a.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements d.a.i0.a.h0.l.g.b<d.a.i0.a.h0.l.g.a>, j {
    public static final boolean k = k.f43025a;
    public static final boolean l;

    /* renamed from: a  reason: collision with root package name */
    public volatile b f42135a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f42136b;

    /* renamed from: e  reason: collision with root package name */
    public b f42139e;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<d.a.i0.a.o0.d.a> f42137c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public final List<d<d.a.i0.a.h0.l.g.a>> f42138d = new LinkedList();
    public final Object j = new Object();

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f42140f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f42141g = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42143i = false;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f42142h = false;

    static {
        l = d.a.i0.a.h0.o.e.a.j() == 1;
    }

    @Override // d.a.i0.a.h0.l.g.c
    public void b(d<d.a.i0.a.h0.l.g.a> dVar) {
        if (dVar == null) {
            return;
        }
        synchronized (this.j) {
            if (this.f42141g) {
                if (k) {
                    Log.d("SwanAppMasterProviderMulti", "app already start , call back immediately");
                }
                dVar.a(this.f42142h, this.f42139e);
                return;
            }
            if (!this.f42138d.contains(dVar)) {
                this.f42138d.add(dVar);
            }
        }
    }

    @Override // d.a.i0.a.h0.l.g.b
    public void c(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        if (k) {
            Log.i("SwanAppMasterProviderMulti", "get a prefetch event - " + cVar);
        }
        if (!this.f42140f) {
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "can not prefetch before default mater ready");
                return;
            }
            return;
        }
        d.a.i0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch master");
        if (pMSAppInfo != null) {
            String str = pMSAppInfo.appId;
            if (!TextUtils.isEmpty(str)) {
                if (k) {
                    a.c().h("SwanAppMasterProviderMulti");
                }
                if (this.f42141g) {
                    e Q = e.Q();
                    if (Q != null && TextUtils.equals(str, Q.getAppId())) {
                        d.a.i0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch after app start");
                        this.f42139e.r(cVar, pMSAppInfo);
                        return;
                    } else if (k) {
                        Log.w("SwanAppMasterProviderMulti", "can not prefetch after swan app start, only same app allowed");
                        return;
                    } else {
                        return;
                    }
                }
                synchronized (this.j) {
                    if (this.f42141g) {
                        return;
                    }
                    if (this.f42136b == null || this.f42136b.w(pMSAppInfo, cVar)) {
                        m(this.f42136b);
                        this.f42136b = l(false, this.f42143i);
                    }
                    this.f42136b.r(cVar, pMSAppInfo);
                    return;
                }
            }
        }
        if (k) {
            Log.w("SwanAppMasterProviderMulti", "prefetch currentAppInfo is empty or appId is empty");
        }
    }

    @Override // d.a.i0.a.h0.l.g.b
    public void d(d.a.i0.a.o0.d.a aVar) {
        if (aVar == null || this.f42141g) {
            return;
        }
        synchronized (this.j) {
            this.f42137c.add(aVar);
        }
    }

    @Override // d.a.i0.a.h0.l.g.c
    public boolean f() {
        return this.f42135a != null;
    }

    @Override // d.a.i0.a.h0.l.g.c
    public boolean g() {
        return this.f42141g;
    }

    @Override // d.a.i0.a.h0.l.g.c
    public boolean h() {
        return this.f42140f;
    }

    @Override // d.a.i0.a.h0.l.g.b
    public boolean i() {
        return this.f42143i;
    }

    @Override // d.a.i0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        if (this.f42135a == null) {
            synchronized (this.j) {
                if (this.f42135a == null) {
                    this.f42143i = z;
                    this.f42135a = l(true, z);
                    this.f42135a.c(this);
                    this.f42135a.c(jVar);
                    return;
                }
            }
        }
        if (k) {
            Log.w("SwanAppMasterProviderMulti", "call prepareDefault repeat");
        }
        if (this.f42135a != null) {
            this.f42135a.c(jVar);
        }
    }

    public final void k(b bVar) {
        b bVar2 = bVar == this.f42136b ? this.f42135a : this.f42136b;
        this.f42135a = bVar;
        m(bVar2);
        this.f42136b = null;
    }

    public b l(boolean z, boolean z2) {
        a.c().b(!z);
        return new b(z, z2);
    }

    public final void m(b bVar) {
        if (bVar == null || bVar.i() == null) {
            return;
        }
        bVar.i().destroy();
        if (k) {
            Log.i("SwanAppMasterProviderMulti", "master destroy, id - " + bVar.i().b() + ", isReady - " + bVar.n() + ", is Default - " + bVar.l());
        }
    }

    public final void n() {
        if (!this.f42137c.isEmpty() && this.f42141g) {
            synchronized (this.j) {
                Iterator<d.a.i0.a.o0.d.a> it = this.f42137c.iterator();
                while (it.hasNext()) {
                    d.a.i0.a.o0.d.a next = it.next();
                    if (k) {
                        Log.d("SwanAppMasterProviderMulti", "dispatchPendingEvents event: " + next.f43731a);
                    }
                    g.N().H0(next);
                }
                this.f42137c.clear();
            }
        }
    }

    public final void o(boolean z, b bVar, PMSAppInfo pMSAppInfo) {
        this.f42142h = z;
        this.f42139e = bVar;
        bVar.p(pMSAppInfo);
        this.f42141g = true;
        n();
        k(bVar);
        long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
        if (k) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("SwanAppMasterProviderMulti", "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        q(z, bVar);
        a.c().a();
    }

    @Override // d.a.i0.a.h0.l.g.j
    public void onReady() {
        this.f42140f = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.h0.l.g.c
    /* renamed from: p */
    public b a() {
        if (!this.f42141g) {
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "master not final confirmed, has default - " + f());
                Log.w("SwanAppMasterProviderMulti", Log.getStackTraceString(new RuntimeException("throw by debug")));
                return null;
            }
            return null;
        }
        return this.f42139e;
    }

    public final void q(boolean z, b bVar) {
        if (this.f42138d.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (d<d.a.i0.a.h0.l.g.a> dVar : this.f42138d) {
                dVar.a(z, bVar);
            }
            this.f42138d.clear();
        }
        if (k) {
            Log.d("SwanAppMasterProviderMulti", "is hit prefetch env - " + z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0124, code lost:
        if (r7 == false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0128 A[Catch: all -> 0x017c, TryCatch #0 {, blocks: (B:21:0x0061, B:23:0x0065, B:25:0x0069, B:26:0x0072, B:28:0x0078, B:32:0x0084, B:34:0x008d, B:56:0x0131, B:35:0x0091, B:37:0x0099, B:38:0x009d, B:40:0x00c2, B:45:0x011b, B:52:0x0128, B:53:0x012b, B:54:0x012e, B:57:0x0134), top: B:66:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012b A[Catch: all -> 0x017c, TryCatch #0 {, blocks: (B:21:0x0061, B:23:0x0065, B:25:0x0069, B:26:0x0072, B:28:0x0078, B:32:0x0084, B:34:0x008d, B:56:0x0131, B:35:0x0091, B:37:0x0099, B:38:0x009d, B:40:0x00c2, B:45:0x011b, B:52:0x0128, B:53:0x012b, B:54:0x012e, B:57:0x0134), top: B:66:0x0061 }] */
    @Override // d.a.i0.a.h0.l.g.c
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b e(PMSAppInfo pMSAppInfo) {
        b bVar;
        long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
        if ((pMSAppInfo == null || !this.f42140f) && k) {
            Log.e("SwanAppMasterProviderMulti", Log.getStackTraceString(new Exception("currentAppInfo can not be null， and should call startApp after preload finished")));
        }
        if (k) {
            Log.w("SwanAppMasterProviderMulti", "real start a swan app - " + pMSAppInfo);
            Log.w("SwanAppMasterProviderMulti", "is default master ready - " + this.f42140f);
        }
        if (this.f42141g) {
            return this.f42139e;
        }
        synchronized (this.j) {
            if (!this.f42141g) {
                if (k) {
                    a.c().h("SwanAppMasterProviderMulti");
                }
                boolean z = true;
                if (this.f42136b != null && this.f42136b.n() && pMSAppInfo != null) {
                    if (this.f42136b.w(pMSAppInfo, null)) {
                        bVar = this.f42135a;
                        z = false;
                        o(z, bVar, pMSAppInfo);
                    } else {
                        if (this.f42136b.j()) {
                            bVar = this.f42136b;
                        } else {
                            a.C0664a c0664a = new a.C0664a(pMSAppInfo.appKey, pMSAppInfo.versionCode);
                            boolean f2 = a.c().f(c0664a);
                            boolean g2 = a.c().g(c0664a);
                            boolean e2 = a.c().e();
                            if (k) {
                                Log.d("SwanAppMasterProviderMulti", "app - " + c0664a + ", is loaded - " + f2);
                                Log.d("SwanAppMasterProviderMulti", "app - " + c0664a + ", is loading - " + g2);
                                StringBuilder sb = new StringBuilder();
                                sb.append("has loading app now - ");
                                sb.append(e2);
                                Log.d("SwanAppMasterProviderMulti", sb.toString());
                            }
                            if (e2 && !g2) {
                                if (f2 && l) {
                                    bVar = z ? this.f42136b : this.f42135a;
                                }
                                z = false;
                                if (z) {
                                }
                            }
                            if (z) {
                            }
                        }
                        o(z, bVar, pMSAppInfo);
                    }
                }
                bVar = this.f42135a;
                z = false;
                o(z, bVar, pMSAppInfo);
            }
        }
        if (k) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("SwanAppMasterProviderMulti", "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("final master id - ");
            sb2.append(this.f42139e.i().b());
            Log.i("SwanAppMasterProviderMulti", sb2.toString());
        }
        return this.f42139e;
    }

    @Override // d.a.i0.a.h0.l.g.c
    public void reset() {
        if (k) {
            Log.d("SwanAppMasterProviderMulti", "release master provider");
        }
        this.f42140f = false;
        this.f42141g = false;
        this.f42143i = false;
        this.f42142h = false;
        m(this.f42135a);
        m(this.f42136b);
        this.f42135a = null;
        this.f42136b = null;
        this.f42139e = null;
        synchronized (this.j) {
            this.f42137c.clear();
            this.f42138d.clear();
        }
        d.a.i0.a.h0.l.g.e.c();
        h.b().d();
        a.c().a();
    }
}
