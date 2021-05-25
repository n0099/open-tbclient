package d.a.l0.f.i.k.d;

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
import d.a.l0.f.i.k.d.c;
import d.a.l0.f.i.k.f.e;
import d.a.l0.f.i.r.g;
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
public final class a implements d.a.l0.f.i.k.f.d, c.a {
    @SuppressLint({"StaticFieldLeak"})
    public static a k;

    /* renamed from: a  reason: collision with root package name */
    public long f46715a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f46716b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f46717c;

    /* renamed from: d  reason: collision with root package name */
    public final List<DownloadInfo> f46718d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f46719e;

    /* renamed from: f  reason: collision with root package name */
    public final e f46720f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.l0.f.i.k.f.b f46721g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.l0.f.i.k.c.a f46722h;

    /* renamed from: i  reason: collision with root package name */
    public ConcurrentHashMap<Uri, BroadcastReceiver> f46723i = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Uri, Timer> j = new ConcurrentHashMap<>();

    /* renamed from: d.a.l0.f.i.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0979a extends BroadcastReceiver {
        public final /* synthetic */ d val$listener;
        public final /* synthetic */ String val$packageName;
        public final /* synthetic */ Uri val$uri;

        public C0979a(String str, d dVar, Uri uri) {
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
        public final /* synthetic */ d f46724e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f46725f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Uri f46726g;

        public b(d dVar, Context context, Uri uri) {
            this.f46724e = dVar;
            this.f46725f = context;
            this.f46726g = uri;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f46724e.a(Boolean.FALSE);
            a.this.l(this.f46725f, this.f46726g);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Timer f46728e;

        public c(Timer timer) {
            this.f46728e = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            for (Map.Entry entry : a.this.f46723i.entrySet()) {
                a aVar = a.this;
                aVar.l(aVar.f46719e, (Uri) entry.getKey());
            }
            this.f46728e.cancel();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d<T> {
        public void a(T t) {
        }
    }

    public a(Context context, d.a.l0.f.i.k.c.a aVar) {
        this.f46719e = context;
        if (aVar == null) {
            this.f46722h = new d.a.l0.f.i.k.c.a();
        } else {
            this.f46722h = aVar;
        }
        if (this.f46722h.a() == null) {
            this.f46721g = new d.a.l0.f.i.k.e.a(context, this.f46722h);
        } else {
            this.f46721g = this.f46722h.a();
        }
        this.f46718d = new ArrayList();
        this.f46717c = new ConcurrentHashMap<>();
        this.f46721g.b();
        this.f46716b = Executors.newFixedThreadPool(this.f46722h.b());
        this.f46720f = new d.a.l0.f.i.k.d.b(this.f46721g);
    }

    public static synchronized d.a.l0.f.i.k.f.d m(Context context, d.a.l0.f.i.k.c.a aVar) {
        a aVar2;
        synchronized (a.class) {
            if (k == null) {
                k = new a(context, aVar);
            }
            aVar2 = k;
        }
        return aVar2;
    }

    @Override // d.a.l0.f.i.k.f.d
    public synchronized void a(DownloadInfo downloadInfo) {
        if (n()) {
            p(downloadInfo);
        }
    }

    @Override // d.a.l0.f.i.k.f.d
    public synchronized void b(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setStatus(DownloadState.DELETED.value());
        this.f46717c.remove(downloadInfo.getId());
        this.f46718d.remove(downloadInfo);
        this.f46721g.d(downloadInfo);
        this.f46720f.b(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // d.a.l0.f.i.k.f.d
    public synchronized void c(DownloadInfo downloadInfo) {
        this.f46718d.add(downloadInfo);
        p(downloadInfo);
    }

    @Override // d.a.l0.f.i.k.f.d
    public synchronized void d(DownloadInfo downloadInfo) {
        if (n()) {
            o(downloadInfo);
        }
    }

    @Override // d.a.l0.f.i.k.f.d
    public synchronized void destroy() {
        k();
        if (this.f46721g != null) {
            this.f46721g.close();
        }
        if (this.f46716b != null) {
            this.f46716b.shutdownNow();
            this.f46716b = null;
        }
        k = null;
    }

    @Override // d.a.l0.f.i.k.d.c.a
    public synchronized void e(DownloadInfo downloadInfo) {
        g.c(downloadInfo.getPath(), false);
        this.f46717c.remove(downloadInfo.getId());
        this.f46718d.remove(downloadInfo);
        q();
    }

    @Override // d.a.l0.f.i.k.f.d
    @AnyThread
    public synchronized void f(@NonNull String str, @NonNull Uri uri, @NonNull d<Boolean> dVar) {
        Context appContext = AppRuntime.getAppContext();
        if (g.a(appContext, str)) {
            dVar.a(Boolean.TRUE);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        C0979a c0979a = new C0979a(str, dVar, uri);
        appContext.registerReceiver(c0979a, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new b(dVar, appContext, uri), 60000L);
        this.f46723i.put(uri, c0979a);
        this.j.put(uri, timer);
    }

    @Override // d.a.l0.f.i.k.f.d
    public synchronized DownloadInfo g(String str) {
        DownloadInfo downloadInfo;
        downloadInfo = null;
        Iterator<DownloadInfo> it = this.f46718d.iterator();
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
            downloadInfo = this.f46721g.c(str);
        }
        return downloadInfo;
    }

    public final void k() {
        Timer timer = new Timer();
        timer.schedule(new c(timer), 60000L);
    }

    public final void l(Context context, Uri uri) {
        BroadcastReceiver remove = this.f46723i.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.j.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    public synchronized boolean n() {
        if (System.currentTimeMillis() - this.f46715a > 500) {
            this.f46715a = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public final void o(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(DownloadState.DOWNLOAD_PAUSED.value());
        this.f46717c.remove(downloadInfo.getId());
        this.f46720f.b(downloadInfo);
        q();
    }

    public final void p(DownloadInfo downloadInfo) {
        if (this.f46717c.size() >= this.f46722h.b()) {
            downloadInfo.setStatus(DownloadState.WAIT.value());
            this.f46720f.b(downloadInfo);
            return;
        }
        d.a.l0.f.i.k.d.c cVar = new d.a.l0.f.i.k.d.c(this.f46716b, this.f46720f, downloadInfo, this);
        this.f46717c.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(DownloadState.PREPARE_DOWNLOAD.value());
        this.f46720f.b(downloadInfo);
        cVar.c();
    }

    public final void q() {
        for (DownloadInfo downloadInfo : this.f46718d) {
            if (downloadInfo.getStatus() == DownloadState.WAIT.value()) {
                p(downloadInfo);
                return;
            }
        }
    }
}
