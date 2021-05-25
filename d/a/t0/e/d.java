package d.a.t0.e;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static String f64662b = "UnionIDFactory";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f64663c = a.e();

    /* renamed from: a  reason: collision with root package name */
    public d.a.t0.e.f.c f64664a;

    public d(Context context) {
        int a2 = b.a();
        if (f64663c) {
            String str = f64662b;
            Log.e(str, "UnionIDFactory manufacturer:" + a2);
        }
        if (a2 == 10001) {
            this.f64664a = new d.a.t0.e.g.a(context);
        } else if (a2 != 10002) {
            this.f64664a = new d.a.t0.e.g.b(context);
        } else {
            if (f64663c) {
                Log.e(f64662b, "UnionIDFactory XMUnionID");
            }
            this.f64664a = new d.a.t0.e.g.c(context);
        }
    }

    public d.a.t0.e.f.c a() {
        return this.f64664a;
    }
}
