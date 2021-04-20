package d.b.g0.a.e0.q;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.a.e0.h.a.a;
import d.b.g0.a.k;
import d.b.g0.a.n1.c.f.c;
import d.b.g0.a.n1.c.f.e;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44629a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static f f44630b = new f(null);

    /* renamed from: c  reason: collision with root package name */
    public static g f44631c = new g(null);

    /* renamed from: d.b.g0.a.e0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0690a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f44632a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f44633b;

        public C0690a(e eVar, PrefetchEvent prefetchEvent) {
            this.f44632a = eVar;
            this.f44633b = prefetchEvent;
        }

        @Override // d.b.g0.a.e0.q.a.d
        public void a(d.b.g0.a.n1.c.f.c cVar) {
            if (cVar == null) {
                return;
            }
            if (!cVar.x()) {
                a.this.h(cVar, this.f44633b, this.f44632a);
            } else {
                this.f44632a.a(cVar, null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f44635a;

        public b(a aVar, d dVar) {
            this.f44635a = dVar;
        }

        @Override // d.b.g0.a.n1.c.f.c.b
        public void a(d.b.g0.a.n1.c.f.c cVar) {
            this.f44635a.a(cVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.n1.c.f.c f44636a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f44637b;

        public c(a aVar, d.b.g0.a.n1.c.f.c cVar, e eVar) {
            this.f44636a = cVar;
            this.f44637b = eVar;
        }

        @Override // d.b.g0.a.e0.h.a.a.c
        public void a(int i) {
            if (a.f44629a) {
                Log.d("PrefetchEnv", "prepareBundle failed: " + i);
            }
        }

        @Override // d.b.g0.a.e0.h.a.a.c
        public void b() {
            if (a.f44629a) {
                Log.d("PrefetchEnv", "prepareBundle success isPreloaded: " + this.f44636a.C());
            }
            if (this.f44636a.C()) {
                this.f44637b.a(this.f44636a, null);
            }
        }

        @Override // d.b.g0.a.e0.h.a.a.c
        public void c() {
            if (a.f44629a) {
                Log.d("PrefetchEnv", "prepareBundle swanAppIdInvalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(d.b.g0.a.n1.c.f.c cVar);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(@NonNull d.b.g0.a.n1.c.f.c cVar, @Nullable PMSAppInfo pMSAppInfo);
    }

    /* loaded from: classes2.dex */
    public static class f implements e.c<String> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.n1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, d.b.g0.a.n1.c.f.c cVar) {
            PrefetchEvent prefetchEvent = cVar.j;
            if (prefetchEvent == null) {
                return false;
            }
            return TextUtils.equals(str, prefetchEvent.appId);
        }

        public /* synthetic */ f(C0690a c0690a) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class g implements e.c<String> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.n1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, d.b.g0.a.n1.c.f.c cVar) {
            return cVar.x() && TextUtils.equals(str, cVar.f45784g);
        }

        public /* synthetic */ g(C0690a c0690a) {
            this();
        }
    }

    public static d.b.g0.a.n1.c.f.c c(@NonNull PrefetchEvent prefetchEvent) {
        d.b.g0.a.n1.c.f.c e2 = e(prefetchEvent);
        if (e2 != null) {
            return e2;
        }
        d.b.g0.a.n1.c.f.c d2 = d(prefetchEvent);
        return (d2 == null || !d2.C()) ? d.b.g0.a.n1.c.f.e.j().d() : d2;
    }

    public static d.b.g0.a.n1.c.f.c d(@NonNull PrefetchEvent prefetchEvent) {
        return d.b.g0.a.n1.c.f.e.j().o(prefetchEvent.appId, f44630b);
    }

    public static d.b.g0.a.n1.c.f.c e(@NonNull PrefetchEvent prefetchEvent) {
        return d.b.g0.a.n1.c.f.e.j().o(prefetchEvent.appId, f44631c);
    }

    public final boolean f(PMSAppInfo pMSAppInfo) {
        return pMSAppInfo != null && d.b.g0.a.y0.h.a.e(pMSAppInfo);
    }

    public final void g(boolean z, @NonNull d.b.g0.a.n1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        d.b.g0.a.e0.h.a.a.d(z, prefetchEvent.appId, 200, new c(this, cVar, eVar), prefetchEvent.scene, "swan");
    }

    public final void h(@NonNull d.b.g0.a.n1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        PMSAppInfo r = d.b.g0.l.i.a.h().r(prefetchEvent.appId);
        boolean f2 = f(r);
        if (f2 && !r.l()) {
            eVar.a(cVar, r);
        } else {
            g(f2, cVar, prefetchEvent, eVar);
        }
    }

    public void i(@NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        j(prefetchEvent, new C0690a(eVar, prefetchEvent));
    }

    @Nullable
    public final void j(@NonNull PrefetchEvent prefetchEvent, @NonNull d dVar) {
        d.b.g0.a.n1.c.f.c e2 = e(prefetchEvent);
        if (e2 != null) {
            dVar.a(e2);
            return;
        }
        d.b.g0.a.n1.c.f.c d2 = d(prefetchEvent);
        if (d2 != null && d2.C()) {
            dVar.a(d2);
            return;
        }
        d.b.g0.a.n1.c.f.c d3 = d.b.g0.a.n1.c.f.e.j().d();
        if (d3.x()) {
            if (f44629a) {
                Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
            }
            dVar.a(null);
        } else if (d3.C()) {
            if (f44629a) {
                Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
            }
            dVar.a(d3);
        } else {
            d3.T(new b(this, dVar));
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "8");
            d.b.g0.a.n1.c.f.b.k(d.b.g0.a.w0.a.c(), d3, bundle);
        }
    }
}
