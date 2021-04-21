package d.b.h0.e.a.r;

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
import d.b.h0.a.e0.l.f;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
import d.b.h0.e.a.a;
import d.b.h0.e.a.o.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements d.b.h0.e.a.m.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f48421a;

    /* renamed from: b  reason: collision with root package name */
    public String f48422b;

    /* renamed from: c  reason: collision with root package name */
    public String f48423c;

    /* renamed from: d  reason: collision with root package name */
    public i f48424d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.e.a.r.f f48425e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.e.a.r.b f48426f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f48427g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.e.a.a f48428h;
    public boolean i;
    public String j;
    public a.e k;
    public boolean l;
    public d.b.h0.e.a.r.g m;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f48429e;

        public a(l lVar) {
            this.f48429e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f48428h != null && d.b.h0.g.k0.e.c.g(e.this.f48428h.h())) {
                e.this.f48428h.n();
                l lVar = this.f48429e;
                if (lVar != null) {
                    lVar.c();
                }
                if (e.this.i) {
                    return;
                }
                e.this.i = true;
                if (e.this.l) {
                    d.b.h0.e.a.p.d.f(e.this.f48427g, e.this.f48426f);
                    return;
                }
                d.b.h0.e.a.p.c.g(e.this.f48427g, e.this.f48426f);
                String str = e.this.f48423c;
                e eVar = e.this;
                d.b.h0.e.a.p.c.c(str, eVar.f48422b, eVar.j, e.this.f48426f);
                return;
            }
            l lVar2 = this.f48429e;
            if (lVar2 != null) {
                lVar2.b("3010010");
            }
            if (e.this.f48424d != null) {
                e.this.f48424d.onError("3010010");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f48428h != null) {
                e.this.f48428h.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f48428h != null) {
                d.b.h0.g.k0.e.c.i(e.this.f48428h.h());
            }
            e.this.f48428h = null;
            e.this.f48424d = null;
            e.this.f48427g = null;
            if (e.this.m != null) {
                e.this.m.i();
                e.this.m = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48433e;

        public d(String str) {
            this.f48433e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.e.a.r.f fVar = e.this.f48425e;
            boolean z = fVar.width != fVar.realWidth;
            e.this.x();
            if (e.this.f48428h != null) {
                e.this.f48428h.g(e.this.f48425e.width);
                d.b.h0.g.k0.e.c.k(e.this.f48428h.h(), new d.b.h0.a.e1.d.a.a(h0.f(e.this.f48425e.left), h0.f(e.this.f48425e.top), h0.f(e.this.f48425e.realWidth), h0.f(e.this.f48425e.realHeight)));
            }
            if (this.f48433e.equals("width") && z && e.this.f48424d != null) {
                e.this.f48424d.b(e.this.f48425e);
            }
        }
    }

    /* renamed from: d.b.h0.e.a.r.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0970e implements Runnable {
        public RunnableC0970e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f48428h == null || !d.b.h0.g.k0.e.c.g(e.this.f48428h.h())) {
                return;
            }
            d.b.h0.g.k0.e.c.i(e.this.f48428h.h());
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.h0.e.a.m.d {
        public f() {
        }

        @Override // d.b.h0.e.a.m.d
        public void a(String str, String str2) {
        }

        @Override // d.b.h0.e.a.m.d
        public void d(View view) {
            if (e.this.l) {
                e.this.z(view);
                d.b.h0.g.k0.e.b.b("gdtbanner", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.b.h0.e.a.m.a {
        public g() {
        }

        @Override // d.b.h0.e.a.m.a
        public void e(CommandType commandType, Uri uri) {
            d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
            if (W == null) {
                if (e.this.f48421a != null) {
                    d.b.h0.a.q1.b.f.d.e(e.this.f48421a, d.b.h0.a.h.aiapps_open_fragment_failed_toast).C();
                }
            } else if (e.this.f48427g != null) {
                String l = e.this.f48427g.l();
                d.b.h0.a.e1.b c2 = d.b.h0.a.e1.b.c(l, l);
                f.b i = W.i("adLanding");
                i.n(d.b.h0.a.e0.l.f.f44734g, d.b.h0.a.e0.l.f.i);
                i.k("adLanding", c2).b();
                d.b.h0.e.a.p.c.d(e.this.f48427g, e.this.f48426f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.b.h0.e.a.m.d {
        public h() {
        }

        @Override // d.b.h0.e.a.m.d
        public void a(String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (e.this.m == null) {
                    e.this.m = new d.b.h0.e.a.r.g(e.this.f48421a, e.this.f48427g, e.this.f48426f);
                }
                e.this.m.k(str);
                d.b.h0.a.w0.a.d().a(e.this.f48421a, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.m);
            } catch (JSONException e2) {
                if (d.b.h0.a.k.f45772a) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.b.h0.e.a.m.d
        public void d(View view) {
        }
    }

    public e(String str, String str2, d.b.h0.e.a.r.f fVar, a.e eVar, boolean z) {
        this.f48425e = null;
        Context appContext = AppRuntime.getAppContext();
        this.f48421a = appContext;
        this.f48423c = str;
        this.f48422b = str2;
        this.f48425e = fVar;
        this.k = eVar;
        this.f48426f = new d.b.h0.e.a.r.b(appContext);
        this.l = z;
        x();
        B();
    }

    public final void A() {
        d.b.h0.e.a.a aVar = new d.b.h0.e.a.a(this.f48421a, this.f48427g, this.f48422b, this.l);
        this.f48428h = aVar;
        aVar.k(this.k);
        if (this.l) {
            this.f48428h.m(new f());
        } else {
            this.f48428h.l(new g());
        }
        this.f48428h.g(this.f48425e.width);
        if (d.b.h0.g.k0.e.c.g(this.f48428h.h())) {
            d.b.h0.g.k0.e.c.i(this.f48428h.h());
        }
        if (d.b.h0.g.k0.e.c.a(this.f48428h.h(), new d.b.h0.a.e1.d.a.a(h0.f(this.f48425e.left), h0.f(this.f48425e.top), h0.f(this.f48425e.realWidth), h0.f(this.f48425e.realHeight)))) {
            i iVar = this.f48424d;
            if (iVar != null) {
                iVar.a();
                return;
            }
            return;
        }
        i iVar2 = this.f48424d;
        if (iVar2 != null) {
            iVar2.onError("3010000");
        }
    }

    public final void B() {
        d.b.h0.e.a.o.d cVar;
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        String B = y != null ? y.B() : "";
        b.C0969b c0969b = new b.C0969b();
        c0969b.l(this.f48423c);
        c0969b.i(this.f48422b);
        c0969b.m(B);
        c0969b.k(this.f48425e.width);
        c0969b.h(this.f48425e.height);
        d.b.h0.e.a.o.b g2 = c0969b.g();
        if (this.l) {
            cVar = new d.b.h0.e.a.o.e(this.f48421a, g2, 1, y());
            d.b.h0.g.k0.e.b.b("gdtbanner", null);
        } else {
            cVar = new d.b.h0.e.a.o.c(this.f48421a, g2);
            this.j = cVar.c();
            d.b.h0.g.k0.e.b.b("banner", null);
        }
        d.b.h0.e.a.o.a aVar = new d.b.h0.e.a.o.a(this.f48421a, this.l);
        aVar.i(this);
        aVar.h(cVar, this.f48426f);
    }

    public void C(i iVar) {
        this.f48424d = iVar;
    }

    public void D(String str) {
        k0.X(new d(str));
    }

    @Override // d.b.h0.e.a.m.b
    public void c(String str) {
        i iVar = this.f48424d;
        if (iVar != null) {
            iVar.onError(str);
        }
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        String str2 = y != null ? y.f46461f : "";
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            w();
        }
        d.b.h0.g.k0.e.b.c(this.l ? "gdtbanner" : "banner", "fail", str);
    }

    @Override // d.b.h0.e.a.m.b
    public void f(AdElementInfo adElementInfo) {
        this.f48427g = adElementInfo;
        A();
        d.b.h0.g.k0.e.b.b(this.l ? "gdtbanner" : "banner", "success");
    }

    public void t() {
        k0.X(new c());
    }

    public void u() {
        k0.X(new b());
    }

    public void v(JsObject jsObject) {
        k0.X(new a(l.d(d.b.h0.g.e.d.c.F(jsObject))));
    }

    public final void w() {
        d.b.h0.e.a.a aVar = new d.b.h0.e.a.a(this.f48421a);
        this.f48428h = aVar;
        aVar.g(this.f48425e.width);
        if (d.b.h0.g.k0.e.c.g(this.f48428h.h())) {
            d.b.h0.g.k0.e.c.i(this.f48428h.h());
        }
        d.b.h0.g.k0.e.c.a(this.f48428h.h(), new d.b.h0.a.e1.d.a.a(h0.f(this.f48425e.left), h0.f(this.f48425e.top), h0.f(this.f48425e.realWidth), h0.f(this.f48425e.realHeight)));
        this.f48428h.h().postDelayed(new RunnableC0970e(), 20000L);
    }

    public final void x() {
        d.b.h0.e.a.r.f fVar = this.f48425e;
        if (fVar == null) {
            return;
        }
        if (h0.f(fVar.width) < 300) {
            this.f48425e.width = h0.H(300.0f);
        }
        int c2 = d.b.h0.g.k0.e.c.c();
        int b2 = d.b.h0.g.k0.e.c.b();
        if (h0.f(this.f48425e.width) > c2) {
            this.f48425e.width = h0.H(c2);
        }
        d.b.h0.e.a.r.f fVar2 = this.f48425e;
        fVar2.height = (int) (fVar2.width / d.b.h0.e.a.q.d.f48403a);
        if (fVar2.left < 0) {
            fVar2.left = 0;
        }
        int H = h0.H(c2);
        d.b.h0.e.a.r.f fVar3 = this.f48425e;
        int i = H - fVar3.width;
        if (fVar3.left > i) {
            fVar3.left = i;
        }
        d.b.h0.e.a.r.f fVar4 = this.f48425e;
        if (fVar4.top < 0) {
            fVar4.top = 0;
        }
        int H2 = h0.H(b2);
        d.b.h0.e.a.r.f fVar5 = this.f48425e;
        int i2 = H2 - fVar5.height;
        if (fVar5.top > i2) {
            fVar5.top = i2;
        }
        d.b.h0.e.a.r.f fVar6 = this.f48425e;
        fVar6.realWidth = fVar6.width;
        fVar6.realHeight = fVar6.height;
    }

    public final int y() {
        if (this.f48425e == null) {
            return 2;
        }
        int H = h0.H(d.b.h0.g.k0.e.c.b());
        int i = this.f48425e.top;
        int i2 = H / 3;
        if (i < i2) {
            return 1;
        }
        return i < i2 * 2 ? 4 : 2;
    }

    public final void z(View view) {
        AdElementInfo adElementInfo;
        if (!this.l || (adElementInfo = this.f48427g) == null || this.f48425e == null || view == null) {
            return;
        }
        d.b.h0.e.a.p.d.d(adElementInfo, this.f48426f);
        d.b.h0.e.a.p.b bVar = new d.b.h0.e.a.p.b();
        bVar.f48391a = String.valueOf(this.f48425e.width);
        bVar.f48392b = String.valueOf(this.f48425e.height);
        bVar.f48393c = String.valueOf(this.f48425e.width);
        bVar.f48394d = String.valueOf(this.f48425e.height);
        bVar.f48395e = String.valueOf((int) view.getX());
        bVar.f48396f = String.valueOf((int) view.getY());
        bVar.f48397g = String.valueOf((int) view.getX());
        bVar.f48398h = String.valueOf((int) view.getY());
        if (this.f48427g.h() == 2) {
            d.b.h0.e.a.p.d.a(bVar, this.f48427g, this.f48426f, new h());
            return;
        }
        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
        if (W == null) {
            Context context = this.f48421a;
            if (context != null) {
                d.b.h0.a.q1.b.f.d.e(context, d.b.h0.a.h.aiapps_open_fragment_failed_toast).C();
                return;
            }
            return;
        }
        AdElementInfo adElementInfo2 = this.f48427g;
        if (adElementInfo2 != null) {
            String c2 = d.b.h0.e.a.p.d.c(adElementInfo2.l(), bVar);
            d.b.h0.a.e1.b c3 = d.b.h0.a.e1.b.c(c2, c2);
            f.b i = W.i("adLanding");
            i.n(d.b.h0.a.e0.l.f.f44734g, d.b.h0.a.e0.l.f.i);
            i.k("adLanding", c3).b();
        }
    }
}
