package d.a.h0.a.e0.o.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.h0.a.e0.g;
import d.a.h0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f42141h = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.a.e0.o.a f42142a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c> f42143b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final boolean f42144c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f42145d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f42146e;

    /* renamed from: f  reason: collision with root package name */
    public long f42147f;

    /* renamed from: g  reason: collision with root package name */
    public long f42148g;

    /* loaded from: classes2.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent.c f42149a;

        public a(PrefetchEvent.c cVar) {
            this.f42149a = cVar;
        }

        @Override // d.a.h0.a.e0.o.f.c
        public void onReady() {
            if (d.this.f42142a == null || d.this.f42142a.g() == null || d.this.f42142a.g().isDestroyed()) {
                return;
            }
            d.a.h0.a.k0.a.b(d.this.f42142a.g(), this.f42149a);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends g {
        public b() {
        }

        @Override // d.a.h0.a.e0.g
        public void a(String str) {
            super.a(str);
            if (d.f42141h) {
                Log.d("PreloadMasterManager", "prepareMaster finish. url: " + str);
            }
            d.this.f42145d = true;
            d.this.f42148g = System.currentTimeMillis();
            d.this.o();
            if (d.f42141h) {
                Log.d("PreloadMasterManager", "createBlankOne cost - " + d.this.h() + "ms");
            }
        }
    }

    public d(boolean z, boolean z2) {
        this.f42144c = z;
    }

    public static d g(boolean z, boolean z2) {
        if (f42141h) {
            Log.d("PreloadMasterManager", "start create a blank preload master manager, is default - " + z + ",is v8 - " + z2);
        }
        d dVar = new d(z, z2);
        dVar.f42147f = System.currentTimeMillis();
        long currentTimeMillis = f42141h ? System.currentTimeMillis() : 0L;
        dVar.f42142a = d.a.h0.a.e0.w.d.L().m0(z2, new b());
        if (f42141h) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("PreloadMasterManager", "create a new master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return dVar;
    }

    public synchronized void f(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f42145d) {
            if (f42141h) {
                Log.d("PreloadMasterManager", "is Ready , call back immediately");
            }
            cVar.onReady();
            return;
        }
        if (!this.f42143b.contains(cVar)) {
            this.f42143b.add(cVar);
        }
    }

    public long h() {
        return this.f42148g - this.f42147f;
    }

    public String i() {
        return this.f42146e;
    }

    public d.a.h0.a.e0.o.a j() {
        return this.f42142a;
    }

    public final boolean k(String str, PrefetchEvent.c cVar) {
        return false;
    }

    public boolean l() {
        return this.f42144c;
    }

    public boolean m() {
        return !TextUtils.isEmpty(this.f42146e);
    }

    public boolean n() {
        return this.f42145d;
    }

    public final synchronized void o() {
        if (f42141h) {
            Log.d("PreloadMasterManager", "notifyAllReady, callback size " + this.f42143b.size());
        }
        for (c cVar : this.f42143b) {
            if (cVar != null) {
                cVar.onReady();
            }
        }
        this.f42143b.clear();
    }

    public void p(String str, PrefetchEvent.c cVar) {
        if (cVar == null) {
            if (f42141h) {
                Log.e("PreloadMasterManager", "prefetch event is null");
            }
        } else if (TextUtils.isEmpty(str)) {
            if (f42141h) {
                Log.e("PreloadMasterManager", "prefetch appId is empty");
            }
        } else if (this.f42142a == null) {
            if (f42141h) {
                Log.i("PreloadMasterManager", "mMasterManager not create yet, can not prefetch");
            }
        } else if (this.f42144c && !m()) {
            if (f42141h) {
                Log.i("PreloadMasterManager", "default blank master can not use to prefetch");
            }
        } else if (m() && !TextUtils.equals(str, this.f42146e)) {
            if (f42141h) {
                Log.e("PreloadMasterManager", "one master can only prefetch one appId");
            }
        } else if (k(str, cVar)) {
            if (f42141h) {
                Log.i("PreloadMasterManager", "intercept for current prefetch event - " + str);
            }
        } else {
            this.f42146e = str;
            f(new a(cVar));
            if (f42141h) {
                Log.i("PreloadMasterManager", "fire prefetch event - " + str);
            }
        }
    }

    public void q(String str) {
        this.f42146e = str;
    }
}
