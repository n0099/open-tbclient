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
/* loaded from: classes3.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f46262i = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppSlaveManager f46263a;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f46267e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.l1.b f46268f;

    /* renamed from: g  reason: collision with root package name */
    public String f46269g;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f46264b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f46265c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f46266d = false;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f46270h = false;

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
        this.f46263a = swanAppSlaveManager;
    }

    public void a() {
        q.c(new a(), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
    }

    public void b() {
        if (this.f46265c || this.f46270h) {
            return;
        }
        this.f46270h = true;
        d.a.l0.a.c1.a.e0().c(d.g().getAppId());
    }

    public void c() {
        if (this.f46265c) {
            SwanAppSlaveManager swanAppSlaveManager = this.f46263a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            h.e(this.f46269g, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O(), this.f46267e);
        }
    }

    public void d() {
        this.f46264b = true;
        if (this.f46263a instanceof SwanAppWebViewWidget) {
            return;
        }
        g();
    }

    public void e() {
        if (!(this.f46263a instanceof SwanAppWebViewWidget)) {
            f();
        }
        this.f46264b = false;
        this.f46267e = h.c();
        if (this.f46265c) {
            h.e(this.f46269g, "success", null, this.f46267e);
        }
    }

    public final void f() {
        this.f46266d = false;
        boolean b2 = h.b();
        boolean a2 = h.a();
        if (b2) {
            this.f46265c = false;
        } else if (this.f46264b) {
            this.f46265c = true;
            if (a2) {
                return;
            }
            h.g(this.f46269g);
            if (f46262i) {
                Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f46268f);
            }
        } else {
            this.f46265c = !TextUtils.isEmpty(this.f46263a.j0());
        }
    }

    public void g() {
        if (f46262i) {
            Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f46268f);
        }
        if (!this.f46265c || this.f46266d) {
            return;
        }
        this.f46266d = true;
        SwanAppSlaveManager swanAppSlaveManager = this.f46263a;
        SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
        d.a.l0.a.p.e.j.d O = swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O();
        if (O != null && O.f47676c > 0) {
            h.e(this.f46269g, "arrivesuccess", O, this.f46267e);
        } else {
            h.e(this.f46269g, "arrivecancel", O, this.f46267e);
        }
    }

    public void h(@NonNull d.a.l0.a.l1.b bVar) {
        this.f46268f = bVar;
        this.f46269g = bVar.f47033e;
    }
}
