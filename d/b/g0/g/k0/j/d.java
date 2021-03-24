package d.b.g0.g.k0.j;

import android.util.Log;
import androidx.annotation.NonNull;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import d.b.g0.a.z1.h;
import d.b.g0.g.k0.j.a;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48336a = k.f45050a;

    public static void a(@NonNull e eVar, @NonNull a.e eVar2) {
        long k = eVar.J().k("launch_time", 0L);
        if (k <= 0) {
            if (f48336a) {
                Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                return;
            }
            return;
        }
        d.b.g0.a.z1.k.e eVar3 = new d.b.g0.a.z1.k.e();
        eVar3.f47250a = h.n(eVar.J().F());
        eVar3.f47254e = eVar.getAppId();
        eVar3.f47252c = eVar.J().S();
        eVar3.f47251b = "startup";
        eVar3.f47255f = eVar2.f48332a;
        eVar3.f47253d = eVar2.f48333b;
        eVar3.a("na_start", Long.valueOf(k));
        eVar3.a("h5_start", Long.valueOf(eVar2.f48334c));
        eVar3.a("h5_finish", Long.valueOf(eVar2.f48335d));
        h.u("1235", eVar3);
    }
}
