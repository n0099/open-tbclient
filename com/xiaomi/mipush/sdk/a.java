package com.xiaomi.mipush.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.push.fa;
import com.xiaomi.push.fb;
import java.util.HashSet;
import java.util.Set;
@TargetApi(14)
/* loaded from: classes8.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    private Set<String> a = new HashSet();

    private static void a(Application application) {
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
        Intent intent = activity.getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if (TextUtils.isEmpty(stringExtra) || intExtra <= 0 || this.a.contains(stringExtra)) {
            return;
        }
        this.a.add(stringExtra);
        if (intExtra == 3000) {
            fb.a(activity.getApplicationContext()).a(activity.getPackageName(), fa.m265a(intExtra), stringExtra, 3008, null);
        } else if (intExtra == 1000) {
            fb.a(activity.getApplicationContext()).a(activity.getPackageName(), fa.m265a(intExtra), stringExtra, 1008, null);
        }
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
