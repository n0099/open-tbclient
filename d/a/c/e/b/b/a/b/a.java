package d.a.c.e.b.b.a.b;

import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    public Object f42103a;

    public a(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return;
        }
        this.f42103a = obj;
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
        return this.f42103a;
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object c(d.a.c.e.b.b.a.e.c cVar) {
        return this.f42103a;
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object d(d.a.c.e.b.b.a.e.c cVar) {
        Object obj = this.f42103a;
        if (obj != null) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                return this.f42103a;
            }
            if (componentType == Byte.TYPE) {
                return this.f42103a;
            }
            if (componentType == Character.TYPE) {
                return this.f42103a;
            }
            if (componentType == Double.TYPE) {
                return this.f42103a;
            }
            if (componentType == Float.TYPE) {
                return this.f42103a;
            }
            if (componentType == Integer.TYPE) {
                return this.f42103a;
            }
            if (componentType == Long.TYPE) {
                return this.f42103a;
            }
            if (componentType == Short.TYPE) {
                return this.f42103a;
            }
            if (componentType == String.class) {
                return this.f42103a;
            }
            int length = Array.getLength(this.f42103a);
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < length; i2++) {
                Object f2 = d.a.c.e.b.b.a.e.f.a(Array.get(this.f42103a, i2)).f(new d.a.c.e.b.b.a.e.c(componentType));
                if (f2 != null) {
                    jSONArray.put(f2);
                }
            }
            return jSONArray.toString();
        }
        return null;
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object e(d.a.c.e.b.b.a.e.c cVar) {
        return d(cVar);
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object f(d.a.c.e.b.b.a.e.c cVar) {
        Object obj = this.f42103a;
        if (obj != null) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Character.TYPE) {
                return String.valueOf((char[]) this.f42103a);
            }
            if (componentType == Byte.TYPE) {
                try {
                    d.a.c.e.p.c.k((byte[]) this.f42103a, 0);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                int length = Array.getLength(this.f42103a);
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < length; i2++) {
                    Object f2 = d.a.c.e.b.b.a.e.f.a(Array.get(this.f42103a, i2)).f(new d.a.c.e.b.b.a.e.c(componentType));
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
