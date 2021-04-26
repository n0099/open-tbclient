package d.a.p0.e;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static String f63486b = "UnionIDFactory";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f63487c = a.e();

    /* renamed from: a  reason: collision with root package name */
    public d.a.p0.e.f.c f63488a;

    public d(Context context) {
        int a2 = b.a();
        if (f63487c) {
            String str = f63486b;
            Log.e(str, "UnionIDFactory manufacturer:" + a2);
        }
        if (a2 == 10001) {
            this.f63488a = new d.a.p0.e.g.a(context);
        } else if (a2 != 10002) {
            this.f63488a = new d.a.p0.e.g.b(context);
        } else {
            if (f63487c) {
                Log.e(f63486b, "UnionIDFactory XMUnionID");
            }
            this.f63488a = new d.a.p0.e.g.c(context);
        }
    }

    public d.a.p0.e.f.c a() {
        return this.f63488a;
    }
}
