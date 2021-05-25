package d.a.l0.h.d.c;

import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f47275a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f47276b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f47277c;

    public static a e(d.a.l0.a.y.b.a aVar) {
        if (aVar == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.f47275a = aVar.v("success");
        aVar2.f47276b = aVar.v("fail");
        aVar2.f47277c = aVar.v(XAdRemoteEvent.COMPLETE);
        return aVar2;
    }

    public void a() {
        JsFunction jsFunction = this.f47276b;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f47277c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f47275a);
    }

    public void b(Object obj) {
        JsFunction jsFunction = this.f47276b;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f47277c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f47275a);
    }

    public void c() {
        JsFunction jsFunction = this.f47275a;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f47277c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f47276b);
    }

    public void d(Object obj) {
        JsFunction jsFunction = this.f47275a;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f47277c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f47276b);
    }

    public final void f(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
