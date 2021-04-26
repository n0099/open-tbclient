package d.a.g;

import android.util.Log;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f40739a = false;

    public static void a(String str, Object... objArr) {
        if (f40739a) {
            Log.v("BDHttpDns", String.format(str, objArr));
        }
    }

    public static void b(boolean z) {
        f40739a = z;
    }
}
