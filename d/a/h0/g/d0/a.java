package d.a.h0.g.d0;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import d.a.h0.g.d0.d.d;
/* loaded from: classes3.dex */
public class a extends c {
    public a(d.a.h0.g.i.b bVar) {
        super(bVar);
    }

    public final void g(JsObject jsObject, String str, String str2, d dVar) {
        d.a.h0.g.e.d.c n = n(jsObject);
        d.a.h0.g.e.d.b bVar = new d.a.h0.g.e.d.b();
        boolean g2 = dVar.g();
        bVar.errMsg = dVar.c(str, str2);
        d.a.h0.g.i0.b.a(n, g2, bVar);
        if (g2) {
            return;
        }
        d.a.h0.g.c0.c.i(str2, bVar.errMsg);
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

    public final d j(JsObject jsObject) {
        for (int i2 = 0; i2 < jsObject.length(); i2++) {
            if ("key".equals(jsObject.getPropertyName(i2))) {
                int propertyType = jsObject.getPropertyType(i2);
                return propertyType == 7 ? d.i(jsObject.toString(i2)) : d.b(String.format("parameter error: the key must be string instead of %s.", d.f(propertyType)));
            }
        }
        return d.b("parameter error: the parameter key is necessary.");
    }

    public void k(JsObject jsObject) {
        String m = m(jsObject, "getStorage");
        if (m == null) {
            return;
        }
        d c2 = c(m);
        if (c2.g()) {
            d.a.h0.g.d0.d.b bVar = new d.a.h0.g.d0.d.b();
            bVar.errMsg = d.a.h0.g.d0.d.a.b("getStorage");
            Object d2 = c2.d();
            bVar.data = d2;
            if (d2 instanceof JsSerializeValue) {
                ((JsSerializeValue) d2).setAutoRelease(false);
            }
            d.a.h0.g.i0.b.a(n(jsObject), true, bVar);
            return;
        }
        g(jsObject, "getStorage", m, c2);
    }

    public void l(JsObject jsObject) {
        d.a.h0.g.e.d.c n = n(jsObject);
        d.a.h0.g.d0.d.c b2 = b();
        b2.errMsg = d.a.h0.g.d0.d.a.b("getStorageInfo");
        d.a.h0.g.i0.b.a(n, true, b2);
    }

    public final String m(JsObject jsObject, String str) {
        d j = j(jsObject);
        if (!j.g()) {
            g(jsObject, str, "", j);
            return null;
        }
        return (String) j.d();
    }

    @NonNull
    public final d.a.h0.g.e.d.c n(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        return F == null ? new d.a.h0.g.e.d.c() : F;
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
