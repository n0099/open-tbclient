package d.a.l0.a.s2;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f48364a;

    public static String a() {
        if (TextUtils.isEmpty(f48364a)) {
            f48364a = b.d();
        }
        return f48364a;
    }

    public static String b(String str) {
        return String.format("%s %s", str, a());
    }
}
