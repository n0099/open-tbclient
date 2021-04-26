package d.a.j0.q0;

import d.a.i0.r.q.a2;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static String f57966a;

    /* renamed from: b  reason: collision with root package name */
    public static a2 f57967b;

    public static a2 a() {
        return f57967b;
    }

    public static String b() {
        return f57966a;
    }

    public static synchronized void c(a2 a2Var) {
        synchronized (l.class) {
            f57966a = a2Var.A;
            f57967b = a2Var;
        }
    }
}
