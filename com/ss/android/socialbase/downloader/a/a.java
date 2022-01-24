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
/* loaded from: classes4.dex */
public class a {
    public Application a;

    /* renamed from: b  reason: collision with root package name */
    public c f59874b;

    /* renamed from: c  reason: collision with root package name */
    public final List<InterfaceC2203a> f59875c;

    /* renamed from: d  reason: collision with root package name */
    public int f59876d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f59877e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f59878f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f59879g;

    /* renamed from: h  reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f59880h;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC2203a {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static final a a = new a();
    }

    /* loaded from: classes4.dex */
    public interface c {
    }

    private Object[] d() {
        Object[] array;
        synchronized (this.f59875c) {
            array = this.f59875c.size() > 0 ? this.f59875c.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f59878f = 1;
        Object[] d2 = d();
        if (d2 != null) {
            for (Object obj : d2) {
                ((InterfaceC2203a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f59878f = 0;
        Object[] d2 = d();
        if (d2 != null) {
            for (Object obj : d2) {
                ((InterfaceC2203a) obj).c();
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
        this.f59875c = new ArrayList();
        this.f59878f = -1;
        this.f59879g = false;
        this.f59880h = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.a.a.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                a.this.f59879g = true;
                if (a.this.f59876d != 0 || activity == null) {
                    return;
                }
                a.this.f59876d = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i2 = a.this.f59876d;
                a.this.f59879g = false;
                a.this.f59876d = activity != null ? activity.hashCode() : i2;
                if (i2 == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                a.this.f59877e = new WeakReference(activity);
                int i2 = a.this.f59876d;
                a.this.f59876d = activity != null ? activity.hashCode() : i2;
                a.this.f59879g = false;
                if (i2 == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == a.this.f59876d) {
                    a.this.f59876d = 0;
                    a.this.f();
                }
                a.this.f59879g = false;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    public boolean b() {
        int i2 = this.f59878f;
        int i3 = i2;
        if (i2 == -1) {
            ?? g2 = g();
            this.f59878f = g2;
            i3 = g2;
        }
        return i3 == 1;
    }

    public boolean c() {
        return b() && !this.f59879g;
    }

    public static a a() {
        return b.a;
    }

    public void b(InterfaceC2203a interfaceC2203a) {
        synchronized (this.f59875c) {
            this.f59875c.remove(interfaceC2203a);
        }
    }

    public void a(Context context) {
        if (this.a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.a == null) {
                    Application application = (Application) context;
                    this.a = application;
                    application.registerActivityLifecycleCallbacks(this.f59880h);
                }
            }
        }
    }

    public void a(c cVar) {
        this.f59874b = cVar;
    }

    public void a(InterfaceC2203a interfaceC2203a) {
        if (interfaceC2203a == null) {
            return;
        }
        synchronized (this.f59875c) {
            if (!this.f59875c.contains(interfaceC2203a)) {
                this.f59875c.add(interfaceC2203a);
            }
        }
    }
}
