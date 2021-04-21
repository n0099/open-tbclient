package d.b.p0.e.g;

import android.content.Context;
import android.util.Log;
import d.b.p0.e.f.d;
/* loaded from: classes5.dex */
public class c extends d {

    /* renamed from: h  reason: collision with root package name */
    public static String f65199h = "XMUnionID";
    public static boolean i = d.b.p0.e.a.e();

    public c(Context context) {
        super(context);
        if (i) {
            Log.e(f65199h, "xiaomi XMUnionID !!");
        }
        this.f65192d = "";
        this.f65190b = false;
        this.f65191c = false;
        this.f65195g = -200;
    }

    @Override // d.b.p0.e.f.c
    public d.b.p0.e.f.c d() {
        try {
            this.f65191c = d.l.b.a.b();
            this.f65192d = d.l.b.a.a(this.f65189a);
            this.f65195g = 0;
        } catch (Exception e2) {
            if (i) {
                Log.e(f65199h, "xiaomi init4UnionId error", e2);
            }
        }
        return this;
    }
}
