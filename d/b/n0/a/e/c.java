package d.b.n0.a.e;

import android.app.Activity;
import d.b.n0.a.e.a;
import d.b.n0.a.e.d;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public final class c implements a.InterfaceC1766a {
    @Override // d.b.n0.a.e.a.InterfaceC1766a
    public final void T() {
    }

    @Override // d.b.n0.a.e.a.InterfaceC1766a
    public final void U() {
    }

    @Override // d.b.n0.a.e.a.InterfaceC1766a
    public final void a(Activity activity) {
        d dVar;
        dVar = d.a.f65067a;
        dVar.c(new WeakReference<>(activity));
    }

    @Override // d.b.n0.a.e.a.InterfaceC1766a
    public final void onActivityDestroyed(Activity activity) {
        d dVar;
        dVar = d.a.f65067a;
        dVar.d(activity);
    }
}
