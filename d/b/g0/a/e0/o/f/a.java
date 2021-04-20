package d.b.g0.a.e0.o.f;

import android.util.Log;
import d.b.g0.a.k;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44506a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicInteger f44507b = new AtomicInteger(0);

    public static boolean a(String str) {
        return str != null && str.startsWith("master");
    }

    public static String b() {
        String str = "master";
        if (d.b.g0.a.e0.q.e.a.c()) {
            int andIncrement = f44507b.getAndIncrement();
            if (andIncrement >= 1) {
                str = "master" + andIncrement;
            }
            if (f44506a) {
                Log.i("MasterIdGenerator", "next master id - " + str);
            }
            return str;
        }
        return "master";
    }

    public static int c() {
        int andSet = f44507b.getAndSet(0);
        if (f44506a) {
            Log.i("MasterIdGenerator", "last master id - " + andSet);
        }
        return andSet;
    }
}
