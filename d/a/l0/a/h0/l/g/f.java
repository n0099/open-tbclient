package d.a.l0.a.h0.l.g;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45932a = d.a.l0.a.k.f46875a;

    public static boolean a(d.a.l0.a.h0.f.a aVar, String str) {
        d.a.l0.a.a2.e Q;
        a a2;
        boolean z = false;
        if (d.a.l0.a.u1.a.a.C()) {
            return false;
        }
        if (aVar != null && !TextUtils.isEmpty(aVar.getContainerId())) {
            if (d.a.l0.a.h0.l.g.n.a.i().k(aVar.getContainerId())) {
                return true;
            }
            if (!d.a.l0.a.h0.o.e.a.f()) {
                return false;
            }
            String containerId = aVar.getContainerId();
            if (!e.a(containerId) || (Q = d.a.l0.a.a2.e.Q()) == null || !b(aVar) || (a2 = h.b().a()) == null) {
                return false;
            }
            z = (TextUtils.equals(a2.i().b(), aVar.getContainerId()) && TextUtils.equals(a2.h(), Q.f44425f)) ? true : true;
            if (f45932a && z) {
                Log.w("MasterIsolationHelper", "master id - " + containerId + ",can not call API - " + str + ", intercept for preload/prefetch");
            }
        }
        return z;
    }

    public static boolean b(d.a.l0.a.h0.f.a aVar) {
        return (aVar instanceof d.a.l0.a.l0.a) && ((d.a.l0.a.l0.a) aVar).getInvokeSourceType() == 0;
    }
}
