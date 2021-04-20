package d.b.g0.e.a.l.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import d.b.g0.e.a.l.e;
import d.b.g0.e.a.l.g.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public final class a implements d.b.g0.e.a.l.i.c, c.a {
    public static a k;

    /* renamed from: a  reason: collision with root package name */
    public long f47976a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f47977b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f47978c;

    /* renamed from: d  reason: collision with root package name */
    public final List<DownloadInfo> f47979d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f47980e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.g0.e.a.l.i.d f47981f;

    /* renamed from: g  reason: collision with root package name */
    public final d.b.g0.e.a.l.i.a f47982g;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.g0.e.a.l.f.a f47983h;
    public ConcurrentHashMap<Uri, BroadcastReceiver> i = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Uri, Timer> j = new ConcurrentHashMap<>();

    /* renamed from: d.b.g0.e.a.l.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0942a extends BroadcastReceiver {
        public final /* synthetic */ d val$listener;
        public final /* synthetic */ String val$packageName;
        public final /* synthetic */ Uri val$uri;

        public C0942a(String str, d dVar, Uri uri) {
            this.val$packageName = str;
            this.val$listener = dVar;
            this.val$uri = uri;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String dataString = intent.getDataString();
            if (dataString == null || !dataString.endsWith(this.val$packageName)) {
                return;
            }
            this.val$listener.a(Boolean.TRUE);
            a.this.l(context, this.val$uri);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f47984e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f47985f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Uri f47986g;

        public b(d dVar, Context context, Uri uri) {
            this.f47984e = dVar;
            this.f47985f = context;
            this.f47986g = uri;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f47984e.a(Boolean.FALSE);
            a.this.l(this.f47985f, this.f47986g);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Timer f47988e;

        public c(Timer timer) {
            this.f47988e = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            for (Map.Entry entry : a.this.i.entrySet()) {
                a aVar = a.this;
                aVar.l(aVar.f47980e, (Uri) entry.getKey());
            }
            this.f47988e.cancel();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d<T> {
        public void a(T t) {
        }
    }

    public a(Context context, d.b.g0.e.a.l.f.a aVar) {
        this.f47980e = context;
        if (aVar == null) {
            this.f47983h = new d.b.g0.e.a.l.f.a();
        } else {
            this.f47983h = aVar;
        }
        if (this.f47983h.a() == null) {
            this.f47982g = new d.b.g0.e.a.l.h.a(context, this.f47983h);
        } else {
            this.f47982g = this.f47983h.a();
        }
        this.f47979d = new ArrayList();
        this.f47978c = new ConcurrentHashMap<>();
        this.f47982g.d();
        this.f47977b = Executors.newFixedThreadPool(this.f47983h.b());
        this.f47981f = new d.b.g0.e.a.l.g.b(this.f47982g);
    }

    public static d.b.g0.e.a.l.i.c m(Context context, d.b.g0.e.a.l.f.a aVar) {
        synchronized (a.class) {
            if (k == null) {
                k = new a(context, aVar);
            }
        }
        return k;
    }

    @Override // d.b.g0.e.a.l.i.c
    public void a(DownloadInfo downloadInfo) {
        if (n()) {
            p(downloadInfo);
        }
    }

    @Override // d.b.g0.e.a.l.i.c
    public void b(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DELETED.value());
        this.f47978c.remove(downloadInfo.getId());
        this.f47979d.remove(downloadInfo);
        this.f47982g.c(downloadInfo);
        this.f47981f.b(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // d.b.g0.e.a.l.i.c
    public void c(DownloadInfo downloadInfo) {
        this.f47979d.add(downloadInfo);
        p(downloadInfo);
    }

    @Override // d.b.g0.e.a.l.i.c
    public void d(DownloadInfo downloadInfo) {
        if (n()) {
            o(downloadInfo);
        }
    }

    @Override // d.b.g0.e.a.l.i.c
    public void destroy() {
        k();
        ExecutorService executorService = this.f47977b;
        if (executorService != null) {
            executorService.shutdownNow();
            this.f47977b = null;
        }
        k = null;
    }

    @Override // d.b.g0.e.a.l.g.c.a
    public void e(DownloadInfo downloadInfo) {
        e.c(downloadInfo.getPath(), false);
        this.f47978c.remove(downloadInfo.getId());
        this.f47979d.remove(downloadInfo);
        q();
    }

    @Override // d.b.g0.e.a.l.i.c
    @AnyThread
    public void f(@NonNull String str, @NonNull Uri uri, @NonNull d<Boolean> dVar) {
        Context appContext = AppRuntime.getAppContext();
        if (e.a(appContext, str)) {
            dVar.a(Boolean.TRUE);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        C0942a c0942a = new C0942a(str, dVar, uri);
        appContext.registerReceiver(c0942a, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new b(dVar, appContext, uri), 60000L);
        this.i.put(uri, c0942a);
        this.j.put(uri, timer);
    }

    @Override // d.b.g0.e.a.l.i.c
    public DownloadInfo g(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.f47979d.iterator();
        while (true) {
            if (!it.hasNext()) {
                downloadInfo = null;
                break;
            }
            downloadInfo = it.next();
            if (downloadInfo.getId().equals(str)) {
                break;
            }
        }
        return downloadInfo == null ? this.f47982g.b(str) : downloadInfo;
    }

    public final void k() {
        Timer timer = new Timer();
        timer.schedule(new c(timer), 60000L);
    }

    public final void l(Context context, Uri uri) {
        BroadcastReceiver remove = this.i.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.j.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    public boolean n() {
        if (System.currentTimeMillis() - this.f47976a > 500) {
            this.f47976a = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public final void o(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.f47978c.remove(downloadInfo.getId());
        this.f47981f.b(downloadInfo);
        q();
    }

    public final void p(DownloadInfo downloadInfo) {
        if (this.f47978c.size() >= this.f47983h.b()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.f47981f.b(downloadInfo);
            return;
        }
        d.b.g0.e.a.l.g.c cVar = new d.b.g0.e.a.l.g.c(this.f47977b, this.f47981f, downloadInfo, this);
        this.f47978c.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.f47981f.b(downloadInfo);
        cVar.c();
    }

    public final void q() {
        for (DownloadInfo downloadInfo : this.f47979d) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                p(downloadInfo);
                return;
            }
        }
    }
}
