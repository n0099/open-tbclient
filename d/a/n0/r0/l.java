package d.a.n0.r0;

import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static String f58849a;

    /* renamed from: b  reason: collision with root package name */
    public static a2 f58850b;

    public static a2 a() {
        return f58850b;
    }

    public static String b() {
        return f58849a;
    }

    public static synchronized void c(a2 a2Var) {
        synchronized (l.class) {
            f58849a = a2Var.A;
            f58850b = a2Var;
        }
    }
}
