package d.a.l0.a.e2.c;

import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f45349a;

    static {
        boolean z = k.f46875a;
        f45349a = -1;
    }

    public static int a() {
        if (f45349a < 0) {
            d.a.l0.a.c1.a.Z().getSwitch("swan_app_request_opendata_retry", 0);
            f45349a = 0;
        }
        return f45349a;
    }

    public static boolean b() {
        return a() > 0;
    }
}
