package d.b.m.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.crabsdk.b.n;
/* loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        com.baidu.crabsdk.c.a.c("onActivityCreated:" + activity.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        com.baidu.crabsdk.c.a.c("onActivityDestroyed:" + activity.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        boolean z;
        com.baidu.crabsdk.c.a.c("##onActivityPaused " + activity.getClass().getName());
        z = com.baidu.crabsdk.b.a.f4709h;
        if (z) {
            n.e(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        com.baidu.crabsdk.c.a.c("##onActivityResumed " + activity.getClass().getName());
        boolean unused = com.baidu.crabsdk.b.a.f4709h = true;
        n.f(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        com.baidu.crabsdk.c.a.c("onActivitySaveInstanceState:" + activity.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        com.baidu.crabsdk.b.a.a(activity);
        com.baidu.crabsdk.c.a.c("onActivityStarted:" + activity.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        com.baidu.crabsdk.b.a.c(activity);
        com.baidu.crabsdk.c.a.c("onActivityStopped:" + activity.toString());
    }
}
