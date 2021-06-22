package d.a.m0.a.n0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import d.a.m0.a.e0.b;
import d.a.m0.a.k;
import d.a.m0.a.n0.d;
import d.a.m0.a.p.d.t;
import d.a.m0.a.p.d.v0;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.w0;
/* loaded from: classes3.dex */
public final class f implements d.InterfaceC0818d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47372c = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public d f47373a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f47374b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v0 f47375e;

        public a(f fVar, v0 v0Var) {
            this.f47375e = v0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47375e.b();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f47376e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f47377f;

        public b(int i2, Bundle bundle) {
            this.f47376e = i2;
            this.f47377f = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.f47372c) {
                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + this.f47376e);
            }
            d.a.m0.a.v1.c.f.b.k(f.this.a(), this.f47377f);
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final f f47379a = new f(null);
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f c() {
        return c.f47379a;
    }

    @Override // d.a.m0.a.n0.b
    @NonNull
    public Context a() {
        return AppRuntime.getAppContext();
    }

    public d d() {
        return this.f47373a;
    }

    public void e(Bundle bundle) {
        if (this.f47374b) {
            return;
        }
        synchronized (this) {
            if (!this.f47374b) {
                f(bundle);
                this.f47374b = true;
            }
        }
    }

    public final void f(Bundle bundle) {
        g(bundle);
        SwanLauncher.j().l(null);
        b.C0656b.e();
        w0.a();
        ExecutorUtilsExt.postOnElastic(new a(this, d.a.m0.a.c1.a.j0()), "requestBatchRebateInfo", 2);
    }

    public final void g(Bundle bundle) {
        if (f47372c) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        t f2 = d.a.m0.a.c1.a.f();
        if (f2 == null) {
            return;
        }
        int a2 = f2.a();
        if (f47372c) {
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
            if (f47372c) {
                Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + a2);
            }
            q0.Y(new b(a2, bundle), d.a.m0.a.c1.a.f().c());
            return;
        }
        if (f47372c) {
            Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + a2);
        }
        d.a.m0.a.v1.c.f.b.k(a(), bundle);
    }

    public f() {
        this.f47374b = false;
        this.f47373a = new d(this);
        d.a.m0.a.p0.e.a.d().f();
    }
}
