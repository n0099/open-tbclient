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
    public static final boolean f44727f = d.b.g0.a.k.f45051a;

    /* renamed from: g  reason: collision with root package name */
    public static c f44728g;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Application f44729a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.a.z0.a f44730b = new a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f44731c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44732d;

    /* renamed from: e  reason: collision with root package name */
    public int f44733e;

    /* loaded from: classes3.dex */
    public class a extends d.b.g0.a.z0.a {

        /* renamed from: d.b.g0.a.i2.n0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0701a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f44735e;

            public RunnableC0701a(Activity activity) {
                this.f44735e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Intent intent = this.f44735e.getIntent();
                d.b.g0.a.p.c.r l = d.b.g0.a.w0.a.l();
                ComponentName component = intent.getComponent();
                if (n0.this.f44731c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && l != null && component != null && TextUtils.equals(l.j(), component.getClassName())) {
                    if (n0.this.f44732d) {
                        if (n0.f44727f) {
                            Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                            return;
                        }
                        return;
                    }
                    d.b.g0.a.i2.b m = d.b.g0.a.i2.b.m();
                    if (d.b.g0.a.i2.c.a() && d.b.g0.a.i2.b.k()) {
                        u = m.w(this.f44735e, n0.this.f44733e, false);
                    } else {
                        u = m.u(n0.this.f44733e, false, false);
                    }
                    if (n0.f44727f) {
                        Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + u + ", taskId=" + n0.this.f44733e);
                    }
                    m.i();
                }
                if (n0.f44727f) {
                    Log.d("SwanHomeScreenLaunch", "class=" + this.f44735e + ", swanAppForeground=" + n0.this.f44731c + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
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
                RunnableC0701a runnableC0701a = new RunnableC0701a(activity);
                if (d.b.g0.a.i2.c.a()) {
                    runnableC0701a.run();
                } else {
                    p.j(runnableC0701a, "moveTaskToFront");
                }
            }
        }

        @Override // d.b.g0.a.z0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            super.onActivityStarted(activity);
            n0 n0Var = n0.this;
            n0Var.f44731c = n0Var.f44731c && activity != null && activity.getTaskId() == n0.this.f44733e;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c {
        public b() {
        }

        @Override // d.b.g0.a.i2.n0.c
        public void a(boolean z, int i) {
            if (z) {
                n0.this.f44731c = true;
                n0.this.f44733e = i;
            } else if (n0.this.f44731c && i == 1) {
                n0.this.f44731c = false;
            }
            n0.this.f44732d = z;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z, int i);
    }

    public n0(@NonNull Application application) {
        this.f44729a = application;
        f44728g = new b();
        application.registerActivityLifecycleCallbacks(this.f44730b);
    }

    public static void h(boolean z, int i) {
        c cVar = f44728g;
        if (cVar != null) {
            cVar.a(z, i);
        }
    }

    public void i() {
        f44728g = null;
        this.f44729a.unregisterActivityLifecycleCallbacks(this.f44730b);
    }
}
