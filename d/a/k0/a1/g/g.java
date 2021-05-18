package d.a.k0.a1.g;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f51555a = true;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Integer> f51556b = new HashMap<>();

    public static void a() {
        f51556b.clear();
    }

    public static int b() {
        return f51556b.size();
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f51556b.put(str, 0);
    }

    public static boolean d() {
        return f51555a;
    }

    public static void e(boolean z) {
        f51555a = z;
        if (z) {
            return;
        }
        f51556b.clear();
    }
}
