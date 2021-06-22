package d.a.u0.e;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static String f68484b = "UnionIDFactory";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f68485c = a.e();

    /* renamed from: a  reason: collision with root package name */
    public d.a.u0.e.f.c f68486a;

    public d(Context context) {
        int a2 = b.a();
        if (f68485c) {
            String str = f68484b;
            Log.e(str, "UnionIDFactory manufacturer:" + a2);
        }
        if (a2 == 10001) {
            this.f68486a = new d.a.u0.e.g.a(context);
        } else if (a2 != 10002) {
            this.f68486a = new d.a.u0.e.g.b(context);
        } else {
            if (f68485c) {
                Log.e(f68484b, "UnionIDFactory XMUnionID");
            }
            this.f68486a = new d.a.u0.e.g.c(context);
        }
    }

    public d.a.u0.e.f.c a() {
        return this.f68486a;
    }
}
