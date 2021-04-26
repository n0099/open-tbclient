package d.a.h0.g.f0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import d.a.h0.a.k;
import d.a.h0.a.z0.f;
import d.a.h0.g.f0.b;
/* loaded from: classes3.dex */
public class c extends EventTargetImpl {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f46332h = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.g.i.b f46333e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.g.e.d.a f46334f;

    /* renamed from: g  reason: collision with root package name */
    public String f46335g;

    /* loaded from: classes3.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.a.h0.g.f0.b.a
        public void a(int i2, long j, long j2) {
            if (c.this.hasEventListener("progressupdate")) {
                d.a.h0.g.f0.d.a aVar = new d.a.h0.g.f0.d.a();
                aVar.progress = i2;
                aVar.totalBytesWritten = j;
                aVar.totalBytesExpectedToWrite = j2;
                JSEvent jSEvent = new JSEvent("progressupdate");
                jSEvent.data = aVar;
                if (c.f46332h) {
                    Log.i("LoadSubpackageTask", "progress :" + i2 + "totalBytesWritten :" + j + "totalBytesExpectedToWrite :" + j2);
                }
                c.this.dispatchEvent(jSEvent);
            }
        }

        @Override // d.a.h0.g.f0.b.a
        public void b(int i2) {
            c.this.F(false);
            d.a.h0.g.c0.c.j(c.this.f46335g, i2, "");
        }

        @Override // d.a.h0.g.f0.b.a
        public void success() {
            c cVar = c.this;
            c.this.F(cVar.G(cVar.f46335g));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46337e;

        public b(boolean z) {
            this.f46337e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f46337e) {
                if (c.this.f46334f != null) {
                    c.this.f46334f.c();
                    if (c.f46332h) {
                        Log.i("LoadSubpackageTask", "success call");
                    }
                }
            } else if (c.this.f46334f != null) {
                c.this.f46334f.a();
                if (c.f46332h) {
                    Log.i("LoadSubpackageTask", "fail call");
                }
            }
        }
    }

    public c(d.a.h0.g.i.b bVar) {
        super(bVar);
        this.f46333e = bVar;
    }

    public final void F(boolean z) {
        d.a.h0.g.i.b bVar = this.f46333e;
        if (bVar != null) {
            bVar.runOnJSThread(new b(z));
        }
    }

    public final boolean G(String str) {
        if (this.f46333e == null) {
            return false;
        }
        String str2 = f.V().A() + d.a.h0.g.f0.a.b().c(str, 2);
        String c2 = d.a.h0.g.f0.a.b().c(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(c2)) {
            return false;
        }
        this.f46333e.U(str2, c2);
        return true;
    }

    public void H(JsObject jsObject) {
        J();
        I(jsObject);
        if (TextUtils.isEmpty(this.f46335g)) {
            if (f46332h) {
                Log.i("LoadSubpackageTask", "params error");
            }
            d.a.h0.g.c0.c.j(this.f46335g, 2111, "");
            return;
        }
        d.a.h0.g.f0.b.a(this.f46335g, new a());
    }

    public final void I(JsObject jsObject) {
        d.a.h0.g.e.d.c F;
        if (jsObject == null || (F = d.a.h0.g.e.d.c.F(jsObject)) == null) {
            return;
        }
        this.f46334f = d.a.h0.g.e.d.a.e(F);
        try {
            this.f46335g = F.g("name");
        } catch (JSTypeMismatchException e2) {
            if (f46332h) {
                e2.printStackTrace();
            }
            d.a.h0.g.i0.b.e(this.f46333e, e2);
            J();
        }
    }

    public final void J() {
        this.f46334f = null;
        this.f46335g = null;
    }
}
