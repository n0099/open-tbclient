package d.b.g0.e.a.r;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.e.a.o.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h implements d.b.g0.e.a.m.b, d.b.g0.e.a.m.c, d.b.g0.e.a.m.a, d.b.g0.e.a.m.d {
    public static String G = "0";
    public static String H = "101";
    public static String I = "102";
    public static String J = "103";
    public static String K = "104";
    public static String L = "1";
    public static String M = "0";
    public static String N = "status";
    public static String O = "isPaused";
    public static String P = "token";
    public static String Q = "monitors";
    public d.b.g0.a.q.g.a.a A;
    public boolean B;
    public boolean C;
    public boolean D;
    public d.b.g0.e.a.r.g E;
    public boolean F;

    /* renamed from: a  reason: collision with root package name */
    public Context f47724a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.e.a.b f47725b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.a.b1.g.a f47726c;

    /* renamed from: d  reason: collision with root package name */
    public AdElementInfo f47727d;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.g.k0.a f47729f;

    /* renamed from: h  reason: collision with root package name */
    public k f47731h;
    public l i;
    public d.b.g0.a.q1.b.b.g j;
    public String k;
    public String l;
    public j m;
    public boolean n;
    public d.b.g0.e.a.r.b o;
    public i p;
    public boolean q;
    public String s;
    public d.b.g0.e.a.n.a t;
    public d.b.g0.a.q.b x;
    public d.b.g0.a.q.g.b.a z;

    /* renamed from: e  reason: collision with root package name */
    public int f47728e = 256;

    /* renamed from: g  reason: collision with root package name */
    public int f47730g = 0;
    public boolean r = true;
    public String u = H;
    public String v = M;
    public Map<String, String> w = new HashMap();
    public SwanAdDownloadState y = SwanAdDownloadState.NOT_START;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f47732e;

        public a(l lVar) {
            this.f47732e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.l0();
            if (d.b.g0.g.k0.e.c.g(h.this.f47725b.q())) {
                d.b.g0.g.k0.e.c.i(h.this.f47725b.q());
            }
            if (!d.b.g0.g.k0.e.c.a(h.this.f47725b.q(), d.b.g0.a.e1.d.a.a.b())) {
                h.this.i0(this.f47732e, "3010000");
                return;
            }
            h.this.i = this.f47732e;
            h.this.f47728e = 260;
            h.this.f47725b.E(h.this.f47727d.I());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            h.this.n = false;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            h.this.X();
            h.this.n = false;
            d.b.g0.g.k0.e.b.a(h.this.b0(), "continue", h.this.a0());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (!h.this.F || h.this.f47725b == null) {
                h.this.d0();
            } else {
                if (h.this.f47726c != null) {
                    h.this.f47726c.r();
                }
                if (h.this.p != null) {
                    h.this.f47724a.unregisterReceiver(h.this.p);
                    h.this.p = null;
                }
                h.this.f47728e = 262;
                h.this.f47725b.z();
            }
            h.this.n = false;
            d.b.g0.g.k0.e.b.a(h.this.b0(), IntentConfig.CLOSE, h.this.a0());
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.g0.a.q.g.a.a {
        public e() {
        }

        @Override // d.b.g0.a.q.g.a.a
        public void a(SwanAdDownloadState swanAdDownloadState, int i) {
            if (i == 0) {
                return;
            }
            if (i != 100 || h.this.u == h.H) {
                if (h.this.u == h.H || h.this.u == h.K) {
                    return;
                }
                h.this.u = String.valueOf(i);
                return;
            }
            h.this.u = h.I;
        }

        @Override // d.b.g0.a.q.g.a.a
        public void b() {
            h.this.x.c("appinstallbegin");
        }

        @Override // d.b.g0.a.q.g.a.a
        public void c(SwanAdDownloadState swanAdDownloadState, int i) {
            if (!h.this.B) {
                h.this.v0(swanAdDownloadState);
            }
            h.this.B = true;
            if (h.this.y == swanAdDownloadState) {
                return;
            }
            if (h.this.y == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                h.this.v = h.M;
                h.this.x.c("appdownloadbegin");
            } else if (swanAdDownloadState != SwanAdDownloadState.DOWNLOAD_PAUSED) {
                if (h.this.y == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                    h.this.v = h.M;
                    h.this.x.c("appdownloadcontinue");
                } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                    h.this.v = h.M;
                    h.this.u = h.I;
                    h.this.x.c("appdownloadfinish");
                    h.this.x.c("appinstallbegin");
                } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                    h.this.v = h.M;
                    h.this.u = h.J;
                    h.this.x.c("appinstallfinish");
                } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_FAILED) {
                    h.this.v = h.M;
                    h.this.u = h.K;
                } else if (swanAdDownloadState == SwanAdDownloadState.DELETED) {
                    h.this.v = h.M;
                    h.this.u = h.H;
                }
            } else {
                h.this.v = h.L;
                h.this.x.c("appdownloadpause");
            }
            h.this.y = swanAdDownloadState;
        }

        @Override // d.b.g0.a.q.g.a.a
        public void d(String str) {
        }

        @Override // d.b.g0.a.q.g.a.a
        public String e() {
            h.this.x.c("appinstallopen");
            return "";
        }

        @Override // d.b.g0.a.q.g.a.a
        public void f(boolean z) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.g0.a.b1.g.b {
        public f() {
        }

        @Override // d.b.g0.a.b1.g.b
        public void a(d.b.g0.a.w0.c.j jVar) {
            if (h.this.f47725b != null) {
                h.this.f47725b.w();
            }
            h.this.f47728e = 261;
            h.this.f47730g = 0;
            if (h.this.f47725b != null) {
                h.this.f47725b.o();
            }
            if (h.this.i != null) {
                h.this.i.c();
            }
            if (h.this.p == null) {
                h.this.p = new i(h.this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                h.this.f47724a.registerReceiver(h.this.p, intentFilter);
            }
            if (h.this.C) {
                d.b.g0.e.a.p.d.f(h.this.f47727d, h.this.o);
                return;
            }
            d.b.g0.e.a.p.c.g(h.this.f47727d, h.this.o);
            d.b.g0.e.a.p.c.j(h.this.f47727d, h.this.o);
            String str = h.this.l;
            h hVar = h.this;
            d.b.g0.e.a.p.c.c(str, hVar.k, hVar.s, h.this.o);
        }

        @Override // d.b.g0.a.b1.g.b
        public boolean b(d.b.g0.a.w0.c.j jVar, int i, int i2) {
            h.this.r0();
            h hVar = h.this;
            hVar.i0(hVar.i, "3010001");
            return true;
        }

        @Override // d.b.g0.a.b1.g.b
        public void c(d.b.g0.a.w0.c.j jVar) {
        }

        @Override // d.b.g0.a.b1.g.b
        public void d(d.b.g0.a.w0.c.j jVar) {
            h.this.c0();
        }

        @Override // d.b.g0.a.b1.g.b
        public void e(d.b.g0.a.w0.c.j jVar) {
        }

        @Override // d.b.g0.a.b1.g.b
        public void f(d.b.g0.a.w0.c.j jVar) {
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.b.g0.g.k0.a {
        public g() {
        }

        @Override // d.b.g0.g.k0.a
        public void f() {
            h.this.q = false;
            h.this.q0();
        }

        @Override // d.b.g0.g.k0.a
        public void k() {
        }

        @Override // d.b.g0.g.k0.a
        public void q() {
            h.this.q = true;
            if (h.this.r) {
                h.this.X();
            }
        }
    }

    /* renamed from: d.b.g0.e.a.r.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0938h {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f47740a;

        static {
            int[] iArr = new int[CommandType.values().length];
            f47740a = iArr;
            try {
                iArr[CommandType.ACTION_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47740a[CommandType.OPEN_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47740a[CommandType.GET_DOWNLOAD_STATUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47740a[CommandType.PAUSE_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47740a[CommandType.UNSPECIFIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f47740a[CommandType.BANNER_VIEW.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends BroadcastReceiver {
        public i() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.f47726c == null) {
                return;
            }
            if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                h.this.r = true;
                if (h.this.q) {
                    h.this.X();
                }
            } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                h.this.r = false;
            }
        }

        public /* synthetic */ i(h hVar, a aVar) {
            this();
        }
    }

    public h(String str, String str2, boolean z) {
        this.k = "";
        Context appContext = AppRuntime.getAppContext();
        this.f47724a = appContext;
        this.l = str;
        this.k = str2;
        this.C = z;
        this.D = z;
        this.o = new d.b.g0.e.a.r.b(appContext);
        this.t = new d.b.g0.e.a.n.a();
        this.F = d.b.g0.e.a.q.f.i();
    }

    public final void X() {
        if (this.f47726c == null || this.f47725b == null) {
            return;
        }
        d.b.g0.a.q1.b.b.g gVar = this.j;
        if ((gVar != null && gVar.isShowing()) || this.f47726c.o() || this.f47725b.s()) {
            return;
        }
        this.f47726c.t();
        this.f47725b.B();
        d.b.g0.e.a.p.c.j(this.f47727d, this.o);
    }

    public final d.b.g0.e.a.p.b Y(int i2) {
        d.b.g0.e.a.p.b bVar = new d.b.g0.e.a.p.b();
        bVar.i = String.valueOf(this.f47727d.r());
        bVar.j = String.valueOf(this.f47730g);
        bVar.k = String.valueOf(i2);
        String str = "1";
        bVar.l = this.f47730g == 0 ? "1" : "0";
        bVar.m = i2 == this.f47727d.r() ? "1" : "0";
        int i3 = 1;
        bVar.n = this.f47724a.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        int i4 = this.f47730g;
        if (i4 != 0) {
            i3 = i4 == this.f47727d.r() ? 3 : 2;
        }
        bVar.o = String.valueOf(i3);
        bVar.p = (this.f47730g == 0 && SwanAppNetworkUtils.i(this.f47724a)) ? "2" : "2";
        bVar.q = String.valueOf(0);
        return bVar;
    }

    public final int Z() {
        d.b.g0.a.b1.g.a aVar = this.f47726c;
        if (aVar != null && aVar.n()) {
            return this.f47726c.j() / 1000;
        }
        return a0();
    }

    @Override // d.b.g0.e.a.m.d
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", str2);
            jSONObject.put("title", this.f47727d.G());
            jSONObject.put("description", this.f47727d.q());
            jSONObject.put("autoinstall", true);
            if (this.E == null) {
                this.E = new d.b.g0.e.a.r.g(this.f47724a, this.f47727d, this.o);
            }
            this.E.k(str);
            d.b.g0.a.w0.a.d().a(this.f47724a, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.E);
        } catch (JSONException e2) {
            if (d.b.g0.a.k.f45050a) {
                e2.printStackTrace();
            }
        }
    }

    public final int a0() {
        d.b.g0.a.b1.g.a aVar = this.f47726c;
        if (aVar != null) {
            return aVar.i() / 1000;
        }
        return 0;
    }

    @Override // d.b.g0.e.a.m.c
    public void b(View view) {
        SwanAppActivity activity;
        int min;
        int i2;
        int i3;
        String format;
        if (this.f47726c == null || this.f47727d == null || (activity = d.b.g0.a.z0.f.V().getActivity()) == null || this.n) {
            return;
        }
        if (view != null && d.b.g0.e.a.g.close_ad != view.getId()) {
            f0();
            return;
        }
        int i4 = this.f47726c.i() / 1000;
        int min2 = Math.min(this.f47727d.A(), this.f47726c.j() / 1000);
        if (i4 >= min2) {
            c0();
            return;
        }
        int c2 = d.b.g0.g.k0.e.c.c();
        int b2 = d.b.g0.g.k0.e.c.b();
        if (d.b.g0.g.k0.e.c.f()) {
            min = (int) (c2 * 0.275f);
            i3 = (int) (b2 * 0.05f);
            i2 = min;
        } else {
            min = (int) (Math.min(c2, b2) * 0.1f);
            i2 = min;
            i3 = 0;
        }
        q0();
        d.b.g0.g.k0.e.b.a(b0(), "pageshow", a0());
        this.f47724a.getResources().getString(d.b.g0.e.a.i.swangame_game_ad_dialog_msg_more);
        if (this.F) {
            format = String.format(this.f47724a.getResources().getString(d.b.g0.e.a.i.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.f47726c.i() / 1000)));
        } else {
            format = String.format(this.f47724a.getResources().getString(d.b.g0.e.a.i.swangame_game_ad_video_close_alert), Integer.valueOf(min2 - i4));
        }
        this.n = true;
        g.a aVar = new g.a(activity);
        aVar.f(true);
        aVar.C(d.b.g0.e.a.i.ad_close, new d());
        aVar.y(format);
        aVar.O(d.b.g0.e.a.i.ad_continue_watch, new c());
        aVar.Q(d.b.g0.e.a.d.aiapps_game_continue_watch);
        aVar.M(new b());
        aVar.n(new d.b.g0.a.j2.g.a());
        aVar.s(min, 0, i2, i3);
        this.j = aVar.X();
    }

    public String b0() {
        return this.C ? "gdtvideo" : "video";
    }

    @Override // d.b.g0.e.a.m.b
    public void c(String str) {
        this.f47728e = PayBeanFactory.BEAN_ID_MODIFY_MOBILE_PWD;
        n0(this.f47731h, str);
        d.b.g0.g.k0.e.b.c(b0(), "fail", str);
    }

    public final void c0() {
        d.b.g0.a.b1.g.a aVar = this.f47726c;
        if (aVar == null || this.f47725b == null) {
            return;
        }
        if (aVar.o()) {
            this.f47726c.r();
            this.f47725b.x();
        }
        this.f47728e = 262;
        if (this.C) {
            d.b.g0.e.a.p.d.g(Y(this.f47727d.r()), this.f47727d, this.o);
        } else {
            d.b.g0.e.a.p.c.h(a0(), this.f47730g, this.f47727d, this.o);
        }
        if (this.f47725b != null) {
            if (this.f47726c.n()) {
                this.f47725b.y();
            } else {
                this.f47725b.z();
            }
        }
    }

    @Override // d.b.g0.e.a.m.d
    public void d(View view) {
        d.b.g0.g.k0.e.b.a(b0(), PrefetchEvent.STATE_CLICK, Z());
        if (this.C) {
            g0(view);
        }
    }

    public final void d0() {
        d.b.g0.a.b1.g.a aVar;
        if (this.m != null && (aVar = this.f47726c) != null) {
            this.m.b(this.f47726c.n() || this.f47726c.i() / 1000 >= Math.min(this.f47727d.A(), aVar.j() / 1000));
        }
        r0();
        if (!this.C && this.f47727d.h() == 2 && SwanAdDownloadState.DOWNLOADING == this.y) {
            this.A = null;
            d.b.g0.a.w0.a.d().a(this.f47724a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.A);
        }
        d.b.g0.e.a.p.c.i(this.f47727d, this.o);
        this.f47728e = PayBeanFactory.BEAN_ID_CREDIT_PAY;
        s0(null);
    }

    @Override // d.b.g0.e.a.m.a
    public void e(CommandType commandType, Uri uri) {
        String l = this.f47727d.l();
        String y = this.f47727d.y();
        int i2 = C0938h.f47740a[commandType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        this.v = L;
                        e0();
                    } else if (i2 == 6) {
                        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
                        if (W == null) {
                            Context context = this.f47724a;
                            if (context != null) {
                                d.b.g0.a.q1.b.f.d.e(context, d.b.g0.e.a.i.aiapps_open_fragment_failed_toast).C();
                                return;
                            }
                            return;
                        }
                        d.b.g0.a.e1.b c2 = d.b.g0.a.e1.b.c(l, l);
                        f.b i3 = W.i("adLanding");
                        i3.n(d.b.g0.a.e0.l.f.f44012g, d.b.g0.a.e0.l.f.i);
                        i3.k("adLanding", c2).b();
                    }
                } else if (this.t == null) {
                    return;
                } else {
                    if (j0(this.f47724a, y)) {
                        this.u = J;
                    }
                    String queryParameter = uri.getQueryParameter(P);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(N, this.u);
                        jSONObject.put(O, this.v);
                        this.t.b(queryParameter, jSONObject.toString());
                    } catch (JSONException unused) {
                    }
                }
            } else if (this.f47727d != null) {
                p0(this.f47724a, y);
            }
        } else if (this.f47727d.h() == 2) {
            e0();
        } else {
            h0();
        }
        d.b.g0.e.a.p.c.d(this.f47727d, this.o);
        d.b.g0.g.k0.e.b.a(b0(), PrefetchEvent.STATE_CLICK, Z());
    }

    public final void e0() {
        if (k0.C(this.f47724a, this.z.f45487b)) {
            this.u = J;
            p0(this.f47724a, this.z.f45487b);
            this.x.c("appinstallopen");
            return;
        }
        SwanAdDownloadState swanAdDownloadState = this.y;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START || swanAdDownloadState == SwanAdDownloadState.DELETED) {
            this.u = G;
            d.b.g0.a.w0.a.d().a(this.f47724a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.A);
        }
        if (this.y == SwanAdDownloadState.DOWNLOADING) {
            d.b.g0.a.w0.a.d().a(this.f47724a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.A);
        }
        if (this.y == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.v = M;
            d.b.g0.a.w0.a.d().a(this.f47724a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.A);
        }
        if (this.y == SwanAdDownloadState.DOWNLOAD_FAILED) {
            d.b.g0.a.w0.a.d().a(this.f47724a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.A);
        }
        if (this.y == SwanAdDownloadState.DOWNLOADED) {
            this.u = I;
            this.A.b();
            d.b.g0.a.w0.a.d().a(this.f47724a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.A);
        }
        if (this.y == SwanAdDownloadState.INSTALLED) {
            p0(this.f47724a, this.z.f45487b);
        }
    }

    @Override // d.b.g0.e.a.m.b
    public void f(AdElementInfo adElementInfo) {
        this.f47727d = adElementInfo;
        this.C = adElementInfo.K();
        this.f47728e = PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD;
        o0(this.f47731h);
        if (!this.C && this.f47727d.h() == 2) {
            k0();
        }
        d.b.g0.g.k0.e.b.b(b0(), "success");
    }

    public final void f0() {
        d.b.g0.g.k0.e.b.a(b0(), "pageclose", this.f47726c.j() / 1000);
        d0();
    }

    public final void g0(View view) {
        AdElementInfo adElementInfo;
        if (!this.C || (adElementInfo = this.f47727d) == null) {
            return;
        }
        d.b.g0.e.a.p.d.d(adElementInfo, this.o);
        d.b.g0.e.a.p.b bVar = new d.b.g0.e.a.p.b();
        bVar.f47669a = String.valueOf(h0.m(this.f47724a));
        bVar.f47670b = String.valueOf(h0.l(this.f47724a));
        bVar.f47671c = String.valueOf(h0.m(this.f47724a));
        bVar.f47672d = String.valueOf(h0.l(this.f47724a));
        bVar.f47673e = String.valueOf((int) view.getX());
        bVar.f47674f = String.valueOf((int) view.getY());
        bVar.f47675g = String.valueOf((int) view.getX());
        bVar.f47676h = String.valueOf((int) view.getY());
        if (this.f47727d.h() == 2) {
            d.b.g0.e.a.p.d.a(bVar, this.f47727d, this.o, this);
            return;
        }
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            Context context = this.f47724a;
            if (context != null) {
                d.b.g0.a.q1.b.f.d.e(context, d.b.g0.e.a.i.aiapps_open_fragment_failed_toast).C();
                return;
            }
            return;
        }
        AdElementInfo adElementInfo2 = this.f47727d;
        if (adElementInfo2 != null) {
            String c2 = d.b.g0.e.a.p.d.c(adElementInfo2.l(), bVar);
            d.b.g0.a.e1.b c3 = d.b.g0.a.e1.b.c(c2, c2);
            f.b i2 = W.i("adLanding");
            i2.n(d.b.g0.a.e0.l.f.f44012g, d.b.g0.a.e0.l.f.i);
            i2.k("adLanding", c3).b();
        }
    }

    public final void h0() {
        String l = this.f47727d.l();
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            Context context = this.f47724a;
            if (context != null) {
                d.b.g0.a.q1.b.f.d.e(context, d.b.g0.e.a.i.aiapps_open_fragment_failed_toast).C();
                return;
            }
            return;
        }
        JSONObject i2 = this.f47727d.i();
        d.b.g0.a.e1.b c2 = d.b.g0.a.e1.b.c(l, l);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(Q, i2);
        } catch (JSONException unused) {
        }
        c2.g(jSONObject.toString());
        f.b i3 = W.i("adLanding");
        i3.n(d.b.g0.a.e0.l.f.f44012g, d.b.g0.a.e0.l.f.i);
        i3.k("adLanding", c2).b();
    }

    public final void i0(l lVar, String str) {
        if (lVar != null) {
            lVar.b(str);
        }
        j jVar = this.m;
        if (jVar != null) {
            jVar.onError(str);
        }
        this.f47728e = PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK;
    }

    public final boolean j0(Context context, String str) {
        if (context != null) {
            try {
                if (context.getPackageManager() != null) {
                    context.getPackageManager().getPackageInfo(str, 0);
                    return true;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public final void k0() {
        this.x = new d.b.g0.a.q.b(this.f47724a, this.f47727d.i());
        this.A = new e();
        String l = this.f47727d.l();
        String y = this.f47727d.y();
        String str = this.w.get(y);
        if (str != null) {
            l = str;
        } else {
            this.w.put(y, l);
        }
        this.z = new d.b.g0.a.q.g.b.a(l, y, this.f47727d.G());
        this.B = false;
        d.b.g0.a.w0.a.d().a(this.f47724a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.A);
    }

    public final void l0() {
        this.t.i(this);
        if (d.b.g0.g.k0.e.c.f()) {
            this.f47725b = new d.b.g0.e.a.j(this.f47724a, this.f47727d, this.t);
        } else {
            this.f47725b = new d.b.g0.e.a.k(this.f47724a, this.f47727d, this.t);
        }
        if (this.C) {
            this.f47725b.D(this);
        }
        this.f47725b.C(this);
        d.b.g0.a.b1.g.a r = this.f47725b.r();
        this.f47726c = r;
        r.z(new f());
        if (this.f47729f == null) {
            g gVar = new g();
            this.f47729f = gVar;
            d.b.g0.g.k0.e.c.h(gVar);
        }
        this.f47725b.q().setAnimation(AnimationUtils.loadAnimation(this.f47724a, d.b.g0.e.a.c.ng_game_ad_open));
    }

    public final boolean m0() {
        AdElementInfo adElementInfo = this.f47727d;
        if (adElementInfo == null) {
            return true;
        }
        long u = adElementInfo.u() * 1000;
        if (u == 0) {
            u = 1740000;
        }
        return System.currentTimeMillis() - this.f47727d.p() >= u;
    }

    public final void n0(k kVar, String str) {
        j jVar = this.m;
        if (jVar != null) {
            jVar.onError(str);
        }
        if (kVar != null) {
            kVar.b(str);
        }
        d.b.g0.e.a.r.a.b().c(17, str);
    }

    public final void o0(k kVar) {
        j jVar = this.m;
        if (jVar != null) {
            jVar.a();
        }
        if (kVar != null) {
            kVar.c();
        }
        d.b.g0.e.a.r.a.b().c(16, "");
    }

    public final boolean p0(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0 && queryIntentActivities.iterator().next() != null) {
            String str2 = queryIntentActivities.iterator().next().activityInfo.name;
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(str, str2));
            intent2.setFlags(268435456);
            try {
                context.startActivity(intent2);
                return true;
            } catch (Exception unused) {
                d.b.g0.a.q1.b.f.d f2 = d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "打开失败");
                f2.k(3);
                f2.C();
            }
        } else {
            d.b.g0.a.q1.b.f.d f3 = d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "打开失败");
            f3.k(3);
            f3.C();
        }
        return false;
    }

    public final void q0() {
        d.b.g0.a.b1.g.a aVar = this.f47726c;
        if (aVar == null || this.f47725b == null || !aVar.o()) {
            return;
        }
        this.f47726c.r();
        this.f47725b.x();
        if (this.C) {
            d.b.g0.e.a.p.d.g(Y(a0()), this.f47727d, this.o);
        } else {
            d.b.g0.e.a.p.c.h(a0(), this.f47730g, this.f47727d, this.o);
        }
        this.f47730g = a0();
    }

    public final void r0() {
        d.b.g0.a.b1.g.a aVar = this.f47726c;
        if (aVar != null) {
            aVar.r();
            this.f47726c.onDestroy();
        }
        i iVar = this.p;
        if (iVar != null) {
            this.f47724a.unregisterReceiver(iVar);
            this.p = null;
        }
        d.b.g0.e.a.b bVar = this.f47725b;
        if (bVar != null) {
            bVar.n();
            this.f47725b.q().setAnimation(AnimationUtils.loadAnimation(this.f47724a, d.b.g0.e.a.c.ng_game_ad_close));
            d.b.g0.g.k0.e.c.i(this.f47725b.q());
        }
        d.b.g0.g.k0.a aVar2 = this.f47729f;
        if (aVar2 != null) {
            d.b.g0.g.k0.e.c.j(aVar2);
            this.f47729f = null;
        }
        d.b.g0.e.a.r.g gVar = this.E;
        if (gVar != null) {
            gVar.i();
            this.E = null;
        }
    }

    public synchronized void s0(d.b.g0.g.e.d.c cVar) {
        d.b.g0.e.a.o.d fVar;
        k d2 = k.d(cVar);
        if (this.f47728e == 257) {
            d.b.g0.e.a.r.a.b().a(d2);
            return;
        }
        if (this.f47728e != 261 && this.f47728e != 260 && this.f47728e != 265) {
            if (this.f47728e == 258) {
                if (m0()) {
                    this.f47728e = AuthorityState.STATE_INIT_ING;
                } else {
                    o0(d2);
                    return;
                }
            }
            if (this.f47728e == 259 || this.f47728e == 262 || this.f47728e == 263 || this.f47728e == 264 || this.f47728e == 256 || this.f47728e == 272) {
                d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
                String B = y != null ? y.B() : "";
                if (!TextUtils.isEmpty(B) && !TextUtils.isEmpty(this.l) && !TextUtils.isEmpty(this.k)) {
                    this.f47731h = d2;
                    this.f47728e = 257;
                    b.C0936b c0936b = new b.C0936b();
                    c0936b.l(this.l);
                    c0936b.i(this.k);
                    c0936b.m(B);
                    c0936b.k(h0.m(this.f47724a));
                    c0936b.h(h0.l(this.f47724a));
                    c0936b.j(1);
                    d.b.g0.e.a.o.b g2 = c0936b.g();
                    if (this.D) {
                        this.C = true;
                        fVar = new d.b.g0.e.a.o.e(this.f47724a, g2, 5, 5);
                        d.b.g0.g.k0.e.b.b("gdtvideo", null);
                    } else {
                        this.C = false;
                        fVar = new d.b.g0.e.a.o.f(this.f47724a, g2);
                        this.s = fVar.c();
                        d.b.g0.g.k0.e.b.b("video", null);
                    }
                    d.b.g0.e.a.o.a aVar = new d.b.g0.e.a.o.a(this.f47724a, this.C);
                    aVar.i(this);
                    aVar.h(fVar, this.o);
                }
                n0(d2, "3010007");
                return;
            }
            return;
        }
        n0(d2, "3010006");
    }

    public void t0(j jVar) {
        this.m = jVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x008c, code lost:
        r5.b("3010004");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void u0(d.b.g0.g.e.d.c cVar) {
        l d2 = l.d(cVar);
        if (this.f47728e != 261 && this.f47728e != 260 && this.f47728e != 265) {
            if (this.f47728e == 258 && !m0()) {
                if (this.f47727d != null && TextUtils.isEmpty(this.f47727d.I())) {
                    i0(d2, "3010008");
                    return;
                }
                if (this.f47728e == 258) {
                    this.f47728e = 265;
                    String t = this.f47727d != null ? this.f47727d.t() : "";
                    if (d.b.g0.g.k0.e.c.f() && (d.b.g0.g.k0.e.c.e() || !TextUtils.isEmpty(t))) {
                        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
                        if (activity != null) {
                            activity.setRequestedOrientation(1);
                        }
                        d.b.g0.a.z0.f.V().X().n(true);
                    }
                    k0.X(new a(d2));
                }
                return;
            }
            i0(d2, "3010004");
            return;
        }
        if (this.m != null) {
            this.m.onError("3010004");
        }
    }

    public final void v0(SwanAdDownloadState swanAdDownloadState) {
        this.y = swanAdDownloadState;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START) {
            this.u = H;
            this.v = M;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.u = G;
            this.v = L;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.u = I;
            this.v = M;
        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
            this.u = J;
            this.v = M;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
            this.u = G;
            this.v = M;
        }
    }
}
