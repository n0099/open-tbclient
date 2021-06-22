package d.a.m0.a.j2;

import android.util.Log;
import d.a.m0.a.v2.q;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46907a = d.a.m0.a.k.f46983a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.e f46908e;

        public a(d.a.m0.a.j2.p.e eVar) {
            this.f46908e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.k("1719", this.f46908e.f());
        }
    }

    public static void onEvent(d.a.m0.a.j2.p.e eVar) {
        if (eVar == null) {
            if (f46907a) {
                Log.w("SwanAppPermissionDialogUbc", "event is null");
                return;
            }
            return;
        }
        q.i(new a(eVar), "SwanAppPermissionDialogUbc");
    }
}
