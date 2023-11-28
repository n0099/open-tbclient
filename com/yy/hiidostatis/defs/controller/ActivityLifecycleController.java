package com.yy.hiidostatis.defs.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes2.dex */
public class ActivityLifecycleController {
    public volatile boolean isRegister = false;

    /* loaded from: classes2.dex */
    public interface ActivityLifecycleCallback {
        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);
    }

    public boolean isRegister() {
        return this.isRegister;
    }

    @SuppressLint({"NewApi"})
    public void registerActivityLifecycleCallbacks(Context context, final ActivityLifecycleCallback activityLifecycleCallback) {
        try {
            if (isRegister()) {
                L.warnOn(this, "call registerActivityLifecycleCallbacks only once", new Object[0]);
            } else if (Build.VERSION.SDK_INT >= 14) {
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
                ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.yy.hiidostatis.defs.controller.ActivityLifecycleController.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        activityLifecycleCallback.onActivityPaused(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        activityLifecycleCallback.onActivityResumed(activity);
                    }
                });
                this.isRegister = true;
            }
        } catch (Throwable th) {
            L.debug(this, "registerActivityLifecycleCallbacks Throwable:%s", th);
        }
    }
}
