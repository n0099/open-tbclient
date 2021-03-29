package d.b.g0.a.g2;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f44593a;

    public static String a() {
        if (TextUtils.isEmpty(f44593a)) {
            f44593a = b.d();
        }
        return f44593a;
    }

    public static String b(String str) {
        return String.format("%s %s", str, a());
    }
}
