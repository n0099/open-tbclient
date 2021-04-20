package d.b.m0.a.e;

import android.app.Activity;
import d.b.m0.a.e.a;
import d.b.m0.a.e.d;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public final class c implements a.InterfaceC1747a {
    @Override // d.b.m0.a.e.a.InterfaceC1747a
    public final void T() {
    }

    @Override // d.b.m0.a.e.a.InterfaceC1747a
    public final void U() {
    }

    @Override // d.b.m0.a.e.a.InterfaceC1747a
    public final void a(Activity activity) {
        d dVar;
        dVar = d.a.f64799a;
        dVar.c(new WeakReference<>(activity));
    }

    @Override // d.b.m0.a.e.a.InterfaceC1747a
    public final void onActivityDestroyed(Activity activity) {
        d dVar;
        dVar = d.a.f64799a;
        dVar.d(activity);
    }
}
