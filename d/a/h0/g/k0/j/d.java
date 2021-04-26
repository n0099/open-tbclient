package d.a.h0.g.k0.j;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.a.z1.h;
import d.a.h0.g.k0.j.a;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46535a = k.f43101a;

    public static void a(@NonNull e eVar, @NonNull a.e eVar2) {
        long k = eVar.J().k("launch_time", 0L);
        if (k <= 0) {
            if (f46535a) {
                Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                return;
            }
            return;
        }
        d.a.h0.a.z1.k.e eVar3 = new d.a.h0.a.z1.k.e();
        eVar3.f45411a = h.n(eVar.J().F());
        eVar3.f45415e = eVar.getAppId();
        eVar3.f45413c = eVar.J().S();
        eVar3.f45412b = "startup";
        eVar3.f45416f = eVar2.f46531a;
        eVar3.f45414d = eVar2.f46532b;
        eVar3.a("na_start", Long.valueOf(k));
        eVar3.a("h5_start", Long.valueOf(eVar2.f46533c));
        eVar3.a("h5_finish", Long.valueOf(eVar2.f46534d));
        h.u("1235", eVar3);
    }
}
