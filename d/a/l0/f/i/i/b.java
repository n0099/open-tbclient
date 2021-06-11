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
    public Context f50306a;

    /* renamed from: b  reason: collision with root package name */
    public String f50307b;

    /* renamed from: c  reason: collision with root package name */
    public String f50308c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.f.i.i.f f50309d;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.f.i.o.b f50311f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f50312g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.f.i.i.d f50313h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50314i;
    public String j;
    public boolean k;
    public d.a.l0.f.i.k.b l;
    public d.a.l0.f.i.l.f n;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.f.i.i.c f50310e = null;
    public Map<String, String> m = new TreeMap();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f50313h == null || b.this.f50313h.f() == null || !b.this.n.c(b.this.f50313h.f())) {
                return;
            }
            b.this.n.removeView(b.this.f50313h.f());
        }
    }

    /* renamed from: d.a.l0.f.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1030b implements d.a.l0.f.i.l.d {
        public C1030b() {
        }

        @Override // d.a.l0.f.i.l.d
        public void d(String str, String str2) {
        }

        @Override // d.a.l0.f.i.l.d
        public void f(View view) {
            if (b.this.k) {
                b.this.A(view);
                if (b.this.f50309d != null) {
                    b.this.f50309d.onClick();
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
            if (b.this.f50312g != null) {
                String l = b.this.f50312g.l();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("monitorUrl", d.a.l0.f.i.q.b.b("landingPageLoad", b.this.m));
                } catch (JSONException unused) {
                }
                b.this.n.a(l, jSONObject);
                d.a.l0.f.i.q.b.g(b.this.f50312g, b.this.f50311f);
                d.a.l0.f.i.q.b.n("lpClick", b.this.m, b.this.f50311f);
                d.a.l0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, b.this.m, b.this.f50311f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50318e;

        public d(String str) {
            this.f50318e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.f.i.i.c cVar = b.this.f50310e;
            boolean z = cVar.f50326c != cVar.f50328e;
            b.this.x();
            if (b.this.f50313h != null) {
                b.this.f50313h.e(b.this.f50310e.f50326c);
                b.this.n.f(b.this.f50313h.f(), new d.a.l0.f.i.i.a(d.a.l0.f.i.r.h.a(b.this.f50310e.f50324a), d.a.l0.f.i.r.h.a(b.this.f50310e.f50325b), d.a.l0.f.i.r.h.a(b.this.f50310e.f50328e), d.a.l0.f.i.r.h.a(b.this.f50310e.f50329f)));
            }
            if (this.f50318e.equals("width") && z && b.this.f50309d != null) {
                d.a.l0.f.i.i.f fVar = b.this.f50309d;
                d.a.l0.f.i.i.c cVar2 = b.this.f50310e;
                fVar.b(cVar2.f50328e, cVar2.f50329f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f50313h == null || !b.this.n.c(b.this.f50313h.f())) {
                if (b.this.f50309d != null) {
                    b.this.f50309d.onShow(false);
                    b.this.f50309d.onError("3010010");
                    return;
                }
                return;
            }
            b.this.f50313h.l();
            if (b.this.f50309d != null) {
                b.this.f50309d.onShow(true);
            }
            d.a.l0.f.i.q.b.n("showSuccess", b.this.m, b.this.f50311f);
            if (b.this.f50314i) {
                return;
            }
            b.this.f50314i = true;
            if (b.this.k) {
                d.a.l0.f.i.q.d.f(b.this.f50312g, b.this.f50311f);
                return;
            }
            d.a.l0.f.i.q.b.j(b.this.f50312g, b.this.f50311f);
            String str = b.this.f50308c;
            b bVar = b.this;
            d.a.l0.f.i.q.b.f(str, bVar.f50307b, bVar.j, b.this.f50311f);
            d.a.l0.f.i.q.b.n("show", b.this.m, b.this.f50311f);
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
                    b.this.l = new d.a.l0.f.i.k.b(b.this.f50306a, b.this.f50312g, b.this.f50311f);
                }
                b.this.l.k(str);
                d.a.l0.f.i.m.a.b().b(b.this.f50306a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.l);
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
            if (b.this.f50313h != null) {
                b.this.f50313h.g();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f50313h != null) {
                b.this.n.removeView(b.this.f50313h.f());
            }
            b.this.f50313h = null;
            b.this.f50309d = null;
            b.this.f50312g = null;
            if (b.this.l != null) {
                b.this.l.i();
                b.this.l = null;
            }
        }
    }

    public b(String str, String str2, d.a.l0.f.i.i.f fVar, d.a.l0.f.i.l.f fVar2) {
        Context appContext = AppRuntime.getAppContext();
        this.f50306a = appContext;
        this.f50308c = str;
        this.f50307b = str2;
        this.f50309d = fVar;
        this.n = fVar2;
        this.f50311f = new d.a.l0.f.i.o.b(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        if (!this.k || (adElementInfo = this.f50312g) == null || this.f50310e == null || view == null) {
            return;
        }
        d.a.l0.f.i.q.d.d(adElementInfo, this.f50311f);
        d.a.l0.f.i.q.a aVar = new d.a.l0.f.i.q.a();
        aVar.f50489a = String.valueOf(this.f50310e.f50326c);
        aVar.f50490b = String.valueOf(this.f50310e.f50327d);
        aVar.f50491c = String.valueOf(this.f50310e.f50326c);
        aVar.f50492d = String.valueOf(this.f50310e.f50327d);
        aVar.f50493e = String.valueOf((int) view.getX());
        aVar.f50494f = String.valueOf((int) view.getY());
        aVar.f50495g = String.valueOf((int) view.getX());
        aVar.f50496h = String.valueOf((int) view.getY());
        if (this.f50312g.h() == 2) {
            d.a.l0.f.i.q.d.a(aVar, this.f50312g, this.f50311f, new f());
            return;
        }
        AdElementInfo adElementInfo2 = this.f50312g;
        if (adElementInfo2 != null) {
            this.n.a(d.a.l0.f.i.q.d.c(adElementInfo2.l(), aVar), new JSONObject());
        }
    }

    public void B() {
        d.a.l0.f.i.r.d.c(new g());
    }

    public final void C() {
        d.a.l0.f.i.i.d dVar = new d.a.l0.f.i.i.d(this.f50306a, this.f50312g, this.f50307b, this.k);
        this.f50313h = dVar;
        dVar.i(this);
        if (this.k) {
            this.f50313h.k(new C1030b());
        } else {
            this.f50313h.j(new c());
        }
        this.f50313h.e(this.f50310e.f50326c);
        if (this.n.c(this.f50313h.f())) {
            this.n.removeView(this.f50313h.f());
        }
        if (this.n.d(this.f50313h.f(), new d.a.l0.f.i.i.a(d.a.l0.f.i.r.h.a(this.f50310e.f50324a), d.a.l0.f.i.r.h.a(this.f50310e.f50325b), d.a.l0.f.i.r.h.a(this.f50310e.f50328e), d.a.l0.f.i.r.h.a(this.f50310e.f50329f)))) {
            d.a.l0.f.i.i.f fVar = this.f50309d;
            if (fVar != null) {
                fVar.a(true, "");
                return;
            }
            return;
        }
        d.a.l0.f.i.i.f fVar2 = this.f50309d;
        if (fVar2 != null) {
            fVar2.onError("3010000");
        }
    }

    public final void D() {
        d.a.l0.f.i.o.e dVar;
        d.a.l0.f.i.q.b.n("loadApi", this.m, this.f50311f);
        String appKey = d.a.l0.f.i.m.a.b().getAppKey();
        c.b bVar = new c.b();
        bVar.m(this.f50308c);
        bVar.j(this.f50307b);
        bVar.o(appKey);
        bVar.n("game");
        bVar.k("banner");
        bVar.l(this.f50310e.f50326c);
        bVar.i(this.f50310e.f50327d);
        d.a.l0.f.i.o.c h2 = bVar.h();
        if (this.k) {
            dVar = new d.a.l0.f.i.o.f(this.f50306a, h2, 1, z());
        } else {
            dVar = new d.a.l0.f.i.o.d(this.f50306a, h2);
            this.j = dVar.c();
        }
        d.a.l0.f.i.o.a aVar = new d.a.l0.f.i.o.a(this.f50306a, false);
        aVar.k(this);
        aVar.i(dVar, this.f50311f);
    }

    public void E(int i2, int i3, int i4, int i5) {
        this.f50310e = new d.a.l0.f.i.i.c(i2, i3, i4, i5);
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
        d.a.l0.f.i.i.f fVar = this.f50309d;
        if (fVar != null) {
            fVar.onError(str);
        }
        String appId = d.a.l0.f.i.m.a.b().getAppId();
        if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
            w();
        }
        d.a.l0.f.i.i.f fVar2 = this.f50309d;
        if (fVar2 != null) {
            fVar2.a(false, "");
        }
    }

    @Override // d.a.l0.f.i.i.d.e
    public void b() {
        d.a.l0.f.i.i.f fVar = this.f50309d;
        if (fVar != null) {
            fVar.onClose();
        }
    }

    @Override // d.a.l0.f.i.l.b
    public void c(AdElementInfo adElementInfo) {
        this.f50312g = adElementInfo;
        C();
    }

    public final void w() {
        d.a.l0.f.i.i.d dVar = new d.a.l0.f.i.i.d(this.f50306a);
        this.f50313h = dVar;
        dVar.e(this.f50310e.f50326c);
        if (this.f50313h.f() == null) {
            return;
        }
        if (this.n.c(this.f50313h.f())) {
            this.n.removeView(this.f50313h.f());
        }
        this.n.d(this.f50313h.f(), new d.a.l0.f.i.i.a(d.a.l0.f.i.r.h.a(this.f50310e.f50324a), d.a.l0.f.i.r.h.a(this.f50310e.f50325b), d.a.l0.f.i.r.h.a(this.f50310e.f50328e), d.a.l0.f.i.r.h.a(this.f50310e.f50329f)));
        this.f50313h.f().postDelayed(new a(), 20000L);
    }

    public final void x() {
        d.a.l0.f.i.i.c cVar = this.f50310e;
        if (cVar == null) {
            return;
        }
        if (d.a.l0.f.i.r.h.a(cVar.f50326c) < 300) {
            this.f50310e.f50326c = d.a.l0.f.i.r.h.p(300.0f);
        }
        int q = d.a.l0.f.i.m.a.b().q();
        int p = d.a.l0.f.i.m.a.b().p();
        if (d.a.l0.f.i.r.h.a(this.f50310e.f50326c) > q) {
            this.f50310e.f50326c = d.a.l0.f.i.r.h.p(q);
        }
        d.a.l0.f.i.i.c cVar2 = this.f50310e;
        cVar2.f50327d = (int) (cVar2.f50326c / d.a.l0.f.i.i.e.f50343a);
        if (cVar2.f50324a < 0) {
            cVar2.f50324a = 0;
        }
        int p2 = d.a.l0.f.i.r.h.p(q);
        d.a.l0.f.i.i.c cVar3 = this.f50310e;
        int i2 = p2 - cVar3.f50326c;
        if (cVar3.f50324a > i2) {
            cVar3.f50324a = i2;
        }
        d.a.l0.f.i.i.c cVar4 = this.f50310e;
        if (cVar4.f50325b < 0) {
            cVar4.f50325b = 0;
        }
        int p3 = d.a.l0.f.i.r.h.p(p);
        d.a.l0.f.i.i.c cVar5 = this.f50310e;
        int i3 = p3 - cVar5.f50327d;
        if (cVar5.f50325b > i3) {
            cVar5.f50325b = i3;
        }
        d.a.l0.f.i.i.c cVar6 = this.f50310e;
        cVar6.f50328e = cVar6.f50326c;
        cVar6.f50329f = cVar6.f50327d;
    }

    public void y() {
        d.a.l0.f.i.r.d.c(new h());
    }

    public final int z() {
        if (this.f50310e == null) {
            return 2;
        }
        int p = d.a.l0.f.i.r.h.p(d.a.l0.f.i.m.a.b().p());
        int i2 = this.f50310e.f50325b;
        int i3 = p / 3;
        if (i2 < i3) {
            return 1;
        }
        return i2 < i3 * 2 ? 4 : 2;
    }
}
