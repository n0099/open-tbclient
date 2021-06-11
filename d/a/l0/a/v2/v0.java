package d.a.l0.a.v2;

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
    public static final boolean f49167f = d.a.l0.a.k.f46875a;

    /* renamed from: g  reason: collision with root package name */
    public static c f49168g;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Application f49169a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.g1.a f49170b = new a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f49171c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49172d;

    /* renamed from: e  reason: collision with root package name */
    public int f49173e;

    /* loaded from: classes3.dex */
    public class a extends d.a.l0.a.g1.a {

        /* renamed from: d.a.l0.a.v2.v0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0945a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f49175e;

            public RunnableC0945a(Activity activity) {
                this.f49175e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Intent intent = this.f49175e.getIntent();
                d.a.l0.a.p.d.a0 n = d.a.l0.a.c1.a.n();
                ComponentName component = intent.getComponent();
                if (v0.this.f49171c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && n != null && component != null && TextUtils.equals(n.y(), component.getClassName())) {
                    if (v0.this.f49172d) {
                        if (v0.f49167f) {
                            Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                            return;
                        }
                        return;
                    }
                    d.a.l0.a.v2.c m = d.a.l0.a.v2.c.m();
                    if (d.a() && d.a.l0.a.v2.c.k()) {
                        u = m.w(this.f49175e, v0.this.f49173e, false);
                    } else {
                        u = m.u(v0.this.f49173e, false, false);
                    }
                    if (v0.f49167f) {
                        Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + u + ", taskId=" + v0.this.f49173e);
                    }
                    m.i();
                }
                if (v0.f49167f) {
                    Log.d("SwanHomeScreenLaunch", "class=" + this.f49175e + ", swanAppForeground=" + v0.this.f49171c + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                }
            }
        }

        public a() {
        }

        @Override // d.a.l0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (d.a.l0.a.v2.c.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC0945a runnableC0945a = new RunnableC0945a(activity);
                if (d.a()) {
                    runnableC0945a.run();
                } else {
                    q.i(runnableC0945a, "moveTaskToFront");
                }
            }
        }

        @Override // d.a.l0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            super.onActivityStarted(activity);
            v0 v0Var = v0.this;
            v0Var.f49171c = v0Var.f49171c && activity != null && activity.getTaskId() == v0.this.f49173e;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c {
        public b() {
        }

        @Override // d.a.l0.a.v2.v0.c
        public void a(boolean z, int i2) {
            if (z) {
                v0.this.f49171c = true;
                v0.this.f49173e = i2;
            } else if (v0.this.f49171c && i2 == 1) {
                v0.this.f49171c = false;
            }
            v0.this.f49172d = z;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z, int i2);
    }

    public v0(@NonNull Application application) {
        this.f49169a = application;
        f49168g = new b();
        application.registerActivityLifecycleCallbacks(this.f49170b);
    }

    public static void h(boolean z, int i2) {
        c cVar = f49168g;
        if (cVar != null) {
            cVar.a(z, i2);
        }
    }

    public void i() {
        f49168g = null;
        this.f49169a.unregisterActivityLifecycleCallbacks(this.f49170b);
    }
}
