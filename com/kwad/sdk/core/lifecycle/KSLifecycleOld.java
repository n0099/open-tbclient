package com.kwad.sdk.core.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class KSLifecycleOld implements Application.ActivityLifecycleCallbacks {
    public static KSLifecycleOld a;
    public Application b;
    public WeakReference<Activity> e;
    public boolean c = true;
    public int d = 0;
    public final List<b> f = new CopyOnWriteArrayList();

    public static KSLifecycleOld a() {
        if (a == null) {
            synchronized (KSLifecycleOld.class) {
                if (a == null) {
                    a = new KSLifecycleOld();
                }
            }
        }
        return a;
    }

    private void b() {
        try {
            this.c = false;
            for (b bVar : this.f) {
                bVar.a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c() {
        try {
            this.c = true;
            for (b bVar : this.f) {
                bVar.b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(@NonNull Context context) {
        try {
            Application application = (Application) context;
            this.b = application;
            application.registerActivityLifecycleCallbacks(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Keep
    public Application getApplication() {
        return this.b;
    }

    @Keep
    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Keep
    public boolean isAppOnForeground() {
        return !this.c;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            for (b bVar : this.f) {
                bVar.a(activity, bundle);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        try {
            for (b bVar : this.f) {
                bVar.c(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        try {
            for (b bVar : this.f) {
                bVar.b(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            this.e = new WeakReference<>(activity);
            for (b bVar : this.f) {
                bVar.a(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        try {
            int i = this.d + 1;
            this.d = i;
            if (i == 1) {
                b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        try {
            int i = this.d - 1;
            this.d = i;
            if (i == 0) {
                c();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Keep
    public void registerLifecycleListener(b bVar) {
        this.f.add(bVar);
    }

    @Keep
    public void unRegisterLifecycleListener(b bVar) {
        this.f.remove(bVar);
    }
}
