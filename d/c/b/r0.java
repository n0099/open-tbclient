package d.c.b;

import android.util.Log;
/* loaded from: classes5.dex */
public class r0 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f65062a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f65063b = false;

    public static void a(String str, Throwable th) {
        if (f65063b) {
            Log.d("TeaLog", str, th);
        }
    }

    public static void b(Throwable th) {
        Log.e("TeaLog", "U SHALL NOT PASS!", th);
    }

    public static void c(String str, Throwable th) {
        Log.w("TeaLog", str, th);
    }

    public static void d(String str, Throwable th) {
        Log.e("TeaLog", str, th);
    }

    public static void e(String str, Throwable th) {
        Log.i("TeaLog", str, th);
    }
}
