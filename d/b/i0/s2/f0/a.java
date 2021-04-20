package d.b.i0.s2.f0;

import d.b.c.j.e.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Set<n>> f61673a = new HashMap();

    public static Set<n> a(String str) {
        return f61673a.get(str);
    }

    public static void b(String str, Set<n> set) {
        f61673a.put(str, set);
    }

    public static void c(String str) {
        if (f61673a.get(str) != null) {
            f61673a.get(str).clear();
            f61673a.remove(str);
        }
    }
}
