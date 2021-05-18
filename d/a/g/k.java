package d.a.g;

import android.util.Log;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f39984a = false;

    public static void a(String str, Object... objArr) {
        if (f39984a) {
            Log.v("BDHttpDns", String.format(str, objArr));
        }
    }

    public static void b(boolean z) {
        f39984a = z;
    }
}
