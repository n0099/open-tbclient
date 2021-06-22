package d.a.m0.h.d.c;

import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f51057a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f51058b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f51059c;

    public static a e(d.a.m0.a.y.b.a aVar) {
        if (aVar == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.f51057a = aVar.v("success");
        aVar2.f51058b = aVar.v(com.baidu.pass.biometrics.face.liveness.b.a.g0);
        aVar2.f51059c = aVar.v(XAdRemoteEvent.COMPLETE);
        return aVar2;
    }

    public void a() {
        JsFunction jsFunction = this.f51058b;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f51059c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f51057a);
    }

    public void b(Object obj) {
        JsFunction jsFunction = this.f51058b;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f51059c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f51057a);
    }

    public void c() {
        JsFunction jsFunction = this.f51057a;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f51059c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f51058b);
    }

    public void d(Object obj) {
        JsFunction jsFunction = this.f51057a;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f51059c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f51058b);
    }

    public final void f(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
