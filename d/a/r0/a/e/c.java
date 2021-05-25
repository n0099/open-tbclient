package d.a.r0.a.e;

import android.app.Activity;
import d.a.r0.a.e.a;
import d.a.r0.a.e.d;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public final class c implements a.InterfaceC1801a {
    @Override // d.a.r0.a.e.a.InterfaceC1801a
    public final void T() {
    }

    @Override // d.a.r0.a.e.a.InterfaceC1801a
    public final void U() {
    }

    @Override // d.a.r0.a.e.a.InterfaceC1801a
    public final void a(Activity activity) {
        d dVar;
        dVar = d.a.f64413a;
        dVar.c(new WeakReference<>(activity));
    }

    @Override // d.a.r0.a.e.a.InterfaceC1801a
    public final void onActivityDestroyed(Activity activity) {
        d dVar;
        dVar = d.a.f64413a;
        dVar.d(activity);
    }
}
