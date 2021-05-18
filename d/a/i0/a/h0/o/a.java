package d.a.i0.a.h0.o;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.i0.a.k;
import d.a.i0.a.v1.c.f.c;
import d.a.i0.a.v1.c.f.e;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42247a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static f f42248b = new f(null);

    /* renamed from: c  reason: collision with root package name */
    public static g f42249c = new g(null);

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f42250d = d.a.i0.a.h0.o.e.a.m();

    /* renamed from: d.a.i0.a.h0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0675a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f42251a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f42252b;

        public C0675a(e eVar, PrefetchEvent prefetchEvent) {
            this.f42251a = eVar;
            this.f42252b = prefetchEvent;
        }

        @Override // d.a.i0.a.h0.o.a.d
        public void a(d.a.i0.a.v1.c.f.c cVar) {
            if (cVar == null) {
                return;
            }
            if (a.f42250d || !cVar.C()) {
                a.this.f(cVar, this.f42252b, this.f42251a);
            } else {
                this.f42251a.a(cVar, null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42254a;

        public b(a aVar, d dVar) {
            this.f42254a = dVar;
        }

        @Override // d.a.i0.a.v1.c.f.c.b
        public void a(d.a.i0.a.v1.c.f.c cVar) {
            this.f42254a.a(cVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.i0.a.h0.c.a.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v1.c.f.c f42255b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f42256c;

        public c(a aVar, d.a.i0.a.v1.c.f.c cVar, e eVar) {
            this.f42255b = cVar;
            this.f42256c = eVar;
        }

        @Override // d.a.i0.a.h0.c.a.a, d.a.i0.a.h0.c.a.b.InterfaceC0633b
        public void a() {
            super.a();
            boolean z = a.f42250d && this.f42255b.C();
            if (this.f42255b.G() || z) {
                this.f42256c.a(this.f42255b, null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(d.a.i0.a.v1.c.f.c cVar);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(@NonNull d.a.i0.a.v1.c.f.c cVar, @Nullable PMSAppInfo pMSAppInfo);
    }

    /* loaded from: classes2.dex */
    public static class f implements e.c<String> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, d.a.i0.a.v1.c.f.c cVar) {
            PrefetchEvent prefetchEvent = cVar.j;
            if (prefetchEvent == null) {
                return false;
            }
            return TextUtils.equals(str, prefetchEvent.appId);
        }

        public /* synthetic */ f(C0675a c0675a) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class g implements e.c<String> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, d.a.i0.a.v1.c.f.c cVar) {
            return cVar.C() && TextUtils.equals(str, cVar.f45156g);
        }

        public /* synthetic */ g(C0675a c0675a) {
            this();
        }
    }

    public static d.a.i0.a.v1.c.f.c c(@NonNull PrefetchEvent prefetchEvent) {
        return d.a.i0.a.v1.c.f.e.k().p(prefetchEvent.appId, f42248b);
    }

    public static d.a.i0.a.v1.c.f.c d(@NonNull PrefetchEvent prefetchEvent) {
        return d.a.i0.a.v1.c.f.e.k().p(prefetchEvent.appId, f42249c);
    }

    public final void e(@NonNull d.a.i0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        d.a.i0.a.h0.c.a.b.g(prefetchEvent.appId, "swan", prefetchEvent.scene, false, prefetchEvent.schema, new c(this, cVar, eVar));
    }

    public final void f(@NonNull d.a.i0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        e(cVar, prefetchEvent, eVar);
    }

    public void g(@NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        h(prefetchEvent, new C0675a(eVar, prefetchEvent));
    }

    @Nullable
    public final void h(@NonNull PrefetchEvent prefetchEvent, @NonNull d dVar) {
        d.a.i0.a.v1.c.f.c d2 = d(prefetchEvent);
        if (d2 != null) {
            dVar.a(d2);
            return;
        }
        d.a.i0.a.v1.c.f.c c2 = c(prefetchEvent);
        if (c2 != null && c2.G()) {
            dVar.a(c2);
            return;
        }
        d.a.i0.a.v1.c.f.c e2 = d.a.i0.a.v1.c.f.e.k().e();
        if (e2.C()) {
            if (f42247a) {
                Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
            }
            dVar.a(null);
        } else if (e2.G()) {
            if (f42247a) {
                Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
            }
            dVar.a(e2);
        } else {
            e2.Y(new b(this, dVar));
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "8");
            d.a.i0.a.v1.c.f.b.m(d.a.i0.a.c1.a.b(), e2, bundle);
        }
    }
}
