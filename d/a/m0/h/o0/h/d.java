package d.a.m0.h.o0.h;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.m0.a.a2.e;
import d.a.m0.a.k;
import d.a.m0.h.o0.h.a;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51428a = k.f46983a;

    public static void a(@NonNull e eVar, @NonNull a.e eVar2) {
        long l = eVar.L().l("launch_time", 0L);
        if (l <= 0) {
            if (f51428a) {
                Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                return;
            }
            return;
        }
        d.a.m0.a.j2.p.e eVar3 = new d.a.m0.a.j2.p.e();
        eVar3.f46969a = d.a.m0.a.j2.k.m(eVar.L().G());
        eVar3.f46974f = eVar.getAppId();
        eVar3.f46971c = eVar.L().T();
        eVar3.f46970b = "startup";
        eVar3.f46975g = eVar2.f51424a;
        eVar3.f46973e = eVar2.f51425b;
        eVar3.a("na_start", Long.valueOf(l));
        eVar3.a("h5_start", Long.valueOf(eVar2.f51426c));
        eVar3.a("h5_finish", Long.valueOf(eVar2.f51427d));
        d.a.m0.a.j2.k.u("1235", eVar3);
    }
}
