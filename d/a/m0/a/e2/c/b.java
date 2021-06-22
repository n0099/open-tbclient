package d.a.m0.a.e2.c;

import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f45457a;

    static {
        boolean z = k.f46983a;
        f45457a = -1;
    }

    public static int a() {
        if (f45457a < 0) {
            d.a.m0.a.c1.a.Z().getSwitch("swan_app_request_opendata_retry", 0);
            f45457a = 0;
        }
        return f45457a;
    }

    public static boolean b() {
        return a() > 0;
    }
}
