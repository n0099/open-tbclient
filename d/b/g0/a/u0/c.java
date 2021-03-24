package d.b.g0.a.u0;

import android.os.Bundle;
import d.b.g0.a.k;
import d.b.g0.a.u0.f;
import d.b.g0.a.y0.g.b;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes3.dex */
public class c extends f.AbstractC0849f {
    public static final boolean j = k.f45050a;

    /* renamed from: h  reason: collision with root package name */
    public final String f46592h;
    public final d.b.g0.l.h.d i;

    public c(String str, d.b.g0.l.h.d dVar) {
        super("check_sign");
        this.f46592h = str;
        this.i = dVar;
    }

    @Override // d.b.g0.a.u0.f.AbstractC0849f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        d.b.g0.a.f2.a aVar;
        d.b.g0.a.y0.g.a d2 = d.b.g0.a.y0.g.a.d(bundle.getString("launch_id"));
        b.C0885b e2 = d2.e();
        e2.b("SignChecker");
        e2.d(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                aVar = d.b.g0.a.e0.p.r.a.a(sourceChannel, this.f46592h, this.i);
            } catch (IOException e3) {
                if (j) {
                    e3.printStackTrace();
                }
                d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
                aVar2.j(11L);
                aVar2.h(2300L);
                aVar2.e("inputStream IOException:" + e3.toString());
                d.b.g0.a.f2.e.a().f(aVar2);
                d2.g("SignChecker", aVar2.toString());
                d.b.g0.a.i2.s0.b.a(sourceChannel);
                aVar = aVar2;
            }
            d2.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
            boolean z = aVar == null;
            if (aVar != null) {
                d2.g("SignChecker", aVar.toString());
                b().putLong("result_error_code", aVar.a());
            }
            d2.g("SignChecker", "done: " + z);
            return z;
        } finally {
            d.b.g0.a.i2.s0.b.a(sourceChannel);
        }
    }
}
