package d.b.g0.a.z0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class g implements Application.ActivityLifecycleCallbacks {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f47172g = k.f45050a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile g f47173h;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47174e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f47175f;

    public static g a() {
        if (f47173h == null) {
            synchronized (g.class) {
                if (f47173h == null) {
                    f47173h = new g();
                }
            }
        }
        return f47173h;
    }

    public boolean b() {
        return this.f47174e;
    }

    public void c() {
        d.b.g0.a.w0.a.c().registerActivityLifecycleCallbacks(this);
    }

    public void d(boolean z) {
        this.f47174e = z;
    }

    public void e() {
        d.b.g0.a.w0.a.c().unregisterActivityLifecycleCallbacks(this);
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
        this.f47174e = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i = this.f47175f + 1;
        this.f47175f = i;
        if (i == 1) {
            if (f47172g) {
                Log.d("SwanAppLifecycle", "onBackgroundToForeground");
            }
            this.f47174e = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.f47175f - 1;
        this.f47175f = i;
        if (i == 0) {
            if (f47172g) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.f47174e = false;
        }
    }
}
