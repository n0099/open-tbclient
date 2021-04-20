package d.b.i0.q0;

import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static String f59473a;

    /* renamed from: b  reason: collision with root package name */
    public static a2 f59474b;

    public static a2 a() {
        return f59474b;
    }

    public static String b() {
        return f59473a;
    }

    public static synchronized void c(a2 a2Var) {
        synchronized (l.class) {
            f59473a = a2Var.A;
            f59474b = a2Var;
        }
    }
}
