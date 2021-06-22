package d.a.o0.b1.h;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f55530a = true;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Integer> f55531b = new HashMap<>();

    public static void a() {
        f55531b.clear();
    }

    public static int b() {
        return f55531b.size();
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f55531b.put(str, 0);
    }

    public static boolean d() {
        return f55530a;
    }

    public static void e(boolean z) {
        f55530a = z;
        if (z) {
            return;
        }
        f55531b.clear();
    }
}
