package d.b.m0.a.e;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import d.b.m0.a.e.a;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class h implements Application.ActivityLifecycleCallbacks {

    /* renamed from: e  reason: collision with root package name */
    public a f64084e;

    public h(a aVar) {
        this.f64084e = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.f64084e.b()) {
            for (a.InterfaceC1735a interfaceC1735a : this.f64084e.b()) {
                interfaceC1735a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.f64084e.b()) {
            for (a.InterfaceC1735a interfaceC1735a : this.f64084e.b()) {
                interfaceC1735a.onActivityDestroyed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.f64084e.b()) {
            for (a.InterfaceC1735a interfaceC1735a : this.f64084e.b()) {
                interfaceC1735a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.f64084e.b()) {
            for (a.InterfaceC1735a interfaceC1735a : this.f64084e.b()) {
                interfaceC1735a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.f64084e.b()) {
            Iterator<a.InterfaceC1735a> it = this.f64084e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.f64084e.b()) {
            Iterator<a.InterfaceC1735a> it = this.f64084e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.f64084e.b()) {
            Iterator<a.InterfaceC1735a> it = this.f64084e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
