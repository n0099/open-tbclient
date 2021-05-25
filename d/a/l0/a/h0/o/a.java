package d.a.l0.a.h0.o;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.k;
import d.a.l0.a.v1.c.f.c;
import d.a.l0.a.v1.c.f.e;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42421a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static f f42422b = new f(null);

    /* renamed from: c  reason: collision with root package name */
    public static g f42423c = new g(null);

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f42424d = d.a.l0.a.h0.o.e.a.m();

    /* renamed from: d.a.l0.a.h0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0686a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f42425a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f42426b;

        public C0686a(e eVar, PrefetchEvent prefetchEvent) {
            this.f42425a = eVar;
            this.f42426b = prefetchEvent;
        }

        @Override // d.a.l0.a.h0.o.a.d
        public void a(d.a.l0.a.v1.c.f.c cVar) {
            if (cVar == null) {
                return;
            }
            if (a.f42424d || !cVar.C()) {
                a.this.f(cVar, this.f42426b, this.f42425a);
            } else {
                this.f42425a.a(cVar, null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42428a;

        public b(a aVar, d dVar) {
            this.f42428a = dVar;
        }

        @Override // d.a.l0.a.v1.c.f.c.b
        public void a(d.a.l0.a.v1.c.f.c cVar) {
            this.f42428a.a(cVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.l0.a.h0.c.a.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v1.c.f.c f42429b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f42430c;

        public c(a aVar, d.a.l0.a.v1.c.f.c cVar, e eVar) {
            this.f42429b = cVar;
            this.f42430c = eVar;
        }

        @Override // d.a.l0.a.h0.c.a.a, d.a.l0.a.h0.c.a.b.InterfaceC0644b
        public void a() {
            super.a();
            boolean z = a.f42424d && this.f42429b.C();
            if (this.f42429b.G() || z) {
                this.f42430c.a(this.f42429b, null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(d.a.l0.a.v1.c.f.c cVar);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(@NonNull d.a.l0.a.v1.c.f.c cVar, @Nullable PMSAppInfo pMSAppInfo);
    }

    /* loaded from: classes2.dex */
    public static class f implements e.c<String> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, d.a.l0.a.v1.c.f.c cVar) {
            PrefetchEvent prefetchEvent = cVar.j;
            if (prefetchEvent == null) {
                return false;
            }
            return TextUtils.equals(str, prefetchEvent.appId);
        }

        public /* synthetic */ f(C0686a c0686a) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class g implements e.c<String> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, d.a.l0.a.v1.c.f.c cVar) {
            return cVar.C() && TextUtils.equals(str, cVar.f45332g);
        }

        public /* synthetic */ g(C0686a c0686a) {
            this();
        }
    }

    public static d.a.l0.a.v1.c.f.c c(@NonNull PrefetchEvent prefetchEvent) {
        return d.a.l0.a.v1.c.f.e.k().p(prefetchEvent.appId, f42422b);
    }

    public static d.a.l0.a.v1.c.f.c d(@NonNull PrefetchEvent prefetchEvent) {
        return d.a.l0.a.v1.c.f.e.k().p(prefetchEvent.appId, f42423c);
    }

    public final void e(@NonNull d.a.l0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        d.a.l0.a.h0.c.a.b.g(prefetchEvent.appId, "swan", prefetchEvent.scene, false, prefetchEvent.schema, new c(this, cVar, eVar));
    }

    public final void f(@NonNull d.a.l0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        e(cVar, prefetchEvent, eVar);
    }

    public void g(@NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        h(prefetchEvent, new C0686a(eVar, prefetchEvent));
    }

    @Nullable
    public final void h(@NonNull PrefetchEvent prefetchEvent, @NonNull d dVar) {
        d.a.l0.a.v1.c.f.c d2 = d(prefetchEvent);
        if (d2 != null) {
            dVar.a(d2);
            return;
        }
        d.a.l0.a.v1.c.f.c c2 = c(prefetchEvent);
        if (c2 != null && c2.G()) {
            dVar.a(c2);
            return;
        }
        d.a.l0.a.v1.c.f.c e2 = d.a.l0.a.v1.c.f.e.k().e();
        if (e2.C()) {
            if (f42421a) {
                Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
            }
            dVar.a(null);
        } else if (e2.G()) {
            if (f42421a) {
                Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
            }
            dVar.a(e2);
        } else {
            e2.Y(new b(this, dVar));
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "8");
            d.a.l0.a.v1.c.f.b.m(d.a.l0.a.c1.a.b(), e2, bundle);
        }
    }
}
