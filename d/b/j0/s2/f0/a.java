package d.b.j0.s2.f0;

import d.b.c.j.e.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Set<n>> f62094a = new HashMap();

    public static Set<n> a(String str) {
        return f62094a.get(str);
    }

    public static void b(String str, Set<n> set) {
        f62094a.put(str, set);
    }

    public static void c(String str) {
        if (f62094a.get(str) != null) {
            f62094a.get(str).clear();
            f62094a.remove(str);
        }
    }
}
