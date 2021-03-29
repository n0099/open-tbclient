package d.b.g0.e.a.r;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.e.a.a;
import d.b.g0.e.a.o.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements d.b.g0.e.a.m.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f47700a;

    /* renamed from: b  reason: collision with root package name */
    public String f47701b;

    /* renamed from: c  reason: collision with root package name */
    public String f47702c;

    /* renamed from: d  reason: collision with root package name */
    public i f47703d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.e.a.r.f f47704e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.e.a.r.b f47705f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f47706g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.e.a.a f47707h;
    public boolean i;
    public String j;
    public a.e k;
    public boolean l;
    public d.b.g0.e.a.r.g m;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f47708e;

        public a(l lVar) {
            this.f47708e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f47707h != null && d.b.g0.g.k0.e.c.g(e.this.f47707h.h())) {
                e.this.f47707h.n();
                l lVar = this.f47708e;
                if (lVar != null) {
                    lVar.c();
                }
                if (e.this.i) {
                    return;
                }
                e.this.i = true;
                if (e.this.l) {
                    d.b.g0.e.a.p.d.f(e.this.f47706g, e.this.f47705f);
                    return;
                }
                d.b.g0.e.a.p.c.g(e.this.f47706g, e.this.f47705f);
                String str = e.this.f47702c;
                e eVar = e.this;
                d.b.g0.e.a.p.c.c(str, eVar.f47701b, eVar.j, e.this.f47705f);
                return;
            }
            l lVar2 = this.f47708e;
            if (lVar2 != null) {
                lVar2.b("3010010");
            }
            if (e.this.f47703d != null) {
                e.this.f47703d.onError("3010010");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f47707h != null) {
                e.this.f47707h.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f47707h != null) {
                d.b.g0.g.k0.e.c.i(e.this.f47707h.h());
            }
            e.this.f47707h = null;
            e.this.f47703d = null;
            e.this.f47706g = null;
            if (e.this.m != null) {
                e.this.m.i();
                e.this.m = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47712e;

        public d(String str) {
            this.f47712e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.e.a.r.f fVar = e.this.f47704e;
            boolean z = fVar.width != fVar.realWidth;
            e.this.x();
            if (e.this.f47707h != null) {
                e.this.f47707h.g(e.this.f47704e.width);
                d.b.g0.g.k0.e.c.k(e.this.f47707h.h(), new d.b.g0.a.e1.d.a.a(h0.f(e.this.f47704e.left), h0.f(e.this.f47704e.top), h0.f(e.this.f47704e.realWidth), h0.f(e.this.f47704e.realHeight)));
            }
            if (this.f47712e.equals("width") && z && e.this.f47703d != null) {
                e.this.f47703d.b(e.this.f47704e);
            }
        }
    }

    /* renamed from: d.b.g0.e.a.r.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0938e implements Runnable {
        public RunnableC0938e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f47707h == null || !d.b.g0.g.k0.e.c.g(e.this.f47707h.h())) {
                return;
            }
            d.b.g0.g.k0.e.c.i(e.this.f47707h.h());
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.g0.e.a.m.d {
        public f() {
        }

        @Override // d.b.g0.e.a.m.d
        public void a(String str, String str2) {
        }

        @Override // d.b.g0.e.a.m.d
        public void d(View view) {
            if (e.this.l) {
                e.this.z(view);
                d.b.g0.g.k0.e.b.b("gdtbanner", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.b.g0.e.a.m.a {
        public g() {
        }

        @Override // d.b.g0.e.a.m.a
        public void e(CommandType commandType, Uri uri) {
            d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
            if (W == null) {
                if (e.this.f47700a != null) {
                    d.b.g0.a.q1.b.f.d.e(e.this.f47700a, d.b.g0.a.h.aiapps_open_fragment_failed_toast).C();
                }
            } else if (e.this.f47706g != null) {
                String l = e.this.f47706g.l();
                d.b.g0.a.e1.b c2 = d.b.g0.a.e1.b.c(l, l);
                f.b i = W.i("adLanding");
                i.n(d.b.g0.a.e0.l.f.f44013g, d.b.g0.a.e0.l.f.i);
                i.k("adLanding", c2).b();
                d.b.g0.e.a.p.c.d(e.this.f47706g, e.this.f47705f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.b.g0.e.a.m.d {
        public h() {
        }

        @Override // d.b.g0.e.a.m.d
        public void a(String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (e.this.m == null) {
                    e.this.m = new d.b.g0.e.a.r.g(e.this.f47700a, e.this.f47706g, e.this.f47705f);
                }
                e.this.m.k(str);
                d.b.g0.a.w0.a.d().a(e.this.f47700a, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.m);
            } catch (JSONException e2) {
                if (d.b.g0.a.k.f45051a) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.b.g0.e.a.m.d
        public void d(View view) {
        }
    }

    public e(String str, String str2, d.b.g0.e.a.r.f fVar, a.e eVar, boolean z) {
        this.f47704e = null;
        Context appContext = AppRuntime.getAppContext();
        this.f47700a = appContext;
        this.f47702c = str;
        this.f47701b = str2;
        this.f47704e = fVar;
        this.k = eVar;
        this.f47705f = new d.b.g0.e.a.r.b(appContext);
        this.l = z;
        x();
        B();
    }

    public final void A() {
        d.b.g0.e.a.a aVar = new d.b.g0.e.a.a(this.f47700a, this.f47706g, this.f47701b, this.l);
        this.f47707h = aVar;
        aVar.k(this.k);
        if (this.l) {
            this.f47707h.m(new f());
        } else {
            this.f47707h.l(new g());
        }
        this.f47707h.g(this.f47704e.width);
        if (d.b.g0.g.k0.e.c.g(this.f47707h.h())) {
            d.b.g0.g.k0.e.c.i(this.f47707h.h());
        }
        if (d.b.g0.g.k0.e.c.a(this.f47707h.h(), new d.b.g0.a.e1.d.a.a(h0.f(this.f47704e.left), h0.f(this.f47704e.top), h0.f(this.f47704e.realWidth), h0.f(this.f47704e.realHeight)))) {
            i iVar = this.f47703d;
            if (iVar != null) {
                iVar.a();
                return;
            }
            return;
        }
        i iVar2 = this.f47703d;
        if (iVar2 != null) {
            iVar2.onError("3010000");
        }
    }

    public final void B() {
        d.b.g0.e.a.o.d cVar;
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        String B = y != null ? y.B() : "";
        b.C0937b c0937b = new b.C0937b();
        c0937b.l(this.f47702c);
        c0937b.i(this.f47701b);
        c0937b.m(B);
        c0937b.k(this.f47704e.width);
        c0937b.h(this.f47704e.height);
        d.b.g0.e.a.o.b g2 = c0937b.g();
        if (this.l) {
            cVar = new d.b.g0.e.a.o.e(this.f47700a, g2, 1, y());
            d.b.g0.g.k0.e.b.b("gdtbanner", null);
        } else {
            cVar = new d.b.g0.e.a.o.c(this.f47700a, g2);
            this.j = cVar.c();
            d.b.g0.g.k0.e.b.b("banner", null);
        }
        d.b.g0.e.a.o.a aVar = new d.b.g0.e.a.o.a(this.f47700a, this.l);
        aVar.i(this);
        aVar.h(cVar, this.f47705f);
    }

    public void C(i iVar) {
        this.f47703d = iVar;
    }

    public void D(String str) {
        k0.X(new d(str));
    }

    @Override // d.b.g0.e.a.m.b
    public void c(String str) {
        i iVar = this.f47703d;
        if (iVar != null) {
            iVar.onError(str);
        }
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        String str2 = y != null ? y.f45740f : "";
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            w();
        }
        d.b.g0.g.k0.e.b.c(this.l ? "gdtbanner" : "banner", "fail", str);
    }

    @Override // d.b.g0.e.a.m.b
    public void f(AdElementInfo adElementInfo) {
        this.f47706g = adElementInfo;
        A();
        d.b.g0.g.k0.e.b.b(this.l ? "gdtbanner" : "banner", "success");
    }

    public void t() {
        k0.X(new c());
    }

    public void u() {
        k0.X(new b());
    }

    public void v(JsObject jsObject) {
        k0.X(new a(l.d(d.b.g0.g.e.d.c.F(jsObject))));
    }

    public final void w() {
        d.b.g0.e.a.a aVar = new d.b.g0.e.a.a(this.f47700a);
        this.f47707h = aVar;
        aVar.g(this.f47704e.width);
        if (d.b.g0.g.k0.e.c.g(this.f47707h.h())) {
            d.b.g0.g.k0.e.c.i(this.f47707h.h());
        }
        d.b.g0.g.k0.e.c.a(this.f47707h.h(), new d.b.g0.a.e1.d.a.a(h0.f(this.f47704e.left), h0.f(this.f47704e.top), h0.f(this.f47704e.realWidth), h0.f(this.f47704e.realHeight)));
        this.f47707h.h().postDelayed(new RunnableC0938e(), 20000L);
    }

    public final void x() {
        d.b.g0.e.a.r.f fVar = this.f47704e;
        if (fVar == null) {
            return;
        }
        if (h0.f(fVar.width) < 300) {
            this.f47704e.width = h0.H(300.0f);
        }
        int c2 = d.b.g0.g.k0.e.c.c();
        int b2 = d.b.g0.g.k0.e.c.b();
        if (h0.f(this.f47704e.width) > c2) {
            this.f47704e.width = h0.H(c2);
        }
        d.b.g0.e.a.r.f fVar2 = this.f47704e;
        fVar2.height = (int) (fVar2.width / d.b.g0.e.a.q.d.f47682a);
        if (fVar2.left < 0) {
            fVar2.left = 0;
        }
        int H = h0.H(c2);
        d.b.g0.e.a.r.f fVar3 = this.f47704e;
        int i = H - fVar3.width;
        if (fVar3.left > i) {
            fVar3.left = i;
        }
        d.b.g0.e.a.r.f fVar4 = this.f47704e;
        if (fVar4.top < 0) {
            fVar4.top = 0;
        }
        int H2 = h0.H(b2);
        d.b.g0.e.a.r.f fVar5 = this.f47704e;
        int i2 = H2 - fVar5.height;
        if (fVar5.top > i2) {
            fVar5.top = i2;
        }
        d.b.g0.e.a.r.f fVar6 = this.f47704e;
        fVar6.realWidth = fVar6.width;
        fVar6.realHeight = fVar6.height;
    }

    public final int y() {
        if (this.f47704e == null) {
            return 2;
        }
        int H = h0.H(d.b.g0.g.k0.e.c.b());
        int i = this.f47704e.top;
        int i2 = H / 3;
        if (i < i2) {
            return 1;
        }
        return i < i2 * 2 ? 4 : 2;
    }

    public final void z(View view) {
        AdElementInfo adElementInfo;
        if (!this.l || (adElementInfo = this.f47706g) == null || this.f47704e == null || view == null) {
            return;
        }
        d.b.g0.e.a.p.d.d(adElementInfo, this.f47705f);
        d.b.g0.e.a.p.b bVar = new d.b.g0.e.a.p.b();
        bVar.f47670a = String.valueOf(this.f47704e.width);
        bVar.f47671b = String.valueOf(this.f47704e.height);
        bVar.f47672c = String.valueOf(this.f47704e.width);
        bVar.f47673d = String.valueOf(this.f47704e.height);
        bVar.f47674e = String.valueOf((int) view.getX());
        bVar.f47675f = String.valueOf((int) view.getY());
        bVar.f47676g = String.valueOf((int) view.getX());
        bVar.f47677h = String.valueOf((int) view.getY());
        if (this.f47706g.h() == 2) {
            d.b.g0.e.a.p.d.a(bVar, this.f47706g, this.f47705f, new h());
            return;
        }
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            Context context = this.f47700a;
            if (context != null) {
                d.b.g0.a.q1.b.f.d.e(context, d.b.g0.a.h.aiapps_open_fragment_failed_toast).C();
                return;
            }
            return;
        }
        AdElementInfo adElementInfo2 = this.f47706g;
        if (adElementInfo2 != null) {
            String c2 = d.b.g0.e.a.p.d.c(adElementInfo2.l(), bVar);
            d.b.g0.a.e1.b c3 = d.b.g0.a.e1.b.c(c2, c2);
            f.b i = W.i("adLanding");
            i.n(d.b.g0.a.e0.l.f.f44013g, d.b.g0.a.e0.l.f.i);
            i.k("adLanding", c3).b();
        }
    }
}
