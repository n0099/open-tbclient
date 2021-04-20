package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.FieldBuilder;
/* loaded from: classes7.dex */
public class dh implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public Context f40652a;

    /* renamed from: a  reason: collision with other field name */
    public String f234a;

    /* renamed from: b  reason: collision with root package name */
    public String f40653b;

    public dh(Context context, String str) {
        this.f234a = "";
        this.f40652a = context;
        this.f234a = str;
    }

    private void a(String str) {
        hn hnVar = new hn();
        hnVar.a(str);
        hnVar.a(System.currentTimeMillis());
        hnVar.a(hh.ActivityActiveTimeStamp);
        dq.a(this.f40652a, hnVar);
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
        if (TextUtils.isEmpty(this.f234a) || TextUtils.isEmpty(localClassName)) {
            return;
        }
        this.f40653b = "";
        if (!TextUtils.isEmpty("") && !TextUtils.equals(this.f40653b, localClassName)) {
            this.f234a = "";
            return;
        }
        a(this.f40652a.getPackageName() + FieldBuilder.SE + localClassName + ":" + this.f234a + "," + String.valueOf(System.currentTimeMillis() / 1000));
        this.f234a = "";
        this.f40653b = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.f40653b)) {
            this.f40653b = activity.getLocalClassName();
        }
        this.f234a = String.valueOf(System.currentTimeMillis() / 1000);
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
