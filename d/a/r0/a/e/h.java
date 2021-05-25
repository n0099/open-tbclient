package d.a.r0.a.e;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import d.a.r0.a.e.a;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class h implements Application.ActivityLifecycleCallbacks {

    /* renamed from: e  reason: collision with root package name */
    public a f64426e;

    public h(a aVar) {
        this.f64426e = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.f64426e.b()) {
            for (a.InterfaceC1801a interfaceC1801a : this.f64426e.b()) {
                interfaceC1801a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.f64426e.b()) {
            for (a.InterfaceC1801a interfaceC1801a : this.f64426e.b()) {
                interfaceC1801a.onActivityDestroyed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.f64426e.b()) {
            for (a.InterfaceC1801a interfaceC1801a : this.f64426e.b()) {
                interfaceC1801a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.f64426e.b()) {
            for (a.InterfaceC1801a interfaceC1801a : this.f64426e.b()) {
                interfaceC1801a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.f64426e.b()) {
            Iterator<a.InterfaceC1801a> it = this.f64426e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.f64426e.b()) {
            Iterator<a.InterfaceC1801a> it = this.f64426e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.f64426e.b()) {
            Iterator<a.InterfaceC1801a> it = this.f64426e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
