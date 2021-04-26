package d.a.h0.a.c1;

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
import d.a.h0.a.c1.c.c;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.l0;
import d.a.h0.a.y0.e.b;
import d.a.h0.i.n;
import d.a.h0.i.o;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f41737e = d.a.h0.a.k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public n f41738a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAppMenuHeaderView f41739b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.a.e0.l.c f41740c;

    /* renamed from: d  reason: collision with root package name */
    public Context f41741d;

    /* renamed from: d.a.h0.a.c1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0601a implements d.a.h0.i.e {
        public C0601a() {
        }

        @Override // d.a.h0.i.e
        public boolean b(View view, o oVar) {
            return a.this.v(oVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SwanAppMenuHeaderView.e {
        public b() {
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            a.this.f41738a.e();
            a.this.B();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements SwanAppMenuHeaderView.e {
        public c() {
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            a.this.f41738a.e();
            a.this.u();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements SwanAppMenuHeaderView.f {
        public d() {
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.f
        public boolean onLongClick(View view) {
            a.this.f41738a.e();
            return a.this.w();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements c.d {
        public e() {
        }

        @Override // d.a.h0.a.c1.c.c.d
        public void a(int i2) {
            d.a.h0.a.p.d.b S2;
            NgWebView ngWebView;
            if (!(a.this.f41740c instanceof d.a.h0.a.e0.l.e) || (S2 = ((d.a.h0.a.e0.l.e) a.this.f41740c).S2()) == null) {
                return;
            }
            if (S2.l() != null) {
                ngWebView = (NgWebView) S2.l().s();
            } else {
                ngWebView = (NgWebView) S2.s();
            }
            if (!d.a.h0.a.c1.c.b.e()) {
                ngWebView.getSettings().setTextZoom(d.a.h0.a.c1.c.b.a(i2));
            }
            d.a.h0.a.c1.c.b.f(i2);
            d.a.h0.a.c1.c.a.a(Integer.valueOf(i2 + 1));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements PopupWindow.b {
        public f(a aVar) {
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            a.s("fontSizeChanged", null, null, "fontSizeLevel", String.valueOf(d.a.h0.a.c1.c.b.c()));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.h0.a.m0.b.b {
        public g() {
        }

        @Override // d.a.h0.a.m0.b.b
        public void a() {
            d.a.h0.a.q1.b.f.d e2 = d.a.h0.a.q1.b.f.d.e(a.this.f41741d.getApplicationContext(), d.a.h0.a.h.aiapps_cancel_fav_fail);
            e2.k(2);
            e2.C();
        }

        @Override // d.a.h0.a.m0.b.b
        public void b() {
            d.a.h0.a.q1.b.f.d e2 = d.a.h0.a.q1.b.f.d.e(a.this.f41741d.getApplicationContext(), d.a.h0.a.h.aiapps_cancel_fav_success);
            e2.k(2);
            e2.x();
            a.this.E();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.a.h0.a.m0.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41748a;

        public h(String str) {
            this.f41748a = str;
        }

        @Override // d.a.h0.a.m0.b.a
        public void a() {
            d.a.h0.a.q1.b.f.d e2 = d.a.h0.a.q1.b.f.d.e(a.this.f41741d.getApplicationContext(), d.a.h0.a.h.aiapps_fav_fail);
            e2.k(2);
            e2.C();
        }

        @Override // d.a.h0.a.m0.b.a
        public void b() {
            d.a.h0.a.g0.c.a.t();
            if (!a.l(a.this.f41740c.f())) {
                d.a.h0.a.q1.b.f.d e2 = d.a.h0.a.q1.b.f.d.e(a.this.f41741d.getApplicationContext(), d.a.h0.a.h.aiapps_fav_success);
                e2.k(2);
                e2.o(2);
                e2.C();
                a.this.E();
                return;
            }
            a.q("addmyswan", this.f41748a);
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements d.a.h0.a.m0.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f41750a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f41751b;

        public i(Activity activity, j jVar) {
            this.f41750a = activity;
            this.f41751b = jVar;
        }

        @Override // d.a.h0.a.m0.b.a
        public void a() {
            d.a.h0.a.q1.b.f.d e2 = d.a.h0.a.q1.b.f.d.e(this.f41750a.getApplicationContext(), d.a.h0.a.h.aiapps_fav_fail);
            e2.k(2);
            e2.C();
            j jVar = this.f41751b;
            if (jVar != null) {
                jVar.onFail();
            }
        }

        @Override // d.a.h0.a.m0.b.a
        public void b() {
            d.a.h0.a.g0.c.a.t();
            if (a.l(this.f41750a)) {
                j jVar = this.f41751b;
                if (jVar != null) {
                    jVar.onSuccess();
                    return;
                }
                return;
            }
            d.a.h0.a.q1.b.f.d e2 = d.a.h0.a.q1.b.f.d.e(this.f41750a.getApplicationContext(), d.a.h0.a.h.aiapps_fav_success);
            e2.k(2);
            e2.o(2);
            e2.C();
            j jVar2 = this.f41751b;
            if (jVar2 != null) {
                jVar2.onSuccess();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes3.dex */
    public static final class k {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f41752a = d.a.h0.a.w0.a.N().g();
    }

    public a(n nVar, d.a.h0.a.e0.l.c cVar) {
        this(nVar, cVar, null);
    }

    public static void i(@NonNull Activity activity, j jVar) {
        String appId = d.a.h0.a.r1.d.e().getAppId();
        if (TextUtils.isEmpty(appId) && jVar != null) {
            jVar.onFail();
        }
        if (!d.a.h0.a.g0.c.a.n(appId)) {
            SwanFavorDataManager.i().b(appId, 1, new i(activity, jVar));
        } else if (jVar != null) {
            jVar.onSuccess();
        }
    }

    public static boolean l(Activity activity) {
        return d.a.h0.a.w0.a.T().a(activity);
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
        d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
        fVar.f45414d = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f45416f = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f45412b = str3;
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            fVar.a(str4, str5);
        }
        SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
        if (activity != null) {
            activity.doUBCEventStatistic(fVar);
        }
    }

    public final void A() {
        this.f41738a.e();
        d.a.h0.a.c1.c.c cVar = new d.a.h0.a.c1.c.c(this.f41741d, this.f41740c.C1(), new d.a.h0.a.j2.g.b());
        cVar.a0();
        cVar.Y(new e());
        cVar.G(new f(this));
        p("typeface");
    }

    public final void B() {
        if (f41737e) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            d.a.h0.a.q1.b.f.d.e(this.f41741d, d.a.h0.a.h.aiapps_open_fragment_failed_toast).C();
            return;
        }
        f.b i2 = W.i("navigateTo");
        i2.n(d.a.h0.a.e0.l.f.f42031g, d.a.h0.a.e0.l.f.f42033i);
        i2.k("about", null).a();
        p("about");
    }

    public final void C() {
        if (f41737e) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        d.a.h0.a.e0.l.f E1 = this.f41740c.E1();
        if (E1 == null) {
            d.a.h0.a.q1.b.f.d.e(this.f41741d, d.a.h0.a.h.aiapps_open_fragment_failed_toast).C();
            return;
        }
        f.b i2 = E1.i("navigateTo");
        i2.n(d.a.h0.a.e0.l.f.f42031g, d.a.h0.a.e0.l.f.f42033i);
        i2.k("authority", null).a();
        p("permission");
    }

    public final void D() {
        d.a.h0.a.w0.a.S().a(null);
    }

    public final void E() {
        this.f41739b.setAttentionBtnStates(d.a.h0.a.g0.c.a.n(d.a.h0.a.r1.d.e().getAppId()));
    }

    public final boolean F() {
        l0.b(this.f41741d).c(d.a.h0.a.e1.b.a(k0.n()));
        return true;
    }

    public final void j() {
        b.a launchInfo;
        if (d.a.h0.a.m1.a.a.C()) {
            if (f41737e) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            d.a.h0.a.q1.b.f.d.e(this.f41741d.getApplicationContext(), d.a.h0.a.h.aiapps_debug_forbid_shortcut).C();
            return;
        }
        if (f41737e) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (d.a.h0.a.r1.e.O() != null) {
            launchInfo = d.a.h0.a.r1.e.O().J();
        } else {
            launchInfo = ((SwanAppActivity) this.f41740c.f()).getLaunchInfo();
        }
        d.a.h0.a.w1.a.h(this.f41740c.m(), launchInfo);
        p("addshortcut");
    }

    public final void k() {
        if (f41737e) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean a2 = d.a.h0.a.w0.a.z().a();
        d.a.h0.a.w0.a.z().e(!a2);
        if (this.f41740c.f() != null && (this.f41740c.f() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.f41740c.f()).onNightModeCoverChanged(d.a.h0.a.w0.a.z().a(), true);
        }
        if (a2) {
            d.a.h0.a.q1.b.f.d e2 = d.a.h0.a.q1.b.f.d.e(this.f41741d.getApplicationContext(), d.a.h0.a.h.aiapps_browser_menu_toast_day_mode);
            e2.l(d.a.h0.a.e.aiapps_day_mode_toast_icon);
            e2.k(2);
            e2.x();
        } else {
            d.a.h0.a.q1.b.f.d e3 = d.a.h0.a.q1.b.f.d.e(this.f41741d.getApplicationContext(), d.a.h0.a.h.aiapps_browser_menu_toast_night_mode);
            e3.l(d.a.h0.a.e.aiapps_night_mode_toast_icon);
            e3.k(2);
            e3.x();
        }
        p("daynightmode");
    }

    public final void m(String str) {
        if (d.a.h0.a.m1.a.a.C()) {
            if (f41737e) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            d.a.h0.a.q1.b.f.d.e(this.f41741d.getApplicationContext(), d.a.h0.a.h.aiapps_debug_forbid_favor).C();
            return;
        }
        String d2 = k0.n().d();
        SwanFavorDataManager.i().b(str, 1, new h(d2));
        q("addmyswan", d2);
    }

    public final void n(String str) {
        SwanFavorDataManager i2 = SwanFavorDataManager.i();
        g gVar = new g();
        d.a.h0.a.j0.j.c k2 = d.a.h0.a.j0.j.c.k();
        k2.m(3);
        i2.d(str, gVar, k2.j());
        p("deletemyswan");
    }

    public final void o() {
        this.f41740c.w2();
        p("share");
    }

    public final void t() {
        d.a.h0.a.e0.l.f E1 = this.f41740c.E1();
        if (E1 == null) {
            d.a.h0.a.q1.b.f.d.e(this.f41741d, d.a.h0.a.h.aiapps_open_fragment_failed_toast).C();
            return;
        }
        f.b i2 = E1.i("navigateTo");
        i2.n(d.a.h0.a.e0.l.f.f42031g, d.a.h0.a.e0.l.f.f42033i);
        i2.k("settings", null).a();
        p("set");
    }

    public final void u() {
        String appId = d.a.h0.a.r1.d.e().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return;
        }
        if (d.a.h0.a.g0.c.a.n(appId)) {
            n(appId);
        } else {
            m(appId);
        }
    }

    public final boolean v(o oVar) {
        if (this.f41740c == null || this.f41741d == null) {
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
                    return d.a.h0.a.w0.a.y().d(oVar);
            }
        } else {
            A();
            return true;
        }
    }

    public final boolean w() {
        String string;
        if (this.f41740c == null || this.f41741d == null) {
            return false;
        }
        if (F()) {
            string = this.f41741d.getString(d.a.h0.a.h.swanapp_write_to_clipborad_succ);
        } else {
            string = this.f41741d.getString(d.a.h0.a.h.swanapp_write_to_clipborad_fail);
        }
        d.a.h0.a.q1.b.f.d f2 = d.a.h0.a.q1.b.f.d.f(this.f41741d, string);
        f2.k(2);
        f2.C();
        return true;
    }

    public void x() {
        p("refresh");
        d.a.h0.g.i0.a.a(d.a.h0.a.z0.f.V().getActivity());
        d.a.h0.a.c0.c.h("SwanAppMenuHelper", "restart");
    }

    public final void y() {
        if (f41737e) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        Context context = this.f41741d;
        if (context == null) {
            return;
        }
        d.a.h0.g.i0.a.a((SwanAppActivity) context);
    }

    public void z() {
        d.a.h0.a.r1.e O;
        if (this.f41738a == null || this.f41740c == null || this.f41741d == null || (O = d.a.h0.a.r1.e.O()) == null) {
            return;
        }
        this.f41738a.m(new C0601a());
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.f41739b;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setOnMenuHeaderClickListener(new b());
            if (k.f41752a) {
                this.f41739b.setAttentionBtnShow(true);
                this.f41739b.setOnAttentionBtnClickListener(new c());
            }
            if (O.i0()) {
                return;
            }
            this.f41739b.setOnMenuHeaderLongClickListener(new d());
        }
    }

    public a(n nVar, d.a.h0.a.e0.l.c cVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.f41738a = nVar;
        this.f41739b = swanAppMenuHeaderView;
        this.f41740c = cVar;
        if (cVar != null) {
            this.f41741d = cVar.m();
        }
        D();
    }
}
