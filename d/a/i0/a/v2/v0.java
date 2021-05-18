package d.a.i0.a.v2;

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
public class v0 {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45317f = d.a.i0.a.k.f43025a;

    /* renamed from: g  reason: collision with root package name */
    public static c f45318g;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Application f45319a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.g1.a f45320b = new a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f45321c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45322d;

    /* renamed from: e  reason: collision with root package name */
    public int f45323e;

    /* loaded from: classes3.dex */
    public class a extends d.a.i0.a.g1.a {

        /* renamed from: d.a.i0.a.v2.v0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0878a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f45325e;

            public RunnableC0878a(Activity activity) {
                this.f45325e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Intent intent = this.f45325e.getIntent();
                d.a.i0.a.p.d.a0 n = d.a.i0.a.c1.a.n();
                ComponentName component = intent.getComponent();
                if (v0.this.f45321c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && n != null && component != null && TextUtils.equals(n.y(), component.getClassName())) {
                    if (v0.this.f45322d) {
                        if (v0.f45317f) {
                            Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                            return;
                        }
                        return;
                    }
                    d.a.i0.a.v2.c m = d.a.i0.a.v2.c.m();
                    if (d.a() && d.a.i0.a.v2.c.k()) {
                        u = m.w(this.f45325e, v0.this.f45323e, false);
                    } else {
                        u = m.u(v0.this.f45323e, false, false);
                    }
                    if (v0.f45317f) {
                        Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + u + ", taskId=" + v0.this.f45323e);
                    }
                    m.i();
                }
                if (v0.f45317f) {
                    Log.d("SwanHomeScreenLaunch", "class=" + this.f45325e + ", swanAppForeground=" + v0.this.f45321c + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                }
            }
        }

        public a() {
        }

        @Override // d.a.i0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (d.a.i0.a.v2.c.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC0878a runnableC0878a = new RunnableC0878a(activity);
                if (d.a()) {
                    runnableC0878a.run();
                } else {
                    q.i(runnableC0878a, "moveTaskToFront");
                }
            }
        }

        @Override // d.a.i0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            super.onActivityStarted(activity);
            v0 v0Var = v0.this;
            v0Var.f45321c = v0Var.f45321c && activity != null && activity.getTaskId() == v0.this.f45323e;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c {
        public b() {
        }

        @Override // d.a.i0.a.v2.v0.c
        public void a(boolean z, int i2) {
            if (z) {
                v0.this.f45321c = true;
                v0.this.f45323e = i2;
            } else if (v0.this.f45321c && i2 == 1) {
                v0.this.f45321c = false;
            }
            v0.this.f45322d = z;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z, int i2);
    }

    public v0(@NonNull Application application) {
        this.f45319a = application;
        f45318g = new b();
        application.registerActivityLifecycleCallbacks(this.f45320b);
    }

    public static void h(boolean z, int i2) {
        c cVar = f45318g;
        if (cVar != null) {
            cVar.a(z, i2);
        }
    }

    public void i() {
        f45318g = null;
        this.f45319a.unregisterActivityLifecycleCallbacks(this.f45320b);
    }
}
