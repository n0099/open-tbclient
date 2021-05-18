package d.a.q0.e.g;

import android.content.Context;
import android.util.Log;
import d.a.q0.e.f.d;
/* loaded from: classes5.dex */
public class c extends d {

    /* renamed from: h  reason: collision with root package name */
    public static String f64510h = "XMUnionID";

    /* renamed from: i  reason: collision with root package name */
    public static boolean f64511i = d.a.q0.e.a.e();

    public c(Context context) {
        super(context);
        if (f64511i) {
            Log.e(f64510h, "xiaomi XMUnionID !!");
        }
        this.f64503d = "";
        this.f64501b = false;
        this.f64502c = false;
        this.f64506g = -200;
    }

    @Override // d.a.q0.e.f.c
    public d.a.q0.e.f.c d() {
        try {
            this.f64502c = d.k.b.a.b();
            this.f64503d = d.k.b.a.a(this.f64500a);
            this.f64506g = 0;
        } catch (Exception e2) {
            if (f64511i) {
                Log.e(f64510h, "xiaomi init4UnionId error", e2);
            }
        }
        return this;
    }
}
