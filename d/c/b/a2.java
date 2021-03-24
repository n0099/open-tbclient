package d.c.b;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a2 extends v1 {

    /* renamed from: g  reason: collision with root package name */
    public static final long[] f64950g = {60000};

    /* renamed from: d  reason: collision with root package name */
    public final a0 f64951d;

    /* renamed from: e  reason: collision with root package name */
    public final j f64952e;

    /* renamed from: f  reason: collision with root package name */
    public long f64953f;

    public a2(Context context, j jVar, a0 a0Var) {
        super(context);
        this.f64951d = a0Var;
        this.f64952e = jVar;
    }

    @Override // d.c.b.v1
    public boolean a() {
        return false;
    }

    @Override // d.c.b.v1
    public long b() {
        return this.f64953f + 60000;
    }

    @Override // d.c.b.v1
    public long[] c() {
        return f64950g;
    }

    @Override // d.c.b.v1
    public boolean d() {
        Bundle b2;
        long currentTimeMillis = System.currentTimeMillis();
        e2 i = x1.i();
        if (i != null && (b2 = i.b(currentTimeMillis, 50000L)) != null) {
            a.q("play_session", b2);
            a.a();
        }
        if (this.f64952e.v() != 0) {
            JSONObject i2 = this.f64952e.i();
            if (i2 != null) {
                boolean m = this.f64951d.m(i2);
                this.f64953f = System.currentTimeMillis();
                return m;
            }
            r0.b(null);
            return false;
        }
        return false;
    }

    @Override // d.c.b.v1
    public String e() {
        return "p";
    }
}
