package d.a.l0.a.h0.l.g;

import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42254a = d.a.l0.a.k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicInteger f42255b = new AtomicInteger(0);

    public static boolean a(String str) {
        return str != null && str.startsWith("master");
    }

    public static String b() {
        String str = "master";
        if (d.a.l0.a.h0.o.e.a.f()) {
            int andIncrement = f42255b.getAndIncrement();
            if (andIncrement >= 1) {
                str = "master" + andIncrement;
            }
            if (f42254a) {
                Log.i("MasterIdGenerator", "next master id - " + str);
            }
            return str;
        }
        return "master";
    }

    public static int c() {
        int andSet = f42255b.getAndSet(0);
        if (f42254a) {
            Log.i("MasterIdGenerator", "last master id - " + andSet);
        }
        return andSet;
    }
}
