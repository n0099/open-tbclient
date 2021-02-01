package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
/* renamed from: com.xiaomi.push.do  reason: invalid class name */
/* loaded from: classes6.dex */
public class Cdo implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private Context f13953a;

    /* renamed from: a  reason: collision with other field name */
    private String f304a;

    /* renamed from: b  reason: collision with root package name */
    private String f13954b;

    public Cdo(Context context, String str) {
        this.f304a = "";
        this.f13953a = context;
        this.f304a = str;
    }

    private void a(String str) {
        hu huVar = new hu();
        huVar.a(str);
        huVar.a(System.currentTimeMillis());
        huVar.a(ho.ActivityActiveTimeStamp);
        ed.a(this.f13953a, huVar);
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
        if (TextUtils.isEmpty(this.f304a) || TextUtils.isEmpty(localClassName)) {
            return;
        }
        this.f13954b = "";
        if (!TextUtils.isEmpty(this.f13954b) && !TextUtils.equals(this.f13954b, localClassName)) {
            this.f304a = "";
            return;
        }
        a(this.f13953a.getPackageName() + "|" + localClassName + ":" + this.f304a + "," + String.valueOf(System.currentTimeMillis() / 1000));
        this.f304a = "";
        this.f13954b = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.f13954b)) {
            this.f13954b = activity.getLocalClassName();
        }
        this.f304a = String.valueOf(System.currentTimeMillis() / 1000);
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
