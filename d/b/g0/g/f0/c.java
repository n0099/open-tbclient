package d.b.g0.g.f0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import d.b.g0.a.k;
import d.b.g0.a.z0.f;
import d.b.g0.g.f0.b;
/* loaded from: classes3.dex */
public class c extends EventTargetImpl {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f48138h = k.f45050a;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.g.i.b f48139e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.g.e.d.a f48140f;

    /* renamed from: g  reason: collision with root package name */
    public String f48141g;

    /* loaded from: classes3.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.b.g0.g.f0.b.a
        public void a(int i, long j, long j2) {
            if (c.this.hasEventListener("progressupdate")) {
                d.b.g0.g.f0.d.a aVar = new d.b.g0.g.f0.d.a();
                aVar.progress = i;
                aVar.totalBytesWritten = j;
                aVar.totalBytesExpectedToWrite = j2;
                JSEvent jSEvent = new JSEvent("progressupdate");
                jSEvent.data = aVar;
                if (c.f48138h) {
                    Log.i("LoadSubpackageTask", "progress :" + i + "totalBytesWritten :" + j + "totalBytesExpectedToWrite :" + j2);
                }
                c.this.dispatchEvent(jSEvent);
            }
        }

        @Override // d.b.g0.g.f0.b.a
        public void b(int i) {
            c.this.F(false);
            d.b.g0.g.c0.c.j(c.this.f48141g, i, "");
        }

        @Override // d.b.g0.g.f0.b.a
        public void success() {
            c cVar = c.this;
            c.this.F(cVar.G(cVar.f48141g));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48143e;

        public b(boolean z) {
            this.f48143e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f48143e) {
                if (c.this.f48140f != null) {
                    c.this.f48140f.c();
                    if (c.f48138h) {
                        Log.i("LoadSubpackageTask", "success call");
                    }
                }
            } else if (c.this.f48140f != null) {
                c.this.f48140f.a();
                if (c.f48138h) {
                    Log.i("LoadSubpackageTask", "fail call");
                }
            }
        }
    }

    public c(d.b.g0.g.i.b bVar) {
        super(bVar);
        this.f48139e = bVar;
    }

    public final void F(boolean z) {
        d.b.g0.g.i.b bVar = this.f48139e;
        if (bVar != null) {
            bVar.runOnJSThread(new b(z));
        }
    }

    public final boolean G(String str) {
        if (this.f48139e == null) {
            return false;
        }
        String str2 = f.V().h() + d.b.g0.g.f0.a.b().c(str, 2);
        String c2 = d.b.g0.g.f0.a.b().c(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(c2)) {
            return false;
        }
        this.f48139e.N(str2, c2);
        return true;
    }

    public void H(JsObject jsObject) {
        J();
        I(jsObject);
        if (TextUtils.isEmpty(this.f48141g)) {
            if (f48138h) {
                Log.i("LoadSubpackageTask", "params error");
            }
            d.b.g0.g.c0.c.j(this.f48141g, 2111, "");
            return;
        }
        d.b.g0.g.f0.b.a(this.f48141g, new a());
    }

    public final void I(JsObject jsObject) {
        d.b.g0.g.e.d.c F;
        if (jsObject == null || (F = d.b.g0.g.e.d.c.F(jsObject)) == null) {
            return;
        }
        this.f48140f = d.b.g0.g.e.d.a.e(F);
        try {
            this.f48141g = F.g("name");
        } catch (JSTypeMismatchException e2) {
            if (f48138h) {
                e2.printStackTrace();
            }
            d.b.g0.g.i0.b.e(this.f48139e, e2);
            J();
        }
    }

    public final void J() {
        this.f48140f = null;
        this.f48141g = null;
    }
}
