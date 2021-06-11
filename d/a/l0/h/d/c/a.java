package d.a.l0.h.d.c;

import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f50949a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f50950b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f50951c;

    public static a e(d.a.l0.a.y.b.a aVar) {
        if (aVar == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.f50949a = aVar.v("success");
        aVar2.f50950b = aVar.v(com.baidu.pass.biometrics.face.liveness.b.b.g0);
        aVar2.f50951c = aVar.v(XAdRemoteEvent.COMPLETE);
        return aVar2;
    }

    public void a() {
        JsFunction jsFunction = this.f50950b;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f50951c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f50949a);
    }

    public void b(Object obj) {
        JsFunction jsFunction = this.f50950b;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f50951c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f50949a);
    }

    public void c() {
        JsFunction jsFunction = this.f50949a;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f50951c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f50950b);
    }

    public void d(Object obj) {
        JsFunction jsFunction = this.f50949a;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f50951c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f50950b);
    }

    public final void f(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
