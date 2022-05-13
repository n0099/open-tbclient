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
/* loaded from: classes7.dex */
public class a {
    public Application a;
    public c b;
    public final List<InterfaceC0597a> c;
    public int d;
    public WeakReference<Activity> e;
    public volatile int f;
    public volatile boolean g;
    public final Application.ActivityLifecycleCallbacks h;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0597a {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static final a a = new a();
    }

    /* loaded from: classes7.dex */
    public interface c {
    }

    private Object[] d() {
        Object[] array;
        synchronized (this.c) {
            array = this.c.size() > 0 ? this.c.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f = 1;
        Object[] d = d();
        if (d != null) {
            for (Object obj : d) {
                ((InterfaceC0597a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f = 0;
        Object[] d = d();
        if (d != null) {
            for (Object obj : d) {
                ((InterfaceC0597a) obj).c();
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
        this.c = new ArrayList();
        this.f = -1;
        this.g = false;
        this.h = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.a.a.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                a.this.g = true;
                if (a.this.d != 0 || activity == null) {
                    return;
                }
                a.this.d = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i = a.this.d;
                a.this.g = false;
                a.this.d = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                a.this.e = new WeakReference(activity);
                int i = a.this.d;
                a.this.d = activity != null ? activity.hashCode() : i;
                a.this.g = false;
                if (i == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == a.this.d) {
                    a.this.d = 0;
                    a.this.f();
                }
                a.this.g = false;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [int, boolean] */
    public boolean b() {
        int i = this.f;
        int i2 = i;
        if (i == -1) {
            ?? g = g();
            this.f = g;
            i2 = g;
        }
        return i2 == 1;
    }

    public boolean c() {
        return b() && !this.g;
    }

    public static a a() {
        return b.a;
    }

    public void b(InterfaceC0597a interfaceC0597a) {
        synchronized (this.c) {
            this.c.remove(interfaceC0597a);
        }
    }

    public void a(Context context) {
        if (this.a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.a == null) {
                    Application application = (Application) context;
                    this.a = application;
                    application.registerActivityLifecycleCallbacks(this.h);
                }
            }
        }
    }

    public void a(c cVar) {
        this.b = cVar;
    }

    public void a(InterfaceC0597a interfaceC0597a) {
        if (interfaceC0597a == null) {
            return;
        }
        synchronized (this.c) {
            if (!this.c.contains(interfaceC0597a)) {
                this.c.add(interfaceC0597a);
            }
        }
    }
}
