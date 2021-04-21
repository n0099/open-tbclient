package d.b.h0.a.e0.l;

import android.content.DialogInterface;
import android.net.Uri;
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
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.pms.PMSConstants$PayProtected;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.b.h0.a.e0.j.c;
import d.b.h0.a.e0.l.i;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.l0;
import d.b.h0.a.j1.k;
import d.b.h0.a.p1.b;
import d.b.h0.a.q1.b.b.g;
import d.b.h0.a.y0.e.b;
import d.b.h0.g.f.d;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.h0.a.e0.l.c implements View.OnClickListener {
    public static final boolean N0 = d.b.h0.a.k.f45772a;
    public TextView A0;
    public d.b.h0.a.j2.a B0;
    public long[] C0 = new long[5];
    public String D0;
    public String E0;
    public String K0;
    public Button L0;
    public RecyclerView M0;
    public SwanAppRoundedImageView y0;
    public BdBaseImageView z0;

    /* renamed from: d.b.h0.a.e0.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0683a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnLongClickListener f44649e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f44650f;

        public RunnableC0683a(View.OnLongClickListener onLongClickListener, View view) {
            this.f44649e = onLongClickListener;
            this.f44650f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.c2.j.b.a.d().g();
            this.f44649e.onLongClick(this.f44650f);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f44652e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f44653f;

        public b(Runnable runnable, long j) {
            this.f44652e = runnable;
            this.f44653f = j;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                view.postDelayed(this.f44652e, this.f44653f);
                return false;
            } else if (action == 1 || action == 3) {
                view.removeCallbacks(this.f44652e);
                return false;
            } else {
                return false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements b.InterfaceC0789b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppRelatedSwanListAdapter f44655a;

        /* renamed from: d.b.h0.a.e0.l.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0684a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.a.p1.a f44657e;

            public RunnableC0684a(d.b.h0.a.p1.a aVar) {
                this.f44657e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.M0.setVisibility(0);
                c.this.f44655a.d(this.f44657e);
            }
        }

        public c(SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter) {
            this.f44655a = swanAppRelatedSwanListAdapter;
        }

        @Override // d.b.h0.a.p1.b.InterfaceC0789b
        public void a(d.b.h0.a.p1.a aVar) {
            if (aVar != null) {
                if ((aVar.f46182a == null) || (aVar.f46182a.size() <= 0)) {
                    return;
                }
                k0.X(new RunnableC0684a(aVar));
                SwanAppRelatedSwanListAdapter.c("aboutrelated", null, "show");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.b {

        /* renamed from: d.b.h0.a.e0.l.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0685a implements d.e {
            public C0685a() {
            }

            @Override // d.b.h0.g.f.d.e
            public void a(boolean z) {
                if (z) {
                    d.b.h0.a.c0.a.d(a.this.l());
                } else {
                    d.b.h0.g.f.d.m().p(a.this.f0, null);
                }
            }
        }

        public d() {
        }

        @Override // d.b.h0.a.e0.j.c.b
        public void a(boolean z, String str) {
            if (!z) {
                d.b.h0.a.e0.j.c.b(a.this.f0, str);
            } else if (d.b.h0.a.c0.a.a()) {
                d.b.h0.a.c0.a.d(a.this.l());
            } else {
                d.b.h0.g.f.d.m().o(new C0685a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.h0.a.m0.b.b {
        public e() {
        }

        @Override // d.b.h0.a.m0.b.b
        public void a() {
            d.b.h0.a.q1.b.f.d e2 = d.b.h0.a.q1.b.f.d.e(a.this.l(), d.b.h0.a.h.aiapps_cancel_fav_fail);
            e2.k(2);
            e2.C();
        }

        @Override // d.b.h0.a.m0.b.b
        public void b() {
            d.b.h0.a.q1.b.f.d e2 = d.b.h0.a.q1.b.f.d.e(a.this.l(), d.b.h0.a.h.aiapps_cancel_fav_success);
            e2.k(2);
            e2.x();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.b.h0.a.m0.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44662a;

        public f(String str) {
            this.f44662a = str;
        }

        @Override // d.b.h0.a.m0.b.a
        public void a() {
            d.b.h0.a.g0.c.a.t();
            if (d.b.h0.a.c1.a.l(a.this.f())) {
                d.b.h0.a.c1.a.q("aboutconcern", this.f44662a);
                return;
            }
            d.b.h0.a.q1.b.f.d e2 = d.b.h0.a.q1.b.f.d.e(a.this.l(), d.b.h0.a.h.aiapps_fav_success);
            e2.k(2);
            e2.o(2);
            e2.C();
        }

        @Override // d.b.h0.a.m0.b.a
        public void b() {
            d.b.h0.a.q1.b.f.d e2 = d.b.h0.a.q1.b.f.d.e(a.this.l(), d.b.h0.a.h.aiapps_fav_fail);
            e2.k(2);
            e2.C();
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.e0.f.j();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public FullScreenFloatView f44665e;

        /* renamed from: d.b.h0.a.e0.l.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0686a implements d.e {
            public C0686a() {
            }

            @Override // d.b.h0.g.f.d.e
            public void a(boolean z) {
                if (z) {
                    d.b.h0.a.c0.a.c(a.this.l(), true);
                } else {
                    d.b.h0.g.f.d.m().p(a.this.f0, null);
                }
            }
        }

        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f0 == null) {
                return;
            }
            if (a.N0) {
                if (this.f44665e == null) {
                    this.f44665e = d.b.h0.a.z0.f.V().B(a.this.f0);
                }
                if (a.this.Q1()) {
                    if (d.b.h0.a.c0.a.a()) {
                        d.b.h0.a.c0.a.c(a.this.l(), false);
                        return;
                    } else {
                        d.b.h0.g.f.d.m().o(new C0686a());
                        return;
                    }
                }
                this.f44665e.setVisibility(this.f44665e.getVisibility() == 0 ? 8 : 0);
            } else if (a.this.Q1()) {
                a.this.Z2();
            } else {
                d.b.h0.a.c0.a.d(a.this.l());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public SwanAppPropertyWindow f44668e;

        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f44668e == null) {
                this.f44668e = d.b.h0.a.z0.f.V().H(a.this.f0);
            }
            this.f44668e.setVisibility(this.f44668e.getVisibility() == 0 ? 8 : 0);
        }
    }

    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.y0.e.b f44670e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f44671f;

        /* renamed from: d.b.h0.a.e0.l.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class DialogInterface$OnClickListenerC0687a implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0687a(j jVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public j(d.b.h0.a.y0.e.b bVar, d.b.h0.a.r1.e eVar) {
            this.f44670e = bVar;
            this.f44671f = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f0 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ENABLE CODE CACHE: ");
            sb.append(d.b.h0.a.w0.a.N().G(a.this.A1()));
            sb.append("\n");
            sb.append("ENABLE V8: ");
            sb.append(d.b.h0.a.e0.w.d.L().d0());
            sb.append("\n");
            sb.append("APS VERSION: ");
            sb.append(TextUtils.isEmpty(this.f44670e.n1()) ? "" : this.f44670e.n1());
            sb.append("\n");
            sb.append("APPID VERSION: ");
            sb.append(d.b.h0.a.u.a.c(this.f44671f.f46461f));
            sb.append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), this.f44670e.a1());
            sb.append("小程序包大小: ");
            sb.append(TextUtils.isEmpty(formatFileSize) ? "" : formatFileSize);
            sb.append("(");
            sb.append(this.f44670e.a1());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append("\n");
            g.a aVar = new g.a(a.this.f0);
            aVar.V(a.this.f0.getResources().getString(d.b.h0.a.h.aiapps_show_ext_info_title));
            aVar.y(sb.toString());
            aVar.n(new d.b.h0.a.j2.g.a());
            aVar.m(false);
            aVar.O(d.b.h0.a.h.aiapps_ok, new DialogInterface$OnClickListenerC0687a(this));
            aVar.X();
        }
    }

    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {

        /* renamed from: d.b.h0.a.e0.l.a$k$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class DialogInterface$OnClickListenerC0688a implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0688a(k kVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String e2;
            String string;
            a aVar = a.this;
            if (aVar.f0 == null) {
                return;
            }
            if (aVar.Q1()) {
                e2 = d.b.h0.a.b2.a.c().e(1);
                string = a.this.f0.getResources().getString(d.b.h0.a.h.ai_games_debug_game_core_version);
            } else {
                e2 = d.b.h0.a.b2.a.c().e(0);
                string = a.this.f0.getResources().getString(d.b.h0.a.h.aiapps_swan_core_history_title);
            }
            g.a aVar2 = new g.a(a.this.f0);
            aVar2.V(string);
            aVar2.y(e2);
            aVar2.n(new d.b.h0.a.j2.g.a());
            aVar2.m(false);
            aVar2.O(d.b.h0.a.h.aiapps_ok, new DialogInterface$OnClickListenerC0688a(this));
            aVar2.X();
        }
    }

    /* loaded from: classes2.dex */
    public class l implements View.OnClickListener {

        /* renamed from: d.b.h0.a.e0.l.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0689a extends k.a {

            /* renamed from: d.b.h0.a.e0.l.a$l$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC0690a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f44676e;

                public RunnableC0690a(String str) {
                    this.f44676e = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    g.a aVar = new g.a(a.this.f0);
                    aVar.U(d.b.h0.a.h.aiapps_debug_report_performance);
                    aVar.y(this.f44676e);
                    aVar.n(new d.b.h0.a.j2.g.a());
                    aVar.m(false);
                    aVar.O(d.b.h0.a.h.aiapps_ok, null);
                    aVar.X();
                }
            }

            public C0689a() {
            }

            @Override // d.b.h0.a.j1.k.a
            public void c(String str) {
                a.this.f0.runOnUiThread(new RunnableC0690a(str));
            }
        }

        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f0 == null) {
                return;
            }
            d.b.h0.a.j1.k.e().g(new C0689a());
        }
    }

    /* loaded from: classes2.dex */
    public class m implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public d.b.h0.a.c0.f.a f44678e;

        /* renamed from: d.b.h0.a.e0.l.a$m$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class DialogInterface$OnClickListenerC0691a implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0691a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                d.b.h0.a.c0.f.a.g(1);
                m.this.f44678e = new d.b.h0.a.c0.f.a(d.b.h0.a.w0.a.c());
                m.this.f44678e.h();
            }
        }

        /* loaded from: classes2.dex */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                m.this.b();
                d.b.h0.a.c0.f.a.g(2);
                System.exit(0);
            }
        }

        /* loaded from: classes2.dex */
        public class c implements DialogInterface.OnClickListener {
            public c() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                m.this.b();
                d.b.h0.a.c0.f.a.g(0);
            }
        }

        public m() {
        }

        public final void b() {
            d.b.h0.a.c0.f.a aVar = this.f44678e;
            if (aVar != null) {
                aVar.i();
                this.f44678e = null;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.f0);
            aVar.U(d.b.h0.a.h.aiapps_debug_start_inspect);
            aVar.w(d.b.h0.a.h.aiapps_debug_inspect_message);
            aVar.n(new d.b.h0.a.j2.g.a());
            aVar.m(true);
            if (d.b.h0.a.c0.f.a.e() == 0) {
                aVar.O(d.b.h0.a.h.aiapps_debug_inspect_normal, new DialogInterface$OnClickListenerC0691a());
            }
            if (d.b.h0.a.c0.f.a.e() != 2) {
                aVar.I(d.b.h0.a.h.aiapps_debug_inspect_enhance, new b());
            }
            if (d.b.h0.a.c0.f.a.e() != 0) {
                aVar.C(d.b.h0.a.h.aiapps_debug_inspect_close, new c());
            }
            aVar.X();
        }
    }

    /* loaded from: classes2.dex */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k0.a(a.this.l());
            a.this.M2(PrefetchEvent.STATE_CLICK, "baozhang");
        }
    }

    /* loaded from: classes2.dex */
    public class o implements View.OnLongClickListener {
        public o() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            a.this.J2();
            return true;
        }
    }

    public static a S2() {
        return new a();
    }

    @NonNull
    public final String G2(@NonNull String str, String str2) {
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

    public final void H2() {
        i.d I2 = d.b.h0.a.e0.l.i.I2(this.K0);
        I2.b(G(d.b.h0.a.h.swan_app_service_agreement));
        I2.a(false);
        I2.c();
        M2(PrefetchEvent.STATE_CLICK, "servicenote");
    }

    public final void I2() {
        d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
        if (O == null) {
            return;
        }
        b.a J = O.J();
        String I = J.I();
        String E = J.E();
        if (!TextUtils.isEmpty(I) && !TextUtils.isEmpty(E)) {
            String i2 = k0.i(I, E);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new d.b.h0.a.t1.j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(i2), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.f0, unitedSchemeEntity);
            if (N0) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        } else if (N0) {
            Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
        }
    }

    public final void J2() {
        if (this.f0 == null) {
            return;
        }
        String str = d.b.h0.a.r1.d.e().s().J().c0().webUrl;
        if (TextUtils.isEmpty(str)) {
            l0.b(this.f0).c("");
            d.b.h0.a.q1.b.f.d.e(this.f0, d.b.h0.a.h.swanapp_web_url_copy_fail).C();
            return;
        }
        String G2 = G2(str, d.b.h0.a.e1.b.a(k0.n()));
        int i2 = d.b.h0.a.h.swanapp_web_url_copy_success;
        if (G2.length() > PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL) {
            i2 = d.b.h0.a.h.swanapp_web_url_param_to_long;
        } else {
            str = G2;
        }
        l0.b(this.f0).c(str);
        d.b.h0.a.q1.b.f.d.e(this.f0, i2).C();
    }

    public final void K2(String str) {
        if (d.b.h0.a.m1.a.a.C()) {
            if (N0) {
                Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
            }
            d.b.h0.a.q1.b.f.d.e(l(), d.b.h0.a.h.aiapps_debug_forbid_favor).C();
            return;
        }
        String d2 = k0.n().d();
        SwanFavorDataManager.i().b(str, 1, new f(d2));
        d.b.h0.a.c1.a.q("aboutconcern", d2);
    }

    public final void L2(String str) {
        SwanFavorDataManager i2 = SwanFavorDataManager.i();
        e eVar = new e();
        d.b.h0.a.j0.j.c k2 = d.b.h0.a.j0.j.c.k();
        k2.m(3);
        i2.d(str, eVar, k2.j());
        M2(PrefetchEvent.STATE_CLICK, "aboutmove");
    }

    @Override // d.b.h0.a.e0.l.c
    public void M1(View view) {
        N1(view);
        m2(true);
        g2(-1);
        o2(-16777216);
        i2(null);
        k2(true);
    }

    public final void M2(String str, String str2) {
        d.b.h0.a.z1.k.f fVar = new d.b.h0.a.z1.k.f();
        if (!TextUtils.isEmpty(str)) {
            fVar.f47973b = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            fVar.f47975d = str2;
        }
        t1(fVar);
    }

    public final void N2(int i2) {
        h0.F(this.z0, this.A0, String.valueOf(i2));
    }

    public void O2() {
        FragmentActivity f2 = f();
        if (f2 == null || this.j0 != null) {
            return;
        }
        this.j0 = new d.b.h0.i.n(f2, this.i0, 13, d.b.h0.a.w0.a.y(), new d.b.h0.a.j2.g.b());
        if (!Q1()) {
            this.j0.k(35);
            this.j0.k(37);
        }
        new d.b.h0.a.c1.a(this.j0, this).z();
    }

    public final void P2(View view) {
        d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
        if (O == null || O.J() == null) {
            return;
        }
        b.a J = O.J();
        this.y0 = (SwanAppRoundedImageView) view.findViewById(d.b.h0.a.f.aiapps_icon);
        TextView textView = (TextView) view.findViewById(d.b.h0.a.f.aiapps_title);
        textView.setText(J.J());
        if (J.F() == 0) {
            d.b.h0.a.j2.e.a(textView, new g());
        }
        d.b.h0.a.j1.l.f.h().l().f(textView);
        ((TextView) view.findViewById(d.b.h0.a.f.aiapps_description)).setText(J.W0());
        ((Button) view.findViewById(d.b.h0.a.f.share_friends)).setOnClickListener(this);
        Button button = (Button) view.findViewById(d.b.h0.a.f.add_favor);
        this.L0 = button;
        button.setOnClickListener(this);
        a3();
        ((TextView) view.findViewById(d.b.h0.a.f.service_category_value)).setText(J.j1());
        ((TextView) view.findViewById(d.b.h0.a.f.subject_info_value)).setText(J.k1());
        String D = d.b.h0.a.w0.a.l().D();
        this.K0 = D;
        if (!TextUtils.isEmpty(D)) {
            View findViewById = view.findViewById(d.b.h0.a.f.agreement_layout);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        }
        this.M0 = (RecyclerView) view.findViewById(d.b.h0.a.f.related_swan_app_list);
        PMSAppInfo c0 = J.c0();
        if (R2(c0)) {
            W2(view, c0.brandsInfo);
        }
        this.A0 = (TextView) view.findViewById(d.b.h0.a.f.aiapps_label_tv);
        this.z0 = (BdBaseImageView) view.findViewById(d.b.h0.a.f.aiapps_label_bg);
        this.y0.setImageBitmap(k0.j(J, "SwanAppAboutFragment", false));
        this.y0.setOnClickListener(this);
        SwanAppBearInfo c1 = J.c1();
        if (c1 != null && c1.a()) {
            this.B0 = new d.b.h0.a.j2.a(this.f0, view, c1, d.b.h0.a.f.bear_layout);
        }
        N2(J.m1());
        ((Button) view.findViewById(d.b.h0.a.f.open_app_button)).setVisibility(8);
        if (N0 || d.b.h0.a.z0.f.V().O()) {
            View inflate = ((ViewStub) view.findViewById(d.b.h0.a.f.ai_app_console)).inflate();
            if (Q1() && (inflate instanceof Button)) {
                ((Button) inflate).setText(J.i0() ? d.b.h0.a.h.aiapps_close_debug_mode : d.b.h0.a.h.aiapps_open_debug_mode);
            }
            inflate.setOnClickListener(new h());
            if (!Q1()) {
                ((ViewStub) view.findViewById(d.b.h0.a.f.ai_app_property)).inflate().setOnClickListener(new i());
            }
            ((ViewStub) view.findViewById(d.b.h0.a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new j(J, O));
            View inflate2 = ((ViewStub) view.findViewById(d.b.h0.a.f.ai_app_swan_core_history_info)).inflate();
            if (inflate2 instanceof Button) {
                Button button2 = (Button) inflate2;
                if (Q1()) {
                    button2.setText(d.b.h0.a.h.ai_games_debug_game_core_version);
                } else {
                    button2.setText(d.b.h0.a.h.aiapps_debug_swan_core_version);
                }
                button2.setOnClickListener(new k());
            }
            if (d.b.h0.a.j1.k.e().f()) {
                View inflate3 = ((ViewStub) view.findViewById(d.b.h0.a.f.ai_app_report_performance)).inflate();
                if (inflate3 instanceof Button) {
                    Button button3 = (Button) inflate3;
                    button3.setText(d.b.h0.a.h.aiapps_debug_report_performance);
                    button3.setOnClickListener(new l());
                }
            }
            View inflate4 = ((ViewStub) view.findViewById(d.b.h0.a.f.ai_app_start_inspector)).inflate();
            if (inflate4 instanceof Button) {
                ((Button) inflate4).setText(d.b.h0.a.h.aiapps_debug_start_inspect);
            }
            inflate4.setOnClickListener(new m());
        }
        if (Q2(c0)) {
            ImageView imageView = (ImageView) view.findViewById(d.b.h0.a.f.apply_guarantee);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new n());
        }
        if (Q1()) {
            return;
        }
        U2(this.y0, 2000L, new o());
    }

    public final boolean Q2(PMSAppInfo pMSAppInfo) {
        return (pMSAppInfo == null ? PMSConstants$PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants$PayProtected.PAY_PROTECTED.type && k0.D();
    }

    public final boolean R2(PMSAppInfo pMSAppInfo) {
        return (d.b.h0.a.r1.d.e().h() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true;
    }

    @Override // d.b.h0.a.e0.l.c
    public boolean T1() {
        return false;
    }

    public final void T2() {
        String appId = d.b.h0.a.r1.d.e().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return;
        }
        if (d.b.h0.a.g0.c.a.n(appId)) {
            L2(appId);
        } else {
            K2(appId);
        }
        a3();
    }

    public final void U2(View view, long j2, View.OnLongClickListener onLongClickListener) {
        if (view == null || onLongClickListener == null || j2 <= 0) {
            return;
        }
        view.setOnTouchListener(new b(new RunnableC0683a(onLongClickListener, view), j2));
    }

    @Override // d.b.h0.a.e0.l.c
    public boolean V1() {
        return false;
    }

    public final void V2() {
        long[] jArr = this.C0;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.C0;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.C0[0] >= SystemClock.uptimeMillis() - 1000) {
            X2();
        }
    }

    public final void W2(View view, String str) {
        int length;
        if (N0) {
            Log.i("SwanAppAboutFragment", str + "");
        }
        if (TextUtils.isEmpty(str) || view == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.D0 = jSONObject.optString("scheme");
            this.E0 = jSONObject.optString("description");
            if (!TextUtils.isEmpty(this.D0) && !TextUtils.isEmpty(this.E0) && (length = this.E0.length()) >= 20) {
                if (length > 100) {
                    this.E0 = this.E0.substring(0, 100);
                }
                LinearLayout linearLayout = (LinearLayout) view.findViewById(d.b.h0.a.f.brands_introduction_ll);
                linearLayout.setOnClickListener(this);
                linearLayout.setVisibility(0);
                ((TextView) view.findViewById(d.b.h0.a.f.brands_introduction_details)).setText(this.E0);
                SwanAppRelatedSwanListAdapter.c("brand", null, "show");
                Y2();
            }
        } catch (JSONException e2) {
            if (N0) {
                Log.i("SwanAppAboutFragment", e2.getMessage());
            }
        }
    }

    public final void X2() {
        String d2 = d.b.h0.a.i2.o.d(this.f0);
        d.b.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), d2).B();
        d.b.h0.a.c0.c.h("SwanAppAboutFragment", "showExtraInfo\n" + d2);
        this.C0 = new long[5];
    }

    public final void Y2() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(l());
        linearLayoutManager.setOrientation(1);
        this.M0.setLayoutManager(linearLayoutManager);
        SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(l());
        this.M0.setAdapter(swanAppRelatedSwanListAdapter);
        d.b.h0.a.p1.b.b(new c(swanAppRelatedSwanListAdapter));
    }

    public final void Z2() {
        if (d.b.h0.a.r1.e.O() == null) {
            return;
        }
        d.b.h0.a.e0.j.c.a(d.b.h0.a.r1.e.O(), this.f0, new d());
    }

    @Override // d.b.h0.a.e0.l.c
    public void a2() {
        O2();
        this.j0.p(d.b.h0.a.w0.a.z().a());
    }

    public final void a3() {
        if (d.b.h0.a.g0.c.a.n(d.b.h0.a.r1.d.e().getAppId())) {
            this.L0.setText(d.b.h0.a.h.swanapp_favored);
            this.L0.setTextColor(u().getColorStateList(d.b.h0.a.c.swan_app_about_attentation_text_selector));
            this.L0.setBackgroundResource(d.b.h0.a.e.swan_app_about_cancel_attention_selector);
            return;
        }
        this.L0.setText(d.b.h0.a.h.swanapp_add_favor);
        this.L0.setTextColor(-1);
        this.L0.setBackgroundResource(d.b.h0.a.e.swan_app_about_attention_selector);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.b.h0.a.f.aiapps_icon) {
            V2();
        } else if (id == d.b.h0.a.f.open_app_button) {
            I2();
        } else if (id == d.b.h0.a.f.brands_introduction_ll) {
            SchemeRouter.invoke(l(), this.D0);
            M2(PrefetchEvent.STATE_CLICK, "brand");
        } else if (id == d.b.h0.a.f.agreement_layout) {
            H2();
        } else if (id == d.b.h0.a.f.share_friends) {
            x2();
        } else if (id == d.b.h0.a.f.add_favor) {
            T2();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // d.b.h0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        d.b.h0.a.j2.a aVar = this.B0;
        if (aVar != null) {
            aVar.c();
        }
        s2(1);
        d.b.h0.i.n nVar = this.j0;
        if (nVar != null && nVar.h()) {
            this.j0.x(d.b.h0.a.w0.a.z().a());
        }
        if (this.L0 != null) {
            a3();
        }
    }

    @Override // d.b.h0.a.e0.l.c
    public boolean v() {
        return false;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View v0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.b.h0.a.g.aiapps_about_fragment, viewGroup, false);
        M1(inflate);
        P2(inflate);
        if (L1()) {
            inflate = O1(inflate);
        }
        return v1(inflate, this);
    }

    @Override // d.b.h0.a.e0.l.c
    public void x2() {
        d.b.h0.a.e0.l.e eVar;
        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
        if (W == null || (eVar = (d.b.h0.a.e0.l.e) W.n(d.b.h0.a.e0.l.e.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", eVar.X2());
        d.b.h0.a.z0.f.V().N(new d.b.h0.a.k0.b.b("sharebtn", hashMap));
        M2(PrefetchEvent.STATE_CLICK, "aboutshare");
    }
}
