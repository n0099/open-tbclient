package d.a.n0.t2.i0;

import d.a.c.k.e.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Set<n>> f64831a = new HashMap();

    public static Set<n> a(String str) {
        return f64831a.get(str);
    }

    public static void b(String str, Set<n> set) {
        f64831a.put(str, set);
    }

    public static void c(String str) {
        if (f64831a.get(str) != null) {
            f64831a.get(str).clear();
            f64831a.remove(str);
        }
    }
}
