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
/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.kwad.sdk.core.download.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1956a {
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f39432b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f39433c;

        /* renamed from: d  reason: collision with root package name */
        public AdTemplate f39434d;

        /* renamed from: e  reason: collision with root package name */
        public b f39435e;

        /* renamed from: f  reason: collision with root package name */
        public com.kwad.sdk.core.download.a.b f39436f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f39437g;

        /* renamed from: h  reason: collision with root package name */
        public int f39438h;
        public boolean i;
        public boolean j;
        public p.a k;
        public JSONObject l;
        public boolean m = false;

        public C1956a(Context context) {
            this.a = context;
        }

        public Context a() {
            return this.a;
        }

        public C1956a a(int i) {
            this.f39438h = i;
            return this;
        }

        public C1956a a(b bVar) {
            this.f39435e = bVar;
            return this;
        }

        public C1956a a(com.kwad.sdk.core.download.a.b bVar) {
            this.f39436f = bVar;
            return this;
        }

        public C1956a a(p.a aVar) {
            this.k = aVar;
            return this;
        }

        public C1956a a(AdTemplate adTemplate) {
            this.f39434d = adTemplate;
            return this;
        }

        public C1956a a(JSONObject jSONObject) {
            this.l = jSONObject;
            return this;
        }

        public C1956a a(boolean z) {
            this.f39437g = z;
            return this;
        }

        public C1956a b(boolean z) {
            this.i = z;
            return this;
        }

        public AdTemplate b() {
            return this.f39434d;
        }

        public C1956a c(boolean z) {
            this.j = z;
            return this;
        }

        public b c() {
            return this.f39435e;
        }

        public C1956a d(boolean z) {
            this.m = z;
            return this;
        }

        public com.kwad.sdk.core.download.a.b d() {
            return this.f39436f;
        }

        public C1956a e(boolean z) {
            this.f39433c = z;
            return this;
        }

        public boolean e() {
            return this.f39437g;
        }

        public C1956a f(boolean z) {
            this.f39432b = z;
            return this;
        }

        public boolean f() {
            return this.i;
        }

        public int g() {
            return this.f39438h;
        }

        public boolean h() {
            return this.j;
        }

        public boolean i() {
            return this.m;
        }

        public JSONObject j() {
            return this.l;
        }

        public boolean k() {
            return this.f39433c;
        }

        public boolean l() {
            return this.f39432b;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable com.kwad.sdk.core.download.a.b bVar2, boolean z) {
        return a(new C1956a(context).a(adTemplate).a(bVar).a(bVar2).a(z).b(false));
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable com.kwad.sdk.core.download.a.b bVar2, boolean z, boolean z2) {
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        com.kwad.sdk.home.download.a.a().a(true);
        if (d.a(context, adTemplate, 1) == 1) {
            bVar.a();
            return 0;
        } else if (!com.kwad.sdk.core.response.a.a.B(j)) {
            bVar.a();
            if (com.kwad.sdk.utils.f.a(context, com.kwad.sdk.core.response.a.a.aL(j), com.kwad.sdk.core.response.a.a.v(j))) {
                com.kwad.sdk.core.report.a.k(adTemplate);
            } else {
                AdWebViewActivityProxy.launch(context, adTemplate);
            }
            return 0;
        } else if (bVar2 != null) {
            int a = bVar2.a(new C1956a(context).a(z).a(adTemplate).b(z2).d(false));
            int i = j.status;
            if (i != 2 && i != 3) {
                bVar.a();
            }
            return a;
        } else {
            return 0;
        }
    }

    public static int a(C1956a c1956a) {
        if (c1956a.l()) {
            a(c1956a.a(), c1956a.b(), c1956a.c(), c1956a.d(), c1956a.f39437g, c1956a.f());
            return 0;
        } else if (com.kwad.sdk.core.download.a.b.c(c1956a) == 3) {
            return 0;
        } else {
            AdInfo j = com.kwad.sdk.core.response.a.d.j(c1956a.b());
            com.kwad.sdk.home.download.a.a().a(true);
            if (d.a(c1956a.a(), c1956a.b(), 1) == 1) {
                c(c1956a);
                return 0;
            } else if (c1956a.k() && (!com.kwad.sdk.core.response.a.a.B(j) || g(c1956a))) {
                c(c1956a);
                f(c1956a);
                return 0;
            } else if (!com.kwad.sdk.core.response.a.a.B(j)) {
                if (c1956a.b().isWebViewDownload) {
                    return e(c1956a);
                }
                boolean a = com.kwad.sdk.utils.f.a(c1956a.a(), com.kwad.sdk.core.response.a.a.aL(j), com.kwad.sdk.core.response.a.a.v(j));
                c(c1956a);
                if (a) {
                    com.kwad.sdk.core.report.a.k(c1956a.b());
                    return 0;
                }
                AdWebViewActivityProxy.launch(c1956a.a(), c1956a.b());
                return 0;
            } else {
                if (com.kwad.sdk.core.response.a.a.B(j)) {
                    if (AdWebViewLandPageActivityProxy.showingAdWebViewLandPage || com.kwad.sdk.core.download.kwai.b.a()) {
                        c1956a.d(false);
                        c(c1956a);
                    } else {
                        c(c1956a);
                        if (!b(c1956a)) {
                            c1956a.d(true);
                        }
                    }
                    return e(c1956a);
                }
                return 0;
            }
        }
    }

    public static boolean b(C1956a c1956a) {
        AdTemplate b2 = c1956a.b();
        AdInfo j = com.kwad.sdk.core.response.a.d.j(b2);
        if (!c1956a.k() || !com.kwad.sdk.core.response.a.a.V(j) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.G(j)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c1956a.d().d()) {
            return false;
        }
        AdWebViewVideoActivityProxy.launch(c1956a.a(), b2);
        return true;
    }

    public static void c(C1956a c1956a) {
        d(c1956a);
        if (c1956a.c() != null) {
            c1956a.c().a();
        }
    }

    public static void d(C1956a c1956a) {
        if (c1956a.h()) {
            com.kwad.sdk.core.report.a.a(c1956a.f39434d, c1956a.k, c1956a.j());
        }
    }

    public static int e(C1956a c1956a) {
        com.kwad.sdk.core.download.a.b d2 = c1956a.d();
        if (d2 == null) {
            d2 = new com.kwad.sdk.core.download.a.b(c1956a.f39434d);
            c1956a.a(d2);
        }
        return d2.a(c1956a);
    }

    public static void f(C1956a c1956a) {
        int i;
        AdTemplate b2 = c1956a.b();
        Context a = c1956a.a();
        AdInfo j = com.kwad.sdk.core.response.a.d.j(b2);
        if (com.kwad.sdk.utils.f.a(a, com.kwad.sdk.core.response.a.a.aL(j), com.kwad.sdk.core.response.a.a.v(j))) {
            com.kwad.sdk.core.report.a.k(b2);
            return;
        }
        if (g(c1956a)) {
            i = 4;
        } else if (com.kwad.sdk.core.response.a.a.V(j) && !b2.mAdWebVideoPageShowing) {
            AdWebViewVideoActivityProxy.launch(a, b2);
            return;
        } else {
            i = 0;
        }
        AdWebViewActivityProxy.launch(a, b2, i);
    }

    public static boolean g(C1956a c1956a) {
        AdTemplate b2 = c1956a.b();
        return com.kwad.sdk.core.response.a.b.j(b2) && !b2.interactLandingPageShowing;
    }
}
