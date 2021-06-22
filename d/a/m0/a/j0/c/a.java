package d.a.m0.a.j0.c;

import android.net.Uri;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f46834a = "content://" + d.a.m0.a.j0.b.b.f46830b + "/history_with_app";

    /* renamed from: b  reason: collision with root package name */
    public static final String f46835b = "content://" + d.a.m0.a.j0.b.b.f46830b + "/history";

    /* renamed from: c  reason: collision with root package name */
    public static final String f46836c = "content://" + d.a.m0.a.j0.b.b.f46830b + "/history_with_aps_pms";

    public static Uri a() {
        return Uri.parse(f46835b);
    }

    public static Uri b() {
        return Uri.parse(f46834a);
    }

    public static Uri c() {
        return Uri.parse(f46836c);
    }
}
