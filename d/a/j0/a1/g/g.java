package d.a.j0.a1.g;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f50858a = true;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Integer> f50859b = new HashMap<>();

    public static void a() {
        f50859b.clear();
    }

    public static int b() {
        return f50859b.size();
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f50859b.put(str, 0);
    }

    public static boolean d() {
        return f50858a;
    }

    public static void e(boolean z) {
        f50858a = z;
        if (z) {
            return;
        }
        f50859b.clear();
    }
}
