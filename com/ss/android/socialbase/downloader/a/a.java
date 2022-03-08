package com.ss.android.socialbase.downloader.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public Application a;

    /* renamed from: b  reason: collision with root package name */
    public c f58391b;

    /* renamed from: c  reason: collision with root package name */
    public final List<InterfaceC2192a> f58392c;

    /* renamed from: d  reason: collision with root package name */
    public int f58393d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f58394e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f58395f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f58396g;

    /* renamed from: h  reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f58397h;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC2192a {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static final a a = new a();
    }

    /* loaded from: classes8.dex */
    public interface c {
    }

    private Object[] d() {
        Object[] array;
        synchronized (this.f58392c) {
            array = this.f58392c.size() > 0 ? this.f58392c.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f58395f = 1;
        Object[] d2 = d();
        if (d2 != null) {
            for (Object obj : d2) {
                ((InterfaceC2192a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f58395f = 0;
        Object[] d2 = d();
        if (d2 != null) {
            for (Object obj : d2) {
                ((InterfaceC2192a) obj).c();
            }
        }
    }

    private boolean g() {
        try {
            Application application = this.a;
            if (application == null) {
                return false;
            }
            String packageName = application.getPackageName();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) application.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.importance == 100 && TextUtils.equals(runningAppProcessInfo.processName, packageName)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public a() {
        this.f58392c = new ArrayList();
        this.f58395f = -1;
        this.f58396g = false;
        this.f58397h = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.a.a.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                a.this.f58396g = true;
                if (a.this.f58393d != 0 || activity == null) {
                    return;
                }
                a.this.f58393d = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i2 = a.this.f58393d;
                a.this.f58396g = false;
                a.this.f58393d = activity != null ? activity.hashCode() : i2;
                if (i2 == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                a.this.f58394e = new WeakReference(activity);
                int i2 = a.this.f58393d;
                a.this.f58393d = activity != null ? activity.hashCode() : i2;
                a.this.f58396g = false;
                if (i2 == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == a.this.f58393d) {
                    a.this.f58393d = 0;
                    a.this.f();
                }
                a.this.f58396g = false;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    public boolean b() {
        int i2 = this.f58395f;
        int i3 = i2;
        if (i2 == -1) {
            ?? g2 = g();
            this.f58395f = g2;
            i3 = g2;
        }
        return i3 == 1;
    }

    public boolean c() {
        return b() && !this.f58396g;
    }

    public static a a() {
        return b.a;
    }

    public void b(InterfaceC2192a interfaceC2192a) {
        synchronized (this.f58392c) {
            this.f58392c.remove(interfaceC2192a);
        }
    }

    public void a(Context context) {
        if (this.a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.a == null) {
                    Application application = (Application) context;
                    this.a = application;
                    application.registerActivityLifecycleCallbacks(this.f58397h);
                }
            }
        }
    }

    public void a(c cVar) {
        this.f58391b = cVar;
    }

    public void a(InterfaceC2192a interfaceC2192a) {
        if (interfaceC2192a == null) {
            return;
        }
        synchronized (this.f58392c) {
            if (!this.f58392c.contains(interfaceC2192a)) {
                this.f58392c.add(interfaceC2192a);
            }
        }
    }
}
