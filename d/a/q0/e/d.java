package d.a.q0.e;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static String f64483b = "UnionIDFactory";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f64484c = a.e();

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.e.f.c f64485a;

    public d(Context context) {
        int a2 = b.a();
        if (f64484c) {
            String str = f64483b;
            Log.e(str, "UnionIDFactory manufacturer:" + a2);
        }
        if (a2 == 10001) {
            this.f64485a = new d.a.q0.e.g.a(context);
        } else if (a2 != 10002) {
            this.f64485a = new d.a.q0.e.g.b(context);
        } else {
            if (f64484c) {
                Log.e(f64483b, "UnionIDFactory XMUnionID");
            }
            this.f64485a = new d.a.q0.e.g.c(context);
        }
    }

    public d.a.q0.e.f.c a() {
        return this.f64485a;
    }
}
