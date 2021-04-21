package d.b.h0.g.h0;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f48876a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f48877b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f48878c;

    public static b d(d.b.h0.g.e.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        JsFunction u = cVar.u("onCheckForUpdate");
        bVar.f48876a = u;
        if (u != null) {
            u.setReleaseMode(false);
        }
        JsFunction u2 = cVar.u("onUpdateReady");
        bVar.f48877b = u2;
        if (u2 != null) {
            u2.setReleaseMode(false);
        }
        JsFunction u3 = cVar.u("onUpdateFailed");
        bVar.f48878c = u3;
        if (u3 != null) {
            u3.setReleaseMode(false);
        }
        return bVar;
    }

    public void a(c cVar) {
        JsFunction jsFunction = this.f48876a;
        if (jsFunction != null) {
            jsFunction.call(cVar);
        }
    }

    public void b() {
        JsFunction jsFunction = this.f48878c;
        if (jsFunction != null) {
            jsFunction.call();
        }
    }

    public void c() {
        JsFunction jsFunction = this.f48877b;
        if (jsFunction != null) {
            jsFunction.call();
        }
    }
}
