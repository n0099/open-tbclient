package d.b.g0.a.e0.u;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.webkit.WebView;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.webkit.sdk.CookieSyncManager;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f44288h = k.f45050a;
    public static volatile b i;

    /* renamed from: a  reason: collision with root package name */
    public Context f44289a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f44290b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44291c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44292d = false;

    /* renamed from: e  reason: collision with root package name */
    public final Object f44293e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final Object f44294f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f44295g = new ArrayList<>();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44296e;

        public a(boolean z) {
            this.f44296e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            b.this.g(this.f44296e);
            b.this.f44290b = true;
            synchronized (b.this.f44294f) {
                b.this.f44292d = true;
                b.this.f44294f.notifyAll();
                b.this.m();
            }
        }
    }

    /* renamed from: d.b.g0.a.e0.u.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0682b implements Runnable {
        public RunnableC0682b(b bVar) {
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
        this.f44289a = context.getApplicationContext();
    }

    public static synchronized b h(Context context) {
        b bVar;
        synchronized (b.class) {
            if (i == null) {
                i = new b(context);
            }
            bVar = i;
        }
        return bVar;
    }

    public void e(c cVar) {
        synchronized (this.f44294f) {
            if (f44288h) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.f44295g.contains(cVar)) {
                this.f44295g.add(cVar);
            }
            if (this.f44292d) {
                m();
            }
        }
    }

    public void f(c cVar) {
        synchronized (this.f44294f) {
            boolean remove = this.f44295g.remove(cVar);
            if (f44288h) {
                android.util.Log.d("BlinkInitHelper", "delBlinkInitListener. listener: " + cVar + " ,isRemoved: " + remove);
            }
        }
    }

    public final void g(boolean z) {
        WebKitFactory.setNeedDownloadCloudResource(false);
        WebKitFactory.setProcessType("1");
        com.baidu.webkit.sdk.WebView.setDataDirectorySuffix(ProcessUtils.getCurProcessName());
        BdSailor.getInstance().init(this.f44289a, null, null);
        if (f44288h) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0682b(this));
        }
        BdSailor.getInstance().initWebkit("swan", false);
        BdSailor.getInstance().setWebkitEnable(true);
        BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
        if (BdZeusUtil.isWebkitLoaded()) {
            if (f44288h) {
                android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) success ^V^");
            }
        } else if (f44288h) {
            android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) fail !!!!");
        }
        CookieSyncManager.createInstance(this.f44289a);
        BdSailor.initCookieSyncManager(this.f44289a);
    }

    public void i() {
        j(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    public final void j(boolean z, boolean z2) {
        if (this.f44290b) {
            return;
        }
        synchronized (this.f44293e) {
            if (!this.f44291c) {
                Executors.newSingleThreadExecutor().execute(new a(z2));
                this.f44291c = true;
            }
        }
        if (z) {
            synchronized (this.f44294f) {
                while (!this.f44292d) {
                    try {
                        this.f44294f.wait(1000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void k(boolean z) {
        j(false, z);
    }

    public boolean l() {
        return this.f44290b;
    }

    public void m() {
        synchronized (this.f44294f) {
            if (f44288h) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<c> it = this.f44295g.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f44295g.clear();
        }
    }

    public void n() {
        if (l()) {
            BdSailor.getInstance().destroy();
        }
    }
}
