package d.b.g;

import android.util.Log;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f43093a = false;

    public static void a(String str, Object... objArr) {
        if (f43093a) {
            Log.v("BDHttpDns", String.format(str, objArr));
        }
    }

    public static void b(boolean z) {
        f43093a = z;
    }
}
