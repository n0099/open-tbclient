package d.a.n0.r0;

import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static String f62540a;

    /* renamed from: b  reason: collision with root package name */
    public static a2 f62541b;

    public static a2 a() {
        return f62541b;
    }

    public static String b() {
        return f62540a;
    }

    public static synchronized void c(a2 a2Var) {
        synchronized (l.class) {
            f62540a = a2Var.A;
            f62541b = a2Var;
        }
    }
}
