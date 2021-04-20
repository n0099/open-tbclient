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
    public static final boolean f44512h = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.e0.o.a f44513a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c> f44514b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final boolean f44515c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f44516d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f44517e;

    /* renamed from: f  reason: collision with root package name */
    public long f44518f;

    /* renamed from: g  reason: collision with root package name */
    public long f44519g;

    /* loaded from: classes2.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent.c f44520a;

        public a(PrefetchEvent.c cVar) {
            this.f44520a = cVar;
        }

        @Override // d.b.g0.a.e0.o.f.c
        public void onReady() {
            if (d.this.f44513a == null || d.this.f44513a.g() == null || d.this.f44513a.g().isDestroyed()) {
                return;
            }
            d.b.g0.a.k0.a.b(d.this.f44513a.g(), this.f44520a);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends g {
        public b() {
        }

        @Override // d.b.g0.a.e0.g
        public void a(String str) {
            super.a(str);
            if (d.f44512h) {
                Log.d("PreloadMasterManager", "prepareMaster finish. url: " + str);
            }
            d.this.f44516d = true;
            d.this.f44519g = System.currentTimeMillis();
            d.this.o();
            if (d.f44512h) {
                Log.d("PreloadMasterManager", "createBlankOne cost - " + d.this.h() + "ms");
            }
        }
    }

    public d(boolean z, boolean z2) {
        this.f44515c = z;
    }

    public static d g(boolean z, boolean z2) {
        if (f44512h) {
            Log.d("PreloadMasterManager", "start create a blank preload master manager, is default - " + z + ",is v8 - " + z2);
        }
        d dVar = new d(z, z2);
        dVar.f44518f = System.currentTimeMillis();
        long currentTimeMillis = f44512h ? System.currentTimeMillis() : 0L;
        dVar.f44513a = d.b.g0.a.e0.w.d.L().m0(z2, new b());
        if (f44512h) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("PreloadMasterManager", "create a new master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return dVar;
    }

    public synchronized void f(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f44516d) {
            if (f44512h) {
                Log.d("PreloadMasterManager", "is Ready , call back immediately");
            }
            cVar.onReady();
            return;
        }
        if (!this.f44514b.contains(cVar)) {
            this.f44514b.add(cVar);
        }
    }

    public long h() {
        return this.f44519g - this.f44518f;
    }

    public String i() {
        return this.f44517e;
    }

    public d.b.g0.a.e0.o.a j() {
        return this.f44513a;
    }

    public final boolean k(String str, PrefetchEvent.c cVar) {
        return false;
    }

    public boolean l() {
        return this.f44515c;
    }

    public boolean m() {
        return !TextUtils.isEmpty(this.f44517e);
    }

    public boolean n() {
        return this.f44516d;
    }

    public final synchronized void o() {
        if (f44512h) {
            Log.d("PreloadMasterManager", "notifyAllReady, callback size " + this.f44514b.size());
        }
        for (c cVar : this.f44514b) {
            if (cVar != null) {
                cVar.onReady();
            }
        }
        this.f44514b.clear();
    }

    public void p(String str, PrefetchEvent.c cVar) {
        if (cVar == null) {
            if (f44512h) {
                Log.e("PreloadMasterManager", "prefetch event is null");
            }
        } else if (TextUtils.isEmpty(str)) {
            if (f44512h) {
                Log.e("PreloadMasterManager", "prefetch appId is empty");
            }
        } else if (this.f44513a == null) {
            if (f44512h) {
                Log.i("PreloadMasterManager", "mMasterManager not create yet, can not prefetch");
            }
        } else if (this.f44515c && !m()) {
            if (f44512h) {
                Log.i("PreloadMasterManager", "default blank master can not use to prefetch");
            }
        } else if (m() && !TextUtils.equals(str, this.f44517e)) {
            if (f44512h) {
                Log.e("PreloadMasterManager", "one master can only prefetch one appId");
            }
        } else if (k(str, cVar)) {
            if (f44512h) {
                Log.i("PreloadMasterManager", "intercept for current prefetch event - " + str);
            }
        } else {
            this.f44517e = str;
            f(new a(cVar));
            if (f44512h) {
                Log.i("PreloadMasterManager", "fire prefetch event - " + str);
            }
        }
    }

    public void q(String str) {
        this.f44517e = str;
    }
}
