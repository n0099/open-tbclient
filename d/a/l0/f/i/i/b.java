package d.a.l0.f.i.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import d.a.l0.f.i.i.d;
import d.a.l0.f.i.o.c;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d.a.l0.f.i.l.b, d.e {

    /* renamed from: a  reason: collision with root package name */
    public Context f46632a;

    /* renamed from: b  reason: collision with root package name */
    public String f46633b;

    /* renamed from: c  reason: collision with root package name */
    public String f46634c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.f.i.i.f f46635d;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.f.i.o.b f46637f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f46638g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.f.i.i.d f46639h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46640i;
    public String j;
    public boolean k;
    public d.a.l0.f.i.k.b l;
    public d.a.l0.f.i.l.f n;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.f.i.i.c f46636e = null;
    public Map<String, String> m = new TreeMap();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f46639h == null || b.this.f46639h.f() == null || !b.this.n.c(b.this.f46639h.f())) {
                return;
            }
            b.this.n.removeView(b.this.f46639h.f());
        }
    }

    /* renamed from: d.a.l0.f.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0974b implements d.a.l0.f.i.l.d {
        public C0974b() {
        }

        @Override // d.a.l0.f.i.l.d
        public void d(String str, String str2) {
        }

        @Override // d.a.l0.f.i.l.d
        public void f(View view) {
            if (b.this.k) {
                b.this.A(view);
                if (b.this.f46635d != null) {
                    b.this.f46635d.onClick();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.f.i.l.a {
        public c() {
        }

        @Override // d.a.l0.f.i.l.a
        public void b(CommandType commandType, Uri uri) {
            if (b.this.f46638g != null) {
                String l = b.this.f46638g.l();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("monitorUrl", d.a.l0.f.i.q.b.b("landingPageLoad", b.this.m));
                } catch (JSONException unused) {
                }
                b.this.n.a(l, jSONObject);
                d.a.l0.f.i.q.b.g(b.this.f46638g, b.this.f46637f);
                d.a.l0.f.i.q.b.n("lpClick", b.this.m, b.this.f46637f);
                d.a.l0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, b.this.m, b.this.f46637f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46644e;

        public d(String str) {
            this.f46644e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.f.i.i.c cVar = b.this.f46636e;
            boolean z = cVar.f46652c != cVar.f46654e;
            b.this.x();
            if (b.this.f46639h != null) {
                b.this.f46639h.e(b.this.f46636e.f46652c);
                b.this.n.f(b.this.f46639h.f(), new d.a.l0.f.i.i.a(d.a.l0.f.i.r.h.a(b.this.f46636e.f46650a), d.a.l0.f.i.r.h.a(b.this.f46636e.f46651b), d.a.l0.f.i.r.h.a(b.this.f46636e.f46654e), d.a.l0.f.i.r.h.a(b.this.f46636e.f46655f)));
            }
            if (this.f46644e.equals("width") && z && b.this.f46635d != null) {
                d.a.l0.f.i.i.f fVar = b.this.f46635d;
                d.a.l0.f.i.i.c cVar2 = b.this.f46636e;
                fVar.b(cVar2.f46654e, cVar2.f46655f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f46639h == null || !b.this.n.c(b.this.f46639h.f())) {
                if (b.this.f46635d != null) {
                    b.this.f46635d.onShow(false);
                    b.this.f46635d.onError("3010010");
                    return;
                }
                return;
            }
            b.this.f46639h.l();
            if (b.this.f46635d != null) {
                b.this.f46635d.onShow(true);
            }
            d.a.l0.f.i.q.b.n("showSuccess", b.this.m, b.this.f46637f);
            if (b.this.f46640i) {
                return;
            }
            b.this.f46640i = true;
            if (b.this.k) {
                d.a.l0.f.i.q.d.f(b.this.f46638g, b.this.f46637f);
                return;
            }
            d.a.l0.f.i.q.b.j(b.this.f46638g, b.this.f46637f);
            String str = b.this.f46634c;
            b bVar = b.this;
            d.a.l0.f.i.q.b.f(str, bVar.f46633b, bVar.j, b.this.f46637f);
            d.a.l0.f.i.q.b.n("show", b.this.m, b.this.f46637f);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.l0.f.i.l.d {
        public f() {
        }

        @Override // d.a.l0.f.i.l.d
        public void d(String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (b.this.l == null) {
                    b.this.l = new d.a.l0.f.i.k.b(b.this.f46632a, b.this.f46638g, b.this.f46637f);
                }
                b.this.l.k(str);
                d.a.l0.f.i.m.a.b().b(b.this.f46632a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.l);
            } catch (JSONException unused) {
            }
        }

        @Override // d.a.l0.f.i.l.d
        public void f(View view) {
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f46639h != null) {
                b.this.f46639h.g();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f46639h != null) {
                b.this.n.removeView(b.this.f46639h.f());
            }
            b.this.f46639h = null;
            b.this.f46635d = null;
            b.this.f46638g = null;
            if (b.this.l != null) {
                b.this.l.i();
                b.this.l = null;
            }
        }
    }

    public b(String str, String str2, d.a.l0.f.i.i.f fVar, d.a.l0.f.i.l.f fVar2) {
        Context appContext = AppRuntime.getAppContext();
        this.f46632a = appContext;
        this.f46634c = str;
        this.f46633b = str2;
        this.f46635d = fVar;
        this.n = fVar2;
        this.f46637f = new d.a.l0.f.i.o.b(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        if (!this.k || (adElementInfo = this.f46638g) == null || this.f46636e == null || view == null) {
            return;
        }
        d.a.l0.f.i.q.d.d(adElementInfo, this.f46637f);
        d.a.l0.f.i.q.a aVar = new d.a.l0.f.i.q.a();
        aVar.f46815a = String.valueOf(this.f46636e.f46652c);
        aVar.f46816b = String.valueOf(this.f46636e.f46653d);
        aVar.f46817c = String.valueOf(this.f46636e.f46652c);
        aVar.f46818d = String.valueOf(this.f46636e.f46653d);
        aVar.f46819e = String.valueOf((int) view.getX());
        aVar.f46820f = String.valueOf((int) view.getY());
        aVar.f46821g = String.valueOf((int) view.getX());
        aVar.f46822h = String.valueOf((int) view.getY());
        if (this.f46638g.h() == 2) {
            d.a.l0.f.i.q.d.a(aVar, this.f46638g, this.f46637f, new f());
            return;
        }
        AdElementInfo adElementInfo2 = this.f46638g;
        if (adElementInfo2 != null) {
            this.n.a(d.a.l0.f.i.q.d.c(adElementInfo2.l(), aVar), new JSONObject());
        }
    }

    public void B() {
        d.a.l0.f.i.r.d.c(new g());
    }

    public final void C() {
        d.a.l0.f.i.i.d dVar = new d.a.l0.f.i.i.d(this.f46632a, this.f46638g, this.f46633b, this.k);
        this.f46639h = dVar;
        dVar.i(this);
        if (this.k) {
            this.f46639h.k(new C0974b());
        } else {
            this.f46639h.j(new c());
        }
        this.f46639h.e(this.f46636e.f46652c);
        if (this.n.c(this.f46639h.f())) {
            this.n.removeView(this.f46639h.f());
        }
        if (this.n.d(this.f46639h.f(), new d.a.l0.f.i.i.a(d.a.l0.f.i.r.h.a(this.f46636e.f46650a), d.a.l0.f.i.r.h.a(this.f46636e.f46651b), d.a.l0.f.i.r.h.a(this.f46636e.f46654e), d.a.l0.f.i.r.h.a(this.f46636e.f46655f)))) {
            d.a.l0.f.i.i.f fVar = this.f46635d;
            if (fVar != null) {
                fVar.a(true, "");
                return;
            }
            return;
        }
        d.a.l0.f.i.i.f fVar2 = this.f46635d;
        if (fVar2 != null) {
            fVar2.onError("3010000");
        }
    }

    public final void D() {
        d.a.l0.f.i.o.e dVar;
        d.a.l0.f.i.q.b.n("loadApi", this.m, this.f46637f);
        String v = d.a.l0.f.i.m.a.b().v();
        c.b bVar = new c.b();
        bVar.m(this.f46634c);
        bVar.j(this.f46633b);
        bVar.o(v);
        bVar.n("game");
        bVar.k("banner");
        bVar.l(this.f46636e.f46652c);
        bVar.i(this.f46636e.f46653d);
        d.a.l0.f.i.o.c h2 = bVar.h();
        if (this.k) {
            dVar = new d.a.l0.f.i.o.f(this.f46632a, h2, 1, z());
        } else {
            dVar = new d.a.l0.f.i.o.d(this.f46632a, h2);
            this.j = dVar.c();
        }
        d.a.l0.f.i.o.a aVar = new d.a.l0.f.i.o.a(this.f46632a, false);
        aVar.k(this);
        aVar.i(dVar, this.f46637f);
    }

    public void E(int i2, int i3, int i4, int i5) {
        this.f46636e = new d.a.l0.f.i.i.c(i2, i3, i4, i5);
        x();
    }

    public void F(Map<String, String> map) {
        this.m = map;
    }

    public void G(JsObject jsObject) {
        d.a.l0.f.i.r.d.c(new e());
    }

    public void H(String str) {
        d.a.l0.f.i.r.d.c(new d(str));
    }

    @Override // d.a.l0.f.i.l.b
    public void a(String str) {
        d.a.l0.f.i.i.f fVar = this.f46635d;
        if (fVar != null) {
            fVar.onError(str);
        }
        String appId = d.a.l0.f.i.m.a.b().getAppId();
        if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
            w();
        }
        d.a.l0.f.i.i.f fVar2 = this.f46635d;
        if (fVar2 != null) {
            fVar2.a(false, "");
        }
    }

    @Override // d.a.l0.f.i.i.d.e
    public void b() {
        d.a.l0.f.i.i.f fVar = this.f46635d;
        if (fVar != null) {
            fVar.onClose();
        }
    }

    @Override // d.a.l0.f.i.l.b
    public void c(AdElementInfo adElementInfo) {
        this.f46638g = adElementInfo;
        C();
    }

    public final void w() {
        d.a.l0.f.i.i.d dVar = new d.a.l0.f.i.i.d(this.f46632a);
        this.f46639h = dVar;
        dVar.e(this.f46636e.f46652c);
        if (this.f46639h.f() == null) {
            return;
        }
        if (this.n.c(this.f46639h.f())) {
            this.n.removeView(this.f46639h.f());
        }
        this.n.d(this.f46639h.f(), new d.a.l0.f.i.i.a(d.a.l0.f.i.r.h.a(this.f46636e.f46650a), d.a.l0.f.i.r.h.a(this.f46636e.f46651b), d.a.l0.f.i.r.h.a(this.f46636e.f46654e), d.a.l0.f.i.r.h.a(this.f46636e.f46655f)));
        this.f46639h.f().postDelayed(new a(), 20000L);
    }

    public final void x() {
        d.a.l0.f.i.i.c cVar = this.f46636e;
        if (cVar == null) {
            return;
        }
        if (d.a.l0.f.i.r.h.a(cVar.f46652c) < 300) {
            this.f46636e.f46652c = d.a.l0.f.i.r.h.p(300.0f);
        }
        int q = d.a.l0.f.i.m.a.b().q();
        int p = d.a.l0.f.i.m.a.b().p();
        if (d.a.l0.f.i.r.h.a(this.f46636e.f46652c) > q) {
            this.f46636e.f46652c = d.a.l0.f.i.r.h.p(q);
        }
        d.a.l0.f.i.i.c cVar2 = this.f46636e;
        cVar2.f46653d = (int) (cVar2.f46652c / d.a.l0.f.i.i.e.f46669a);
        if (cVar2.f46650a < 0) {
            cVar2.f46650a = 0;
        }
        int p2 = d.a.l0.f.i.r.h.p(q);
        d.a.l0.f.i.i.c cVar3 = this.f46636e;
        int i2 = p2 - cVar3.f46652c;
        if (cVar3.f46650a > i2) {
            cVar3.f46650a = i2;
        }
        d.a.l0.f.i.i.c cVar4 = this.f46636e;
        if (cVar4.f46651b < 0) {
            cVar4.f46651b = 0;
        }
        int p3 = d.a.l0.f.i.r.h.p(p);
        d.a.l0.f.i.i.c cVar5 = this.f46636e;
        int i3 = p3 - cVar5.f46653d;
        if (cVar5.f46651b > i3) {
            cVar5.f46651b = i3;
        }
        d.a.l0.f.i.i.c cVar6 = this.f46636e;
        cVar6.f46654e = cVar6.f46652c;
        cVar6.f46655f = cVar6.f46653d;
    }

    public void y() {
        d.a.l0.f.i.r.d.c(new h());
    }

    public final int z() {
        if (this.f46636e == null) {
            return 2;
        }
        int p = d.a.l0.f.i.r.h.p(d.a.l0.f.i.m.a.b().p());
        int i2 = this.f46636e.f46651b;
        int i3 = p / 3;
        if (i2 < i3) {
            return 1;
        }
        return i2 < i3 * 2 ? 4 : 2;
    }
}
