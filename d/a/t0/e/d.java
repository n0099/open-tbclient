package d.a.t0.e;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static String f68380b = "UnionIDFactory";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f68381c = a.e();

    /* renamed from: a  reason: collision with root package name */
    public d.a.t0.e.f.c f68382a;

    public d(Context context) {
        int a2 = b.a();
        if (f68381c) {
            String str = f68380b;
            Log.e(str, "UnionIDFactory manufacturer:" + a2);
        }
        if (a2 == 10001) {
            this.f68382a = new d.a.t0.e.g.a(context);
        } else if (a2 != 10002) {
            this.f68382a = new d.a.t0.e.g.b(context);
        } else {
            if (f68381c) {
                Log.e(f68380b, "UnionIDFactory XMUnionID");
            }
            this.f68382a = new d.a.t0.e.g.c(context);
        }
    }

    public d.a.t0.e.f.c a() {
        return this.f68382a;
    }
}
