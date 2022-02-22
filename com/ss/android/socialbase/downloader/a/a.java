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
    public c f60041b;

    /* renamed from: c  reason: collision with root package name */
    public final List<InterfaceC2213a> f60042c;

    /* renamed from: d  reason: collision with root package name */
    public int f60043d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f60044e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f60045f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f60046g;

    /* renamed from: h  reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f60047h;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC2213a {
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
        synchronized (this.f60042c) {
            array = this.f60042c.size() > 0 ? this.f60042c.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f60045f = 1;
        Object[] d2 = d();
        if (d2 != null) {
            for (Object obj : d2) {
                ((InterfaceC2213a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f60045f = 0;
        Object[] d2 = d();
        if (d2 != null) {
            for (Object obj : d2) {
                ((InterfaceC2213a) obj).c();
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
        this.f60042c = new ArrayList();
        this.f60045f = -1;
        this.f60046g = false;
        this.f60047h = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.a.a.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                a.this.f60046g = true;
                if (a.this.f60043d != 0 || activity == null) {
                    return;
                }
                a.this.f60043d = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i2 = a.this.f60043d;
                a.this.f60046g = false;
                a.this.f60043d = activity != null ? activity.hashCode() : i2;
                if (i2 == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                a.this.f60044e = new WeakReference(activity);
                int i2 = a.this.f60043d;
                a.this.f60043d = activity != null ? activity.hashCode() : i2;
                a.this.f60046g = false;
                if (i2 == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == a.this.f60043d) {
                    a.this.f60043d = 0;
                    a.this.f();
                }
                a.this.f60046g = false;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [int, boolean] */
    public boolean b() {
        int i2 = this.f60045f;
        int i3 = i2;
        if (i2 == -1) {
            ?? g2 = g();
            this.f60045f = g2;
            i3 = g2;
        }
        return i3 == 1;
    }

    public boolean c() {
        return b() && !this.f60046g;
    }

    public static a a() {
        return b.a;
    }

    public void b(InterfaceC2213a interfaceC2213a) {
        synchronized (this.f60042c) {
            this.f60042c.remove(interfaceC2213a);
        }
    }

    public void a(Context context) {
        if (this.a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.a == null) {
                    Application application = (Application) context;
                    this.a = application;
                    application.registerActivityLifecycleCallbacks(this.f60047h);
                }
            }
        }
    }

    public void a(c cVar) {
        this.f60041b = cVar;
    }

    public void a(InterfaceC2213a interfaceC2213a) {
        if (interfaceC2213a == null) {
            return;
        }
        synchronized (this.f60042c) {
            if (!this.f60042c.contains(interfaceC2213a)) {
                this.f60042c.add(interfaceC2213a);
            }
        }
    }
}
