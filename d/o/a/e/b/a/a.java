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
    public Application f66921a;

    /* renamed from: b  reason: collision with root package name */
    public d f66922b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f66923c;

    /* renamed from: d  reason: collision with root package name */
    public int f66924d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f66925e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f66926f;

    /* renamed from: g  reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f66927g;

    /* renamed from: d.o.a.e.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1844a implements Application.ActivityLifecycleCallbacks {
        public C1844a() {
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
            if (a.this.f66924d != 0 || activity == null) {
                return;
            }
            a.this.f66924d = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            d.o.a.e.b.c.a.g("AppStatusManager", "onActivityResumed activity = [" + activity + "]");
            int i = a.this.f66924d;
            a.this.f66924d = activity != null ? activity.hashCode() : i;
            if (i == 0) {
                a.this.m();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            a.this.f66925e = new WeakReference(activity);
            int i = a.this.f66924d;
            a.this.f66924d = activity != null ? activity.hashCode() : i;
            if (i == 0) {
                a.this.m();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            d.o.a.e.b.c.a.g("AppStatusManager", "onActivityStopped activity = [" + activity + "]");
            if (activity == null || activity.hashCode() != a.this.f66924d) {
                return;
            }
            a.this.f66924d = 0;
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
        public static final a f66929a = new a(null);
    }

    /* loaded from: classes7.dex */
    public interface d {
        boolean a();
    }

    public /* synthetic */ a(C1844a c1844a) {
        this();
    }

    public static a c() {
        return c.f66929a;
    }

    public void e(Context context) {
        if (this.f66921a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.f66921a == null) {
                    Application application = (Application) context;
                    this.f66921a = application;
                    application.registerActivityLifecycleCallbacks(this.f66927g);
                }
            }
        }
    }

    public void f(b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.f66923c) {
            if (!this.f66923c.contains(bVar)) {
                this.f66923c.add(bVar);
            }
        }
    }

    public void g(d dVar) {
        this.f66922b = dVar;
    }

    public void h(b bVar) {
        synchronized (this.f66923c) {
            this.f66923c.remove(bVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [int, boolean] */
    public boolean j() {
        d dVar = this.f66922b;
        if (dVar != null) {
            return !dVar.a();
        }
        int i = this.f66926f;
        int i2 = i;
        if (i == -1) {
            ?? o = o();
            this.f66926f = o;
            i2 = o;
        }
        return i2 == 1;
    }

    public final Object[] l() {
        Object[] array;
        synchronized (this.f66923c) {
            array = this.f66923c.size() > 0 ? this.f66923c.toArray() : null;
        }
        return array;
    }

    public final void m() {
        this.f66926f = 1;
        Object[] l = l();
        if (l != null) {
            for (Object obj : l) {
                ((b) obj).b();
            }
        }
    }

    public final void n() {
        this.f66926f = 0;
        Object[] l = l();
        if (l != null) {
            for (Object obj : l) {
                ((b) obj).c();
            }
        }
    }

    public final boolean o() {
        try {
            Application application = this.f66921a;
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
        this.f66923c = new ArrayList();
        this.f66926f = -1;
        this.f66927g = new C1844a();
    }
}
