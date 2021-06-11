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
    public volatile InterfaceC0323a f30241a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f30242b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f30243c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public HashSet<Integer> f30244d = new HashSet<>();

    /* renamed from: com.bytedance.sdk.openadsdk.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0323a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    private void c() {
        long b2 = k.b();
        if (b2 <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - b2;
        if (currentTimeMillis >= 86400000 || currentTimeMillis <= 0) {
            return;
        }
        String c2 = k.c();
        String d2 = k.d();
        if (TextUtils.isEmpty(c2) || TextUtils.isEmpty(d2)) {
            return;
        }
        com.bytedance.sdk.openadsdk.c.d.a(currentTimeMillis, c2, d2);
    }

    public boolean a() {
        return this.f30243c.get();
    }

    public void b() {
        if (this.f30241a != null) {
            this.f30241a = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f30241a != null) {
            this.f30241a.d();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            this.f30244d.remove(Integer.valueOf(activity.hashCode()));
        }
        if (this.f30241a != null) {
            this.f30241a.f();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.f30241a != null) {
            this.f30241a.c();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity != null) {
            this.f30244d.add(Integer.valueOf(activity.hashCode()));
        }
        if (this.f30241a != null) {
            this.f30241a.a();
        }
        d.b.c.b.a.c(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.f30242b.incrementAndGet() > 0) {
            this.f30243c.set(false);
        }
        c();
        if (this.f30241a != null) {
            this.f30241a.b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.f30242b.decrementAndGet() == 0) {
            this.f30243c.set(true);
        }
        if (this.f30241a != null) {
            this.f30241a.e();
        }
    }

    public boolean a(Activity activity) {
        return activity != null && this.f30244d.contains(Integer.valueOf(activity.hashCode()));
    }

    public void a(InterfaceC0323a interfaceC0323a) {
        this.f30241a = interfaceC0323a;
    }
}
