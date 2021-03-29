package d.b.i0.p0;

import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static String f57774a;

    /* renamed from: b  reason: collision with root package name */
    public static a2 f57775b;

    public static a2 a() {
        return f57775b;
    }

    public static String b() {
        return f57774a;
    }

    public static synchronized void c(a2 a2Var) {
        synchronized (l.class) {
            f57774a = a2Var.A;
            f57775b = a2Var;
        }
    }
}
