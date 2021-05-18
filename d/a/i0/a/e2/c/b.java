package d.a.i0.a.e2.c;

import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f41499a;

    static {
        boolean z = k.f43025a;
        f41499a = -1;
    }

    public static int a() {
        if (f41499a < 0) {
            d.a.i0.a.c1.a.Z().getSwitch("swan_app_request_opendata_retry", 0);
            f41499a = 0;
        }
        return f41499a;
    }

    public static boolean b() {
        return a() > 0;
    }
}
