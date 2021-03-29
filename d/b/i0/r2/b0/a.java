package d.b.i0.r2.b0;

import d.b.b.j.e.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Set<n>> f59754a = new HashMap();

    public static Set<n> a(String str) {
        return f59754a.get(str);
    }

    public static void b(String str, Set<n> set) {
        f59754a.put(str, set);
    }

    public static void c(String str) {
        if (f59754a.get(str) != null) {
            f59754a.get(str).clear();
            f59754a.remove(str);
        }
    }
}
