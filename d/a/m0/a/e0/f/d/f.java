package d.a.m0.a.e0.f.d;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.container.NgWebView;
import d.a.m0.a.a1.e;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.k;
import d.a.m0.a.l0.j;
import d.a.m0.a.v2.q0;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45174f = k.f46983a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f45175g;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.h0.k.f f45176a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f45177b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f45178c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f45179d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f45180e = false;

    /* loaded from: classes3.dex */
    public class a implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.f1.e.b f45181a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.l.a f45182b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.p.e.b f45183c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f45184d;

        public a(d.a.m0.a.f1.e.b bVar, d.a.m0.a.h0.l.a aVar, d.a.m0.a.p.e.b bVar2, e.g gVar) {
            this.f45181a = bVar;
            this.f45182b = aVar;
            this.f45183c = bVar2;
            this.f45184d = gVar;
        }

        @Override // d.a.m0.a.l0.j
        public void a(d.a.m0.a.l0.a aVar) {
            f.this.f45179d = true;
            d.a.m0.a.e0.f.d.d.e().f("loaddebug");
            d.a.m0.a.e0.d.h("LocalDebugger", "prepareDaemon finish.");
            d.a.m0.a.o0.d.b j = f.this.j(this.f45181a);
            f.this.t(j);
            if (f.f45174f) {
                Log.d("LocalDebugger", "debugInitMsg - " + j.g().toString());
            }
            f.this.n(this.f45182b, this.f45183c, this.f45181a, this.f45184d);
            f.this.p(this.f45182b, this.f45183c, this.f45181a, this.f45184d);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.l.a f45186a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.p.e.b f45187b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.f1.e.b f45188c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f45189d;

        public b(d.a.m0.a.h0.l.a aVar, d.a.m0.a.p.e.b bVar, d.a.m0.a.f1.e.b bVar2, e.g gVar) {
            this.f45186a = aVar;
            this.f45187b = bVar;
            this.f45188c = bVar2;
            this.f45189d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (f.f45174f) {
                Log.d("LocalDebugger", "master onReceiveValue: " + str);
            }
            f.this.f45177b = true;
            f.this.u(this.f45186a, this.f45187b, this.f45188c, this.f45189d);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.l.a f45191e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45192f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f45193g;

        public c(f fVar, d.a.m0.a.h0.l.a aVar, String str, ValueCallback valueCallback) {
            this.f45191e = aVar;
            this.f45192f = str;
            this.f45193g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45191e.g().evaluateJavascript(this.f45192f, this.f45193g);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ValueCallback<String> {
        public d(f fVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (f.f45174f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.p.e.b f45194e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45195f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f45196g;

        public e(f fVar, d.a.m0.a.p.e.b bVar, String str, ValueCallback valueCallback) {
            this.f45194e = bVar;
            this.f45195f = str;
            this.f45196g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((NgWebView) this.f45194e.u()).evaluateJavascript(this.f45195f, this.f45196g);
        }
    }

    /* renamed from: d.a.m0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0658f implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.l.a f45197a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.p.e.b f45198b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.f1.e.b f45199c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f45200d;

        public C0658f(d.a.m0.a.h0.l.a aVar, d.a.m0.a.p.e.b bVar, d.a.m0.a.f1.e.b bVar2, e.g gVar) {
            this.f45197a = aVar;
            this.f45198b = bVar;
            this.f45199c = bVar2;
            this.f45200d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (f.f45174f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
            f.this.f45178c = true;
            f.this.u(this.f45197a, this.f45198b, this.f45199c, this.f45200d);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.l.a f45202e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.p.e.b f45203f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.f1.e.b f45204g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e.g f45205h;

        public g(f fVar, d.a.m0.a.h0.l.a aVar, d.a.m0.a.p.e.b bVar, d.a.m0.a.f1.e.b bVar2, e.g gVar) {
            this.f45202e = aVar;
            this.f45203f = bVar;
            this.f45204g = bVar2;
            this.f45205h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.c2.f.p0.c.a(this.f45202e, this.f45203f, this.f45204g, this.f45205h);
        }
    }

    public static f k() {
        if (f45175g == null) {
            synchronized (f.class) {
                if (f45175g == null) {
                    f45175g = new f();
                }
            }
        }
        return f45175g;
    }

    public final d.a.m0.a.o0.d.b j(@NonNull d.a.m0.a.f1.e.b<b.a> bVar) {
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
        return new d.a.m0.a.o0.d.b("message", hashMap);
    }

    public d.a.m0.a.l0.a l() {
        d.a.m0.a.h0.k.f fVar = this.f45176a;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    public boolean m() {
        return this.f45180e;
    }

    public final void n(d.a.m0.a.h0.l.a aVar, d.a.m0.a.p.e.b<NgWebView> bVar, d.a.m0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        if (aVar != null && aVar.g() != null) {
            q0.X(new c(this, aVar, d.a.m0.t.d.D(new File(d.a.m0.a.e0.f.d.b.e())), new b(aVar, bVar, bVar2, gVar)));
        } else {
            d.a.m0.a.e0.d.h("LocalDebugger", "loadMasterDebugJs - master or js container is null");
        }
    }

    public void o(d.a.m0.a.p.e.b<NgWebView> bVar, ValueCallback<String> valueCallback) {
        if (bVar != null && bVar.u() != null) {
            String D = d.a.m0.t.d.D(new File(d.a.m0.a.e0.f.d.b.f()));
            if (valueCallback == null) {
                valueCallback = new d(this);
            }
            q0.X(new e(this, bVar, D, valueCallback));
            return;
        }
        d.a.m0.a.e0.d.h("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
    }

    public final void p(d.a.m0.a.h0.l.a aVar, d.a.m0.a.p.e.b<NgWebView> bVar, d.a.m0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        o(bVar, new C0658f(aVar, bVar, bVar2, gVar));
    }

    public void q(d.a.m0.a.h0.l.a aVar, d.a.m0.a.p.e.b<NgWebView> bVar, d.a.m0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        if (d.a.m0.a.h0.u.g.N().g0()) {
            d.a.m0.a.e0.d.h("LocalDebugger", "prepareDaemon start.");
            if (this.f45180e && this.f45179d && this.f45176a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            d.a.m0.a.h0.k.f b2 = d.a.m0.a.h0.u.g.N().X().b();
            this.f45176a = b2;
            b2.c(new a(bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        d.a.m0.a.e0.d.h("LocalDebugger", "releaseLocalDebugger");
        d.a.m0.a.h0.k.f fVar = this.f45176a;
        if (fVar != null) {
            fVar.b();
            this.f45176a = null;
        }
        f45175g = null;
    }

    public void s() {
        d.a.m0.a.e0.d.h("LocalDebugger", "resetMasterAndSlaveStatus");
        this.f45180e = true;
        this.f45177b = false;
        this.f45178c = false;
    }

    public final void t(d.a.m0.a.o0.d.a aVar) {
        d.a.m0.a.h0.k.f fVar = this.f45176a;
        if (fVar != null) {
            d.a.m0.a.o0.a.a(fVar.a(), aVar);
        }
    }

    public final synchronized void u(d.a.m0.a.h0.l.a aVar, d.a.m0.a.p.e.b<NgWebView> bVar, d.a.m0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        if (this.f45177b && this.f45178c) {
            d.a.m0.a.e0.d.h("LocalDebugger", "startFirstPage");
            q0.X(new g(this, aVar, bVar, bVar2, gVar));
        }
    }
}
