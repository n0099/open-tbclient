package d.a.l0.a.n0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import d.a.l0.a.e0.b;
import d.a.l0.a.k;
import d.a.l0.a.n0.d;
import d.a.l0.a.p.d.t;
import d.a.l0.a.p.d.v0;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.w0;
/* loaded from: classes2.dex */
public final class f implements d.InterfaceC0759d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f43588c = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public d f43589a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f43590b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v0 f43591e;

        public a(f fVar, v0 v0Var) {
            this.f43591e = v0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43591e.b();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43592e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f43593f;

        public b(int i2, Bundle bundle) {
            this.f43592e = i2;
            this.f43593f = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.f43588c) {
                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + this.f43592e);
            }
            d.a.l0.a.v1.c.f.b.k(f.this.a(), this.f43593f);
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final f f43595a = new f(null);
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f c() {
        return c.f43595a;
    }

    @Override // d.a.l0.a.n0.b
    @NonNull
    public Context a() {
        return AppRuntime.getAppContext();
    }

    public d d() {
        return this.f43589a;
    }

    public void e(Bundle bundle) {
        if (this.f43590b) {
            return;
        }
        synchronized (this) {
            if (!this.f43590b) {
                f(bundle);
                this.f43590b = true;
            }
        }
    }

    public final void f(Bundle bundle) {
        g(bundle);
        SwanLauncher.j().l(null);
        b.C0597b.e();
        w0.a();
        ExecutorUtilsExt.postOnElastic(new a(this, d.a.l0.a.c1.a.j0()), "requestBatchRebateInfo", 2);
    }

    public final void g(Bundle bundle) {
        if (f43588c) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        t f2 = d.a.l0.a.c1.a.f();
        if (f2 == null) {
            return;
        }
        int a2 = f2.a();
        if (f43588c) {
            Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + a2);
        }
        if (f2.e()) {
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
            bundle.putString("bundle_key_preload_preload_scene", "0");
        }
        if (bundle.getBoolean("bundle_key_preload_delay", false) && f2.f()) {
            if (f43588c) {
                Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + a2);
            }
            q0.Y(new b(a2, bundle), d.a.l0.a.c1.a.f().c());
            return;
        }
        if (f43588c) {
            Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + a2);
        }
        d.a.l0.a.v1.c.f.b.k(a(), bundle);
    }

    public f() {
        this.f43590b = false;
        this.f43589a = new d(this);
        d.a.l0.a.p0.e.a.d().f();
    }
}
