package d.b.h0.a.z0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class g implements Application.ActivityLifecycleCallbacks {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f47894g = k.f45772a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile g f47895h;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47896e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f47897f;

    public static g a() {
        if (f47895h == null) {
            synchronized (g.class) {
                if (f47895h == null) {
                    f47895h = new g();
                }
            }
        }
        return f47895h;
    }

    public boolean b() {
        return this.f47896e;
    }

    public void c() {
        d.b.h0.a.w0.a.c().registerActivityLifecycleCallbacks(this);
    }

    public void d(boolean z) {
        this.f47896e = z;
    }

    public void e() {
        d.b.h0.a.w0.a.c().unregisterActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f47896e = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i = this.f47897f + 1;
        this.f47897f = i;
        if (i == 1) {
            if (f47894g) {
                Log.d("SwanAppLifecycle", "onBackgroundToForeground");
            }
            this.f47896e = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.f47897f - 1;
        this.f47897f = i;
        if (i == 0) {
            if (f47894g) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.f47896e = false;
        }
    }
}
