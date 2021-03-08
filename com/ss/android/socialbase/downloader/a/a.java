package com.ss.android.socialbase.downloader.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.MainThread;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Application f7772a;
    private final List<InterfaceC1223a> b;
    private int c;
    private WeakReference<Activity> d;
    private volatile int e;
    private final Application.ActivityLifecycleCallbacks qfx;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1223a {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    public static a eGc() {
        return b.qfy;
    }

    /* loaded from: classes6.dex */
    private static class b {
        private static final a qfy = new a();
    }

    private a() {
        this.b = new ArrayList();
        this.e = -1;
        this.qfx = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.a.a.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                a.this.d = new WeakReference(activity);
                int i = a.this.c;
                a.this.c = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    a.this.d();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i = a.this.c;
                a.this.c = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    a.this.d();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == a.this.c) {
                    a.this.c = 0;
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }
        };
    }

    public void a(Context context) {
        if (this.f7772a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.f7772a == null) {
                    this.f7772a = (Application) context;
                    this.f7772a.registerActivityLifecycleCallbacks(this.qfx);
                }
            }
        }
    }

    public boolean b() {
        int i = this.e;
        if (i == -1) {
            f();
            i = this.e;
        }
        return i == 1;
    }

    public void a(InterfaceC1223a interfaceC1223a) {
        if (interfaceC1223a != null) {
            synchronized (this.b) {
                if (!this.b.contains(interfaceC1223a)) {
                    this.b.add(interfaceC1223a);
                }
            }
        }
    }

    public void b(InterfaceC1223a interfaceC1223a) {
        synchronized (this.b) {
            this.b.remove(interfaceC1223a);
        }
    }

    private Object[] c() {
        Object[] objArr = null;
        synchronized (this.b) {
            if (this.b.size() > 0) {
                objArr = this.b.toArray();
            }
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.ss.android.socialbase.downloader.f.a.c("AppStatusManager", "dispatchAppForeground");
        this.e = 1;
        Object[] c = c();
        if (c != null) {
            for (Object obj : c) {
                ((InterfaceC1223a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.ss.android.socialbase.downloader.f.a.c("AppStatusManager", "dispatchAppBackground");
        this.e = 0;
        Object[] c = c();
        if (c != null) {
            for (Object obj : c) {
                ((InterfaceC1223a) obj).c();
            }
        }
    }

    private void f() {
        Activity eGd = eGd();
        if (this.e == -1) {
            if (eGd != null) {
                this.c = eGd.hashCode();
                this.e = 1;
                return;
            }
            this.e = 0;
        }
    }

    private Activity eGd() {
        Map map;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            map = (Map) declaredField.get(invoke);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (map == null || map.size() == 0) {
            return null;
        }
        Field field = null;
        Class<?> cls2 = null;
        for (Object obj : map.values()) {
            if (cls2 == null) {
                cls2 = obj.getClass();
            }
            if (field == null) {
                field = cls2.getDeclaredField("paused");
            }
            field.setAccessible(true);
            if (!field.getBoolean(obj)) {
                Field declaredField2 = cls2.getDeclaredField(PushConstants.INTENT_ACTIVITY_NAME);
                declaredField2.setAccessible(true);
                return (Activity) declaredField2.get(obj);
            }
        }
        return null;
    }
}
