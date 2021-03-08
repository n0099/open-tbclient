package org.webrtc.audioengine;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
class AppBackgroundMonitor implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "[NotifyApplicationBackground]";
    private AppBackgroundMonitorListener mAppBackgroundMonitorListener;
    private Context mContext;
    private boolean mIsBackground = false;
    private WeakReference<Activity> mCurrentActivity = null;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mCheck = null;
    private Application mApplication = null;

    public AppBackgroundMonitor(Context context, AppBackgroundMonitorListener appBackgroundMonitorListener) {
        this.mContext = context;
        this.mAppBackgroundMonitorListener = appBackgroundMonitorListener;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.mCurrentActivity = new WeakReference<>(activity);
        if (this.mCheck != null) {
            this.mHandler.removeCallbacks(this.mCheck);
        }
        if (this.mIsBackground && activity != null && !activity.isChangingConfigurations() && this.mAppBackgroundMonitorListener != null) {
            this.mIsBackground = false;
            this.mAppBackgroundMonitorListener.notifyAppBackground(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (!activity.isChangingConfigurations()) {
            final WeakReference weakReference = new WeakReference(activity);
            Handler handler = this.mHandler;
            Runnable runnable = new Runnable() { // from class: org.webrtc.audioengine.AppBackgroundMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    AppBackgroundMonitor.this.onActivityCeased((Activity) weakReference.get());
                }
            };
            this.mCheck = runnable;
            handler.postDelayed(runnable, 2000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.mCheck != null) {
            this.mHandler.removeCallbacks(this.mCheck);
        }
        onActivityCeased(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onActivityCeased(Activity activity) {
        if (!this.mIsBackground) {
            if ((this.mCurrentActivity == null || activity == this.mCurrentActivity.get()) && activity != null && !activity.isChangingConfigurations() && this.mAppBackgroundMonitorListener != null) {
                this.mIsBackground = true;
                this.mAppBackgroundMonitorListener.notifyAppBackground(true);
            }
        }
    }

    public void init() {
        if (this.mContext != null && (this.mContext instanceof Application)) {
            this.mApplication = (Application) this.mContext;
            this.mApplication.registerActivityLifecycleCallbacks(this);
            AudioManagerAndroid.doLog("[NotifyApplicationBackground]registerNotifyApplicationBackgound");
        }
        this.mIsBackground = false;
        this.mCheck = null;
        this.mCurrentActivity = null;
    }

    public void uninit() {
        if (this.mApplication != null) {
            this.mApplication = (Application) this.mContext;
            this.mApplication.unregisterActivityLifecycleCallbacks(this);
            this.mApplication = null;
            AudioManagerAndroid.doLog("[NotifyApplicationBackground]unregisterNotifyApplicationBackgound");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }
}
