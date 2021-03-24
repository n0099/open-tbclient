package d.b.b.e.b.b.a.b;

import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    public Object f41610a;

    public a(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return;
        }
        this.f41610a = obj;
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
        return this.f41610a;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object d(d.b.b.e.b.b.a.e.c cVar) {
        return this.f41610a;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object e(d.b.b.e.b.b.a.e.c cVar) {
        Object obj = this.f41610a;
        if (obj != null) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Boolean.TYPE) {
                return this.f41610a;
            }
            if (componentType == Byte.TYPE) {
                return this.f41610a;
            }
            if (componentType == Character.TYPE) {
                return this.f41610a;
            }
            if (componentType == Double.TYPE) {
                return this.f41610a;
            }
            if (componentType == Float.TYPE) {
                return this.f41610a;
            }
            if (componentType == Integer.TYPE) {
                return this.f41610a;
            }
            if (componentType == Long.TYPE) {
                return this.f41610a;
            }
            if (componentType == Short.TYPE) {
                return this.f41610a;
            }
            if (componentType == String.class) {
                return this.f41610a;
            }
            int length = Array.getLength(this.f41610a);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                Object f2 = d.b.b.e.b.b.a.e.f.a(Array.get(this.f41610a, i)).f(new d.b.b.e.b.b.a.e.c(componentType));
                if (f2 != null) {
                    jSONArray.put(f2);
                }
            }
            return jSONArray.toString();
        }
        return null;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object f(d.b.b.e.b.b.a.e.c cVar) {
        Object obj = this.f41610a;
        if (obj != null) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType == Character.TYPE) {
                return String.valueOf((char[]) this.f41610a);
            }
            if (componentType == Byte.TYPE) {
                try {
                    d.b.b.e.p.c.k((byte[]) this.f41610a, 0);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                int length = Array.getLength(this.f41610a);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    Object f2 = d.b.b.e.b.b.a.e.f.a(Array.get(this.f41610a, i)).f(new d.b.b.e.b.b.a.e.c(componentType));
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
