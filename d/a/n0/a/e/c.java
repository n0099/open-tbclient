package d.a.n0.a.e;

import android.app.Activity;
import d.a.n0.a.e.a;
import d.a.n0.a.e.d;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public final class c implements a.InterfaceC1704a {
    @Override // d.a.n0.a.e.a.InterfaceC1704a
    public final void T() {
    }

    @Override // d.a.n0.a.e.a.InterfaceC1704a
    public final void U() {
    }

    @Override // d.a.n0.a.e.a.InterfaceC1704a
    public final void a(Activity activity) {
        d dVar;
        dVar = d.a.f63378a;
        dVar.c(new WeakReference<>(activity));
    }

    @Override // d.a.n0.a.e.a.InterfaceC1704a
    public final void onActivityDestroyed(Activity activity) {
        d dVar;
        dVar = d.a.f63378a;
        dVar.d(activity);
    }
}
