package d.b.i0.z0.g;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f63103a = true;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Integer> f63104b = new HashMap<>();

    public static void a() {
        f63104b.clear();
    }

    public static int b() {
        return f63104b.size();
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f63104b.put(str, 0);
    }

    public static boolean d() {
        return f63103a;
    }

    public static void e(boolean z) {
        f63103a = z;
        if (z) {
            return;
        }
        f63104b.clear();
    }
}
