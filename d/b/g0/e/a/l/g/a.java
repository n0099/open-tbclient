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
    public long f47583a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f47584b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f47585c;

    /* renamed from: d  reason: collision with root package name */
    public final List<DownloadInfo> f47586d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f47587e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.g0.e.a.l.i.d f47588f;

    /* renamed from: g  reason: collision with root package name */
    public final d.b.g0.e.a.l.i.a f47589g;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.g0.e.a.l.f.a f47590h;
    public ConcurrentHashMap<Uri, BroadcastReceiver> i = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Uri, Timer> j = new ConcurrentHashMap<>();

    /* renamed from: d.b.g0.e.a.l.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0929a extends BroadcastReceiver {
        public final /* synthetic */ d val$listener;
        public final /* synthetic */ String val$packageName;
        public final /* synthetic */ Uri val$uri;

        public C0929a(String str, d dVar, Uri uri) {
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
        public final /* synthetic */ d f47591e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f47592f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Uri f47593g;

        public b(d dVar, Context context, Uri uri) {
            this.f47591e = dVar;
            this.f47592f = context;
            this.f47593g = uri;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f47591e.a(Boolean.FALSE);
            a.this.l(this.f47592f, this.f47593g);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Timer f47595e;

        public c(Timer timer) {
            this.f47595e = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            for (Map.Entry entry : a.this.i.entrySet()) {
                a aVar = a.this;
                aVar.l(aVar.f47587e, (Uri) entry.getKey());
            }
            this.f47595e.cancel();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d<T> {
        public void a(T t) {
        }
    }

    public a(Context context, d.b.g0.e.a.l.f.a aVar) {
        this.f47587e = context;
        if (aVar == null) {
            this.f47590h = new d.b.g0.e.a.l.f.a();
        } else {
            this.f47590h = aVar;
        }
        if (this.f47590h.a() == null) {
            this.f47589g = new d.b.g0.e.a.l.h.a(context, this.f47590h);
        } else {
            this.f47589g = this.f47590h.a();
        }
        this.f47586d = new ArrayList();
        this.f47585c = new ConcurrentHashMap<>();
        this.f47589g.d();
        this.f47584b = Executors.newFixedThreadPool(this.f47590h.b());
        this.f47588f = new d.b.g0.e.a.l.g.b(this.f47589g);
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
        this.f47585c.remove(downloadInfo.getId());
        this.f47586d.remove(downloadInfo);
        this.f47589g.c(downloadInfo);
        this.f47588f.b(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // d.b.g0.e.a.l.i.c
    public void c(DownloadInfo downloadInfo) {
        this.f47586d.add(downloadInfo);
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
        ExecutorService executorService = this.f47584b;
        if (executorService != null) {
            executorService.shutdownNow();
            this.f47584b = null;
        }
        k = null;
    }

    @Override // d.b.g0.e.a.l.g.c.a
    public void e(DownloadInfo downloadInfo) {
        e.c(downloadInfo.getPath(), false);
        this.f47585c.remove(downloadInfo.getId());
        this.f47586d.remove(downloadInfo);
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
        C0929a c0929a = new C0929a(str, dVar, uri);
        appContext.registerReceiver(c0929a, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new b(dVar, appContext, uri), 60000L);
        this.i.put(uri, c0929a);
        this.j.put(uri, timer);
    }

    @Override // d.b.g0.e.a.l.i.c
    public DownloadInfo g(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.f47586d.iterator();
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
        return downloadInfo == null ? this.f47589g.b(str) : downloadInfo;
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
        if (System.currentTimeMillis() - this.f47583a > 500) {
            this.f47583a = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public final void o(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.f47585c.remove(downloadInfo.getId());
        this.f47588f.b(downloadInfo);
        q();
    }

    public final void p(DownloadInfo downloadInfo) {
        if (this.f47585c.size() >= this.f47590h.b()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.f47588f.b(downloadInfo);
            return;
        }
        d.b.g0.e.a.l.g.c cVar = new d.b.g0.e.a.l.g.c(this.f47584b, this.f47588f, downloadInfo, this);
        this.f47585c.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.f47588f.b(downloadInfo);
        cVar.c();
    }

    public final void q() {
        for (DownloadInfo downloadInfo : this.f47586d) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                p(downloadInfo);
                return;
            }
        }
    }
}
