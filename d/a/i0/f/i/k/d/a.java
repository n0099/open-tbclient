package d.a.i0.f.i.k.d;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import d.a.i0.f.i.k.d.c;
import d.a.i0.f.i.k.f.e;
import d.a.i0.f.i.r.g;
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
public final class a implements d.a.i0.f.i.k.f.d, c.a {
    @SuppressLint({"StaticFieldLeak"})
    public static a k;

    /* renamed from: a  reason: collision with root package name */
    public long f46539a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f46540b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f46541c;

    /* renamed from: d  reason: collision with root package name */
    public final List<DownloadInfo> f46542d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f46543e;

    /* renamed from: f  reason: collision with root package name */
    public final e f46544f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.i0.f.i.k.f.b f46545g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.i0.f.i.k.c.a f46546h;

    /* renamed from: i  reason: collision with root package name */
    public ConcurrentHashMap<Uri, BroadcastReceiver> f46547i = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Uri, Timer> j = new ConcurrentHashMap<>();

    /* renamed from: d.a.i0.f.i.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0968a extends BroadcastReceiver {
        public final /* synthetic */ d val$listener;
        public final /* synthetic */ String val$packageName;
        public final /* synthetic */ Uri val$uri;

        public C0968a(String str, d dVar, Uri uri) {
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
        public final /* synthetic */ d f46548e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f46549f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Uri f46550g;

        public b(d dVar, Context context, Uri uri) {
            this.f46548e = dVar;
            this.f46549f = context;
            this.f46550g = uri;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f46548e.a(Boolean.FALSE);
            a.this.l(this.f46549f, this.f46550g);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Timer f46552e;

        public c(Timer timer) {
            this.f46552e = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            for (Map.Entry entry : a.this.f46547i.entrySet()) {
                a aVar = a.this;
                aVar.l(aVar.f46543e, (Uri) entry.getKey());
            }
            this.f46552e.cancel();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d<T> {
        public void a(T t) {
        }
    }

    public a(Context context, d.a.i0.f.i.k.c.a aVar) {
        this.f46543e = context;
        if (aVar == null) {
            this.f46546h = new d.a.i0.f.i.k.c.a();
        } else {
            this.f46546h = aVar;
        }
        if (this.f46546h.a() == null) {
            this.f46545g = new d.a.i0.f.i.k.e.a(context, this.f46546h);
        } else {
            this.f46545g = this.f46546h.a();
        }
        this.f46542d = new ArrayList();
        this.f46541c = new ConcurrentHashMap<>();
        this.f46545g.b();
        this.f46540b = Executors.newFixedThreadPool(this.f46546h.b());
        this.f46544f = new d.a.i0.f.i.k.d.b(this.f46545g);
    }

    public static synchronized d.a.i0.f.i.k.f.d m(Context context, d.a.i0.f.i.k.c.a aVar) {
        a aVar2;
        synchronized (a.class) {
            if (k == null) {
                k = new a(context, aVar);
            }
            aVar2 = k;
        }
        return aVar2;
    }

    @Override // d.a.i0.f.i.k.f.d
    public synchronized void a(DownloadInfo downloadInfo) {
        if (n()) {
            p(downloadInfo);
        }
    }

    @Override // d.a.i0.f.i.k.f.d
    public synchronized void b(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setStatus(DownloadState.DELETED.value());
        this.f46541c.remove(downloadInfo.getId());
        this.f46542d.remove(downloadInfo);
        this.f46545g.d(downloadInfo);
        this.f46544f.b(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // d.a.i0.f.i.k.f.d
    public synchronized void c(DownloadInfo downloadInfo) {
        this.f46542d.add(downloadInfo);
        p(downloadInfo);
    }

    @Override // d.a.i0.f.i.k.f.d
    public synchronized void d(DownloadInfo downloadInfo) {
        if (n()) {
            o(downloadInfo);
        }
    }

    @Override // d.a.i0.f.i.k.f.d
    public synchronized void destroy() {
        k();
        if (this.f46545g != null) {
            this.f46545g.close();
        }
        if (this.f46540b != null) {
            this.f46540b.shutdownNow();
            this.f46540b = null;
        }
        k = null;
    }

    @Override // d.a.i0.f.i.k.d.c.a
    public synchronized void e(DownloadInfo downloadInfo) {
        g.c(downloadInfo.getPath(), false);
        this.f46541c.remove(downloadInfo.getId());
        this.f46542d.remove(downloadInfo);
        q();
    }

    @Override // d.a.i0.f.i.k.f.d
    @AnyThread
    public synchronized void f(@NonNull String str, @NonNull Uri uri, @NonNull d<Boolean> dVar) {
        Context appContext = AppRuntime.getAppContext();
        if (g.a(appContext, str)) {
            dVar.a(Boolean.TRUE);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        C0968a c0968a = new C0968a(str, dVar, uri);
        appContext.registerReceiver(c0968a, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new b(dVar, appContext, uri), 60000L);
        this.f46547i.put(uri, c0968a);
        this.j.put(uri, timer);
    }

    @Override // d.a.i0.f.i.k.f.d
    public synchronized DownloadInfo g(String str) {
        DownloadInfo downloadInfo;
        downloadInfo = null;
        Iterator<DownloadInfo> it = this.f46542d.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadInfo next = it.next();
            if (next.getId().equals(str)) {
                downloadInfo = next;
                break;
            }
        }
        if (downloadInfo == null) {
            downloadInfo = this.f46545g.c(str);
        }
        return downloadInfo;
    }

    public final void k() {
        Timer timer = new Timer();
        timer.schedule(new c(timer), 60000L);
    }

    public final void l(Context context, Uri uri) {
        BroadcastReceiver remove = this.f46547i.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.j.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    public synchronized boolean n() {
        if (System.currentTimeMillis() - this.f46539a > 500) {
            this.f46539a = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public final void o(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(DownloadState.DOWNLOAD_PAUSED.value());
        this.f46541c.remove(downloadInfo.getId());
        this.f46544f.b(downloadInfo);
        q();
    }

    public final void p(DownloadInfo downloadInfo) {
        if (this.f46541c.size() >= this.f46546h.b()) {
            downloadInfo.setStatus(DownloadState.WAIT.value());
            this.f46544f.b(downloadInfo);
            return;
        }
        d.a.i0.f.i.k.d.c cVar = new d.a.i0.f.i.k.d.c(this.f46540b, this.f46544f, downloadInfo, this);
        this.f46541c.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(DownloadState.PREPARE_DOWNLOAD.value());
        this.f46544f.b(downloadInfo);
        cVar.c();
    }

    public final void q() {
        for (DownloadInfo downloadInfo : this.f46542d) {
            if (downloadInfo.getStatus() == DownloadState.WAIT.value()) {
                p(downloadInfo);
                return;
            }
        }
    }
}
