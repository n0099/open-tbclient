package d.a.l0.a.h0.l.g;

import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45930a = d.a.l0.a.k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicInteger f45931b = new AtomicInteger(0);

    public static boolean a(String str) {
        return str != null && str.startsWith("master");
    }

    public static String b() {
        String str = "master";
        if (d.a.l0.a.h0.o.e.a.f()) {
            int andIncrement = f45931b.getAndIncrement();
            if (andIncrement >= 1) {
                str = "master" + andIncrement;
            }
            if (f45930a) {
                Log.i("MasterIdGenerator", "next master id - " + str);
            }
            return str;
        }
        return "master";
    }

    public static int c() {
        int andSet = f45931b.getAndSet(0);
        if (f45930a) {
            Log.i("MasterIdGenerator", "last master id - " + andSet);
        }
        return andSet;
    }
}
