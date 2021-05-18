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
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Application f67108a;

    /* renamed from: b  reason: collision with root package name */
    public d f67109b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f67110c;

    /* renamed from: d  reason: collision with root package name */
    public int f67111d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f67112e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f67113f;

    /* renamed from: g  reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f67114g;

    /* renamed from: d.o.a.e.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1883a implements Application.ActivityLifecycleCallbacks {
        public C1883a() {
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
            if (a.this.f67111d != 0 || activity == null) {
                return;
            }
            a.this.f67111d = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            d.o.a.e.b.c.a.g("AppStatusManager", "onActivityResumed activity = [" + activity + "]");
            int i2 = a.this.f67111d;
            a.this.f67111d = activity != null ? activity.hashCode() : i2;
            if (i2 == 0) {
                a.this.m();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            a.this.f67112e = new WeakReference(activity);
            int i2 = a.this.f67111d;
            a.this.f67111d = activity != null ? activity.hashCode() : i2;
            if (i2 == 0) {
                a.this.m();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            d.o.a.e.b.c.a.g("AppStatusManager", "onActivityStopped activity = [" + activity + "]");
            if (activity == null || activity.hashCode() != a.this.f67111d) {
                return;
            }
            a.this.f67111d = 0;
            a.this.n();
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f67116a = new a(null);
    }

    /* loaded from: classes7.dex */
    public interface d {
        boolean a();
    }

    public /* synthetic */ a(C1883a c1883a) {
        this();
    }

    public static a c() {
        return c.f67116a;
    }

    public void e(Context context) {
        if (this.f67108a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.f67108a == null) {
                    Application application = (Application) context;
                    this.f67108a = application;
                    application.registerActivityLifecycleCallbacks(this.f67114g);
                }
            }
        }
    }

    public void f(b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.f67110c) {
            if (!this.f67110c.contains(bVar)) {
                this.f67110c.add(bVar);
            }
        }
    }

    public void g(d dVar) {
        this.f67109b = dVar;
    }

    public void h(b bVar) {
        synchronized (this.f67110c) {
            this.f67110c.remove(bVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    public boolean j() {
        d dVar = this.f67109b;
        if (dVar != null) {
            return !dVar.a();
        }
        int i2 = this.f67113f;
        int i3 = i2;
        if (i2 == -1) {
            ?? o = o();
            this.f67113f = o;
            i3 = o;
        }
        return i3 == 1;
    }

    public final Object[] l() {
        Object[] array;
        synchronized (this.f67110c) {
            array = this.f67110c.size() > 0 ? this.f67110c.toArray() : null;
        }
        return array;
    }

    public final void m() {
        this.f67113f = 1;
        Object[] l = l();
        if (l != null) {
            for (Object obj : l) {
                ((b) obj).b();
            }
        }
    }

    public final void n() {
        this.f67113f = 0;
        Object[] l = l();
        if (l != null) {
            for (Object obj : l) {
                ((b) obj).c();
            }
        }
    }

    public final boolean o() {
        try {
            Application application = this.f67108a;
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
        this.f67110c = new ArrayList();
        this.f67113f = -1;
        this.f67114g = new C1883a();
    }
}
