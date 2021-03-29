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
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f44289h = k.f45051a;
    public static volatile b i;

    /* renamed from: a  reason: collision with root package name */
    public Context f44290a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f44291b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44292c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44293d = false;

    /* renamed from: e  reason: collision with root package name */
    public final Object f44294e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final Object f44295f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f44296g = new ArrayList<>();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44297e;

        public a(boolean z) {
            this.f44297e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            b.this.g(this.f44297e);
            b.this.f44291b = true;
            synchronized (b.this.f44295f) {
                b.this.f44293d = true;
                b.this.f44295f.notifyAll();
                b.this.m();
            }
        }
    }

    /* renamed from: d.b.g0.a.e0.u.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0683b implements Runnable {
        public RunnableC0683b(b bVar) {
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
        this.f44290a = context.getApplicationContext();
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
        synchronized (this.f44295f) {
            if (f44289h) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.f44296g.contains(cVar)) {
                this.f44296g.add(cVar);
            }
            if (this.f44293d) {
                m();
            }
        }
    }

    public void f(c cVar) {
        synchronized (this.f44295f) {
            boolean remove = this.f44296g.remove(cVar);
            if (f44289h) {
                android.util.Log.d("BlinkInitHelper", "delBlinkInitListener. listener: " + cVar + " ,isRemoved: " + remove);
            }
        }
    }

    public final void g(boolean z) {
        WebKitFactory.setNeedDownloadCloudResource(false);
        WebKitFactory.setProcessType("1");
        com.baidu.webkit.sdk.WebView.setDataDirectorySuffix(ProcessUtils.getCurProcessName());
        BdSailor.getInstance().init(this.f44290a, null, null);
        if (f44289h) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0683b(this));
        }
        BdSailor.getInstance().initWebkit("swan", false);
        BdSailor.getInstance().setWebkitEnable(true);
        BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
        if (BdZeusUtil.isWebkitLoaded()) {
            if (f44289h) {
                android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) success ^V^");
            }
        } else if (f44289h) {
            android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) fail !!!!");
        }
        CookieSyncManager.createInstance(this.f44290a);
        BdSailor.initCookieSyncManager(this.f44290a);
    }

    public void i() {
        j(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    public final void j(boolean z, boolean z2) {
        if (this.f44291b) {
            return;
        }
        synchronized (this.f44294e) {
            if (!this.f44292c) {
                Executors.newSingleThreadExecutor().execute(new a(z2));
                this.f44292c = true;
            }
        }
        if (z) {
            synchronized (this.f44295f) {
                while (!this.f44293d) {
                    try {
                        this.f44295f.wait(1000L);
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
        return this.f44291b;
    }

    public void m() {
        synchronized (this.f44295f) {
            if (f44289h) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<c> it = this.f44296g.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f44296g.clear();
        }
    }

    public void n() {
        if (l()) {
            BdSailor.getInstance().destroy();
        }
    }
}
