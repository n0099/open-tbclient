package d.a.l0.a.h0.s;

import android.content.Context;
import android.os.Process;
import android.webkit.WebView;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.webkit.sdk.CookieSyncManager;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f46234h = k.f46875a;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f46235i;

    /* renamed from: a  reason: collision with root package name */
    public Context f46236a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f46237b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46238c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46239d = false;

    /* renamed from: e  reason: collision with root package name */
    public final Object f46240e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final Object f46241f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f46242g = new ArrayList<>();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46243e;

        public a(boolean z) {
            this.f46243e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            b.this.f(this.f46243e);
            b.this.f46237b = true;
            synchronized (b.this.f46241f) {
                b.this.f46239d = true;
                b.this.f46241f.notifyAll();
                b.this.l();
            }
        }
    }

    /* renamed from: d.a.l0.a.h0.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0754b implements Runnable {
        public RunnableC0754b(b bVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView.setWebContentsDebuggingEnabled(true);
            Log.setMinLogLevel(3, true);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a();
    }

    public b(Context context) {
        this.f46236a = context.getApplicationContext();
    }

    public static synchronized b g(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f46235i == null) {
                f46235i = new b(context);
            }
            bVar = f46235i;
        }
        return bVar;
    }

    public void e(c cVar) {
        synchronized (this.f46241f) {
            if (f46234h) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.f46242g.contains(cVar)) {
                this.f46242g.add(cVar);
            }
            if (this.f46239d) {
                l();
            }
        }
    }

    public final void f(boolean z) {
        WebKitFactory.setNeedDownloadCloudResource(false);
        WebKitFactory.setProcessType("1");
        com.baidu.webkit.sdk.WebView.setDataDirectorySuffix(ProcessUtils.getCurProcessName());
        BdSailor.getInstance().init(this.f46236a, null, null);
        if (f46234h) {
            q0.X(new RunnableC0754b(this));
        }
        BdSailor.getInstance().setWebkitEnable(!(f46234h && d.a.l0.a.u1.a.a.F().booleanValue()));
        BdSailor.getInstance().initWebkit("swan", false);
        BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
        if (BdZeusUtil.isWebkitLoaded()) {
            if (f46234h) {
                android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) success ^V^");
            }
        } else if (f46234h) {
            android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) fail !!!!");
        }
        CookieSyncManager.createInstance(this.f46236a);
        BdSailor.initCookieSyncManager(this.f46236a);
    }

    public void h() {
        i(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    public final void i(boolean z, boolean z2) {
        if (this.f46237b) {
            return;
        }
        synchronized (this.f46240e) {
            if (!this.f46238c) {
                Executors.newSingleThreadExecutor().execute(new a(z2));
                this.f46238c = true;
            }
        }
        if (z) {
            synchronized (this.f46241f) {
                while (!this.f46239d) {
                    try {
                        this.f46241f.wait(1000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void j(boolean z) {
        i(false, z);
    }

    public boolean k() {
        return this.f46237b;
    }

    public void l() {
        synchronized (this.f46241f) {
            if (f46234h) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<c> it = this.f46242g.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f46242g.clear();
        }
    }

    public void m() {
        if (k()) {
            BdSailor.getInstance().destroy();
        }
    }
}
