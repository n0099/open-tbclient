package d.a.i0.f.i.i;

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
import d.a.i0.f.i.i.d;
import d.a.i0.f.i.o.c;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d.a.i0.f.i.l.b, d.e {

    /* renamed from: a  reason: collision with root package name */
    public Context f46456a;

    /* renamed from: b  reason: collision with root package name */
    public String f46457b;

    /* renamed from: c  reason: collision with root package name */
    public String f46458c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.f.i.i.f f46459d;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.f.i.o.b f46461f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f46462g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.i0.f.i.i.d f46463h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46464i;
    public String j;
    public boolean k;
    public d.a.i0.f.i.k.b l;
    public d.a.i0.f.i.l.f n;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.f.i.i.c f46460e = null;
    public Map<String, String> m = new TreeMap();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f46463h == null || b.this.f46463h.f() == null || !b.this.n.c(b.this.f46463h.f())) {
                return;
            }
            b.this.n.removeView(b.this.f46463h.f());
        }
    }

    /* renamed from: d.a.i0.f.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0963b implements d.a.i0.f.i.l.d {
        public C0963b() {
        }

        @Override // d.a.i0.f.i.l.d
        public void d(String str, String str2) {
        }

        @Override // d.a.i0.f.i.l.d
        public void f(View view) {
            if (b.this.k) {
                b.this.A(view);
                if (b.this.f46459d != null) {
                    b.this.f46459d.onClick();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.i0.f.i.l.a {
        public c() {
        }

        @Override // d.a.i0.f.i.l.a
        public void b(CommandType commandType, Uri uri) {
            if (b.this.f46462g != null) {
                String l = b.this.f46462g.l();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("monitorUrl", d.a.i0.f.i.q.b.b("landingPageLoad", b.this.m));
                } catch (JSONException unused) {
                }
                b.this.n.a(l, jSONObject);
                d.a.i0.f.i.q.b.g(b.this.f46462g, b.this.f46461f);
                d.a.i0.f.i.q.b.n("lpClick", b.this.m, b.this.f46461f);
                d.a.i0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, b.this.m, b.this.f46461f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46468e;

        public d(String str) {
            this.f46468e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.f.i.i.c cVar = b.this.f46460e;
            boolean z = cVar.f46476c != cVar.f46478e;
            b.this.x();
            if (b.this.f46463h != null) {
                b.this.f46463h.e(b.this.f46460e.f46476c);
                b.this.n.f(b.this.f46463h.f(), new d.a.i0.f.i.i.a(d.a.i0.f.i.r.h.a(b.this.f46460e.f46474a), d.a.i0.f.i.r.h.a(b.this.f46460e.f46475b), d.a.i0.f.i.r.h.a(b.this.f46460e.f46478e), d.a.i0.f.i.r.h.a(b.this.f46460e.f46479f)));
            }
            if (this.f46468e.equals("width") && z && b.this.f46459d != null) {
                d.a.i0.f.i.i.f fVar = b.this.f46459d;
                d.a.i0.f.i.i.c cVar2 = b.this.f46460e;
                fVar.b(cVar2.f46478e, cVar2.f46479f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f46463h == null || !b.this.n.c(b.this.f46463h.f())) {
                if (b.this.f46459d != null) {
                    b.this.f46459d.onShow(false);
                    b.this.f46459d.onError("3010010");
                    return;
                }
                return;
            }
            b.this.f46463h.l();
            if (b.this.f46459d != null) {
                b.this.f46459d.onShow(true);
            }
            d.a.i0.f.i.q.b.n("showSuccess", b.this.m, b.this.f46461f);
            if (b.this.f46464i) {
                return;
            }
            b.this.f46464i = true;
            if (b.this.k) {
                d.a.i0.f.i.q.d.f(b.this.f46462g, b.this.f46461f);
                return;
            }
            d.a.i0.f.i.q.b.j(b.this.f46462g, b.this.f46461f);
            String str = b.this.f46458c;
            b bVar = b.this;
            d.a.i0.f.i.q.b.f(str, bVar.f46457b, bVar.j, b.this.f46461f);
            d.a.i0.f.i.q.b.n("show", b.this.m, b.this.f46461f);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.i0.f.i.l.d {
        public f() {
        }

        @Override // d.a.i0.f.i.l.d
        public void d(String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (b.this.l == null) {
                    b.this.l = new d.a.i0.f.i.k.b(b.this.f46456a, b.this.f46462g, b.this.f46461f);
                }
                b.this.l.k(str);
                d.a.i0.f.i.m.a.b().b(b.this.f46456a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.l);
            } catch (JSONException unused) {
            }
        }

        @Override // d.a.i0.f.i.l.d
        public void f(View view) {
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f46463h != null) {
                b.this.f46463h.g();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f46463h != null) {
                b.this.n.removeView(b.this.f46463h.f());
            }
            b.this.f46463h = null;
            b.this.f46459d = null;
            b.this.f46462g = null;
            if (b.this.l != null) {
                b.this.l.i();
                b.this.l = null;
            }
        }
    }

    public b(String str, String str2, d.a.i0.f.i.i.f fVar, d.a.i0.f.i.l.f fVar2) {
        Context appContext = AppRuntime.getAppContext();
        this.f46456a = appContext;
        this.f46458c = str;
        this.f46457b = str2;
        this.f46459d = fVar;
        this.n = fVar2;
        this.f46461f = new d.a.i0.f.i.o.b(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        if (!this.k || (adElementInfo = this.f46462g) == null || this.f46460e == null || view == null) {
            return;
        }
        d.a.i0.f.i.q.d.d(adElementInfo, this.f46461f);
        d.a.i0.f.i.q.a aVar = new d.a.i0.f.i.q.a();
        aVar.f46639a = String.valueOf(this.f46460e.f46476c);
        aVar.f46640b = String.valueOf(this.f46460e.f46477d);
        aVar.f46641c = String.valueOf(this.f46460e.f46476c);
        aVar.f46642d = String.valueOf(this.f46460e.f46477d);
        aVar.f46643e = String.valueOf((int) view.getX());
        aVar.f46644f = String.valueOf((int) view.getY());
        aVar.f46645g = String.valueOf((int) view.getX());
        aVar.f46646h = String.valueOf((int) view.getY());
        if (this.f46462g.h() == 2) {
            d.a.i0.f.i.q.d.a(aVar, this.f46462g, this.f46461f, new f());
            return;
        }
        AdElementInfo adElementInfo2 = this.f46462g;
        if (adElementInfo2 != null) {
            this.n.a(d.a.i0.f.i.q.d.c(adElementInfo2.l(), aVar), new JSONObject());
        }
    }

    public void B() {
        d.a.i0.f.i.r.d.c(new g());
    }

    public final void C() {
        d.a.i0.f.i.i.d dVar = new d.a.i0.f.i.i.d(this.f46456a, this.f46462g, this.f46457b, this.k);
        this.f46463h = dVar;
        dVar.i(this);
        if (this.k) {
            this.f46463h.k(new C0963b());
        } else {
            this.f46463h.j(new c());
        }
        this.f46463h.e(this.f46460e.f46476c);
        if (this.n.c(this.f46463h.f())) {
            this.n.removeView(this.f46463h.f());
        }
        if (this.n.d(this.f46463h.f(), new d.a.i0.f.i.i.a(d.a.i0.f.i.r.h.a(this.f46460e.f46474a), d.a.i0.f.i.r.h.a(this.f46460e.f46475b), d.a.i0.f.i.r.h.a(this.f46460e.f46478e), d.a.i0.f.i.r.h.a(this.f46460e.f46479f)))) {
            d.a.i0.f.i.i.f fVar = this.f46459d;
            if (fVar != null) {
                fVar.a(true, "");
                return;
            }
            return;
        }
        d.a.i0.f.i.i.f fVar2 = this.f46459d;
        if (fVar2 != null) {
            fVar2.onError("3010000");
        }
    }

    public final void D() {
        d.a.i0.f.i.o.e dVar;
        d.a.i0.f.i.q.b.n("loadApi", this.m, this.f46461f);
        String v = d.a.i0.f.i.m.a.b().v();
        c.b bVar = new c.b();
        bVar.m(this.f46458c);
        bVar.j(this.f46457b);
        bVar.o(v);
        bVar.n("game");
        bVar.k("banner");
        bVar.l(this.f46460e.f46476c);
        bVar.i(this.f46460e.f46477d);
        d.a.i0.f.i.o.c h2 = bVar.h();
        if (this.k) {
            dVar = new d.a.i0.f.i.o.f(this.f46456a, h2, 1, z());
        } else {
            dVar = new d.a.i0.f.i.o.d(this.f46456a, h2);
            this.j = dVar.c();
        }
        d.a.i0.f.i.o.a aVar = new d.a.i0.f.i.o.a(this.f46456a, false);
        aVar.k(this);
        aVar.i(dVar, this.f46461f);
    }

    public void E(int i2, int i3, int i4, int i5) {
        this.f46460e = new d.a.i0.f.i.i.c(i2, i3, i4, i5);
        x();
    }

    public void F(Map<String, String> map) {
        this.m = map;
    }

    public void G(JsObject jsObject) {
        d.a.i0.f.i.r.d.c(new e());
    }

    public void H(String str) {
        d.a.i0.f.i.r.d.c(new d(str));
    }

    @Override // d.a.i0.f.i.l.b
    public void a(String str) {
        d.a.i0.f.i.i.f fVar = this.f46459d;
        if (fVar != null) {
            fVar.onError(str);
        }
        String appId = d.a.i0.f.i.m.a.b().getAppId();
        if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
            w();
        }
        d.a.i0.f.i.i.f fVar2 = this.f46459d;
        if (fVar2 != null) {
            fVar2.a(false, "");
        }
    }

    @Override // d.a.i0.f.i.i.d.e
    public void b() {
        d.a.i0.f.i.i.f fVar = this.f46459d;
        if (fVar != null) {
            fVar.onClose();
        }
    }

    @Override // d.a.i0.f.i.l.b
    public void c(AdElementInfo adElementInfo) {
        this.f46462g = adElementInfo;
        C();
    }

    public final void w() {
        d.a.i0.f.i.i.d dVar = new d.a.i0.f.i.i.d(this.f46456a);
        this.f46463h = dVar;
        dVar.e(this.f46460e.f46476c);
        if (this.f46463h.f() == null) {
            return;
        }
        if (this.n.c(this.f46463h.f())) {
            this.n.removeView(this.f46463h.f());
        }
        this.n.d(this.f46463h.f(), new d.a.i0.f.i.i.a(d.a.i0.f.i.r.h.a(this.f46460e.f46474a), d.a.i0.f.i.r.h.a(this.f46460e.f46475b), d.a.i0.f.i.r.h.a(this.f46460e.f46478e), d.a.i0.f.i.r.h.a(this.f46460e.f46479f)));
        this.f46463h.f().postDelayed(new a(), 20000L);
    }

    public final void x() {
        d.a.i0.f.i.i.c cVar = this.f46460e;
        if (cVar == null) {
            return;
        }
        if (d.a.i0.f.i.r.h.a(cVar.f46476c) < 300) {
            this.f46460e.f46476c = d.a.i0.f.i.r.h.p(300.0f);
        }
        int q = d.a.i0.f.i.m.a.b().q();
        int p = d.a.i0.f.i.m.a.b().p();
        if (d.a.i0.f.i.r.h.a(this.f46460e.f46476c) > q) {
            this.f46460e.f46476c = d.a.i0.f.i.r.h.p(q);
        }
        d.a.i0.f.i.i.c cVar2 = this.f46460e;
        cVar2.f46477d = (int) (cVar2.f46476c / d.a.i0.f.i.i.e.f46493a);
        if (cVar2.f46474a < 0) {
            cVar2.f46474a = 0;
        }
        int p2 = d.a.i0.f.i.r.h.p(q);
        d.a.i0.f.i.i.c cVar3 = this.f46460e;
        int i2 = p2 - cVar3.f46476c;
        if (cVar3.f46474a > i2) {
            cVar3.f46474a = i2;
        }
        d.a.i0.f.i.i.c cVar4 = this.f46460e;
        if (cVar4.f46475b < 0) {
            cVar4.f46475b = 0;
        }
        int p3 = d.a.i0.f.i.r.h.p(p);
        d.a.i0.f.i.i.c cVar5 = this.f46460e;
        int i3 = p3 - cVar5.f46477d;
        if (cVar5.f46475b > i3) {
            cVar5.f46475b = i3;
        }
        d.a.i0.f.i.i.c cVar6 = this.f46460e;
        cVar6.f46478e = cVar6.f46476c;
        cVar6.f46479f = cVar6.f46477d;
    }

    public void y() {
        d.a.i0.f.i.r.d.c(new h());
    }

    public final int z() {
        if (this.f46460e == null) {
            return 2;
        }
        int p = d.a.i0.f.i.r.h.p(d.a.i0.f.i.m.a.b().p());
        int i2 = this.f46460e.f46475b;
        int i3 = p / 3;
        if (i2 < i3) {
            return 1;
        }
        return i2 < i3 * 2 ? 4 : 2;
    }
}
