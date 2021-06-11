package d.a.l0.h.o0.h;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import d.a.l0.h.o0.h.a;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51320a = k.f46875a;

    public static void a(@NonNull e eVar, @NonNull a.e eVar2) {
        long l = eVar.L().l("launch_time", 0L);
        if (l <= 0) {
            if (f51320a) {
                Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                return;
            }
            return;
        }
        d.a.l0.a.j2.p.e eVar3 = new d.a.l0.a.j2.p.e();
        eVar3.f46861a = d.a.l0.a.j2.k.m(eVar.L().G());
        eVar3.f46866f = eVar.getAppId();
        eVar3.f46863c = eVar.L().T();
        eVar3.f46862b = "startup";
        eVar3.f46867g = eVar2.f51316a;
        eVar3.f46865e = eVar2.f51317b;
        eVar3.a("na_start", Long.valueOf(l));
        eVar3.a("h5_start", Long.valueOf(eVar2.f51318c));
        eVar3.a("h5_finish", Long.valueOf(eVar2.f51319d));
        d.a.l0.a.j2.k.u("1235", eVar3);
    }
}
