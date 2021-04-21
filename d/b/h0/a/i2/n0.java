package d.b.h0.a.i2;

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
    public static final boolean f45448f = d.b.h0.a.k.f45772a;

    /* renamed from: g  reason: collision with root package name */
    public static c f45449g;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Application f45450a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.a.z0.a f45451b = new a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f45452c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45453d;

    /* renamed from: e  reason: collision with root package name */
    public int f45454e;

    /* loaded from: classes3.dex */
    public class a extends d.b.h0.a.z0.a {

        /* renamed from: d.b.h0.a.i2.n0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0733a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f45456e;

            public RunnableC0733a(Activity activity) {
                this.f45456e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Intent intent = this.f45456e.getIntent();
                d.b.h0.a.p.c.r l = d.b.h0.a.w0.a.l();
                ComponentName component = intent.getComponent();
                if (n0.this.f45452c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && l != null && component != null && TextUtils.equals(l.j(), component.getClassName())) {
                    if (n0.this.f45453d) {
                        if (n0.f45448f) {
                            Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                            return;
                        }
                        return;
                    }
                    d.b.h0.a.i2.b m = d.b.h0.a.i2.b.m();
                    if (d.b.h0.a.i2.c.a() && d.b.h0.a.i2.b.k()) {
                        u = m.w(this.f45456e, n0.this.f45454e, false);
                    } else {
                        u = m.u(n0.this.f45454e, false, false);
                    }
                    if (n0.f45448f) {
                        Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + u + ", taskId=" + n0.this.f45454e);
                    }
                    m.i();
                }
                if (n0.f45448f) {
                    Log.d("SwanHomeScreenLaunch", "class=" + this.f45456e + ", swanAppForeground=" + n0.this.f45452c + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                }
            }
        }

        public a() {
        }

        @Override // d.b.h0.a.z0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (d.b.h0.a.i2.b.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC0733a runnableC0733a = new RunnableC0733a(activity);
                if (d.b.h0.a.i2.c.a()) {
                    runnableC0733a.run();
                } else {
                    p.j(runnableC0733a, "moveTaskToFront");
                }
            }
        }

        @Override // d.b.h0.a.z0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            super.onActivityStarted(activity);
            n0 n0Var = n0.this;
            n0Var.f45452c = n0Var.f45452c && activity != null && activity.getTaskId() == n0.this.f45454e;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c {
        public b() {
        }

        @Override // d.b.h0.a.i2.n0.c
        public void a(boolean z, int i) {
            if (z) {
                n0.this.f45452c = true;
                n0.this.f45454e = i;
            } else if (n0.this.f45452c && i == 1) {
                n0.this.f45452c = false;
            }
            n0.this.f45453d = z;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z, int i);
    }

    public n0(@NonNull Application application) {
        this.f45450a = application;
        f45449g = new b();
        application.registerActivityLifecycleCallbacks(this.f45451b);
    }

    public static void h(boolean z, int i) {
        c cVar = f45449g;
        if (cVar != null) {
            cVar.a(z, i);
        }
    }

    public void i() {
        f45449g = null;
        this.f45450a.unregisterActivityLifecycleCallbacks(this.f45451b);
    }
}
