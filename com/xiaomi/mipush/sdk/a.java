package com.xiaomi.mipush.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.push.ek;
import com.xiaomi.push.el;
import java.util.HashSet;
import java.util.Set;
@TargetApi(14)
/* loaded from: classes7.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public Set<String> f37292a = new HashSet();

    public static void a(Application application) {
        application.registerActivityLifecycleCallbacks(new a());
    }

    public static void a(Context context) {
        a((Application) context.getApplicationContext());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        el a2;
        String packageName;
        String m273a;
        int i2;
        Intent intent = activity.getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(MiPushMessage.KEY_MESSAGE_ID);
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if (TextUtils.isEmpty(stringExtra) || intExtra <= 0 || this.f37292a.contains(stringExtra)) {
            return;
        }
        this.f37292a.add(stringExtra);
        if (intExtra == 3000) {
            a2 = el.a(activity.getApplicationContext());
            packageName = activity.getPackageName();
            m273a = ek.m273a(intExtra);
            i2 = 3008;
        } else if (intExtra != 1000) {
            return;
        } else {
            a2 = el.a(activity.getApplicationContext());
            packageName = activity.getPackageName();
            m273a = ek.m273a(intExtra);
            i2 = 1008;
        }
        a2.a(packageName, m273a, stringExtra, i2, null);
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
