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
    public Context f48092a;

    /* renamed from: b  reason: collision with root package name */
    public String f48093b;

    /* renamed from: c  reason: collision with root package name */
    public String f48094c;

    /* renamed from: d  reason: collision with root package name */
    public i f48095d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.e.a.r.f f48096e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.e.a.r.b f48097f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f48098g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.e.a.a f48099h;
    public boolean i;
    public String j;
    public a.e k;
    public boolean l;
    public d.b.g0.e.a.r.g m;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f48100e;

        public a(l lVar) {
            this.f48100e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f48099h != null && d.b.g0.g.k0.e.c.g(e.this.f48099h.h())) {
                e.this.f48099h.n();
                l lVar = this.f48100e;
                if (lVar != null) {
                    lVar.c();
                }
                if (e.this.i) {
                    return;
                }
                e.this.i = true;
                if (e.this.l) {
                    d.b.g0.e.a.p.d.f(e.this.f48098g, e.this.f48097f);
                    return;
                }
                d.b.g0.e.a.p.c.g(e.this.f48098g, e.this.f48097f);
                String str = e.this.f48094c;
                e eVar = e.this;
                d.b.g0.e.a.p.c.c(str, eVar.f48093b, eVar.j, e.this.f48097f);
                return;
            }
            l lVar2 = this.f48100e;
            if (lVar2 != null) {
                lVar2.b("3010010");
            }
            if (e.this.f48095d != null) {
                e.this.f48095d.onError("3010010");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f48099h != null) {
                e.this.f48099h.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f48099h != null) {
                d.b.g0.g.k0.e.c.i(e.this.f48099h.h());
            }
            e.this.f48099h = null;
            e.this.f48095d = null;
            e.this.f48098g = null;
            if (e.this.m != null) {
                e.this.m.i();
                e.this.m = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48104e;

        public d(String str) {
            this.f48104e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.e.a.r.f fVar = e.this.f48096e;
            boolean z = fVar.width != fVar.realWidth;
            e.this.x();
            if (e.this.f48099h != null) {
                e.this.f48099h.g(e.this.f48096e.width);
                d.b.g0.g.k0.e.c.k(e.this.f48099h.h(), new d.b.g0.a.e1.d.a.a(h0.f(e.this.f48096e.left), h0.f(e.this.f48096e.top), h0.f(e.this.f48096e.realWidth), h0.f(e.this.f48096e.realHeight)));
            }
            if (this.f48104e.equals("width") && z && e.this.f48095d != null) {
                e.this.f48095d.b(e.this.f48096e);
            }
        }
    }

    /* renamed from: d.b.g0.e.a.r.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0950e implements Runnable {
        public RunnableC0950e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f48099h == null || !d.b.g0.g.k0.e.c.g(e.this.f48099h.h())) {
                return;
            }
            d.b.g0.g.k0.e.c.i(e.this.f48099h.h());
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
                if (e.this.f48092a != null) {
                    d.b.g0.a.q1.b.f.d.e(e.this.f48092a, d.b.g0.a.h.aiapps_open_fragment_failed_toast).C();
                }
            } else if (e.this.f48098g != null) {
                String l = e.this.f48098g.l();
                d.b.g0.a.e1.b c2 = d.b.g0.a.e1.b.c(l, l);
                f.b i = W.i("adLanding");
                i.n(d.b.g0.a.e0.l.f.f44405g, d.b.g0.a.e0.l.f.i);
                i.k("adLanding", c2).b();
                d.b.g0.e.a.p.c.d(e.this.f48098g, e.this.f48097f);
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
                    e.this.m = new d.b.g0.e.a.r.g(e.this.f48092a, e.this.f48098g, e.this.f48097f);
                }
                e.this.m.k(str);
                d.b.g0.a.w0.a.d().a(e.this.f48092a, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.m);
            } catch (JSONException e2) {
                if (d.b.g0.a.k.f45443a) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.b.g0.e.a.m.d
        public void d(View view) {
        }
    }

    public e(String str, String str2, d.b.g0.e.a.r.f fVar, a.e eVar, boolean z) {
        this.f48096e = null;
        Context appContext = AppRuntime.getAppContext();
        this.f48092a = appContext;
        this.f48094c = str;
        this.f48093b = str2;
        this.f48096e = fVar;
        this.k = eVar;
        this.f48097f = new d.b.g0.e.a.r.b(appContext);
        this.l = z;
        x();
        B();
    }

    public final void A() {
        d.b.g0.e.a.a aVar = new d.b.g0.e.a.a(this.f48092a, this.f48098g, this.f48093b, this.l);
        this.f48099h = aVar;
        aVar.k(this.k);
        if (this.l) {
            this.f48099h.m(new f());
        } else {
            this.f48099h.l(new g());
        }
        this.f48099h.g(this.f48096e.width);
        if (d.b.g0.g.k0.e.c.g(this.f48099h.h())) {
            d.b.g0.g.k0.e.c.i(this.f48099h.h());
        }
        if (d.b.g0.g.k0.e.c.a(this.f48099h.h(), new d.b.g0.a.e1.d.a.a(h0.f(this.f48096e.left), h0.f(this.f48096e.top), h0.f(this.f48096e.realWidth), h0.f(this.f48096e.realHeight)))) {
            i iVar = this.f48095d;
            if (iVar != null) {
                iVar.a();
                return;
            }
            return;
        }
        i iVar2 = this.f48095d;
        if (iVar2 != null) {
            iVar2.onError("3010000");
        }
    }

    public final void B() {
        d.b.g0.e.a.o.d cVar;
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        String B = y != null ? y.B() : "";
        b.C0949b c0949b = new b.C0949b();
        c0949b.l(this.f48094c);
        c0949b.i(this.f48093b);
        c0949b.m(B);
        c0949b.k(this.f48096e.width);
        c0949b.h(this.f48096e.height);
        d.b.g0.e.a.o.b g2 = c0949b.g();
        if (this.l) {
            cVar = new d.b.g0.e.a.o.e(this.f48092a, g2, 1, y());
            d.b.g0.g.k0.e.b.b("gdtbanner", null);
        } else {
            cVar = new d.b.g0.e.a.o.c(this.f48092a, g2);
            this.j = cVar.c();
            d.b.g0.g.k0.e.b.b("banner", null);
        }
        d.b.g0.e.a.o.a aVar = new d.b.g0.e.a.o.a(this.f48092a, this.l);
        aVar.i(this);
        aVar.h(cVar, this.f48097f);
    }

    public void C(i iVar) {
        this.f48095d = iVar;
    }

    public void D(String str) {
        k0.X(new d(str));
    }

    @Override // d.b.g0.e.a.m.b
    public void c(String str) {
        i iVar = this.f48095d;
        if (iVar != null) {
            iVar.onError(str);
        }
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        String str2 = y != null ? y.f46132f : "";
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            w();
        }
        d.b.g0.g.k0.e.b.c(this.l ? "gdtbanner" : "banner", "fail", str);
    }

    @Override // d.b.g0.e.a.m.b
    public void f(AdElementInfo adElementInfo) {
        this.f48098g = adElementInfo;
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
        d.b.g0.e.a.a aVar = new d.b.g0.e.a.a(this.f48092a);
        this.f48099h = aVar;
        aVar.g(this.f48096e.width);
        if (d.b.g0.g.k0.e.c.g(this.f48099h.h())) {
            d.b.g0.g.k0.e.c.i(this.f48099h.h());
        }
        d.b.g0.g.k0.e.c.a(this.f48099h.h(), new d.b.g0.a.e1.d.a.a(h0.f(this.f48096e.left), h0.f(this.f48096e.top), h0.f(this.f48096e.realWidth), h0.f(this.f48096e.realHeight)));
        this.f48099h.h().postDelayed(new RunnableC0950e(), 20000L);
    }

    public final void x() {
        d.b.g0.e.a.r.f fVar = this.f48096e;
        if (fVar == null) {
            return;
        }
        if (h0.f(fVar.width) < 300) {
            this.f48096e.width = h0.H(300.0f);
        }
        int c2 = d.b.g0.g.k0.e.c.c();
        int b2 = d.b.g0.g.k0.e.c.b();
        if (h0.f(this.f48096e.width) > c2) {
            this.f48096e.width = h0.H(c2);
        }
        d.b.g0.e.a.r.f fVar2 = this.f48096e;
        fVar2.height = (int) (fVar2.width / d.b.g0.e.a.q.d.f48074a);
        if (fVar2.left < 0) {
            fVar2.left = 0;
        }
        int H = h0.H(c2);
        d.b.g0.e.a.r.f fVar3 = this.f48096e;
        int i = H - fVar3.width;
        if (fVar3.left > i) {
            fVar3.left = i;
        }
        d.b.g0.e.a.r.f fVar4 = this.f48096e;
        if (fVar4.top < 0) {
            fVar4.top = 0;
        }
        int H2 = h0.H(b2);
        d.b.g0.e.a.r.f fVar5 = this.f48096e;
        int i2 = H2 - fVar5.height;
        if (fVar5.top > i2) {
            fVar5.top = i2;
        }
        d.b.g0.e.a.r.f fVar6 = this.f48096e;
        fVar6.realWidth = fVar6.width;
        fVar6.realHeight = fVar6.height;
    }

    public final int y() {
        if (this.f48096e == null) {
            return 2;
        }
        int H = h0.H(d.b.g0.g.k0.e.c.b());
        int i = this.f48096e.top;
        int i2 = H / 3;
        if (i < i2) {
            return 1;
        }
        return i < i2 * 2 ? 4 : 2;
    }

    public final void z(View view) {
        AdElementInfo adElementInfo;
        if (!this.l || (adElementInfo = this.f48098g) == null || this.f48096e == null || view == null) {
            return;
        }
        d.b.g0.e.a.p.d.d(adElementInfo, this.f48097f);
        d.b.g0.e.a.p.b bVar = new d.b.g0.e.a.p.b();
        bVar.f48062a = String.valueOf(this.f48096e.width);
        bVar.f48063b = String.valueOf(this.f48096e.height);
        bVar.f48064c = String.valueOf(this.f48096e.width);
        bVar.f48065d = String.valueOf(this.f48096e.height);
        bVar.f48066e = String.valueOf((int) view.getX());
        bVar.f48067f = String.valueOf((int) view.getY());
        bVar.f48068g = String.valueOf((int) view.getX());
        bVar.f48069h = String.valueOf((int) view.getY());
        if (this.f48098g.h() == 2) {
            d.b.g0.e.a.p.d.a(bVar, this.f48098g, this.f48097f, new h());
            return;
        }
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            Context context = this.f48092a;
            if (context != null) {
                d.b.g0.a.q1.b.f.d.e(context, d.b.g0.a.h.aiapps_open_fragment_failed_toast).C();
                return;
            }
            return;
        }
        AdElementInfo adElementInfo2 = this.f48098g;
        if (adElementInfo2 != null) {
            String c2 = d.b.g0.e.a.p.d.c(adElementInfo2.l(), bVar);
            d.b.g0.a.e1.b c3 = d.b.g0.a.e1.b.c(c2, c2);
            f.b i = W.i("adLanding");
            i.n(d.b.g0.a.e0.l.f.f44405g, d.b.g0.a.e0.l.f.i);
            i.k("adLanding", c3).b();
        }
    }
}
