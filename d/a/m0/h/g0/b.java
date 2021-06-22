package d.a.m0.h.g0;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
/* loaded from: classes3.dex */
public class b extends e {
    public b(d.a.m0.a.l0.c cVar) {
        super(cVar);
    }

    public final void g(JsObject jsObject, String str, String str2, d.a.m0.h.g0.f.d dVar) {
        d.a.m0.a.y.b.a n = n(jsObject);
        d.a.m0.h.d.c.b bVar = new d.a.m0.h.d.c.b();
        boolean g2 = dVar.g();
        bVar.errMsg = dVar.c(str, str2);
        d.a.m0.h.m0.c.a(n, g2, bVar);
        if (g2) {
            return;
        }
        d.a.m0.h.f0.e.i(str2, bVar.errMsg);
    }

    public void h(JsObject jsObject) {
        g(jsObject, "clearStorage", "", a());
    }

    public final JsSerializeValue i(JsObject jsObject) {
        for (int i2 = 0; i2 < jsObject.length(); i2++) {
            if ("data".equals(jsObject.getPropertyName(i2))) {
                return jsObject.toSerializeValue(i2);
            }
        }
        return null;
    }

    public final d.a.m0.h.g0.f.d j(JsObject jsObject) {
        for (int i2 = 0; i2 < jsObject.length(); i2++) {
            if ("key".equals(jsObject.getPropertyName(i2))) {
                int propertyType = jsObject.getPropertyType(i2);
                return propertyType == 7 ? d.a.m0.h.g0.f.d.i(jsObject.toString(i2)) : d.a.m0.h.g0.f.d.b(String.format("parameter error: the key must be string instead of %s.", d.a.m0.h.g0.f.d.f(propertyType)));
            }
        }
        return d.a.m0.h.g0.f.d.b("parameter error: the parameter key is necessary.");
    }

    public void k(JsObject jsObject) {
        String m = m(jsObject, "getStorage");
        if (m == null) {
            return;
        }
        d.a.m0.h.g0.f.d c2 = c(m);
        if (c2.g()) {
            d.a.m0.h.g0.f.b bVar = new d.a.m0.h.g0.f.b();
            bVar.errMsg = d.a.m0.h.g0.f.a.b("getStorage");
            Object d2 = c2.d();
            bVar.data = d2;
            if (d2 instanceof JsSerializeValue) {
                ((JsSerializeValue) d2).setAutoRelease(false);
            }
            d.a.m0.h.m0.c.a(n(jsObject), true, bVar);
            return;
        }
        g(jsObject, "getStorage", m, c2);
    }

    public void l(JsObject jsObject) {
        d.a.m0.a.y.b.a n = n(jsObject);
        d.a.m0.h.g0.f.c b2 = b();
        b2.errMsg = d.a.m0.h.g0.f.a.b("getStorageInfo");
        d.a.m0.h.m0.c.a(n, true, b2);
    }

    public final String m(JsObject jsObject, String str) {
        d.a.m0.h.g0.f.d j = j(jsObject);
        if (!j.g()) {
            g(jsObject, str, "", j);
            return null;
        }
        return (String) j.d();
    }

    @NonNull
    public final d.a.m0.a.y.b.a n(JsObject jsObject) {
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        return G == null ? new d.a.m0.a.y.b.a() : G;
    }

    public void o(JsObject jsObject) {
        String m = m(jsObject, "removeStorage");
        if (m == null) {
            return;
        }
        g(jsObject, "removeStorage", m, e(m));
    }

    public void p(JsObject jsObject) {
        String m = m(jsObject, "setStorage");
        if (m == null) {
            return;
        }
        g(jsObject, "setStorage", m, f(m, i(jsObject)));
    }
}
