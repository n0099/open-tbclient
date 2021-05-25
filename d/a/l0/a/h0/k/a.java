package d.a.l0.a.h0.k;

import android.util.Log;
import d.a.l0.a.k;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42205a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicInteger f42206b = new AtomicInteger(0);

    public static boolean a(String str) {
        return str != null && str.startsWith("localDebug");
    }

    public static String b() {
        int andIncrement = f42206b.getAndIncrement();
        String str = "localDebug";
        if (andIncrement >= 1) {
            str = "localDebug" + andIncrement;
        }
        if (f42205a) {
            Log.i("DaemonIdGenerator", "next daemon id - " + str);
        }
        return str;
    }
}
