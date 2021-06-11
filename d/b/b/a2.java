package d.b.b;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a2 extends v1 {

    /* renamed from: g  reason: collision with root package name */
    public static final long[] f68706g = {60000};

    /* renamed from: d  reason: collision with root package name */
    public final a0 f68707d;

    /* renamed from: e  reason: collision with root package name */
    public final j f68708e;

    /* renamed from: f  reason: collision with root package name */
    public long f68709f;

    public a2(Context context, j jVar, a0 a0Var) {
        super(context);
        this.f68707d = a0Var;
        this.f68708e = jVar;
    }

    @Override // d.b.b.v1
    public boolean a() {
        return false;
    }

    @Override // d.b.b.v1
    public long b() {
        return this.f68709f + 60000;
    }

    @Override // d.b.b.v1
    public long[] c() {
        return f68706g;
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
        if (this.f68708e.v() != 0) {
            JSONObject i3 = this.f68708e.i();
            if (i3 != null) {
                boolean m = this.f68707d.m(i3);
                this.f68709f = System.currentTimeMillis();
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
