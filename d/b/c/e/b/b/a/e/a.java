package d.b.c.e.b.b.a.e;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    public static final List<Object> a(c cVar, int i) {
        Class<?> a2 = cVar.a();
        if (a2 != List.class && a2 != ArrayList.class) {
            if (a2 == LinkedList.class) {
                return new LinkedList();
            }
            Object i2 = d.b.c.e.b.a.a.i(a2, i);
            if (i2 == null) {
                i2 = d.b.c.e.b.a.a.h(a2);
            }
            if (i2 instanceof List) {
                return (List) i2;
            }
            return null;
        }
        return new ArrayList(i);
    }

    public static final Map<String, Object> b(c cVar, int i) {
        Class<?> a2 = cVar.a();
        Type[] b2 = cVar.b();
        if (d.b.c.e.b.a.a.g(a2, Map.class)) {
            if (b2 != null && b2.length >= 2 && b2[0] == String.class) {
                if (a2 == Map.class) {
                    return new HashMap(i);
                }
                Object i2 = d.b.c.e.b.a.a.i(a2, i);
                if (i2 == null) {
                    i2 = d.b.c.e.b.a.a.h(a2);
                }
                if (i2 instanceof Map) {
                    return (Map) i2;
                }
                return null;
            } else if (a2 == Map.class) {
                return new HashMap(i);
            } else {
                Object i3 = d.b.c.e.b.a.a.i(a2, i);
                if (i3 == null) {
                    i3 = d.b.c.e.b.a.a.h(a2);
                }
                if (i3 instanceof Map) {
                    return (Map) i3;
                }
                return null;
            }
        }
        return null;
    }

    public static final Queue<Object> c(c cVar, int i) {
        Class<?> a2 = cVar.a();
        if (a2 == Queue.class) {
            return new LinkedList();
        }
        Object i2 = d.b.c.e.b.a.a.i(a2, i);
        if (i2 == null) {
            i2 = d.b.c.e.b.a.a.h(a2);
        }
        if (i2 instanceof Queue) {
            return (Queue) i2;
        }
        return null;
    }

    public static final Set<Object> d(c cVar, int i) {
        Class<?> a2 = cVar.a();
        if (a2 == Set.class) {
            return new HashSet();
        }
        Object i2 = d.b.c.e.b.a.a.i(a2, i);
        if (i2 == null) {
            i2 = d.b.c.e.b.a.a.h(a2);
        }
        if (i2 instanceof Set) {
            return (Set) i2;
        }
        return null;
    }
}
