package d.a.h0.a.e0.o.f;

import android.util.Log;
import d.a.h0.a.k;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42135a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicInteger f42136b = new AtomicInteger(0);

    public static boolean a(String str) {
        return str != null && str.startsWith("master");
    }

    public static String b() {
        String str = "master";
        if (d.a.h0.a.e0.q.e.a.c()) {
            int andIncrement = f42136b.getAndIncrement();
            if (andIncrement >= 1) {
                str = "master" + andIncrement;
            }
            if (f42135a) {
                Log.i("MasterIdGenerator", "next master id - " + str);
            }
            return str;
        }
        return "master";
    }

    public static int c() {
        int andSet = f42136b.getAndSet(0);
        if (f42135a) {
            Log.i("MasterIdGenerator", "last master id - " + andSet);
        }
        return andSet;
    }
}
