package d.b.h.a.i;

import java.util.HashMap;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, a> f49454a = new HashMap<>();

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
            if (!f49454a.containsKey(str) || (aVar = f49454a.get(str)) == null) {
                a aVar2 = new a(str, i);
                try {
                    aVar2.start();
                } catch (Exception unused) {
                }
                f49454a.put(str, aVar2);
                return aVar2;
            }
            return aVar;
        }
    }

    public static synchronized void c(a aVar) {
        synchronized (b.class) {
            if (aVar != null) {
                aVar.a();
                f49454a.values().remove(aVar);
            }
        }
    }
}
