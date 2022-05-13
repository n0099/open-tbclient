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
    public static class C0295a {
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

        public C0295a(Context context) {
            this.a = context;
        }

        public Context a() {
            return this.a;
        }

        public C0295a a(int i) {
            this.h = i;
            return this;
        }

        public C0295a a(b bVar) {
            this.e = bVar;
            return this;
        }

        public C0295a a(com.kwad.sdk.core.download.a.b bVar) {
            this.f = bVar;
            return this;
        }

        public C0295a a(p.a aVar) {
            this.k = aVar;
            return this;
        }

        public C0295a a(AdTemplate adTemplate) {
            this.d = adTemplate;
            return this;
        }

        public C0295a a(JSONObject jSONObject) {
            this.l = jSONObject;
            return this;
        }

        public C0295a a(boolean z) {
            this.g = z;
            return this;
        }

        public C0295a b(boolean z) {
            this.i = z;
            return this;
        }

        public AdTemplate b() {
            return this.d;
        }

        public C0295a c(boolean z) {
            this.j = z;
            return this;
        }

        public b c() {
            return this.e;
        }

        public C0295a d(boolean z) {
            this.m = z;
            return this;
        }

        public com.kwad.sdk.core.download.a.b d() {
            return this.f;
        }

        public C0295a e(boolean z) {
            this.c = z;
            return this;
        }

        public boolean e() {
            return this.g;
        }

        public C0295a f(boolean z) {
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
        return a(new C0295a(context).a(adTemplate).a(bVar).a(bVar2).a(z).b(false));
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
            int a = bVar2.a(new C0295a(context).a(z).a(adTemplate).b(z2).d(false));
            int i = j.status;
            if (i != 2 && i != 3) {
                bVar.a();
            }
            return a;
        } else {
            return 0;
        }
    }

    public static int a(C0295a c0295a) {
        if (c0295a.l()) {
            a(c0295a.a(), c0295a.b(), c0295a.c(), c0295a.d(), c0295a.g, c0295a.f());
            return 0;
        } else if (com.kwad.sdk.core.download.a.b.c(c0295a) == 3) {
            return 0;
        } else {
            AdInfo j = com.kwad.sdk.core.response.a.d.j(c0295a.b());
            com.kwad.sdk.home.download.a.a().a(true);
            if (d.a(c0295a.a(), c0295a.b(), 1) == 1) {
                c(c0295a);
                return 0;
            } else if (c0295a.k() && (!com.kwad.sdk.core.response.a.a.B(j) || g(c0295a))) {
                c(c0295a);
                f(c0295a);
                return 0;
            } else if (!com.kwad.sdk.core.response.a.a.B(j)) {
                if (c0295a.b().isWebViewDownload) {
                    return e(c0295a);
                }
                boolean a = com.kwad.sdk.utils.f.a(c0295a.a(), com.kwad.sdk.core.response.a.a.aL(j), com.kwad.sdk.core.response.a.a.v(j));
                c(c0295a);
                if (a) {
                    com.kwad.sdk.core.report.a.k(c0295a.b());
                    return 0;
                }
                AdWebViewActivityProxy.launch(c0295a.a(), c0295a.b());
                return 0;
            } else {
                if (com.kwad.sdk.core.response.a.a.B(j)) {
                    if (AdWebViewLandPageActivityProxy.showingAdWebViewLandPage || com.kwad.sdk.core.download.kwai.b.a()) {
                        c0295a.d(false);
                        c(c0295a);
                    } else {
                        c(c0295a);
                        if (!b(c0295a)) {
                            c0295a.d(true);
                        }
                    }
                    return e(c0295a);
                }
                return 0;
            }
        }
    }

    public static boolean b(C0295a c0295a) {
        AdTemplate b2 = c0295a.b();
        AdInfo j = com.kwad.sdk.core.response.a.d.j(b2);
        if (!c0295a.k() || !com.kwad.sdk.core.response.a.a.V(j) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.G(j)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0295a.d().d()) {
            return false;
        }
        AdWebViewVideoActivityProxy.launch(c0295a.a(), b2);
        return true;
    }

    public static void c(C0295a c0295a) {
        d(c0295a);
        if (c0295a.c() != null) {
            c0295a.c().a();
        }
    }

    public static void d(C0295a c0295a) {
        if (c0295a.h()) {
            com.kwad.sdk.core.report.a.a(c0295a.d, c0295a.k, c0295a.j());
        }
    }

    public static int e(C0295a c0295a) {
        com.kwad.sdk.core.download.a.b d = c0295a.d();
        if (d == null) {
            d = new com.kwad.sdk.core.download.a.b(c0295a.d);
            c0295a.a(d);
        }
        return d.a(c0295a);
    }

    public static void f(C0295a c0295a) {
        int i;
        AdTemplate b2 = c0295a.b();
        Context a = c0295a.a();
        AdInfo j = com.kwad.sdk.core.response.a.d.j(b2);
        if (com.kwad.sdk.utils.f.a(a, com.kwad.sdk.core.response.a.a.aL(j), com.kwad.sdk.core.response.a.a.v(j))) {
            com.kwad.sdk.core.report.a.k(b2);
            return;
        }
        if (g(c0295a)) {
            i = 4;
        } else if (com.kwad.sdk.core.response.a.a.V(j) && !b2.mAdWebVideoPageShowing) {
            AdWebViewVideoActivityProxy.launch(a, b2);
            return;
        } else {
            i = 0;
        }
        AdWebViewActivityProxy.launch(a, b2, i);
    }

    public static boolean g(C0295a c0295a) {
        AdTemplate b2 = c0295a.b();
        return com.kwad.sdk.core.response.a.b.j(b2) && !b2.interactLandingPageShowing;
    }
}
