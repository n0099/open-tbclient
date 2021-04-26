package d.a.c.e.b.b.a.b;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n implements h {

    /* renamed from: a  reason: collision with root package name */
    public Queue<?> f39553a;

    public n(Queue<?> queue) {
        this.f39553a = queue;
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object a(d.a.c.e.b.b.a.e.c cVar) {
        Object f2 = f(cVar);
        if (f2 != null) {
            if (f2 instanceof JSONObject) {
                return f2.toString();
            }
            return f2 instanceof JSONArray ? f2.toString() : f2;
        }
        return null;
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object b(d.a.c.e.b.b.a.e.c cVar) {
        return this.f39553a;
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object c(d.a.c.e.b.b.a.e.c cVar) {
        return this.f39553a;
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object d(d.a.c.e.b.b.a.e.c cVar) {
        Type[] b2 = cVar.b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f39553a) {
            if (obj != null) {
                if (b2 != null && b2.length >= 1) {
                    Object f2 = d.a.c.e.b.b.a.e.f.a(obj).f(new d.a.c.e.b.b.a.e.c(b2[0]));
                    if (f2 != null) {
                        arrayList.add(f2.toString());
                    }
                } else {
                    Object f3 = d.a.c.e.b.b.a.e.f.a(obj).f(new d.a.c.e.b.b.a.e.c(cVar.a()));
                    if (f3 != null) {
                        arrayList.add(f3.toString());
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object e(d.a.c.e.b.b.a.e.c cVar) {
        return d(cVar);
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object f(d.a.c.e.b.b.a.e.c cVar) {
        Type[] b2 = cVar.b();
        JSONArray jSONArray = new JSONArray();
        for (Object obj : this.f39553a) {
            if (obj != null) {
                if (b2 != null && b2.length >= 1) {
                    Object f2 = d.a.c.e.b.b.a.e.f.a(obj).f(new d.a.c.e.b.b.a.e.c(b2[0]));
                    if (f2 != null) {
                        jSONArray.put(f2);
                    }
                } else {
                    Object f3 = d.a.c.e.b.b.a.e.f.a(obj).f(new d.a.c.e.b.b.a.e.c(cVar.a()));
                    if (f3 != null) {
                        jSONArray.put(f3);
                    }
                }
            }
        }
        return jSONArray;
    }
}
