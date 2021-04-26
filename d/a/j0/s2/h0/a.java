package d.a.j0.s2.h0;

import d.a.c.j.e.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Set<n>> f60294a = new HashMap();

    public static Set<n> a(String str) {
        return f60294a.get(str);
    }

    public static void b(String str, Set<n> set) {
        f60294a.put(str, set);
    }

    public static void c(String str) {
        if (f60294a.get(str) != null) {
            f60294a.get(str).clear();
            f60294a.remove(str);
        }
    }
}
