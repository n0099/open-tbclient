package d.a.o0.r0;

import d.a.n0.r.q.a2;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static String f62665a;

    /* renamed from: b  reason: collision with root package name */
    public static a2 f62666b;

    public static a2 a() {
        return f62666b;
    }

    public static String b() {
        return f62665a;
    }

    public static synchronized void c(a2 a2Var) {
        synchronized (l.class) {
            f62665a = a2Var.A;
            f62666b = a2Var;
        }
    }
}
