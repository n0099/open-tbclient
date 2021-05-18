package d.a.o0.a.e;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import d.a.o0.a.e.a;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class h implements Application.ActivityLifecycleCallbacks {

    /* renamed from: e  reason: collision with root package name */
    public a f64099e;

    public h(a aVar) {
        this.f64099e = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.f64099e.b()) {
            for (a.InterfaceC1769a interfaceC1769a : this.f64099e.b()) {
                interfaceC1769a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.f64099e.b()) {
            for (a.InterfaceC1769a interfaceC1769a : this.f64099e.b()) {
                interfaceC1769a.onActivityDestroyed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.f64099e.b()) {
            for (a.InterfaceC1769a interfaceC1769a : this.f64099e.b()) {
                interfaceC1769a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.f64099e.b()) {
            for (a.InterfaceC1769a interfaceC1769a : this.f64099e.b()) {
                interfaceC1769a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.f64099e.b()) {
            Iterator<a.InterfaceC1769a> it = this.f64099e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.f64099e.b()) {
            Iterator<a.InterfaceC1769a> it = this.f64099e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.f64099e.b()) {
            Iterator<a.InterfaceC1769a> it = this.f64099e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
