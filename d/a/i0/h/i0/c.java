package d.a.i0.h.i0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import d.a.i0.a.g1.f;
import d.a.i0.a.k;
import d.a.i0.h.f0.e;
import d.a.i0.h.i0.b;
/* loaded from: classes3.dex */
public class c extends EventTargetImpl {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f47225h = k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.a.l0.c f47226e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.h.d.c.a f47227f;

    /* renamed from: g  reason: collision with root package name */
    public String f47228g;

    /* loaded from: classes3.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.a.i0.h.i0.b.a
        public void a(int i2, long j, long j2) {
            if (c.this.hasEventListener("progressupdate")) {
                d.a.i0.h.i0.d.a aVar = new d.a.i0.h.i0.d.a();
                aVar.progress = i2;
                aVar.totalBytesWritten = j;
                aVar.totalBytesExpectedToWrite = j2;
                JSEvent jSEvent = new JSEvent("progressupdate");
                jSEvent.data = aVar;
                if (c.f47225h) {
                    Log.i("LoadSubpackageTask", "progress :" + i2 + "totalBytesWritten :" + j + "totalBytesExpectedToWrite :" + j2);
                }
                c.this.dispatchEvent(jSEvent);
            }
        }

        @Override // d.a.i0.h.i0.b.a
        public void b(int i2) {
            c.this.E(false);
            e.j(c.this.f47228g, i2, "");
        }

        @Override // d.a.i0.h.i0.b.a
        public void success() {
            c cVar = c.this;
            c.this.E(cVar.F(cVar.f47228g));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47230e;

        public b(boolean z) {
            this.f47230e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f47230e) {
                if (c.this.f47227f != null) {
                    c.this.f47227f.c();
                    if (c.f47225h) {
                        Log.i("LoadSubpackageTask", "success call");
                    }
                }
            } else if (c.this.f47227f != null) {
                c.this.f47227f.a();
                if (c.f47225h) {
                    Log.i("LoadSubpackageTask", "fail call");
                }
            }
        }
    }

    public c(d.a.i0.a.l0.c cVar) {
        super(cVar);
        this.f47226e = cVar;
    }

    public final void E(boolean z) {
        d.a.i0.a.l0.c cVar = this.f47226e;
        if (cVar != null) {
            cVar.runOnJSThread(new b(z));
        }
    }

    public final boolean F(String str) {
        if (this.f47226e == null) {
            return false;
        }
        String str2 = f.V().A() + d.a.i0.h.i0.a.b().c(str, 2);
        String c2 = d.a.i0.h.i0.a.b().c(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(c2)) {
            return false;
        }
        this.f47226e.b0(str2, c2);
        return true;
    }

    public void G(JsObject jsObject) {
        I();
        H(jsObject);
        if (TextUtils.isEmpty(this.f47228g)) {
            if (f47225h) {
                Log.i("LoadSubpackageTask", "params error");
            }
            e.j(this.f47228g, 2111, "");
            return;
        }
        d.a.i0.h.i0.b.a(this.f47228g, new a());
    }

    public final void H(JsObject jsObject) {
        d.a.i0.a.y.b.a G;
        if (jsObject == null || (G = d.a.i0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        this.f47227f = d.a.i0.h.d.c.a.e(G);
        try {
            this.f47228g = G.g("name");
        } catch (JSTypeMismatchException e2) {
            if (f47225h) {
                e2.printStackTrace();
            }
            d.a.i0.h.m0.c.e(this.f47226e, e2);
            I();
        }
    }

    public final void I() {
        this.f47227f = null;
        this.f47228g = null;
    }
}
