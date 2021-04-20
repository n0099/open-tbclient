package d.b.g0.a.g2;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f44985a;

    public static String a() {
        if (TextUtils.isEmpty(f44985a)) {
            f44985a = b.d();
        }
        return f44985a;
    }

    public static String b(String str) {
        return String.format("%s %s", str, a());
    }
}
