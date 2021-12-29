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
/* loaded from: classes3.dex */
public class a {
    public Application a;

    /* renamed from: b  reason: collision with root package name */
    public c f62175b;

    /* renamed from: c  reason: collision with root package name */
    public final List<InterfaceC2180a> f62176c;

    /* renamed from: d  reason: collision with root package name */
    public int f62177d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f62178e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f62179f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f62180g;

    /* renamed from: h  reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f62181h;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2180a {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static final a a = new a();
    }

    /* loaded from: classes3.dex */
    public interface c {
    }

    private Object[] d() {
        Object[] array;
        synchronized (this.f62176c) {
            array = this.f62176c.size() > 0 ? this.f62176c.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f62179f = 1;
        Object[] d2 = d();
        if (d2 != null) {
            for (Object obj : d2) {
                ((InterfaceC2180a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f62179f = 0;
        Object[] d2 = d();
        if (d2 != null) {
            for (Object obj : d2) {
                ((InterfaceC2180a) obj).c();
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
        this.f62176c = new ArrayList();
        this.f62179f = -1;
        this.f62180g = false;
        this.f62181h = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.a.a.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                a.this.f62180g = true;
                if (a.this.f62177d != 0 || activity == null) {
                    return;
                }
                a.this.f62177d = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i2 = a.this.f62177d;
                a.this.f62180g = false;
                a.this.f62177d = activity != null ? activity.hashCode() : i2;
                if (i2 == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                a.this.f62178e = new WeakReference(activity);
                int i2 = a.this.f62177d;
                a.this.f62177d = activity != null ? activity.hashCode() : i2;
                a.this.f62180g = false;
                if (i2 == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == a.this.f62177d) {
                    a.this.f62177d = 0;
                    a.this.f();
                }
                a.this.f62180g = false;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    public boolean b() {
        int i2 = this.f62179f;
        int i3 = i2;
        if (i2 == -1) {
            ?? g2 = g();
            this.f62179f = g2;
            i3 = g2;
        }
        return i3 == 1;
    }

    public boolean c() {
        return b() && !this.f62180g;
    }

    public static a a() {
        return b.a;
    }

    public void b(InterfaceC2180a interfaceC2180a) {
        synchronized (this.f62176c) {
            this.f62176c.remove(interfaceC2180a);
        }
    }

    public void a(Context context) {
        if (this.a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.a == null) {
                    Application application = (Application) context;
                    this.a = application;
                    application.registerActivityLifecycleCallbacks(this.f62181h);
                }
            }
        }
    }

    public void a(c cVar) {
        this.f62175b = cVar;
    }

    public void a(InterfaceC2180a interfaceC2180a) {
        if (interfaceC2180a == null) {
            return;
        }
        synchronized (this.f62176c) {
            if (!this.f62176c.contains(interfaceC2180a)) {
                this.f62176c.add(interfaceC2180a);
            }
        }
    }
}
