package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
/* renamed from: com.xiaomi.push.do  reason: invalid class name */
/* loaded from: classes5.dex */
public class Cdo implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private Context f8327a;

    /* renamed from: a  reason: collision with other field name */
    private String f225a;
    private String b;

    public Cdo(Context context, String str) {
        this.f225a = "";
        this.f8327a = context;
        this.f225a = str;
    }

    private void a(String str) {
        hu huVar = new hu();
        huVar.a(str);
        huVar.a(System.currentTimeMillis());
        huVar.a(ho.ActivityActiveTimeStamp);
        ed.a(this.f8327a, huVar);
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
        if (TextUtils.isEmpty(this.f225a) || TextUtils.isEmpty(localClassName)) {
            return;
        }
        this.b = "";
        if (!TextUtils.isEmpty(this.b) && !TextUtils.equals(this.b, localClassName)) {
            this.f225a = "";
            return;
        }
        a(this.f8327a.getPackageName() + "|" + localClassName + ":" + this.f225a + "," + String.valueOf(System.currentTimeMillis() / 1000));
        this.f225a = "";
        this.b = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = activity.getLocalClassName();
        }
        this.f225a = String.valueOf(System.currentTimeMillis() / 1000);
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
