package d.b.m0.a.e;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import d.b.m0.a.e.a;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class h implements Application.ActivityLifecycleCallbacks {

    /* renamed from: e  reason: collision with root package name */
    public a f64812e;

    public h(a aVar) {
        this.f64812e = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.f64812e.b()) {
            for (a.InterfaceC1747a interfaceC1747a : this.f64812e.b()) {
                interfaceC1747a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.f64812e.b()) {
            for (a.InterfaceC1747a interfaceC1747a : this.f64812e.b()) {
                interfaceC1747a.onActivityDestroyed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.f64812e.b()) {
            for (a.InterfaceC1747a interfaceC1747a : this.f64812e.b()) {
                interfaceC1747a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.f64812e.b()) {
            for (a.InterfaceC1747a interfaceC1747a : this.f64812e.b()) {
                interfaceC1747a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.f64812e.b()) {
            Iterator<a.InterfaceC1747a> it = this.f64812e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.f64812e.b()) {
            Iterator<a.InterfaceC1747a> it = this.f64812e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.f64812e.b()) {
            Iterator<a.InterfaceC1747a> it = this.f64812e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
