package d.b.j0.a1.g;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f53144a = true;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Integer> f53145b = new HashMap<>();

    public static void a() {
        f53145b.clear();
    }

    public static int b() {
        return f53145b.size();
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f53145b.put(str, 0);
    }

    public static boolean d() {
        return f53144a;
    }

    public static void e(boolean z) {
        f53144a = z;
        if (z) {
            return;
        }
        f53145b.clear();
    }
}
