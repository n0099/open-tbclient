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
    public volatile InterfaceC0326a f30323a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f30324b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f30325c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public HashSet<Integer> f30326d = new HashSet<>();

    /* renamed from: com.bytedance.sdk.openadsdk.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0326a {
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
        return this.f30325c.get();
    }

    public void b() {
        if (this.f30323a != null) {
            this.f30323a = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f30323a != null) {
            this.f30323a.d();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            this.f30326d.remove(Integer.valueOf(activity.hashCode()));
        }
        if (this.f30323a != null) {
            this.f30323a.f();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.f30323a != null) {
            this.f30323a.c();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity != null) {
            this.f30326d.add(Integer.valueOf(activity.hashCode()));
        }
        if (this.f30323a != null) {
            this.f30323a.a();
        }
        d.b.c.b.a.c(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.f30324b.incrementAndGet() > 0) {
            this.f30325c.set(false);
        }
        c();
        if (this.f30323a != null) {
            this.f30323a.b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.f30324b.decrementAndGet() == 0) {
            this.f30325c.set(true);
        }
        if (this.f30323a != null) {
            this.f30323a.e();
        }
    }

    public boolean a(Activity activity) {
        return activity != null && this.f30326d.contains(Integer.valueOf(activity.hashCode()));
    }

    public void a(InterfaceC0326a interfaceC0326a) {
        this.f30323a = interfaceC0326a;
    }
}
