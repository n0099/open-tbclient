package com.ss.android.socialbase.downloader.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.MainThread;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Application f13062a;

    /* renamed from: b  reason: collision with root package name */
    private final List<InterfaceC1227a> f13063b;
    private int c;
    private volatile int d;
    private final Application.ActivityLifecycleCallbacks pUd;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1227a {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    public static a eDz() {
        return b.pUe;
    }

    /* loaded from: classes4.dex */
    private static class b {
        private static final a pUe = new a();
    }

    private a() {
        this.f13063b = new ArrayList();
        this.d = -1;
        this.pUd = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.a.a.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
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
        if (this.f13062a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.f13062a == null) {
                    this.f13062a = (Application) context;
                    this.f13062a.registerActivityLifecycleCallbacks(this.pUd);
                }
            }
        }
    }

    public boolean b() {
        int i = this.d;
        if (i == -1) {
            f();
            i = this.d;
        }
        return i == 1;
    }

    public void a(InterfaceC1227a interfaceC1227a) {
        if (interfaceC1227a != null) {
            synchronized (this.f13063b) {
                if (!this.f13063b.contains(interfaceC1227a)) {
                    this.f13063b.add(interfaceC1227a);
                }
            }
        }
    }

    public void b(InterfaceC1227a interfaceC1227a) {
        synchronized (this.f13063b) {
            this.f13063b.remove(interfaceC1227a);
        }
    }

    private Object[] c() {
        Object[] objArr = null;
        synchronized (this.f13063b) {
            if (this.f13063b.size() > 0) {
                objArr = this.f13063b.toArray();
            }
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.ss.android.socialbase.downloader.f.a.c("AppStatusManager", "dispatchAppForeground");
        this.d = 1;
        Object[] c = c();
        if (c != null) {
            for (Object obj : c) {
                ((InterfaceC1227a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.ss.android.socialbase.downloader.f.a.c("AppStatusManager", "dispatchAppBackground");
        this.d = 0;
        Object[] c = c();
        if (c != null) {
            for (Object obj : c) {
                ((InterfaceC1227a) obj).c();
            }
        }
    }

    private void f() {
        Activity eDA = eDA();
        if (this.d == -1) {
            if (eDA != null) {
                this.c = eDA.hashCode();
                this.d = 1;
                return;
            }
            this.d = 0;
        }
    }

    private Activity eDA() {
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
