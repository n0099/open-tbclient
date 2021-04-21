package d.b.h0.a.e0.o.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.b.h0.a.k;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class e implements c {
    public static final boolean i = k.f45772a;

    /* renamed from: c  reason: collision with root package name */
    public d f44854c;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<d.b.h0.a.k0.b.a> f44853b = new LinkedList<>();

    /* renamed from: a  reason: collision with root package name */
    public b f44852a = new b(2);

    /* renamed from: h  reason: collision with root package name */
    public final Object f44859h = new Object();

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f44855d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f44856e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f44857f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44858g = false;

    public final void a() {
        if (!this.f44853b.isEmpty() && this.f44856e) {
            synchronized (this.f44859h) {
                Iterator<d.b.h0.a.k0.b.a> it = this.f44853b.iterator();
                while (it.hasNext()) {
                    d.b.h0.a.k0.b.a next = it.next();
                    if (i) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.f45777a);
                    }
                    d.b.h0.a.e0.w.d.L().A0(next);
                }
                this.f44853b.clear();
            }
        }
    }

    public final void b(d dVar, String str) {
        this.f44854c = dVar;
        dVar.q(str);
        this.f44856e = true;
        a();
        long currentTimeMillis = i ? System.currentTimeMillis() : 0L;
        this.f44852a.a(Collections.singletonList(dVar));
        if (i) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
    }

    public d c() {
        if (!this.f44856e) {
            if (i) {
                Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + d());
                Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
                return null;
            }
            return null;
        }
        return this.f44854c;
    }

    public boolean d() {
        return this.f44857f;
    }

    public void e(d.b.h0.a.k0.b.a aVar) {
        if (aVar == null || this.f44856e) {
            return;
        }
        synchronized (this.f44859h) {
            this.f44853b.add(aVar);
        }
    }

    public boolean f() {
        return this.f44856e;
    }

    public boolean g() {
        return this.f44855d;
    }

    public boolean h() {
        return this.f44858g;
    }

    public void i(String str, PrefetchEvent.c cVar) {
        if (i) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + cVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (i) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.f44856e) {
            d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
            if (O == null) {
                return;
            }
            if (TextUtils.equals(str, O.getAppId())) {
                this.f44854c.p(str, cVar);
                if (i) {
                    Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                }
            } else if (i) {
                Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
            }
        } else if (!this.f44855d) {
            if (i) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.f44859h) {
                if (this.f44856e) {
                    return;
                }
                d c2 = this.f44852a.c(str);
                if (c2 == null) {
                    c2 = d.g(false, this.f44858g);
                    this.f44852a.e(c2);
                }
                c2.p(str, cVar);
            }
        }
    }

    public void j(boolean z, c cVar) {
        if (!this.f44857f) {
            synchronized (this.f44859h) {
                if (!this.f44857f) {
                    this.f44858g = z;
                    d g2 = d.g(true, z);
                    g2.f(this);
                    g2.f(cVar);
                    this.f44852a.e(g2);
                    this.f44857f = true;
                    return;
                }
            }
        }
        if (i) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d c2 = this.f44852a.c("_default_id_");
        if (c2 != null) {
            c2.f(cVar);
        }
    }

    public void k() {
        this.f44855d = false;
        this.f44856e = false;
        this.f44857f = false;
        this.f44858g = false;
        this.f44854c = null;
        this.f44852a.a(null);
        synchronized (this.f44859h) {
            this.f44853b.clear();
        }
        a.c();
    }

    public d l(String str) {
        d c2;
        long currentTimeMillis = i ? System.currentTimeMillis() : 0L;
        if (i) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.f44855d && i) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.f44856e) {
            return this.f44854c;
        }
        synchronized (this.f44859h) {
            if (!this.f44856e) {
                if (TextUtils.isEmpty(str)) {
                    c2 = this.f44852a.c("_default_id_");
                } else {
                    c2 = this.f44852a.c(str);
                    if (c2 == null || !c2.n()) {
                        c2 = this.f44852a.c("_default_id_");
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
            sb.append(this.f44854c.j().c());
            Log.i("SwanAppMasterProvider", sb.toString());
        }
        return this.f44854c;
    }

    @Override // d.b.h0.a.e0.o.f.c
    public void onReady() {
        this.f44855d = true;
    }
}
