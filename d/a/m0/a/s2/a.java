package d.a.m0.a.s2;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f48472a;

    public static String a() {
        if (TextUtils.isEmpty(f48472a)) {
            f48472a = b.d();
        }
        return f48472a;
    }

    public static String b(String str) {
        return String.format("%s %s", str, a());
    }
}
