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
    private Context f14251a;

    /* renamed from: a  reason: collision with other field name */
    private String f305a;

    /* renamed from: b  reason: collision with root package name */
    private String f14252b;

    public Cdo(Context context, String str) {
        this.f305a = "";
        this.f14251a = context;
        this.f305a = str;
    }

    private void a(String str) {
        hu huVar = new hu();
        huVar.a(str);
        huVar.a(System.currentTimeMillis());
        huVar.a(ho.ActivityActiveTimeStamp);
        ed.a(this.f14251a, huVar);
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
        if (TextUtils.isEmpty(this.f305a) || TextUtils.isEmpty(localClassName)) {
            return;
        }
        this.f14252b = "";
        if (!TextUtils.isEmpty(this.f14252b) && !TextUtils.equals(this.f14252b, localClassName)) {
            this.f305a = "";
            return;
        }
        a(this.f14251a.getPackageName() + "|" + localClassName + ":" + this.f305a + "," + String.valueOf(System.currentTimeMillis() / 1000));
        this.f305a = "";
        this.f14252b = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.f14252b)) {
            this.f14252b = activity.getLocalClassName();
        }
        this.f305a = String.valueOf(System.currentTimeMillis() / 1000);
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
