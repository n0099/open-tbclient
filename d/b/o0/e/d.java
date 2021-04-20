package d.b.o0.e;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static String f64908b = "UnionIDFactory";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f64909c = a.e();

    /* renamed from: a  reason: collision with root package name */
    public d.b.o0.e.f.c f64910a;

    public d(Context context) {
        int a2 = b.a();
        if (f64909c) {
            String str = f64908b;
            Log.e(str, "UnionIDFactory manufacturer:" + a2);
        }
        if (a2 == 10001) {
            this.f64910a = new d.b.o0.e.g.a(context);
        } else if (a2 != 10002) {
            this.f64910a = new d.b.o0.e.g.b(context);
        } else {
            if (f64909c) {
                Log.e(f64908b, "UnionIDFactory XMUnionID");
            }
            this.f64910a = new d.b.o0.e.g.c(context);
        }
    }

    public d.b.o0.e.f.c a() {
        return this.f64910a;
    }
}
