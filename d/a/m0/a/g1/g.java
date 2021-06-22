package d.a.m0.a.g1;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class g implements Application.ActivityLifecycleCallbacks {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45710g = k.f46983a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile g f45711h;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45712e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f45713f;

    public static g a() {
        if (f45711h == null) {
            synchronized (g.class) {
                if (f45711h == null) {
                    f45711h = new g();
                }
            }
        }
        return f45711h;
    }

    public boolean b() {
        return this.f45712e;
    }

    public void c() {
        if (f45710g) {
            Log.d("SwanAppLifecycle", "registerSelf for lifecycle");
        }
        d.a.m0.a.c1.a.b().registerActivityLifecycleCallbacks(this);
    }

    public void d(boolean z) {
        boolean z2 = this.f45712e;
        if (z2 != z) {
            if (z2) {
                this.f45712e = false;
                d.a.m0.a.g1.k.d.a().e(null);
                return;
            }
            this.f45712e = true;
            d.a.m0.a.g1.k.d.a().d(null);
        }
    }

    public void e() {
        if (f45710g) {
            Log.d("SwanAppLifecycle", "un registerSelf for lifecycle");
        }
        d.a.m0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this);
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
        if (this.f45712e) {
            return;
        }
        this.f45712e = true;
        d.a.m0.a.g1.k.d.a().d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i2 = this.f45713f + 1;
        this.f45713f = i2;
        if (i2 != 1 || this.f45712e) {
            return;
        }
        if (f45710g) {
            Log.d("SwanAppLifecycle", "onBackgroundToForeground");
        }
        this.f45712e = true;
        d.a.m0.a.g1.k.d.a().d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i2 = this.f45713f - 1;
        this.f45713f = i2;
        if (i2 == 0 && this.f45712e) {
            if (f45710g) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.f45712e = false;
            d.a.m0.a.g1.k.d.a().e(activity);
        }
    }
}
