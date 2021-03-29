package d.c.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class s1 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: f  reason: collision with root package name */
    public static int f65070f;

    /* renamed from: g  reason: collision with root package name */
    public static h0 f65071g;

    /* renamed from: h  reason: collision with root package name */
    public static h0 f65072h;
    public static long i;
    public static String j;
    public static Object k;
    public static Object l;
    public static final HashSet<Integer> m = new HashSet<>(8);

    /* renamed from: e  reason: collision with root package name */
    public final e1 f65073e;

    public s1(e1 e1Var) {
        this.f65073e = e1Var;
    }

    public static h0 a(h0 h0Var, long j2) {
        h0 h0Var2 = (h0) h0Var.clone();
        h0Var2.f65112e = j2;
        long j3 = j2 - h0Var.f65112e;
        if (j3 >= 0) {
            h0Var2.m = j3;
        } else {
            r0.b(null);
        }
        x1.d(h0Var2);
        return h0Var2;
    }

    public static h0 b(String str, String str2, long j2, String str3) {
        h0 h0Var = new h0();
        if (!TextUtils.isEmpty(str2)) {
            h0Var.o = str + ":" + str2;
        } else {
            h0Var.o = str;
        }
        h0Var.f65112e = j2;
        h0Var.m = -1L;
        if (str3 == null) {
            str3 = "";
        }
        h0Var.n = str3;
        x1.d(h0Var);
        return h0Var;
    }

    public static void c(Object obj) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        m.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        m.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (f65072h != null) {
            c(l);
        }
        h0 h0Var = f65071g;
        if (h0Var != null) {
            j = h0Var.o;
            long currentTimeMillis = System.currentTimeMillis();
            i = currentTimeMillis;
            a(f65071g, currentTimeMillis);
            f65071g = null;
            activity.isChild();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        h0 b2 = b(activity.getClass().getName(), "", System.currentTimeMillis(), j);
        f65071g = b2;
        b2.p = !m.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild()) {
            return;
        }
        try {
            activity.getWindow().getDecorView().hashCode();
            k = activity;
        } catch (Exception e2) {
            r0.b(e2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        e1 e1Var;
        int i2 = f65070f + 1;
        f65070f = i2;
        if (i2 != 1 || (e1Var = this.f65073e) == null) {
            return;
        }
        e1Var.a(true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (j != null) {
            int i2 = f65070f - 1;
            f65070f = i2;
            if (i2 <= 0) {
                j = null;
                i = 0L;
                e1 e1Var = this.f65073e;
                if (e1Var != null) {
                    e1Var.a(false);
                }
            }
        }
    }
}
