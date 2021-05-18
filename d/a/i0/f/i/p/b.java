package d.a.i0.f.i.p;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.mobads.container.widget.player.PlayerEvent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import d.a.i0.f.i.j.a;
import d.a.i0.f.i.o.c;
import d.a.i0.f.i.r.h;
import d.a.i0.f.i.r.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d.a.i0.f.i.l.b, d.a.i0.f.i.l.c, d.a.i0.f.i.l.a, d.a.i0.f.i.l.d {
    public static String E = "0";
    public static String F = "101";
    public static String G = "102";
    public static String H = "103";
    public static String I = "104";
    public static String J = "1";
    public static String K = "0";
    public static String L = "status";
    public static String M = "isPaused";
    public static String N = "token";
    public d.a.i0.f.i.k.b C;
    public Activity D;

    /* renamed from: a  reason: collision with root package name */
    public Context f46624a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.f.i.s.a f46625b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.f.i.m.b.c f46626c;

    /* renamed from: d  reason: collision with root package name */
    public AdElementInfo f46627d;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.f.i.j.a f46630g;

    /* renamed from: h  reason: collision with root package name */
    public String f46631h;

    /* renamed from: i  reason: collision with root package name */
    public String f46632i;
    public d.a.i0.f.i.p.a j;
    public d.a.i0.f.i.o.b k;
    public String l;
    public d.a.i0.f.i.n.a m;
    public d.a.i0.f.i.q.c q;
    public DownloadParams s;
    public d.a.i0.f.i.k.f.a t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public d.a.i0.f.i.l.f y;
    public boolean z;

    /* renamed from: e  reason: collision with root package name */
    public int f46628e = 256;

    /* renamed from: f  reason: collision with root package name */
    public int f46629f = 0;
    public String n = F;
    public String o = K;
    public Map<String, String> p = new HashMap();
    public DownloadState r = DownloadState.NOT_START;
    public boolean A = false;
    public Map<String, String> B = new TreeMap();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.c0();
            if (b.this.y.c(b.this.f46625b.r())) {
                b.this.y.removeView(b.this.f46625b.r());
            }
            if (!b.this.y.d(b.this.f46625b.r(), d.a.i0.f.i.i.a.b())) {
                b.this.Z("3010000");
                return;
            }
            b.this.f46628e = 260;
            b.this.f46625b.G(b.this.f46627d.I());
            d.a.i0.f.i.q.b.n("showSuccess", b.this.B, b.this.k);
        }
    }

    /* renamed from: d.a.i0.f.i.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnDismissListenerC0975b implements DialogInterface.OnDismissListener {
        public DialogInterface$OnDismissListenerC0975b(b bVar) {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            b.this.P();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (!b.this.x || b.this.f46625b == null) {
                b.this.U();
                return;
            }
            if (b.this.f46626c != null) {
                b.this.f46626c.pause();
            }
            b.this.f46628e = PlayerEvent.PLAY_LOADING_END;
            b.this.f46625b.B();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.i0.f.i.k.f.a {
        public e() {
        }

        @Override // d.a.i0.f.i.k.f.a
        public void a(int i2) {
            if (i2 == 0 || i2 > 100) {
                return;
            }
            if (i2 != 100 || b.this.n == b.F) {
                if (b.this.n == b.F || b.this.n == b.I) {
                    return;
                }
                b.this.n = String.valueOf(i2);
                return;
            }
            b.this.n = b.G;
        }

        @Override // d.a.i0.f.i.k.f.a
        public void b() {
            b.this.q.c("appinstallbegin");
        }

        @Override // d.a.i0.f.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            if (!b.this.u) {
                b.this.m0(downloadState);
            }
            b.this.u = true;
            if (b.this.r == downloadState) {
                return;
            }
            if (b.this.r == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                b.this.o = b.K;
                b.this.q.c("appdownloadbegin");
            } else if (downloadState != DownloadState.DOWNLOAD_PAUSED) {
                if (b.this.r == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                    b.this.o = b.K;
                    b.this.q.c("appdownloadcontinue");
                } else if (downloadState == DownloadState.DOWNLOADED) {
                    b.this.o = b.K;
                    b.this.n = b.G;
                    b.this.q.c("appdownloadfinish");
                    b.this.q.c("appinstallbegin");
                } else if (downloadState == DownloadState.INSTALLED) {
                    b.this.o = b.K;
                    b.this.n = b.H;
                    b.this.q.c("appinstallfinish");
                } else if (downloadState == DownloadState.DOWNLOAD_FAILED) {
                    b.this.o = b.K;
                    b.this.n = b.I;
                }
            } else {
                b.this.o = b.J;
                b.this.q.c("appdownloadpause");
            }
            b.this.r = downloadState;
        }

        @Override // d.a.i0.f.i.k.f.a
        public void d(String str) {
        }

        @Override // d.a.i0.f.i.k.f.a
        public String e() {
            b.this.q.c("appinstallopen");
            return "";
        }

        @Override // d.a.i0.f.i.k.f.a
        public void f(boolean z) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.i0.f.i.l.e {
        public f() {
        }

        @Override // d.a.i0.f.i.l.e
        public void onCompletion() {
            b.this.A = false;
            b.this.T();
        }

        @Override // d.a.i0.f.i.l.e
        public boolean onError() {
            b.this.j0();
            b.this.Z("3010001");
            return true;
        }

        @Override // d.a.i0.f.i.l.e
        public void onPause() {
            if (b.this.A) {
                b.this.i0();
                b.this.A = false;
            }
        }

        @Override // d.a.i0.f.i.l.e
        public void onPrepared() {
            if (b.this.f46625b != null) {
                b.this.f46625b.y();
            }
            b.this.f46628e = PlayerEvent.PLAY_LOADING_START;
            b.this.f46629f = 0;
            if (b.this.f46625b != null) {
                b.this.f46625b.p();
            }
            if (b.this.j != null) {
                b.this.j.b(true, "");
            }
            if (b.this.v) {
                d.a.i0.f.i.q.d.f(b.this.f46627d, b.this.k);
            } else {
                d.a.i0.f.i.q.b.j(b.this.f46627d, b.this.k);
                d.a.i0.f.i.q.b.q(b.this.f46627d, b.this.k);
                String str = b.this.f46632i;
                b bVar = b.this;
                d.a.i0.f.i.q.b.f(str, bVar.f46631h, bVar.l, b.this.k);
            }
            d.a.i0.f.i.q.b.n("show", b.this.B, b.this.k);
        }

        @Override // d.a.i0.f.i.l.e
        public void onResume() {
            b.this.A = true;
            b.this.P();
        }

        @Override // d.a.i0.f.i.l.e
        public void onStart() {
            b.this.A = true;
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f46638a;

        static {
            int[] iArr = new int[CommandType.values().length];
            f46638a = iArr;
            try {
                iArr[CommandType.ACTION_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46638a[CommandType.GET_DOWNLOAD_STATUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46638a[CommandType.PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b(Activity activity, String str, String str2, boolean z, d.a.i0.f.i.p.a aVar, d.a.i0.f.i.l.f fVar) {
        this.f46631h = "";
        Context appContext = AppRuntime.getAppContext();
        this.f46624a = appContext;
        this.f46632i = str;
        this.f46631h = str2;
        this.v = z;
        this.w = z;
        this.k = new d.a.i0.f.i.o.b(appContext);
        this.m = new d.a.i0.f.i.n.a();
        this.x = i.i();
        this.j = aVar;
        this.y = fVar;
        this.D = activity;
    }

    public synchronized void P() {
        if (this.f46626c != null && this.f46625b != null) {
            if (this.f46630g == null || !this.f46630g.isShowing()) {
                if (!this.A && !this.f46625b.t()) {
                    this.f46626c.resume();
                    this.f46625b.D();
                } else {
                    d.a.i0.f.i.q.b.q(this.f46627d, this.k);
                }
            }
        }
    }

    public final d.a.i0.f.i.q.a Q(int i2) {
        d.a.i0.f.i.q.a aVar = new d.a.i0.f.i.q.a();
        aVar.f46647i = String.valueOf(this.f46627d.r());
        aVar.j = String.valueOf(this.f46629f);
        aVar.k = String.valueOf(i2);
        String str = "1";
        aVar.l = this.f46629f == 0 ? "1" : "0";
        aVar.m = i2 == this.f46627d.r() ? "1" : "0";
        int i3 = 1;
        aVar.n = this.f46624a.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        int i4 = this.f46629f;
        if (i4 != 0) {
            i3 = i4 == this.f46627d.r() ? 3 : 2;
        }
        aVar.o = String.valueOf(i3);
        aVar.p = (this.f46629f == 0 && NetworkUtils.g(this.f46624a)) ? "2" : "2";
        aVar.q = String.valueOf(0);
        return aVar;
    }

    public final int R() {
        d.a.i0.f.i.m.b.c cVar = this.f46626c;
        if (cVar != null && cVar.isEnd()) {
            return this.f46626c.getDuration() / 1000;
        }
        return S();
    }

    public final int S() {
        d.a.i0.f.i.m.b.c cVar = this.f46626c;
        if (cVar != null) {
            return cVar.getCurrentPosition() / 1000;
        }
        return 0;
    }

    public final void T() {
        if (this.f46626c == null || this.f46625b == null) {
            return;
        }
        i0();
        this.f46628e = PlayerEvent.PLAY_LOADING_END;
        if (this.f46625b != null) {
            if (this.f46626c.isEnd()) {
                this.f46625b.A();
            } else {
                this.f46625b.B();
            }
        }
    }

    public final void U() {
        d.a.i0.f.i.m.b.c cVar;
        if (this.j != null && (cVar = this.f46626c) != null) {
            int duration = cVar.getDuration() / 1000;
            this.j.c(this.f46626c.isEnd() || this.f46626c.getCurrentPosition() / 1000 >= Math.min(this.f46627d.A(), duration), duration);
        }
        j0();
        if (this.f46627d.h() == 2 && DownloadState.DOWNLOADING == this.r) {
            this.t = null;
            d.a.i0.f.i.m.a.b().b(this.f46624a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.t);
        }
        d.a.i0.f.i.q.b.p(this.f46627d, this.k);
        this.f46628e = PayBeanFactory.BEAN_ID_CREDIT_PAY;
        e0();
    }

    public final void V() {
        if (d.a.i0.f.i.r.g.a(this.f46624a, this.s.f11634b)) {
            this.n = H;
            h0(this.f46624a, this.s.f11634b);
            this.q.c("appinstallopen");
            return;
        }
        DownloadState downloadState = this.r;
        if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
            this.n = E;
            d.a.i0.f.i.m.a.b().b(this.f46624a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
        }
        if (this.r == DownloadState.DOWNLOADING) {
            d.a.i0.f.i.m.a.b().b(this.f46624a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.t);
        }
        if (this.r == DownloadState.DOWNLOAD_PAUSED) {
            this.o = K;
            d.a.i0.f.i.m.a.b().b(this.f46624a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
        }
        if (this.r == DownloadState.DOWNLOAD_FAILED) {
            d.a.i0.f.i.m.a.b().b(this.f46624a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
        }
        if (this.r == DownloadState.DOWNLOADED) {
            this.n = G;
            this.t.b();
            d.a.i0.f.i.m.a.b().b(this.f46624a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP, this.t);
        }
        if (this.r == DownloadState.INSTALLED) {
            h0(this.f46624a, this.s.f11634b);
        }
    }

    public final void W() {
        U();
    }

    public final void X(View view) {
        AdElementInfo adElementInfo;
        if (!this.v || (adElementInfo = this.f46627d) == null) {
            return;
        }
        d.a.i0.f.i.q.d.d(adElementInfo, this.k);
        d.a.i0.f.i.q.a aVar = new d.a.i0.f.i.q.a();
        aVar.f46639a = String.valueOf(h.i(this.f46624a));
        aVar.f46640b = String.valueOf(h.h(this.f46624a));
        aVar.f46641c = String.valueOf(h.i(this.f46624a));
        aVar.f46642d = String.valueOf(h.h(this.f46624a));
        aVar.f46643e = String.valueOf((int) view.getX());
        aVar.f46644f = String.valueOf((int) view.getY());
        aVar.f46645g = String.valueOf((int) view.getX());
        aVar.f46646h = String.valueOf((int) view.getY());
        if (this.f46627d.h() == 2) {
            d.a.i0.f.i.q.d.a(aVar, this.f46627d, this.k, this);
            return;
        }
        AdElementInfo adElementInfo2 = this.f46627d;
        if (adElementInfo2 != null) {
            this.y.a(d.a.i0.f.i.q.d.c(adElementInfo2.l(), aVar), new JSONObject());
        }
    }

    public final void Y() {
        String l = this.f46627d.l();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("monitorUrl", d.a.i0.f.i.q.b.b("landingPageLoad", this.B));
        } catch (JSONException unused) {
        }
        this.y.a(l, jSONObject);
    }

    public final void Z(String str) {
        d.a.i0.f.i.p.a aVar = this.j;
        if (aVar != null) {
            aVar.onError(str);
            this.j.b(false, "");
        }
        this.f46628e = PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK;
    }

    @Override // d.a.i0.f.i.l.b
    public synchronized void a(String str) {
        this.f46628e = 259;
        f0(str);
    }

    public final boolean a0(Context context, String str) {
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

    @Override // d.a.i0.f.i.l.a
    public synchronized void b(CommandType commandType, Uri uri) {
        this.f46627d.l();
        String y = this.f46627d.y();
        int i2 = g.f46638a[commandType.ordinal()];
        if (i2 == 1) {
            if (this.f46627d.h() == 2) {
                V();
            } else {
                Y();
                d.a.i0.f.i.q.b.n("lpClick", this.B, this.k);
            }
            d.a.i0.f.i.q.b.g(this.f46627d, this.k);
            d.a.i0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, this.B, this.k);
        } else if (i2 != 2) {
            if (i2 == 3) {
                this.o = J;
                V();
            }
        } else if (this.m == null) {
        } else {
            if (a0(this.f46624a, y)) {
                this.n = H;
            }
            String queryParameter = uri.getQueryParameter(N);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(L, this.n);
                jSONObject.put(M, this.o);
                this.m.b(queryParameter, jSONObject.toString());
            } catch (JSONException unused) {
            }
        }
    }

    public final void b0() {
        this.q = new d.a.i0.f.i.q.c(this.f46624a, this.f46627d.i());
        this.t = new e();
        String l = this.f46627d.l();
        String y = this.f46627d.y();
        String str = this.p.get(y);
        if (str != null) {
            l = str;
        } else {
            this.p.put(y, l);
        }
        this.s = new DownloadParams(l, y, this.f46627d.G());
        this.u = false;
        if (h.o()) {
            d.a.i0.f.i.m.a.b().b(this.f46624a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS, this.t);
        }
    }

    @Override // d.a.i0.f.i.l.b
    public synchronized void c(AdElementInfo adElementInfo) {
        this.f46627d = adElementInfo;
        this.v = adElementInfo.K();
        this.f46628e = 258;
        g0();
        if (!this.v && this.f46627d.h() == 2) {
            b0();
        }
    }

    public final void c0() {
        this.m.i(this);
        if (this.y.b()) {
            this.f46625b = new d.a.i0.f.i.s.b(this.f46624a, this.f46627d, this.m);
        } else {
            this.f46625b = new d.a.i0.f.i.s.c(this.f46624a, this.f46627d, this.m);
        }
        if (this.v) {
            this.f46625b.F(this);
        }
        this.f46625b.E(this);
        d.a.i0.f.i.m.b.c s = this.f46625b.s();
        this.f46626c = s;
        s.g(new f());
        this.f46625b.r().setAnimation(AnimationUtils.loadAnimation(this.f46624a, d.a.i0.f.i.a.ng_game_ad_open));
    }

    @Override // d.a.i0.f.i.l.d
    public synchronized void d(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("title", this.f46627d.G());
                jSONObject.put("description", this.f46627d.q());
                jSONObject.put("autoinstall", true);
                if (this.C == null) {
                    this.C = new d.a.i0.f.i.k.b(this.f46624a, this.f46627d, this.k);
                }
                this.C.k(str);
                d.a.i0.f.i.m.a.b().b(this.f46624a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.C);
            } catch (JSONException unused) {
            }
        }
    }

    public final boolean d0() {
        AdElementInfo adElementInfo = this.f46627d;
        if (adElementInfo == null) {
            return true;
        }
        long u = adElementInfo.u() * 1000;
        if (u == 0) {
            u = 1740000;
        }
        return System.currentTimeMillis() - this.f46627d.p() >= u;
    }

    @Override // d.a.i0.f.i.l.c
    public synchronized void e(View view) {
        int min;
        int i2;
        int i3;
        String format;
        if (this.f46626c != null && this.f46627d != null) {
            if (this.f46630g == null || !this.f46630g.isShowing()) {
                if (view != null && d.a.i0.f.i.e.close_ad != view.getId()) {
                    W();
                    return;
                }
                int currentPosition = this.f46626c.getCurrentPosition() / 1000;
                int min2 = Math.min(this.f46627d.A(), this.f46626c.getDuration() / 1000);
                if (currentPosition >= min2) {
                    T();
                    return;
                }
                int q = d.a.i0.f.i.m.a.b().q();
                int p = d.a.i0.f.i.m.a.b().p();
                if (this.y.b()) {
                    min = (int) (q * 0.275f);
                    i3 = (int) (p * 0.05f);
                    i2 = min;
                } else {
                    min = (int) (Math.min(q, p) * 0.1f);
                    i2 = min;
                    i3 = 0;
                }
                i0();
                this.f46624a.getResources().getString(d.a.i0.f.i.g.swangame_game_ad_dialog_msg_more);
                if (this.x) {
                    format = String.format(this.f46624a.getResources().getString(d.a.i0.f.i.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.f46626c.getCurrentPosition() / 1000)));
                } else {
                    format = String.format(this.f46624a.getResources().getString(d.a.i0.f.i.g.swangame_game_ad_video_close_alert), Integer.valueOf(min2 - currentPosition));
                }
                if (this.f46630g != null) {
                    this.f46630g.d(format);
                    this.f46630g.show();
                } else {
                    a.C0965a c0965a = new a.C0965a(this.D);
                    c0965a.c(true);
                    c0965a.i(d.a.i0.f.i.g.ad_close, new d());
                    c0965a.g(format);
                    c0965a.l(d.a.i0.f.i.g.ad_continue_watch, new c());
                    c0965a.n(d.a.i0.f.i.b.swan_ad_game_continue_watch);
                    c0965a.k(new DialogInterface$OnDismissListenerC0975b(this));
                    c0965a.f(min, 0, i2, i3);
                    this.f46630g = c0965a.p();
                }
            }
        }
    }

    public synchronized void e0() {
        d.a.i0.f.i.o.e gVar;
        if (this.f46628e == 257) {
            return;
        }
        d.a.i0.f.i.q.b.n("loadApi", this.B, this.k);
        d.a.i0.f.i.m.a.a().b(this.v);
        int i2 = this.f46628e;
        if (i2 != 256 && i2 != 272) {
            switch (i2) {
                case 258:
                    if (d0()) {
                        this.f46628e = AuthorityState.STATE_INIT_ING;
                        return;
                    } else {
                        g0();
                        return;
                    }
                case 259:
                case PlayerEvent.PLAY_LOADING_END /* 262 */:
                case PayBeanFactory.BEAN_ID_CREDIT_PAY /* 263 */:
                case PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK /* 264 */:
                    break;
                case 260:
                case PlayerEvent.PLAY_LOADING_START /* 261 */:
                case 265:
                    f0("3010006");
                    return;
                default:
                    return;
            }
        }
        String v = d.a.i0.f.i.m.a.b().v();
        if (!TextUtils.isEmpty(v) && !TextUtils.isEmpty(this.f46632i) && !TextUtils.isEmpty(this.f46631h)) {
            this.f46628e = 257;
            c.b bVar = new c.b();
            bVar.m(this.f46632i);
            bVar.j(this.f46631h);
            bVar.o(v);
            bVar.l(h.i(this.f46624a));
            bVar.i(h.h(this.f46624a));
            bVar.n(this.z ? "game" : "app");
            bVar.k("video");
            d.a.i0.f.i.o.c h2 = bVar.h();
            if (this.w) {
                this.v = true;
                gVar = new d.a.i0.f.i.o.f(this.f46624a, h2, 5, 5);
            } else {
                this.v = false;
                gVar = new d.a.i0.f.i.o.g(this.f46624a, h2);
                this.l = gVar.c();
            }
            d.a.i0.f.i.o.a aVar = new d.a.i0.f.i.o.a(this.f46624a, false);
            aVar.k(this);
            aVar.i(gVar, this.k);
            return;
        }
        f0("3010007");
    }

    @Override // d.a.i0.f.i.l.d
    public synchronized void f(View view) {
        if (this.j != null) {
            this.j.onClick(R());
        }
        if (this.v) {
            X(view);
        }
    }

    public final void f0(String str) {
        d.a.i0.f.i.p.a aVar = this.j;
        if (aVar != null) {
            aVar.onError(str);
            this.j.a(false, str);
        }
    }

    public final void g0() {
        d.a.i0.f.i.p.a aVar = this.j;
        if (aVar != null) {
            aVar.a(true, "");
        }
    }

    public final boolean h0(Context context, String str) {
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
            }
        }
        return false;
    }

    public synchronized void i0() {
        if (this.f46626c != null && this.f46625b != null) {
            if (this.f46626c.isPlaying()) {
                this.f46626c.pause();
                this.f46625b.z();
                if (this.v) {
                    d.a.i0.f.i.q.d.g(Q(S()), this.f46627d, this.k);
                } else {
                    d.a.i0.f.i.q.b.o(S(), this.f46629f, this.f46627d, this.k);
                }
            } else {
                d.a.i0.f.i.q.b.o(S(), this.f46629f, this.f46627d, this.k);
                this.f46629f = S();
            }
        }
    }

    public final void j0() {
        d.a.i0.f.i.m.b.c cVar = this.f46626c;
        if (cVar != null) {
            cVar.pause();
            this.f46626c.stop();
        }
        d.a.i0.f.i.s.a aVar = this.f46625b;
        if (aVar != null) {
            aVar.n();
            this.f46625b.r().setAnimation(AnimationUtils.loadAnimation(this.f46624a, d.a.i0.f.i.a.ng_game_ad_close));
            this.y.removeView(this.f46625b.r());
            this.f46625b = null;
        }
        d.a.i0.f.i.k.b bVar = this.C;
        if (bVar != null) {
            bVar.i();
            this.C = null;
        }
    }

    public void k0(Map<String, String> map) {
        this.B = map;
        this.z = d.a.i0.f.i.q.b.c(map).equals("game");
    }

    public synchronized void l0() {
        d.a.i0.f.i.q.b.n("showApi", this.B, this.k);
        if (this.f46628e != 261 && this.f46628e != 260 && this.f46628e != 265) {
            if (this.f46628e == 258 && !d0()) {
                if (this.f46627d != null && TextUtils.isEmpty(this.f46627d.I())) {
                    Z("3010008");
                    return;
                }
                if (this.f46628e == 258) {
                    this.f46628e = 265;
                    this.y.e();
                    d.a.i0.f.i.r.d.c(new a());
                }
                return;
            }
            Z("3010004");
            return;
        }
        if (this.j != null) {
            this.j.onError("3010004");
            this.j.b(false, "3010004");
        }
    }

    public final void m0(DownloadState downloadState) {
        this.r = downloadState;
        if (downloadState == DownloadState.NOT_START) {
            this.n = F;
            this.o = K;
        } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
            this.n = E;
            this.o = J;
        } else if (downloadState == DownloadState.DOWNLOADED) {
            this.n = G;
            this.o = K;
        } else if (downloadState == DownloadState.INSTALLED) {
            this.n = H;
            this.o = K;
        } else if (downloadState == DownloadState.DOWNLOADING) {
            this.n = E;
            this.o = K;
        }
    }
}
