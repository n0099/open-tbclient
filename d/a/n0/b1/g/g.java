package d.a.n0.b1.g;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f51722a = true;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Integer> f51723b = new HashMap<>();

    public static void a() {
        f51723b.clear();
    }

    public static int b() {
        return f51723b.size();
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f51723b.put(str, 0);
    }

    public static boolean d() {
        return f51722a;
    }

    public static void e(boolean z) {
        f51722a = z;
        if (z) {
            return;
        }
        f51723b.clear();
    }
}
