package d.a.i0.h.o0.h;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.i0.a.a2.e;
import d.a.i0.a.k;
import d.a.i0.h.o0.h.a;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47470a = k.f43025a;

    public static void a(@NonNull e eVar, @NonNull a.e eVar2) {
        long l = eVar.L().l("launch_time", 0L);
        if (l <= 0) {
            if (f47470a) {
                Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                return;
            }
            return;
        }
        d.a.i0.a.j2.p.e eVar3 = new d.a.i0.a.j2.p.e();
        eVar3.f43011a = d.a.i0.a.j2.k.m(eVar.L().G());
        eVar3.f43016f = eVar.getAppId();
        eVar3.f43013c = eVar.L().T();
        eVar3.f43012b = "startup";
        eVar3.f43017g = eVar2.f47466a;
        eVar3.f43015e = eVar2.f47467b;
        eVar3.a("na_start", Long.valueOf(l));
        eVar3.a("h5_start", Long.valueOf(eVar2.f47468c));
        eVar3.a("h5_finish", Long.valueOf(eVar2.f47469d));
        d.a.i0.a.j2.k.u("1235", eVar3);
    }
}
