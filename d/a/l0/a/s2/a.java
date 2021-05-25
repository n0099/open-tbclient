package d.a.l0.a.s2;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f44690a;

    public static String a() {
        if (TextUtils.isEmpty(f44690a)) {
            f44690a = b.d();
        }
        return f44690a;
    }

    public static String b(String str) {
        return String.format("%s %s", str, a());
    }
}
