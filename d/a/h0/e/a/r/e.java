package d.a.h0.e.a.r;

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
import d.a.h0.a.e0.l.f;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.e.a.a;
import d.a.h0.e.a.o.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements d.a.h0.e.a.m.b {

    /* renamed from: a  reason: collision with root package name */
    public Context f45879a;

    /* renamed from: b  reason: collision with root package name */
    public String f45880b;

    /* renamed from: c  reason: collision with root package name */
    public String f45881c;

    /* renamed from: d  reason: collision with root package name */
    public i f45882d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.e.a.r.f f45883e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.e.a.r.b f45884f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f45885g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.h0.e.a.a f45886h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45887i;
    public String j;
    public a.e k;
    public boolean l;
    public d.a.h0.e.a.r.g m;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f45888e;

        public a(l lVar) {
            this.f45888e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f45886h != null && d.a.h0.g.k0.e.c.g(e.this.f45886h.h())) {
                e.this.f45886h.n();
                l lVar = this.f45888e;
                if (lVar != null) {
                    lVar.c();
                }
                if (e.this.f45887i) {
                    return;
                }
                e.this.f45887i = true;
                if (e.this.l) {
                    d.a.h0.e.a.p.d.f(e.this.f45885g, e.this.f45884f);
                    return;
                }
                d.a.h0.e.a.p.c.g(e.this.f45885g, e.this.f45884f);
                String str = e.this.f45881c;
                e eVar = e.this;
                d.a.h0.e.a.p.c.c(str, eVar.f45880b, eVar.j, e.this.f45884f);
                return;
            }
            l lVar2 = this.f45888e;
            if (lVar2 != null) {
                lVar2.b("3010010");
            }
            if (e.this.f45882d != null) {
                e.this.f45882d.onError("3010010");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f45886h != null) {
                e.this.f45886h.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f45886h != null) {
                d.a.h0.g.k0.e.c.i(e.this.f45886h.h());
            }
            e.this.f45886h = null;
            e.this.f45882d = null;
            e.this.f45885g = null;
            if (e.this.m != null) {
                e.this.m.i();
                e.this.m = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45892e;

        public d(String str) {
            this.f45892e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.e.a.r.f fVar = e.this.f45883e;
            boolean z = fVar.width != fVar.realWidth;
            e.this.x();
            if (e.this.f45886h != null) {
                e.this.f45886h.g(e.this.f45883e.width);
                d.a.h0.g.k0.e.c.k(e.this.f45886h.h(), new d.a.h0.a.e1.d.a.a(h0.f(e.this.f45883e.left), h0.f(e.this.f45883e.top), h0.f(e.this.f45883e.realWidth), h0.f(e.this.f45883e.realHeight)));
            }
            if (this.f45892e.equals("width") && z && e.this.f45882d != null) {
                e.this.f45882d.b(e.this.f45883e);
            }
        }
    }

    /* renamed from: d.a.h0.e.a.r.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0909e implements Runnable {
        public RunnableC0909e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f45886h == null || !d.a.h0.g.k0.e.c.g(e.this.f45886h.h())) {
                return;
            }
            d.a.h0.g.k0.e.c.i(e.this.f45886h.h());
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.h0.e.a.m.d {
        public f() {
        }

        @Override // d.a.h0.e.a.m.d
        public void d(String str, String str2) {
        }

        @Override // d.a.h0.e.a.m.d
        public void f(View view) {
            if (e.this.l) {
                e.this.z(view);
                d.a.h0.g.k0.e.b.b("gdtbanner", PrefetchEvent.STATE_CLICK);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.h0.e.a.m.a {
        public g() {
        }

        @Override // d.a.h0.e.a.m.a
        public void b(CommandType commandType, Uri uri) {
            d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
            if (W == null) {
                if (e.this.f45879a != null) {
                    d.a.h0.a.q1.b.f.d.e(e.this.f45879a, d.a.h0.a.h.aiapps_open_fragment_failed_toast).C();
                }
            } else if (e.this.f45885g != null) {
                String l = e.this.f45885g.l();
                d.a.h0.a.e1.b c2 = d.a.h0.a.e1.b.c(l, l);
                f.b i2 = W.i("adLanding");
                i2.n(d.a.h0.a.e0.l.f.f42031g, d.a.h0.a.e0.l.f.f42033i);
                i2.k("adLanding", c2).b();
                d.a.h0.e.a.p.c.d(e.this.f45885g, e.this.f45884f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.a.h0.e.a.m.d {
        public h() {
        }

        @Override // d.a.h0.e.a.m.d
        public void d(String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (e.this.m == null) {
                    e.this.m = new d.a.h0.e.a.r.g(e.this.f45879a, e.this.f45885g, e.this.f45884f);
                }
                e.this.m.k(str);
                d.a.h0.a.w0.a.d().a(e.this.f45879a, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.m);
            } catch (JSONException e2) {
                if (d.a.h0.a.k.f43101a) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.a.h0.e.a.m.d
        public void f(View view) {
        }
    }

    public e(String str, String str2, d.a.h0.e.a.r.f fVar, a.e eVar, boolean z) {
        this.f45883e = null;
        Context appContext = AppRuntime.getAppContext();
        this.f45879a = appContext;
        this.f45881c = str;
        this.f45880b = str2;
        this.f45883e = fVar;
        this.k = eVar;
        this.f45884f = new d.a.h0.e.a.r.b(appContext);
        this.l = z;
        x();
        B();
    }

    public final void A() {
        d.a.h0.e.a.a aVar = new d.a.h0.e.a.a(this.f45879a, this.f45885g, this.f45880b, this.l);
        this.f45886h = aVar;
        aVar.k(this.k);
        if (this.l) {
            this.f45886h.m(new f());
        } else {
            this.f45886h.l(new g());
        }
        this.f45886h.g(this.f45883e.width);
        if (d.a.h0.g.k0.e.c.g(this.f45886h.h())) {
            d.a.h0.g.k0.e.c.i(this.f45886h.h());
        }
        if (d.a.h0.g.k0.e.c.a(this.f45886h.h(), new d.a.h0.a.e1.d.a.a(h0.f(this.f45883e.left), h0.f(this.f45883e.top), h0.f(this.f45883e.realWidth), h0.f(this.f45883e.realHeight)))) {
            i iVar = this.f45882d;
            if (iVar != null) {
                iVar.a();
                return;
            }
            return;
        }
        i iVar2 = this.f45882d;
        if (iVar2 != null) {
            iVar2.onError("3010000");
        }
    }

    public final void B() {
        d.a.h0.e.a.o.d cVar;
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        String B = h2 != null ? h2.B() : "";
        b.C0908b c0908b = new b.C0908b();
        c0908b.l(this.f45881c);
        c0908b.i(this.f45880b);
        c0908b.m(B);
        c0908b.k(this.f45883e.width);
        c0908b.h(this.f45883e.height);
        d.a.h0.e.a.o.b g2 = c0908b.g();
        if (this.l) {
            cVar = new d.a.h0.e.a.o.e(this.f45879a, g2, 1, y());
            d.a.h0.g.k0.e.b.b("gdtbanner", null);
        } else {
            cVar = new d.a.h0.e.a.o.c(this.f45879a, g2);
            this.j = cVar.c();
            d.a.h0.g.k0.e.b.b("banner", null);
        }
        d.a.h0.e.a.o.a aVar = new d.a.h0.e.a.o.a(this.f45879a, this.l);
        aVar.i(this);
        aVar.h(cVar, this.f45884f);
    }

    public void C(i iVar) {
        this.f45882d = iVar;
    }

    public void D(String str) {
        k0.X(new d(str));
    }

    @Override // d.a.h0.e.a.m.b
    public void a(String str) {
        i iVar = this.f45882d;
        if (iVar != null) {
            iVar.onError(str);
        }
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        String str2 = h2 != null ? h2.f43823f : "";
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            w();
        }
        d.a.h0.g.k0.e.b.c(this.l ? "gdtbanner" : "banner", "fail", str);
    }

    @Override // d.a.h0.e.a.m.b
    public void c(AdElementInfo adElementInfo) {
        this.f45885g = adElementInfo;
        A();
        d.a.h0.g.k0.e.b.b(this.l ? "gdtbanner" : "banner", "success");
    }

    public void t() {
        k0.X(new c());
    }

    public void u() {
        k0.X(new b());
    }

    public void v(JsObject jsObject) {
        k0.X(new a(l.d(d.a.h0.g.e.d.c.F(jsObject))));
    }

    public final void w() {
        d.a.h0.e.a.a aVar = new d.a.h0.e.a.a(this.f45879a);
        this.f45886h = aVar;
        aVar.g(this.f45883e.width);
        if (d.a.h0.g.k0.e.c.g(this.f45886h.h())) {
            d.a.h0.g.k0.e.c.i(this.f45886h.h());
        }
        d.a.h0.g.k0.e.c.a(this.f45886h.h(), new d.a.h0.a.e1.d.a.a(h0.f(this.f45883e.left), h0.f(this.f45883e.top), h0.f(this.f45883e.realWidth), h0.f(this.f45883e.realHeight)));
        this.f45886h.h().postDelayed(new RunnableC0909e(), 20000L);
    }

    public final void x() {
        d.a.h0.e.a.r.f fVar = this.f45883e;
        if (fVar == null) {
            return;
        }
        if (h0.f(fVar.width) < 300) {
            this.f45883e.width = h0.H(300.0f);
        }
        int c2 = d.a.h0.g.k0.e.c.c();
        int b2 = d.a.h0.g.k0.e.c.b();
        if (h0.f(this.f45883e.width) > c2) {
            this.f45883e.width = h0.H(c2);
        }
        d.a.h0.e.a.r.f fVar2 = this.f45883e;
        fVar2.height = (int) (fVar2.width / d.a.h0.e.a.q.d.f45859a);
        if (fVar2.left < 0) {
            fVar2.left = 0;
        }
        int H = h0.H(c2);
        d.a.h0.e.a.r.f fVar3 = this.f45883e;
        int i2 = H - fVar3.width;
        if (fVar3.left > i2) {
            fVar3.left = i2;
        }
        d.a.h0.e.a.r.f fVar4 = this.f45883e;
        if (fVar4.top < 0) {
            fVar4.top = 0;
        }
        int H2 = h0.H(b2);
        d.a.h0.e.a.r.f fVar5 = this.f45883e;
        int i3 = H2 - fVar5.height;
        if (fVar5.top > i3) {
            fVar5.top = i3;
        }
        d.a.h0.e.a.r.f fVar6 = this.f45883e;
        fVar6.realWidth = fVar6.width;
        fVar6.realHeight = fVar6.height;
    }

    public final int y() {
        if (this.f45883e == null) {
            return 2;
        }
        int H = h0.H(d.a.h0.g.k0.e.c.b());
        int i2 = this.f45883e.top;
        int i3 = H / 3;
        if (i2 < i3) {
            return 1;
        }
        return i2 < i3 * 2 ? 4 : 2;
    }

    public final void z(View view) {
        AdElementInfo adElementInfo;
        if (!this.l || (adElementInfo = this.f45885g) == null || this.f45883e == null || view == null) {
            return;
        }
        d.a.h0.e.a.p.d.d(adElementInfo, this.f45884f);
        d.a.h0.e.a.p.b bVar = new d.a.h0.e.a.p.b();
        bVar.f45846a = String.valueOf(this.f45883e.width);
        bVar.f45847b = String.valueOf(this.f45883e.height);
        bVar.f45848c = String.valueOf(this.f45883e.width);
        bVar.f45849d = String.valueOf(this.f45883e.height);
        bVar.f45850e = String.valueOf((int) view.getX());
        bVar.f45851f = String.valueOf((int) view.getY());
        bVar.f45852g = String.valueOf((int) view.getX());
        bVar.f45853h = String.valueOf((int) view.getY());
        if (this.f45885g.h() == 2) {
            d.a.h0.e.a.p.d.a(bVar, this.f45885g, this.f45884f, new h());
            return;
        }
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            Context context = this.f45879a;
            if (context != null) {
                d.a.h0.a.q1.b.f.d.e(context, d.a.h0.a.h.aiapps_open_fragment_failed_toast).C();
                return;
            }
            return;
        }
        AdElementInfo adElementInfo2 = this.f45885g;
        if (adElementInfo2 != null) {
            String c2 = d.a.h0.e.a.p.d.c(adElementInfo2.l(), bVar);
            d.a.h0.a.e1.b c3 = d.a.h0.a.e1.b.c(c2, c2);
            f.b i2 = W.i("adLanding");
            i2.n(d.a.h0.a.e0.l.f.f42031g, d.a.h0.a.e0.l.f.f42033i);
            i2.k("adLanding", c3).b();
        }
    }
}
