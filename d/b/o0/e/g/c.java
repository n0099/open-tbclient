package d.b.o0.e.g;

import android.content.Context;
import android.util.Log;
import d.b.o0.e.f.d;
/* loaded from: classes5.dex */
public class c extends d {

    /* renamed from: h  reason: collision with root package name */
    public static String f64221h = "XMUnionID";
    public static boolean i = d.b.o0.e.a.e();

    public c(Context context) {
        super(context);
        if (i) {
            Log.e(f64221h, "xiaomi XMUnionID !!");
        }
        this.f64214d = "";
        this.f64212b = false;
        this.f64213c = false;
        this.f64217g = -200;
    }

    @Override // d.b.o0.e.f.c
    public d.b.o0.e.f.c d() {
        try {
            this.f64213c = d.k.b.a.b();
            this.f64214d = d.k.b.a.a(this.f64211a);
            this.f64217g = 0;
        } catch (Exception e2) {
            if (i) {
                Log.e(f64221h, "xiaomi init4UnionId error", e2);
            }
        }
        return this;
    }
}
