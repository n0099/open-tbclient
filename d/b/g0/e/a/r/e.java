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
    public Context f47699a;

    /* renamed from: b  reason: collision with root package name */
    public String f47700b;

    /* renamed from: c  reason: collision with root package name */
    public String f47701c;

    /* renamed from: d  reason: collision with root package name */
    public i f47702d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.e.a.r.f f47703e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.e.a.r.b f47704f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f47705g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.e.a.a f47706h;
    public boolean i;
    public String j;
    public a.e k;
    public boolean l;
    public d.b.g0.e.a.r.g m;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f47707e;

        public a(l lVar) {
            this.f47707e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f47706h != null && d.b.g0.g.k0.e.c.g(e.this.f47706h.h())) {
                e.this.f47706h.n();
                l lVar = this.f47707e;
                if (lVar != null) {
                    lVar.c();
                }
                if (e.this.i) {
                    return;
                }
                e.this.i = true;
                if (e.this.l) {
                    d.b.g0.e.a.p.d.f(e.this.f47705g, e.this.f47704f);
                    return;
                }
                d.b.g0.e.a.p.c.g(e.this.f47705g, e.this.f47704f);
                String str = e.this.f47701c;
                e eVar = e.this;
                d.b.g0.e.a.p.c.c(str, eVar.f47700b, eVar.j, e.this.f47704f);
                return;
            }
            l lVar2 = this.f47707e;
            if (lVar2 != null) {
                lVar2.b("3010010");
            }
            if (e.this.f47702d != null) {
                e.this.f47702d.onError("3010010");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f47706h != null) {
                e.this.f47706h.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f47706h != null) {
                d.b.g0.g.k0.e.c.i(e.this.f47706h.h());
            }
            e.this.f47706h = null;
            e.this.f47702d = null;
            e.this.f47705g = null;
            if (e.this.m != null) {
                e.this.m.i();
                e.this.m = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47711e;

        public d(String str) {
            this.f47711e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.e.a.r.f fVar = e.this.f47703e;
            boolean z = fVar.width != fVar.realWidth;
            e.this.x();
            if (e.this.f47706h != null) {
                e.this.f47706h.g(e.this.f47703e.width);
                d.b.g0.g.k0.e.c.k(e.this.f47706h.h(), new d.b.g0.a.e1.d.a.a(h0.f(e.this.f47703e.left), h0.f(e.this.f47703e.top), h0.f(e.this.f47703e.realWidth), h0.f(e.this.f47703e.realHeight)));
            }
            if (this.f47711e.equals("width") && z && e.this.f47702d != null) {
                e.this.f47702d.b(e.this.f47703e);
            }
        }
    }

    /* renamed from: d.b.g0.e.a.r.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0937e implements Runnable {
        public RunnableC0937e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f47706h == null || !d.b.g0.g.k0.e.c.g(e.this.f47706h.h())) {
                return;
            }
            d.b.g0.g.k0.e.c.i(e.this.f47706h.h());
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
                if (e.this.f47699a != null) {
                    d.b.g0.a.q1.b.f.d.e(e.this.f47699a, d.b.g0.a.h.aiapps_open_fragment_failed_toast).C();
                }
            } else if (e.this.f47705g != null) {
                String l = e.this.f47705g.l();
                d.b.g0.a.e1.b c2 = d.b.g0.a.e1.b.c(l, l);
                f.b i = W.i("adLanding");
                i.n(d.b.g0.a.e0.l.f.f44012g, d.b.g0.a.e0.l.f.i);
                i.k("adLanding", c2).b();
                d.b.g0.e.a.p.c.d(e.this.f47705g, e.this.f47704f);
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
                    e.this.m = new d.b.g0.e.a.r.g(e.this.f47699a, e.this.f47705g, e.this.f47704f);
                }
                e.this.m.k(str);
                d.b.g0.a.w0.a.d().a(e.this.f47699a, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.m);
            } catch (JSONException e2) {
                if (d.b.g0.a.k.f45050a) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.b.g0.e.a.m.d
        public void d(View view) {
        }
    }

    public e(String str, String str2, d.b.g0.e.a.r.f fVar, a.e eVar, boolean z) {
        this.f47703e = null;
        Context appContext = AppRuntime.getAppContext();
        this.f47699a = appContext;
        this.f47701c = str;
        this.f47700b = str2;
        this.f47703e = fVar;
        this.k = eVar;
        this.f47704f = new d.b.g0.e.a.r.b(appContext);
        this.l = z;
        x();
        B();
    }

    public final void A() {
        d.b.g0.e.a.a aVar = new d.b.g0.e.a.a(this.f47699a, this.f47705g, this.f47700b, this.l);
        this.f47706h = aVar;
        aVar.k(this.k);
        if (this.l) {
            this.f47706h.m(new f());
        } else {
            this.f47706h.l(new g());
        }
        this.f47706h.g(this.f47703e.width);
        if (d.b.g0.g.k0.e.c.g(this.f47706h.h())) {
            d.b.g0.g.k0.e.c.i(this.f47706h.h());
        }
        if (d.b.g0.g.k0.e.c.a(this.f47706h.h(), new d.b.g0.a.e1.d.a.a(h0.f(this.f47703e.left), h0.f(this.f47703e.top), h0.f(this.f47703e.realWidth), h0.f(this.f47703e.realHeight)))) {
            i iVar = this.f47702d;
            if (iVar != null) {
                iVar.a();
                return;
            }
            return;
        }
        i iVar2 = this.f47702d;
        if (iVar2 != null) {
            iVar2.onError("3010000");
        }
    }

    public final void B() {
        d.b.g0.e.a.o.d cVar;
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        String B = y != null ? y.B() : "";
        b.C0936b c0936b = new b.C0936b();
        c0936b.l(this.f47701c);
        c0936b.i(this.f47700b);
        c0936b.m(B);
        c0936b.k(this.f47703e.width);
        c0936b.h(this.f47703e.height);
        d.b.g0.e.a.o.b g2 = c0936b.g();
        if (this.l) {
            cVar = new d.b.g0.e.a.o.e(this.f47699a, g2, 1, y());
            d.b.g0.g.k0.e.b.b("gdtbanner", null);
        } else {
            cVar = new d.b.g0.e.a.o.c(this.f47699a, g2);
            this.j = cVar.c();
            d.b.g0.g.k0.e.b.b("banner", null);
        }
        d.b.g0.e.a.o.a aVar = new d.b.g0.e.a.o.a(this.f47699a, this.l);
        aVar.i(this);
        aVar.h(cVar, this.f47704f);
    }

    public void C(i iVar) {
        this.f47702d = iVar;
    }

    public void D(String str) {
        k0.X(new d(str));
    }

    @Override // d.b.g0.e.a.m.b
    public void c(String str) {
        i iVar = this.f47702d;
        if (iVar != null) {
            iVar.onError(str);
        }
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        String str2 = y != null ? y.f45739f : "";
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            w();
        }
        d.b.g0.g.k0.e.b.c(this.l ? "gdtbanner" : "banner", "fail", str);
    }

    @Override // d.b.g0.e.a.m.b
    public void f(AdElementInfo adElementInfo) {
        this.f47705g = adElementInfo;
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
        d.b.g0.e.a.a aVar = new d.b.g0.e.a.a(this.f47699a);
        this.f47706h = aVar;
        aVar.g(this.f47703e.width);
        if (d.b.g0.g.k0.e.c.g(this.f47706h.h())) {
            d.b.g0.g.k0.e.c.i(this.f47706h.h());
        }
        d.b.g0.g.k0.e.c.a(this.f47706h.h(), new d.b.g0.a.e1.d.a.a(h0.f(this.f47703e.left), h0.f(this.f47703e.top), h0.f(this.f47703e.realWidth), h0.f(this.f47703e.realHeight)));
        this.f47706h.h().postDelayed(new RunnableC0937e(), 20000L);
    }

    public final void x() {
        d.b.g0.e.a.r.f fVar = this.f47703e;
        if (fVar == null) {
            return;
        }
        if (h0.f(fVar.width) < 300) {
            this.f47703e.width = h0.H(300.0f);
        }
        int c2 = d.b.g0.g.k0.e.c.c();
        int b2 = d.b.g0.g.k0.e.c.b();
        if (h0.f(this.f47703e.width) > c2) {
            this.f47703e.width = h0.H(c2);
        }
        d.b.g0.e.a.r.f fVar2 = this.f47703e;
        fVar2.height = (int) (fVar2.width / d.b.g0.e.a.q.d.f47681a);
        if (fVar2.left < 0) {
            fVar2.left = 0;
        }
        int H = h0.H(c2);
        d.b.g0.e.a.r.f fVar3 = this.f47703e;
        int i = H - fVar3.width;
        if (fVar3.left > i) {
            fVar3.left = i;
        }
        d.b.g0.e.a.r.f fVar4 = this.f47703e;
        if (fVar4.top < 0) {
            fVar4.top = 0;
        }
        int H2 = h0.H(b2);
        d.b.g0.e.a.r.f fVar5 = this.f47703e;
        int i2 = H2 - fVar5.height;
        if (fVar5.top > i2) {
            fVar5.top = i2;
        }
        d.b.g0.e.a.r.f fVar6 = this.f47703e;
        fVar6.realWidth = fVar6.width;
        fVar6.realHeight = fVar6.height;
    }

    public final int y() {
        if (this.f47703e == null) {
            return 2;
        }
        int H = h0.H(d.b.g0.g.k0.e.c.b());
        int i = this.f47703e.top;
        int i2 = H / 3;
        if (i < i2) {
            return 1;
        }
        return i < i2 * 2 ? 4 : 2;
    }

    public final void z(View view) {
        AdElementInfo adElementInfo;
        if (!this.l || (adElementInfo = this.f47705g) == null || this.f47703e == null || view == null) {
            return;
        }
        d.b.g0.e.a.p.d.d(adElementInfo, this.f47704f);
        d.b.g0.e.a.p.b bVar = new d.b.g0.e.a.p.b();
        bVar.f47669a = String.valueOf(this.f47703e.width);
        bVar.f47670b = String.valueOf(this.f47703e.height);
        bVar.f47671c = String.valueOf(this.f47703e.width);
        bVar.f47672d = String.valueOf(this.f47703e.height);
        bVar.f47673e = String.valueOf((int) view.getX());
        bVar.f47674f = String.valueOf((int) view.getY());
        bVar.f47675g = String.valueOf((int) view.getX());
        bVar.f47676h = String.valueOf((int) view.getY());
        if (this.f47705g.h() == 2) {
            d.b.g0.e.a.p.d.a(bVar, this.f47705g, this.f47704f, new h());
            return;
        }
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            Context context = this.f47699a;
            if (context != null) {
                d.b.g0.a.q1.b.f.d.e(context, d.b.g0.a.h.aiapps_open_fragment_failed_toast).C();
                return;
            }
            return;
        }
        AdElementInfo adElementInfo2 = this.f47705g;
        if (adElementInfo2 != null) {
            String c2 = d.b.g0.e.a.p.d.c(adElementInfo2.l(), bVar);
            d.b.g0.a.e1.b c3 = d.b.g0.a.e1.b.c(c2, c2);
            f.b i = W.i("adLanding");
            i.n(d.b.g0.a.e0.l.f.f44012g, d.b.g0.a.e0.l.f.i);
            i.k("adLanding", c3).b();
        }
    }
}
