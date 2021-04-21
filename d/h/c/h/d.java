package d.h.c.h;

import d.h.c.a.n;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public abstract class d<T> {
    public final Type capture() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        n.k(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
