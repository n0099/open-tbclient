package d.a.m0.a.h0.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f45804a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static d.a.m0.a.k2.g.g f45805b;

    public static d.a.m0.a.k2.g.g a() {
        if (f45805b == null) {
            synchronized (b.class) {
                if (f45805b == null) {
                    f45805b = new d.a.m0.a.k2.g.g("swan_about_page_sp", true);
                }
            }
        }
        return f45805b;
    }

    public static String b() {
        String D;
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q == null) {
            D = d.a.m0.a.v.a.a(d.a.m0.a.a2.d.g().getAppId());
        } else {
            D = Q.D();
        }
        return "pref_tool_" + D;
    }

    public static boolean c() {
        if (f45804a == -1) {
            f45804a = a().getInt(b(), 0);
        }
        return f45804a == 1;
    }
}
