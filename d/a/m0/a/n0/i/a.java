package d.a.m0.a.n0.i;

import android.util.Log;
import d.a.m0.a.k;
import d.a.m0.a.k2.g.h;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47394a = k.f46983a;

    public static String a(int i2, String str) {
        return "frame_type_" + i2 + "_" + str;
    }

    public static long b(int i2) {
        long j = h.a().getLong(a(i2, "launch_time"), 0L);
        if (f47394a) {
            Log.d("LaunchRecorder", "frame_type : " + i2 + " , launch time : " + j);
        }
        return j;
    }

    public static void c(int i2) {
        String a2 = a(i2, "launch_time");
        long currentTimeMillis = System.currentTimeMillis();
        h.a().putLong(a2, currentTimeMillis);
        if (f47394a) {
            Log.d("LaunchRecorder", "frame_type : " + i2 + " , launch time : " + currentTimeMillis);
        }
    }
}
