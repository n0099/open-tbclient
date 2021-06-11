package d.a.g;

import android.util.Log;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f43578a = false;

    public static void a(String str, Object... objArr) {
        if (f43578a) {
            Log.v("BDHttpDns", String.format(str, objArr));
        }
    }

    public static void b(boolean z) {
        f43578a = z;
    }
}
