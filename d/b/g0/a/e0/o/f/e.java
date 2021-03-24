package d.b.g0.a.e0.o.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.b.g0.a.k;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class e implements c {
    public static final boolean i = k.f45050a;

    /* renamed from: c  reason: collision with root package name */
    public d f44132c;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<d.b.g0.a.k0.b.a> f44131b = new LinkedList<>();

    /* renamed from: a  reason: collision with root package name */
    public b f44130a = new b(2);

    /* renamed from: h  reason: collision with root package name */
    public final Object f44137h = new Object();

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f44133d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f44134e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f44135f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44136g = false;

    public final void a() {
        if (!this.f44131b.isEmpty() && this.f44134e) {
            synchronized (this.f44137h) {
                Iterator<d.b.g0.a.k0.b.a> it = this.f44131b.iterator();
                while (it.hasNext()) {
                    d.b.g0.a.k0.b.a next = it.next();
                    if (i) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.f45055a);
                    }
                    d.b.g0.a.e0.w.d.L().A0(next);
                }
                this.f44131b.clear();
            }
        }
    }

    public final void b(d dVar, String str) {
        this.f44132c = dVar;
        dVar.q(str);
        this.f44134e = true;
        a();
        long currentTimeMillis = i ? System.currentTimeMillis() : 0L;
        this.f44130a.a(Collections.singletonList(dVar));
        if (i) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
    }

    public d c() {
        if (!this.f44134e) {
            if (i) {
                Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + d());
                Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
                return null;
            }
            return null;
        }
        return this.f44132c;
    }

    public boolean d() {
        return this.f44135f;
    }

    public void e(d.b.g0.a.k0.b.a aVar) {
        if (aVar == null || this.f44134e) {
            return;
        }
        synchronized (this.f44137h) {
            this.f44131b.add(aVar);
        }
    }

    public boolean f() {
        return this.f44134e;
    }

    public boolean g() {
        return this.f44133d;
    }

    public boolean h() {
        return this.f44136g;
    }

    public void i(String str, PrefetchEvent.c cVar) {
        if (i) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + cVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (i) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.f44134e) {
            d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
            if (O == null) {
                return;
            }
            if (TextUtils.equals(str, O.getAppId())) {
                this.f44132c.p(str, cVar);
                if (i) {
                    Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                }
            } else if (i) {
                Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
            }
        } else if (!this.f44133d) {
            if (i) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.f44137h) {
                if (this.f44134e) {
                    return;
                }
                d c2 = this.f44130a.c(str);
                if (c2 == null) {
                    c2 = d.g(false, this.f44136g);
                    this.f44130a.e(c2);
                }
                c2.p(str, cVar);
            }
        }
    }

    public void j(boolean z, c cVar) {
        if (!this.f44135f) {
            synchronized (this.f44137h) {
                if (!this.f44135f) {
                    this.f44136g = z;
                    d g2 = d.g(true, z);
                    g2.f(this);
                    g2.f(cVar);
                    this.f44130a.e(g2);
                    this.f44135f = true;
                    return;
                }
            }
        }
        if (i) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d c2 = this.f44130a.c("_default_id_");
        if (c2 != null) {
            c2.f(cVar);
        }
    }

    public void k() {
        this.f44133d = false;
        this.f44134e = false;
        this.f44135f = false;
        this.f44136g = false;
        this.f44132c = null;
        this.f44130a.a(null);
        synchronized (this.f44137h) {
            this.f44131b.clear();
        }
        a.c();
    }

    public d l(String str) {
        d c2;
        long currentTimeMillis = i ? System.currentTimeMillis() : 0L;
        if (i) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.f44133d && i) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.f44134e) {
            return this.f44132c;
        }
        synchronized (this.f44137h) {
            if (!this.f44134e) {
                if (TextUtils.isEmpty(str)) {
                    c2 = this.f44130a.c("_default_id_");
                } else {
                    c2 = this.f44130a.c(str);
                    if (c2 == null || !c2.n()) {
                        c2 = this.f44130a.c("_default_id_");
                    }
                }
                b(c2, str);
            }
        }
        if (i) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("SwanAppMasterProvider", "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            StringBuilder sb = new StringBuilder();
            sb.append("final master id - ");
            sb.append(this.f44132c.j().c());
            Log.i("SwanAppMasterProvider", sb.toString());
        }
        return this.f44132c;
    }

    @Override // d.b.g0.a.e0.o.f.c
    public void onReady() {
        this.f44133d = true;
    }
}
