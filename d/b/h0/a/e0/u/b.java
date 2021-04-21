package d.b.h0.a.e0.u;

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
import d.b.h0.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f45010h = k.f45772a;
    public static volatile b i;

    /* renamed from: a  reason: collision with root package name */
    public Context f45011a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f45012b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45013c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45014d = false;

    /* renamed from: e  reason: collision with root package name */
    public final Object f45015e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final Object f45016f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f45017g = new ArrayList<>();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f45018e;

        public a(boolean z) {
            this.f45018e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            b.this.g(this.f45018e);
            b.this.f45012b = true;
            synchronized (b.this.f45016f) {
                b.this.f45014d = true;
                b.this.f45016f.notifyAll();
                b.this.m();
            }
        }
    }

    /* renamed from: d.b.h0.a.e0.u.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0715b implements Runnable {
        public RunnableC0715b(b bVar) {
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
        this.f45011a = context.getApplicationContext();
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
        synchronized (this.f45016f) {
            if (f45010h) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.f45017g.contains(cVar)) {
                this.f45017g.add(cVar);
            }
            if (this.f45014d) {
                m();
            }
        }
    }

    public void f(c cVar) {
        synchronized (this.f45016f) {
            boolean remove = this.f45017g.remove(cVar);
            if (f45010h) {
                android.util.Log.d("BlinkInitHelper", "delBlinkInitListener. listener: " + cVar + " ,isRemoved: " + remove);
            }
        }
    }

    public final void g(boolean z) {
        WebKitFactory.setNeedDownloadCloudResource(false);
        WebKitFactory.setProcessType("1");
        com.baidu.webkit.sdk.WebView.setDataDirectorySuffix(ProcessUtils.getCurProcessName());
        BdSailor.getInstance().init(this.f45011a, null, null);
        if (f45010h) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0715b(this));
        }
        BdSailor.getInstance().initWebkit("swan", false);
        BdSailor.getInstance().setWebkitEnable(true);
        BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
        if (BdZeusUtil.isWebkitLoaded()) {
            if (f45010h) {
                android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) success ^V^");
            }
        } else if (f45010h) {
            android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) fail !!!!");
        }
        CookieSyncManager.createInstance(this.f45011a);
        BdSailor.initCookieSyncManager(this.f45011a);
    }

    public void i() {
        j(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    public final void j(boolean z, boolean z2) {
        if (this.f45012b) {
            return;
        }
        synchronized (this.f45015e) {
            if (!this.f45013c) {
                Executors.newSingleThreadExecutor().execute(new a(z2));
                this.f45013c = true;
            }
        }
        if (z) {
            synchronized (this.f45016f) {
                while (!this.f45014d) {
                    try {
                        this.f45016f.wait(1000L);
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
        return this.f45012b;
    }

    public void m() {
        synchronized (this.f45016f) {
            if (f45010h) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<c> it = this.f45017g.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f45017g.clear();
        }
    }

    public void n() {
        if (l()) {
            BdSailor.getInstance().destroy();
        }
    }
}
