package d.b.g0.g.e.d;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f48096a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f48097b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f48098c;

    public static a e(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.f48096a = cVar.u("success");
        aVar.f48097b = cVar.u("fail");
        aVar.f48098c = cVar.u("complete");
        return aVar;
    }

    public void a() {
        JsFunction jsFunction = this.f48097b;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f48098c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f48096a);
    }

    public void b(Object obj) {
        JsFunction jsFunction = this.f48097b;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f48098c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f48096a);
    }

    public void c() {
        JsFunction jsFunction = this.f48096a;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f48098c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f48097b);
    }

    public void d(Object obj) {
        JsFunction jsFunction = this.f48096a;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f48098c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f48097b);
    }

    public final void f(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
