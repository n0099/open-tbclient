package d.a.o0.t2.i0;

import d.a.c.k.e.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Set<n>> f64956a = new HashMap();

    public static Set<n> a(String str) {
        return f64956a.get(str);
    }

    public static void b(String str, Set<n> set) {
        f64956a.put(str, set);
    }

    public static void c(String str) {
        if (f64956a.get(str) != null) {
            f64956a.get(str).clear();
            f64956a.remove(str);
        }
    }
}
