package d.a.l0.a.j0.c;

import android.net.Uri;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f43050a = "content://" + d.a.l0.a.j0.b.b.f43046b + "/history_with_app";

    /* renamed from: b  reason: collision with root package name */
    public static final String f43051b = "content://" + d.a.l0.a.j0.b.b.f43046b + "/history";

    /* renamed from: c  reason: collision with root package name */
    public static final String f43052c = "content://" + d.a.l0.a.j0.b.b.f43046b + "/history_with_aps_pms";

    public static Uri a() {
        return Uri.parse(f43051b);
    }

    public static Uri b() {
        return Uri.parse(f43050a);
    }

    public static Uri c() {
        return Uri.parse(f43052c);
    }
}
