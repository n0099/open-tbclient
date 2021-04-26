package d.a.h0.a.e0.u;

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
import d.a.h0.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f42315h = k.f43101a;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f42316i;

    /* renamed from: a  reason: collision with root package name */
    public Context f42317a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f42318b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42319c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42320d = false;

    /* renamed from: e  reason: collision with root package name */
    public final Object f42321e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final Object f42322f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f42323g = new ArrayList<>();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f42324e;

        public a(boolean z) {
            this.f42324e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            b.this.g(this.f42324e);
            b.this.f42318b = true;
            synchronized (b.this.f42322f) {
                b.this.f42320d = true;
                b.this.f42322f.notifyAll();
                b.this.m();
            }
        }
    }

    /* renamed from: d.a.h0.a.e0.u.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0654b implements Runnable {
        public RunnableC0654b(b bVar) {
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
        this.f42317a = context.getApplicationContext();
    }

    public static synchronized b h(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f42316i == null) {
                f42316i = new b(context);
            }
            bVar = f42316i;
        }
        return bVar;
    }

    public void e(c cVar) {
        synchronized (this.f42322f) {
            if (f42315h) {
                android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
            }
            if (!this.f42323g.contains(cVar)) {
                this.f42323g.add(cVar);
            }
            if (this.f42320d) {
                m();
            }
        }
    }

    public void f(c cVar) {
        synchronized (this.f42322f) {
            boolean remove = this.f42323g.remove(cVar);
            if (f42315h) {
                android.util.Log.d("BlinkInitHelper", "delBlinkInitListener. listener: " + cVar + " ,isRemoved: " + remove);
            }
        }
    }

    public final void g(boolean z) {
        WebKitFactory.setNeedDownloadCloudResource(false);
        WebKitFactory.setProcessType("1");
        com.baidu.webkit.sdk.WebView.setDataDirectorySuffix(ProcessUtils.getCurProcessName());
        BdSailor.getInstance().init(this.f42317a, null, null);
        if (f42315h) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0654b(this));
        }
        BdSailor.getInstance().initWebkit("swan", false);
        BdSailor.getInstance().setWebkitEnable(true);
        BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
        if (BdZeusUtil.isWebkitLoaded()) {
            if (f42315h) {
                android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) success ^V^");
            }
        } else if (f42315h) {
            android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) fail !!!!");
        }
        CookieSyncManager.createInstance(this.f42317a);
        BdSailor.initCookieSyncManager(this.f42317a);
    }

    public void i() {
        j(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
    }

    public final void j(boolean z, boolean z2) {
        if (this.f42318b) {
            return;
        }
        synchronized (this.f42321e) {
            if (!this.f42319c) {
                Executors.newSingleThreadExecutor().execute(new a(z2));
                this.f42319c = true;
            }
        }
        if (z) {
            synchronized (this.f42322f) {
                while (!this.f42320d) {
                    try {
                        this.f42322f.wait(1000L);
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
        return this.f42318b;
    }

    public void m() {
        synchronized (this.f42322f) {
            if (f42315h) {
                android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
            }
            Iterator<c> it = this.f42323g.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f42323g.clear();
        }
    }

    public void n() {
        if (l()) {
            BdSailor.getInstance().destroy();
        }
    }
}
