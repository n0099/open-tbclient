package d.b.b;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a2 extends v1 {

    /* renamed from: g  reason: collision with root package name */
    public static final long[] f64932g = {60000};

    /* renamed from: d  reason: collision with root package name */
    public final a0 f64933d;

    /* renamed from: e  reason: collision with root package name */
    public final j f64934e;

    /* renamed from: f  reason: collision with root package name */
    public long f64935f;

    public a2(Context context, j jVar, a0 a0Var) {
        super(context);
        this.f64933d = a0Var;
        this.f64934e = jVar;
    }

    @Override // d.b.b.v1
    public boolean a() {
        return false;
    }

    @Override // d.b.b.v1
    public long b() {
        return this.f64935f + 60000;
    }

    @Override // d.b.b.v1
    public long[] c() {
        return f64932g;
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
        if (this.f64934e.v() != 0) {
            JSONObject i3 = this.f64934e.i();
            if (i3 != null) {
                boolean m = this.f64933d.m(i3);
                this.f64935f = System.currentTimeMillis();
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
