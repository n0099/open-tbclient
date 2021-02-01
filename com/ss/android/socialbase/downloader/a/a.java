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
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Application f13064a;

    /* renamed from: b  reason: collision with root package name */
    private final List<InterfaceC1231a> f13065b;
    private int c;
    private volatile int d;
    private final Application.ActivityLifecycleCallbacks qei;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1231a {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    public static a eFQ() {
        return b.qej;
    }

    /* loaded from: classes6.dex */
    private static class b {
        private static final a qej = new a();
    }

    private a() {
        this.f13065b = new ArrayList();
        this.d = -1;
        this.qei = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.a.a.1
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
        if (this.f13064a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.f13064a == null) {
                    this.f13064a = (Application) context;
                    this.f13064a.registerActivityLifecycleCallbacks(this.qei);
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

    public void a(InterfaceC1231a interfaceC1231a) {
        if (interfaceC1231a != null) {
            synchronized (this.f13065b) {
                if (!this.f13065b.contains(interfaceC1231a)) {
                    this.f13065b.add(interfaceC1231a);
                }
            }
        }
    }

    public void b(InterfaceC1231a interfaceC1231a) {
        synchronized (this.f13065b) {
            this.f13065b.remove(interfaceC1231a);
        }
    }

    private Object[] c() {
        Object[] objArr = null;
        synchronized (this.f13065b) {
            if (this.f13065b.size() > 0) {
                objArr = this.f13065b.toArray();
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
                ((InterfaceC1231a) obj).b();
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
                ((InterfaceC1231a) obj).c();
            }
        }
    }

    private void f() {
        Activity eFR = eFR();
        if (this.d == -1) {
            if (eFR != null) {
                this.c = eFR.hashCode();
                this.d = 1;
                return;
            }
            this.d = 0;
        }
    }

    private Activity eFR() {
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
