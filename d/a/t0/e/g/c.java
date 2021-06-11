package d.a.t0.e.g;

import android.content.Context;
import android.util.Log;
import d.a.t0.e.f.d;
/* loaded from: classes5.dex */
public class c extends d {

    /* renamed from: h  reason: collision with root package name */
    public static String f68407h = "XMUnionID";

    /* renamed from: i  reason: collision with root package name */
    public static boolean f68408i = d.a.t0.e.a.e();

    public c(Context context) {
        super(context);
        if (f68408i) {
            Log.e(f68407h, "xiaomi XMUnionID !!");
        }
        this.f68400d = "";
        this.f68398b = false;
        this.f68399c = false;
        this.f68403g = -200;
    }

    @Override // d.a.t0.e.f.c
    public d.a.t0.e.f.c d() {
        try {
            this.f68399c = d.k.b.a.b();
            this.f68400d = d.k.b.a.a(this.f68397a);
            this.f68403g = 0;
        } catch (Exception e2) {
            if (f68408i) {
                Log.e(f68407h, "xiaomi init4UnionId error", e2);
            }
        }
        return this;
    }
}
