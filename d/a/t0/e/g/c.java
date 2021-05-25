package d.a.t0.e.g;

import android.content.Context;
import android.util.Log;
import d.a.t0.e.f.d;
/* loaded from: classes5.dex */
public class c extends d {

    /* renamed from: h  reason: collision with root package name */
    public static String f64689h = "XMUnionID";

    /* renamed from: i  reason: collision with root package name */
    public static boolean f64690i = d.a.t0.e.a.e();

    public c(Context context) {
        super(context);
        if (f64690i) {
            Log.e(f64689h, "xiaomi XMUnionID !!");
        }
        this.f64682d = "";
        this.f64680b = false;
        this.f64681c = false;
        this.f64685g = -200;
    }

    @Override // d.a.t0.e.f.c
    public d.a.t0.e.f.c d() {
        try {
            this.f64681c = d.k.b.a.b();
            this.f64682d = d.k.b.a.a(this.f64679a);
            this.f64685g = 0;
        } catch (Exception e2) {
            if (f64690i) {
                Log.e(f64689h, "xiaomi init4UnionId error", e2);
            }
        }
        return this;
    }
}
