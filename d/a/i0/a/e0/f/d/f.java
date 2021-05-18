package d.a.i0.a.e0.f.d;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.container.NgWebView;
import d.a.i0.a.a1.e;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.k;
import d.a.i0.a.l0.j;
import d.a.i0.a.v2.q0;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f41216f = k.f43025a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f41217g;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.h0.k.f f41218a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f41219b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f41220c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f41221d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f41222e = false;

    /* loaded from: classes2.dex */
    public class a implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.f1.e.b f41223a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.l.a f41224b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.p.e.b f41225c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f41226d;

        public a(d.a.i0.a.f1.e.b bVar, d.a.i0.a.h0.l.a aVar, d.a.i0.a.p.e.b bVar2, e.g gVar) {
            this.f41223a = bVar;
            this.f41224b = aVar;
            this.f41225c = bVar2;
            this.f41226d = gVar;
        }

        @Override // d.a.i0.a.l0.j
        public void a(d.a.i0.a.l0.a aVar) {
            f.this.f41221d = true;
            d.a.i0.a.e0.f.d.d.e().f("loaddebug");
            d.a.i0.a.e0.d.h("LocalDebugger", "prepareDaemon finish.");
            d.a.i0.a.o0.d.b j = f.this.j(this.f41223a);
            f.this.t(j);
            if (f.f41216f) {
                Log.d("LocalDebugger", "debugInitMsg - " + j.g().toString());
            }
            f.this.n(this.f41224b, this.f41225c, this.f41223a, this.f41226d);
            f.this.p(this.f41224b, this.f41225c, this.f41223a, this.f41226d);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.l.a f41228a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.p.e.b f41229b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.f1.e.b f41230c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f41231d;

        public b(d.a.i0.a.h0.l.a aVar, d.a.i0.a.p.e.b bVar, d.a.i0.a.f1.e.b bVar2, e.g gVar) {
            this.f41228a = aVar;
            this.f41229b = bVar;
            this.f41230c = bVar2;
            this.f41231d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (f.f41216f) {
                Log.d("LocalDebugger", "master onReceiveValue: " + str);
            }
            f.this.f41219b = true;
            f.this.u(this.f41228a, this.f41229b, this.f41230c, this.f41231d);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.l.a f41233e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41234f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f41235g;

        public c(f fVar, d.a.i0.a.h0.l.a aVar, String str, ValueCallback valueCallback) {
            this.f41233e = aVar;
            this.f41234f = str;
            this.f41235g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f41233e.g().evaluateJavascript(this.f41234f, this.f41235g);
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
            if (f.f41216f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.p.e.b f41236e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41237f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f41238g;

        public e(f fVar, d.a.i0.a.p.e.b bVar, String str, ValueCallback valueCallback) {
            this.f41236e = bVar;
            this.f41237f = str;
            this.f41238g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((NgWebView) this.f41236e.u()).evaluateJavascript(this.f41237f, this.f41238g);
        }
    }

    /* renamed from: d.a.i0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0588f implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.l.a f41239a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.p.e.b f41240b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.f1.e.b f41241c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f41242d;

        public C0588f(d.a.i0.a.h0.l.a aVar, d.a.i0.a.p.e.b bVar, d.a.i0.a.f1.e.b bVar2, e.g gVar) {
            this.f41239a = aVar;
            this.f41240b = bVar;
            this.f41241c = bVar2;
            this.f41242d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (f.f41216f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
            f.this.f41220c = true;
            f.this.u(this.f41239a, this.f41240b, this.f41241c, this.f41242d);
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.l.a f41244e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.p.e.b f41245f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.f1.e.b f41246g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e.g f41247h;

        public g(f fVar, d.a.i0.a.h0.l.a aVar, d.a.i0.a.p.e.b bVar, d.a.i0.a.f1.e.b bVar2, e.g gVar) {
            this.f41244e = aVar;
            this.f41245f = bVar;
            this.f41246g = bVar2;
            this.f41247h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.c2.f.p0.c.a(this.f41244e, this.f41245f, this.f41246g, this.f41247h);
        }
    }

    public static f k() {
        if (f41217g == null) {
            synchronized (f.class) {
                if (f41217g == null) {
                    f41217g = new f();
                }
            }
        }
        return f41217g;
    }

    public final d.a.i0.a.o0.d.b j(@NonNull d.a.i0.a.f1.e.b<b.a> bVar) {
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
        return new d.a.i0.a.o0.d.b("message", hashMap);
    }

    public d.a.i0.a.l0.a l() {
        d.a.i0.a.h0.k.f fVar = this.f41218a;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    public boolean m() {
        return this.f41222e;
    }

    public final void n(d.a.i0.a.h0.l.a aVar, d.a.i0.a.p.e.b<NgWebView> bVar, d.a.i0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        if (aVar != null && aVar.g() != null) {
            q0.X(new c(this, aVar, d.a.i0.t.d.D(new File(d.a.i0.a.e0.f.d.b.e())), new b(aVar, bVar, bVar2, gVar)));
        } else {
            d.a.i0.a.e0.d.h("LocalDebugger", "loadMasterDebugJs - master or js container is null");
        }
    }

    public void o(d.a.i0.a.p.e.b<NgWebView> bVar, ValueCallback<String> valueCallback) {
        if (bVar != null && bVar.u() != null) {
            String D = d.a.i0.t.d.D(new File(d.a.i0.a.e0.f.d.b.f()));
            if (valueCallback == null) {
                valueCallback = new d(this);
            }
            q0.X(new e(this, bVar, D, valueCallback));
            return;
        }
        d.a.i0.a.e0.d.h("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
    }

    public final void p(d.a.i0.a.h0.l.a aVar, d.a.i0.a.p.e.b<NgWebView> bVar, d.a.i0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        o(bVar, new C0588f(aVar, bVar, bVar2, gVar));
    }

    public void q(d.a.i0.a.h0.l.a aVar, d.a.i0.a.p.e.b<NgWebView> bVar, d.a.i0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        if (d.a.i0.a.h0.u.g.N().g0()) {
            d.a.i0.a.e0.d.h("LocalDebugger", "prepareDaemon start.");
            if (this.f41222e && this.f41221d && this.f41218a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            d.a.i0.a.h0.k.f b2 = d.a.i0.a.h0.u.g.N().X().b();
            this.f41218a = b2;
            b2.c(new a(bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        d.a.i0.a.e0.d.h("LocalDebugger", "releaseLocalDebugger");
        d.a.i0.a.h0.k.f fVar = this.f41218a;
        if (fVar != null) {
            fVar.b();
            this.f41218a = null;
        }
        f41217g = null;
    }

    public void s() {
        d.a.i0.a.e0.d.h("LocalDebugger", "resetMasterAndSlaveStatus");
        this.f41222e = true;
        this.f41219b = false;
        this.f41220c = false;
    }

    public final void t(d.a.i0.a.o0.d.a aVar) {
        d.a.i0.a.h0.k.f fVar = this.f41218a;
        if (fVar != null) {
            d.a.i0.a.o0.a.a(fVar.a(), aVar);
        }
    }

    public final synchronized void u(d.a.i0.a.h0.l.a aVar, d.a.i0.a.p.e.b<NgWebView> bVar, d.a.i0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        if (this.f41219b && this.f41220c) {
            d.a.i0.a.e0.d.h("LocalDebugger", "startFirstPage");
            q0.X(new g(this, aVar, bVar, bVar2, gVar));
        }
    }
}
