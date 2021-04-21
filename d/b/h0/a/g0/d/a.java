package d.b.h0.a.g0.d;

import android.net.Uri;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f45216a = "content://" + d.b.h0.a.g0.c.b.f45212b + "/history_with_app";

    /* renamed from: b  reason: collision with root package name */
    public static final String f45217b = "content://" + d.b.h0.a.g0.c.b.f45212b + "/history";

    /* renamed from: c  reason: collision with root package name */
    public static final String f45218c = "content://" + d.b.h0.a.g0.c.b.f45212b + "/history_with_aps_pms";

    public static Uri a() {
        return Uri.parse(f45217b);
    }

    public static Uri b() {
        return Uri.parse(f45216a);
    }

    public static Uri c() {
        return Uri.parse(f45218c);
    }
}
