package d.a.s0.a.e;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import d.a.s0.a.e.a;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class h implements Application.ActivityLifecycleCallbacks {

    /* renamed from: e  reason: collision with root package name */
    public a f68260e;

    public h(a aVar) {
        this.f68260e = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.f68260e.b()) {
            for (a.InterfaceC1863a interfaceC1863a : this.f68260e.b()) {
                interfaceC1863a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.f68260e.b()) {
            for (a.InterfaceC1863a interfaceC1863a : this.f68260e.b()) {
                interfaceC1863a.onActivityDestroyed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.f68260e.b()) {
            for (a.InterfaceC1863a interfaceC1863a : this.f68260e.b()) {
                interfaceC1863a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.f68260e.b()) {
            for (a.InterfaceC1863a interfaceC1863a : this.f68260e.b()) {
                interfaceC1863a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.f68260e.b()) {
            Iterator<a.InterfaceC1863a> it = this.f68260e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.f68260e.b()) {
            Iterator<a.InterfaceC1863a> it = this.f68260e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.f68260e.b()) {
            Iterator<a.InterfaceC1863a> it = this.f68260e.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
