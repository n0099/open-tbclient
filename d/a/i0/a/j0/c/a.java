package d.a.i0.a.j0.c;

import android.net.Uri;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f42876a = "content://" + d.a.i0.a.j0.b.b.f42872b + "/history_with_app";

    /* renamed from: b  reason: collision with root package name */
    public static final String f42877b = "content://" + d.a.i0.a.j0.b.b.f42872b + "/history";

    /* renamed from: c  reason: collision with root package name */
    public static final String f42878c = "content://" + d.a.i0.a.j0.b.b.f42872b + "/history_with_aps_pms";

    public static Uri a() {
        return Uri.parse(f42877b);
    }

    public static Uri b() {
        return Uri.parse(f42876a);
    }

    public static Uri c() {
        return Uri.parse(f42878c);
    }
}
