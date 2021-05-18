package d.a.i0.a.j2;

import android.util.Log;
import d.a.i0.a.v2.q;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42949a = d.a.i0.a.k.f43025a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.j2.p.e f42950e;

        public a(d.a.i0.a.j2.p.e eVar) {
            this.f42950e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.k("1719", this.f42950e.f());
        }
    }

    public static void onEvent(d.a.i0.a.j2.p.e eVar) {
        if (eVar == null) {
            if (f42949a) {
                Log.w("SwanAppPermissionDialogUbc", "event is null");
                return;
            }
            return;
        }
        q.i(new a(eVar), "SwanAppPermissionDialogUbc");
    }
}
