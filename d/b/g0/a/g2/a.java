package d.b.g0.a.g2;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f44592a;

    public static String a() {
        if (TextUtils.isEmpty(f44592a)) {
            f44592a = b.d();
        }
        return f44592a;
    }

    public static String b(String str) {
        return String.format("%s %s", str, a());
    }
}
