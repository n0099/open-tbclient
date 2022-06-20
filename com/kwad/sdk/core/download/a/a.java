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
/* loaded from: classes5.dex */
public class a {

    /* renamed from: com.kwad.sdk.core.download.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0304a {
        public final Context a;
        public boolean b;
        public boolean c;
        public AdTemplate d;
        public b e;
        public com.kwad.sdk.core.download.a.b f;
        public boolean g;
        public int h;
        public boolean i;
        public boolean j;
        public p.a k;
        public JSONObject l;
        public boolean m = false;

        public C0304a(Context context) {
            this.a = context;
        }

        public Context a() {
            return this.a;
        }

        public C0304a a(int i) {
            this.h = i;
            return this;
        }

        public C0304a a(b bVar) {
            this.e = bVar;
            return this;
        }

        public C0304a a(com.kwad.sdk.core.download.a.b bVar) {
            this.f = bVar;
            return this;
        }

        public C0304a a(p.a aVar) {
            this.k = aVar;
            return this;
        }

        public C0304a a(AdTemplate adTemplate) {
            this.d = adTemplate;
            return this;
        }

        public C0304a a(JSONObject jSONObject) {
            this.l = jSONObject;
            return this;
        }

        public C0304a a(boolean z) {
            this.g = z;
            return this;
        }

        public C0304a b(boolean z) {
            this.i = z;
            return this;
        }

        public AdTemplate b() {
            return this.d;
        }

        public C0304a c(boolean z) {
            this.j = z;
            return this;
        }

        public b c() {
            return this.e;
        }

        public C0304a d(boolean z) {
            this.m = z;
            return this;
        }

        public com.kwad.sdk.core.download.a.b d() {
            return this.f;
        }

        public C0304a e(boolean z) {
            this.c = z;
            return this;
        }

        public boolean e() {
            return this.g;
        }

        public C0304a f(boolean z) {
            this.b = z;
            return this;
        }

        public boolean f() {
            return this.i;
        }

        public int g() {
            return this.h;
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
            return this.c;
        }

        public boolean l() {
            return this.b;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable com.kwad.sdk.core.download.a.b bVar2, boolean z) {
        return a(new C0304a(context).a(adTemplate).a(bVar).a(bVar2).a(z).b(false));
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
            int a = bVar2.a(new C0304a(context).a(z).a(adTemplate).b(z2).d(false));
            int i = j.status;
            if (i != 2 && i != 3) {
                bVar.a();
            }
            return a;
        } else {
            return 0;
        }
    }

    public static int a(C0304a c0304a) {
        if (c0304a.l()) {
            a(c0304a.a(), c0304a.b(), c0304a.c(), c0304a.d(), c0304a.g, c0304a.f());
            return 0;
        } else if (com.kwad.sdk.core.download.a.b.c(c0304a) == 3) {
            return 0;
        } else {
            AdInfo j = com.kwad.sdk.core.response.a.d.j(c0304a.b());
            com.kwad.sdk.home.download.a.a().a(true);
            if (d.a(c0304a.a(), c0304a.b(), 1) == 1) {
                c(c0304a);
                return 0;
            } else if (c0304a.k() && (!com.kwad.sdk.core.response.a.a.B(j) || g(c0304a))) {
                c(c0304a);
                f(c0304a);
                return 0;
            } else if (!com.kwad.sdk.core.response.a.a.B(j)) {
                if (c0304a.b().isWebViewDownload) {
                    return e(c0304a);
                }
                boolean a = com.kwad.sdk.utils.f.a(c0304a.a(), com.kwad.sdk.core.response.a.a.aL(j), com.kwad.sdk.core.response.a.a.v(j));
                c(c0304a);
                if (a) {
                    com.kwad.sdk.core.report.a.k(c0304a.b());
                    return 0;
                }
                AdWebViewActivityProxy.launch(c0304a.a(), c0304a.b());
                return 0;
            } else {
                if (com.kwad.sdk.core.response.a.a.B(j)) {
                    if (AdWebViewLandPageActivityProxy.showingAdWebViewLandPage || com.kwad.sdk.core.download.kwai.b.a()) {
                        c0304a.d(false);
                        c(c0304a);
                    } else {
                        c(c0304a);
                        if (!b(c0304a)) {
                            c0304a.d(true);
                        }
                    }
                    return e(c0304a);
                }
                return 0;
            }
        }
    }

    public static boolean b(C0304a c0304a) {
        AdTemplate b2 = c0304a.b();
        AdInfo j = com.kwad.sdk.core.response.a.d.j(b2);
        if (!c0304a.k() || !com.kwad.sdk.core.response.a.a.V(j) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.G(j)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0304a.d().d()) {
            return false;
        }
        AdWebViewVideoActivityProxy.launch(c0304a.a(), b2);
        return true;
    }

    public static void c(C0304a c0304a) {
        d(c0304a);
        if (c0304a.c() != null) {
            c0304a.c().a();
        }
    }

    public static void d(C0304a c0304a) {
        if (c0304a.h()) {
            com.kwad.sdk.core.report.a.a(c0304a.d, c0304a.k, c0304a.j());
        }
    }

    public static int e(C0304a c0304a) {
        com.kwad.sdk.core.download.a.b d = c0304a.d();
        if (d == null) {
            d = new com.kwad.sdk.core.download.a.b(c0304a.d);
            c0304a.a(d);
        }
        return d.a(c0304a);
    }

    public static void f(C0304a c0304a) {
        int i;
        AdTemplate b2 = c0304a.b();
        Context a = c0304a.a();
        AdInfo j = com.kwad.sdk.core.response.a.d.j(b2);
        if (com.kwad.sdk.utils.f.a(a, com.kwad.sdk.core.response.a.a.aL(j), com.kwad.sdk.core.response.a.a.v(j))) {
            com.kwad.sdk.core.report.a.k(b2);
            return;
        }
        if (g(c0304a)) {
            i = 4;
        } else if (com.kwad.sdk.core.response.a.a.V(j) && !b2.mAdWebVideoPageShowing) {
            AdWebViewVideoActivityProxy.launch(a, b2);
            return;
        } else {
            i = 0;
        }
        AdWebViewActivityProxy.launch(a, b2, i);
    }

    public static boolean g(C0304a c0304a) {
        AdTemplate b2 = c0304a.b();
        return com.kwad.sdk.core.response.a.b.j(b2) && !b2.interactLandingPageShowing;
    }
}
