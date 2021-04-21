package d.b.c.e.b.b.a.b;

import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    public Object f42348a;

    public a(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return;
        }
        this.f42348a = obj;
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
        return this.f42348a;
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object d(d.b.c.e.b.b.a.e.c cVar) {
        return this.f42348a;
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object e(d.b.c.e.b.b.a.e.c cVar) {
        Object obj = this.f42348a;
        if (obj != null) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                return this.f42348a;
            }
            if (componentType == Byte.TYPE) {
                return this.f42348a;
            }
            if (componentType == Character.TYPE) {
                return this.f42348a;
            }
            if (componentType == Double.TYPE) {
                return this.f42348a;
            }
            if (componentType == Float.TYPE) {
                return this.f42348a;
            }
            if (componentType == Integer.TYPE) {
                return this.f42348a;
            }
            if (componentType == Long.TYPE) {
                return this.f42348a;
            }
            if (componentType == Short.TYPE) {
                return this.f42348a;
            }
            if (componentType == String.class) {
                return this.f42348a;
            }
            int length = Array.getLength(this.f42348a);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                Object f2 = d.b.c.e.b.b.a.e.f.a(Array.get(this.f42348a, i)).f(new d.b.c.e.b.b.a.e.c(componentType));
                if (f2 != null) {
                    jSONArray.put(f2);
                }
            }
            return jSONArray.toString();
        }
        return null;
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object f(d.b.c.e.b.b.a.e.c cVar) {
        Object obj = this.f42348a;
        if (obj != null) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Character.TYPE) {
                return String.valueOf((char[]) this.f42348a);
            }
            if (componentType == Byte.TYPE) {
                try {
                    d.b.c.e.p.c.k((byte[]) this.f42348a, 0);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                int length = Array.getLength(this.f42348a);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    Object f2 = d.b.c.e.b.b.a.e.f.a(Array.get(this.f42348a, i)).f(new d.b.c.e.b.b.a.e.c(componentType));
                    if (f2 != null) {
                        jSONArray.put(f2);
                    }
                }
                return jSONArray;
            }
        }
        return null;
    }
}
