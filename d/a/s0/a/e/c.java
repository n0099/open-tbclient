package d.a.s0.a.e;

import android.app.Activity;
import d.a.s0.a.e.a;
import d.a.s0.a.e.d;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public final class c implements a.InterfaceC1863a {
    @Override // d.a.s0.a.e.a.InterfaceC1863a
    public final void T() {
    }

    @Override // d.a.s0.a.e.a.InterfaceC1863a
    public final void U() {
    }

    @Override // d.a.s0.a.e.a.InterfaceC1863a
    public final void a(Activity activity) {
        d dVar;
        dVar = d.a.f68247a;
        dVar.c(new WeakReference<>(activity));
    }

    @Override // d.a.s0.a.e.a.InterfaceC1863a
    public final void onActivityDestroyed(Activity activity) {
        d dVar;
        dVar = d.a.f68247a;
        dVar.d(activity);
    }
}
