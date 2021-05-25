package d.a.n0.t2.i0;

import d.a.c.j.e.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Set<n>> f61139a = new HashMap();

    public static Set<n> a(String str) {
        return f61139a.get(str);
    }

    public static void b(String str, Set<n> set) {
        f61139a.put(str, set);
    }

    public static void c(String str) {
        if (f61139a.get(str) != null) {
            f61139a.get(str).clear();
            f61139a.remove(str);
        }
    }
}
