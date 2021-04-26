package d.a.h0.e.a.r;

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
import d.a.h0.a.e0.l.f;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.e.a.o.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h implements d.a.h0.e.a.m.b, d.a.h0.e.a.m.c, d.a.h0.e.a.m.a, d.a.h0.e.a.m.d {
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
    public d.a.h0.a.q.g.a.a A;
    public boolean B;
    public boolean C;
    public boolean D;
    public d.a.h0.e.a.r.g E;
    public boolean F;

    /* renamed from: a  reason: collision with root package name */
    public Context f45905a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.e.a.b f45906b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.a.b1.g.a f45907c;

    /* renamed from: d  reason: collision with root package name */
    public AdElementInfo f45908d;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.g.k0.a f45910f;

    /* renamed from: h  reason: collision with root package name */
    public k f45912h;

    /* renamed from: i  reason: collision with root package name */
    public l f45913i;
    public d.a.h0.a.q1.b.b.g j;
    public String k;
    public String l;
    public j m;
    public boolean n;
    public d.a.h0.e.a.r.b o;
    public i p;
    public boolean q;
    public String s;
    public d.a.h0.e.a.n.a t;
    public d.a.h0.a.q.b x;
    public d.a.h0.a.q.g.b.a z;

    /* renamed from: e  reason: collision with root package name */
    public int f45909e = 256;

    /* renamed from: g  reason: collision with root package name */
    public int f45911g = 0;
    public boolean r = true;
    public String u = H;
    public String v = M;
    public Map<String, String> w = new HashMap();
    public SwanAdDownloadState y = SwanAdDownloadState.NOT_START;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f45914e;

        public a(l lVar) {
            this.f45914e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.l0();
            if (d.a.h0.g.k0.e.c.g(h.this.f45906b.q())) {
                d.a.h0.g.k0.e.c.i(h.this.f45906b.q());
            }
            if (!d.a.h0.g.k0.e.c.a(h.this.f45906b.q(), d.a.h0.a.e1.d.a.a.b())) {
                h.this.i0(this.f45914e, "3010000");
                return;
            }
            h.this.f45913i = this.f45914e;
            h.this.f45909e = 260;
            h.this.f45906b.E(h.this.f45908d.I());
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
        public void onClick(DialogInterface dialogInterface, int i2) {
            h.this.X();
            h.this.n = false;
            d.a.h0.g.k0.e.b.a(h.this.b0(), "continue", h.this.a0());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (!h.this.F || h.this.f45906b == null) {
                h.this.d0();
            } else {
                if (h.this.f45907c != null) {
                    h.this.f45907c.r();
                }
                if (h.this.p != null) {
                    h.this.f45905a.unregisterReceiver(h.this.p);
                    h.this.p = null;
                }
                h.this.f45909e = PlayerEvent.PLAY_LOADING_END;
                h.this.f45906b.z();
            }
            h.this.n = false;
            d.a.h0.g.k0.e.b.a(h.this.b0(), IntentConfig.CLOSE, h.this.a0());
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.h0.a.q.g.a.a {
        public e() {
        }

        @Override // d.a.h0.a.q.g.a.a
        public void a() {
            h.this.x.c("appinstallbegin");
        }

        @Override // d.a.h0.a.q.g.a.a
        public void b(SwanAdDownloadState swanAdDownloadState, int i2) {
            if (i2 == 0) {
                return;
            }
            if (i2 != 100 || h.this.u == h.H) {
                if (h.this.u == h.H || h.this.u == h.K) {
                    return;
                }
                h.this.u = String.valueOf(i2);
                return;
            }
            h.this.u = h.I;
        }

        @Override // d.a.h0.a.q.g.a.a
        public void c(SwanAdDownloadState swanAdDownloadState, int i2) {
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

        @Override // d.a.h0.a.q.g.a.a
        public void d(String str) {
        }

        @Override // d.a.h0.a.q.g.a.a
        public String e() {
            h.this.x.c("appinstallopen");
            return "";
        }

        @Override // d.a.h0.a.q.g.a.a
        public void f(boolean z) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.h0.a.b1.g.b {
        public f() {
        }

        @Override // d.a.h0.a.b1.g.b
        public void a(d.a.h0.a.w0.c.j jVar) {
        }

        @Override // d.a.h0.a.b1.g.b
        public void b(d.a.h0.a.w0.c.j jVar) {
            h.this.c0();
        }

        @Override // d.a.h0.a.b1.g.b
        public void c(d.a.h0.a.w0.c.j jVar) {
        }

        @Override // d.a.h0.a.b1.g.b
        public void d(d.a.h0.a.w0.c.j jVar) {
        }

        @Override // d.a.h0.a.b1.g.b
        public void e(d.a.h0.a.w0.c.j jVar) {
            if (h.this.f45906b != null) {
                h.this.f45906b.w();
            }
            h.this.f45909e = PlayerEvent.PLAY_LOADING_START;
            h.this.f45911g = 0;
            if (h.this.f45906b != null) {
                h.this.f45906b.o();
            }
            if (h.this.f45913i != null) {
                h.this.f45913i.c();
            }
            if (h.this.p == null) {
                h.this.p = new i(h.this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                h.this.f45905a.registerReceiver(h.this.p, intentFilter);
            }
            if (h.this.C) {
                d.a.h0.e.a.p.d.f(h.this.f45908d, h.this.o);
                return;
            }
            d.a.h0.e.a.p.c.g(h.this.f45908d, h.this.o);
            d.a.h0.e.a.p.c.j(h.this.f45908d, h.this.o);
            String str = h.this.l;
            h hVar = h.this;
            d.a.h0.e.a.p.c.c(str, hVar.k, hVar.s, h.this.o);
        }

        @Override // d.a.h0.a.b1.g.b
        public boolean f(d.a.h0.a.w0.c.j jVar, int i2, int i3) {
            h.this.r0();
            h hVar = h.this;
            hVar.i0(hVar.f45913i, "3010001");
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.h0.g.k0.a {
        public g() {
        }

        @Override // d.a.h0.g.k0.a
        public void f() {
            h.this.q = false;
            h.this.q0();
        }

        @Override // d.a.h0.g.k0.a
        public void j() {
        }

        @Override // d.a.h0.g.k0.a
        public void m() {
            h.this.q = true;
            if (h.this.r) {
                h.this.X();
            }
        }
    }

    /* renamed from: d.a.h0.e.a.r.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0910h {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45922a;

        static {
            int[] iArr = new int[CommandType.values().length];
            f45922a = iArr;
            try {
                iArr[CommandType.ACTION_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45922a[CommandType.OPEN_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45922a[CommandType.GET_DOWNLOAD_STATUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45922a[CommandType.PAUSE_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45922a[CommandType.UNSPECIFIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45922a[CommandType.BANNER_VIEW.ordinal()] = 6;
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
            if (h.this.f45907c == null) {
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
        this.f45905a = appContext;
        this.l = str;
        this.k = str2;
        this.C = z;
        this.D = z;
        this.o = new d.a.h0.e.a.r.b(appContext);
        this.t = new d.a.h0.e.a.n.a();
        this.F = d.a.h0.e.a.q.f.i();
    }

    public final void X() {
        if (this.f45907c == null || this.f45906b == null) {
            return;
        }
        d.a.h0.a.q1.b.b.g gVar = this.j;
        if ((gVar != null && gVar.isShowing()) || this.f45907c.o() || this.f45906b.s()) {
            return;
        }
        this.f45907c.t();
        this.f45906b.B();
        d.a.h0.e.a.p.c.j(this.f45908d, this.o);
    }

    public final d.a.h0.e.a.p.b Y(int i2) {
        d.a.h0.e.a.p.b bVar = new d.a.h0.e.a.p.b();
        bVar.f45854i = String.valueOf(this.f45908d.r());
        bVar.j = String.valueOf(this.f45911g);
        bVar.k = String.valueOf(i2);
        String str = "1";
        bVar.l = this.f45911g == 0 ? "1" : "0";
        bVar.m = i2 == this.f45908d.r() ? "1" : "0";
        int i3 = 1;
        bVar.n = this.f45905a.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        int i4 = this.f45911g;
        if (i4 != 0) {
            i3 = i4 == this.f45908d.r() ? 3 : 2;
        }
        bVar.o = String.valueOf(i3);
        bVar.p = (this.f45911g == 0 && SwanAppNetworkUtils.i(this.f45905a)) ? "2" : "2";
        bVar.q = String.valueOf(0);
        return bVar;
    }

    public final int Z() {
        d.a.h0.a.b1.g.a aVar = this.f45907c;
        if (aVar != null && aVar.n()) {
            return this.f45907c.j() / 1000;
        }
        return a0();
    }

    @Override // d.a.h0.e.a.m.b
    public void a(String str) {
        this.f45909e = 259;
        n0(this.f45912h, str);
        d.a.h0.g.k0.e.b.c(b0(), "fail", str);
    }

    public final int a0() {
        d.a.h0.a.b1.g.a aVar = this.f45907c;
        if (aVar != null) {
            return aVar.i() / 1000;
        }
        return 0;
    }

    @Override // d.a.h0.e.a.m.a
    public void b(CommandType commandType, Uri uri) {
        String l = this.f45908d.l();
        String y = this.f45908d.y();
        int i2 = C0910h.f45922a[commandType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        this.v = L;
                        e0();
                    } else if (i2 == 6) {
                        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
                        if (W == null) {
                            Context context = this.f45905a;
                            if (context != null) {
                                d.a.h0.a.q1.b.f.d.e(context, d.a.h0.e.a.i.aiapps_open_fragment_failed_toast).C();
                                return;
                            }
                            return;
                        }
                        d.a.h0.a.e1.b c2 = d.a.h0.a.e1.b.c(l, l);
                        f.b i3 = W.i("adLanding");
                        i3.n(d.a.h0.a.e0.l.f.f42031g, d.a.h0.a.e0.l.f.f42033i);
                        i3.k("adLanding", c2).b();
                    }
                } else if (this.t == null) {
                    return;
                } else {
                    if (j0(this.f45905a, y)) {
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
            } else if (this.f45908d != null) {
                p0(this.f45905a, y);
            }
        } else if (this.f45908d.h() == 2) {
            e0();
        } else {
            h0();
        }
        d.a.h0.e.a.p.c.d(this.f45908d, this.o);
        d.a.h0.g.k0.e.b.a(b0(), PrefetchEvent.STATE_CLICK, Z());
    }

    public String b0() {
        return this.C ? "gdtvideo" : "video";
    }

    @Override // d.a.h0.e.a.m.b
    public void c(AdElementInfo adElementInfo) {
        this.f45908d = adElementInfo;
        this.C = adElementInfo.K();
        this.f45909e = 258;
        o0(this.f45912h);
        if (!this.C && this.f45908d.h() == 2) {
            k0();
        }
        d.a.h0.g.k0.e.b.b(b0(), "success");
    }

    public final void c0() {
        d.a.h0.a.b1.g.a aVar = this.f45907c;
        if (aVar == null || this.f45906b == null) {
            return;
        }
        if (aVar.o()) {
            this.f45907c.r();
            this.f45906b.x();
        }
        this.f45909e = PlayerEvent.PLAY_LOADING_END;
        if (this.C) {
            d.a.h0.e.a.p.d.g(Y(this.f45908d.r()), this.f45908d, this.o);
        } else {
            d.a.h0.e.a.p.c.h(a0(), this.f45911g, this.f45908d, this.o);
        }
        if (this.f45906b != null) {
            if (this.f45907c.n()) {
                this.f45906b.y();
            } else {
                this.f45906b.z();
            }
        }
    }

    @Override // d.a.h0.e.a.m.d
    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", str2);
            jSONObject.put("title", this.f45908d.G());
            jSONObject.put("description", this.f45908d.q());
            jSONObject.put("autoinstall", true);
            if (this.E == null) {
                this.E = new d.a.h0.e.a.r.g(this.f45905a, this.f45908d, this.o);
            }
            this.E.k(str);
            d.a.h0.a.w0.a.d().a(this.f45905a, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.E);
        } catch (JSONException e2) {
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
            }
        }
    }

    public final void d0() {
        d.a.h0.a.b1.g.a aVar;
        if (this.m != null && (aVar = this.f45907c) != null) {
            this.m.b(this.f45907c.n() || this.f45907c.i() / 1000 >= Math.min(this.f45908d.A(), aVar.j() / 1000));
        }
        r0();
        if (!this.C && this.f45908d.h() == 2 && SwanAdDownloadState.DOWNLOADING == this.y) {
            this.A = null;
            d.a.h0.a.w0.a.d().a(this.f45905a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.A);
        }
        d.a.h0.e.a.p.c.i(this.f45908d, this.o);
        this.f45909e = PayBeanFactory.BEAN_ID_CREDIT_PAY;
        s0(null);
    }

    @Override // d.a.h0.e.a.m.c
    public void e(View view) {
        SwanAppActivity activity;
        int min;
        int i2;
        int i3;
        String format;
        if (this.f45907c == null || this.f45908d == null || (activity = d.a.h0.a.z0.f.V().getActivity()) == null || this.n) {
            return;
        }
        if (view != null && d.a.h0.e.a.g.close_ad != view.getId()) {
            f0();
            return;
        }
        int i4 = this.f45907c.i() / 1000;
        int min2 = Math.min(this.f45908d.A(), this.f45907c.j() / 1000);
        if (i4 >= min2) {
            c0();
            return;
        }
        int c2 = d.a.h0.g.k0.e.c.c();
        int b2 = d.a.h0.g.k0.e.c.b();
        if (d.a.h0.g.k0.e.c.f()) {
            min = (int) (c2 * 0.275f);
            i3 = (int) (b2 * 0.05f);
            i2 = min;
        } else {
            min = (int) (Math.min(c2, b2) * 0.1f);
            i2 = min;
            i3 = 0;
        }
        q0();
        d.a.h0.g.k0.e.b.a(b0(), "pageshow", a0());
        this.f45905a.getResources().getString(d.a.h0.e.a.i.swangame_game_ad_dialog_msg_more);
        if (this.F) {
            format = String.format(this.f45905a.getResources().getString(d.a.h0.e.a.i.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.f45907c.i() / 1000)));
        } else {
            format = String.format(this.f45905a.getResources().getString(d.a.h0.e.a.i.swangame_game_ad_video_close_alert), Integer.valueOf(min2 - i4));
        }
        this.n = true;
        g.a aVar = new g.a(activity);
        aVar.f(true);
        aVar.C(d.a.h0.e.a.i.ad_close, new d());
        aVar.y(format);
        aVar.O(d.a.h0.e.a.i.ad_continue_watch, new c());
        aVar.Q(d.a.h0.e.a.d.aiapps_game_continue_watch);
        aVar.M(new b());
        aVar.n(new d.a.h0.a.j2.g.a());
        aVar.s(min, 0, i2, i3);
        this.j = aVar.X();
    }

    public final void e0() {
        if (k0.C(this.f45905a, this.z.f43557b)) {
            this.u = J;
            p0(this.f45905a, this.z.f43557b);
            this.x.c("appinstallopen");
            return;
        }
        SwanAdDownloadState swanAdDownloadState = this.y;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START || swanAdDownloadState == SwanAdDownloadState.DELETED) {
            this.u = G;
            d.a.h0.a.w0.a.d().a(this.f45905a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.A);
        }
        if (this.y == SwanAdDownloadState.DOWNLOADING) {
            d.a.h0.a.w0.a.d().a(this.f45905a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.A);
        }
        if (this.y == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.v = M;
            d.a.h0.a.w0.a.d().a(this.f45905a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.A);
        }
        if (this.y == SwanAdDownloadState.DOWNLOAD_FAILED) {
            d.a.h0.a.w0.a.d().a(this.f45905a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.A);
        }
        if (this.y == SwanAdDownloadState.DOWNLOADED) {
            this.u = I;
            this.A.a();
            d.a.h0.a.w0.a.d().a(this.f45905a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.A);
        }
        if (this.y == SwanAdDownloadState.INSTALLED) {
            p0(this.f45905a, this.z.f43557b);
        }
    }

    @Override // d.a.h0.e.a.m.d
    public void f(View view) {
        d.a.h0.g.k0.e.b.a(b0(), PrefetchEvent.STATE_CLICK, Z());
        if (this.C) {
            g0(view);
        }
    }

    public final void f0() {
        d.a.h0.g.k0.e.b.a(b0(), "pageclose", this.f45907c.j() / 1000);
        d0();
    }

    public final void g0(View view) {
        AdElementInfo adElementInfo;
        if (!this.C || (adElementInfo = this.f45908d) == null) {
            return;
        }
        d.a.h0.e.a.p.d.d(adElementInfo, this.o);
        d.a.h0.e.a.p.b bVar = new d.a.h0.e.a.p.b();
        bVar.f45846a = String.valueOf(h0.m(this.f45905a));
        bVar.f45847b = String.valueOf(h0.l(this.f45905a));
        bVar.f45848c = String.valueOf(h0.m(this.f45905a));
        bVar.f45849d = String.valueOf(h0.l(this.f45905a));
        bVar.f45850e = String.valueOf((int) view.getX());
        bVar.f45851f = String.valueOf((int) view.getY());
        bVar.f45852g = String.valueOf((int) view.getX());
        bVar.f45853h = String.valueOf((int) view.getY());
        if (this.f45908d.h() == 2) {
            d.a.h0.e.a.p.d.a(bVar, this.f45908d, this.o, this);
            return;
        }
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            Context context = this.f45905a;
            if (context != null) {
                d.a.h0.a.q1.b.f.d.e(context, d.a.h0.e.a.i.aiapps_open_fragment_failed_toast).C();
                return;
            }
            return;
        }
        AdElementInfo adElementInfo2 = this.f45908d;
        if (adElementInfo2 != null) {
            String c2 = d.a.h0.e.a.p.d.c(adElementInfo2.l(), bVar);
            d.a.h0.a.e1.b c3 = d.a.h0.a.e1.b.c(c2, c2);
            f.b i2 = W.i("adLanding");
            i2.n(d.a.h0.a.e0.l.f.f42031g, d.a.h0.a.e0.l.f.f42033i);
            i2.k("adLanding", c3).b();
        }
    }

    public final void h0() {
        String l = this.f45908d.l();
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            Context context = this.f45905a;
            if (context != null) {
                d.a.h0.a.q1.b.f.d.e(context, d.a.h0.e.a.i.aiapps_open_fragment_failed_toast).C();
                return;
            }
            return;
        }
        JSONObject i2 = this.f45908d.i();
        d.a.h0.a.e1.b c2 = d.a.h0.a.e1.b.c(l, l);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(Q, i2);
        } catch (JSONException unused) {
        }
        c2.g(jSONObject.toString());
        f.b i3 = W.i("adLanding");
        i3.n(d.a.h0.a.e0.l.f.f42031g, d.a.h0.a.e0.l.f.f42033i);
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
        this.f45909e = PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK;
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
        this.x = new d.a.h0.a.q.b(this.f45905a, this.f45908d.i());
        this.A = new e();
        String l = this.f45908d.l();
        String y = this.f45908d.y();
        String str = this.w.get(y);
        if (str != null) {
            l = str;
        } else {
            this.w.put(y, l);
        }
        this.z = new d.a.h0.a.q.g.b.a(l, y, this.f45908d.G());
        this.B = false;
        d.a.h0.a.w0.a.d().a(this.f45905a, this.z.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.A);
    }

    public final void l0() {
        this.t.i(this);
        if (d.a.h0.g.k0.e.c.f()) {
            this.f45906b = new d.a.h0.e.a.j(this.f45905a, this.f45908d, this.t);
        } else {
            this.f45906b = new d.a.h0.e.a.k(this.f45905a, this.f45908d, this.t);
        }
        if (this.C) {
            this.f45906b.D(this);
        }
        this.f45906b.C(this);
        d.a.h0.a.b1.g.a r = this.f45906b.r();
        this.f45907c = r;
        r.z(new f());
        if (this.f45910f == null) {
            g gVar = new g();
            this.f45910f = gVar;
            d.a.h0.g.k0.e.c.h(gVar);
        }
        this.f45906b.q().setAnimation(AnimationUtils.loadAnimation(this.f45905a, d.a.h0.e.a.c.ng_game_ad_open));
    }

    public final boolean m0() {
        AdElementInfo adElementInfo = this.f45908d;
        if (adElementInfo == null) {
            return true;
        }
        long u = adElementInfo.u() * 1000;
        if (u == 0) {
            u = 1740000;
        }
        return System.currentTimeMillis() - this.f45908d.p() >= u;
    }

    public final void n0(k kVar, String str) {
        j jVar = this.m;
        if (jVar != null) {
            jVar.onError(str);
        }
        if (kVar != null) {
            kVar.b(str);
        }
        d.a.h0.e.a.r.a.b().c(17, str);
    }

    public final void o0(k kVar) {
        j jVar = this.m;
        if (jVar != null) {
            jVar.a();
        }
        if (kVar != null) {
            kVar.c();
        }
        d.a.h0.e.a.r.a.b().c(16, "");
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
                d.a.h0.a.q1.b.f.d f2 = d.a.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "打开失败");
                f2.k(3);
                f2.C();
            }
        } else {
            d.a.h0.a.q1.b.f.d f3 = d.a.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "打开失败");
            f3.k(3);
            f3.C();
        }
        return false;
    }

    public final void q0() {
        d.a.h0.a.b1.g.a aVar = this.f45907c;
        if (aVar == null || this.f45906b == null || !aVar.o()) {
            return;
        }
        this.f45907c.r();
        this.f45906b.x();
        if (this.C) {
            d.a.h0.e.a.p.d.g(Y(a0()), this.f45908d, this.o);
        } else {
            d.a.h0.e.a.p.c.h(a0(), this.f45911g, this.f45908d, this.o);
        }
        this.f45911g = a0();
    }

    public final void r0() {
        d.a.h0.a.b1.g.a aVar = this.f45907c;
        if (aVar != null) {
            aVar.r();
            this.f45907c.onDestroy();
        }
        i iVar = this.p;
        if (iVar != null) {
            this.f45905a.unregisterReceiver(iVar);
            this.p = null;
        }
        d.a.h0.e.a.b bVar = this.f45906b;
        if (bVar != null) {
            bVar.n();
            this.f45906b.q().setAnimation(AnimationUtils.loadAnimation(this.f45905a, d.a.h0.e.a.c.ng_game_ad_close));
            d.a.h0.g.k0.e.c.i(this.f45906b.q());
        }
        d.a.h0.g.k0.a aVar2 = this.f45910f;
        if (aVar2 != null) {
            d.a.h0.g.k0.e.c.j(aVar2);
            this.f45910f = null;
        }
        d.a.h0.e.a.r.g gVar = this.E;
        if (gVar != null) {
            gVar.i();
            this.E = null;
        }
    }

    public synchronized void s0(d.a.h0.g.e.d.c cVar) {
        d.a.h0.e.a.o.d fVar;
        k d2 = k.d(cVar);
        if (this.f45909e == 257) {
            d.a.h0.e.a.r.a.b().a(d2);
            return;
        }
        if (this.f45909e != 261 && this.f45909e != 260 && this.f45909e != 265) {
            if (this.f45909e == 258) {
                if (m0()) {
                    this.f45909e = AuthorityState.STATE_INIT_ING;
                } else {
                    o0(d2);
                    return;
                }
            }
            if (this.f45909e == 259 || this.f45909e == 262 || this.f45909e == 263 || this.f45909e == 264 || this.f45909e == 256 || this.f45909e == 272) {
                d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
                String B = h2 != null ? h2.B() : "";
                if (!TextUtils.isEmpty(B) && !TextUtils.isEmpty(this.l) && !TextUtils.isEmpty(this.k)) {
                    this.f45912h = d2;
                    this.f45909e = 257;
                    b.C0908b c0908b = new b.C0908b();
                    c0908b.l(this.l);
                    c0908b.i(this.k);
                    c0908b.m(B);
                    c0908b.k(h0.m(this.f45905a));
                    c0908b.h(h0.l(this.f45905a));
                    c0908b.j(1);
                    d.a.h0.e.a.o.b g2 = c0908b.g();
                    if (this.D) {
                        this.C = true;
                        fVar = new d.a.h0.e.a.o.e(this.f45905a, g2, 5, 5);
                        d.a.h0.g.k0.e.b.b("gdtvideo", null);
                    } else {
                        this.C = false;
                        fVar = new d.a.h0.e.a.o.f(this.f45905a, g2);
                        this.s = fVar.c();
                        d.a.h0.g.k0.e.b.b("video", null);
                    }
                    d.a.h0.e.a.o.a aVar = new d.a.h0.e.a.o.a(this.f45905a, this.C);
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
    public synchronized void u0(d.a.h0.g.e.d.c cVar) {
        l d2 = l.d(cVar);
        if (this.f45909e != 261 && this.f45909e != 260 && this.f45909e != 265) {
            if (this.f45909e == 258 && !m0()) {
                if (this.f45908d != null && TextUtils.isEmpty(this.f45908d.I())) {
                    i0(d2, "3010008");
                    return;
                }
                if (this.f45909e == 258) {
                    this.f45909e = 265;
                    String t = this.f45908d != null ? this.f45908d.t() : "";
                    if (d.a.h0.g.k0.e.c.f() && (d.a.h0.g.k0.e.c.e() || !TextUtils.isEmpty(t))) {
                        SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
                        if (activity != null) {
                            activity.setRequestedOrientation(1);
                        }
                        d.a.h0.a.z0.f.V().X().n(true);
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
