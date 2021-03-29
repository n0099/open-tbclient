package d.b.g0.a.j0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import d.b.g0.a.c0.b;
import d.b.g0.a.i2.o0;
import d.b.g0.a.j0.c;
import d.b.g0.a.k;
import d.b.g0.a.p.c.k0;
import d.b.g0.a.p.c.l;
/* loaded from: classes2.dex */
public final class e implements c.InterfaceC0705c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44805c = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.j0.c f44806a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f44807b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k0 f44808e;

        public a(e eVar, k0 k0Var) {
            this.f44808e = k0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44808e.a();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f44809e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f44810f;

        public b(int i, Bundle bundle) {
            this.f44809e = i;
            this.f44810f = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.f44805c) {
                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + this.f44809e);
            }
            d.b.g0.a.n1.c.f.b.i(e.this.a(), this.f44810f);
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final e f44812a = new e(null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e c() {
        return c.f44812a;
    }

    @Override // d.b.g0.a.j0.b
    @NonNull
    public Context a() {
        return AppRuntime.getAppContext();
    }

    public d.b.g0.a.j0.c d() {
        return this.f44806a;
    }

    public void e(Bundle bundle) {
        if (this.f44807b) {
            return;
        }
        synchronized (this) {
            if (!this.f44807b) {
                f(bundle);
                this.f44807b = true;
            }
        }
    }

    public final void f(Bundle bundle) {
        g(bundle);
        SwanLauncher.j().l(null);
        b.C0619b.e();
        o0.a();
        ExecutorUtilsExt.postOnElastic(new a(this, d.b.g0.a.w0.a.W()), "requestBatchRebateInfo", 2);
    }

    public final void g(Bundle bundle) {
        if (f44805c) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        l f2 = d.b.g0.a.w0.a.f();
        if (f2 == null) {
            return;
        }
        int b2 = f2.b();
        if (f44805c) {
            Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + b2);
        }
        if (f2.d()) {
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
            bundle.putString("bundle_key_preload_preload_scene", "0");
        }
        if (bundle.getBoolean("bundle_key_preload_delay", false) && f2.f()) {
            if (f44805c) {
                Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + b2);
            }
            d.b.g0.a.i2.k0.U(new b(b2, bundle), d.b.g0.a.w0.a.f().e());
            return;
        }
        if (f44805c) {
            Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + b2);
        }
        d.b.g0.a.n1.c.f.b.i(a(), bundle);
    }

    public e() {
        this.f44807b = false;
        this.f44806a = new d.b.g0.a.j0.c(this);
        d.b.g0.a.l0.f.a.d().f();
    }
}
