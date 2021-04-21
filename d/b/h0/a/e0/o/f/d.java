package d.b.h0.a.e0.o.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.b.h0.a.e0.g;
import d.b.h0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f44841h = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.a.e0.o.a f44842a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c> f44843b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final boolean f44844c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f44845d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f44846e;

    /* renamed from: f  reason: collision with root package name */
    public long f44847f;

    /* renamed from: g  reason: collision with root package name */
    public long f44848g;

    /* loaded from: classes2.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent.c f44849a;

        public a(PrefetchEvent.c cVar) {
            this.f44849a = cVar;
        }

        @Override // d.b.h0.a.e0.o.f.c
        public void onReady() {
            if (d.this.f44842a == null || d.this.f44842a.g() == null || d.this.f44842a.g().isDestroyed()) {
                return;
            }
            d.b.h0.a.k0.a.b(d.this.f44842a.g(), this.f44849a);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends g {
        public b() {
        }

        @Override // d.b.h0.a.e0.g
        public void a(String str) {
            super.a(str);
            if (d.f44841h) {
                Log.d("PreloadMasterManager", "prepareMaster finish. url: " + str);
            }
            d.this.f44845d = true;
            d.this.f44848g = System.currentTimeMillis();
            d.this.o();
            if (d.f44841h) {
                Log.d("PreloadMasterManager", "createBlankOne cost - " + d.this.h() + "ms");
            }
        }
    }

    public d(boolean z, boolean z2) {
        this.f44844c = z;
    }

    public static d g(boolean z, boolean z2) {
        if (f44841h) {
            Log.d("PreloadMasterManager", "start create a blank preload master manager, is default - " + z + ",is v8 - " + z2);
        }
        d dVar = new d(z, z2);
        dVar.f44847f = System.currentTimeMillis();
        long currentTimeMillis = f44841h ? System.currentTimeMillis() : 0L;
        dVar.f44842a = d.b.h0.a.e0.w.d.L().m0(z2, new b());
        if (f44841h) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("PreloadMasterManager", "create a new master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return dVar;
    }

    public synchronized void f(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f44845d) {
            if (f44841h) {
                Log.d("PreloadMasterManager", "is Ready , call back immediately");
            }
            cVar.onReady();
            return;
        }
        if (!this.f44843b.contains(cVar)) {
            this.f44843b.add(cVar);
        }
    }

    public long h() {
        return this.f44848g - this.f44847f;
    }

    public String i() {
        return this.f44846e;
    }

    public d.b.h0.a.e0.o.a j() {
        return this.f44842a;
    }

    public final boolean k(String str, PrefetchEvent.c cVar) {
        return false;
    }

    public boolean l() {
        return this.f44844c;
    }

    public boolean m() {
        return !TextUtils.isEmpty(this.f44846e);
    }

    public boolean n() {
        return this.f44845d;
    }

    public final synchronized void o() {
        if (f44841h) {
            Log.d("PreloadMasterManager", "notifyAllReady, callback size " + this.f44843b.size());
        }
        for (c cVar : this.f44843b) {
            if (cVar != null) {
                cVar.onReady();
            }
        }
        this.f44843b.clear();
    }

    public void p(String str, PrefetchEvent.c cVar) {
        if (cVar == null) {
            if (f44841h) {
                Log.e("PreloadMasterManager", "prefetch event is null");
            }
        } else if (TextUtils.isEmpty(str)) {
            if (f44841h) {
                Log.e("PreloadMasterManager", "prefetch appId is empty");
            }
        } else if (this.f44842a == null) {
            if (f44841h) {
                Log.i("PreloadMasterManager", "mMasterManager not create yet, can not prefetch");
            }
        } else if (this.f44844c && !m()) {
            if (f44841h) {
                Log.i("PreloadMasterManager", "default blank master can not use to prefetch");
            }
        } else if (m() && !TextUtils.equals(str, this.f44846e)) {
            if (f44841h) {
                Log.e("PreloadMasterManager", "one master can only prefetch one appId");
            }
        } else if (k(str, cVar)) {
            if (f44841h) {
                Log.i("PreloadMasterManager", "intercept for current prefetch event - " + str);
            }
        } else {
            this.f44846e = str;
            f(new a(cVar));
            if (f44841h) {
                Log.i("PreloadMasterManager", "fire prefetch event - " + str);
            }
        }
    }

    public void q(String str) {
        this.f44846e = str;
    }
}
