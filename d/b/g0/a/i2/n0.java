package d.b.g0.a.i2;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class n0 {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f44726f = d.b.g0.a.k.f45050a;

    /* renamed from: g  reason: collision with root package name */
    public static c f44727g;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Application f44728a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.a.z0.a f44729b = new a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f44730c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44731d;

    /* renamed from: e  reason: collision with root package name */
    public int f44732e;

    /* loaded from: classes3.dex */
    public class a extends d.b.g0.a.z0.a {

        /* renamed from: d.b.g0.a.i2.n0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0700a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f44734e;

            public RunnableC0700a(Activity activity) {
                this.f44734e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Intent intent = this.f44734e.getIntent();
                d.b.g0.a.p.c.r l = d.b.g0.a.w0.a.l();
                ComponentName component = intent.getComponent();
                if (n0.this.f44730c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && l != null && component != null && TextUtils.equals(l.j(), component.getClassName())) {
                    if (n0.this.f44731d) {
                        if (n0.f44726f) {
                            Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                            return;
                        }
                        return;
                    }
                    d.b.g0.a.i2.b m = d.b.g0.a.i2.b.m();
                    if (d.b.g0.a.i2.c.a() && d.b.g0.a.i2.b.k()) {
                        u = m.w(this.f44734e, n0.this.f44732e, false);
                    } else {
                        u = m.u(n0.this.f44732e, false, false);
                    }
                    if (n0.f44726f) {
                        Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + u + ", taskId=" + n0.this.f44732e);
                    }
                    m.i();
                }
                if (n0.f44726f) {
                    Log.d("SwanHomeScreenLaunch", "class=" + this.f44734e + ", swanAppForeground=" + n0.this.f44730c + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                }
            }
        }

        public a() {
        }

        @Override // d.b.g0.a.z0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (d.b.g0.a.i2.b.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC0700a runnableC0700a = new RunnableC0700a(activity);
                if (d.b.g0.a.i2.c.a()) {
                    runnableC0700a.run();
                } else {
                    p.j(runnableC0700a, "moveTaskToFront");
                }
            }
        }

        @Override // d.b.g0.a.z0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            super.onActivityStarted(activity);
            n0 n0Var = n0.this;
            n0Var.f44730c = n0Var.f44730c && activity != null && activity.getTaskId() == n0.this.f44732e;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c {
        public b() {
        }

        @Override // d.b.g0.a.i2.n0.c
        public void a(boolean z, int i) {
            if (z) {
                n0.this.f44730c = true;
                n0.this.f44732e = i;
            } else if (n0.this.f44730c && i == 1) {
                n0.this.f44730c = false;
            }
            n0.this.f44731d = z;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z, int i);
    }

    public n0(@NonNull Application application) {
        this.f44728a = application;
        f44727g = new b();
        application.registerActivityLifecycleCallbacks(this.f44729b);
    }

    public static void h(boolean z, int i) {
        c cVar = f44727g;
        if (cVar != null) {
            cVar.a(z, i);
        }
    }

    public void i() {
        f44727g = null;
        this.f44728a.unregisterActivityLifecycleCallbacks(this.f44729b);
    }
}
