package d.a.i0.a.a1;

import android.os.Bundle;
import d.a.i0.a.a1.g;
import d.a.i0.a.f1.g.b;
import d.a.i0.a.k;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes3.dex */
public class d extends g.f {
    public static final boolean j = k.f43025a;

    /* renamed from: h  reason: collision with root package name */
    public final String f40509h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.i0.n.f.d f40510i;

    public d(String str, d.a.i0.n.f.d dVar) {
        super("check_sign");
        this.f40509h = str;
        this.f40510i = dVar;
    }

    @Override // d.a.i0.a.a1.g.f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        d.a.i0.a.q2.a aVar;
        d.a.i0.a.f1.g.a d2 = d.a.i0.a.f1.g.a.d(bundle.getString("launch_id"));
        b.C0624b e2 = d2.e();
        e2.b("SignChecker");
        e2.d(1);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                aVar = d.a.i0.a.h0.m.r.a.a(sourceChannel, this.f40509h, this.f40510i);
            } catch (IOException e3) {
                if (j) {
                    e3.printStackTrace();
                }
                d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
                aVar2.j(11L);
                aVar2.h(2300L);
                aVar2.e("inputStream IOException:" + e3.toString());
                d.a.i0.a.q2.e.a().f(aVar2);
                d2.g("SignChecker", aVar2.toString());
                d.a.i0.a.v2.c1.b.a(sourceChannel);
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
            d.a.i0.a.v2.c1.b.a(sourceChannel);
        }
    }
}
