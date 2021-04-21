package d.b.h0.a.g2;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f45314a;

    public static String a() {
        if (TextUtils.isEmpty(f45314a)) {
            f45314a = b.d();
        }
        return f45314a;
    }

    public static String b(String str) {
        return String.format("%s %s", str, a());
    }
}
