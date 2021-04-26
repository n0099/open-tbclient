package d.a.h0.a.e0.o.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.h0.a.k;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class e implements c {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f42152i = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public d f42155c;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<d.a.h0.a.k0.b.a> f42154b = new LinkedList<>();

    /* renamed from: a  reason: collision with root package name */
    public b f42153a = new b(2);

    /* renamed from: h  reason: collision with root package name */
    public final Object f42160h = new Object();

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f42156d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f42157e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f42158f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42159g = false;

    public final void a() {
        if (!this.f42154b.isEmpty() && this.f42157e) {
            synchronized (this.f42160h) {
                Iterator<d.a.h0.a.k0.b.a> it = this.f42154b.iterator();
                while (it.hasNext()) {
                    d.a.h0.a.k0.b.a next = it.next();
                    if (f42152i) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.f43106a);
                    }
                    d.a.h0.a.e0.w.d.L().A0(next);
                }
                this.f42154b.clear();
            }
        }
    }

    public final void b(d dVar, String str) {
        this.f42155c = dVar;
        dVar.q(str);
        this.f42157e = true;
        a();
        long currentTimeMillis = f42152i ? System.currentTimeMillis() : 0L;
        this.f42153a.a(Collections.singletonList(dVar));
        if (f42152i) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
    }

    public d c() {
        if (!this.f42157e) {
            if (f42152i) {
                Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + d());
                Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
                return null;
            }
            return null;
        }
        return this.f42155c;
    }

    public boolean d() {
        return this.f42158f;
    }

    public void e(d.a.h0.a.k0.b.a aVar) {
        if (aVar == null || this.f42157e) {
            return;
        }
        synchronized (this.f42160h) {
            this.f42154b.add(aVar);
        }
    }

    public boolean f() {
        return this.f42157e;
    }

    public boolean g() {
        return this.f42156d;
    }

    public boolean h() {
        return this.f42159g;
    }

    public void i(String str, PrefetchEvent.c cVar) {
        if (f42152i) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + cVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (f42152i) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.f42157e) {
            d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
            if (O == null) {
                return;
            }
            if (TextUtils.equals(str, O.getAppId())) {
                this.f42155c.p(str, cVar);
                if (f42152i) {
                    Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                }
            } else if (f42152i) {
                Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
            }
        } else if (!this.f42156d) {
            if (f42152i) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.f42160h) {
                if (this.f42157e) {
                    return;
                }
                d c2 = this.f42153a.c(str);
                if (c2 == null) {
                    c2 = d.g(false, this.f42159g);
                    this.f42153a.e(c2);
                }
                c2.p(str, cVar);
            }
        }
    }

    public void j(boolean z, c cVar) {
        if (!this.f42158f) {
            synchronized (this.f42160h) {
                if (!this.f42158f) {
                    this.f42159g = z;
                    d g2 = d.g(true, z);
                    g2.f(this);
                    g2.f(cVar);
                    this.f42153a.e(g2);
                    this.f42158f = true;
                    return;
                }
            }
        }
        if (f42152i) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d c2 = this.f42153a.c("_default_id_");
        if (c2 != null) {
            c2.f(cVar);
        }
    }

    public void k() {
        this.f42156d = false;
        this.f42157e = false;
        this.f42158f = false;
        this.f42159g = false;
        this.f42155c = null;
        this.f42153a.a(null);
        synchronized (this.f42160h) {
            this.f42154b.clear();
        }
        a.c();
    }

    public d l(String str) {
        d c2;
        long currentTimeMillis = f42152i ? System.currentTimeMillis() : 0L;
        if (f42152i) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.f42156d && f42152i) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.f42157e) {
            return this.f42155c;
        }
        synchronized (this.f42160h) {
            if (!this.f42157e) {
                if (TextUtils.isEmpty(str)) {
                    c2 = this.f42153a.c("_default_id_");
                } else {
                    c2 = this.f42153a.c(str);
                    if (c2 == null || !c2.n()) {
                        c2 = this.f42153a.c("_default_id_");
                    }
                }
                b(c2, str);
            }
        }
        if (f42152i) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("SwanAppMasterProvider", "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            StringBuilder sb = new StringBuilder();
            sb.append("final master id - ");
            sb.append(this.f42155c.j().c());
            Log.i("SwanAppMasterProvider", sb.toString());
        }
        return this.f42155c;
    }

    @Override // d.a.h0.a.e0.o.f.c
    public void onReady() {
        this.f42156d = true;
    }
}
