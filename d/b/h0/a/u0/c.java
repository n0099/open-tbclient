package d.b.h0.a.u0;

import android.os.Bundle;
import d.b.h0.a.k;
import d.b.h0.a.u0.f;
import d.b.h0.a.y0.g.b;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes2.dex */
public class c extends f.AbstractC0882f {
    public static final boolean j = k.f45772a;

    /* renamed from: h  reason: collision with root package name */
    public final String f47314h;
    public final d.b.h0.l.h.d i;

    public c(String str, d.b.h0.l.h.d dVar) {
        super("check_sign");
        this.f47314h = str;
        this.i = dVar;
    }

    @Override // d.b.h0.a.u0.f.AbstractC0882f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        d.b.h0.a.f2.a aVar;
        d.b.h0.a.y0.g.a d2 = d.b.h0.a.y0.g.a.d(bundle.getString("launch_id"));
        b.C0918b e2 = d2.e();
        e2.b("SignChecker");
        e2.d(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                aVar = d.b.h0.a.e0.p.r.a.a(sourceChannel, this.f47314h, this.i);
            } catch (IOException e3) {
                if (j) {
                    e3.printStackTrace();
                }
                d.b.h0.a.f2.a aVar2 = new d.b.h0.a.f2.a();
                aVar2.j(11L);
                aVar2.h(2300L);
                aVar2.e("inputStream IOException:" + e3.toString());
                d.b.h0.a.f2.e.a().f(aVar2);
                d2.g("SignChecker", aVar2.toString());
                d.b.h0.a.i2.s0.b.a(sourceChannel);
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
            d.b.h0.a.i2.s0.b.a(sourceChannel);
        }
    }
}
