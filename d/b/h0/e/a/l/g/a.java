package d.b.h0.e.a.l.g;

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
import d.b.h0.e.a.l.e;
import d.b.h0.e.a.l.g.c;
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
public final class a implements d.b.h0.e.a.l.i.c, c.a {
    public static a k;

    /* renamed from: a  reason: collision with root package name */
    public long f48305a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f48306b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f48307c;

    /* renamed from: d  reason: collision with root package name */
    public final List<DownloadInfo> f48308d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f48309e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.h0.e.a.l.i.d f48310f;

    /* renamed from: g  reason: collision with root package name */
    public final d.b.h0.e.a.l.i.a f48311g;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.h0.e.a.l.f.a f48312h;
    public ConcurrentHashMap<Uri, BroadcastReceiver> i = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Uri, Timer> j = new ConcurrentHashMap<>();

    /* renamed from: d.b.h0.e.a.l.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0962a extends BroadcastReceiver {
        public final /* synthetic */ d val$listener;
        public final /* synthetic */ String val$packageName;
        public final /* synthetic */ Uri val$uri;

        public C0962a(String str, d dVar, Uri uri) {
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
        public final /* synthetic */ d f48313e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f48314f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Uri f48315g;

        public b(d dVar, Context context, Uri uri) {
            this.f48313e = dVar;
            this.f48314f = context;
            this.f48315g = uri;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f48313e.a(Boolean.FALSE);
            a.this.l(this.f48314f, this.f48315g);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Timer f48317e;

        public c(Timer timer) {
            this.f48317e = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            for (Map.Entry entry : a.this.i.entrySet()) {
                a aVar = a.this;
                aVar.l(aVar.f48309e, (Uri) entry.getKey());
            }
            this.f48317e.cancel();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d<T> {
        public void a(T t) {
        }
    }

    public a(Context context, d.b.h0.e.a.l.f.a aVar) {
        this.f48309e = context;
        if (aVar == null) {
            this.f48312h = new d.b.h0.e.a.l.f.a();
        } else {
            this.f48312h = aVar;
        }
        if (this.f48312h.a() == null) {
            this.f48311g = new d.b.h0.e.a.l.h.a(context, this.f48312h);
        } else {
            this.f48311g = this.f48312h.a();
        }
        this.f48308d = new ArrayList();
        this.f48307c = new ConcurrentHashMap<>();
        this.f48311g.d();
        this.f48306b = Executors.newFixedThreadPool(this.f48312h.b());
        this.f48310f = new d.b.h0.e.a.l.g.b(this.f48311g);
    }

    public static d.b.h0.e.a.l.i.c m(Context context, d.b.h0.e.a.l.f.a aVar) {
        synchronized (a.class) {
            if (k == null) {
                k = new a(context, aVar);
            }
        }
        return k;
    }

    @Override // d.b.h0.e.a.l.i.c
    public void a(DownloadInfo downloadInfo) {
        if (n()) {
            p(downloadInfo);
        }
    }

    @Override // d.b.h0.e.a.l.i.c
    public void b(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DELETED.value());
        this.f48307c.remove(downloadInfo.getId());
        this.f48308d.remove(downloadInfo);
        this.f48311g.c(downloadInfo);
        this.f48310f.b(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // d.b.h0.e.a.l.i.c
    public void c(DownloadInfo downloadInfo) {
        this.f48308d.add(downloadInfo);
        p(downloadInfo);
    }

    @Override // d.b.h0.e.a.l.i.c
    public void d(DownloadInfo downloadInfo) {
        if (n()) {
            o(downloadInfo);
        }
    }

    @Override // d.b.h0.e.a.l.i.c
    public void destroy() {
        k();
        ExecutorService executorService = this.f48306b;
        if (executorService != null) {
            executorService.shutdownNow();
            this.f48306b = null;
        }
        k = null;
    }

    @Override // d.b.h0.e.a.l.g.c.a
    public void e(DownloadInfo downloadInfo) {
        e.c(downloadInfo.getPath(), false);
        this.f48307c.remove(downloadInfo.getId());
        this.f48308d.remove(downloadInfo);
        q();
    }

    @Override // d.b.h0.e.a.l.i.c
    @AnyThread
    public void f(@NonNull String str, @NonNull Uri uri, @NonNull d<Boolean> dVar) {
        Context appContext = AppRuntime.getAppContext();
        if (e.a(appContext, str)) {
            dVar.a(Boolean.TRUE);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        C0962a c0962a = new C0962a(str, dVar, uri);
        appContext.registerReceiver(c0962a, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new b(dVar, appContext, uri), 60000L);
        this.i.put(uri, c0962a);
        this.j.put(uri, timer);
    }

    @Override // d.b.h0.e.a.l.i.c
    public DownloadInfo g(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.f48308d.iterator();
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
        return downloadInfo == null ? this.f48311g.b(str) : downloadInfo;
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
        if (System.currentTimeMillis() - this.f48305a > 500) {
            this.f48305a = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public final void o(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.f48307c.remove(downloadInfo.getId());
        this.f48310f.b(downloadInfo);
        q();
    }

    public final void p(DownloadInfo downloadInfo) {
        if (this.f48307c.size() >= this.f48312h.b()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.f48310f.b(downloadInfo);
            return;
        }
        d.b.h0.e.a.l.g.c cVar = new d.b.h0.e.a.l.g.c(this.f48306b, this.f48310f, downloadInfo, this);
        this.f48307c.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.f48310f.b(downloadInfo);
        cVar.c();
    }

    public final void q() {
        for (DownloadInfo downloadInfo : this.f48308d) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                p(downloadInfo);
                return;
            }
        }
    }
}
