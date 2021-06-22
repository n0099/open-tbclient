package d.a.m0.a.h0.s;

import android.content.Context;
import android.os.Process;
import android.webkit.WebView;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.webkit.sdk.CookieSyncManager;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import d.a.m0.a.k;
import d.a.m0.a.v2.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f46342h = k.f46983a;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f46343i;

    /* renamed from: a  reason: collision with root package name */
    public Context f46344a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f46345b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46346c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46347d = false;

    /* renamed from: e  reason: collision with root package name */
    public final Object f46348e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final Object f46349f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f46350g = new ArrayList<>();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46351e;

        public a(boolean z) {
            this.f46351e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            b.this.f(this.f46351e);
            b.this.f46345b = true;
            synchronized (b.this.f46349f) {
                b.this.f46347d = true;
                b.this.f46349f.notifyAll();
                b.this.l();
            }
        }
    }

    /* renamed from: d.a.m0.a.h0.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0757b implements Runnable {
        public RunnableC0757b(b bVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView.setWebContentsDebuggingEnabled(true);
            Log.setMinLogLevel(3, true);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    public b(Context context) {
        this.f46344a = context.getApplicationContext();
    }

    public static synchronized b g(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f46343i == null) {
                f46343i = new b(context);
            }
            bVar = f46343i;
        }
        return bVar;
    }

    public void e(c cVar) {
        synchronized (this.f46349f) {
            if (f46342h) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.f46350g.contains(cVar)) {
                this.f46350g.add(cVar);
            }
            if (this.f46347d) {
                l();
            }
        }
    }

    public final void f(boolean z) {
        WebKitFactory.setNeedDownloadCloudResource(false);
        WebKitFactory.setProcessType("1");
        com.baidu.webkit.sdk.WebView.setDataDirectorySuffix(ProcessUtils.getCurProcessName());
        BdSailor.getInstance().init(this.f46344a, null, null);
        if (f46342h) {
            q0.X(new RunnableC0757b(this));
        }
        BdSailor.getInstance().setWebkitEnable(!(f46342h && d.a.m0.a.u1.a.a.F().booleanValue()));
        BdSailor.getInstance().initWebkit("swan", false);
        BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
        if (BdZeusUtil.isWebkitLoaded()) {
            if (f46342h) {
                android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) success ^V^");
            }
        } else if (f46342h) {
            android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) fail !!!!");
        }
        CookieSyncManager.createInstance(this.f46344a);
        BdSailor.initCookieSyncManager(this.f46344a);
    }

    public void h() {
        i(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    public final void i(boolean z, boolean z2) {
        if (this.f46345b) {
            return;
        }
        synchronized (this.f46348e) {
            if (!this.f46346c) {
                Executors.newSingleThreadExecutor().execute(new a(z2));
                this.f46346c = true;
            }
        }
        if (z) {
            synchronized (this.f46349f) {
                while (!this.f46347d) {
                    try {
                        this.f46349f.wait(1000L);
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
        return this.f46345b;
    }

    public void l() {
        synchronized (this.f46349f) {
            if (f46342h) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<c> it = this.f46350g.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f46350g.clear();
        }
    }

    public void m() {
        if (k()) {
            BdSailor.getInstance().destroy();
        }
    }
}
