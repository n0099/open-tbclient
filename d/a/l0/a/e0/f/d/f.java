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
    public static final boolean f41390f = k.f43199a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f41391g;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.h0.k.f f41392a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f41393b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f41394c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f41395d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f41396e = false;

    /* loaded from: classes2.dex */
    public class a implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f41397a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.l.a f41398b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.p.e.b f41399c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f41400d;

        public a(d.a.l0.a.f1.e.b bVar, d.a.l0.a.h0.l.a aVar, d.a.l0.a.p.e.b bVar2, e.g gVar) {
            this.f41397a = bVar;
            this.f41398b = aVar;
            this.f41399c = bVar2;
            this.f41400d = gVar;
        }

        @Override // d.a.l0.a.l0.j
        public void a(d.a.l0.a.l0.a aVar) {
            f.this.f41395d = true;
            d.a.l0.a.e0.f.d.d.e().f("loaddebug");
            d.a.l0.a.e0.d.h("LocalDebugger", "prepareDaemon finish.");
            d.a.l0.a.o0.d.b j = f.this.j(this.f41397a);
            f.this.t(j);
            if (f.f41390f) {
                Log.d("LocalDebugger", "debugInitMsg - " + j.g().toString());
            }
            f.this.n(this.f41398b, this.f41399c, this.f41397a, this.f41400d);
            f.this.p(this.f41398b, this.f41399c, this.f41397a, this.f41400d);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.l.a f41402a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.p.e.b f41403b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f41404c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f41405d;

        public b(d.a.l0.a.h0.l.a aVar, d.a.l0.a.p.e.b bVar, d.a.l0.a.f1.e.b bVar2, e.g gVar) {
            this.f41402a = aVar;
            this.f41403b = bVar;
            this.f41404c = bVar2;
            this.f41405d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (f.f41390f) {
                Log.d("LocalDebugger", "master onReceiveValue: " + str);
            }
            f.this.f41393b = true;
            f.this.u(this.f41402a, this.f41403b, this.f41404c, this.f41405d);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.l.a f41407e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41408f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f41409g;

        public c(f fVar, d.a.l0.a.h0.l.a aVar, String str, ValueCallback valueCallback) {
            this.f41407e = aVar;
            this.f41408f = str;
            this.f41409g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f41407e.g().evaluateJavascript(this.f41408f, this.f41409g);
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
            if (f.f41390f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.p.e.b f41410e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41411f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f41412g;

        public e(f fVar, d.a.l0.a.p.e.b bVar, String str, ValueCallback valueCallback) {
            this.f41410e = bVar;
            this.f41411f = str;
            this.f41412g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((NgWebView) this.f41410e.u()).evaluateJavascript(this.f41411f, this.f41412g);
        }
    }

    /* renamed from: d.a.l0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0599f implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.l.a f41413a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.p.e.b f41414b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f41415c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f41416d;

        public C0599f(d.a.l0.a.h0.l.a aVar, d.a.l0.a.p.e.b bVar, d.a.l0.a.f1.e.b bVar2, e.g gVar) {
            this.f41413a = aVar;
            this.f41414b = bVar;
            this.f41415c = bVar2;
            this.f41416d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (f.f41390f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
            f.this.f41394c = true;
            f.this.u(this.f41413a, this.f41414b, this.f41415c, this.f41416d);
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.l.a f41418e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.p.e.b f41419f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f41420g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e.g f41421h;

        public g(f fVar, d.a.l0.a.h0.l.a aVar, d.a.l0.a.p.e.b bVar, d.a.l0.a.f1.e.b bVar2, e.g gVar) {
            this.f41418e = aVar;
            this.f41419f = bVar;
            this.f41420g = bVar2;
            this.f41421h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.c2.f.p0.c.a(this.f41418e, this.f41419f, this.f41420g, this.f41421h);
        }
    }

    public static f k() {
        if (f41391g == null) {
            synchronized (f.class) {
                if (f41391g == null) {
                    f41391g = new f();
                }
            }
        }
        return f41391g;
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
        d.a.l0.a.h0.k.f fVar = this.f41392a;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    public boolean m() {
        return this.f41396e;
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
        o(bVar, new C0599f(aVar, bVar, bVar2, gVar));
    }

    public void q(d.a.l0.a.h0.l.a aVar, d.a.l0.a.p.e.b<NgWebView> bVar, d.a.l0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        if (d.a.l0.a.h0.u.g.N().g0()) {
            d.a.l0.a.e0.d.h("LocalDebugger", "prepareDaemon start.");
            if (this.f41396e && this.f41395d && this.f41392a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            d.a.l0.a.h0.k.f b2 = d.a.l0.a.h0.u.g.N().X().b();
            this.f41392a = b2;
            b2.c(new a(bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        d.a.l0.a.e0.d.h("LocalDebugger", "releaseLocalDebugger");
        d.a.l0.a.h0.k.f fVar = this.f41392a;
        if (fVar != null) {
            fVar.b();
            this.f41392a = null;
        }
        f41391g = null;
    }

    public void s() {
        d.a.l0.a.e0.d.h("LocalDebugger", "resetMasterAndSlaveStatus");
        this.f41396e = true;
        this.f41393b = false;
        this.f41394c = false;
    }

    public final void t(d.a.l0.a.o0.d.a aVar) {
        d.a.l0.a.h0.k.f fVar = this.f41392a;
        if (fVar != null) {
            d.a.l0.a.o0.a.a(fVar.a(), aVar);
        }
    }

    public final synchronized void u(d.a.l0.a.h0.l.a aVar, d.a.l0.a.p.e.b<NgWebView> bVar, d.a.l0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        if (this.f41393b && this.f41394c) {
            d.a.l0.a.e0.d.h("LocalDebugger", "startFirstPage");
            q0.X(new g(this, aVar, bVar, bVar2, gVar));
        }
    }
}
