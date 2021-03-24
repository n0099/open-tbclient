package d.b.g0.g.h0;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f48154a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f48155b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f48156c;

    public static b d(d.b.g0.g.e.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        JsFunction u = cVar.u("onCheckForUpdate");
        bVar.f48154a = u;
        if (u != null) {
            u.setReleaseMode(false);
        }
        JsFunction u2 = cVar.u("onUpdateReady");
        bVar.f48155b = u2;
        if (u2 != null) {
            u2.setReleaseMode(false);
        }
        JsFunction u3 = cVar.u("onUpdateFailed");
        bVar.f48156c = u3;
        if (u3 != null) {
            u3.setReleaseMode(false);
        }
        return bVar;
    }

    public void a(c cVar) {
        JsFunction jsFunction = this.f48154a;
        if (jsFunction != null) {
            jsFunction.call(cVar);
        }
    }

    public void b() {
        JsFunction jsFunction = this.f48156c;
        if (jsFunction != null) {
            jsFunction.call();
        }
    }

    public void c() {
        JsFunction jsFunction = this.f48155b;
        if (jsFunction != null) {
            jsFunction.call();
        }
    }
}
