package d.a.m0.a.h0.l.g;

import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46038a = d.a.m0.a.k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicInteger f46039b = new AtomicInteger(0);

    public static boolean a(String str) {
        return str != null && str.startsWith("master");
    }

    public static String b() {
        String str = "master";
        if (d.a.m0.a.h0.o.e.a.f()) {
            int andIncrement = f46039b.getAndIncrement();
            if (andIncrement >= 1) {
                str = "master" + andIncrement;
            }
            if (f46038a) {
                Log.i("MasterIdGenerator", "next master id - " + str);
            }
            return str;
        }
        return "master";
    }

    public static int c() {
        int andSet = f46039b.getAndSet(0);
        if (f46038a) {
            Log.i("MasterIdGenerator", "last master id - " + andSet);
        }
        return andSet;
    }
}
