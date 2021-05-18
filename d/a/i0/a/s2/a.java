package d.a.i0.a.s2;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f44514a;

    public static String a() {
        if (TextUtils.isEmpty(f44514a)) {
            f44514a = b.d();
        }
        return f44514a;
    }

    public static String b(String str) {
        return String.format("%s %s", str, a());
    }
}
