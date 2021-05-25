package d.a.c.e.b.b.a.d;

import android.util.SparseArray;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class j implements h {

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f38486a;

    public j(JSONArray jSONArray) {
        this.f38486a = jSONArray;
    }

    @Override // d.a.c.e.b.b.a.d.h
    public Object a(d.a.c.e.b.b.a.e.c cVar) {
        Class<?> a2 = cVar.a();
        Type[] b2 = cVar.b();
        if (a2.isArray()) {
            Class<?> componentType = a2.getComponentType();
            Object newInstance = Array.newInstance(componentType, this.f38486a.length());
            int length = this.f38486a.length();
            for (int i2 = 0; i2 < length; i2++) {
                Object a3 = d.a.c.e.b.b.a.e.g.a(this.f38486a.opt(i2)).a(new d.a.c.e.b.b.a.e.c(componentType));
                if (a3 != null) {
                    Array.set(newInstance, i2, a3);
                }
            }
            return newInstance;
        } else if (b2 == null || b2.length < 1) {
            return null;
        } else {
            if (d.a.c.e.b.a.a.g(a2, List.class)) {
                List<Object> a4 = d.a.c.e.b.b.a.e.a.a(cVar, this.f38486a.length());
                if (a4 != null) {
                    int length2 = this.f38486a.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        Object a5 = d.a.c.e.b.b.a.e.g.a(this.f38486a.opt(i3)).a(new d.a.c.e.b.b.a.e.c(b2[0]));
                        if (a5 != null) {
                            a4.add(a5);
                        }
                    }
                }
                return a4;
            } else if (d.a.c.e.b.a.a.g(a2, Set.class)) {
                Set<Object> d2 = d.a.c.e.b.b.a.e.a.d(cVar, this.f38486a.length());
                if (d2 != null) {
                    int length3 = this.f38486a.length();
                    for (int i4 = 0; i4 < length3; i4++) {
                        Object a6 = d.a.c.e.b.b.a.e.g.a(this.f38486a.opt(i4)).a(new d.a.c.e.b.b.a.e.c(b2[0]));
                        if (a6 != null) {
                            d2.add(a6);
                        }
                    }
                }
                return d2;
            } else if (d.a.c.e.b.a.a.g(a2, Map.class)) {
                Map<String, Object> b3 = d.a.c.e.b.b.a.e.a.b(cVar, this.f38486a.length());
                if (b3 != null) {
                    int length4 = this.f38486a.length();
                    for (int i5 = 0; i5 < length4; i5++) {
                        Object a7 = d.a.c.e.b.b.a.e.g.a(this.f38486a.opt(i5)).a(new d.a.c.e.b.b.a.e.c(b2[0]));
                        if (a7 != null) {
                            b3.put(String.valueOf(i5), a7);
                        }
                    }
                }
                return b3;
            } else if (d.a.c.e.b.a.a.g(a2, Queue.class)) {
                Queue<Object> c2 = d.a.c.e.b.b.a.e.a.c(cVar, this.f38486a.length());
                if (c2 != null) {
                    int length5 = this.f38486a.length();
                    for (int i6 = 0; i6 < length5; i6++) {
                        Object a8 = d.a.c.e.b.b.a.e.g.a(this.f38486a.opt(i6)).a(new d.a.c.e.b.b.a.e.c(b2[0]));
                        if (a8 != null) {
                            c2.add(a8);
                        }
                    }
                }
                return c2;
            } else if (a2 == SparseArray.class) {
                SparseArray sparseArray = new SparseArray(this.f38486a.length());
                int length6 = this.f38486a.length();
                for (int i7 = 0; i7 < length6; i7++) {
                    Object a9 = d.a.c.e.b.b.a.e.g.a(this.f38486a.opt(i7)).a(new d.a.c.e.b.b.a.e.c(b2[0]));
                    if (a9 != null) {
                        sparseArray.put(i7, a9);
                    }
                }
                return sparseArray;
            } else {
                return null;
            }
        }
    }
}
