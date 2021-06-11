package d.a.l0.a.e0.f.d;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.container.NgWebView;
import d.a.l0.a.a1.e;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.k;
import d.a.l0.a.l0.j;
import d.a.l0.a.v2.q0;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45066f = k.f46875a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f45067g;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.h0.k.f f45068a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f45069b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f45070c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f45071d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f45072e = false;

    /* loaded from: classes2.dex */
    public class a implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f45073a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.l.a f45074b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.p.e.b f45075c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f45076d;

        public a(d.a.l0.a.f1.e.b bVar, d.a.l0.a.h0.l.a aVar, d.a.l0.a.p.e.b bVar2, e.g gVar) {
            this.f45073a = bVar;
            this.f45074b = aVar;
            this.f45075c = bVar2;
            this.f45076d = gVar;
        }

        @Override // d.a.l0.a.l0.j
        public void a(d.a.l0.a.l0.a aVar) {
            f.this.f45071d = true;
            d.a.l0.a.e0.f.d.d.e().f("loaddebug");
            d.a.l0.a.e0.d.h("LocalDebugger", "prepareDaemon finish.");
            d.a.l0.a.o0.d.b j = f.this.j(this.f45073a);
            f.this.t(j);
            if (f.f45066f) {
                Log.d("LocalDebugger", "debugInitMsg - " + j.g().toString());
            }
            f.this.n(this.f45074b, this.f45075c, this.f45073a, this.f45076d);
            f.this.p(this.f45074b, this.f45075c, this.f45073a, this.f45076d);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.l.a f45078a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.p.e.b f45079b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f45080c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f45081d;

        public b(d.a.l0.a.h0.l.a aVar, d.a.l0.a.p.e.b bVar, d.a.l0.a.f1.e.b bVar2, e.g gVar) {
            this.f45078a = aVar;
            this.f45079b = bVar;
            this.f45080c = bVar2;
            this.f45081d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (f.f45066f) {
                Log.d("LocalDebugger", "master onReceiveValue: " + str);
            }
            f.this.f45069b = true;
            f.this.u(this.f45078a, this.f45079b, this.f45080c, this.f45081d);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.l.a f45083e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45084f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f45085g;

        public c(f fVar, d.a.l0.a.h0.l.a aVar, String str, ValueCallback valueCallback) {
            this.f45083e = aVar;
            this.f45084f = str;
            this.f45085g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45083e.g().evaluateJavascript(this.f45084f, this.f45085g);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ValueCallback<String> {
        public d(f fVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (f.f45066f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.p.e.b f45086e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45087f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f45088g;

        public e(f fVar, d.a.l0.a.p.e.b bVar, String str, ValueCallback valueCallback) {
            this.f45086e = bVar;
            this.f45087f = str;
            this.f45088g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((NgWebView) this.f45086e.u()).evaluateJavascript(this.f45087f, this.f45088g);
        }
    }

    /* renamed from: d.a.l0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0655f implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.l.a f45089a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.p.e.b f45090b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f45091c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f45092d;

        public C0655f(d.a.l0.a.h0.l.a aVar, d.a.l0.a.p.e.b bVar, d.a.l0.a.f1.e.b bVar2, e.g gVar) {
            this.f45089a = aVar;
            this.f45090b = bVar;
            this.f45091c = bVar2;
            this.f45092d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (f.f45066f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
            f.this.f45070c = true;
            f.this.u(this.f45089a, this.f45090b, this.f45091c, this.f45092d);
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.l.a f45094e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.p.e.b f45095f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f45096g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e.g f45097h;

        public g(f fVar, d.a.l0.a.h0.l.a aVar, d.a.l0.a.p.e.b bVar, d.a.l0.a.f1.e.b bVar2, e.g gVar) {
            this.f45094e = aVar;
            this.f45095f = bVar;
            this.f45096g = bVar2;
            this.f45097h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.c2.f.p0.c.a(this.f45094e, this.f45095f, this.f45096g, this.f45097h);
        }
    }

    public static f k() {
        if (f45067g == null) {
            synchronized (f.class) {
                if (f45067g == null) {
                    f45067g = new f();
                }
            }
        }
        return f45067g;
    }

    public final d.a.l0.a.o0.d.b j(@NonNull d.a.l0.a.f1.e.b<b.a> bVar) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "debugInit");
            jSONObject.put("host", bVar.X());
            jSONObject.put("wsServerPort", bVar.Y());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        hashMap.put("message", jSONObject.toString());
        return new d.a.l0.a.o0.d.b("message", hashMap);
    }

    public d.a.l0.a.l0.a l() {
        d.a.l0.a.h0.k.f fVar = this.f45068a;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    public boolean m() {
        return this.f45072e;
    }

    public final void n(d.a.l0.a.h0.l.a aVar, d.a.l0.a.p.e.b<NgWebView> bVar, d.a.l0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        if (aVar != null && aVar.g() != null) {
            q0.X(new c(this, aVar, d.a.l0.t.d.D(new File(d.a.l0.a.e0.f.d.b.e())), new b(aVar, bVar, bVar2, gVar)));
        } else {
            d.a.l0.a.e0.d.h("LocalDebugger", "loadMasterDebugJs - master or js container is null");
        }
    }

    public void o(d.a.l0.a.p.e.b<NgWebView> bVar, ValueCallback<String> valueCallback) {
        if (bVar != null && bVar.u() != null) {
            String D = d.a.l0.t.d.D(new File(d.a.l0.a.e0.f.d.b.f()));
            if (valueCallback == null) {
                valueCallback = new d(this);
            }
            q0.X(new e(this, bVar, D, valueCallback));
            return;
        }
        d.a.l0.a.e0.d.h("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
    }

    public final void p(d.a.l0.a.h0.l.a aVar, d.a.l0.a.p.e.b<NgWebView> bVar, d.a.l0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        o(bVar, new C0655f(aVar, bVar, bVar2, gVar));
    }

    public void q(d.a.l0.a.h0.l.a aVar, d.a.l0.a.p.e.b<NgWebView> bVar, d.a.l0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        if (d.a.l0.a.h0.u.g.N().g0()) {
            d.a.l0.a.e0.d.h("LocalDebugger", "prepareDaemon start.");
            if (this.f45072e && this.f45071d && this.f45068a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            d.a.l0.a.h0.k.f b2 = d.a.l0.a.h0.u.g.N().X().b();
            this.f45068a = b2;
            b2.c(new a(bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        d.a.l0.a.e0.d.h("LocalDebugger", "releaseLocalDebugger");
        d.a.l0.a.h0.k.f fVar = this.f45068a;
        if (fVar != null) {
            fVar.b();
            this.f45068a = null;
        }
        f45067g = null;
    }

    public void s() {
        d.a.l0.a.e0.d.h("LocalDebugger", "resetMasterAndSlaveStatus");
        this.f45072e = true;
        this.f45069b = false;
        this.f45070c = false;
    }

    public final void t(d.a.l0.a.o0.d.a aVar) {
        d.a.l0.a.h0.k.f fVar = this.f45068a;
        if (fVar != null) {
            d.a.l0.a.o0.a.a(fVar.a(), aVar);
        }
    }

    public final synchronized void u(d.a.l0.a.h0.l.a aVar, d.a.l0.a.p.e.b<NgWebView> bVar, d.a.l0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        if (this.f45069b && this.f45070c) {
            d.a.l0.a.e0.d.h("LocalDebugger", "startFirstPage");
            q0.X(new g(this, aVar, bVar, bVar2, gVar));
        }
    }
}
