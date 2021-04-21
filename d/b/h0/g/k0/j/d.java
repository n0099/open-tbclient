package d.b.h0.g.k0.j;

import android.util.Log;
import androidx.annotation.NonNull;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.a.z1.h;
import d.b.h0.g.k0.j.a;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49058a = k.f45772a;

    public static void a(@NonNull e eVar, @NonNull a.e eVar2) {
        long k = eVar.J().k("launch_time", 0L);
        if (k <= 0) {
            if (f49058a) {
                Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                return;
            }
            return;
        }
        d.b.h0.a.z1.k.e eVar3 = new d.b.h0.a.z1.k.e();
        eVar3.f47972a = h.n(eVar.J().F());
        eVar3.f47976e = eVar.getAppId();
        eVar3.f47974c = eVar.J().S();
        eVar3.f47973b = "startup";
        eVar3.f47977f = eVar2.f49054a;
        eVar3.f47975d = eVar2.f49055b;
        eVar3.a("na_start", Long.valueOf(k));
        eVar3.a("h5_start", Long.valueOf(eVar2.f49056c));
        eVar3.a("h5_finish", Long.valueOf(eVar2.f49057d));
        h.u("1235", eVar3);
    }
}
