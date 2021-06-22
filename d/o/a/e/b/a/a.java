package d.o.a.e.b.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Application f71041a;

    /* renamed from: b  reason: collision with root package name */
    public d f71042b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f71043c;

    /* renamed from: d  reason: collision with root package name */
    public int f71044d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f71045e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f71046f;

    /* renamed from: g  reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f71047g;

    /* renamed from: d.o.a.e.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1950a implements Application.ActivityLifecycleCallbacks {
        public C1950a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            d.o.a.e.b.c.a.g("AppStatusManager", "onActivityPaused activity = [" + activity + PreferencesUtil.RIGHT_MOUNT);
            if (a.this.f71044d != 0 || activity == null) {
                return;
            }
            a.this.f71044d = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            d.o.a.e.b.c.a.g("AppStatusManager", "onActivityResumed activity = [" + activity + PreferencesUtil.RIGHT_MOUNT);
            int i2 = a.this.f71044d;
            a.this.f71044d = activity != null ? activity.hashCode() : i2;
            if (i2 == 0) {
                a.this.m();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            a.this.f71045e = new WeakReference(activity);
            int i2 = a.this.f71044d;
            a.this.f71044d = activity != null ? activity.hashCode() : i2;
            if (i2 == 0) {
                a.this.m();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            d.o.a.e.b.c.a.g("AppStatusManager", "onActivityStopped activity = [" + activity + PreferencesUtil.RIGHT_MOUNT);
            if (activity == null || activity.hashCode() != a.this.f71044d) {
                return;
            }
            a.this.f71044d = 0;
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
        public static final a f71049a = new a(null);
    }

    /* loaded from: classes7.dex */
    public interface d {
        boolean a();
    }

    public /* synthetic */ a(C1950a c1950a) {
        this();
    }

    public static a c() {
        return c.f71049a;
    }

    public void e(Context context) {
        if (this.f71041a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.f71041a == null) {
                    Application application = (Application) context;
                    this.f71041a = application;
                    application.registerActivityLifecycleCallbacks(this.f71047g);
                }
            }
        }
    }

    public void f(b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.f71043c) {
            if (!this.f71043c.contains(bVar)) {
                this.f71043c.add(bVar);
            }
        }
    }

    public void g(d dVar) {
        this.f71042b = dVar;
    }

    public void h(b bVar) {
        synchronized (this.f71043c) {
            this.f71043c.remove(bVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [int, boolean] */
    public boolean j() {
        d dVar = this.f71042b;
        if (dVar != null) {
            return !dVar.a();
        }
        int i2 = this.f71046f;
        int i3 = i2;
        if (i2 == -1) {
            ?? o = o();
            this.f71046f = o;
            i3 = o;
        }
        return i3 == 1;
    }

    public final Object[] l() {
        Object[] array;
        synchronized (this.f71043c) {
            array = this.f71043c.size() > 0 ? this.f71043c.toArray() : null;
        }
        return array;
    }

    public final void m() {
        this.f71046f = 1;
        Object[] l = l();
        if (l != null) {
            for (Object obj : l) {
                ((b) obj).b();
            }
        }
    }

    public final void n() {
        this.f71046f = 0;
        Object[] l = l();
        if (l != null) {
            for (Object obj : l) {
                ((b) obj).c();
            }
        }
    }

    public final boolean o() {
        try {
            Application application = this.f71041a;
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
        this.f71043c = new ArrayList();
        this.f71046f = -1;
        this.f71047g = new C1950a();
    }
}
