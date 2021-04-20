package d.b.g0.g.e.d;

import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f48488a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f48489b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f48490c;

    public static a e(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.f48488a = cVar.u("success");
        aVar.f48489b = cVar.u("fail");
        aVar.f48490c = cVar.u(XAdRemoteEvent.COMPLETE);
        return aVar;
    }

    public void a() {
        JsFunction jsFunction = this.f48489b;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f48490c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f48488a);
    }

    public void b(Object obj) {
        JsFunction jsFunction = this.f48489b;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f48490c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f48488a);
    }

    public void c() {
        JsFunction jsFunction = this.f48488a;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f48490c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f48489b);
    }

    public void d(Object obj) {
        JsFunction jsFunction = this.f48488a;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f48490c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f48489b);
    }

    public final void f(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
