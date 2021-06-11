package d.a.l0.a.a1;

import android.os.Bundle;
import d.a.l0.a.a1.g;
import d.a.l0.a.f1.g.b;
import d.a.l0.a.k;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes3.dex */
public class d extends g.f {
    public static final boolean j = k.f46875a;

    /* renamed from: h  reason: collision with root package name */
    public final String f44359h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.l0.n.f.d f44360i;

    public d(String str, d.a.l0.n.f.d dVar) {
        super("check_sign");
        this.f44359h = str;
        this.f44360i = dVar;
    }

    @Override // d.a.l0.a.a1.g.f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        d.a.l0.a.q2.a aVar;
        d.a.l0.a.f1.g.a d2 = d.a.l0.a.f1.g.a.d(bundle.getString("launch_id"));
        b.C0691b e2 = d2.e();
        e2.b("SignChecker");
        e2.d(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                aVar = d.a.l0.a.h0.m.r.a.a(sourceChannel, this.f44359h, this.f44360i);
            } catch (IOException e3) {
                if (j) {
                    e3.printStackTrace();
                }
                d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
                aVar2.j(11L);
                aVar2.h(2300L);
                aVar2.e("inputStream IOException:" + e3.toString());
                d.a.l0.a.q2.e.a().f(aVar2);
                d2.g("SignChecker", aVar2.toString());
                d.a.l0.a.v2.c1.b.a(sourceChannel);
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
            d.a.l0.a.v2.c1.b.a(sourceChannel);
        }
    }
}
