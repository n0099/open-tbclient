package d.a.l0.a.j2;

import android.util.Log;
import d.a.l0.a.v2.q;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46799a = d.a.l0.a.k.f46875a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.e f46800e;

        public a(d.a.l0.a.j2.p.e eVar) {
            this.f46800e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.k("1719", this.f46800e.f());
        }
    }

    public static void onEvent(d.a.l0.a.j2.p.e eVar) {
        if (eVar == null) {
            if (f46799a) {
                Log.w("SwanAppPermissionDialogUbc", "event is null");
                return;
            }
            return;
        }
        q.i(new a(eVar), "SwanAppPermissionDialogUbc");
    }
}
