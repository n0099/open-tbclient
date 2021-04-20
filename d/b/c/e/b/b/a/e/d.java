package d.b.c.e.b.b.a.e;

import android.text.TextUtils;
import d.b.c.e.b.b.a.b.h;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public class d {
    public static final boolean a(d.b.c.e.b.b.a.a.b bVar, d.b.c.e.b.b.a.c.c cVar) {
        h a2;
        if (bVar == null || cVar == null) {
            return false;
        }
        for (Field field : d.b.c.e.b.a.a.b(bVar.getClass())) {
            if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                String name = field.getName();
                if (!TextUtils.isEmpty(name) && (a2 = f.a(d.b.c.e.b.a.a.d(bVar, name))) != null) {
                    Object obj = null;
                    if (cVar instanceof d.b.c.e.b.b.a.c.e) {
                        obj = a2.f(new c(field.getGenericType()));
                    } else if (cVar instanceof d.b.c.e.b.b.a.c.a) {
                        obj = a2.e(new c(field.getGenericType()));
                    } else if (cVar instanceof d.b.c.e.b.b.a.c.d) {
                        obj = a2.b(new c(field.getGenericType()));
                    } else if (cVar instanceof d.b.c.e.b.b.a.c.f) {
                        obj = a2.c(new c(field.getGenericType()));
                    } else if (cVar instanceof d.b.c.e.b.b.a.c.b) {
                        obj = a2.a(new c(field.getGenericType()));
                    } else if (cVar instanceof d.b.c.e.b.b.a.c.g) {
                        obj = a2.d(new c(field.getGenericType()));
                    }
                    if (obj != null) {
                        cVar.b(name, obj);
                    }
                }
            }
        }
        return true;
    }
}
