package d.a.m0.a.j1;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.k;
import d.a.m0.a.v2.e0;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.r0;
import d.a.m0.k.n;
import d.a.m0.k.o;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46845e = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public n f46846a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAppMenuHeaderView f46847b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.a.h0.g.d f46848c;

    /* renamed from: d  reason: collision with root package name */
    public Context f46849d;

    /* renamed from: d.a.m0.a.j1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0781a implements d.a.m0.k.e {
        public C0781a() {
        }

        @Override // d.a.m0.k.e
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
            a.this.f46846a.d();
            a.this.A();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements SwanAppMenuHeaderView.e {
        public c() {
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            a.this.f46846a.d();
            a.this.u();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements SwanAppMenuHeaderView.f {
        public d() {
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.f
        public boolean onLongClick(View view) {
            a.this.f46846a.d();
            return a.this.w();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.m0.a.q0.b.b {
        public e() {
        }

        @Override // d.a.m0.a.q0.b.b
        public void a() {
            d.a.m0.a.z1.b.f.e f2 = d.a.m0.a.z1.b.f.e.f(a.this.f46849d, d.a.m0.a.h.swanapp_tip_net_unavailable);
            f2.l(2);
            f2.F();
        }

        @Override // d.a.m0.a.q0.b.b
        public void b() {
            d.a.m0.a.z1.b.f.e f2 = d.a.m0.a.z1.b.f.e.f(a.this.f46849d.getApplicationContext(), d.a.m0.a.h.aiapps_cancel_fav_fail);
            f2.l(2);
            f2.F();
        }

        @Override // d.a.m0.a.q0.b.b
        public void c() {
            d.a.m0.a.z1.b.f.e f2 = d.a.m0.a.z1.b.f.e.f(a.this.f46849d.getApplicationContext(), d.a.m0.a.h.aiapps_cancel_fav_success);
            f2.l(2);
            f2.F();
            a.this.C();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.m0.a.q0.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46855a;

        public f(String str) {
            this.f46855a = str;
        }

        @Override // d.a.m0.a.q0.b.a
        public void a() {
            d.a.m0.a.z1.b.f.e f2 = d.a.m0.a.z1.b.f.e.f(a.this.f46849d, d.a.m0.a.h.swanapp_tip_net_unavailable);
            f2.l(2);
            f2.F();
        }

        @Override // d.a.m0.a.q0.b.a
        public void b() {
            d.a.m0.a.z1.b.f.e f2 = d.a.m0.a.z1.b.f.e.f(a.this.f46849d.getApplicationContext(), d.a.m0.a.h.aiapps_fav_fail);
            f2.l(2);
            f2.F();
        }

        @Override // d.a.m0.a.q0.b.a
        public void c() {
            d.a.m0.a.j0.b.a.t();
            if (!a.k(a.this.f46848c.h())) {
                d.a.m0.a.z1.b.f.e g2 = d.a.m0.a.z1.b.f.e.g(a.this.f46849d, d.a.m0.a.c1.a.e0().f(a.this.f46849d));
                g2.l(2);
                g2.p(2);
                g2.F();
                a.this.C();
                return;
            }
            a.p("addmyswan", this.f46855a);
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements d.a.m0.a.q0.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f46857a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f46858b;

        public g(Activity activity, h hVar) {
            this.f46857a = activity;
            this.f46858b = hVar;
        }

        @Override // d.a.m0.a.q0.b.a
        public void a() {
            d.a.m0.a.z1.b.f.e f2 = d.a.m0.a.z1.b.f.e.f(this.f46857a.getApplicationContext(), d.a.m0.a.h.swanapp_tip_net_unavailable);
            f2.l(2);
            f2.F();
            h hVar = this.f46858b;
            if (hVar != null) {
                hVar.onFail();
            }
        }

        @Override // d.a.m0.a.q0.b.a
        public void b() {
            d.a.m0.a.z1.b.f.e f2 = d.a.m0.a.z1.b.f.e.f(this.f46857a.getApplicationContext(), d.a.m0.a.h.aiapps_fav_fail);
            f2.l(2);
            f2.F();
            h hVar = this.f46858b;
            if (hVar != null) {
                hVar.onFail();
            }
        }

        @Override // d.a.m0.a.q0.b.a
        public void c() {
            d.a.m0.a.j0.b.a.t();
            if (a.k(this.f46857a)) {
                h hVar = this.f46858b;
                if (hVar != null) {
                    hVar.onSuccess();
                    return;
                }
                return;
            }
            Context applicationContext = this.f46857a.getApplicationContext();
            d.a.m0.a.z1.b.f.e g2 = d.a.m0.a.z1.b.f.e.g(applicationContext, d.a.m0.a.c1.a.e0().f(applicationContext));
            g2.l(2);
            g2.p(2);
            g2.F();
            h hVar2 = this.f46858b;
            if (hVar2 != null) {
                hVar2.onSuccess();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface h {
        void onFail();

        void onSuccess();
    }

    public a(n nVar, d.a.m0.a.h0.g.d dVar) {
        this(nVar, dVar, null);
    }

    public static void h(@NonNull Activity activity, h hVar) {
        String D = d.a.m0.a.a2.d.g().r().D();
        if (TextUtils.isEmpty(D) && hVar != null) {
            hVar.onFail();
        }
        if (!d.a.m0.a.j0.b.a.n(D)) {
            SwanFavorDataManager.h().b(D, new g(activity, hVar));
        } else if (hVar != null) {
            hVar.onSuccess();
        }
    }

    public static void j(Activity activity) {
        if (activity == null) {
            return;
        }
        if (f46845e) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean a2 = d.a.m0.a.c1.a.H().a();
        d.a.m0.a.c1.a.H().e(!a2);
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).onNightModeCoverChanged(d.a.m0.a.c1.a.H().a(), true);
        } else if (activity instanceof SwanAppErrorActivity) {
            ((SwanAppErrorActivity) activity).updateCurrentNightMode();
        }
        if (a2) {
            d.a.m0.a.z1.b.f.e f2 = d.a.m0.a.z1.b.f.e.f(activity.getApplicationContext(), d.a.m0.a.h.aiapps_browser_menu_toast_day_mode);
            f2.m(d.a.m0.a.e.aiapps_day_mode_toast_icon);
            f2.l(2);
            f2.A();
        } else {
            d.a.m0.a.z1.b.f.e f3 = d.a.m0.a.z1.b.f.e.f(activity.getApplicationContext(), d.a.m0.a.h.aiapps_browser_menu_toast_night_mode);
            f3.m(d.a.m0.a.e.aiapps_night_mode_toast_icon);
            f3.l(2);
            f3.A();
        }
        o("daynightmode");
    }

    public static boolean k(Activity activity) {
        return d.a.m0.a.c1.a.e0().a(activity);
    }

    public static void o(String str) {
        p(str, null);
    }

    public static void p(String str, String str2) {
        q(str, str2, null);
    }

    public static void q(String str, String str2, String str3) {
        r(str, str2, str3, null, null);
    }

    public static void r(String str, String str2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
        fVar.f46973e = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f46975g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f46970b = str3;
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            fVar.a(str4, str5);
        }
        SwanAppActivity activity = d.a.m0.a.g1.f.V().getActivity();
        if (activity != null) {
            activity.doUBCEventStatistic(fVar);
        }
    }

    public static void t(Activity activity) {
        if (activity instanceof SwanAppErrorActivity) {
            SwanLauncher.j().m(((SwanAppErrorActivity) activity).getLaunchInfo().C());
            if (activity != null) {
                d.a.m0.a.v2.f.j(activity);
            }
        }
    }

    public final void A() {
        if (f46845e) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        d.a.m0.a.h0.g.g W = d.a.m0.a.g1.f.V().W();
        if (W == null) {
            d.a.m0.a.z1.b.f.e.f(this.f46849d, d.a.m0.a.h.aiapps_open_fragment_failed_toast).F();
            return;
        }
        g.b i2 = W.i("navigateTo");
        i2.n(d.a.m0.a.h0.g.g.f45860g, d.a.m0.a.h0.g.g.f45862i);
        i2.k("about", null).a();
        o("about");
    }

    public final void B() {
        if (f46845e) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        d.a.m0.a.h0.g.g J1 = this.f46848c.J1();
        if (J1 == null) {
            d.a.m0.a.z1.b.f.e.f(this.f46849d, d.a.m0.a.h.aiapps_open_fragment_failed_toast).F();
            return;
        }
        g.b i2 = J1.i("navigateTo");
        i2.n(d.a.m0.a.h0.g.g.f45860g, d.a.m0.a.h0.g.g.f45862i);
        i2.k("authority", null).a();
        o("permission");
    }

    public final void C() {
        this.f46847b.setAttentionBtnStates(d.a.m0.a.j0.b.a.n(d.a.m0.a.a2.d.g().getAppId()));
    }

    public final boolean D() {
        r0.b(this.f46849d).c(d.a.m0.a.l1.b.c(q0.n()));
        return true;
    }

    public final void i() {
        b.a launchInfo;
        if (d.a.m0.a.u1.a.a.G()) {
            if (f46845e) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            d.a.m0.a.z1.b.f.e.f(this.f46849d.getApplicationContext(), d.a.m0.a.h.aiapps_debug_forbid_shortcut).F();
            return;
        }
        if (f46845e) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (d.a.m0.a.a2.e.Q() != null) {
            launchInfo = d.a.m0.a.a2.e.Q().L();
        } else {
            launchInfo = ((SwanAppActivity) this.f46848c.h()).getLaunchInfo();
        }
        d.a.m0.a.f2.a.i(this.f46848c.q(), launchInfo);
        o("addshortcut");
    }

    public final void l(String str) {
        if (d.a.m0.a.u1.a.a.G()) {
            if (f46845e) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            d.a.m0.a.z1.b.f.e.f(this.f46849d.getApplicationContext(), d.a.m0.a.h.aiapps_debug_forbid_favor).F();
            return;
        }
        String f2 = q0.n().f();
        SwanFavorDataManager.h().b(str, new f(f2));
        p("addmyswan", f2);
    }

    public final void m(String str) {
        SwanFavorDataManager h2 = SwanFavorDataManager.h();
        e eVar = new e();
        d.a.m0.a.n0.l.c l = d.a.m0.a.n0.l.c.l();
        l.n(3);
        h2.c(str, eVar, l.k());
        o("deletemyswan");
    }

    public final void n() {
        this.f46848c.C2();
        o("share");
    }

    public final void s() {
        d.a.m0.a.h0.g.g J1 = this.f46848c.J1();
        if (J1 == null) {
            d.a.m0.a.z1.b.f.e.f(this.f46849d, d.a.m0.a.h.aiapps_open_fragment_failed_toast).F();
            return;
        }
        g.b i2 = J1.i("navigateTo");
        i2.n(d.a.m0.a.h0.g.g.f45860g, d.a.m0.a.h0.g.g.f45862i);
        i2.k("settings", null).a();
        o("set");
    }

    public final void u() {
        String D = d.a.m0.a.a2.d.g().r().D();
        if (TextUtils.isEmpty(D)) {
            return;
        }
        if (d.a.m0.a.j0.b.a.n(D)) {
            m(D);
        } else {
            l(D);
        }
    }

    public boolean v(o oVar) {
        if (this.f46848c == null || this.f46849d == null) {
            return false;
        }
        int c2 = oVar.c();
        if (c2 == 4) {
            n();
            return true;
        } else if (c2 == 5) {
            j(this.f46848c.h());
            return true;
        } else if (c2 == 35) {
            i();
            return true;
        } else if (c2 == 49) {
            s();
            return true;
        } else if (c2 == 42) {
            y();
            return true;
        } else if (c2 != 43) {
            switch (c2) {
                case 37:
                    B();
                    return true;
                case 38:
                    u();
                    return true;
                case 39:
                    x();
                    return true;
                default:
                    return d.a.m0.a.c1.a.G().h(oVar);
            }
        } else {
            q0.d();
            return true;
        }
    }

    public final boolean w() {
        String string;
        if (this.f46848c == null || this.f46849d == null) {
            return false;
        }
        if (D()) {
            string = this.f46849d.getString(d.a.m0.a.h.swanapp_write_to_clipborad_succ);
        } else {
            string = this.f46849d.getString(d.a.m0.a.h.swanapp_write_to_clipborad_fail);
        }
        d.a.m0.a.z1.b.f.e g2 = d.a.m0.a.z1.b.f.e.g(this.f46849d, string);
        g2.l(2);
        g2.F();
        return true;
    }

    public void x() {
        o("refresh");
        e0.a(d.a.m0.a.g1.f.V().getActivity());
        d.a.m0.a.e0.d.h("SwanAppMenuHelper", "restart");
    }

    public final void y() {
        if (f46845e) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        Context context = this.f46849d;
        if (context == null) {
            return;
        }
        e0.a((SwanAppActivity) context);
    }

    public void z() {
        d.a.m0.a.a2.e r;
        if (this.f46846a == null || this.f46848c == null || this.f46849d == null || (r = d.a.m0.a.a2.d.g().r()) == null) {
            return;
        }
        r.x();
        this.f46846a.l(new C0781a());
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.f46847b;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setOnMenuHeaderClickListener(new b());
            this.f46847b.setAttentionBtnShow(true);
            this.f46847b.setOnAttentionBtnClickListener(new c());
            if (r.m0()) {
                return;
            }
            this.f46847b.setOnMenuHeaderLongClickListener(new d());
        }
    }

    public a(n nVar, d.a.m0.a.h0.g.d dVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.f46846a = nVar;
        this.f46847b = swanAppMenuHeaderView;
        this.f46848c = dVar;
        if (dVar != null) {
            this.f46849d = dVar.q();
        }
    }
}
