package d.a.l0.a.j0.c;

import android.net.Uri;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f46726a = "content://" + d.a.l0.a.j0.b.b.f46722b + "/history_with_app";

    /* renamed from: b  reason: collision with root package name */
    public static final String f46727b = "content://" + d.a.l0.a.j0.b.b.f46722b + "/history";

    /* renamed from: c  reason: collision with root package name */
    public static final String f46728c = "content://" + d.a.l0.a.j0.b.b.f46722b + "/history_with_aps_pms";

    public static Uri a() {
        return Uri.parse(f46727b);
    }

    public static Uri b() {
        return Uri.parse(f46726a);
    }

    public static Uri c() {
        return Uri.parse(f46728c);
    }
}
