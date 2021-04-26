package d.a.n0.a.e;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import d.a.n0.a.e.a;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class h implements Application.ActivityLifecycleCallbacks {

    /* renamed from: e  reason: collision with root package name */
    public a f63391e;

    public h(a aVar) {
        this.f63391e = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.f63391e.b()) {
            for (a.InterfaceC1704a interfaceC1704a : this.f63391e.b()) {
                interfaceC1704a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.f63391e.b()) {
            for (a.InterfaceC1704a interfaceC1704a : this.f63391e.b()) {
                interfaceC1704a.onActivityDestroyed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.f63391e.b()) {
            for (a.InterfaceC1704a interfaceC1704a : this.f63391e.b()) {
                interfaceC1704a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.f63391e.b()) {
            for (a.InterfaceC1704a interfaceC1704a : this.f63391e.b()) {
                interfaceC1704a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.f63391e.b()) {
            Iterator<a.InterfaceC1704a> it = this.f63391e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.f63391e.b()) {
            Iterator<a.InterfaceC1704a> it = this.f63391e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.f63391e.b()) {
            Iterator<a.InterfaceC1704a> it = this.f63391e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
