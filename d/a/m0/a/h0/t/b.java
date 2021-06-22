package d.a.m0.a.h0.t;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import d.a.m0.a.a2.d;
import d.a.m0.a.j2.h;
import d.a.m0.a.k;
import d.a.m0.a.v2.q;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f46370i = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppSlaveManager f46371a;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f46375e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.a.l1.b f46376f;

    /* renamed from: g  reason: collision with root package name */
    public String f46377g;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f46372b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f46373c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f46374d = false;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f46378h = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b();
        }
    }

    public b(@NonNull SwanAppSlaveManager swanAppSlaveManager) {
        this.f46371a = swanAppSlaveManager;
    }

    public void a() {
        q.c(new a(), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
    }

    public void b() {
        if (this.f46373c || this.f46378h) {
            return;
        }
        this.f46378h = true;
        d.a.m0.a.c1.a.e0().c(d.g().getAppId());
    }

    public void c() {
        if (this.f46373c) {
            SwanAppSlaveManager swanAppSlaveManager = this.f46371a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            h.e(this.f46377g, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O(), this.f46375e);
        }
    }

    public void d() {
        this.f46372b = true;
        if (this.f46371a instanceof SwanAppWebViewWidget) {
            return;
        }
        g();
    }

    public void e() {
        if (!(this.f46371a instanceof SwanAppWebViewWidget)) {
            f();
        }
        this.f46372b = false;
        this.f46375e = h.c();
        if (this.f46373c) {
            h.e(this.f46377g, "success", null, this.f46375e);
        }
    }

    public final void f() {
        this.f46374d = false;
        boolean b2 = h.b();
        boolean a2 = h.a();
        if (b2) {
            this.f46373c = false;
        } else if (this.f46372b) {
            this.f46373c = true;
            if (a2) {
                return;
            }
            h.g(this.f46377g);
            if (f46370i) {
                Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f46376f);
            }
        } else {
            this.f46373c = !TextUtils.isEmpty(this.f46371a.j0());
        }
    }

    public void g() {
        if (f46370i) {
            Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f46376f);
        }
        if (!this.f46373c || this.f46374d) {
            return;
        }
        this.f46374d = true;
        SwanAppSlaveManager swanAppSlaveManager = this.f46371a;
        SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
        d.a.m0.a.p.e.j.d O = swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O();
        if (O != null && O.f47784c > 0) {
            h.e(this.f46377g, "arrivesuccess", O, this.f46375e);
        } else {
            h.e(this.f46377g, "arrivecancel", O, this.f46375e);
        }
    }

    public void h(@NonNull d.a.m0.a.l1.b bVar) {
        this.f46376f = bVar;
        this.f46377g = bVar.f47141e;
    }
}
