package d.b.h.a.i;

import java.util.HashMap;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, a> f43774a = new HashMap<>();

    public static synchronized a a(String str) {
        a b2;
        synchronized (b.class) {
            b2 = b(str, 0);
        }
        return b2;
    }

    public static synchronized a b(String str, int i) {
        a aVar;
        synchronized (b.class) {
            if (!f43774a.containsKey(str) || (aVar = f43774a.get(str)) == null) {
                a aVar2 = new a(str, i);
                try {
                    aVar2.start();
                } catch (Exception unused) {
                }
                f43774a.put(str, aVar2);
                return aVar2;
            }
            return aVar;
        }
    }

    public static synchronized void c(a aVar) {
        synchronized (b.class) {
            if (aVar != null) {
                aVar.a();
                f43774a.values().remove(aVar);
            }
        }
    }
}
