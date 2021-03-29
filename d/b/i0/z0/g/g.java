package d.b.i0.z0.g;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f63104a = true;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Integer> f63105b = new HashMap<>();

    public static void a() {
        f63105b.clear();
    }

    public static int b() {
        return f63105b.size();
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f63105b.put(str, 0);
    }

    public static boolean d() {
        return f63104a;
    }

    public static void e(boolean z) {
        f63104a = z;
        if (z) {
            return;
        }
        f63105b.clear();
    }
}
