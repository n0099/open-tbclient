package d.b.h0.e.a.r;

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
import com.alibaba.fastjson.asm.Label;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.mobads.container.widget.player.PlayerEvent;
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
import d.b.h0.a.e0.l.f;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.q1.b.b.g;
import d.b.h0.e.a.o.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h implements d.b.h0.e.a.m.b, d.b.h0.e.a.m.c, d.b.h0.e.a.m.a, d.b.h0.e.a.m.d {
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
    public d.b.h0.a.q.g.a.a A;
    public boolean B;
    public boolean C;
    public boolean D;
    public d.b.h0.e.a.r.g E;
    public boolean F;

    /* renamed from: a  reason: collision with root package name */
    public Context f48446a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.e.a.b f48447b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.a.b1.g.a f48448c;

    /* renamed from: d  reason: collision with root package name */
    public AdElementInfo f48449d;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.g.k0.a f48451f;

    /* renamed from: h  reason: collision with root package name */
    public k f48453h;
    public l i;
    public d.b.h0.a.q1.b.b.g j;
    public String k;
    public String l;
    public j m;
    public boolean n;
    public d.b.h0.e.a.r.b o;
    public i p;
    public boolean q;
    public String s;
    public d.b.h0.e.a.n.a t;
    public d.b.h0.a.q.b x;
    public d.b.h0.a.q.g.b.a z;

    /* renamed from: e  reason: collision with root package name */
    public int f48450e = 256;

    /* renamed from: g  reason: collision with root package name */
    public int f48452g = 0;
    public boolean r = true;
    public String u = H;
    public String v = M;
    public Map<String, String> w = new HashMap();
    public SwanAdDownloadState y = SwanAdDownloadState.NOT_START;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f48454e;

        public a(l lVar) {
            this.f48454e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.l0();
            if (d.b.h0.g.k0.e.c.g(h.this.f48447b.q())) {
                d.b.h0.g.k0.e.c.i(h.this.f48447b.q());
            }
            if (!d.b.h0.g.k0.e.c.a(h.this.f48447b.q(), d.b.h0.a.e1.d.a.a.b())) {
                h.this.i0(this.f48454e, "3010000");
                return;
            }
            h.this.i = this.f48454e;
            h.this.f48450e = 260;
            h.this.f48447b.E(h.this.f48449d.I());
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
            d.b.h0.g.k0.e.b.a(h.this.b0(), "continue", h.this.a0());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (!h.this.F || h.this.f48447b == null) {
                h.this.d0();
            } else {
                if (h.this.f48448c != null) {
                    h.this.f48448c.r();
                }
                if (h.this.p != null) {
                    h.this.f48446a.unregisterReceiver(h.this.p);
                    h.this.p = null;
                }
                h.this.f48450e = PlayerEvent.PLAY_LOADING_END;
                h.this.f48447b.z();
            }
            h.this.n = false;
            d.b.h0.g.k0.e.b.a(h.this.b0(), IntentConfig.CLOSE, h.this.a0());
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.h0.a.q.g.a.a {
        public e() {
        }

        @Override // d.b.h0.a.q.g.a.a
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

        @Override // d.b.h0.a.q.g.a.a
        public void b() {
            h.this.x.c("appinstallbegin");
        }

        @Override // d.b.h0.a.q.g.a.a
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

        @Override // d.b.h0.a.q.g.a.a
        public void d(String str) {
        }

        @Override // d.b.h0.a.q.g.a.a
        public String e() {
            h.this.x.c("appinstallopen");
            return "";
        }

        @Override // d.b.h0.a.q.g.a.a
        public void f(boolean z) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.h0.a.b1.g.b {
        public f() {
        }

        @Override // d.b.h0.a.b1.g.b
        public void a(d.b.h0.a.w0.c.j jVar) {
            if (h.this.f48447b != null) {
                h.this.f48447b.w();
            }
            h.this.f48450e = PlayerEvent.PLAY_LOADING_START;
            h.this.f48452g = 0;
            if (h.this.f48447b != null) {
                h.this.f48447b.o();
            }
            if (h.this.i != null) {
                h.this.i.c();
            }
            if (h.this.p == null) {
                h.this.p = new i(h.this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                h.this.f48446a.registerReceiver(h.this.p, intentFilter);
            }
            if (h.this.C) {
                d.b.h0.e.a.p.d.f(h.this.f48449d, h.this.o);
                return;
            }
            d.b.h0.e.a.p.c.g(h.this.f48449d, h.this.o);
            d.b.h0.e.a.p.c.j(h.this.f48449d, h.this.o);
            String str = h.this.l;
            h hVar = h.this;
            d.b.h0.e.a.p.c.c(str, hVar.k, hVar.s, h.this.o);
        }

        @Override // d.b.h0.a.b1.g.b
        public boolean b(d.b.h0.a.w0.c.j jVar, int i, int i2) {
            h.this.r0();
            h hVar = h.this;
            hVar.i0(hVar.i, "3010001");
            return true;
        }

        @Override // d.b.h0.a.b1.g.b
        public void c(d.b.h0.a.w0.c.j jVar) {
        }

        @Override // d.b.h0.a.b1.g.b
        public void d(d.b.h0.a.w0.c.j jVar) {
            h.this.c0();
        }

        @Override // d.b.h0.a.b1.g.b
        public void e(d.b.h0.a.w0.c.j jVar) {
        }

        @Override // d.b.h0.a.b1.g.b
        public void f(d.b.h0.a.w0.c.j jVar) {
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.b.h0.g.k0.a {
        public g() {
        }

        @Override // d.b.h0.g.k0.a
        public void f() {
            h.this.q = false;
            h.this.q0();
        }

        @Override // d.b.h0.g.k0.a
        public void k() {
        }

        @Override // d.b.h0.g.k0.a
        public void q() {
            h.this.q = true;
            if (h.this.r) {
                h.this.X();
            }
        }
    }

    /* renamed from: d.b.h0.e.a.r.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0971h {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f48462a;

        static {
            int[] iArr = new int[CommandType.values().length];
            f48462a = iArr;
            try {
                iArr[CommandType.ACTION_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48462a[CommandType.OPEN_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f48462a[CommandType.GET_DOWNLOAD_STATUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f48462a[CommandType.PAUSE_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f48462a[CommandType.UNSPECIFIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f48462a[CommandType.BANNER_VIEW.ordinal()] = 6;
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
            if (h.this.f48448c == null) {
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
        this.f48446a = appContext;
        this.l = str;
        this.k = str2;
        this.C = z;
        this.D = z;
        this.o = new d.b.h0.e.a.r.b(appContext);
        this.t = new d.b.h0.e.a.n.a();
        this.F = d.b.h0.e.a.q.f.i();
    }

    public final void X() {
        if (this.f48448c == null || this.f48447b == null) {
            return;
        }
        d.b.h0.a.q1.b.b.g gVar = this.j;
        if ((gVar != null && gVar.isShowing()) || this.f48448c.o() || this.f48447b.s()) {
            return;
        }
        this.f48448c.t();
        this.f48447b.B();
        d.b.h0.e.a.p.c.j(this.f48449d, this.o);
    }

    public final d.b.h0.e.a.p.b Y(int i2) {
        d.b.h0.e.a.p.b bVar = new d.b.h0.e.a.p.b();
        bVar.i = String.valueOf(this.f48449d.r());
        bVar.j = String.valueOf(this.f48452g);
        bVar.k = String.valueOf(i2);
        String str = "1";
        bVar.l = this.f48452g == 0 ? "1" : "0";
        bVar.m = i2 == this.f48449d.r() ? "1" : "0";
        int i3 = 1;
        bVar.n = this.f48446a.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        int i4 = this.f48452g;
        if (i4 != 0) {
            i3 = i4 == this.f48449d.r() ? 3 : 2;
        }
        bVar.o = String.valueOf(i3);
        bVar.p = (this.f48452g == 0 && SwanAppNetworkUtils.i(this.f48446a)) ? "2" : "2";
        bVar.q = String.valueOf(0);
        return bVar;
    }

    public final int Z() {
        d.b.h0.a.b1.g.a aVar = this.f48448c;
        if (aVar != null && aVar.n()) {
            return this.f48448c.j() / 1000;
        }
        return a0();
    }

    @Override // d.b.h0.e.a.m.d
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", str2);
            jSONObject.put("title", this.f48449d.G());
            jSONObject.put("description", this.f48449d.q());
            jSONObject.put("autoinstall", true);
            if (this.E == null) {
                this.E = new d.b.h0.e.a.r.g(this.f48446a, this.f48449d, this.o);
            }
            this.E.k(str);
            d.b.h0.a.w0.a.d().a(this.f48446a, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.E);
        } catch (JSONException e2) {
            if (d.b.h0.a.k.f45772a) {
                e2.printStackTrace();
            }
        }
    }

    public final int a0() {
        d.b.h0.a.b1.g.a aVar = this.f48448c;
        if (aVar != null) {
            return aVar.i() / 1000;
        }
        return 0;
    }

    @Override // d.b.h0.e.a.m.c
    public void b(View view) {
        SwanAppActivity activity;
        int min;
        int i2;
        int i3;
        String format;
        if (this.f48448c == null || this.f48449d == null || (activity = d.b.h0.a.z0.f.V().getActivity()) == null || this.n) {
            return;
        }
        if (view != null && d.b.h0.e.a.g.close_ad != view.getId()) {
            f0();
            return;
        }
        int i4 = this.f48448c.i() / 1000;
        int min2 = Math.min(this.f48449d.A(), this.f48448c.j() / 1000);
        if (i4 >= min2) {
            c0();
            return;
        }
        int c2 = d.b.h0.g.k0.e.c.c();
        int b2 = d.b.h0.g.k0.e.c.b();
        if (d.b.h0.g.k0.e.c.f()) {
            min = (int) (c2 * 0.275f);
            i3 = (int) (b2 * 0.05f);
            i2 = min;
        } else {
            min = (int) (Math.min(c2, b2) * 0.1f);
            i2 = min;
            i3 = 0;
        }
        q0();
        d.b.h0.g.k0.e.b.a(b0(), "pageshow", a0());
        this.f48446a.getResources().getString(d.b.h0.e.a.i.swangame_game_ad_dialog_msg_more);
        if (this.F) {
            format = String.format(this.f48446a.getResources().getString(d.b.h0.e.a.i.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.f48448c.i() / 1000)));
        } else {
            format = String.format(this.f48446a.getResources().getString(d.b.h0.e.a.i.swangame_game_ad_video_close_alert), Integer.valueOf(min2 - i4));
        }
        this.n = true;
        g.a aVar = new g.a(activity);
        aVar.f(true);
        aVar.C(d.b.h0.e.a.i.ad_close, new d());
        aVar.y(format);
        aVar.O(d.b.h0.e.a.i.ad_continue_watch, new c());
        aVar.Q(d.b.h0.e.a.d.aiapps_game_continue_watch);
        aVar.M(new b());
        aVar.n(new d.b.h0.a.j2.g.a());
        aVar.s(min, 0, i2, i3);
        this.j = aVar.X();
    }

    public String b0() {
        return this.C ? "gdtvideo" : "video";
    }

    @Override // d.b.h0.e.a.m.b
    public void c(String str) {
        this.f48450e = 259;
        n0(this.f48453h, str);
        d.b.h0.g.k0.e.b.c(b0(), "fail", str);
    }

    public final void c0() {
        d.b.h0.a.b1.g.a aVar = this.f48448c;
        if (aVar == null || this.f48447b == null) {
            return;
        }
        if (aVar.o()) {
            this.f48448c.r();
            this.f48447b.x();
        }
        this.f48450e = PlayerEvent.PLAY_LOADING_END;
        if (this.C) {
            d.b.h0.e.a.p.d.g(Y(this.f48449d.r()), this.f48449d, this.o);
        } else {
            d.b.h0.e.a.p.c.h(a0(), this.f48452g, this.f48449d, this.o);
        }
        if (this.f48447b != null) {
            if (this.f48448c.n()) {
                this.f48447b.y();
            } else {
                this.f48447b.z();
            }
        }
    }

    @Override // d.b.h0.e.a.m.d
    public void d(View view) {
        d.b.h0.g.k0.e.b.a(b0(), PrefetchEvent.STATE_CLICK, Z());
        if (this.C) {
            g0(view);
        }
    }

    public final void d0() {
        d.b.h0.a.b1.g.a aVar;
        if (this.m != null && (aVar = this.f48448c) != null) {
            this.m.b(this.f48448c.n() || this.f48448c.i() / 1000 >= Math.min(this.f48449d.A(), aVar.j() / 1000));
        }
        r0();
        if (!this.C && this.f48449d.h() == 2 && SwanAdDownloadState.DOWNLOADING == this.y) {
            this.A = null;
            d.b.h0.a.w0.a.d().a(this.f48446a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.A);
        }
        d.b.h0.e.a.p.c.i(this.f48449d, this.o);
        this.f48450e = PayBeanFactory.BEAN_ID_CREDIT_PAY;
        s0(null);
    }

    @Override // d.b.h0.e.a.m.a
    public void e(CommandType commandType, Uri uri) {
        String l = this.f48449d.l();
        String y = this.f48449d.y();
        int i2 = C0971h.f48462a[commandType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        this.v = L;
                        e0();
                    } else if (i2 == 6) {
                        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
                        if (W == null) {
                            Context context = this.f48446a;
                            if (context != null) {
                                d.b.h0.a.q1.b.f.d.e(context, d.b.h0.e.a.i.aiapps_open_fragment_failed_toast).C();
                                return;
                            }
                            return;
                        }
                        d.b.h0.a.e1.b c2 = d.b.h0.a.e1.b.c(l, l);
                        f.b i3 = W.i("adLanding");
                        i3.n(d.b.h0.a.e0.l.f.f44734g, d.b.h0.a.e0.l.f.i);
                        i3.k("adLanding", c2).b();
                    }
                } else if (this.t == null) {
                    return;
                } else {
                    if (j0(this.f48446a, y)) {
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
            } else if (this.f48449d != null) {
                p0(this.f48446a, y);
            }
        } else if (this.f48449d.h() == 2) {
            e0();
        } else {
            h0();
        }
        d.b.h0.e.a.p.c.d(this.f48449d, this.o);
        d.b.h0.g.k0.e.b.a(b0(), PrefetchEvent.STATE_CLICK, Z());
    }

    public final void e0() {
        if (k0.C(this.f48446a, this.z.f46209b)) {
            this.u = J;
            p0(this.f48446a, this.z.f46209b);
            this.x.c("appinstallopen");
            return;
        }
        SwanAdDownloadState swanAdDownloadState = this.y;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START || swanAdDownloadState == SwanAdDownloadState.DELETED) {
            this.u = G;
            d.b.h0.a.w0.a.d().a(this.f48446a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.A);
        }
        if (this.y == SwanAdDownloadState.DOWNLOADING) {
            d.b.h0.a.w0.a.d().a(this.f48446a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.A);
        }
        if (this.y == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.v = M;
            d.b.h0.a.w0.a.d().a(this.f48446a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.A);
        }
        if (this.y == SwanAdDownloadState.DOWNLOAD_FAILED) {
            d.b.h0.a.w0.a.d().a(this.f48446a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.A);
        }
        if (this.y == SwanAdDownloadState.DOWNLOADED) {
            this.u = I;
            this.A.b();
            d.b.h0.a.w0.a.d().a(this.f48446a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.A);
        }
        if (this.y == SwanAdDownloadState.INSTALLED) {
            p0(this.f48446a, this.z.f46209b);
        }
    }

    @Override // d.b.h0.e.a.m.b
    public void f(AdElementInfo adElementInfo) {
        this.f48449d = adElementInfo;
        this.C = adElementInfo.K();
        this.f48450e = 258;
        o0(this.f48453h);
        if (!this.C && this.f48449d.h() == 2) {
            k0();
        }
        d.b.h0.g.k0.e.b.b(b0(), "success");
    }

    public final void f0() {
        d.b.h0.g.k0.e.b.a(b0(), "pageclose", this.f48448c.j() / 1000);
        d0();
    }

    public final void g0(View view) {
        AdElementInfo adElementInfo;
        if (!this.C || (adElementInfo = this.f48449d) == null) {
            return;
        }
        d.b.h0.e.a.p.d.d(adElementInfo, this.o);
        d.b.h0.e.a.p.b bVar = new d.b.h0.e.a.p.b();
        bVar.f48391a = String.valueOf(h0.m(this.f48446a));
        bVar.f48392b = String.valueOf(h0.l(this.f48446a));
        bVar.f48393c = String.valueOf(h0.m(this.f48446a));
        bVar.f48394d = String.valueOf(h0.l(this.f48446a));
        bVar.f48395e = String.valueOf((int) view.getX());
        bVar.f48396f = String.valueOf((int) view.getY());
        bVar.f48397g = String.valueOf((int) view.getX());
        bVar.f48398h = String.valueOf((int) view.getY());
        if (this.f48449d.h() == 2) {
            d.b.h0.e.a.p.d.a(bVar, this.f48449d, this.o, this);
            return;
        }
        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
        if (W == null) {
            Context context = this.f48446a;
            if (context != null) {
                d.b.h0.a.q1.b.f.d.e(context, d.b.h0.e.a.i.aiapps_open_fragment_failed_toast).C();
                return;
            }
            return;
        }
        AdElementInfo adElementInfo2 = this.f48449d;
        if (adElementInfo2 != null) {
            String c2 = d.b.h0.e.a.p.d.c(adElementInfo2.l(), bVar);
            d.b.h0.a.e1.b c3 = d.b.h0.a.e1.b.c(c2, c2);
            f.b i2 = W.i("adLanding");
            i2.n(d.b.h0.a.e0.l.f.f44734g, d.b.h0.a.e0.l.f.i);
            i2.k("adLanding", c3).b();
        }
    }

    public final void h0() {
        String l = this.f48449d.l();
        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
        if (W == null) {
            Context context = this.f48446a;
            if (context != null) {
                d.b.h0.a.q1.b.f.d.e(context, d.b.h0.e.a.i.aiapps_open_fragment_failed_toast).C();
                return;
            }
            return;
        }
        JSONObject i2 = this.f48449d.i();
        d.b.h0.a.e1.b c2 = d.b.h0.a.e1.b.c(l, l);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(Q, i2);
        } catch (JSONException unused) {
        }
        c2.g(jSONObject.toString());
        f.b i3 = W.i("adLanding");
        i3.n(d.b.h0.a.e0.l.f.f44734g, d.b.h0.a.e0.l.f.i);
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
        this.f48450e = PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK;
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
        this.x = new d.b.h0.a.q.b(this.f48446a, this.f48449d.i());
        this.A = new e();
        String l = this.f48449d.l();
        String y = this.f48449d.y();
        String str = this.w.get(y);
        if (str != null) {
            l = str;
        } else {
            this.w.put(y, l);
        }
        this.z = new d.b.h0.a.q.g.b.a(l, y, this.f48449d.G());
        this.B = false;
        d.b.h0.a.w0.a.d().a(this.f48446a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.A);
    }

    public final void l0() {
        this.t.i(this);
        if (d.b.h0.g.k0.e.c.f()) {
            this.f48447b = new d.b.h0.e.a.j(this.f48446a, this.f48449d, this.t);
        } else {
            this.f48447b = new d.b.h0.e.a.k(this.f48446a, this.f48449d, this.t);
        }
        if (this.C) {
            this.f48447b.D(this);
        }
        this.f48447b.C(this);
        d.b.h0.a.b1.g.a r = this.f48447b.r();
        this.f48448c = r;
        r.z(new f());
        if (this.f48451f == null) {
            g gVar = new g();
            this.f48451f = gVar;
            d.b.h0.g.k0.e.c.h(gVar);
        }
        this.f48447b.q().setAnimation(AnimationUtils.loadAnimation(this.f48446a, d.b.h0.e.a.c.ng_game_ad_open));
    }

    public final boolean m0() {
        AdElementInfo adElementInfo = this.f48449d;
        if (adElementInfo == null) {
            return true;
        }
        long u = adElementInfo.u() * 1000;
        if (u == 0) {
            u = 1740000;
        }
        return System.currentTimeMillis() - this.f48449d.p() >= u;
    }

    public final void n0(k kVar, String str) {
        j jVar = this.m;
        if (jVar != null) {
            jVar.onError(str);
        }
        if (kVar != null) {
            kVar.b(str);
        }
        d.b.h0.e.a.r.a.b().c(17, str);
    }

    public final void o0(k kVar) {
        j jVar = this.m;
        if (jVar != null) {
            jVar.a();
        }
        if (kVar != null) {
            kVar.c();
        }
        d.b.h0.e.a.r.a.b().c(16, "");
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
            intent2.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            try {
                context.startActivity(intent2);
                return true;
            } catch (Exception unused) {
                d.b.h0.a.q1.b.f.d f2 = d.b.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "打开失败");
                f2.k(3);
                f2.C();
            }
        } else {
            d.b.h0.a.q1.b.f.d f3 = d.b.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "打开失败");
            f3.k(3);
            f3.C();
        }
        return false;
    }

    public final void q0() {
        d.b.h0.a.b1.g.a aVar = this.f48448c;
        if (aVar == null || this.f48447b == null || !aVar.o()) {
            return;
        }
        this.f48448c.r();
        this.f48447b.x();
        if (this.C) {
            d.b.h0.e.a.p.d.g(Y(a0()), this.f48449d, this.o);
        } else {
            d.b.h0.e.a.p.c.h(a0(), this.f48452g, this.f48449d, this.o);
        }
        this.f48452g = a0();
    }

    public final void r0() {
        d.b.h0.a.b1.g.a aVar = this.f48448c;
        if (aVar != null) {
            aVar.r();
            this.f48448c.onDestroy();
        }
        i iVar = this.p;
        if (iVar != null) {
            this.f48446a.unregisterReceiver(iVar);
            this.p = null;
        }
        d.b.h0.e.a.b bVar = this.f48447b;
        if (bVar != null) {
            bVar.n();
            this.f48447b.q().setAnimation(AnimationUtils.loadAnimation(this.f48446a, d.b.h0.e.a.c.ng_game_ad_close));
            d.b.h0.g.k0.e.c.i(this.f48447b.q());
        }
        d.b.h0.g.k0.a aVar2 = this.f48451f;
        if (aVar2 != null) {
            d.b.h0.g.k0.e.c.j(aVar2);
            this.f48451f = null;
        }
        d.b.h0.e.a.r.g gVar = this.E;
        if (gVar != null) {
            gVar.i();
            this.E = null;
        }
    }

    public synchronized void s0(d.b.h0.g.e.d.c cVar) {
        d.b.h0.e.a.o.d fVar;
        k d2 = k.d(cVar);
        if (this.f48450e == 257) {
            d.b.h0.e.a.r.a.b().a(d2);
            return;
        }
        if (this.f48450e != 261 && this.f48450e != 260 && this.f48450e != 265) {
            if (this.f48450e == 258) {
                if (m0()) {
                    this.f48450e = AuthorityState.STATE_INIT_ING;
                } else {
                    o0(d2);
                    return;
                }
            }
            if (this.f48450e == 259 || this.f48450e == 262 || this.f48450e == 263 || this.f48450e == 264 || this.f48450e == 256 || this.f48450e == 272) {
                d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
                String B = y != null ? y.B() : "";
                if (!TextUtils.isEmpty(B) && !TextUtils.isEmpty(this.l) && !TextUtils.isEmpty(this.k)) {
                    this.f48453h = d2;
                    this.f48450e = 257;
                    b.C0969b c0969b = new b.C0969b();
                    c0969b.l(this.l);
                    c0969b.i(this.k);
                    c0969b.m(B);
                    c0969b.k(h0.m(this.f48446a));
                    c0969b.h(h0.l(this.f48446a));
                    c0969b.j(1);
                    d.b.h0.e.a.o.b g2 = c0969b.g();
                    if (this.D) {
                        this.C = true;
                        fVar = new d.b.h0.e.a.o.e(this.f48446a, g2, 5, 5);
                        d.b.h0.g.k0.e.b.b("gdtvideo", null);
                    } else {
                        this.C = false;
                        fVar = new d.b.h0.e.a.o.f(this.f48446a, g2);
                        this.s = fVar.c();
                        d.b.h0.g.k0.e.b.b("video", null);
                    }
                    d.b.h0.e.a.o.a aVar = new d.b.h0.e.a.o.a(this.f48446a, this.C);
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
    public synchronized void u0(d.b.h0.g.e.d.c cVar) {
        l d2 = l.d(cVar);
        if (this.f48450e != 261 && this.f48450e != 260 && this.f48450e != 265) {
            if (this.f48450e == 258 && !m0()) {
                if (this.f48449d != null && TextUtils.isEmpty(this.f48449d.I())) {
                    i0(d2, "3010008");
                    return;
                }
                if (this.f48450e == 258) {
                    this.f48450e = 265;
                    String t = this.f48449d != null ? this.f48449d.t() : "";
                    if (d.b.h0.g.k0.e.c.f() && (d.b.h0.g.k0.e.c.e() || !TextUtils.isEmpty(t))) {
                        SwanAppActivity activity = d.b.h0.a.z0.f.V().getActivity();
                        if (activity != null) {
                            activity.setRequestedOrientation(1);
                        }
                        d.b.h0.a.z0.f.V().X().n(true);
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
