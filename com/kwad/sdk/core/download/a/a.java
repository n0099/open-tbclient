package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy;
import com.kwad.sdk.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.kwad.sdk.core.download.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2083a {
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f57932b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f57933c;

        /* renamed from: d  reason: collision with root package name */
        public AdTemplate f57934d;

        /* renamed from: e  reason: collision with root package name */
        public b f57935e;

        /* renamed from: f  reason: collision with root package name */
        public com.kwad.sdk.core.download.a.b f57936f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f57937g;

        /* renamed from: h  reason: collision with root package name */
        public int f57938h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f57939i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f57940j;

        /* renamed from: k  reason: collision with root package name */
        public p.a f57941k;
        public JSONObject l;
        public boolean m = false;

        public C2083a(Context context) {
            this.a = context;
        }

        public Context a() {
            return this.a;
        }

        public C2083a a(int i2) {
            this.f57938h = i2;
            return this;
        }

        public C2083a a(b bVar) {
            this.f57935e = bVar;
            return this;
        }

        public C2083a a(com.kwad.sdk.core.download.a.b bVar) {
            this.f57936f = bVar;
            return this;
        }

        public C2083a a(p.a aVar) {
            this.f57941k = aVar;
            return this;
        }

        public C2083a a(AdTemplate adTemplate) {
            this.f57934d = adTemplate;
            return this;
        }

        public C2083a a(JSONObject jSONObject) {
            this.l = jSONObject;
            return this;
        }

        public C2083a a(boolean z) {
            this.f57937g = z;
            return this;
        }

        public C2083a b(boolean z) {
            this.f57939i = z;
            return this;
        }

        public AdTemplate b() {
            return this.f57934d;
        }

        public C2083a c(boolean z) {
            this.f57940j = z;
            return this;
        }

        public b c() {
            return this.f57935e;
        }

        public C2083a d(boolean z) {
            this.m = z;
            return this;
        }

        public com.kwad.sdk.core.download.a.b d() {
            return this.f57936f;
        }

        public C2083a e(boolean z) {
            this.f57933c = z;
            return this;
        }

        public boolean e() {
            return this.f57937g;
        }

        public C2083a f(boolean z) {
            this.f57932b = z;
            return this;
        }

        public boolean f() {
            return this.f57939i;
        }

        public int g() {
            return this.f57938h;
        }

        public boolean h() {
            return this.f57940j;
        }

        public boolean i() {
            return this.m;
        }

        public JSONObject j() {
            return this.l;
        }

        public boolean k() {
            return this.f57933c;
        }

        public boolean l() {
            return this.f57932b;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable com.kwad.sdk.core.download.a.b bVar2, boolean z) {
        return a(new C2083a(context).a(adTemplate).a(bVar).a(bVar2).a(z).b(false));
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable com.kwad.sdk.core.download.a.b bVar2, boolean z, boolean z2) {
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        com.kwad.sdk.home.download.a.a().a(true);
        if (d.a(context, adTemplate, 1) == 1) {
            bVar.a();
            return 0;
        } else if (!com.kwad.sdk.core.response.a.a.B(j2)) {
            bVar.a();
            if (com.kwad.sdk.utils.f.a(context, com.kwad.sdk.core.response.a.a.aL(j2), com.kwad.sdk.core.response.a.a.v(j2))) {
                com.kwad.sdk.core.report.a.k(adTemplate);
            } else {
                AdWebViewActivityProxy.launch(context, adTemplate);
            }
            return 0;
        } else if (bVar2 != null) {
            int a = bVar2.a(new C2083a(context).a(z).a(adTemplate).b(z2).d(false));
            int i2 = j2.status;
            if (i2 != 2 && i2 != 3) {
                bVar.a();
            }
            return a;
        } else {
            return 0;
        }
    }

    public static int a(C2083a c2083a) {
        if (c2083a.l()) {
            a(c2083a.a(), c2083a.b(), c2083a.c(), c2083a.d(), c2083a.f57937g, c2083a.f());
            return 0;
        } else if (com.kwad.sdk.core.download.a.b.c(c2083a) == 3) {
            return 0;
        } else {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(c2083a.b());
            com.kwad.sdk.home.download.a.a().a(true);
            if (d.a(c2083a.a(), c2083a.b(), 1) == 1) {
                c(c2083a);
                return 0;
            } else if (c2083a.k() && (!com.kwad.sdk.core.response.a.a.B(j2) || g(c2083a))) {
                c(c2083a);
                f(c2083a);
                return 0;
            } else if (!com.kwad.sdk.core.response.a.a.B(j2)) {
                if (c2083a.b().isWebViewDownload) {
                    return e(c2083a);
                }
                boolean a = com.kwad.sdk.utils.f.a(c2083a.a(), com.kwad.sdk.core.response.a.a.aL(j2), com.kwad.sdk.core.response.a.a.v(j2));
                c(c2083a);
                if (a) {
                    com.kwad.sdk.core.report.a.k(c2083a.b());
                    return 0;
                }
                AdWebViewActivityProxy.launch(c2083a.a(), c2083a.b());
                return 0;
            } else {
                if (com.kwad.sdk.core.response.a.a.B(j2)) {
                    if (AdWebViewLandPageActivityProxy.showingAdWebViewLandPage || com.kwad.sdk.core.download.kwai.b.a()) {
                        c2083a.d(false);
                        c(c2083a);
                    } else {
                        c(c2083a);
                        if (!b(c2083a)) {
                            c2083a.d(true);
                        }
                    }
                    return e(c2083a);
                }
                return 0;
            }
        }
    }

    public static boolean b(C2083a c2083a) {
        AdTemplate b2 = c2083a.b();
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(b2);
        if (!c2083a.k() || !com.kwad.sdk.core.response.a.a.V(j2) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.G(j2)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c2083a.d().d()) {
            return false;
        }
        AdWebViewVideoActivityProxy.launch(c2083a.a(), b2);
        return true;
    }

    public static void c(C2083a c2083a) {
        d(c2083a);
        if (c2083a.c() != null) {
            c2083a.c().a();
        }
    }

    public static void d(C2083a c2083a) {
        if (c2083a.h()) {
            com.kwad.sdk.core.report.a.a(c2083a.f57934d, c2083a.f57941k, c2083a.j());
        }
    }

    public static int e(C2083a c2083a) {
        com.kwad.sdk.core.download.a.b d2 = c2083a.d();
        if (d2 == null) {
            d2 = new com.kwad.sdk.core.download.a.b(c2083a.f57934d);
            c2083a.a(d2);
        }
        return d2.a(c2083a);
    }

    public static void f(C2083a c2083a) {
        int i2;
        AdTemplate b2 = c2083a.b();
        Context a = c2083a.a();
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(b2);
        if (com.kwad.sdk.utils.f.a(a, com.kwad.sdk.core.response.a.a.aL(j2), com.kwad.sdk.core.response.a.a.v(j2))) {
            com.kwad.sdk.core.report.a.k(b2);
            return;
        }
        if (g(c2083a)) {
            i2 = 4;
        } else if (com.kwad.sdk.core.response.a.a.V(j2) && !b2.mAdWebVideoPageShowing) {
            AdWebViewVideoActivityProxy.launch(a, b2);
            return;
        } else {
            i2 = 0;
        }
        AdWebViewActivityProxy.launch(a, b2, i2);
    }

    public static boolean g(C2083a c2083a) {
        AdTemplate b2 = c2083a.b();
        return com.kwad.sdk.core.response.a.b.j(b2) && !b2.interactLandingPageShowing;
    }
}
