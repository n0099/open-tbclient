package d.a.h0.a.u0;

import android.os.Bundle;
import d.a.h0.a.k;
import d.a.h0.a.u0.f;
import d.a.h0.a.y0.g.b;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes2.dex */
public class c extends f.AbstractC0821f {
    public static final boolean j = k.f43101a;

    /* renamed from: h  reason: collision with root package name */
    public final String f44724h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.h0.l.h.d f44725i;

    public c(String str, d.a.h0.l.h.d dVar) {
        super("check_sign");
        this.f44724h = str;
        this.f44725i = dVar;
    }

    @Override // d.a.h0.a.u0.f.AbstractC0821f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        d.a.h0.a.f2.a aVar;
        d.a.h0.a.y0.g.a d2 = d.a.h0.a.y0.g.a.d(bundle.getString("launch_id"));
        b.C0857b e2 = d2.e();
        e2.b("SignChecker");
        e2.d(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                aVar = d.a.h0.a.e0.p.r.a.a(sourceChannel, this.f44724h, this.f44725i);
            } catch (IOException e3) {
                if (j) {
                    e3.printStackTrace();
                }
                d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
                aVar2.j(11L);
                aVar2.h(2300L);
                aVar2.e("inputStream IOException:" + e3.toString());
                d.a.h0.a.f2.e.a().f(aVar2);
                d2.g("SignChecker", aVar2.toString());
                d.a.h0.a.i2.s0.b.a(sourceChannel);
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
            d.a.h0.a.i2.s0.b.a(sourceChannel);
        }
    }
}
