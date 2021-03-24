package d.b.g0.a.e0.o.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.b.g0.a.e0.g;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f44119h = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.e0.o.a f44120a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c> f44121b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final boolean f44122c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f44123d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f44124e;

    /* renamed from: f  reason: collision with root package name */
    public long f44125f;

    /* renamed from: g  reason: collision with root package name */
    public long f44126g;

    /* loaded from: classes3.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent.c f44127a;

        public a(PrefetchEvent.c cVar) {
            this.f44127a = cVar;
        }

        @Override // d.b.g0.a.e0.o.f.c
        public void onReady() {
            if (d.this.f44120a == null || d.this.f44120a.g() == null || d.this.f44120a.g().isDestroyed()) {
                return;
            }
            d.b.g0.a.k0.a.b(d.this.f44120a.g(), this.f44127a);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends g {
        public b() {
        }

        @Override // d.b.g0.a.e0.g
        public void a(String str) {
            super.a(str);
            if (d.f44119h) {
                Log.d("PreloadMasterManager", "prepareMaster finish. url: " + str);
            }
            d.this.f44123d = true;
            d.this.f44126g = System.currentTimeMillis();
            d.this.o();
            if (d.f44119h) {
                Log.d("PreloadMasterManager", "createBlankOne cost - " + d.this.h() + "ms");
            }
        }
    }

    public d(boolean z, boolean z2) {
        this.f44122c = z;
    }

    public static d g(boolean z, boolean z2) {
        if (f44119h) {
            Log.d("PreloadMasterManager", "start create a blank preload master manager, is default - " + z + ",is v8 - " + z2);
        }
        d dVar = new d(z, z2);
        dVar.f44125f = System.currentTimeMillis();
        long currentTimeMillis = f44119h ? System.currentTimeMillis() : 0L;
        dVar.f44120a = d.b.g0.a.e0.w.d.L().m0(z2, new b());
        if (f44119h) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("PreloadMasterManager", "create a new master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return dVar;
    }

    public synchronized void f(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f44123d) {
            if (f44119h) {
                Log.d("PreloadMasterManager", "is Ready , call back immediately");
            }
            cVar.onReady();
            return;
        }
        if (!this.f44121b.contains(cVar)) {
            this.f44121b.add(cVar);
        }
    }

    public long h() {
        return this.f44126g - this.f44125f;
    }

    public String i() {
        return this.f44124e;
    }

    public d.b.g0.a.e0.o.a j() {
        return this.f44120a;
    }

    public final boolean k(String str, PrefetchEvent.c cVar) {
        return false;
    }

    public boolean l() {
        return this.f44122c;
    }

    public boolean m() {
        return !TextUtils.isEmpty(this.f44124e);
    }

    public boolean n() {
        return this.f44123d;
    }

    public final synchronized void o() {
        if (f44119h) {
            Log.d("PreloadMasterManager", "notifyAllReady, callback size " + this.f44121b.size());
        }
        for (c cVar : this.f44121b) {
            if (cVar != null) {
                cVar.onReady();
            }
        }
        this.f44121b.clear();
    }

    public void p(String str, PrefetchEvent.c cVar) {
        if (cVar == null) {
            if (f44119h) {
                Log.e("PreloadMasterManager", "prefetch event is null");
            }
        } else if (TextUtils.isEmpty(str)) {
            if (f44119h) {
                Log.e("PreloadMasterManager", "prefetch appId is empty");
            }
        } else if (this.f44120a == null) {
            if (f44119h) {
                Log.i("PreloadMasterManager", "mMasterManager not create yet, can not prefetch");
            }
        } else if (this.f44122c && !m()) {
            if (f44119h) {
                Log.i("PreloadMasterManager", "default blank master can not use to prefetch");
            }
        } else if (m() && !TextUtils.equals(str, this.f44124e)) {
            if (f44119h) {
                Log.e("PreloadMasterManager", "one master can only prefetch one appId");
            }
        } else if (k(str, cVar)) {
            if (f44119h) {
                Log.i("PreloadMasterManager", "intercept for current prefetch event - " + str);
            }
        } else {
            this.f44124e = str;
            f(new a(cVar));
            if (f44119h) {
                Log.i("PreloadMasterManager", "fire prefetch event - " + str);
            }
        }
    }

    public void q(String str) {
        this.f44124e = str;
    }
}
