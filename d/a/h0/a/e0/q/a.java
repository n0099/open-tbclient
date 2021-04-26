package d.a.h0.a.e0.q;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.h0.a.e0.h.a.a;
import d.a.h0.a.k;
import d.a.h0.a.n1.c.f.c;
import d.a.h0.a.n1.c.f.e;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42263a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static f f42264b = new f(null);

    /* renamed from: c  reason: collision with root package name */
    public static g f42265c = new g(null);

    /* renamed from: d.a.h0.a.e0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0649a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f42266a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f42267b;

        public C0649a(e eVar, PrefetchEvent prefetchEvent) {
            this.f42266a = eVar;
            this.f42267b = prefetchEvent;
        }

        @Override // d.a.h0.a.e0.q.a.d
        public void a(d.a.h0.a.n1.c.f.c cVar) {
            if (cVar == null) {
                return;
            }
            if (!cVar.z()) {
                a.this.h(cVar, this.f42267b, this.f42266a);
            } else {
                this.f42266a.a(cVar, null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42269a;

        public b(a aVar, d dVar) {
            this.f42269a = dVar;
        }

        @Override // d.a.h0.a.n1.c.f.c.b
        public void a(d.a.h0.a.n1.c.f.c cVar) {
            this.f42269a.a(cVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.n1.c.f.c f42270a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f42271b;

        public c(a aVar, d.a.h0.a.n1.c.f.c cVar, e eVar) {
            this.f42270a = cVar;
            this.f42271b = eVar;
        }

        @Override // d.a.h0.a.e0.h.a.a.c
        public void a() {
            if (a.f42263a) {
                Log.d("PrefetchEnv", "prepareBundle success isPreloaded: " + this.f42270a.C());
            }
            if (this.f42270a.C()) {
                this.f42271b.a(this.f42270a, null);
            }
        }

        @Override // d.a.h0.a.e0.h.a.a.c
        public void b(int i2) {
            if (a.f42263a) {
                Log.d("PrefetchEnv", "prepareBundle failed: " + i2);
            }
        }

        @Override // d.a.h0.a.e0.h.a.a.c
        public void c() {
            if (a.f42263a) {
                Log.d("PrefetchEnv", "prepareBundle swanAppIdInvalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(d.a.h0.a.n1.c.f.c cVar);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(@NonNull d.a.h0.a.n1.c.f.c cVar, @Nullable PMSAppInfo pMSAppInfo);
    }

    /* loaded from: classes2.dex */
    public static class f implements e.c<String> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.n1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, d.a.h0.a.n1.c.f.c cVar) {
            PrefetchEvent prefetchEvent = cVar.j;
            if (prefetchEvent == null) {
                return false;
            }
            return TextUtils.equals(str, prefetchEvent.appId);
        }

        public /* synthetic */ f(C0649a c0649a) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class g implements e.c<String> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.n1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, d.a.h0.a.n1.c.f.c cVar) {
            return cVar.z() && TextUtils.equals(str, cVar.f43458g);
        }

        public /* synthetic */ g(C0649a c0649a) {
            this();
        }
    }

    public static d.a.h0.a.n1.c.f.c c(@NonNull PrefetchEvent prefetchEvent) {
        d.a.h0.a.n1.c.f.c e2 = e(prefetchEvent);
        if (e2 != null) {
            return e2;
        }
        d.a.h0.a.n1.c.f.c d2 = d(prefetchEvent);
        return (d2 == null || !d2.C()) ? d.a.h0.a.n1.c.f.e.j().d() : d2;
    }

    public static d.a.h0.a.n1.c.f.c d(@NonNull PrefetchEvent prefetchEvent) {
        return d.a.h0.a.n1.c.f.e.j().o(prefetchEvent.appId, f42264b);
    }

    public static d.a.h0.a.n1.c.f.c e(@NonNull PrefetchEvent prefetchEvent) {
        return d.a.h0.a.n1.c.f.e.j().o(prefetchEvent.appId, f42265c);
    }

    public final boolean f(PMSAppInfo pMSAppInfo) {
        return pMSAppInfo != null && d.a.h0.a.y0.h.a.e(pMSAppInfo);
    }

    public final void g(boolean z, @NonNull d.a.h0.a.n1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        d.a.h0.a.e0.h.a.a.d(z, prefetchEvent.appId, 200, new c(this, cVar, eVar), prefetchEvent.scene, "swan");
    }

    public final void h(@NonNull d.a.h0.a.n1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        PMSAppInfo r = d.a.h0.l.i.a.h().r(prefetchEvent.appId);
        boolean f2 = f(r);
        if (f2 && !r.l()) {
            eVar.a(cVar, r);
        } else {
            g(f2, cVar, prefetchEvent, eVar);
        }
    }

    public void i(@NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        j(prefetchEvent, new C0649a(eVar, prefetchEvent));
    }

    @Nullable
    public final void j(@NonNull PrefetchEvent prefetchEvent, @NonNull d dVar) {
        d.a.h0.a.n1.c.f.c e2 = e(prefetchEvent);
        if (e2 != null) {
            dVar.a(e2);
            return;
        }
        d.a.h0.a.n1.c.f.c d2 = d(prefetchEvent);
        if (d2 != null && d2.C()) {
            dVar.a(d2);
            return;
        }
        d.a.h0.a.n1.c.f.c d3 = d.a.h0.a.n1.c.f.e.j().d();
        if (d3.z()) {
            if (f42263a) {
                Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
            }
            dVar.a(null);
        } else if (d3.C()) {
            if (f42263a) {
                Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
            }
            dVar.a(d3);
        } else {
            d3.T(new b(this, dVar));
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "8");
            d.a.h0.a.n1.c.f.b.k(d.a.h0.a.w0.a.c(), d3, bundle);
        }
    }
}
