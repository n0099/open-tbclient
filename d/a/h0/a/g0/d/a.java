package d.a.h0.a.g0.d;

import android.net.Uri;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f42529a = "content://" + d.a.h0.a.g0.c.b.f42525b + "/history_with_app";

    /* renamed from: b  reason: collision with root package name */
    public static final String f42530b = "content://" + d.a.h0.a.g0.c.b.f42525b + "/history";

    /* renamed from: c  reason: collision with root package name */
    public static final String f42531c = "content://" + d.a.h0.a.g0.c.b.f42525b + "/history_with_aps_pms";

    public static Uri a() {
        return Uri.parse(f42530b);
    }

    public static Uri b() {
        return Uri.parse(f42529a);
    }

    public static Uri c() {
        return Uri.parse(f42531c);
    }
}
