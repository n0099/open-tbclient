package d.a.p0.e;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.sapi2.share.ShareCallPacking;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f63480a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<Integer, Boolean> f63481b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<Integer, Long> f63482c = new HashMap<>();

    public static long a(int i2) {
        if (f63482c.containsKey(Integer.valueOf(i2))) {
            return f63482c.get(Integer.valueOf(i2)).longValue();
        }
        return Long.MAX_VALUE;
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }

    public static synchronized void c(Context context) {
        synchronized (a.class) {
            if (!f63480a.get()) {
                SharedPreferences b2 = b(context);
                Iterator<Integer> it = b.f63483a.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    HashMap<Integer, Long> hashMap = f63482c;
                    Integer valueOf = Integer.valueOf(intValue);
                    hashMap.put(valueOf, Long.valueOf(b2.getLong("cache_" + intValue, 10080L)));
                    HashMap<Integer, Boolean> hashMap2 = f63481b;
                    Integer valueOf2 = Integer.valueOf(intValue);
                    hashMap2.put(valueOf2, Boolean.valueOf(b2.getBoolean("close_" + intValue, false)));
                }
                f63482c.put(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT), Long.MAX_VALUE);
                f63481b.put(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT), Boolean.TRUE);
                f63480a.set(true);
            }
        }
    }

    public static boolean d(int i2) {
        if (f63481b.containsKey(Integer.valueOf(i2))) {
            return f63481b.get(Integer.valueOf(i2)).booleanValue();
        }
        return true;
    }

    public static boolean e() {
        return false;
    }
}
