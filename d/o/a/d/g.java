package d.o.a.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import d.o.a.a.a.d.c;
import d.o.a.b.a.a.a;
import d.o.a.b.a.a.b;
import d.o.a.d.f.c;
import d.o.a.d.f.n;
import d.o.a.d.j;
import d.o.a.e.b.a.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g implements d.o.a.b.a.d {

    /* renamed from: b  reason: collision with root package name */
    public static String f66665b = "g";

    /* renamed from: c  reason: collision with root package name */
    public static volatile g f66666c;

    /* renamed from: a  reason: collision with root package name */
    public l f66667a = l.b(n.a());

    /* loaded from: classes7.dex */
    public class a implements c.InterfaceC1818c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.d f66668a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.c f66669b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.b f66670c;

        public a(d.o.a.a.a.c.d dVar, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar) {
            this.f66668a = dVar;
            this.f66669b = cVar;
            this.f66670c = bVar;
        }

        @Override // d.o.a.a.a.d.c.InterfaceC1818c
        public void a(DialogInterface dialogInterface) {
            j.c.a().m("landing_download_dialog_cancel", this.f66668a, this.f66669b, this.f66670c);
            dialogInterface.dismiss();
        }

        @Override // d.o.a.a.a.d.c.InterfaceC1818c
        public void b(DialogInterface dialogInterface) {
            g.this.f66667a.g(this.f66668a.a(), this.f66668a.d(), 2, this.f66669b, this.f66670c);
            j.c.a().m("landing_download_dialog_confirm", this.f66668a, this.f66669b, this.f66670c);
            dialogInterface.dismiss();
        }

        @Override // d.o.a.a.a.d.c.InterfaceC1818c
        public void c(DialogInterface dialogInterface) {
            j.c.a().m("landing_download_dialog_cancel", this.f66668a, this.f66669b, this.f66670c);
        }
    }

    /* loaded from: classes7.dex */
    public class b {

        /* loaded from: classes7.dex */
        public static class a implements e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JSONObject f66672a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.o.a.b.a.c.a f66673b;

            public a(JSONObject jSONObject, d.o.a.b.a.c.a aVar) {
                this.f66672a = jSONObject;
                this.f66673b = aVar;
            }

            @Override // d.o.a.d.g.e
            public void a(boolean z) {
                if (z) {
                    j.c.a().t("deeplink_success", this.f66672a, this.f66673b);
                } else {
                    j.c.a().t("deeplink_failed", this.f66672a, this.f66673b);
                }
            }
        }

        /* renamed from: d.o.a.d.g$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C1829b implements e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JSONObject f66674a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.o.a.b.a.c.a f66675b;

            public C1829b(JSONObject jSONObject, d.o.a.b.a.c.a aVar) {
                this.f66674a = jSONObject;
                this.f66675b = aVar;
            }

            @Override // d.o.a.d.g.e
            public void a(boolean z) {
                if (z) {
                    j.c.a().t("deeplink_success", this.f66674a, this.f66675b);
                } else {
                    j.c.a().t("deeplink_failed", this.f66674a, this.f66675b);
                }
            }
        }

        public static void a(@NonNull d.o.a.b.a.c.b bVar) {
            String f2 = bVar.f();
            JSONObject jSONObject = new JSONObject();
            d.o.a.d.n.f.a(jSONObject, bVar);
            d.o.a.d.n.k.r(jSONObject, "applink_source", "notify_click_by_sdk");
            j.c.a().t("applink_click", jSONObject, bVar);
            c.h k = d.o.a.d.n.h.k(f2, bVar);
            if (k.a() == 2) {
                if (!TextUtils.isEmpty(f2)) {
                    k("notify_by_url", k, jSONObject, bVar);
                }
                k = d.o.a.d.n.h.d(n.a(), bVar.e(), bVar);
            }
            int a2 = k.a();
            if (a2 == 1) {
                l("notify_by_url", jSONObject, bVar);
            } else if (a2 == 3) {
                d("notify_by_package", jSONObject, bVar);
            } else if (a2 != 4) {
                d.o.a.d.n.k.B();
            } else {
                c("notify_by_package", k, jSONObject, bVar);
            }
        }

        public static void b(c.h hVar, c.f fVar) {
            String m = d.o.a.d.n.k.m(hVar.c(), "open_market");
            JSONObject jSONObject = new JSONObject();
            d.o.a.d.n.k.r(jSONObject, "ttdownloader_type", UnitedSchemeConstants.UNITED_SCHEME_BACKUP);
            int a2 = hVar.a();
            if (a2 == 5) {
                e(m, jSONObject, fVar);
            } else if (a2 != 6) {
            } else {
                d.o.a.d.n.k.r(jSONObject, "error_code", Integer.valueOf(hVar.b()));
                j.c.a().t("market_open_failed", jSONObject, fVar);
            }
        }

        public static void c(String str, @NonNull c.h hVar, @NonNull JSONObject jSONObject, @NonNull d.o.a.b.a.c.a aVar) {
            d.o.a.d.n.k.r(jSONObject, "applink_source", str);
            d.o.a.d.n.k.r(jSONObject, "error_code", Integer.valueOf(hVar.b()));
            j.c.a().t("deeplink_app_open_fail", jSONObject, aVar);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void d(String str, @NonNull JSONObject jSONObject, @NonNull d.o.a.b.a.c.a aVar) {
            char c2;
            d.o.a.d.n.k.r(jSONObject, "applink_source", str);
            j.c.a().t("deeplink_app_open", jSONObject, aVar);
            switch (str.hashCode()) {
                case -1282070764:
                    if (str.equals("notify_by_package")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -441514770:
                    if (str.equals("auto_by_package")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -185950114:
                    if (str.equals("by_package")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 368401333:
                    if (str.equals("dialog_by_package")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                if (n.s().optInt("download_sdk_optimize_mode") == 1) {
                    d.o.a.d.n.k.r(jSONObject, "check_applink_result_opt", 1);
                    f.a().b(aVar.e(), new a(jSONObject, aVar));
                    return;
                }
            } else if (c2 != 2 && c2 != 3) {
                return;
            }
            n.m().a(n.a(), aVar.t(), aVar.v(), aVar.u(), aVar.e(), str);
        }

        public static void e(String str, @Nullable JSONObject jSONObject, c.f fVar) {
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (Exception e2) {
                    d.o.a.d.n.k.q(e2);
                    return;
                }
            }
            d.o.a.d.n.k.r(jSONObject, "applink_source", str);
            j.c.a().t("market_open_success", jSONObject, fVar);
            n.m().a(n.a(), fVar.f66544b, fVar.f66546d, fVar.f66545c, fVar.f66544b.v(), str);
            d.o.a.b.a.c.b bVar = new d.o.a.b.a.c.b(fVar.f66544b, fVar.f66545c, fVar.f66546d);
            bVar.v0(2);
            bVar.A0(System.currentTimeMillis());
            bVar.H0(4);
            bVar.L0(2);
            c.g.e().j(bVar);
        }

        public static boolean f(long j) {
            return c.g.e().u(j) == null;
        }

        public static boolean g(@NonNull c.f fVar) {
            boolean z;
            d.o.a.a.a.d.b x = fVar.f66544b.x();
            String d2 = x == null ? null : x.d();
            JSONObject jSONObject = new JSONObject();
            d.o.a.d.n.f.a(jSONObject, fVar);
            d.o.a.d.n.k.r(jSONObject, "applink_source", "click_by_sdk");
            j.c.a().t("applink_click", jSONObject, fVar);
            c.h k = d.o.a.d.n.h.k(d2, fVar);
            if (k.a() == 2) {
                if (!TextUtils.isEmpty(d2)) {
                    k("by_url", k, jSONObject, fVar);
                }
                k = d.o.a.d.n.h.d(n.a(), fVar.f66544b.v(), fVar);
            }
            boolean z2 = false;
            if (f(fVar.f66543a) && n.s().optInt("link_ad_click_event") == 1) {
                d.o.a.a.a.c.d dVar = fVar.f66544b;
                if (dVar instanceof d.o.a.b.a.a.c) {
                    ((d.o.a.b.a.a.c) dVar).b(4);
                }
                j.c.a().c(fVar.f66543a, 0);
                z = true;
            } else {
                z = false;
            }
            int a2 = k.a();
            if (a2 == 1) {
                l("by_url", jSONObject, fVar);
            } else if (a2 == 3) {
                d("by_package", jSONObject, fVar);
            } else {
                if (a2 != 4) {
                    d.o.a.d.n.k.B();
                } else {
                    c("by_package", k, jSONObject, fVar);
                }
                if (z2 && !z && ((j.e.a().c() && !j.e.a().d(fVar.f66543a, fVar.f66544b.u())) || j.e.a().f())) {
                    j.c.a().c(fVar.f66543a, 2);
                }
                return z2;
            }
            z2 = true;
            if (z2) {
                j.c.a().c(fVar.f66543a, 2);
            }
            return z2;
        }

        public static boolean h(@NonNull c.f fVar, int i) {
            JSONObject jSONObject = new JSONObject();
            j.c.a().t("market_click_open", jSONObject, fVar);
            c.h b2 = d.o.a.d.n.h.b(n.a(), fVar, fVar.f66544b.v());
            String m = d.o.a.d.n.k.m(b2.c(), "open_market");
            int a2 = b2.a();
            if (a2 == 5) {
                e(m, jSONObject, fVar);
            } else if (a2 == 6) {
                d.o.a.d.n.k.r(jSONObject, "error_code", Integer.valueOf(b2.b()));
                j.c.a().t("market_open_failed", jSONObject, fVar);
                return false;
            } else if (a2 != 7) {
                return false;
            }
            j.c.a().c(fVar.f66543a, i);
            return true;
        }

        public static boolean i(String str, @NonNull d.o.a.b.a.c.b bVar) {
            if (d.o.a.d.f.l.h(bVar.J())) {
                if (TextUtils.isEmpty(bVar.f()) && TextUtils.isEmpty(str)) {
                    return false;
                }
                d.o.a.e.b.p.b.a().m(bVar.s());
                JSONObject jSONObject = new JSONObject();
                d.o.a.d.n.f.a(jSONObject, bVar);
                d.o.a.d.n.k.r(jSONObject, "applink_source", "auto_click");
                j.c.a().n("applink_click", bVar);
                c.h e2 = d.o.a.d.n.h.e(bVar, bVar.f(), bVar.e());
                int a2 = e2.a();
                if (a2 == 1) {
                    l("auto_by_url", jSONObject, bVar);
                    return true;
                } else if (a2 == 2) {
                    k("auto_by_url", e2, jSONObject, bVar);
                    return false;
                } else if (a2 == 3) {
                    d("auto_by_package", jSONObject, bVar);
                    return true;
                } else if (a2 != 4) {
                    return false;
                } else {
                    c("auto_by_package", e2, jSONObject, bVar);
                    return false;
                }
            }
            return false;
        }

        public static void j(d.o.a.b.a.c.b bVar) {
            if (bVar == null) {
                return;
            }
            String f2 = d.o.a.e.b.j.a.r().m("app_link_opt") == 1 ? bVar.f() : null;
            JSONObject jSONObject = new JSONObject();
            d.o.a.d.n.f.a(jSONObject, bVar);
            d.o.a.d.n.k.r(jSONObject, "applink_source", "dialog_click_by_sdk");
            j.c.a().t("applink_click", jSONObject, bVar);
            c.h k = d.o.a.d.n.h.k(f2, bVar);
            if (k.a() == 2) {
                if (!TextUtils.isEmpty(f2)) {
                    k("dialog_by_url", k, jSONObject, bVar);
                }
                k = d.o.a.d.n.h.d(n.a(), bVar.e(), bVar);
            }
            int a2 = k.a();
            if (a2 == 1) {
                l("dialog_by_url", jSONObject, bVar);
            } else if (a2 == 3) {
                d("dialog_by_package", jSONObject, bVar);
            } else if (a2 != 4) {
                d.o.a.d.n.k.B();
            } else {
                c("dialog_by_package", k, jSONObject, bVar);
            }
        }

        public static void k(String str, @NonNull c.h hVar, @NonNull JSONObject jSONObject, @NonNull d.o.a.b.a.c.a aVar) {
            d.o.a.d.n.k.r(jSONObject, "applink_source", str);
            d.o.a.d.n.k.r(jSONObject, "error_code", Integer.valueOf(hVar.b()));
            j.c.a().t("deeplink_url_open_fail", jSONObject, aVar);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void l(String str, @NonNull JSONObject jSONObject, @NonNull d.o.a.b.a.c.a aVar) {
            char c2;
            d.o.a.d.n.k.r(jSONObject, "applink_source", str);
            j.c.a().t("deeplink_url_open", jSONObject, aVar);
            switch (str.hashCode()) {
                case -1721882089:
                    if (str.equals("auto_by_url")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1374618233:
                    if (str.equals("by_url")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -129544387:
                    if (str.equals("notify_by_url")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 829750366:
                    if (str.equals("dialog_by_url")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                if (n.s().optInt("download_sdk_optimize_mode") == 1) {
                    d.o.a.d.n.k.r(jSONObject, "check_applink_result_opt", 1);
                    f.a().b(aVar.e(), new C1829b(jSONObject, aVar));
                    return;
                }
            } else if (c2 != 2 && c2 != 3) {
                return;
            }
            n.m().a(n.a(), aVar.t(), aVar.v(), aVar.u(), aVar.e(), str);
        }
    }

    /* loaded from: classes7.dex */
    public class c {

        /* loaded from: classes7.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.o.a.b.a.c.b f66676e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f66677f;

            /* renamed from: d.o.a.d.g$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1830a implements i {
                public C1830a() {
                }

                @Override // d.o.a.d.g.i
                public void a(boolean z) {
                    a.this.f66677f.a(z);
                }
            }

            public a(c cVar, d.o.a.b.a.c.b bVar, h hVar) {
                this.f66676e = bVar;
                this.f66677f = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.a(this.f66676e)) {
                    this.f66677f.a(false);
                } else if (!C1831g.c(this.f66676e)) {
                    this.f66677f.a(false);
                } else {
                    C1831g.b(this.f66676e, new C1830a());
                }
            }
        }

        public void a(@NonNull d.o.a.b.a.c.b bVar, @NonNull h hVar, int i) {
            d.o.a.d.i.a().c(new a(this, bVar, hVar), i);
        }
    }

    /* loaded from: classes7.dex */
    public class d {

        /* loaded from: classes7.dex */
        public static class a implements a.b {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.o.a.b.a.c.b f66679e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.o.a.d.m.a.a f66680f;

            public a(d.o.a.b.a.c.b bVar, d.o.a.d.m.a.a aVar) {
                this.f66679e = bVar;
                this.f66680f = aVar;
            }

            @Override // d.o.a.e.b.a.a.b
            public void b() {
                d.o.a.e.b.c.a.g("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                d.o.a.e.b.a.a.c().h(this);
                if (d.o.a.d.n.k.D(this.f66679e)) {
                    return;
                }
                this.f66679e.Z0(true);
                j.c.a().o("install_delay_invoke", this.f66679e);
                this.f66680f.a();
            }

            @Override // d.o.a.e.b.a.a.b
            public void c() {
            }
        }

        public static void a(d.o.a.b.a.c.b bVar, @NonNull d.o.a.d.m.a.a aVar) {
            boolean j = d.o.a.e.b.a.a.c().j();
            if (!j && Build.VERSION.SDK_INT >= 29) {
                d.o.a.d.n.k.G();
            }
            boolean j2 = d.o.a.e.b.a.a.c().j();
            if (!j && j2 && bVar != null) {
                bVar.X0(true);
            }
            aVar.a();
            d.o.a.e.b.c.a.g("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + j2);
            if (j2) {
                return;
            }
            d.o.a.e.b.a.a.c().f(new a(bVar, aVar));
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public class f implements a.b {

        /* loaded from: classes7.dex */
        public class a implements Runnable {
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f66681e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f66682f;

            public b(f fVar, String str, e eVar) {
                this.f66681e = str;
                this.f66682f = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.o.a.d.n.k.H(this.f66681e)) {
                    this.f66682f.a(true);
                } else {
                    this.f66682f.a(false);
                }
            }
        }

        /* loaded from: classes7.dex */
        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public static f f66683a = new f(null);
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        public static f a() {
            return c.f66683a;
        }

        @Override // d.o.a.e.b.a.a.b
        public void b() {
            System.currentTimeMillis();
        }

        @Override // d.o.a.e.b.a.a.b
        public void c() {
        }

        public void c(String str, e eVar, long j) {
            if (eVar == null) {
                return;
            }
            int optInt = n.s().optInt("check_applink_result_delay");
            if (optInt > 0) {
                j = optInt * 1000;
            }
            d.o.a.d.i.a().c(new b(this, str, eVar), j);
        }

        public f() {
            d.o.a.e.b.a.a.c().f(this);
        }

        public void b(String str, e eVar) {
            c(str, eVar, 5000L);
        }
    }

    /* renamed from: d.o.a.d.g$g  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1831g {

        /* renamed from: d.o.a.d.g$g$a */
        /* loaded from: classes7.dex */
        public static class a implements a.b {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.o.a.b.a.c.b f66684e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f66685f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ i f66686g;

            /* renamed from: d.o.a.d.g$g$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC1832a implements Runnable {
                public RunnableC1832a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean H = d.o.a.d.n.k.H(a.this.f66684e.e());
                    long h2 = C1831g.h(a.this.f66684e);
                    if (!H || h2 >= System.currentTimeMillis() - a.this.f66685f) {
                        long k = C1831g.k(a.this.f66684e);
                        long currentTimeMillis = System.currentTimeMillis();
                        a aVar = a.this;
                        if (currentTimeMillis - aVar.f66685f > k) {
                            j.c.a().o("deeplink_delay_timeout", a.this.f66684e);
                            return;
                        }
                        aVar.f66684e.X0(true);
                        j.c.a().o("deeplink_delay_invoke", a.this.f66684e);
                        a.this.f66686g.a(true);
                        d.o.a.b.a.c.b bVar = a.this.f66684e;
                        C1831g.d(bVar, C1831g.m(bVar));
                    }
                }
            }

            public a(d.o.a.b.a.c.b bVar, long j, i iVar) {
                this.f66684e = bVar;
                this.f66685f = j;
                this.f66686g = iVar;
            }

            @Override // d.o.a.e.b.a.a.b
            public void b() {
                d.o.a.e.b.a.a.c().h(this);
                d.o.a.d.i.a().b(new RunnableC1832a());
            }

            @Override // d.o.a.e.b.a.a.b
            public void c() {
            }
        }

        /* renamed from: d.o.a.d.g$g$b */
        /* loaded from: classes7.dex */
        public static class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.o.a.b.a.c.b f66688e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f66689f;

            public b(d.o.a.b.a.c.b bVar, int i) {
                this.f66688e = bVar;
                this.f66689f = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = 1;
                if (d.o.a.d.n.k.H(this.f66688e.e())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!this.f66688e.V()) {
                            i = 2;
                        }
                        jSONObject.putOpt("deeplink_source", Integer.valueOf(i));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    j.c.a().u("deeplink_success_2", jSONObject, this.f66688e);
                    return;
                }
                C1831g.d(this.f66688e, this.f66689f - 1);
            }
        }

        static {
            new Handler(Looper.getMainLooper());
        }

        public static void b(d.o.a.b.a.c.b bVar, @NonNull i iVar) {
            boolean j = d.o.a.e.b.a.a.c().j();
            if (!j && Build.VERSION.SDK_INT >= 29) {
                d.o.a.d.n.k.G();
            }
            boolean j2 = d.o.a.e.b.a.a.c().j();
            boolean z = !j && j2;
            if (bVar != null) {
                bVar.X0(z);
            }
            iVar.a(z);
            if (bVar == null) {
                return;
            }
            d(bVar, m(bVar));
            if (j2) {
                return;
            }
            d.o.a.e.b.a.a.c().f(new a(bVar, System.currentTimeMillis(), iVar));
        }

        public static boolean c(d.o.a.b.a.c.b bVar) {
            return d.o.a.d.n.e.c(bVar).m("app_link_opt_switch") == 1;
        }

        public static void d(@NonNull d.o.a.b.a.c.b bVar, int i) {
            if (i <= 0) {
                return;
            }
            d.o.a.d.i.a().c(new b(bVar, i), l(bVar) * 1000);
        }

        public static boolean e(d.o.a.b.a.c.b bVar) {
            return d.o.a.d.n.e.c(bVar).m("app_link_opt_install_switch") == 1;
        }

        public static boolean f(d.o.a.b.a.c.b bVar) {
            return d.o.a.d.n.e.c(bVar).m("app_link_opt_invoke_switch") == 1;
        }

        public static boolean g(d.o.a.b.a.c.b bVar) {
            return d.o.a.d.n.e.c(bVar).m("app_link_opt_dialog_switch") == 1;
        }

        public static long h(d.o.a.b.a.c.b bVar) {
            if (bVar == null) {
                return 3000L;
            }
            return d.o.a.d.n.e.c(bVar).b("app_link_opt_back_time_limit", 3) * 1000;
        }

        public static long k(d.o.a.b.a.c.b bVar) {
            return d.o.a.d.n.e.c(bVar).c("app_link_check_timeout", 300000L);
        }

        public static int l(d.o.a.b.a.c.b bVar) {
            return d.o.a.d.n.e.c(bVar).b("app_link_check_delay", 1);
        }

        public static int m(d.o.a.b.a.c.b bVar) {
            return d.o.a.d.n.e.c(bVar).b("app_link_check_count", 10);
        }
    }

    /* loaded from: classes7.dex */
    public interface h {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public interface i {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public class j {
        public static boolean a(@NonNull d.o.a.b.a.c.a aVar) {
            return d.o.a.e.a.h.c.f() && Build.VERSION.SDK_INT < 29 && n.u() != null && n.u().a() && d.o.a.d.n.e.c(aVar).m("invoke_app_form_background_switch") == 1 && aVar.q();
        }
    }

    /* loaded from: classes7.dex */
    public class k {
        public static boolean a(Uri uri) {
            if (uri == null) {
                return false;
            }
            String scheme = uri.getScheme();
            if (TextUtils.isEmpty(scheme)) {
                return false;
            }
            return "market".equals(scheme) || "appmarket".equals(scheme) || "oaps".equals(scheme) || "oppomarket".equals(scheme) || "mimarket".equals(scheme) || "vivomarket".equals(scheme) || "vivoMarket".equals(scheme) || "gomarket".equals(scheme) || "goMarket".equals(scheme) || "mstore".equals(scheme) || "samsungapps".equals(scheme);
        }

        public static String b(@NonNull Uri uri) {
            return d.o.a.d.n.k.m(uri.getQueryParameter("id"), uri.getQueryParameter("packagename"), uri.getQueryParameter("pkg"), uri.getQueryParameter("package_name"), uri.getQueryParameter(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
        }
    }

    public static d.o.a.a.a.c.b d(boolean z) {
        a.b bVar = new a.b();
        bVar.b(0);
        bVar.d(true);
        bVar.i(false);
        bVar.k(false);
        if (z) {
            bVar.g(2);
        } else {
            bVar.g(0);
        }
        return bVar.e();
    }

    public static g e() {
        if (f66666c == null) {
            synchronized (g.class) {
                if (f66666c == null) {
                    f66666c = new g();
                }
            }
        }
        return f66666c;
    }

    public static d.o.a.a.a.c.b h() {
        return d(false);
    }

    public static d.o.a.a.a.c.c j() {
        b.C1820b c1820b = new b.C1820b();
        c1820b.b("landing_h5_download_ad_button");
        c1820b.f("landing_h5_download_ad_button");
        c1820b.i("click_start_detail");
        c1820b.l("click_pause_detail");
        c1820b.n("click_continue_detail");
        c1820b.p("click_install_detail");
        c1820b.r("click_open_detail");
        c1820b.t("storage_deny_detail");
        c1820b.a(1);
        c1820b.c(false);
        c1820b.g(true);
        c1820b.j(false);
        return c1820b.d();
    }

    @Override // d.o.a.b.a.d
    public boolean a(Context context, Uri uri, d.o.a.a.a.c.d dVar, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar) {
        d.o.a.a.a.c.b bVar2 = bVar;
        if (k.a(uri) && n.s().optInt("disable_market") != 1) {
            Context a2 = context == null ? n.a() : context;
            String b2 = k.b(uri);
            if (dVar == null) {
                return d.o.a.d.n.h.c(a2, b2).a() == 5;
            }
            if (bVar2 != null) {
                bVar2.a(2);
            } else if ((dVar instanceof d.o.a.b.a.a.c) && TextUtils.isEmpty(dVar.a())) {
                ((d.o.a.b.a.a.c) dVar).e(uri.toString());
                bVar2 = d(true);
            } else if (dVar.a().startsWith("market")) {
                bVar2 = d(true);
            } else {
                bVar2 = h();
            }
            c.f fVar = new c.f(dVar.d(), dVar, (d.o.a.a.a.c.c) d.o.a.d.n.k.k(cVar, j()), bVar2);
            if (!TextUtils.isEmpty(b2) && (dVar instanceof d.o.a.b.a.a.c)) {
                ((d.o.a.b.a.a.c) dVar).d(b2);
            }
            if (d.o.a.d.n.k.w(dVar) && d.o.a.e.b.j.a.r().m("app_link_opt") == 1 && b.g(fVar)) {
                return true;
            }
            JSONObject jSONObject = new JSONObject();
            d.o.a.d.n.k.r(jSONObject, "market_url", uri.toString());
            j.c.a().t("market_click_open", jSONObject, fVar);
            c.h b3 = d.o.a.d.n.h.b(a2, fVar, b2);
            String m = d.o.a.d.n.k.m(b3.c(), "open_market");
            if (b3.a() == 5) {
                b.e(m, jSONObject, fVar);
                return true;
            }
            d.o.a.d.n.k.r(jSONObject, "error_code", Integer.valueOf(b3.b()));
            j.c.a().t("market_open_failed", jSONObject, fVar);
            return false;
        }
        return false;
    }

    @Override // d.o.a.b.a.d
    public boolean b(Context context, long j2, String str, d.o.a.a.a.c.e eVar, int i2) {
        d.o.a.b.a.c.b u = c.g.e().u(j2);
        if (u != null) {
            this.f66667a.d(context, i2, eVar, u.f0());
            return true;
        }
        d.o.a.a.a.c.d a2 = c.g.e().a(j2);
        if (a2 != null) {
            this.f66667a.d(context, i2, eVar, a2);
            return true;
        }
        return false;
    }

    @Override // d.o.a.b.a.d
    public Dialog c(Context context, String str, boolean z, @NonNull d.o.a.a.a.c.d dVar, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar, d.o.a.a.a.c.e eVar, int i2) {
        if (i(dVar.d())) {
            g(dVar.d());
            return null;
        } else if (context == null || TextUtils.isEmpty(dVar.a())) {
            return null;
        } else {
            this.f66667a.d(context, i2, eVar, dVar);
            boolean z2 = true;
            d.o.a.a.a.c.c cVar2 = (d.o.a.a.a.c.c) d.o.a.d.n.k.k(cVar, j());
            d.o.a.a.a.c.b bVar2 = (d.o.a.a.a.c.b) d.o.a.d.n.k.k(bVar, h());
            cVar2.a(1);
            boolean z3 = (n.s().optInt("disable_lp_dialog", 0) == 1) | z;
            if (!bVar2.e() || !d.o.a.d.f.f.b.a().e(dVar)) {
                z2 = z3;
            }
            if (z2) {
                this.f66667a.g(dVar.a(), dVar.d(), 2, cVar2, bVar2);
                return null;
            }
            String str2 = f66665b;
            d.o.a.d.n.j.a(str2, "tryStartDownload show dialog appName:" + dVar.a(), null);
            d.o.a.a.a.a.k n = n.n();
            c.b bVar3 = new c.b(context);
            bVar3.e(dVar.h());
            bVar3.h("确认要下载此应用吗？");
            bVar3.j("确认");
            bVar3.l("取消");
            bVar3.d(new a(dVar, cVar2, bVar2));
            bVar3.b(0);
            Dialog b2 = n.b(bVar3.g());
            j.c.a().m("landing_download_dialog_show", dVar, cVar2, bVar2);
            return b2;
        }
    }

    public void g(long j2) {
        d.o.a.a.a.c.d a2 = c.g.e().a(j2);
        d.o.a.b.a.c.b u = c.g.e().u(j2);
        if (a2 == null && u != null) {
            a2 = u.f0();
        }
        if (a2 == null) {
            return;
        }
        d.o.a.a.a.c.c n = c.g.e().n(j2);
        d.o.a.a.a.c.b s = c.g.e().s(j2);
        if (n instanceof d.o.a.a.a.c.h) {
            n = null;
        }
        if (s instanceof d.o.a.a.a.c.g) {
            s = null;
        }
        if (u == null) {
            if (n == null) {
                n = j();
            }
            if (s == null) {
                s = h();
            }
        } else {
            if (n == null) {
                b.C1820b c1820b = new b.C1820b();
                c1820b.b(u.j());
                c1820b.v(u.i());
                c1820b.j(u.m());
                c1820b.c(false);
                c1820b.i("click_start_detail");
                c1820b.l("click_pause_detail");
                c1820b.n("click_continue_detail");
                c1820b.p("click_install_detail");
                c1820b.t("storage_deny_detail");
                n = c1820b.d();
            }
            if (s == null) {
                s = u.h0();
            }
        }
        d.o.a.a.a.c.c cVar = n;
        cVar.a(1);
        this.f66667a.g(a2.a(), j2, 2, cVar, s);
    }

    public boolean i(long j2) {
        return (c.g.e().a(j2) == null && c.g.e().u(j2) == null) ? false : true;
    }
}
