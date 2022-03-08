package com.kwad.sdk.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Observable;
/* loaded from: classes8.dex */
public class x extends Observable {
    public static volatile x a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Activity> f56522b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f56523c;

    public static x a() {
        if (a == null) {
            synchronized (x.class) {
                if (a == null) {
                    a = new x();
                }
            }
        }
        return a;
    }

    public void a(Context context) {
        Object obj;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        Application application = null;
        com.kwad.sdk.core.d.a.a("LifecycleHolder", "init appContext: " + applicationContext);
        if (!(applicationContext instanceof Application)) {
            Field[] declaredFields = applicationContext.getClass().getDeclaredFields();
            int length = declaredFields.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Field field = declaredFields[i2];
                field.setAccessible(true);
                try {
                    obj = field.get(applicationContext);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
                if (obj instanceof Application) {
                    application = (Application) obj;
                    break;
                } else {
                    continue;
                    i2++;
                }
            }
        } else {
            application = (Application) applicationContext;
        }
        com.kwad.sdk.core.d.a.a("LifecycleHolder", "init application: " + application);
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.kwad.sdk.utils.x.1

                /* renamed from: b  reason: collision with root package name */
                public int f56524b = 0;

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(@NonNull Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(@NonNull Activity activity) {
                    if (x.this.f56522b == null || x.this.f56522b.get() == null || !((Activity) x.this.f56522b.get()).equals(activity)) {
                        return;
                    }
                    x.this.f56522b = null;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(@NonNull Activity activity) {
                    x.this.f56522b = new WeakReference(activity);
                    x.this.f56523c = new WeakReference(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(@NonNull Activity activity) {
                    int i3 = this.f56524b + 1;
                    this.f56524b = i3;
                    if (i3 == 1) {
                        x.this.e();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(@NonNull Activity activity) {
                    int i3 = this.f56524b - 1;
                    this.f56524b = i3;
                    if (i3 == 0) {
                        x.this.f();
                    }
                    if (x.this.f56523c == null || x.this.f56523c.get() == null || !((Activity) x.this.f56523c.get()).equals(activity)) {
                        return;
                    }
                    x.this.f56523c = null;
                }
            });
        }
    }

    public boolean b() {
        return c() != null;
    }

    @Nullable
    public Activity c() {
        WeakReference<Activity> weakReference = this.f56522b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int d() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f56523c;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return 0;
        }
        return activity.getClass().hashCode();
    }

    public void e() {
        com.kwad.sdk.core.d.a.a("LifecycleHolder", "onAppBackToForeground");
        setChanged();
        notifyObservers("ACTION_APP_BACK_TO_FOREGROUND");
    }

    public void f() {
        com.kwad.sdk.core.d.a.a("LifecycleHolder", "onAppGoToBackground");
        setChanged();
        notifyObservers("ACTION_APP_GO_TO_BACKGROUND");
    }
}
