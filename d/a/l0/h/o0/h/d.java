package d.a.l0.h.o0.h;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import d.a.l0.h.o0.h.a;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47646a = k.f43199a;

    public static void a(@NonNull e eVar, @NonNull a.e eVar2) {
        long l = eVar.L().l("launch_time", 0L);
        if (l <= 0) {
            if (f47646a) {
                Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                return;
            }
            return;
        }
        d.a.l0.a.j2.p.e eVar3 = new d.a.l0.a.j2.p.e();
        eVar3.f43185a = d.a.l0.a.j2.k.m(eVar.L().G());
        eVar3.f43190f = eVar.getAppId();
        eVar3.f43187c = eVar.L().T();
        eVar3.f43186b = "startup";
        eVar3.f43191g = eVar2.f47642a;
        eVar3.f43189e = eVar2.f47643b;
        eVar3.a("na_start", Long.valueOf(l));
        eVar3.a("h5_start", Long.valueOf(eVar2.f47644c));
        eVar3.a("h5_finish", Long.valueOf(eVar2.f47645d));
        d.a.l0.a.j2.k.u("1235", eVar3);
    }
}
