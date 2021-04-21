package d.b.p0.e;

import android.content.Context;
import android.util.Log;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static String f65172b = "UnionIDFactory";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f65173c = a.e();

    /* renamed from: a  reason: collision with root package name */
    public d.b.p0.e.f.c f65174a;

    public d(Context context) {
        int a2 = b.a();
        if (f65173c) {
            String str = f65172b;
            Log.e(str, "UnionIDFactory manufacturer:" + a2);
        }
        if (a2 == 10001) {
            this.f65174a = new d.b.p0.e.g.a(context);
        } else if (a2 != 10002) {
            this.f65174a = new d.b.p0.e.g.b(context);
        } else {
            if (f65173c) {
                Log.e(f65172b, "UnionIDFactory XMUnionID");
            }
            this.f65174a = new d.b.p0.e.g.c(context);
        }
    }

    public d.b.p0.e.f.c a() {
        return this.f65174a;
    }
}
