package d.a.t0.e;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f68374a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<Integer, Boolean> f68375b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<Integer, Long> f68376c = new HashMap<>();

    public static long a(int i2) {
        if (f68376c.containsKey(Integer.valueOf(i2))) {
            return f68376c.get(Integer.valueOf(i2)).longValue();
        }
        return Long.MAX_VALUE;
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }

    public static synchronized void c(Context context) {
        synchronized (a.class) {
            if (!f68374a.get()) {
                SharedPreferences b2 = b(context);
                Iterator<Integer> it = b.f68377a.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    HashMap<Integer, Long> hashMap = f68376c;
                    Integer valueOf = Integer.valueOf(intValue);
                    hashMap.put(valueOf, Long.valueOf(b2.getLong("cache_" + intValue, 10080L)));
                    HashMap<Integer, Boolean> hashMap2 = f68375b;
                    Integer valueOf2 = Integer.valueOf(intValue);
                    hashMap2.put(valueOf2, Boolean.valueOf(b2.getBoolean("close_" + intValue, false)));
                }
                f68376c.put(20001, Long.MAX_VALUE);
                f68375b.put(20001, Boolean.TRUE);
                f68374a.set(true);
            }
        }
    }

    public static boolean d(int i2) {
        if (f68375b.containsKey(Integer.valueOf(i2))) {
            return f68375b.get(Integer.valueOf(i2)).booleanValue();
        }
        return true;
    }

    public static boolean e() {
        return false;
    }
}
