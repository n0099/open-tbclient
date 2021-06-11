package d.a.l0.a.g1;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class g implements Application.ActivityLifecycleCallbacks {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45602g = k.f46875a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile g f45603h;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45604e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f45605f;

    public static g a() {
        if (f45603h == null) {
            synchronized (g.class) {
                if (f45603h == null) {
                    f45603h = new g();
                }
            }
        }
        return f45603h;
    }

    public boolean b() {
        return this.f45604e;
    }

    public void c() {
        if (f45602g) {
            Log.d("SwanAppLifecycle", "registerSelf for lifecycle");
        }
        d.a.l0.a.c1.a.b().registerActivityLifecycleCallbacks(this);
    }

    public void d(boolean z) {
        boolean z2 = this.f45604e;
        if (z2 != z) {
            if (z2) {
                this.f45604e = false;
                d.a.l0.a.g1.k.d.a().e(null);
                return;
            }
            this.f45604e = true;
            d.a.l0.a.g1.k.d.a().d(null);
        }
    }

    public void e() {
        if (f45602g) {
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
        if (this.f45604e) {
            return;
        }
        this.f45604e = true;
        d.a.l0.a.g1.k.d.a().d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i2 = this.f45605f + 1;
        this.f45605f = i2;
        if (i2 != 1 || this.f45604e) {
            return;
        }
        if (f45602g) {
            Log.d("SwanAppLifecycle", "onBackgroundToForeground");
        }
        this.f45604e = true;
        d.a.l0.a.g1.k.d.a().d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i2 = this.f45605f - 1;
        this.f45605f = i2;
        if (i2 == 0 && this.f45604e) {
            if (f45602g) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.f45604e = false;
            d.a.l0.a.g1.k.d.a().e(activity);
        }
    }
}
