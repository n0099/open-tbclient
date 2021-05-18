package d.a.i0.h.l0;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f47269a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f47270b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f47271c;

    public static b d(d.a.i0.a.y.b.a aVar) {
        if (aVar == null) {
            return null;
        }
        b bVar = new b();
        JsFunction v = aVar.v("onCheckForUpdate");
        bVar.f47269a = v;
        if (v != null) {
            v.setReleaseMode(false);
        }
        JsFunction v2 = aVar.v("onUpdateReady");
        bVar.f47270b = v2;
        if (v2 != null) {
            v2.setReleaseMode(false);
        }
        JsFunction v3 = aVar.v("onUpdateFailed");
        bVar.f47271c = v3;
        if (v3 != null) {
            v3.setReleaseMode(false);
        }
        return bVar;
    }

    public void a(c cVar) {
        JsFunction jsFunction = this.f47269a;
        if (jsFunction != null) {
            jsFunction.call(cVar);
        }
    }

    public void b() {
        JsFunction jsFunction = this.f47271c;
        if (jsFunction != null) {
            jsFunction.call();
        }
    }

    public void c() {
        JsFunction jsFunction = this.f47270b;
        if (jsFunction != null) {
            jsFunction.call();
        }
    }
}
