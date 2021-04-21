package d.b.h0.g.e.d;

import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f48817a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f48818b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f48819c;

    public static a e(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.f48817a = cVar.u("success");
        aVar.f48818b = cVar.u("fail");
        aVar.f48819c = cVar.u(XAdRemoteEvent.COMPLETE);
        return aVar;
    }

    public void a() {
        JsFunction jsFunction = this.f48818b;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f48819c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f48817a);
    }

    public void b(Object obj) {
        JsFunction jsFunction = this.f48818b;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f48819c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f48817a);
    }

    public void c() {
        JsFunction jsFunction = this.f48817a;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f48819c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f48818b);
    }

    public void d(Object obj) {
        JsFunction jsFunction = this.f48817a;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f48819c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f48818b);
    }

    public final void f(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
