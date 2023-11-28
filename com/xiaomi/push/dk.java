package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
/* loaded from: classes10.dex */
public class dk implements Application.ActivityLifecycleCallbacks {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public String f226a;
    public String b;

    public dk(Context context, String str) {
        this.f226a = "";
        this.a = context;
        this.f226a = str;
    }

    private void a(String str) {
        hp hpVar = new hp();
        hpVar.a(str);
        hpVar.a(System.currentTimeMillis());
        hpVar.a(hj.ActivityActiveTimeStamp);
        ds.a(this.a, hpVar);
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
        if (TextUtils.isEmpty(this.f226a) || TextUtils.isEmpty(localClassName)) {
            return;
        }
        this.b = "";
        if (!TextUtils.isEmpty("") && !TextUtils.equals(this.b, localClassName)) {
            this.f226a = "";
            return;
        }
        a(this.a.getPackageName() + "|" + localClassName + ":" + this.f226a + "," + String.valueOf(System.currentTimeMillis() / 1000));
        this.f226a = "";
        this.b = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = activity.getLocalClassName();
        }
        this.f226a = String.valueOf(System.currentTimeMillis() / 1000);
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
