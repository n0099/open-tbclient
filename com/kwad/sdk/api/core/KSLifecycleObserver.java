package com.kwad.sdk.api.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class KSLifecycleObserver {
    public static volatile KSLifecycleObserver sKSLifecycleObserver;
    public WeakReference<Activity> currentActivity;
    public Application mApplication;
    public boolean mIsInBackground = true;
    public Set<Integer> mStartedActivitySet = new HashSet();
    public final List<KSLifecycleListener> mListeners = new CopyOnWriteArrayList();
    public boolean mHasInit = false;
    public boolean mEnable = false;

    public static KSLifecycleObserver getInstance() {
        if (sKSLifecycleObserver == null) {
            synchronized (KSLifecycleObserver.class) {
                if (sKSLifecycleObserver == null) {
                    sKSLifecycleObserver = new KSLifecycleObserver();
                }
            }
        }
        return sKSLifecycleObserver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppBackToForeground() {
        try {
            this.mIsInBackground = false;
            for (KSLifecycleListener kSLifecycleListener : this.mListeners) {
                kSLifecycleListener.onBackToForeground();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppGoToBackground() {
        try {
            this.mIsInBackground = true;
            for (KSLifecycleListener kSLifecycleListener : this.mListeners) {
                kSLifecycleListener.onBackToBackground();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Keep
    public Application getApplication() {
        return this.mApplication;
    }

    @Keep
    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Keep
    public boolean isAppOnForeground() {
        if (!this.mIsInBackground) {
            return true;
        }
        return false;
    }

    @Keep
    public boolean isEnable() {
        return this.mEnable;
    }

    public void init(@NonNull Context context) {
        try {
            if ((context instanceof Application) && !this.mHasInit) {
                this.mHasInit = true;
                Application application = (Application) context;
                this.mApplication = application;
                application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.kwad.sdk.api.core.KSLifecycleObserver.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(@NonNull Activity activity) {
                        try {
                            for (KSLifecycleListener kSLifecycleListener : KSLifecycleObserver.this.mListeners) {
                                kSLifecycleListener.onActivityDestroyed(activity);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(@NonNull Activity activity) {
                        try {
                            KSLifecycleObserver.this.currentActivity = new WeakReference(activity);
                            for (KSLifecycleListener kSLifecycleListener : KSLifecycleObserver.this.mListeners) {
                                kSLifecycleListener.onActivityResumed(activity);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(@NonNull Activity activity) {
                        try {
                            KSLifecycleObserver.this.mStartedActivitySet.add(Integer.valueOf(activity.hashCode()));
                            if (KSLifecycleObserver.this.mStartedActivitySet.size() != 1) {
                                return;
                            }
                            KSLifecycleObserver.this.onAppBackToForeground();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(@NonNull Activity activity) {
                        try {
                            KSLifecycleObserver.this.mStartedActivitySet.remove(Integer.valueOf(activity.hashCode()));
                            if (KSLifecycleObserver.this.mStartedActivitySet.size() != 0) {
                                return;
                            }
                            KSLifecycleObserver.this.onAppGoToBackground();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                        KSLifecycleObserver.this.mEnable = true;
                        try {
                            for (KSLifecycleListener kSLifecycleListener : KSLifecycleObserver.this.mListeners) {
                                kSLifecycleListener.onActivityCreated(activity, bundle);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(@NonNull Activity activity) {
                        try {
                            if (KSLifecycleObserver.this.currentActivity != null && KSLifecycleObserver.this.currentActivity.get() != null && ((Activity) KSLifecycleObserver.this.currentActivity.get()).equals(activity)) {
                                KSLifecycleObserver.this.currentActivity = null;
                            }
                            for (KSLifecycleListener kSLifecycleListener : KSLifecycleObserver.this.mListeners) {
                                kSLifecycleListener.onActivityPaused(activity);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Keep
    public void registerLifecycleListener(KSLifecycleListener kSLifecycleListener) {
        this.mListeners.add(kSLifecycleListener);
    }

    @Keep
    public void unRegisterLifecycleListener(KSLifecycleListener kSLifecycleListener) {
        this.mListeners.remove(kSLifecycleListener);
    }
}
