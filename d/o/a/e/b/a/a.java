package d.o.a.e.b.a;

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
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Application f66422a;

    /* renamed from: b  reason: collision with root package name */
    public d f66423b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f66424c;

    /* renamed from: d  reason: collision with root package name */
    public int f66425d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f66426e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f66427f;

    /* renamed from: g  reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f66428g;

    /* renamed from: d.o.a.e.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1819a implements Application.ActivityLifecycleCallbacks {
        public C1819a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            d.o.a.e.b.c.a.g("AppStatusManager", "onActivityPaused activity = [" + activity + "]");
            if (a.this.f66425d != 0 || activity == null) {
                return;
            }
            a.this.f66425d = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            d.o.a.e.b.c.a.g("AppStatusManager", "onActivityResumed activity = [" + activity + "]");
            int i2 = a.this.f66425d;
            a.this.f66425d = activity != null ? activity.hashCode() : i2;
            if (i2 == 0) {
                a.this.m();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            a.this.f66426e = new WeakReference(activity);
            int i2 = a.this.f66425d;
            a.this.f66425d = activity != null ? activity.hashCode() : i2;
            if (i2 == 0) {
                a.this.m();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            d.o.a.e.b.c.a.g("AppStatusManager", "onActivityStopped activity = [" + activity + "]");
            if (activity == null || activity.hashCode() != a.this.f66425d) {
                return;
            }
            a.this.f66425d = 0;
            a.this.n();
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f66430a = new a(null);
    }

    /* loaded from: classes6.dex */
    public interface d {
        boolean a();
    }

    public /* synthetic */ a(C1819a c1819a) {
        this();
    }

    public static a c() {
        return c.f66430a;
    }

    public void e(Context context) {
        if (this.f66422a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.f66422a == null) {
                    Application application = (Application) context;
                    this.f66422a = application;
                    application.registerActivityLifecycleCallbacks(this.f66428g);
                }
            }
        }
    }

    public void f(b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.f66424c) {
            if (!this.f66424c.contains(bVar)) {
                this.f66424c.add(bVar);
            }
        }
    }

    public void g(d dVar) {
        this.f66423b = dVar;
    }

    public void h(b bVar) {
        synchronized (this.f66424c) {
            this.f66424c.remove(bVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [int, boolean] */
    public boolean j() {
        d dVar = this.f66423b;
        if (dVar != null) {
            return !dVar.a();
        }
        int i2 = this.f66427f;
        int i3 = i2;
        if (i2 == -1) {
            ?? o = o();
            this.f66427f = o;
            i3 = o;
        }
        return i3 == 1;
    }

    public final Object[] l() {
        Object[] array;
        synchronized (this.f66424c) {
            array = this.f66424c.size() > 0 ? this.f66424c.toArray() : null;
        }
        return array;
    }

    public final void m() {
        this.f66427f = 1;
        Object[] l = l();
        if (l != null) {
            for (Object obj : l) {
                ((b) obj).b();
            }
        }
    }

    public final void n() {
        this.f66427f = 0;
        Object[] l = l();
        if (l != null) {
            for (Object obj : l) {
                ((b) obj).c();
            }
        }
    }

    public final boolean o() {
        try {
            Application application = this.f66422a;
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
        this.f66424c = new ArrayList();
        this.f66427f = -1;
        this.f66428g = new C1819a();
    }
}
