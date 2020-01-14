package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
public class dj implements Application.ActivityLifecycleCallbacks {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private String f243a;
    private String b;

    public dj(Context context, String str) {
        this.f243a = "";
        this.a = context;
        this.f243a = str;
    }

    private void a(String str) {
        ho hoVar = new ho();
        hoVar.a(str);
        hoVar.a(System.currentTimeMillis());
        hoVar.a(hi.ActivityActiveTimeStamp);
        dx.a(this.a, hoVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (TextUtils.isEmpty(this.f243a) || TextUtils.isEmpty(localClassName)) {
            return;
        }
        this.b = "";
        if (!TextUtils.isEmpty(this.b) && !TextUtils.equals(this.b, localClassName)) {
            this.f243a = "";
            return;
        }
        a(this.a.getPackageName() + "|" + localClassName + ":" + this.f243a + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(System.currentTimeMillis() / 1000));
        this.f243a = "";
        this.b = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = activity.getLocalClassName();
        }
        this.f243a = String.valueOf(System.currentTimeMillis() / 1000);
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
}
