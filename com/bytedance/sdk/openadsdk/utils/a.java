package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f7833a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private AtomicBoolean f7834b = new AtomicBoolean(false);
    private HashSet<Integer> c = new HashSet<>();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.f7833a.incrementAndGet() > 0) {
            this.f7834b.set(false);
        }
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity != null) {
            this.c.add(Integer.valueOf(activity.hashCode()));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.f7833a.decrementAndGet() == 0) {
            this.f7834b.set(true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            this.c.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    public boolean a() {
        return this.f7834b.get();
    }

    public boolean a(Activity activity) {
        return activity != null && this.c.contains(Integer.valueOf(activity.hashCode()));
    }

    private void b() {
        long a2 = k.a();
        if (a2 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - a2;
            if (currentTimeMillis < 86400000 && currentTimeMillis > 0) {
                String b2 = k.b();
                String c = k.c();
                if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(c)) {
                    com.bytedance.sdk.openadsdk.c.d.a(currentTimeMillis, b2, c);
                }
            }
        }
    }
}
