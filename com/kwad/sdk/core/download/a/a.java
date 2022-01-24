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
    public static class C2106a {
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f55784b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f55785c;

        /* renamed from: d  reason: collision with root package name */
        public AdTemplate f55786d;

        /* renamed from: e  reason: collision with root package name */
        public b f55787e;

        /* renamed from: f  reason: collision with root package name */
        public com.kwad.sdk.core.download.a.b f55788f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f55789g;

        /* renamed from: h  reason: collision with root package name */
        public int f55790h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f55791i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f55792j;
        public p.a k;
        public JSONObject l;
        public boolean m = false;

        public C2106a(Context context) {
            this.a = context;
        }

        public Context a() {
            return this.a;
        }

        public C2106a a(int i2) {
            this.f55790h = i2;
            return this;
        }

        public C2106a a(b bVar) {
            this.f55787e = bVar;
            return this;
        }

        public C2106a a(com.kwad.sdk.core.download.a.b bVar) {
            this.f55788f = bVar;
            return this;
        }

        public C2106a a(p.a aVar) {
            this.k = aVar;
            return this;
        }

        public C2106a a(AdTemplate adTemplate) {
            this.f55786d = adTemplate;
            return this;
        }

        public C2106a a(JSONObject jSONObject) {
            this.l = jSONObject;
            return this;
        }

        public C2106a a(boolean z) {
            this.f55789g = z;
            return this;
        }

        public C2106a b(boolean z) {
            this.f55791i = z;
            return this;
        }

        public AdTemplate b() {
            return this.f55786d;
        }

        public C2106a c(boolean z) {
            this.f55792j = z;
            return this;
        }

        public b c() {
            return this.f55787e;
        }

        public C2106a d(boolean z) {
            this.m = z;
            return this;
        }

        public com.kwad.sdk.core.download.a.b d() {
            return this.f55788f;
        }

        public C2106a e(boolean z) {
            this.f55785c = z;
            return this;
        }

        public boolean e() {
            return this.f55789g;
        }

        public C2106a f(boolean z) {
            this.f55784b = z;
            return this;
        }

        public boolean f() {
            return this.f55791i;
        }

        public int g() {
            return this.f55790h;
        }

        public boolean h() {
            return this.f55792j;
        }

        public boolean i() {
            return this.m;
        }

        public JSONObject j() {
            return this.l;
        }

        public boolean k() {
            return this.f55785c;
        }

        public boolean l() {
            return this.f55784b;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable com.kwad.sdk.core.download.a.b bVar2, boolean z) {
        return a(new C2106a(context).a(adTemplate).a(bVar).a(bVar2).a(z).b(false));
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
            int a = bVar2.a(new C2106a(context).a(z).a(adTemplate).b(z2).d(false));
            int i2 = j2.status;
            if (i2 != 2 && i2 != 3) {
                bVar.a();
            }
            return a;
        } else {
            return 0;
        }
    }

    public static int a(C2106a c2106a) {
        if (c2106a.l()) {
            a(c2106a.a(), c2106a.b(), c2106a.c(), c2106a.d(), c2106a.f55789g, c2106a.f());
            return 0;
        } else if (com.kwad.sdk.core.download.a.b.c(c2106a) == 3) {
            return 0;
        } else {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(c2106a.b());
            com.kwad.sdk.home.download.a.a().a(true);
            if (d.a(c2106a.a(), c2106a.b(), 1) == 1) {
                c(c2106a);
                return 0;
            } else if (c2106a.k() && (!com.kwad.sdk.core.response.a.a.B(j2) || g(c2106a))) {
                c(c2106a);
                f(c2106a);
                return 0;
            } else if (!com.kwad.sdk.core.response.a.a.B(j2)) {
                if (c2106a.b().isWebViewDownload) {
                    return e(c2106a);
                }
                boolean a = com.kwad.sdk.utils.f.a(c2106a.a(), com.kwad.sdk.core.response.a.a.aL(j2), com.kwad.sdk.core.response.a.a.v(j2));
                c(c2106a);
                if (a) {
                    com.kwad.sdk.core.report.a.k(c2106a.b());
                    return 0;
                }
                AdWebViewActivityProxy.launch(c2106a.a(), c2106a.b());
                return 0;
            } else {
                if (com.kwad.sdk.core.response.a.a.B(j2)) {
                    if (AdWebViewLandPageActivityProxy.showingAdWebViewLandPage || com.kwad.sdk.core.download.kwai.b.a()) {
                        c2106a.d(false);
                        c(c2106a);
                    } else {
                        c(c2106a);
                        if (!b(c2106a)) {
                            c2106a.d(true);
                        }
                    }
                    return e(c2106a);
                }
                return 0;
            }
        }
    }

    public static boolean b(C2106a c2106a) {
        AdTemplate b2 = c2106a.b();
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(b2);
        if (!c2106a.k() || !com.kwad.sdk.core.response.a.a.V(j2) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.G(j2)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c2106a.d().d()) {
            return false;
        }
        AdWebViewVideoActivityProxy.launch(c2106a.a(), b2);
        return true;
    }

    public static void c(C2106a c2106a) {
        d(c2106a);
        if (c2106a.c() != null) {
            c2106a.c().a();
        }
    }

    public static void d(C2106a c2106a) {
        if (c2106a.h()) {
            com.kwad.sdk.core.report.a.a(c2106a.f55786d, c2106a.k, c2106a.j());
        }
    }

    public static int e(C2106a c2106a) {
        com.kwad.sdk.core.download.a.b d2 = c2106a.d();
        if (d2 == null) {
            d2 = new com.kwad.sdk.core.download.a.b(c2106a.f55786d);
            c2106a.a(d2);
        }
        return d2.a(c2106a);
    }

    public static void f(C2106a c2106a) {
        int i2;
        AdTemplate b2 = c2106a.b();
        Context a = c2106a.a();
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(b2);
        if (com.kwad.sdk.utils.f.a(a, com.kwad.sdk.core.response.a.a.aL(j2), com.kwad.sdk.core.response.a.a.v(j2))) {
            com.kwad.sdk.core.report.a.k(b2);
            return;
        }
        if (g(c2106a)) {
            i2 = 4;
        } else if (com.kwad.sdk.core.response.a.a.V(j2) && !b2.mAdWebVideoPageShowing) {
            AdWebViewVideoActivityProxy.launch(a, b2);
            return;
        } else {
            i2 = 0;
        }
        AdWebViewActivityProxy.launch(a, b2, i2);
    }

    public static boolean g(C2106a c2106a) {
        AdTemplate b2 = c2106a.b();
        return com.kwad.sdk.core.response.a.b.j(b2) && !b2.interactLandingPageShowing;
    }
}
