package d.a.l0.a.g1;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class g implements Application.ActivityLifecycleCallbacks {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f41926g = k.f43199a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile g f41927h;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41928e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f41929f;

    public static g a() {
        if (f41927h == null) {
            synchronized (g.class) {
                if (f41927h == null) {
                    f41927h = new g();
                }
            }
        }
        return f41927h;
    }

    public boolean b() {
        return this.f41928e;
    }

    public void c() {
        if (f41926g) {
            Log.d("SwanAppLifecycle", "registerSelf for lifecycle");
        }
        d.a.l0.a.c1.a.b().registerActivityLifecycleCallbacks(this);
    }

    public void d(boolean z) {
        boolean z2 = this.f41928e;
        if (z2 != z) {
            if (z2) {
                this.f41928e = false;
                d.a.l0.a.g1.k.d.a().e(null);
                return;
            }
            this.f41928e = true;
            d.a.l0.a.g1.k.d.a().d(null);
        }
    }

    public void e() {
        if (f41926g) {
            Log.d("SwanAppLifecycle", "un registerSelf for lifecycle");
        }
        d.a.l0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this);
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
        if (this.f41928e) {
            return;
        }
        this.f41928e = true;
        d.a.l0.a.g1.k.d.a().d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i2 = this.f41929f + 1;
        this.f41929f = i2;
        if (i2 != 1 || this.f41928e) {
            return;
        }
        if (f41926g) {
            Log.d("SwanAppLifecycle", "onBackgroundToForeground");
        }
        this.f41928e = true;
        d.a.l0.a.g1.k.d.a().d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i2 = this.f41929f - 1;
        this.f41929f = i2;
        if (i2 == 0 && this.f41928e) {
            if (f41926g) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.f41928e = false;
            d.a.l0.a.g1.k.d.a().e(activity);
        }
    }
}
