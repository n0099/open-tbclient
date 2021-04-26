package d.a.h0.a.j0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import d.a.h0.a.c0.b;
import d.a.h0.a.i2.o0;
import d.a.h0.a.j0.c;
import d.a.h0.a.k;
import d.a.h0.a.p.c.k0;
import d.a.h0.a.p.c.l;
/* loaded from: classes2.dex */
public final class e implements c.InterfaceC0676c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42847c = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.a.j0.c f42848a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f42849b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k0 f42850e;

        public a(e eVar, k0 k0Var) {
            this.f42850e = k0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42850e.b();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f42851e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f42852f;

        public b(int i2, Bundle bundle) {
            this.f42851e = i2;
            this.f42852f = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.f42847c) {
                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + this.f42851e);
            }
            d.a.h0.a.n1.c.f.b.i(e.this.a(), this.f42852f);
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final e f42854a = new e(null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e c() {
        return c.f42854a;
    }

    @Override // d.a.h0.a.j0.b
    @NonNull
    public Context a() {
        return AppRuntime.getAppContext();
    }

    public d.a.h0.a.j0.c d() {
        return this.f42848a;
    }

    public void e(Bundle bundle) {
        if (this.f42849b) {
            return;
        }
        synchronized (this) {
            if (!this.f42849b) {
                f(bundle);
                this.f42849b = true;
            }
        }
    }

    public final void f(Bundle bundle) {
        g(bundle);
        SwanLauncher.j().l(null);
        b.C0590b.e();
        o0.a();
        ExecutorUtilsExt.postOnElastic(new a(this, d.a.h0.a.w0.a.W()), "requestBatchRebateInfo", 2);
    }

    public final void g(Bundle bundle) {
        if (f42847c) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        l f2 = d.a.h0.a.w0.a.f();
        if (f2 == null) {
            return;
        }
        int a2 = f2.a();
        if (f42847c) {
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
            if (f42847c) {
                Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + a2);
            }
            d.a.h0.a.i2.k0.U(new b(a2, bundle), d.a.h0.a.w0.a.f().c());
            return;
        }
        if (f42847c) {
            Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + a2);
        }
        d.a.h0.a.n1.c.f.b.i(a(), bundle);
    }

    public e() {
        this.f42849b = false;
        this.f42848a = new d.a.h0.a.j0.c(this);
        d.a.h0.a.l0.f.a.d().f();
    }
}
