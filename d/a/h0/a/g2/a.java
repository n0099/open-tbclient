package d.a.h0.a.g2;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f42628a;

    public static String a() {
        if (TextUtils.isEmpty(f42628a)) {
            f42628a = b.d();
        }
        return f42628a;
    }

    public static String b(String str) {
        return String.format("%s %s", str, a());
    }
}
