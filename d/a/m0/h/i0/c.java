package d.a.m0.h.i0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import d.a.m0.a.g1.f;
import d.a.m0.a.k;
import d.a.m0.h.f0.e;
import d.a.m0.h.i0.b;
/* loaded from: classes3.dex */
public class c extends EventTargetImpl {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f51183h = k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.a.l0.c f51184e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.h.d.c.a f51185f;

    /* renamed from: g  reason: collision with root package name */
    public String f51186g;

    /* loaded from: classes3.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.a.m0.h.i0.b.a
        public void a(int i2, long j, long j2) {
            if (c.this.hasEventListener("progressupdate")) {
                d.a.m0.h.i0.d.a aVar = new d.a.m0.h.i0.d.a();
                aVar.progress = i2;
                aVar.totalBytesWritten = j;
                aVar.totalBytesExpectedToWrite = j2;
                JSEvent jSEvent = new JSEvent("progressupdate");
                jSEvent.data = aVar;
                if (c.f51183h) {
                    Log.i("LoadSubpackageTask", "progress :" + i2 + "totalBytesWritten :" + j + "totalBytesExpectedToWrite :" + j2);
                }
                c.this.dispatchEvent(jSEvent);
            }
        }

        @Override // d.a.m0.h.i0.b.a
        public void b(int i2) {
            c.this.E(false);
            e.j(c.this.f51186g, i2, "");
        }

        @Override // d.a.m0.h.i0.b.a
        public void success() {
            c cVar = c.this;
            c.this.E(cVar.F(cVar.f51186g));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f51188e;

        public b(boolean z) {
            this.f51188e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f51188e) {
                if (c.this.f51185f != null) {
                    c.this.f51185f.c();
                    if (c.f51183h) {
                        Log.i("LoadSubpackageTask", "success call");
                    }
                }
            } else if (c.this.f51185f != null) {
                c.this.f51185f.a();
                if (c.f51183h) {
                    Log.i("LoadSubpackageTask", "fail call");
                }
            }
        }
    }

    public c(d.a.m0.a.l0.c cVar) {
        super(cVar);
        this.f51184e = cVar;
    }

    public final void E(boolean z) {
        d.a.m0.a.l0.c cVar = this.f51184e;
        if (cVar != null) {
            cVar.runOnJSThread(new b(z));
        }
    }

    public final boolean F(String str) {
        if (this.f51184e == null) {
            return false;
        }
        String str2 = f.V().A() + d.a.m0.h.i0.a.b().c(str, 2);
        String c2 = d.a.m0.h.i0.a.b().c(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(c2)) {
            return false;
        }
        this.f51184e.b0(str2, c2);
        return true;
    }

    public void G(JsObject jsObject) {
        I();
        H(jsObject);
        if (TextUtils.isEmpty(this.f51186g)) {
            if (f51183h) {
                Log.i("LoadSubpackageTask", "params error");
            }
            e.j(this.f51186g, 2111, "");
            return;
        }
        d.a.m0.h.i0.b.a(this.f51186g, new a());
    }

    public final void H(JsObject jsObject) {
        d.a.m0.a.y.b.a G;
        if (jsObject == null || (G = d.a.m0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        this.f51185f = d.a.m0.h.d.c.a.e(G);
        try {
            this.f51186g = G.g("name");
        } catch (JSTypeMismatchException e2) {
            if (f51183h) {
                e2.printStackTrace();
            }
            d.a.m0.h.m0.c.e(this.f51184e, e2);
            I();
        }
    }

    public final void I() {
        this.f51185f = null;
        this.f51186g = null;
    }
}
