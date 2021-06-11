package d.a.n0.b1.h;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f55405a = true;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Integer> f55406b = new HashMap<>();

    public static void a() {
        f55406b.clear();
    }

    public static int b() {
        return f55406b.size();
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f55406b.put(str, 0);
    }

    public static boolean d() {
        return f55405a;
    }

    public static void e(boolean z) {
        f55405a = z;
        if (z) {
            return;
        }
        f55406b.clear();
    }
}
