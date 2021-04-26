package d.a.h0.g.e.d;

import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f46288a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f46289b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f46290c;

    public static a e(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.f46288a = cVar.u("success");
        aVar.f46289b = cVar.u("fail");
        aVar.f46290c = cVar.u(XAdRemoteEvent.COMPLETE);
        return aVar;
    }

    public void a() {
        JsFunction jsFunction = this.f46289b;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f46290c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f46288a);
    }

    public void b(Object obj) {
        JsFunction jsFunction = this.f46289b;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f46290c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f46288a);
    }

    public void c() {
        JsFunction jsFunction = this.f46288a;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f46290c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f46289b);
    }

    public void d(Object obj) {
        JsFunction jsFunction = this.f46288a;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f46290c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f46289b);
    }

    public final void f(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
