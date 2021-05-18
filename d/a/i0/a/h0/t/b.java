package d.a.i0.a.h0.t;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import d.a.i0.a.a2.d;
import d.a.i0.a.j2.h;
import d.a.i0.a.k;
import d.a.i0.a.v2.q;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f42412i = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppSlaveManager f42413a;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f42417e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.a.l1.b f42418f;

    /* renamed from: g  reason: collision with root package name */
    public String f42419g;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f42414b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f42415c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f42416d = false;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f42420h = false;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b();
        }
    }

    public b(@NonNull SwanAppSlaveManager swanAppSlaveManager) {
        this.f42413a = swanAppSlaveManager;
    }

    public void a() {
        q.c(new a(), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
    }

    public void b() {
        if (this.f42415c || this.f42420h) {
            return;
        }
        this.f42420h = true;
        d.a.i0.a.c1.a.e0().c(d.g().getAppId());
    }

    public void c() {
        if (this.f42415c) {
            SwanAppSlaveManager swanAppSlaveManager = this.f42413a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            h.e(this.f42419g, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O(), this.f42417e);
        }
    }

    public void d() {
        this.f42414b = true;
        if (this.f42413a instanceof SwanAppWebViewWidget) {
            return;
        }
        g();
    }

    public void e() {
        if (!(this.f42413a instanceof SwanAppWebViewWidget)) {
            f();
        }
        this.f42414b = false;
        this.f42417e = h.c();
        if (this.f42415c) {
            h.e(this.f42419g, "success", null, this.f42417e);
        }
    }

    public final void f() {
        this.f42416d = false;
        boolean b2 = h.b();
        boolean a2 = h.a();
        if (b2) {
            this.f42415c = false;
        } else if (this.f42414b) {
            this.f42415c = true;
            if (a2) {
                return;
            }
            h.g(this.f42419g);
            if (f42412i) {
                Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f42418f);
            }
        } else {
            this.f42415c = !TextUtils.isEmpty(this.f42413a.j0());
        }
    }

    public void g() {
        if (f42412i) {
            Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f42418f);
        }
        if (!this.f42415c || this.f42416d) {
            return;
        }
        this.f42416d = true;
        SwanAppSlaveManager swanAppSlaveManager = this.f42413a;
        SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
        d.a.i0.a.p.e.j.d O = swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O();
        if (O != null && O.f43826c > 0) {
            h.e(this.f42419g, "arrivesuccess", O, this.f42417e);
        } else {
            h.e(this.f42419g, "arrivecancel", O, this.f42417e);
        }
    }

    public void h(@NonNull d.a.i0.a.l1.b bVar) {
        this.f42418f = bVar;
        this.f42419g = bVar.f43183e;
    }
}
