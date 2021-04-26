package d.a.h0.a.z0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import d.a.h0.a.k;
/* loaded from: classes2.dex */
public class g implements Application.ActivityLifecycleCallbacks {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45330g = k.f43101a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile g f45331h;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45332e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f45333f;

    public static g a() {
        if (f45331h == null) {
            synchronized (g.class) {
                if (f45331h == null) {
                    f45331h = new g();
                }
            }
        }
        return f45331h;
    }

    public boolean b() {
        return this.f45332e;
    }

    public void c() {
        d.a.h0.a.w0.a.c().registerActivityLifecycleCallbacks(this);
    }

    public void d(boolean z) {
        this.f45332e = z;
    }

    public void e() {
        d.a.h0.a.w0.a.c().unregisterActivityLifecycleCallbacks(this);
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
        this.f45332e = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i2 = this.f45333f + 1;
        this.f45333f = i2;
        if (i2 == 1) {
            if (f45330g) {
                Log.d("SwanAppLifecycle", "onBackgroundToForeground");
            }
            this.f45332e = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i2 = this.f45333f - 1;
        this.f45333f = i2;
        if (i2 == 0) {
            if (f45330g) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.f45332e = false;
        }
    }
}
