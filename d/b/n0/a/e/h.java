package d.b.n0.a.e;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import d.b.n0.a.e.a;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class h implements Application.ActivityLifecycleCallbacks {

    /* renamed from: e  reason: collision with root package name */
    public a f65080e;

    public h(a aVar) {
        this.f65080e = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.f65080e.b()) {
            for (a.InterfaceC1766a interfaceC1766a : this.f65080e.b()) {
                interfaceC1766a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.f65080e.b()) {
            for (a.InterfaceC1766a interfaceC1766a : this.f65080e.b()) {
                interfaceC1766a.onActivityDestroyed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.f65080e.b()) {
            for (a.InterfaceC1766a interfaceC1766a : this.f65080e.b()) {
                interfaceC1766a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.f65080e.b()) {
            for (a.InterfaceC1766a interfaceC1766a : this.f65080e.b()) {
                interfaceC1766a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.f65080e.b()) {
            Iterator<a.InterfaceC1766a> it = this.f65080e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.f65080e.b()) {
            Iterator<a.InterfaceC1766a> it = this.f65080e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.f65080e.b()) {
            Iterator<a.InterfaceC1766a> it = this.f65080e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
