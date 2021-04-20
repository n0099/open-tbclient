package d.b.i0.a1.g;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f52723a = true;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Integer> f52724b = new HashMap<>();

    public static void a() {
        f52724b.clear();
    }

    public static int b() {
        return f52724b.size();
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f52724b.put(str, 0);
    }

    public static boolean d() {
        return f52723a;
    }

    public static void e(boolean z) {
        f52723a = z;
        if (z) {
            return;
        }
        f52724b.clear();
    }
}
