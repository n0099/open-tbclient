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
    public static final boolean f42558h = k.f43199a;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f42559i;

    /* renamed from: a  reason: collision with root package name */
    public Context f42560a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f42561b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42562c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42563d = false;

    /* renamed from: e  reason: collision with root package name */
    public final Object f42564e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final Object f42565f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f42566g = new ArrayList<>();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f42567e;

        public a(boolean z) {
            this.f42567e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            b.this.f(this.f42567e);
            b.this.f42561b = true;
            synchronized (b.this.f42565f) {
                b.this.f42563d = true;
                b.this.f42565f.notifyAll();
                b.this.l();
            }
        }
    }

    /* renamed from: d.a.l0.a.h0.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0698b implements Runnable {
        public RunnableC0698b(b bVar) {
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
        this.f42560a = context.getApplicationContext();
    }

    public static synchronized b g(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f42559i == null) {
                f42559i = new b(context);
            }
            bVar = f42559i;
        }
        return bVar;
    }

    public void e(c cVar) {
        synchronized (this.f42565f) {
            if (f42558h) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.f42566g.contains(cVar)) {
                this.f42566g.add(cVar);
            }
            if (this.f42563d) {
                l();
            }
        }
    }

    public final void f(boolean z) {
        WebKitFactory.setNeedDownloadCloudResource(false);
        WebKitFactory.setProcessType("1");
        com.baidu.webkit.sdk.WebView.setDataDirectorySuffix(ProcessUtils.getCurProcessName());
        BdSailor.getInstance().init(this.f42560a, null, null);
        if (f42558h) {
            q0.X(new RunnableC0698b(this));
        }
        BdSailor.getInstance().setWebkitEnable(!(f42558h && d.a.l0.a.u1.a.a.F().booleanValue()));
        BdSailor.getInstance().initWebkit("swan", false);
        BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
        if (BdZeusUtil.isWebkitLoaded()) {
            if (f42558h) {
                android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) success ^V^");
            }
        } else if (f42558h) {
            android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) fail !!!!");
        }
        CookieSyncManager.createInstance(this.f42560a);
        BdSailor.initCookieSyncManager(this.f42560a);
    }

    public void h() {
        i(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    public final void i(boolean z, boolean z2) {
        if (this.f42561b) {
            return;
        }
        synchronized (this.f42564e) {
            if (!this.f42562c) {
                Executors.newSingleThreadExecutor().execute(new a(z2));
                this.f42562c = true;
            }
        }
        if (z) {
            synchronized (this.f42565f) {
                while (!this.f42563d) {
                    try {
                        this.f42565f.wait(1000L);
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
        return this.f42561b;
    }

    public void l() {
        synchronized (this.f42565f) {
            if (f42558h) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<c> it = this.f42566g.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f42566g.clear();
        }
    }

    public void m() {
        if (k()) {
            BdSailor.getInstance().destroy();
        }
    }
}
