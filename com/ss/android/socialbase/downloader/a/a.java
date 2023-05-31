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
/* loaded from: classes10.dex */
public class a {
    public Application a;
    public c b;
    public final List<InterfaceC0713a> c;
    public int d;
    public WeakReference<Activity> e;
    public volatile int f;
    public volatile boolean g;
    public final Application.ActivityLifecycleCallbacks h;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0713a {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* loaded from: classes10.dex */
    public interface c {
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static final a a = new a();
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
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                a.this.g = true;
                if (a.this.d == 0 && activity != null) {
                    a.this.d = activity.hashCode();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i;
                int i2 = a.this.d;
                a.this.g = false;
                a aVar = a.this;
                if (activity != null) {
                    i = activity.hashCode();
                } else {
                    i = i2;
                }
                aVar.d = i;
                if (i2 != 0) {
                    return;
                }
                a.this.e();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                int i;
                a.this.e = new WeakReference(activity);
                int i2 = a.this.d;
                a aVar = a.this;
                if (activity != null) {
                    i = activity.hashCode();
                } else {
                    i = i2;
                }
                aVar.d = i;
                a.this.g = false;
                if (i2 != 0) {
                    return;
                }
                a.this.e();
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

    public static a a() {
        return b.a;
    }

    private Object[] d() {
        Object[] objArr;
        synchronized (this.c) {
            if (this.c.size() > 0) {
                objArr = this.c.toArray();
            } else {
                objArr = null;
            }
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f = 1;
        Object[] d = d();
        if (d != null) {
            for (Object obj : d) {
                ((InterfaceC0713a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f = 0;
        Object[] d = d();
        if (d != null) {
            for (Object obj : d) {
                ((InterfaceC0713a) obj).c();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    public boolean b() {
        int i = this.f;
        int i2 = i;
        if (i == -1) {
            ?? g = g();
            this.f = g;
            i2 = g;
        }
        if (i2 == 1) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (b() && !this.g) {
            return true;
        }
        return false;
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

    public void b(InterfaceC0713a interfaceC0713a) {
        synchronized (this.c) {
            this.c.remove(interfaceC0713a);
        }
    }

    public void a(InterfaceC0713a interfaceC0713a) {
        if (interfaceC0713a == null) {
            return;
        }
        synchronized (this.c) {
            if (!this.c.contains(interfaceC0713a)) {
                this.c.add(interfaceC0713a);
            }
        }
    }

    public void a(c cVar) {
        this.b = cVar;
    }
}
