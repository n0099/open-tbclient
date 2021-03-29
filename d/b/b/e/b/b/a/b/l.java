package d.b.b.e.b.b.a.b;

import java.lang.reflect.Type;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l implements h {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f41621a;

    public l(Map<String, Object> map) {
        this.f41621a = map;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object a(d.b.b.e.b.b.a.e.c cVar) {
        Object f2 = f(cVar);
        if (f2 != null) {
            if (f2 instanceof JSONObject) {
                return f2.toString();
            }
            return f2 instanceof JSONArray ? f2.toString() : f2;
        }
        return null;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object b(d.b.b.e.b.b.a.e.c cVar) {
        return e(cVar);
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object c(d.b.b.e.b.b.a.e.c cVar) {
        return this.f41621a;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object d(d.b.b.e.b.b.a.e.c cVar) {
        return this.f41621a;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object e(d.b.b.e.b.b.a.e.c cVar) {
        Object f2 = f(cVar);
        if (f2 == null || !(f2 instanceof JSONObject)) {
            return null;
        }
        return f2.toString();
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object f(d.b.b.e.b.b.a.e.c cVar) {
        JSONObject jSONObject = new JSONObject();
        if (this.f41621a == null) {
            return jSONObject;
        }
        Type[] b2 = cVar.b();
        for (String str : this.f41621a.keySet()) {
            Object obj = this.f41621a.get(str);
            if (b2 != null && b2.length >= 2) {
                try {
                    jSONObject.put(str, d.b.b.e.b.b.a.e.f.a(obj).f(new d.b.b.e.b.b.a.e.c(b2[1])));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    jSONObject.put(str, d.b.b.e.b.b.a.e.f.a(obj).f(new d.b.b.e.b.b.a.e.c(cVar.a())));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        return jSONObject;
    }
}
