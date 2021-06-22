package d.a.m0.a.h0.o;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.a.k;
import d.a.m0.a.v1.c.f.c;
import d.a.m0.a.v1.c.f.e;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46205a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static f f46206b = new f(null);

    /* renamed from: c  reason: collision with root package name */
    public static g f46207c = new g(null);

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f46208d = d.a.m0.a.h0.o.e.a.m();

    /* renamed from: d.a.m0.a.h0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0745a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f46209a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f46210b;

        public C0745a(e eVar, PrefetchEvent prefetchEvent) {
            this.f46209a = eVar;
            this.f46210b = prefetchEvent;
        }

        @Override // d.a.m0.a.h0.o.a.d
        public void a(d.a.m0.a.v1.c.f.c cVar) {
            if (cVar == null) {
                return;
            }
            if (a.f46208d || !cVar.C()) {
                a.this.f(cVar, this.f46210b, this.f46209a);
            } else {
                this.f46209a.a(cVar, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f46212a;

        public b(a aVar, d dVar) {
            this.f46212a = dVar;
        }

        @Override // d.a.m0.a.v1.c.f.c.b
        public void a(d.a.m0.a.v1.c.f.c cVar) {
            this.f46212a.a(cVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.m0.a.h0.c.a.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v1.c.f.c f46213b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f46214c;

        public c(a aVar, d.a.m0.a.v1.c.f.c cVar, e eVar) {
            this.f46213b = cVar;
            this.f46214c = eVar;
        }

        @Override // d.a.m0.a.h0.c.a.a, d.a.m0.a.h0.c.a.b.InterfaceC0703b
        public void a() {
            super.a();
            boolean z = a.f46208d && this.f46213b.C();
            if (this.f46213b.G() || z) {
                this.f46214c.a(this.f46213b, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(d.a.m0.a.v1.c.f.c cVar);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(@NonNull d.a.m0.a.v1.c.f.c cVar, @Nullable PMSAppInfo pMSAppInfo);
    }

    /* loaded from: classes3.dex */
    public static class f implements e.c<String> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, d.a.m0.a.v1.c.f.c cVar) {
            PrefetchEvent prefetchEvent = cVar.j;
            if (prefetchEvent == null) {
                return false;
            }
            return TextUtils.equals(str, prefetchEvent.appId);
        }

        public /* synthetic */ f(C0745a c0745a) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements e.c<String> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v1.c.f.e.c
        /* renamed from: b */
        public boolean a(String str, d.a.m0.a.v1.c.f.c cVar) {
            return cVar.C() && TextUtils.equals(str, cVar.f49114g);
        }

        public /* synthetic */ g(C0745a c0745a) {
            this();
        }
    }

    public static d.a.m0.a.v1.c.f.c c(@NonNull PrefetchEvent prefetchEvent) {
        return d.a.m0.a.v1.c.f.e.k().p(prefetchEvent.appId, f46206b);
    }

    public static d.a.m0.a.v1.c.f.c d(@NonNull PrefetchEvent prefetchEvent) {
        return d.a.m0.a.v1.c.f.e.k().p(prefetchEvent.appId, f46207c);
    }

    public final void e(@NonNull d.a.m0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        d.a.m0.a.h0.c.a.b.g(prefetchEvent.appId, "swan", prefetchEvent.scene, false, prefetchEvent.schema, new c(this, cVar, eVar));
    }

    public final void f(@NonNull d.a.m0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        e(cVar, prefetchEvent, eVar);
    }

    public void g(@NonNull PrefetchEvent prefetchEvent, @NonNull e eVar) {
        h(prefetchEvent, new C0745a(eVar, prefetchEvent));
    }

    @Nullable
    public final void h(@NonNull PrefetchEvent prefetchEvent, @NonNull d dVar) {
        d.a.m0.a.v1.c.f.c d2 = d(prefetchEvent);
        if (d2 != null) {
            dVar.a(d2);
            return;
        }
        d.a.m0.a.v1.c.f.c c2 = c(prefetchEvent);
        if (c2 != null && c2.G()) {
            dVar.a(c2);
            return;
        }
        d.a.m0.a.v1.c.f.c e2 = d.a.m0.a.v1.c.f.e.k().e();
        if (e2.C()) {
            if (f46205a) {
                Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
            }
            dVar.a(null);
        } else if (e2.G()) {
            if (f46205a) {
                Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
            }
            dVar.a(e2);
        } else {
            e2.Y(new b(this, dVar));
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "8");
            d.a.m0.a.v1.c.f.b.m(d.a.m0.a.c1.a.b(), e2, bundle);
        }
    }
}
