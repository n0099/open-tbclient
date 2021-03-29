package d.b.g0.a.e0.o.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.b.g0.a.e0.g;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f44120h = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.e0.o.a f44121a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c> f44122b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final boolean f44123c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f44124d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f44125e;

    /* renamed from: f  reason: collision with root package name */
    public long f44126f;

    /* renamed from: g  reason: collision with root package name */
    public long f44127g;

    /* loaded from: classes2.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent.c f44128a;

        public a(PrefetchEvent.c cVar) {
            this.f44128a = cVar;
        }

        @Override // d.b.g0.a.e0.o.f.c
        public void onReady() {
            if (d.this.f44121a == null || d.this.f44121a.g() == null || d.this.f44121a.g().isDestroyed()) {
                return;
            }
            d.b.g0.a.k0.a.b(d.this.f44121a.g(), this.f44128a);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends g {
        public b() {
        }

        @Override // d.b.g0.a.e0.g
        public void a(String str) {
            super.a(str);
            if (d.f44120h) {
                Log.d("PreloadMasterManager", "prepareMaster finish. url: " + str);
            }
            d.this.f44124d = true;
            d.this.f44127g = System.currentTimeMillis();
            d.this.o();
            if (d.f44120h) {
                Log.d("PreloadMasterManager", "createBlankOne cost - " + d.this.h() + "ms");
            }
        }
    }

    public d(boolean z, boolean z2) {
        this.f44123c = z;
    }

    public static d g(boolean z, boolean z2) {
        if (f44120h) {
            Log.d("PreloadMasterManager", "start create a blank preload master manager, is default - " + z + ",is v8 - " + z2);
        }
        d dVar = new d(z, z2);
        dVar.f44126f = System.currentTimeMillis();
        long currentTimeMillis = f44120h ? System.currentTimeMillis() : 0L;
        dVar.f44121a = d.b.g0.a.e0.w.d.L().m0(z2, new b());
        if (f44120h) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("PreloadMasterManager", "create a new master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return dVar;
    }

    public synchronized void f(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f44124d) {
            if (f44120h) {
                Log.d("PreloadMasterManager", "is Ready , call back immediately");
            }
            cVar.onReady();
            return;
        }
        if (!this.f44122b.contains(cVar)) {
            this.f44122b.add(cVar);
        }
    }

    public long h() {
        return this.f44127g - this.f44126f;
    }

    public String i() {
        return this.f44125e;
    }

    public d.b.g0.a.e0.o.a j() {
        return this.f44121a;
    }

    public final boolean k(String str, PrefetchEvent.c cVar) {
        return false;
    }

    public boolean l() {
        return this.f44123c;
    }

    public boolean m() {
        return !TextUtils.isEmpty(this.f44125e);
    }

    public boolean n() {
        return this.f44124d;
    }

    public final synchronized void o() {
        if (f44120h) {
            Log.d("PreloadMasterManager", "notifyAllReady, callback size " + this.f44122b.size());
        }
        for (c cVar : this.f44122b) {
            if (cVar != null) {
                cVar.onReady();
            }
        }
        this.f44122b.clear();
    }

    public void p(String str, PrefetchEvent.c cVar) {
        if (cVar == null) {
            if (f44120h) {
                Log.e("PreloadMasterManager", "prefetch event is null");
            }
        } else if (TextUtils.isEmpty(str)) {
            if (f44120h) {
                Log.e("PreloadMasterManager", "prefetch appId is empty");
            }
        } else if (this.f44121a == null) {
            if (f44120h) {
                Log.i("PreloadMasterManager", "mMasterManager not create yet, can not prefetch");
            }
        } else if (this.f44123c && !m()) {
            if (f44120h) {
                Log.i("PreloadMasterManager", "default blank master can not use to prefetch");
            }
        } else if (m() && !TextUtils.equals(str, this.f44125e)) {
            if (f44120h) {
                Log.e("PreloadMasterManager", "one master can only prefetch one appId");
            }
        } else if (k(str, cVar)) {
            if (f44120h) {
                Log.i("PreloadMasterManager", "intercept for current prefetch event - " + str);
            }
        } else {
            this.f44125e = str;
            f(new a(cVar));
            if (f44120h) {
                Log.i("PreloadMasterManager", "fire prefetch event - " + str);
            }
        }
    }

    public void q(String str) {
        this.f44125e = str;
    }
}
