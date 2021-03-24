package d.b.i0.p0;

import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static String f57773a;

    /* renamed from: b  reason: collision with root package name */
    public static a2 f57774b;

    public static a2 a() {
        return f57774b;
    }

    public static String b() {
        return f57773a;
    }

    public static synchronized void c(a2 a2Var) {
        synchronized (l.class) {
            f57773a = a2Var.A;
            f57774b = a2Var;
        }
    }
}
