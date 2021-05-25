package d.a.h.a.i;

import java.util.HashMap;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, a> f39960a = new HashMap<>();

    public static synchronized a a(String str) {
        a b2;
        synchronized (b.class) {
            b2 = b(str, 0);
        }
        return b2;
    }

    public static synchronized a b(String str, int i2) {
        a aVar;
        synchronized (b.class) {
            if (!f39960a.containsKey(str) || (aVar = f39960a.get(str)) == null) {
                a aVar2 = new a(str, i2);
                try {
                    aVar2.start();
                } catch (Exception unused) {
                }
                f39960a.put(str, aVar2);
                return aVar2;
            }
            return aVar;
        }
    }

    public static synchronized void c(a aVar) {
        synchronized (b.class) {
            if (aVar != null) {
                aVar.a();
                f39960a.values().remove(aVar);
            }
        }
    }
}
