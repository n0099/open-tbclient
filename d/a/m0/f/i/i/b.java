package d.a.m0.f.i.i;

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
import d.a.m0.f.i.i.d;
import d.a.m0.f.i.o.c;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d.a.m0.f.i.l.b, d.e {

    /* renamed from: a  reason: collision with root package name */
    public Context f50414a;

    /* renamed from: b  reason: collision with root package name */
    public String f50415b;

    /* renamed from: c  reason: collision with root package name */
    public String f50416c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.f.i.i.f f50417d;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.f.i.o.b f50419f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f50420g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.f.i.i.d f50421h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50422i;
    public String j;
    public boolean k;
    public d.a.m0.f.i.k.b l;
    public d.a.m0.f.i.l.f n;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.f.i.i.c f50418e = null;
    public Map<String, String> m = new TreeMap();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f50421h == null || b.this.f50421h.f() == null || !b.this.n.c(b.this.f50421h.f())) {
                return;
            }
            b.this.n.removeView(b.this.f50421h.f());
        }
    }

    /* renamed from: d.a.m0.f.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1033b implements d.a.m0.f.i.l.d {
        public C1033b() {
        }

        @Override // d.a.m0.f.i.l.d
        public void d(String str, String str2) {
        }

        @Override // d.a.m0.f.i.l.d
        public void f(View view) {
            if (b.this.k) {
                b.this.A(view);
                if (b.this.f50417d != null) {
                    b.this.f50417d.onClick();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.m0.f.i.l.a {
        public c() {
        }

        @Override // d.a.m0.f.i.l.a
        public void b(CommandType commandType, Uri uri) {
            if (b.this.f50420g != null) {
                String l = b.this.f50420g.l();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("monitorUrl", d.a.m0.f.i.q.b.b("landingPageLoad", b.this.m));
                } catch (JSONException unused) {
                }
                b.this.n.a(l, jSONObject);
                d.a.m0.f.i.q.b.g(b.this.f50420g, b.this.f50419f);
                d.a.m0.f.i.q.b.n("lpClick", b.this.m, b.this.f50419f);
                d.a.m0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, b.this.m, b.this.f50419f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50426e;

        public d(String str) {
            this.f50426e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.f.i.i.c cVar = b.this.f50418e;
            boolean z = cVar.f50434c != cVar.f50436e;
            b.this.x();
            if (b.this.f50421h != null) {
                b.this.f50421h.e(b.this.f50418e.f50434c);
                b.this.n.f(b.this.f50421h.f(), new d.a.m0.f.i.i.a(d.a.m0.f.i.r.h.a(b.this.f50418e.f50432a), d.a.m0.f.i.r.h.a(b.this.f50418e.f50433b), d.a.m0.f.i.r.h.a(b.this.f50418e.f50436e), d.a.m0.f.i.r.h.a(b.this.f50418e.f50437f)));
            }
            if (this.f50426e.equals("width") && z && b.this.f50417d != null) {
                d.a.m0.f.i.i.f fVar = b.this.f50417d;
                d.a.m0.f.i.i.c cVar2 = b.this.f50418e;
                fVar.b(cVar2.f50436e, cVar2.f50437f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f50421h == null || !b.this.n.c(b.this.f50421h.f())) {
                if (b.this.f50417d != null) {
                    b.this.f50417d.onShow(false);
                    b.this.f50417d.onError("3010010");
                    return;
                }
                return;
            }
            b.this.f50421h.l();
            if (b.this.f50417d != null) {
                b.this.f50417d.onShow(true);
            }
            d.a.m0.f.i.q.b.n("showSuccess", b.this.m, b.this.f50419f);
            if (b.this.f50422i) {
                return;
            }
            b.this.f50422i = true;
            if (b.this.k) {
                d.a.m0.f.i.q.d.f(b.this.f50420g, b.this.f50419f);
                return;
            }
            d.a.m0.f.i.q.b.j(b.this.f50420g, b.this.f50419f);
            String str = b.this.f50416c;
            b bVar = b.this;
            d.a.m0.f.i.q.b.f(str, bVar.f50415b, bVar.j, b.this.f50419f);
            d.a.m0.f.i.q.b.n("show", b.this.m, b.this.f50419f);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.m0.f.i.l.d {
        public f() {
        }

        @Override // d.a.m0.f.i.l.d
        public void d(String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (b.this.l == null) {
                    b.this.l = new d.a.m0.f.i.k.b(b.this.f50414a, b.this.f50420g, b.this.f50419f);
                }
                b.this.l.k(str);
                d.a.m0.f.i.m.a.b().b(b.this.f50414a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.l);
            } catch (JSONException unused) {
            }
        }

        @Override // d.a.m0.f.i.l.d
        public void f(View view) {
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f50421h != null) {
                b.this.f50421h.g();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f50421h != null) {
                b.this.n.removeView(b.this.f50421h.f());
            }
            b.this.f50421h = null;
            b.this.f50417d = null;
            b.this.f50420g = null;
            if (b.this.l != null) {
                b.this.l.i();
                b.this.l = null;
            }
        }
    }

    public b(String str, String str2, d.a.m0.f.i.i.f fVar, d.a.m0.f.i.l.f fVar2) {
        Context appContext = AppRuntime.getAppContext();
        this.f50414a = appContext;
        this.f50416c = str;
        this.f50415b = str2;
        this.f50417d = fVar;
        this.n = fVar2;
        this.f50419f = new d.a.m0.f.i.o.b(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        if (!this.k || (adElementInfo = this.f50420g) == null || this.f50418e == null || view == null) {
            return;
        }
        d.a.m0.f.i.q.d.d(adElementInfo, this.f50419f);
        d.a.m0.f.i.q.a aVar = new d.a.m0.f.i.q.a();
        aVar.f50597a = String.valueOf(this.f50418e.f50434c);
        aVar.f50598b = String.valueOf(this.f50418e.f50435d);
        aVar.f50599c = String.valueOf(this.f50418e.f50434c);
        aVar.f50600d = String.valueOf(this.f50418e.f50435d);
        aVar.f50601e = String.valueOf((int) view.getX());
        aVar.f50602f = String.valueOf((int) view.getY());
        aVar.f50603g = String.valueOf((int) view.getX());
        aVar.f50604h = String.valueOf((int) view.getY());
        if (this.f50420g.h() == 2) {
            d.a.m0.f.i.q.d.a(aVar, this.f50420g, this.f50419f, new f());
            return;
        }
        AdElementInfo adElementInfo2 = this.f50420g;
        if (adElementInfo2 != null) {
            this.n.a(d.a.m0.f.i.q.d.c(adElementInfo2.l(), aVar), new JSONObject());
        }
    }

    public void B() {
        d.a.m0.f.i.r.d.c(new g());
    }

    public final void C() {
        d.a.m0.f.i.i.d dVar = new d.a.m0.f.i.i.d(this.f50414a, this.f50420g, this.f50415b, this.k);
        this.f50421h = dVar;
        dVar.i(this);
        if (this.k) {
            this.f50421h.k(new C1033b());
        } else {
            this.f50421h.j(new c());
        }
        this.f50421h.e(this.f50418e.f50434c);
        if (this.n.c(this.f50421h.f())) {
            this.n.removeView(this.f50421h.f());
        }
        if (this.n.d(this.f50421h.f(), new d.a.m0.f.i.i.a(d.a.m0.f.i.r.h.a(this.f50418e.f50432a), d.a.m0.f.i.r.h.a(this.f50418e.f50433b), d.a.m0.f.i.r.h.a(this.f50418e.f50436e), d.a.m0.f.i.r.h.a(this.f50418e.f50437f)))) {
            d.a.m0.f.i.i.f fVar = this.f50417d;
            if (fVar != null) {
                fVar.a(true, "");
                return;
            }
            return;
        }
        d.a.m0.f.i.i.f fVar2 = this.f50417d;
        if (fVar2 != null) {
            fVar2.onError("3010000");
        }
    }

    public final void D() {
        d.a.m0.f.i.o.e dVar;
        d.a.m0.f.i.q.b.n("loadApi", this.m, this.f50419f);
        String appKey = d.a.m0.f.i.m.a.b().getAppKey();
        c.b bVar = new c.b();
        bVar.m(this.f50416c);
        bVar.j(this.f50415b);
        bVar.o(appKey);
        bVar.n("game");
        bVar.k("banner");
        bVar.l(this.f50418e.f50434c);
        bVar.i(this.f50418e.f50435d);
        d.a.m0.f.i.o.c h2 = bVar.h();
        if (this.k) {
            dVar = new d.a.m0.f.i.o.f(this.f50414a, h2, 1, z());
        } else {
            dVar = new d.a.m0.f.i.o.d(this.f50414a, h2);
            this.j = dVar.c();
        }
        d.a.m0.f.i.o.a aVar = new d.a.m0.f.i.o.a(this.f50414a, false);
        aVar.k(this);
        aVar.i(dVar, this.f50419f);
    }

    public void E(int i2, int i3, int i4, int i5) {
        this.f50418e = new d.a.m0.f.i.i.c(i2, i3, i4, i5);
        x();
    }

    public void F(Map<String, String> map) {
        this.m = map;
    }

    public void G(JsObject jsObject) {
        d.a.m0.f.i.r.d.c(new e());
    }

    public void H(String str) {
        d.a.m0.f.i.r.d.c(new d(str));
    }

    @Override // d.a.m0.f.i.l.b
    public void a(String str) {
        d.a.m0.f.i.i.f fVar = this.f50417d;
        if (fVar != null) {
            fVar.onError(str);
        }
        String appId = d.a.m0.f.i.m.a.b().getAppId();
        if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
            w();
        }
        d.a.m0.f.i.i.f fVar2 = this.f50417d;
        if (fVar2 != null) {
            fVar2.a(false, "");
        }
    }

    @Override // d.a.m0.f.i.i.d.e
    public void b() {
        d.a.m0.f.i.i.f fVar = this.f50417d;
        if (fVar != null) {
            fVar.onClose();
        }
    }

    @Override // d.a.m0.f.i.l.b
    public void c(AdElementInfo adElementInfo) {
        this.f50420g = adElementInfo;
        C();
    }

    public final void w() {
        d.a.m0.f.i.i.d dVar = new d.a.m0.f.i.i.d(this.f50414a);
        this.f50421h = dVar;
        dVar.e(this.f50418e.f50434c);
        if (this.f50421h.f() == null) {
            return;
        }
        if (this.n.c(this.f50421h.f())) {
            this.n.removeView(this.f50421h.f());
        }
        this.n.d(this.f50421h.f(), new d.a.m0.f.i.i.a(d.a.m0.f.i.r.h.a(this.f50418e.f50432a), d.a.m0.f.i.r.h.a(this.f50418e.f50433b), d.a.m0.f.i.r.h.a(this.f50418e.f50436e), d.a.m0.f.i.r.h.a(this.f50418e.f50437f)));
        this.f50421h.f().postDelayed(new a(), 20000L);
    }

    public final void x() {
        d.a.m0.f.i.i.c cVar = this.f50418e;
        if (cVar == null) {
            return;
        }
        if (d.a.m0.f.i.r.h.a(cVar.f50434c) < 300) {
            this.f50418e.f50434c = d.a.m0.f.i.r.h.p(300.0f);
        }
        int q = d.a.m0.f.i.m.a.b().q();
        int p = d.a.m0.f.i.m.a.b().p();
        if (d.a.m0.f.i.r.h.a(this.f50418e.f50434c) > q) {
            this.f50418e.f50434c = d.a.m0.f.i.r.h.p(q);
        }
        d.a.m0.f.i.i.c cVar2 = this.f50418e;
        cVar2.f50435d = (int) (cVar2.f50434c / d.a.m0.f.i.i.e.f50451a);
        if (cVar2.f50432a < 0) {
            cVar2.f50432a = 0;
        }
        int p2 = d.a.m0.f.i.r.h.p(q);
        d.a.m0.f.i.i.c cVar3 = this.f50418e;
        int i2 = p2 - cVar3.f50434c;
        if (cVar3.f50432a > i2) {
            cVar3.f50432a = i2;
        }
        d.a.m0.f.i.i.c cVar4 = this.f50418e;
        if (cVar4.f50433b < 0) {
            cVar4.f50433b = 0;
        }
        int p3 = d.a.m0.f.i.r.h.p(p);
        d.a.m0.f.i.i.c cVar5 = this.f50418e;
        int i3 = p3 - cVar5.f50435d;
        if (cVar5.f50433b > i3) {
            cVar5.f50433b = i3;
        }
        d.a.m0.f.i.i.c cVar6 = this.f50418e;
        cVar6.f50436e = cVar6.f50434c;
        cVar6.f50437f = cVar6.f50435d;
    }

    public void y() {
        d.a.m0.f.i.r.d.c(new h());
    }

    public final int z() {
        if (this.f50418e == null) {
            return 2;
        }
        int p = d.a.m0.f.i.r.h.p(d.a.m0.f.i.m.a.b().p());
        int i2 = this.f50418e.f50433b;
        int i3 = p / 3;
        if (i2 < i3) {
            return 1;
        }
        return i2 < i3 * 2 ? 4 : 2;
    }
}
