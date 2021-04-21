package d.b.h0.a.c1;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.menu.PopupWindow;
import d.b.h0.a.c1.c.c;
import d.b.h0.a.e0.l.f;
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.l0;
import d.b.h0.a.y0.e.b;
import d.b.h0.i.n;
import d.b.h0.i.o;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44447e = d.b.h0.a.k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public n f44448a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAppMenuHeaderView f44449b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.a.e0.l.c f44450c;

    /* renamed from: d  reason: collision with root package name */
    public Context f44451d;

    /* renamed from: d.b.h0.a.c1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0662a implements d.b.h0.i.e {
        public C0662a() {
        }

        @Override // d.b.h0.i.e
        public boolean b(View view, o oVar) {
            return a.this.v(oVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements SwanAppMenuHeaderView.e {
        public b() {
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            a.this.f44448a.e();
            a.this.B();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements SwanAppMenuHeaderView.e {
        public c() {
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            a.this.f44448a.e();
            a.this.u();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements SwanAppMenuHeaderView.f {
        public d() {
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.f
        public boolean onLongClick(View view) {
            a.this.f44448a.e();
            return a.this.w();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.d {
        public e() {
        }

        @Override // d.b.h0.a.c1.c.c.d
        public void a(int i) {
            d.b.h0.a.p.d.b T2;
            NgWebView ngWebView;
            if (!(a.this.f44450c instanceof d.b.h0.a.e0.l.e) || (T2 = ((d.b.h0.a.e0.l.e) a.this.f44450c).T2()) == null) {
                return;
            }
            if (T2.n() != null) {
                ngWebView = (NgWebView) T2.n().F();
            } else {
                ngWebView = (NgWebView) T2.F();
            }
            if (!d.b.h0.a.c1.c.b.e()) {
                ngWebView.getSettings().setTextZoom(d.b.h0.a.c1.c.b.a(i));
            }
            d.b.h0.a.c1.c.b.f(i);
            d.b.h0.a.c1.c.a.a(Integer.valueOf(i + 1));
        }
    }

    /* loaded from: classes2.dex */
    public class f implements PopupWindow.b {
        public f(a aVar) {
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            a.s("fontSizeChanged", null, null, "fontSizeLevel", String.valueOf(d.b.h0.a.c1.c.b.c()));
        }
    }

    /* loaded from: classes2.dex */
    public class g implements d.b.h0.a.m0.b.b {
        public g() {
        }

        @Override // d.b.h0.a.m0.b.b
        public void a() {
            d.b.h0.a.q1.b.f.d e2 = d.b.h0.a.q1.b.f.d.e(a.this.f44451d.getApplicationContext(), d.b.h0.a.h.aiapps_cancel_fav_fail);
            e2.k(2);
            e2.C();
        }

        @Override // d.b.h0.a.m0.b.b
        public void b() {
            d.b.h0.a.q1.b.f.d e2 = d.b.h0.a.q1.b.f.d.e(a.this.f44451d.getApplicationContext(), d.b.h0.a.h.aiapps_cancel_fav_success);
            e2.k(2);
            e2.x();
            a.this.E();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements d.b.h0.a.m0.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44458a;

        public h(String str) {
            this.f44458a = str;
        }

        @Override // d.b.h0.a.m0.b.a
        public void a() {
            d.b.h0.a.g0.c.a.t();
            if (!a.l(a.this.f44450c.f())) {
                d.b.h0.a.q1.b.f.d e2 = d.b.h0.a.q1.b.f.d.e(a.this.f44451d.getApplicationContext(), d.b.h0.a.h.aiapps_fav_success);
                e2.k(2);
                e2.o(2);
                e2.C();
                a.this.E();
                return;
            }
            a.q("addmyswan", this.f44458a);
        }

        @Override // d.b.h0.a.m0.b.a
        public void b() {
            d.b.h0.a.q1.b.f.d e2 = d.b.h0.a.q1.b.f.d.e(a.this.f44451d.getApplicationContext(), d.b.h0.a.h.aiapps_fav_fail);
            e2.k(2);
            e2.C();
        }
    }

    /* loaded from: classes2.dex */
    public static class i implements d.b.h0.a.m0.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f44460a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f44461b;

        public i(Activity activity, j jVar) {
            this.f44460a = activity;
            this.f44461b = jVar;
        }

        @Override // d.b.h0.a.m0.b.a
        public void a() {
            d.b.h0.a.g0.c.a.t();
            if (a.l(this.f44460a)) {
                j jVar = this.f44461b;
                if (jVar != null) {
                    jVar.onSuccess();
                    return;
                }
                return;
            }
            d.b.h0.a.q1.b.f.d e2 = d.b.h0.a.q1.b.f.d.e(this.f44460a.getApplicationContext(), d.b.h0.a.h.aiapps_fav_success);
            e2.k(2);
            e2.o(2);
            e2.C();
            j jVar2 = this.f44461b;
            if (jVar2 != null) {
                jVar2.onSuccess();
            }
        }

        @Override // d.b.h0.a.m0.b.a
        public void b() {
            d.b.h0.a.q1.b.f.d e2 = d.b.h0.a.q1.b.f.d.e(this.f44460a.getApplicationContext(), d.b.h0.a.h.aiapps_fav_fail);
            e2.k(2);
            e2.C();
            j jVar = this.f44461b;
            if (jVar != null) {
                jVar.onFail();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface j {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes2.dex */
    public static final class k {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f44462a = d.b.h0.a.w0.a.N().k();
    }

    public a(n nVar, d.b.h0.a.e0.l.c cVar) {
        this(nVar, cVar, null);
    }

    public static void i(@NonNull Activity activity, j jVar) {
        String appId = d.b.h0.a.r1.d.e().getAppId();
        if (TextUtils.isEmpty(appId) && jVar != null) {
            jVar.onFail();
        }
        if (!d.b.h0.a.g0.c.a.n(appId)) {
            SwanFavorDataManager.i().b(appId, 1, new i(activity, jVar));
        } else if (jVar != null) {
            jVar.onSuccess();
        }
    }

    public static boolean l(Activity activity) {
        return d.b.h0.a.w0.a.T().a(activity);
    }

    public static void p(String str) {
        q(str, null);
    }

    public static void q(String str, String str2) {
        r(str, str2, null);
    }

    public static void r(String str, String str2, String str3) {
        s(str, str2, str3, null, null);
    }

    public static void s(String str, String str2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.b.h0.a.z1.k.f fVar = new d.b.h0.a.z1.k.f();
        fVar.f47975d = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f47977f = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f47973b = str3;
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            fVar.a(str4, str5);
        }
        SwanAppActivity activity = d.b.h0.a.z0.f.V().getActivity();
        if (activity != null) {
            activity.doUBCEventStatistic(fVar);
        }
    }

    public final void A() {
        this.f44448a.e();
        d.b.h0.a.c1.c.c cVar = new d.b.h0.a.c1.c.c(this.f44451d, this.f44450c.D1(), new d.b.h0.a.j2.g.b());
        cVar.d0();
        cVar.b0(new e());
        cVar.G(new f(this));
        p("typeface");
    }

    public final void B() {
        if (f44447e) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
        if (W == null) {
            d.b.h0.a.q1.b.f.d.e(this.f44451d, d.b.h0.a.h.aiapps_open_fragment_failed_toast).C();
            return;
        }
        f.b i2 = W.i("navigateTo");
        i2.n(d.b.h0.a.e0.l.f.f44734g, d.b.h0.a.e0.l.f.i);
        i2.k("about", null).a();
        p("about");
    }

    public final void C() {
        if (f44447e) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        d.b.h0.a.e0.l.f F1 = this.f44450c.F1();
        if (F1 == null) {
            d.b.h0.a.q1.b.f.d.e(this.f44451d, d.b.h0.a.h.aiapps_open_fragment_failed_toast).C();
            return;
        }
        f.b i2 = F1.i("navigateTo");
        i2.n(d.b.h0.a.e0.l.f.f44734g, d.b.h0.a.e0.l.f.i);
        i2.k("authority", null).a();
        p("permission");
    }

    public final void D() {
        d.b.h0.a.w0.a.S().a(null);
    }

    public final void E() {
        this.f44449b.setAttentionBtnStates(d.b.h0.a.g0.c.a.n(d.b.h0.a.r1.d.e().getAppId()));
    }

    public final boolean F() {
        l0.b(this.f44451d).c(d.b.h0.a.e1.b.a(k0.n()));
        return true;
    }

    public final void j() {
        b.a launchInfo;
        if (d.b.h0.a.m1.a.a.C()) {
            if (f44447e) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            d.b.h0.a.q1.b.f.d.e(this.f44451d.getApplicationContext(), d.b.h0.a.h.aiapps_debug_forbid_shortcut).C();
            return;
        }
        if (f44447e) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (d.b.h0.a.r1.e.O() != null) {
            launchInfo = d.b.h0.a.r1.e.O().J();
        } else {
            launchInfo = ((SwanAppActivity) this.f44450c.f()).getLaunchInfo();
        }
        d.b.h0.a.w1.a.h(this.f44450c.l(), launchInfo);
        p("addshortcut");
    }

    public final void k() {
        if (f44447e) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean a2 = d.b.h0.a.w0.a.z().a();
        d.b.h0.a.w0.a.z().e(!a2);
        if (this.f44450c.f() != null && (this.f44450c.f() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.f44450c.f()).onNightModeCoverChanged(d.b.h0.a.w0.a.z().a(), true);
        }
        if (a2) {
            d.b.h0.a.q1.b.f.d e2 = d.b.h0.a.q1.b.f.d.e(this.f44451d.getApplicationContext(), d.b.h0.a.h.aiapps_browser_menu_toast_day_mode);
            e2.l(d.b.h0.a.e.aiapps_day_mode_toast_icon);
            e2.k(2);
            e2.x();
        } else {
            d.b.h0.a.q1.b.f.d e3 = d.b.h0.a.q1.b.f.d.e(this.f44451d.getApplicationContext(), d.b.h0.a.h.aiapps_browser_menu_toast_night_mode);
            e3.l(d.b.h0.a.e.aiapps_night_mode_toast_icon);
            e3.k(2);
            e3.x();
        }
        p("daynightmode");
    }

    public final void m(String str) {
        if (d.b.h0.a.m1.a.a.C()) {
            if (f44447e) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            d.b.h0.a.q1.b.f.d.e(this.f44451d.getApplicationContext(), d.b.h0.a.h.aiapps_debug_forbid_favor).C();
            return;
        }
        String d2 = k0.n().d();
        SwanFavorDataManager.i().b(str, 1, new h(d2));
        q("addmyswan", d2);
    }

    public final void n(String str) {
        SwanFavorDataManager i2 = SwanFavorDataManager.i();
        g gVar = new g();
        d.b.h0.a.j0.j.c k2 = d.b.h0.a.j0.j.c.k();
        k2.m(3);
        i2.d(str, gVar, k2.j());
        p("deletemyswan");
    }

    public final void o() {
        this.f44450c.x2();
        p("share");
    }

    public final void t() {
        d.b.h0.a.e0.l.f F1 = this.f44450c.F1();
        if (F1 == null) {
            d.b.h0.a.q1.b.f.d.e(this.f44451d, d.b.h0.a.h.aiapps_open_fragment_failed_toast).C();
            return;
        }
        f.b i2 = F1.i("navigateTo");
        i2.n(d.b.h0.a.e0.l.f.f44734g, d.b.h0.a.e0.l.f.i);
        i2.k("settings", null).a();
        p("set");
    }

    public final void u() {
        String appId = d.b.h0.a.r1.d.e().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return;
        }
        if (d.b.h0.a.g0.c.a.n(appId)) {
            n(appId);
        } else {
            m(appId);
        }
    }

    public final boolean v(o oVar) {
        if (this.f44450c == null || this.f44451d == null) {
            return false;
        }
        int c2 = oVar.c();
        if (c2 == 4) {
            o();
            return true;
        } else if (c2 == 5) {
            k();
            return true;
        } else if (c2 == 35) {
            j();
            return true;
        } else if (c2 == 42) {
            y();
            return true;
        } else if (c2 == 49) {
            t();
            return true;
        } else if (c2 != 50) {
            switch (c2) {
                case 37:
                    C();
                    return true;
                case 38:
                    u();
                    return true;
                case 39:
                    x();
                    return true;
                default:
                    return d.b.h0.a.w0.a.y().b(oVar);
            }
        } else {
            A();
            return true;
        }
    }

    public final boolean w() {
        String string;
        if (this.f44450c == null || this.f44451d == null) {
            return false;
        }
        if (F()) {
            string = this.f44451d.getString(d.b.h0.a.h.swanapp_write_to_clipborad_succ);
        } else {
            string = this.f44451d.getString(d.b.h0.a.h.swanapp_write_to_clipborad_fail);
        }
        d.b.h0.a.q1.b.f.d f2 = d.b.h0.a.q1.b.f.d.f(this.f44451d, string);
        f2.k(2);
        f2.C();
        return true;
    }

    public void x() {
        p("refresh");
        d.b.h0.g.i0.a.a(d.b.h0.a.z0.f.V().getActivity());
        d.b.h0.a.c0.c.h("SwanAppMenuHelper", "restart");
    }

    public final void y() {
        if (f44447e) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        Context context = this.f44451d;
        if (context == null) {
            return;
        }
        d.b.h0.g.i0.a.a((SwanAppActivity) context);
    }

    public void z() {
        d.b.h0.a.r1.e O;
        if (this.f44448a == null || this.f44450c == null || this.f44451d == null || (O = d.b.h0.a.r1.e.O()) == null) {
            return;
        }
        this.f44448a.m(new C0662a());
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.f44449b;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setOnMenuHeaderClickListener(new b());
            if (k.f44462a) {
                this.f44449b.setAttentionBtnShow(true);
                this.f44449b.setOnAttentionBtnClickListener(new c());
            }
            if (O.i0()) {
                return;
            }
            this.f44449b.setOnMenuHeaderLongClickListener(new d());
        }
    }

    public a(n nVar, d.b.h0.a.e0.l.c cVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.f44448a = nVar;
        this.f44449b = swanAppMenuHeaderView;
        this.f44450c = cVar;
        if (cVar != null) {
            this.f44451d = cVar.l();
        }
        D();
    }
}
