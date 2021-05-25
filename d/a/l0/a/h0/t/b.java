package d.a.l0.a.h0.t;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import d.a.l0.a.a2.d;
import d.a.l0.a.j2.h;
import d.a.l0.a.k;
import d.a.l0.a.v2.q;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f42586i = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppSlaveManager f42587a;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f42591e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.l1.b f42592f;

    /* renamed from: g  reason: collision with root package name */
    public String f42593g;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f42588b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f42589c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f42590d = false;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f42594h = false;

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
        this.f42587a = swanAppSlaveManager;
    }

    public void a() {
        q.c(new a(), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
    }

    public void b() {
        if (this.f42589c || this.f42594h) {
            return;
        }
        this.f42594h = true;
        d.a.l0.a.c1.a.e0().c(d.g().getAppId());
    }

    public void c() {
        if (this.f42589c) {
            SwanAppSlaveManager swanAppSlaveManager = this.f42587a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            h.e(this.f42593g, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O(), this.f42591e);
        }
    }

    public void d() {
        this.f42588b = true;
        if (this.f42587a instanceof SwanAppWebViewWidget) {
            return;
        }
        g();
    }

    public void e() {
        if (!(this.f42587a instanceof SwanAppWebViewWidget)) {
            f();
        }
        this.f42588b = false;
        this.f42591e = h.c();
        if (this.f42589c) {
            h.e(this.f42593g, "success", null, this.f42591e);
        }
    }

    public final void f() {
        this.f42590d = false;
        boolean b2 = h.b();
        boolean a2 = h.a();
        if (b2) {
            this.f42589c = false;
        } else if (this.f42588b) {
            this.f42589c = true;
            if (a2) {
                return;
            }
            h.g(this.f42593g);
            if (f42586i) {
                Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f42592f);
            }
        } else {
            this.f42589c = !TextUtils.isEmpty(this.f42587a.j0());
        }
    }

    public void g() {
        if (f42586i) {
            Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f42592f);
        }
        if (!this.f42589c || this.f42590d) {
            return;
        }
        this.f42590d = true;
        SwanAppSlaveManager swanAppSlaveManager = this.f42587a;
        SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
        d.a.l0.a.p.e.j.d O = swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O();
        if (O != null && O.f44002c > 0) {
            h.e(this.f42593g, "arrivesuccess", O, this.f42591e);
        } else {
            h.e(this.f42593g, "arrivecancel", O, this.f42591e);
        }
    }

    public void h(@NonNull d.a.l0.a.l1.b bVar) {
        this.f42592f = bVar;
        this.f42593g = bVar.f43357e;
    }
}
