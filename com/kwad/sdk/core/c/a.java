package com.kwad.sdk.core.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    public static a XE;
    public WeakReference<Activity> currentActivity;
    public Application mApplication;
    public boolean mIsInBackground = true;
    public final List<c> mListeners = new CopyOnWriteArrayList();
    public final List<WeakReference<Activity>> XF = new ArrayList();
    public boolean mEnable = false;

    private void e(Activity activity) {
        for (WeakReference<Activity> weakReference : this.XF) {
            if (weakReference.get() == activity) {
                return;
            }
        }
        this.XF.add(new WeakReference<>(activity));
    }

    private void f(Activity activity) {
        Activity activity2;
        if (activity == null) {
            return;
        }
        Iterator<WeakReference<Activity>> it = this.XF.iterator();
        while (it.hasNext()) {
            WeakReference<Activity> next = it.next();
            if (next != null && ((activity2 = next.get()) == activity || activity2 == null)) {
                it.remove();
            }
        }
    }

    public static a tn() {
        if (XE == null) {
            synchronized (a.class) {
                if (XE == null) {
                    XE = new a();
                }
            }
        }
        return XE;
    }

    private boolean to() {
        return b.tq() || !this.mEnable;
    }

    public final void a(c cVar) {
        this.mListeners.add(cVar);
    }

    public final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void init(@NonNull Context context) {
        try {
            Application application = (Application) context;
            this.mApplication = application;
            application.registerActivityLifecycleCallbacks(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isAppOnForeground() {
        return !this.mIsInBackground;
    }

    public final boolean isEnable() {
        return this.mEnable;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.mEnable = true;
        if (to()) {
            return;
        }
        try {
            for (c cVar : this.mListeners) {
                cVar.onActivityCreated(activity, bundle);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (to()) {
            return;
        }
        try {
            for (c cVar : this.mListeners) {
                cVar.onActivityDestroyed(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (to()) {
            return;
        }
        try {
            for (c cVar : this.mListeners) {
                cVar.onActivityPaused(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (to()) {
            return;
        }
        try {
            this.currentActivity = new WeakReference<>(activity);
            for (c cVar : this.mListeners) {
                cVar.onActivityResumed(activity);
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
        if (to()) {
            return;
        }
        try {
            e(activity);
            if (this.XF.size() == 1) {
                this.mIsInBackground = false;
                for (c cVar : this.mListeners) {
                    cVar.onBackToForeground();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (to()) {
            return;
        }
        try {
            f(activity);
            if (this.XF.size() == 0) {
                this.mIsInBackground = true;
                for (c cVar : this.mListeners) {
                    cVar.onBackToBackground();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
