package d.b.p0.e;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f65166a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<Integer, Boolean> f65167b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<Integer, Long> f65168c = new HashMap<>();

    public static long a(int i) {
        if (f65168c.containsKey(Integer.valueOf(i))) {
            return f65168c.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }

    public static synchronized void c(Context context) {
        synchronized (a.class) {
            if (!f65166a.get()) {
                SharedPreferences b2 = b(context);
                Iterator<Integer> it = b.f65169a.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    HashMap<Integer, Long> hashMap = f65168c;
                    Integer valueOf = Integer.valueOf(intValue);
                    hashMap.put(valueOf, Long.valueOf(b2.getLong("cache_" + intValue, 10080L)));
                    HashMap<Integer, Boolean> hashMap2 = f65167b;
                    Integer valueOf2 = Integer.valueOf(intValue);
                    hashMap2.put(valueOf2, Boolean.valueOf(b2.getBoolean("close_" + intValue, false)));
                }
                f65168c.put(20001, Long.MAX_VALUE);
                f65167b.put(20001, Boolean.TRUE);
                f65166a.set(true);
            }
        }
    }

    public static boolean d(int i) {
        if (f65167b.containsKey(Integer.valueOf(i))) {
            return f65167b.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static boolean e() {
        return false;
    }
}
