package d.a.h0.a.i2;

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
    public static final boolean f42766f = d.a.h0.a.k.f43101a;

    /* renamed from: g  reason: collision with root package name */
    public static c f42767g;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Application f42768a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.a.z0.a f42769b = new a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f42770c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42771d;

    /* renamed from: e  reason: collision with root package name */
    public int f42772e;

    /* loaded from: classes3.dex */
    public class a extends d.a.h0.a.z0.a {

        /* renamed from: d.a.h0.a.i2.n0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0672a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f42774e;

            public RunnableC0672a(Activity activity) {
                this.f42774e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Intent intent = this.f42774e.getIntent();
                d.a.h0.a.p.c.r l = d.a.h0.a.w0.a.l();
                ComponentName component = intent.getComponent();
                if (n0.this.f42770c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && l != null && component != null && TextUtils.equals(l.A(), component.getClassName())) {
                    if (n0.this.f42771d) {
                        if (n0.f42766f) {
                            Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                            return;
                        }
                        return;
                    }
                    d.a.h0.a.i2.b m = d.a.h0.a.i2.b.m();
                    if (d.a.h0.a.i2.c.a() && d.a.h0.a.i2.b.k()) {
                        u = m.w(this.f42774e, n0.this.f42772e, false);
                    } else {
                        u = m.u(n0.this.f42772e, false, false);
                    }
                    if (n0.f42766f) {
                        Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + u + ", taskId=" + n0.this.f42772e);
                    }
                    m.i();
                }
                if (n0.f42766f) {
                    Log.d("SwanHomeScreenLaunch", "class=" + this.f42774e + ", swanAppForeground=" + n0.this.f42770c + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                }
            }
        }

        public a() {
        }

        @Override // d.a.h0.a.z0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (d.a.h0.a.i2.b.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC0672a runnableC0672a = new RunnableC0672a(activity);
                if (d.a.h0.a.i2.c.a()) {
                    runnableC0672a.run();
                } else {
                    p.j(runnableC0672a, "moveTaskToFront");
                }
            }
        }

        @Override // d.a.h0.a.z0.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            super.onActivityStarted(activity);
            n0 n0Var = n0.this;
            n0Var.f42770c = n0Var.f42770c && activity != null && activity.getTaskId() == n0.this.f42772e;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c {
        public b() {
        }

        @Override // d.a.h0.a.i2.n0.c
        public void a(boolean z, int i2) {
            if (z) {
                n0.this.f42770c = true;
                n0.this.f42772e = i2;
            } else if (n0.this.f42770c && i2 == 1) {
                n0.this.f42770c = false;
            }
            n0.this.f42771d = z;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z, int i2);
    }

    public n0(@NonNull Application application) {
        this.f42768a = application;
        f42767g = new b();
        application.registerActivityLifecycleCallbacks(this.f42769b);
    }

    public static void h(boolean z, int i2) {
        c cVar = f42767g;
        if (cVar != null) {
            cVar.a(z, i2);
        }
    }

    public void i() {
        f42767g = null;
        this.f42768a.unregisterActivityLifecycleCallbacks(this.f42769b);
    }
}
