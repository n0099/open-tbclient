package d.b.b;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a2 extends v1 {

    /* renamed from: g  reason: collision with root package name */
    public static final long[] f64975g = {60000};

    /* renamed from: d  reason: collision with root package name */
    public final a0 f64976d;

    /* renamed from: e  reason: collision with root package name */
    public final j f64977e;

    /* renamed from: f  reason: collision with root package name */
    public long f64978f;

    public a2(Context context, j jVar, a0 a0Var) {
        super(context);
        this.f64976d = a0Var;
        this.f64977e = jVar;
    }

    @Override // d.b.b.v1
    public boolean a() {
        return false;
    }

    @Override // d.b.b.v1
    public long b() {
        return this.f64978f + 60000;
    }

    @Override // d.b.b.v1
    public long[] c() {
        return f64975g;
    }

    @Override // d.b.b.v1
    public boolean d() {
        Bundle b2;
        long currentTimeMillis = System.currentTimeMillis();
        e2 i2 = x1.i();
        if (i2 != null && (b2 = i2.b(currentTimeMillis, 50000L)) != null) {
            a.q("play_session", b2);
            a.a();
        }
        if (this.f64977e.v() != 0) {
            JSONObject i3 = this.f64977e.i();
            if (i3 != null) {
                boolean m = this.f64976d.m(i3);
                this.f64978f = System.currentTimeMillis();
                return m;
            }
            r0.b(null);
            return false;
        }
        return false;
    }

    @Override // d.b.b.v1
    public String e() {
        return "p";
    }
}
