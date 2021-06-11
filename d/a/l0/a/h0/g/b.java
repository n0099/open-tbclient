package d.a.l0.a.h0.g;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f45696a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static d.a.l0.a.k2.g.g f45697b;

    public static d.a.l0.a.k2.g.g a() {
        if (f45697b == null) {
            synchronized (b.class) {
                if (f45697b == null) {
                    f45697b = new d.a.l0.a.k2.g.g("swan_about_page_sp", true);
                }
            }
        }
        return f45697b;
    }

    public static String b() {
        String D;
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            D = d.a.l0.a.v.a.a(d.a.l0.a.a2.d.g().getAppId());
        } else {
            D = Q.D();
        }
        return "pref_tool_" + D;
    }

    public static boolean c() {
        if (f45696a == -1) {
            f45696a = a().getInt(b(), 0);
        }
        return f45696a == 1;
    }
}
