package d.a.l0.h.l0;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f47445a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f47446b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f47447c;

    public static b d(d.a.l0.a.y.b.a aVar) {
        if (aVar == null) {
            return null;
        }
        b bVar = new b();
        JsFunction v = aVar.v("onCheckForUpdate");
        bVar.f47445a = v;
        if (v != null) {
            v.setReleaseMode(false);
        }
        JsFunction v2 = aVar.v("onUpdateReady");
        bVar.f47446b = v2;
        if (v2 != null) {
            v2.setReleaseMode(false);
        }
        JsFunction v3 = aVar.v("onUpdateFailed");
        bVar.f47447c = v3;
        if (v3 != null) {
            v3.setReleaseMode(false);
        }
        return bVar;
    }

    public void a(c cVar) {
        JsFunction jsFunction = this.f47445a;
        if (jsFunction != null) {
            jsFunction.call(cVar);
        }
    }

    public void b() {
        JsFunction jsFunction = this.f47447c;
        if (jsFunction != null) {
            jsFunction.call();
        }
    }

    public void c() {
        JsFunction jsFunction = this.f47446b;
        if (jsFunction != null) {
            jsFunction.call();
        }
    }
}
