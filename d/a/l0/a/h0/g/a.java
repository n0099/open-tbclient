package d.a.l0.a.h0.g;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.h0.e.c;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.r1.j;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.r0;
import d.a.l0.a.y1.a;
import d.a.l0.a.y1.b;
import d.a.l0.a.z1.b.b.h;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.l0.a.h0.g.d implements View.OnClickListener {
    public static final boolean N0 = d.a.l0.a.k.f43199a;
    public d.a.l0.a.w2.a A0;
    public long[] B0 = new long[5];
    public String C0;
    public String D0;
    public String E0;
    public Button K0;
    public RecyclerView L0;
    public SwanAppWebPopWindow M0;
    public SwanAppRoundedImageView x0;
    public BdBaseImageView y0;
    public TextView z0;

    /* renamed from: d.a.l0.a.h0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0647a implements d.a.l0.d.i.a<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.k2.g.g f41976a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41977b;

        /* renamed from: d.a.l0.a.h0.g.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class DialogInterface$OnClickListenerC0648a implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0648a(C0647a c0647a) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                SwanAppActivity x = d.a.l0.a.a2.d.g().x();
                if (x != null && Build.VERSION.SDK_INT >= 21) {
                    x.finishAndRemoveTask();
                }
                System.exit(0);
            }
        }

        public C0647a(d.a.l0.a.k2.g.g gVar, String str) {
            this.f41976a = gVar;
            this.f41977b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.d.i.a
        /* renamed from: b */
        public void a(Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                this.f41976a.putInt(this.f41977b, 1);
            } else {
                this.f41976a.putInt(this.f41977b, 0);
            }
            h.a aVar = new h.a(a.this.f0);
            aVar.U(d.a.l0.a.h.swan_offline_perf_tool_tip);
            aVar.v(d.a.l0.a.h.swan_offline_perf_tool_message);
            aVar.n(new d.a.l0.a.w2.h.a());
            aVar.O(d.a.l0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0648a(this));
            aVar.X();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.k2.g.g f41979e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41980f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.d.i.a f41981g;

        /* renamed from: d.a.l0.a.h0.g.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0649a implements c.b {
            public C0649a() {
            }

            @Override // d.a.l0.a.h0.e.c.b
            public void a(boolean z, String str) {
                if (z) {
                    b.this.f41981g.a(Boolean.TRUE);
                    return;
                }
                Activity activity = a.this.f0;
                if (activity == null || activity.isDestroyed()) {
                    return;
                }
                d.a.l0.a.h0.e.c.b(a.this.f0, d.a.l0.a.h.swan_offline_perf_tool_tip, str);
            }
        }

        public b(d.a.l0.a.k2.g.g gVar, String str, d.a.l0.d.i.a aVar) {
            this.f41979e = gVar;
            this.f41980f = str;
            this.f41981g = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2 = this.f41979e.getInt(this.f41980f, -1);
            if (i2 == 1) {
                this.f41981g.a(Boolean.FALSE);
            } else if (i2 == 0) {
                this.f41981g.a(Boolean.TRUE);
            } else {
                d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
                if (Q == null) {
                    return;
                }
                d.a.l0.a.h0.e.c.a(Q, a.this.f0, new C0649a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnLongClickListener f41984e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f41985f;

        public c(View.OnLongClickListener onLongClickListener, View view) {
            this.f41984e = onLongClickListener;
            this.f41985f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.n2.l.b.a.d().g();
            this.f41984e.onLongClick(this.f41985f);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f41987e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f41988f;

        public d(Runnable runnable, long j) {
            this.f41987e = runnable;
            this.f41988f = j;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                view.postDelayed(this.f41987e, this.f41988f);
                return false;
            } else if (action == 1 || action == 3) {
                view.removeCallbacks(this.f41987e);
                return false;
            } else {
                return false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements b.InterfaceC0922b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppRelatedSwanListAdapter f41990a;

        /* renamed from: d.a.l0.a.h0.g.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0650a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.y1.a f41992e;

            public RunnableC0650a(d.a.l0.a.y1.a aVar) {
                this.f41992e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.L0.setVisibility(0);
                e.this.f41990a.d(this.f41992e);
            }
        }

        public e(SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter) {
            this.f41990a = swanAppRelatedSwanListAdapter;
        }

        @Override // d.a.l0.a.y1.b.InterfaceC0922b
        public void a(d.a.l0.a.y1.a aVar) {
            List<a.C0921a> list;
            if (aVar == null || (list = aVar.f45899a) == null || list.size() <= 0) {
                return;
            }
            q0.b0(new RunnableC0650a(aVar));
            SwanAppRelatedSwanListAdapter.c("aboutrelated", null, "show");
        }
    }

    /* loaded from: classes2.dex */
    public class f implements c.b {

        /* renamed from: d.a.l0.a.h0.g.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0651a implements d.a.l0.a.v2.e1.b<Boolean> {
            public C0651a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    d.a.l0.a.e0.a.d(a.this.q());
                } else {
                    d.a.l0.a.c1.b.h().a(a.this.f0, null);
                }
            }
        }

        public f() {
        }

        @Override // d.a.l0.a.h0.e.c.b
        public void a(boolean z, String str) {
            if (!z) {
                d.a.l0.a.h0.e.c.c(a.this.f0, str);
            } else if (d.a.l0.a.e0.a.a()) {
                d.a.l0.a.e0.a.d(a.this.q());
            } else {
                d.a.l0.a.c1.b.h().f(new C0651a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements d.a.l0.a.q0.b.b {
        public g() {
        }

        @Override // d.a.l0.a.q0.b.b
        public void a() {
            d.a.l0.a.z1.b.f.e f2 = d.a.l0.a.z1.b.f.e.f(a.this.q(), d.a.l0.a.h.swanapp_tip_net_unavailable);
            f2.l(2);
            f2.F();
        }

        @Override // d.a.l0.a.q0.b.b
        public void b() {
            d.a.l0.a.z1.b.f.e f2 = d.a.l0.a.z1.b.f.e.f(a.this.q(), d.a.l0.a.h.aiapps_cancel_fav_fail);
            f2.l(2);
            f2.F();
        }

        @Override // d.a.l0.a.q0.b.b
        public void c() {
            d.a.l0.a.z1.b.f.e f2 = d.a.l0.a.z1.b.f.e.f(a.this.q(), d.a.l0.a.h.aiapps_cancel_fav_success);
            f2.l(2);
            f2.F();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements d.a.l0.a.q0.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41997a;

        public h(String str) {
            this.f41997a = str;
        }

        @Override // d.a.l0.a.q0.b.a
        public void a() {
            d.a.l0.a.z1.b.f.e f2 = d.a.l0.a.z1.b.f.e.f(a.this.q(), d.a.l0.a.h.swanapp_tip_net_unavailable);
            f2.l(2);
            f2.F();
        }

        @Override // d.a.l0.a.q0.b.a
        public void b() {
            d.a.l0.a.z1.b.f.e f2 = d.a.l0.a.z1.b.f.e.f(a.this.q(), d.a.l0.a.h.aiapps_fav_fail);
            f2.l(2);
            f2.F();
        }

        @Override // d.a.l0.a.q0.b.a
        public void c() {
            d.a.l0.a.j0.b.a.t();
            if (d.a.l0.a.j1.a.k(a.this.h())) {
                d.a.l0.a.j1.a.p("aboutconcern", this.f41997a);
                return;
            }
            Context q = a.this.q();
            d.a.l0.a.z1.b.f.e g2 = d.a.l0.a.z1.b.f.e.g(q, d.a.l0.a.c1.a.e0().f(q));
            g2.l(2);
            g2.p(2);
            g2.F();
        }
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.k3();
        }
    }

    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public FullScreenFloatView f42000e;

        /* renamed from: d.a.l0.a.h0.g.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0652a implements d.a.l0.a.v2.e1.b<Boolean> {
            public C0652a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    d.a.l0.a.e0.a.c(a.this.q(), true);
                } else {
                    d.a.l0.a.c1.b.h().a(a.this.f0, null);
                }
            }
        }

        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f0 == null) {
                return;
            }
            if (a.N0) {
                if (d.a.l0.a.h0.o.e.a.k(null)) {
                    d.a.l0.a.e0.a.d(a.this.q());
                    return;
                }
                if (this.f42000e == null) {
                    this.f42000e = d.a.l0.a.g1.f.V().n(a.this.f0);
                }
                if (a.this.U1()) {
                    if (d.a.l0.a.e0.a.a()) {
                        d.a.l0.a.e0.a.c(a.this.q(), false);
                        return;
                    } else {
                        d.a.l0.a.c1.b.h().f(new C0652a());
                        return;
                    }
                }
                this.f42000e.setVisibility(this.f42000e.getVisibility() == 0 ? 8 : 0);
            } else if (a.this.U1()) {
                a.this.l3();
            } else {
                d.a.l0.a.e0.a.d(a.this.q());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public SwanAppPropertyWindow f42003e;

        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f42003e == null) {
                this.f42003e = d.a.l0.a.g1.f.V().L(a.this.f0);
            }
            this.f42003e.setVisibility(this.f42003e.getVisibility() == 0 ? 8 : 0);
        }
    }

    /* loaded from: classes2.dex */
    public class l implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f42005e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f42006f;

        /* renamed from: d.a.l0.a.h0.g.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class DialogInterface$OnClickListenerC0653a implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0653a(l lVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }

        public l(d.a.l0.a.f1.e.b bVar, d.a.l0.a.a2.e eVar) {
            this.f42005e = bVar;
            this.f42006f = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f0 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ENABLE V8: ");
            sb.append(d.a.l0.a.h0.u.g.N().h0());
            sb.append("\n");
            sb.append("APS VERSION: ");
            sb.append(TextUtils.isEmpty(this.f42005e.u1()) ? "" : this.f42005e.u1());
            sb.append("\n");
            sb.append("APPID VERSION: ");
            sb.append(d.a.l0.a.v.a.c(this.f42006f.f40749f));
            sb.append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), this.f42005e.g1());
            sb.append("小程序包大小: ");
            sb.append(TextUtils.isEmpty(formatFileSize) ? "" : formatFileSize);
            sb.append("(");
            sb.append(this.f42005e.g1());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append("\n");
            h.a aVar = new h.a(a.this.f0);
            aVar.V(a.this.f0.getResources().getString(d.a.l0.a.h.aiapps_show_ext_info_title));
            aVar.x(sb.toString());
            aVar.n(new d.a.l0.a.w2.h.a());
            aVar.m(false);
            aVar.O(d.a.l0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0653a(this));
            aVar.X();
        }
    }

    /* loaded from: classes2.dex */
    public class m implements View.OnClickListener {

        /* renamed from: d.a.l0.a.h0.g.a$m$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class DialogInterface$OnClickListenerC0654a implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0654a(m mVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }

        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f0 == null) {
                return;
            }
            String e2 = d.a.l0.a.m2.a.c().e(1);
            String string = a.this.f0.getResources().getString(d.a.l0.a.h.ai_games_debug_game_core_version);
            h.a aVar = new h.a(a.this.f0);
            aVar.V(string);
            aVar.x(e2);
            aVar.n(new d.a.l0.a.w2.h.a());
            aVar.m(false);
            aVar.O(d.a.l0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0654a(this));
            aVar.X();
        }
    }

    /* loaded from: classes2.dex */
    public class n implements View.OnClickListener {

        /* renamed from: d.a.l0.a.h0.g.a$n$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0655a extends j.a {

            /* renamed from: d.a.l0.a.h0.g.a$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC0656a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f42011e;

                public RunnableC0656a(String str) {
                    this.f42011e = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    h.a aVar = new h.a(a.this.f0);
                    aVar.U(d.a.l0.a.h.aiapps_debug_report_performance);
                    aVar.x(this.f42011e);
                    aVar.n(new d.a.l0.a.w2.h.a());
                    aVar.m(false);
                    aVar.O(d.a.l0.a.h.aiapps_confirm, null);
                    aVar.X();
                }
            }

            public C0655a() {
            }

            @Override // d.a.l0.a.r1.j.a
            public void c(String str) {
                a.this.f0.runOnUiThread(new RunnableC0656a(str));
            }
        }

        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f0 == null) {
                return;
            }
            d.a.l0.a.r1.j.e().g(new C0655a());
        }
    }

    /* loaded from: classes2.dex */
    public class o implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public d.a.l0.a.e0.h.a f42013e;

        /* renamed from: d.a.l0.a.h0.g.a$o$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class DialogInterface$OnClickListenerC0657a implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0657a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                d.a.l0.a.e0.h.a.g(1);
                o.this.f42013e = new d.a.l0.a.e0.h.a(d.a.l0.a.c1.a.b());
                o.this.f42013e.h();
            }
        }

        /* loaded from: classes2.dex */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                o.this.b();
                d.a.l0.a.e0.h.a.g(2);
                System.exit(0);
            }
        }

        /* loaded from: classes2.dex */
        public class c implements DialogInterface.OnClickListener {
            public c() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                o.this.b();
                d.a.l0.a.e0.h.a.g(0);
            }
        }

        public o() {
        }

        public final void b() {
            d.a.l0.a.e0.h.a aVar = this.f42013e;
            if (aVar != null) {
                aVar.i();
                this.f42013e = null;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.a aVar = new h.a(a.this.f0);
            aVar.U(d.a.l0.a.h.aiapps_debug_start_inspect);
            aVar.v(d.a.l0.a.h.aiapps_debug_inspect_message);
            aVar.n(new d.a.l0.a.w2.h.a());
            aVar.m(true);
            if (d.a.l0.a.e0.h.a.e() == 0) {
                aVar.O(d.a.l0.a.h.aiapps_debug_inspect_normal, new DialogInterface$OnClickListenerC0657a());
            }
            if (d.a.l0.a.e0.h.a.e() != 2) {
                aVar.H(d.a.l0.a.h.aiapps_debug_inspect_enhance, new b());
            }
            if (d.a.l0.a.e0.h.a.e() != 0) {
                aVar.B(d.a.l0.a.h.swanapp_close, new c());
            }
            aVar.X();
        }
    }

    /* loaded from: classes2.dex */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.P2();
            a.this.W2(PrefetchEvent.STATE_CLICK, "baozhang");
        }
    }

    /* loaded from: classes2.dex */
    public class q implements View.OnLongClickListener {
        public q() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            a.this.S2();
            return true;
        }
    }

    public static a d3() {
        return new a();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.a.l0.a.g.aiapps_about_fragment, viewGroup, false);
        Q1(inflate);
        a3(inflate);
        if (P1()) {
            inflate = S1(inflate);
        }
        return A1(inflate, this);
    }

    @Override // d.a.l0.a.h0.g.d
    public void C2() {
        d.a.l0.a.h0.g.f fVar;
        d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
        if (W == null || (fVar = (d.a.l0.a.h0.g.f) W.n(d.a.l0.a.h0.g.f.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, fVar.g3());
        d.a.l0.a.g1.f.V().v(new d.a.l0.a.o0.d.b("sharebtn", hashMap));
        W2(PrefetchEvent.STATE_CLICK, "aboutshare");
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean K() {
        return false;
    }

    @NonNull
    public final String O2(@NonNull String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        if (str2.startsWith(File.separator)) {
            str2 = str2.substring(1);
        }
        return str + File.separator + str2;
    }

    public final void P2() {
        d.a.l0.a.a2.e Q;
        SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
        if (activity == null || (Q = d.a.l0.a.a2.e.Q()) == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.M0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + Q.D());
            this.M0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.B0(d.a.l0.a.h.swan_app_baidu_guarantee_title);
            swanAppWebPopWindow2.x0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
            swanAppWebPopWindow2.y0();
            swanAppWebPopWindow2.w0();
            swanAppWebPopWindow2.D0();
        }
    }

    @Override // d.a.l0.a.h0.g.d
    public void Q1(View view) {
        R1(view);
        if (!U1()) {
            z2(false);
        }
        r2(true);
        l2(-1);
        t2(-16777216);
        n2(null);
        p2(true);
    }

    public final void Q2() {
        SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
        if (activity == null || d.a.l0.a.a2.e.Q() == null) {
            return;
        }
        SwanAppWebPopWindow swanAppWebPopWindow = this.M0;
        if (swanAppWebPopWindow == null || !swanAppWebPopWindow.x()) {
            SwanAppWebPopWindow swanAppWebPopWindow2 = new SwanAppWebPopWindow(activity, this.E0);
            this.M0 = swanAppWebPopWindow2;
            swanAppWebPopWindow2.C0(J(d.a.l0.a.h.swan_app_service_agreement));
            swanAppWebPopWindow2.z0(activity.getResources().getDimensionPixelSize(d.a.l0.a.d.swan_half_screen_evalute_height));
            swanAppWebPopWindow2.x0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_RIGHT);
            swanAppWebPopWindow2.w0();
            swanAppWebPopWindow2.D0();
            W2(PrefetchEvent.STATE_CLICK, "servicenote");
        }
    }

    public final void R2() {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        b.a L = Q.L();
        String J = L.J();
        String F = L.F();
        if (!TextUtils.isEmpty(J) && !TextUtils.isEmpty(F)) {
            String h2 = q0.h(J, F);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new d.a.l0.a.c2.e());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(h2), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.f0, unitedSchemeEntity);
            if (N0) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        } else if (N0) {
            Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
        }
    }

    public final void S2() {
        if (this.f0 == null) {
            return;
        }
        String str = d.a.l0.a.a2.d.g().r().L().f0().webUrl;
        if (TextUtils.isEmpty(str)) {
            r0.b(this.f0).c("");
            d.a.l0.a.z1.b.f.e.f(this.f0, d.a.l0.a.h.swanapp_web_url_copy_fail).F();
            return;
        }
        String O2 = O2(str, d.a.l0.a.l1.b.c(q0.n()));
        int i2 = d.a.l0.a.h.swanapp_web_url_copy_success;
        if (O2.length() > PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL) {
            i2 = d.a.l0.a.h.swanapp_web_url_param_to_long;
        } else {
            str = O2;
        }
        r0.b(this.f0).c(str);
        d.a.l0.a.z1.b.f.e.f(this.f0, i2).F();
    }

    public final void T2() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        if (!W() || (swanAppWebPopWindow = this.M0) == null) {
            return;
        }
        swanAppWebPopWindow.r();
    }

    public final void U2(String str) {
        if (d.a.l0.a.u1.a.a.G()) {
            if (N0) {
                Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
            }
            d.a.l0.a.z1.b.f.e.f(q(), d.a.l0.a.h.aiapps_debug_forbid_favor).F();
            return;
        }
        String f2 = q0.n().f();
        SwanFavorDataManager.h().b(str, new h(f2));
        d.a.l0.a.j1.a.p("aboutconcern", f2);
    }

    public final void V2(String str) {
        SwanFavorDataManager h2 = SwanFavorDataManager.h();
        g gVar = new g();
        d.a.l0.a.n0.l.c l2 = d.a.l0.a.n0.l.c.l();
        l2.n(3);
        h2.c(str, gVar, l2.k());
        W2(PrefetchEvent.STATE_CLICK, "aboutmove");
    }

    public final void W2(String str, String str2) {
        d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
        if (!TextUtils.isEmpty(str)) {
            fVar.f43186b = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            fVar.f43189e = str2;
        }
        y1(fVar);
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean X1() {
        return false;
    }

    public final void X2(@NonNull View view) {
        String b2 = d.a.l0.a.h0.g.b.b();
        d.a.l0.a.k2.g.g a2 = d.a.l0.a.h0.g.b.a();
        Button button = (Button) view.findViewById(d.a.l0.a.f.btn_ues_offline_perftool);
        button.setVisibility(0);
        if (a2.getInt(b2, -1) == 1) {
            button.setText(d.a.l0.a.h.swan_offline_perf_tool_disable);
        } else {
            button.setText(d.a.l0.a.h.swan_offline_perf_tool_enable);
        }
        button.setOnClickListener(new b(a2, b2, new C0647a(a2, b2)));
    }

    public final void Y2(int i2) {
        n0.I(this.y0, this.z0, String.valueOf(i2));
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean Z1() {
        return false;
    }

    public void Z2() {
        FragmentActivity h2 = h();
        if (h2 == null || this.j0 != null) {
            return;
        }
        d.a.l0.k.n nVar = new d.a.l0.k.n(h2, this.i0, 13, d.a.l0.a.c1.a.G(), new d.a.l0.a.w2.h.b());
        this.j0 = nVar;
        nVar.n(q0.O());
        new d.a.l0.a.j1.a(this.j0, this).z();
    }

    public final void a3(View view) {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null || Q.L() == null) {
            return;
        }
        b.a L = Q.L();
        this.x0 = (SwanAppRoundedImageView) view.findViewById(d.a.l0.a.f.aiapps_icon);
        TextView textView = (TextView) view.findViewById(d.a.l0.a.f.aiapps_title);
        textView.setText(L.K());
        if (L.G() == 0) {
            d.a.l0.a.w2.f.a(textView, new i());
        }
        d.a.l0.a.r1.k.f.j().n().h(textView);
        TextView textView2 = (TextView) view.findViewById(d.a.l0.a.f.aiapps_description);
        textView2.setText(L.c1());
        Button button = (Button) view.findViewById(d.a.l0.a.f.share_friends);
        button.setOnClickListener(this);
        Button button2 = (Button) view.findViewById(d.a.l0.a.f.add_favor);
        this.K0 = button2;
        button2.setOnClickListener(this);
        m3();
        d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
        if (W == null) {
            return;
        }
        if (W.n(d.a.l0.a.c1.b.c().a()) != null) {
            button.setVisibility(8);
            this.K0.setVisibility(8);
        }
        d.a.l0.q.d.b().a(textView2);
        ((TextView) view.findViewById(d.a.l0.a.f.service_category_value)).setText(L.q1());
        ((TextView) view.findViewById(d.a.l0.a.f.subject_info_value)).setText(L.r1());
        String D = d.a.l0.a.c1.a.n().D();
        this.E0 = D;
        if (!TextUtils.isEmpty(D)) {
            View findViewById = view.findViewById(d.a.l0.a.f.agreement_layout);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        }
        this.L0 = (RecyclerView) view.findViewById(d.a.l0.a.f.related_swan_app_list);
        PMSAppInfo f0 = L.f0();
        if (c3(f0)) {
            h3(view, f0.brandsInfo);
        }
        this.z0 = (TextView) view.findViewById(d.a.l0.a.f.aiapps_label_tv);
        this.y0 = (BdBaseImageView) view.findViewById(d.a.l0.a.f.aiapps_label_bg);
        this.x0.setImageBitmap(q0.i(L, "SwanAppAboutFragment", false));
        this.x0.setOnClickListener(this);
        SwanAppBearInfo i1 = L.i1();
        if (i1 != null && i1.a()) {
            this.A0 = new d.a.l0.a.w2.a(this.f0, view, i1, d.a.l0.a.f.bear_layout);
        }
        Y2(L.t1());
        ((Button) view.findViewById(d.a.l0.a.f.open_app_button)).setVisibility(8);
        if (N0 || d.a.l0.a.g1.f.V().O()) {
            View inflate = ((ViewStub) view.findViewById(d.a.l0.a.f.ai_app_console)).inflate();
            if (U1() && (inflate instanceof Button)) {
                ((Button) inflate).setText(L.l0() ? d.a.l0.a.h.aiapps_close_debug_mode : d.a.l0.a.h.aiapps_open_debug_mode);
            }
            inflate.setOnClickListener(new j());
            if (!U1()) {
                ((ViewStub) view.findViewById(d.a.l0.a.f.ai_app_property)).inflate().setOnClickListener(new k());
            }
            if (U1()) {
                ((ViewStub) view.findViewById(d.a.l0.a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new l(L, Q));
            }
            if (U1()) {
                View inflate2 = ((ViewStub) view.findViewById(d.a.l0.a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button3 = (Button) inflate2;
                    button3.setText(d.a.l0.a.h.ai_games_debug_game_core_version);
                    button3.setOnClickListener(new m());
                }
            }
            if (d.a.l0.a.r1.j.e().f()) {
                View inflate3 = ((ViewStub) view.findViewById(d.a.l0.a.f.ai_app_report_performance)).inflate();
                if (inflate3 instanceof Button) {
                    Button button4 = (Button) inflate3;
                    button4.setText(d.a.l0.a.h.aiapps_debug_report_performance);
                    button4.setOnClickListener(new n());
                }
            }
            View inflate4 = ((ViewStub) view.findViewById(d.a.l0.a.f.ai_app_start_inspector)).inflate();
            if (inflate4 instanceof Button) {
                ((Button) inflate4).setText(d.a.l0.a.h.aiapps_debug_start_inspect);
            }
            inflate4.setOnClickListener(new o());
            if (!U1()) {
                X2(view);
            }
        }
        if (b3(f0)) {
            ImageView imageView = (ImageView) view.findViewById(d.a.l0.a.f.apply_guarantee);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new p());
        }
        if (U1()) {
            return;
        }
        f3(this.x0, 2000L, new q());
    }

    public final boolean b3(PMSAppInfo pMSAppInfo) {
        return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type;
    }

    public final boolean c3(PMSAppInfo pMSAppInfo) {
        return (d.a.l0.a.a2.d.g().l() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true;
    }

    @Override // d.a.l0.a.h0.g.d
    public void e2() {
        if (U1()) {
            Z2();
            this.j0.p(d.a.l0.a.c1.a.H().a());
        }
    }

    public final void e3() {
        String D = d.a.l0.a.a2.d.g().r().D();
        if (TextUtils.isEmpty(D)) {
            return;
        }
        if (d.a.l0.a.j0.b.a.n(D)) {
            V2(D);
        } else {
            U2(D);
        }
        m3();
    }

    public final void f3(View view, long j2, View.OnLongClickListener onLongClickListener) {
        if (view == null || onLongClickListener == null || j2 <= 0) {
            return;
        }
        view.setOnTouchListener(new d(new c(onLongClickListener, view), j2));
    }

    public final void g3() {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        long[] jArr = this.B0;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.B0;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.B0[0] >= SystemClock.uptimeMillis() - 1000) {
            this.B0 = new long[5];
            if (Q.m0()) {
                i3();
            } else {
                k3();
            }
        }
    }

    public final void h3(View view, String str) {
        int length;
        if (N0) {
            Log.i("SwanAppAboutFragment", str + "");
        }
        if (TextUtils.isEmpty(str) || view == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.C0 = jSONObject.optString("scheme");
            this.D0 = jSONObject.optString("description");
            if (!TextUtils.isEmpty(this.C0) && !TextUtils.isEmpty(this.D0) && (length = this.D0.length()) >= 20) {
                if (length > 100) {
                    this.D0 = this.D0.substring(0, 100);
                }
                LinearLayout linearLayout = (LinearLayout) view.findViewById(d.a.l0.a.f.brands_introduction_ll);
                linearLayout.setOnClickListener(this);
                linearLayout.setVisibility(0);
                ((TextView) view.findViewById(d.a.l0.a.f.brands_introduction_details)).setText(this.D0);
                SwanAppRelatedSwanListAdapter.c("brand", null, "show");
                j3();
            }
        } catch (JSONException e2) {
            if (N0) {
                Log.i("SwanAppAboutFragment", e2.getMessage());
            }
        }
    }

    public final void i3() {
        String b2 = d.a.l0.a.v2.p.b(this.f0);
        d.a.l0.a.z1.b.f.e.g(AppRuntime.getAppContext(), b2).E();
        d.a.l0.a.e0.d.h("SwanAppAboutFragment", "showExtraInfo\n" + b2);
    }

    public final void j3() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(q());
        linearLayoutManager.setOrientation(1);
        this.L0.setLayoutManager(linearLayoutManager);
        SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(q());
        this.L0.setAdapter(swanAppRelatedSwanListAdapter);
        d.a.l0.a.y1.b.c(new e(swanAppRelatedSwanListAdapter));
    }

    public final void k3() {
        if (N0) {
            Log.d("SwanAppAboutFragment", "startAboutFragment");
        }
        d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
        if (W == null) {
            d.a.l0.a.z1.b.f.e.f(q(), d.a.l0.a.h.aiapps_open_fragment_failed_toast).F();
            return;
        }
        g.b i2 = W.i("navigateTo");
        i2.n(d.a.l0.a.h0.g.g.f42076g, d.a.l0.a.h0.g.g.f42078i);
        i2.k("running_info", null).a();
    }

    public final void l3() {
        if (d.a.l0.a.a2.e.Q() == null) {
            return;
        }
        d.a.l0.a.h0.e.c.a(d.a.l0.a.a2.e.Q(), this.f0, new f());
    }

    public final void m3() {
        if (d.a.l0.a.j0.b.a.n(d.a.l0.a.a2.d.g().getAppId())) {
            this.K0.setText(d.a.l0.a.h.swanapp_favored);
            this.K0.setTextColor(z().getColorStateList(d.a.l0.a.c.swan_app_about_attentation_text_selector));
            this.K0.setBackgroundResource(d.a.l0.a.e.swan_app_about_cancel_attention_selector);
            return;
        }
        this.K0.setText(d.a.l0.a.h.swanapp_add_favor);
        this.K0.setTextColor(-1);
        this.K0.setBackgroundResource(d.a.l0.a.e.swan_app_about_attention_selector);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.a.l0.a.f.aiapps_icon) {
            g3();
        } else if (id == d.a.l0.a.f.open_app_button) {
            R2();
        } else if (id == d.a.l0.a.f.brands_introduction_ll) {
            SchemeRouter.invoke(q(), this.C0);
            W2(PrefetchEvent.STATE_CLICK, "brand");
        } else if (id == d.a.l0.a.f.agreement_layout) {
            Q2();
        } else if (id == d.a.l0.a.f.share_friends) {
            C2();
        } else if (id == d.a.l0.a.f.add_favor) {
            e3();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        T2();
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        d.a.l0.a.w2.a aVar = this.A0;
        if (aVar != null) {
            aVar.c();
        }
        x2(1);
        d.a.l0.k.n nVar = this.j0;
        if (nVar != null && nVar.g()) {
            this.j0.x(d.a.l0.a.c1.a.H().a());
        }
        if (this.K0 != null) {
            m3();
        }
    }
}
