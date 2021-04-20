package d.b.c.e.b.b.a.b;

import java.lang.reflect.Type;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l implements h {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f42118a;

    public l(Map<String, Object> map) {
        this.f42118a = map;
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object a(d.b.c.e.b.b.a.e.c cVar) {
        Object f2 = f(cVar);
        if (f2 != null) {
            if (f2 instanceof JSONObject) {
                return f2.toString();
            }
            return f2 instanceof JSONArray ? f2.toString() : f2;
        }
        return null;
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object b(d.b.c.e.b.b.a.e.c cVar) {
        return e(cVar);
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object c(d.b.c.e.b.b.a.e.c cVar) {
        return this.f42118a;
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object d(d.b.c.e.b.b.a.e.c cVar) {
        return this.f42118a;
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object e(d.b.c.e.b.b.a.e.c cVar) {
        Object f2 = f(cVar);
        if (f2 == null || !(f2 instanceof JSONObject)) {
            return null;
        }
        return f2.toString();
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object f(d.b.c.e.b.b.a.e.c cVar) {
        JSONObject jSONObject = new JSONObject();
        if (this.f42118a == null) {
            return jSONObject;
        }
        Type[] b2 = cVar.b();
        for (String str : this.f42118a.keySet()) {
            Object obj = this.f42118a.get(str);
            if (b2 != null && b2.length >= 2) {
                try {
                    jSONObject.put(str, d.b.c.e.b.b.a.e.f.a(obj).f(new d.b.c.e.b.b.a.e.c(b2[1])));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    jSONObject.put(str, d.b.c.e.b.b.a.e.f.a(obj).f(new d.b.c.e.b.b.a.e.c(cVar.a())));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        return jSONObject;
    }
}
