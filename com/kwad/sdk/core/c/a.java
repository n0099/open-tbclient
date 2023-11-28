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
/* loaded from: classes10.dex */
public final class a implements Application.ActivityLifecycleCallbacks {
    public final List<WeakReference<Activity>> asW;
    public WeakReference<Activity> currentActivity;
    public Application mApplication;
    public boolean mEnable;
    public boolean mIsInBackground;
    public final List<c> mListeners;

    /* renamed from: com.kwad.sdk.core.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0699a {
        public static final a asX = new a((byte) 0);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public a() {
        this.mIsInBackground = true;
        this.mListeners = new CopyOnWriteArrayList();
        this.asW = new ArrayList();
        this.mEnable = false;
    }

    public static a Cr() {
        return C0699a.asX;
    }

    private boolean Cs() {
        if (!b.Cu() && this.mEnable) {
            return false;
        }
        return true;
    }

    public final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final boolean isAppOnForeground() {
        if (!this.mIsInBackground) {
            return true;
        }
        return false;
    }

    public final boolean isEnable() {
        return this.mEnable;
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    private void f(Activity activity) {
        for (WeakReference<Activity> weakReference : this.asW) {
            if (weakReference.get() == activity) {
                return;
            }
        }
        this.asW.add(new WeakReference<>(activity));
    }

    private void g(Activity activity) {
        Activity activity2;
        if (activity == null) {
            return;
        }
        Iterator<WeakReference<Activity>> it = this.asW.iterator();
        while (it.hasNext()) {
            WeakReference<Activity> next = it.next();
            if (next != null && ((activity2 = next.get()) == activity || activity2 == null)) {
                it.remove();
            }
        }
    }

    public final void a(c cVar) {
        this.mListeners.add(cVar);
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (Cs()) {
            return;
        }
        try {
            for (c cVar : this.mListeners) {
                cVar.b(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (Cs()) {
            return;
        }
        try {
            for (c cVar : this.mListeners) {
                cVar.c(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (Cs()) {
            return;
        }
        try {
            this.currentActivity = new WeakReference<>(activity);
            for (c cVar : this.mListeners) {
                cVar.d(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (Cs()) {
            return;
        }
        try {
            f(activity);
            if (this.asW.size() == 1) {
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
    public final void onActivityStopped(Activity activity) {
        if (Cs()) {
            return;
        }
        try {
            g(activity);
            if (this.asW.size() == 0) {
                this.mIsInBackground = true;
                for (c cVar : this.mListeners) {
                    cVar.onBackToBackground();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.mEnable = true;
        if (Cs()) {
            return;
        }
        try {
            for (c cVar : this.mListeners) {
                cVar.a(activity, bundle);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
