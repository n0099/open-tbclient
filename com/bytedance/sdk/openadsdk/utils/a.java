package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private volatile InterfaceC1047a f5111a;
    private AtomicInteger b = new AtomicInteger(0);
    private AtomicBoolean c = new AtomicBoolean(false);
    private HashSet<Integer> d = new HashSet<>();

    /* renamed from: com.bytedance.sdk.openadsdk.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1047a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f5111a != null) {
            this.f5111a.d();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.b.incrementAndGet() > 0) {
            this.c.set(false);
        }
        c();
        if (this.f5111a != null) {
            this.f5111a.b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity != null) {
            this.d.add(Integer.valueOf(activity.hashCode()));
        }
        if (this.f5111a != null) {
            this.f5111a.a();
        }
        com.bytedance.sdk.adnet.a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.f5111a != null) {
            this.f5111a.c();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.b.decrementAndGet() == 0) {
            this.c.set(true);
        }
        if (this.f5111a != null) {
            this.f5111a.e();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            this.d.remove(Integer.valueOf(activity.hashCode()));
        }
        if (this.f5111a != null) {
            this.f5111a.f();
        }
    }

    public boolean a() {
        return this.c.get();
    }

    public boolean a(Activity activity) {
        return activity != null && this.d.contains(Integer.valueOf(activity.hashCode()));
    }

    private void c() {
        long b = k.b();
        if (b > 0) {
            long currentTimeMillis = System.currentTimeMillis() - b;
            if (currentTimeMillis < 86400000 && currentTimeMillis > 0) {
                String c = k.c();
                String d = k.d();
                if (!TextUtils.isEmpty(c) && !TextUtils.isEmpty(d)) {
                    com.bytedance.sdk.openadsdk.c.d.a(currentTimeMillis, c, d);
                }
            }
        }
    }

    public void a(InterfaceC1047a interfaceC1047a) {
        this.f5111a = interfaceC1047a;
    }

    public void b() {
        if (this.f5111a != null) {
            this.f5111a = null;
        }
    }
}
