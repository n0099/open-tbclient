package d.a.m0.a.v2;

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
    public static final boolean f49275f = d.a.m0.a.k.f46983a;

    /* renamed from: g  reason: collision with root package name */
    public static c f49276g;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Application f49277a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.a.g1.a f49278b = new a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f49279c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49280d;

    /* renamed from: e  reason: collision with root package name */
    public int f49281e;

    /* loaded from: classes3.dex */
    public class a extends d.a.m0.a.g1.a {

        /* renamed from: d.a.m0.a.v2.v0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0948a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f49283e;

            public RunnableC0948a(Activity activity) {
                this.f49283e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Intent intent = this.f49283e.getIntent();
                d.a.m0.a.p.d.a0 n = d.a.m0.a.c1.a.n();
                ComponentName component = intent.getComponent();
                if (v0.this.f49279c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && n != null && component != null && TextUtils.equals(n.y(), component.getClassName())) {
                    if (v0.this.f49280d) {
                        if (v0.f49275f) {
                            Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                            return;
                        }
                        return;
                    }
                    d.a.m0.a.v2.c m = d.a.m0.a.v2.c.m();
                    if (d.a() && d.a.m0.a.v2.c.k()) {
                        u = m.w(this.f49283e, v0.this.f49281e, false);
                    } else {
                        u = m.u(v0.this.f49281e, false, false);
                    }
                    if (v0.f49275f) {
                        Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + u + ", taskId=" + v0.this.f49281e);
                    }
                    m.i();
                }
                if (v0.f49275f) {
                    Log.d("SwanHomeScreenLaunch", "class=" + this.f49283e + ", swanAppForeground=" + v0.this.f49279c + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                }
            }
        }

        public a() {
        }

        @Override // d.a.m0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (d.a.m0.a.v2.c.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC0948a runnableC0948a = new RunnableC0948a(activity);
                if (d.a()) {
                    runnableC0948a.run();
                } else {
                    q.i(runnableC0948a, "moveTaskToFront");
                }
            }
        }

        @Override // d.a.m0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            super.onActivityStarted(activity);
            v0 v0Var = v0.this;
            v0Var.f49279c = v0Var.f49279c && activity != null && activity.getTaskId() == v0.this.f49281e;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c {
        public b() {
        }

        @Override // d.a.m0.a.v2.v0.c
        public void a(boolean z, int i2) {
            if (z) {
                v0.this.f49279c = true;
                v0.this.f49281e = i2;
            } else if (v0.this.f49279c && i2 == 1) {
                v0.this.f49279c = false;
            }
            v0.this.f49280d = z;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z, int i2);
    }

    public v0(@NonNull Application application) {
        this.f49277a = application;
        f49276g = new b();
        application.registerActivityLifecycleCallbacks(this.f49278b);
    }

    public static void h(boolean z, int i2) {
        c cVar = f49276g;
        if (cVar != null) {
            cVar.a(z, i2);
        }
    }

    public void i() {
        f49276g = null;
        this.f49277a.unregisterActivityLifecycleCallbacks(this.f49278b);
    }
}
