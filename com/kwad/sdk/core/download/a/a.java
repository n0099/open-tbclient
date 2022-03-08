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
    public static class C2095a {
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f54301b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f54302c;

        /* renamed from: d  reason: collision with root package name */
        public AdTemplate f54303d;

        /* renamed from: e  reason: collision with root package name */
        public b f54304e;

        /* renamed from: f  reason: collision with root package name */
        public com.kwad.sdk.core.download.a.b f54305f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f54306g;

        /* renamed from: h  reason: collision with root package name */
        public int f54307h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f54308i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f54309j;
        public p.a k;
        public JSONObject l;
        public boolean m = false;

        public C2095a(Context context) {
            this.a = context;
        }

        public Context a() {
            return this.a;
        }

        public C2095a a(int i2) {
            this.f54307h = i2;
            return this;
        }

        public C2095a a(b bVar) {
            this.f54304e = bVar;
            return this;
        }

        public C2095a a(com.kwad.sdk.core.download.a.b bVar) {
            this.f54305f = bVar;
            return this;
        }

        public C2095a a(p.a aVar) {
            this.k = aVar;
            return this;
        }

        public C2095a a(AdTemplate adTemplate) {
            this.f54303d = adTemplate;
            return this;
        }

        public C2095a a(JSONObject jSONObject) {
            this.l = jSONObject;
            return this;
        }

        public C2095a a(boolean z) {
            this.f54306g = z;
            return this;
        }

        public C2095a b(boolean z) {
            this.f54308i = z;
            return this;
        }

        public AdTemplate b() {
            return this.f54303d;
        }

        public C2095a c(boolean z) {
            this.f54309j = z;
            return this;
        }

        public b c() {
            return this.f54304e;
        }

        public C2095a d(boolean z) {
            this.m = z;
            return this;
        }

        public com.kwad.sdk.core.download.a.b d() {
            return this.f54305f;
        }

        public C2095a e(boolean z) {
            this.f54302c = z;
            return this;
        }

        public boolean e() {
            return this.f54306g;
        }

        public C2095a f(boolean z) {
            this.f54301b = z;
            return this;
        }

        public boolean f() {
            return this.f54308i;
        }

        public int g() {
            return this.f54307h;
        }

        public boolean h() {
            return this.f54309j;
        }

        public boolean i() {
            return this.m;
        }

        public JSONObject j() {
            return this.l;
        }

        public boolean k() {
            return this.f54302c;
        }

        public boolean l() {
            return this.f54301b;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable com.kwad.sdk.core.download.a.b bVar2, boolean z) {
        return a(new C2095a(context).a(adTemplate).a(bVar).a(bVar2).a(z).b(false));
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
            int a = bVar2.a(new C2095a(context).a(z).a(adTemplate).b(z2).d(false));
            int i2 = j2.status;
            if (i2 != 2 && i2 != 3) {
                bVar.a();
            }
            return a;
        } else {
            return 0;
        }
    }

    public static int a(C2095a c2095a) {
        if (c2095a.l()) {
            a(c2095a.a(), c2095a.b(), c2095a.c(), c2095a.d(), c2095a.f54306g, c2095a.f());
            return 0;
        } else if (com.kwad.sdk.core.download.a.b.c(c2095a) == 3) {
            return 0;
        } else {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(c2095a.b());
            com.kwad.sdk.home.download.a.a().a(true);
            if (d.a(c2095a.a(), c2095a.b(), 1) == 1) {
                c(c2095a);
                return 0;
            } else if (c2095a.k() && (!com.kwad.sdk.core.response.a.a.B(j2) || g(c2095a))) {
                c(c2095a);
                f(c2095a);
                return 0;
            } else if (!com.kwad.sdk.core.response.a.a.B(j2)) {
                if (c2095a.b().isWebViewDownload) {
                    return e(c2095a);
                }
                boolean a = com.kwad.sdk.utils.f.a(c2095a.a(), com.kwad.sdk.core.response.a.a.aL(j2), com.kwad.sdk.core.response.a.a.v(j2));
                c(c2095a);
                if (a) {
                    com.kwad.sdk.core.report.a.k(c2095a.b());
                    return 0;
                }
                AdWebViewActivityProxy.launch(c2095a.a(), c2095a.b());
                return 0;
            } else {
                if (com.kwad.sdk.core.response.a.a.B(j2)) {
                    if (AdWebViewLandPageActivityProxy.showingAdWebViewLandPage || com.kwad.sdk.core.download.kwai.b.a()) {
                        c2095a.d(false);
                        c(c2095a);
                    } else {
                        c(c2095a);
                        if (!b(c2095a)) {
                            c2095a.d(true);
                        }
                    }
                    return e(c2095a);
                }
                return 0;
            }
        }
    }

    public static boolean b(C2095a c2095a) {
        AdTemplate b2 = c2095a.b();
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(b2);
        if (!c2095a.k() || !com.kwad.sdk.core.response.a.a.V(j2) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.G(j2)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c2095a.d().d()) {
            return false;
        }
        AdWebViewVideoActivityProxy.launch(c2095a.a(), b2);
        return true;
    }

    public static void c(C2095a c2095a) {
        d(c2095a);
        if (c2095a.c() != null) {
            c2095a.c().a();
        }
    }

    public static void d(C2095a c2095a) {
        if (c2095a.h()) {
            com.kwad.sdk.core.report.a.a(c2095a.f54303d, c2095a.k, c2095a.j());
        }
    }

    public static int e(C2095a c2095a) {
        com.kwad.sdk.core.download.a.b d2 = c2095a.d();
        if (d2 == null) {
            d2 = new com.kwad.sdk.core.download.a.b(c2095a.f54303d);
            c2095a.a(d2);
        }
        return d2.a(c2095a);
    }

    public static void f(C2095a c2095a) {
        int i2;
        AdTemplate b2 = c2095a.b();
        Context a = c2095a.a();
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(b2);
        if (com.kwad.sdk.utils.f.a(a, com.kwad.sdk.core.response.a.a.aL(j2), com.kwad.sdk.core.response.a.a.v(j2))) {
            com.kwad.sdk.core.report.a.k(b2);
            return;
        }
        if (g(c2095a)) {
            i2 = 4;
        } else if (com.kwad.sdk.core.response.a.a.V(j2) && !b2.mAdWebVideoPageShowing) {
            AdWebViewVideoActivityProxy.launch(a, b2);
            return;
        } else {
            i2 = 0;
        }
        AdWebViewActivityProxy.launch(a, b2, i2);
    }

    public static boolean g(C2095a c2095a) {
        AdTemplate b2 = c2095a.b();
        return com.kwad.sdk.core.response.a.b.j(b2) && !b2.interactLandingPageShowing;
    }
}
