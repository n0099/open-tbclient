package d.b.g0.a.g0.d;

import android.net.Uri;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f44494a = "content://" + d.b.g0.a.g0.c.b.f44490b + "/history_with_app";

    /* renamed from: b  reason: collision with root package name */
    public static final String f44495b = "content://" + d.b.g0.a.g0.c.b.f44490b + "/history";

    /* renamed from: c  reason: collision with root package name */
    public static final String f44496c = "content://" + d.b.g0.a.g0.c.b.f44490b + "/history_with_aps_pms";

    public static Uri a() {
        return Uri.parse(f44495b);
    }

    public static Uri b() {
        return Uri.parse(f44494a);
    }

    public static Uri c() {
        return Uri.parse(f44496c);
    }
}
