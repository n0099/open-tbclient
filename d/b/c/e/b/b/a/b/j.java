package d.b.c.e.b.b.a.b;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j implements h {

    /* renamed from: a  reason: collision with root package name */
    public List<?> f42116a;

    public j(List<?> list) {
        this.f42116a = list;
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
        return this.f42116a;
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object d(d.b.c.e.b.b.a.e.c cVar) {
        return this.f42116a;
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object e(d.b.c.e.b.b.a.e.c cVar) {
        Type[] b2 = cVar.b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f42116a) {
            if (obj != null) {
                if (b2 != null && b2.length >= 1) {
                    Object f2 = d.b.c.e.b.b.a.e.f.a(obj).f(new d.b.c.e.b.b.a.e.c(b2[0]));
                    if (f2 != null) {
                        arrayList.add(f2.toString());
                    }
                } else {
                    Object f3 = d.b.c.e.b.b.a.e.f.a(obj).f(new d.b.c.e.b.b.a.e.c(cVar.a()));
                    if (f3 != null) {
                        arrayList.add(f3.toString());
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object f(d.b.c.e.b.b.a.e.c cVar) {
        Type[] b2 = cVar.b();
        JSONArray jSONArray = new JSONArray();
        for (Object obj : this.f42116a) {
            if (obj != null) {
                if (b2 != null && b2.length >= 1) {
                    Object f2 = d.b.c.e.b.b.a.e.f.a(obj).f(new d.b.c.e.b.b.a.e.c(b2[0]));
                    if (f2 != null) {
                        jSONArray.put(f2);
                    }
                } else {
                    Object f3 = d.b.c.e.b.b.a.e.f.a(obj).f(new d.b.c.e.b.b.a.e.c(cVar.a()));
                    if (f3 != null) {
                        jSONArray.put(f3);
                    }
                }
            }
        }
        return jSONArray;
    }
}
