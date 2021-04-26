package d.a.p0.e.g;

import android.content.Context;
import android.util.Log;
import d.a.p0.e.f.d;
/* loaded from: classes5.dex */
public class c extends d {

    /* renamed from: h  reason: collision with root package name */
    public static String f63513h = "XMUnionID";

    /* renamed from: i  reason: collision with root package name */
    public static boolean f63514i = d.a.p0.e.a.e();

    public c(Context context) {
        super(context);
        if (f63514i) {
            Log.e(f63513h, "xiaomi XMUnionID !!");
        }
        this.f63506d = "";
        this.f63504b = false;
        this.f63505c = false;
        this.f63509g = -200;
    }

    @Override // d.a.p0.e.f.c
    public d.a.p0.e.f.c d() {
        try {
            this.f63505c = d.k.b.a.b();
            this.f63506d = d.k.b.a.a(this.f63503a);
            this.f63509g = 0;
        } catch (Exception e2) {
            if (f63514i) {
                Log.e(f63513h, "xiaomi init4UnionId error", e2);
            }
        }
        return this;
    }
}
