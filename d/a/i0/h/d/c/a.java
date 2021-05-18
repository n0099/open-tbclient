package d.a.i0.h.d.c;

import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f47099a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f47100b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f47101c;

    public static a e(d.a.i0.a.y.b.a aVar) {
        if (aVar == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.f47099a = aVar.v("success");
        aVar2.f47100b = aVar.v("fail");
        aVar2.f47101c = aVar.v(XAdRemoteEvent.COMPLETE);
        return aVar2;
    }

    public void a() {
        JsFunction jsFunction = this.f47100b;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f47101c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f47099a);
    }

    public void b(Object obj) {
        JsFunction jsFunction = this.f47100b;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f47101c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f47099a);
    }

    public void c() {
        JsFunction jsFunction = this.f47099a;
        if (jsFunction != null) {
            jsFunction.call();
        }
        JsFunction jsFunction2 = this.f47101c;
        if (jsFunction2 != null) {
            jsFunction2.call();
        }
        f(this.f47100b);
    }

    public void d(Object obj) {
        JsFunction jsFunction = this.f47099a;
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        JsFunction jsFunction2 = this.f47101c;
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        f(this.f47100b);
    }

    public final void f(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
