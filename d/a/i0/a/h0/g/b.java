package d.a.i0.a.h0.g;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f41846a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static d.a.i0.a.k2.g.g f41847b;

    public static d.a.i0.a.k2.g.g a() {
        if (f41847b == null) {
            synchronized (b.class) {
                if (f41847b == null) {
                    f41847b = new d.a.i0.a.k2.g.g("swan_about_page_sp", true);
                }
            }
        }
        return f41847b;
    }

    public static String b() {
        String D;
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q == null) {
            D = d.a.i0.a.v.a.a(d.a.i0.a.a2.d.g().getAppId());
        } else {
            D = Q.D();
        }
        return "pref_tool_" + D;
    }

    public static boolean c() {
        if (f41846a == -1) {
            f41846a = a().getInt(b(), 0);
        }
        return f41846a == 1;
    }
}
