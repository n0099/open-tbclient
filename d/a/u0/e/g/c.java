package d.a.u0.e.g;

import android.content.Context;
import android.util.Log;
import d.a.u0.e.f.d;
/* loaded from: classes5.dex */
public class c extends d {

    /* renamed from: h  reason: collision with root package name */
    public static String f68511h = "XMUnionID";

    /* renamed from: i  reason: collision with root package name */
    public static boolean f68512i = d.a.u0.e.a.e();

    public c(Context context) {
        super(context);
        if (f68512i) {
            Log.e(f68511h, "xiaomi XMUnionID !!");
        }
        this.f68504d = "";
        this.f68502b = false;
        this.f68503c = false;
        this.f68507g = -200;
    }

    @Override // d.a.u0.e.f.c
    public d.a.u0.e.f.c d() {
        try {
            this.f68503c = d.k.b.a.b();
            this.f68504d = d.k.b.a.a(this.f68501a);
            this.f68507g = 0;
        } catch (Exception e2) {
            if (f68512i) {
                Log.e(f68511h, "xiaomi init4UnionId error", e2);
            }
        }
        return this;
    }
}
