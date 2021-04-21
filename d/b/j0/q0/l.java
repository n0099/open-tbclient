package d.b.j0.q0;

import d.b.i0.r.q.a2;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static String f59894a;

    /* renamed from: b  reason: collision with root package name */
    public static a2 f59895b;

    public static a2 a() {
        return f59895b;
    }

    public static String b() {
        return f59894a;
    }

    public static synchronized void c(a2 a2Var) {
        synchronized (l.class) {
            f59894a = a2Var.A;
            f59895b = a2Var;
        }
    }
}
