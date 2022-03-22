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

    /* renamed from: b  reason: collision with root package name */
    public c f43124b;

    /* renamed from: c  reason: collision with root package name */
    public final List<InterfaceC2053a> f43125c;

    /* renamed from: d  reason: collision with root package name */
    public int f43126d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f43127e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f43128f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f43129g;

    /* renamed from: h  reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f43130h;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC2053a {
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
        synchronized (this.f43125c) {
            array = this.f43125c.size() > 0 ? this.f43125c.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f43128f = 1;
        Object[] d2 = d();
        if (d2 != null) {
            for (Object obj : d2) {
                ((InterfaceC2053a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f43128f = 0;
        Object[] d2 = d();
        if (d2 != null) {
            for (Object obj : d2) {
                ((InterfaceC2053a) obj).c();
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
        this.f43125c = new ArrayList();
        this.f43128f = -1;
        this.f43129g = false;
        this.f43130h = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.a.a.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                a.this.f43129g = true;
                if (a.this.f43126d != 0 || activity == null) {
                    return;
                }
                a.this.f43126d = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i = a.this.f43126d;
                a.this.f43129g = false;
                a.this.f43126d = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                a.this.f43127e = new WeakReference(activity);
                int i = a.this.f43126d;
                a.this.f43126d = activity != null ? activity.hashCode() : i;
                a.this.f43129g = false;
                if (i == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == a.this.f43126d) {
                    a.this.f43126d = 0;
                    a.this.f();
                }
                a.this.f43129g = false;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    public boolean b() {
        int i = this.f43128f;
        int i2 = i;
        if (i == -1) {
            ?? g2 = g();
            this.f43128f = g2;
            i2 = g2;
        }
        return i2 == 1;
    }

    public boolean c() {
        return b() && !this.f43129g;
    }

    public static a a() {
        return b.a;
    }

    public void b(InterfaceC2053a interfaceC2053a) {
        synchronized (this.f43125c) {
            this.f43125c.remove(interfaceC2053a);
        }
    }

    public void a(Context context) {
        if (this.a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.a == null) {
                    Application application = (Application) context;
                    this.a = application;
                    application.registerActivityLifecycleCallbacks(this.f43130h);
                }
            }
        }
    }

    public void a(c cVar) {
        this.f43124b = cVar;
    }

    public void a(InterfaceC2053a interfaceC2053a) {
        if (interfaceC2053a == null) {
            return;
        }
        synchronized (this.f43125c) {
            if (!this.f43125c.contains(interfaceC2053a)) {
                this.f43125c.add(interfaceC2053a);
            }
        }
    }
}
