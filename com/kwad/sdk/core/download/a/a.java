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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.kwad.sdk.core.download.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C2116a {
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f55951b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f55952c;

        /* renamed from: d  reason: collision with root package name */
        public AdTemplate f55953d;

        /* renamed from: e  reason: collision with root package name */
        public b f55954e;

        /* renamed from: f  reason: collision with root package name */
        public com.kwad.sdk.core.download.a.b f55955f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f55956g;

        /* renamed from: h  reason: collision with root package name */
        public int f55957h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f55958i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f55959j;
        public p.a k;
        public JSONObject l;
        public boolean m = false;

        public C2116a(Context context) {
            this.a = context;
        }

        public Context a() {
            return this.a;
        }

        public C2116a a(int i2) {
            this.f55957h = i2;
            return this;
        }

        public C2116a a(b bVar) {
            this.f55954e = bVar;
            return this;
        }

        public C2116a a(com.kwad.sdk.core.download.a.b bVar) {
            this.f55955f = bVar;
            return this;
        }

        public C2116a a(p.a aVar) {
            this.k = aVar;
            return this;
        }

        public C2116a a(AdTemplate adTemplate) {
            this.f55953d = adTemplate;
            return this;
        }

        public C2116a a(JSONObject jSONObject) {
            this.l = jSONObject;
            return this;
        }

        public C2116a a(boolean z) {
            this.f55956g = z;
            return this;
        }

        public C2116a b(boolean z) {
            this.f55958i = z;
            return this;
        }

        public AdTemplate b() {
            return this.f55953d;
        }

        public C2116a c(boolean z) {
            this.f55959j = z;
            return this;
        }

        public b c() {
            return this.f55954e;
        }

        public C2116a d(boolean z) {
            this.m = z;
            return this;
        }

        public com.kwad.sdk.core.download.a.b d() {
            return this.f55955f;
        }

        public C2116a e(boolean z) {
            this.f55952c = z;
            return this;
        }

        public boolean e() {
            return this.f55956g;
        }

        public C2116a f(boolean z) {
            this.f55951b = z;
            return this;
        }

        public boolean f() {
            return this.f55958i;
        }

        public int g() {
            return this.f55957h;
        }

        public boolean h() {
            return this.f55959j;
        }

        public boolean i() {
            return this.m;
        }

        public JSONObject j() {
            return this.l;
        }

        public boolean k() {
            return this.f55952c;
        }

        public boolean l() {
            return this.f55951b;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable com.kwad.sdk.core.download.a.b bVar2, boolean z) {
        return a(new C2116a(context).a(adTemplate).a(bVar).a(bVar2).a(z).b(false));
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
            int a = bVar2.a(new C2116a(context).a(z).a(adTemplate).b(z2).d(false));
            int i2 = j2.status;
            if (i2 != 2 && i2 != 3) {
                bVar.a();
            }
            return a;
        } else {
            return 0;
        }
    }

    public static int a(C2116a c2116a) {
        if (c2116a.l()) {
            a(c2116a.a(), c2116a.b(), c2116a.c(), c2116a.d(), c2116a.f55956g, c2116a.f());
            return 0;
        } else if (com.kwad.sdk.core.download.a.b.c(c2116a) == 3) {
            return 0;
        } else {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(c2116a.b());
            com.kwad.sdk.home.download.a.a().a(true);
            if (d.a(c2116a.a(), c2116a.b(), 1) == 1) {
                c(c2116a);
                return 0;
            } else if (c2116a.k() && (!com.kwad.sdk.core.response.a.a.B(j2) || g(c2116a))) {
                c(c2116a);
                f(c2116a);
                return 0;
            } else if (!com.kwad.sdk.core.response.a.a.B(j2)) {
                if (c2116a.b().isWebViewDownload) {
                    return e(c2116a);
                }
                boolean a = com.kwad.sdk.utils.f.a(c2116a.a(), com.kwad.sdk.core.response.a.a.aL(j2), com.kwad.sdk.core.response.a.a.v(j2));
                c(c2116a);
                if (a) {
                    com.kwad.sdk.core.report.a.k(c2116a.b());
                    return 0;
                }
                AdWebViewActivityProxy.launch(c2116a.a(), c2116a.b());
                return 0;
            } else {
                if (com.kwad.sdk.core.response.a.a.B(j2)) {
                    if (AdWebViewLandPageActivityProxy.showingAdWebViewLandPage || com.kwad.sdk.core.download.kwai.b.a()) {
                        c2116a.d(false);
                        c(c2116a);
                    } else {
                        c(c2116a);
                        if (!b(c2116a)) {
                            c2116a.d(true);
                        }
                    }
                    return e(c2116a);
                }
                return 0;
            }
        }
    }

    public static boolean b(C2116a c2116a) {
        AdTemplate b2 = c2116a.b();
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(b2);
        if (!c2116a.k() || !com.kwad.sdk.core.response.a.a.V(j2) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.G(j2)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c2116a.d().d()) {
            return false;
        }
        AdWebViewVideoActivityProxy.launch(c2116a.a(), b2);
        return true;
    }

    public static void c(C2116a c2116a) {
        d(c2116a);
        if (c2116a.c() != null) {
            c2116a.c().a();
        }
    }

    public static void d(C2116a c2116a) {
        if (c2116a.h()) {
            com.kwad.sdk.core.report.a.a(c2116a.f55953d, c2116a.k, c2116a.j());
        }
    }

    public static int e(C2116a c2116a) {
        com.kwad.sdk.core.download.a.b d2 = c2116a.d();
        if (d2 == null) {
            d2 = new com.kwad.sdk.core.download.a.b(c2116a.f55953d);
            c2116a.a(d2);
        }
        return d2.a(c2116a);
    }

    public static void f(C2116a c2116a) {
        int i2;
        AdTemplate b2 = c2116a.b();
        Context a = c2116a.a();
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(b2);
        if (com.kwad.sdk.utils.f.a(a, com.kwad.sdk.core.response.a.a.aL(j2), com.kwad.sdk.core.response.a.a.v(j2))) {
            com.kwad.sdk.core.report.a.k(b2);
            return;
        }
        if (g(c2116a)) {
            i2 = 4;
        } else if (com.kwad.sdk.core.response.a.a.V(j2) && !b2.mAdWebVideoPageShowing) {
            AdWebViewVideoActivityProxy.launch(a, b2);
            return;
        } else {
            i2 = 0;
        }
        AdWebViewActivityProxy.launch(a, b2, i2);
    }

    public static boolean g(C2116a c2116a) {
        AdTemplate b2 = c2116a.b();
        return com.kwad.sdk.core.response.a.b.j(b2) && !b2.interactLandingPageShowing;
    }
}
