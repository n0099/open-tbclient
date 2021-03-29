package d.b.o0.e.g;

import android.content.Context;
import android.util.Log;
import d.b.o0.e.f.d;
/* loaded from: classes5.dex */
public class c extends d {

    /* renamed from: h  reason: collision with root package name */
    public static String f64222h = "XMUnionID";
    public static boolean i = d.b.o0.e.a.e();

    public c(Context context) {
        super(context);
        if (i) {
            Log.e(f64222h, "xiaomi XMUnionID !!");
        }
        this.f64215d = "";
        this.f64213b = false;
        this.f64214c = false;
        this.f64218g = -200;
    }

    @Override // d.b.o0.e.f.c
    public d.b.o0.e.f.c d() {
        try {
            this.f64214c = d.k.b.a.b();
            this.f64215d = d.k.b.a.a(this.f64212a);
            this.f64218g = 0;
        } catch (Exception e2) {
            if (i) {
                Log.e(f64222h, "xiaomi init4UnionId error", e2);
            }
        }
        return this;
    }
}
