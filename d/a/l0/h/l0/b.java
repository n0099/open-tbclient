package d.a.l0.h.l0;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f51119a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f51120b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f51121c;

    public static b d(d.a.l0.a.y.b.a aVar) {
        if (aVar == null) {
            return null;
        }
        b bVar = new b();
        JsFunction v = aVar.v("onCheckForUpdate");
        bVar.f51119a = v;
        if (v != null) {
            v.setReleaseMode(false);
        }
        JsFunction v2 = aVar.v("onUpdateReady");
        bVar.f51120b = v2;
        if (v2 != null) {
            v2.setReleaseMode(false);
        }
        JsFunction v3 = aVar.v("onUpdateFailed");
        bVar.f51121c = v3;
        if (v3 != null) {
            v3.setReleaseMode(false);
        }
        return bVar;
    }

    public void a(c cVar) {
        JsFunction jsFunction = this.f51119a;
        if (jsFunction != null) {
            jsFunction.call(cVar);
        }
    }

    public void b() {
        JsFunction jsFunction = this.f51121c;
        if (jsFunction != null) {
            jsFunction.call();
        }
    }

    public void c() {
        JsFunction jsFunction = this.f51120b;
        if (jsFunction != null) {
            jsFunction.call();
        }
    }
}
