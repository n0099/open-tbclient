package d.a.h0.e.a.l.g;

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
import d.a.h0.e.a.l.e;
import d.a.h0.e.a.l.g.c;
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
public final class a implements d.a.h0.e.a.l.i.c, c.a {
    public static a k;

    /* renamed from: a  reason: collision with root package name */
    public long f45758a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f45759b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f45760c;

    /* renamed from: d  reason: collision with root package name */
    public final List<DownloadInfo> f45761d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f45762e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.h0.e.a.l.i.d f45763f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.h0.e.a.l.i.a f45764g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.h0.e.a.l.f.a f45765h;

    /* renamed from: i  reason: collision with root package name */
    public ConcurrentHashMap<Uri, BroadcastReceiver> f45766i = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Uri, Timer> j = new ConcurrentHashMap<>();

    /* renamed from: d.a.h0.e.a.l.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0901a extends BroadcastReceiver {
        public final /* synthetic */ d val$listener;
        public final /* synthetic */ String val$packageName;
        public final /* synthetic */ Uri val$uri;

        public C0901a(String str, d dVar, Uri uri) {
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
        public final /* synthetic */ d f45767e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f45768f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Uri f45769g;

        public b(d dVar, Context context, Uri uri) {
            this.f45767e = dVar;
            this.f45768f = context;
            this.f45769g = uri;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f45767e.a(Boolean.FALSE);
            a.this.l(this.f45768f, this.f45769g);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Timer f45771e;

        public c(Timer timer) {
            this.f45771e = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            for (Map.Entry entry : a.this.f45766i.entrySet()) {
                a aVar = a.this;
                aVar.l(aVar.f45762e, (Uri) entry.getKey());
            }
            this.f45771e.cancel();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d<T> {
        public void a(T t) {
        }
    }

    public a(Context context, d.a.h0.e.a.l.f.a aVar) {
        this.f45762e = context;
        if (aVar == null) {
            this.f45765h = new d.a.h0.e.a.l.f.a();
        } else {
            this.f45765h = aVar;
        }
        if (this.f45765h.a() == null) {
            this.f45764g = new d.a.h0.e.a.l.h.a(context, this.f45765h);
        } else {
            this.f45764g = this.f45765h.a();
        }
        this.f45761d = new ArrayList();
        this.f45760c = new ConcurrentHashMap<>();
        this.f45764g.b();
        this.f45759b = Executors.newFixedThreadPool(this.f45765h.b());
        this.f45763f = new d.a.h0.e.a.l.g.b(this.f45764g);
    }

    public static d.a.h0.e.a.l.i.c m(Context context, d.a.h0.e.a.l.f.a aVar) {
        synchronized (a.class) {
            if (k == null) {
                k = new a(context, aVar);
            }
        }
        return k;
    }

    @Override // d.a.h0.e.a.l.i.c
    public void a(DownloadInfo downloadInfo) {
        if (n()) {
            p(downloadInfo);
        }
    }

    @Override // d.a.h0.e.a.l.i.c
    public void b(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DELETED.value());
        this.f45760c.remove(downloadInfo.getId());
        this.f45761d.remove(downloadInfo);
        this.f45764g.d(downloadInfo);
        this.f45763f.b(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // d.a.h0.e.a.l.i.c
    public void c(DownloadInfo downloadInfo) {
        this.f45761d.add(downloadInfo);
        p(downloadInfo);
    }

    @Override // d.a.h0.e.a.l.i.c
    public void d(DownloadInfo downloadInfo) {
        if (n()) {
            o(downloadInfo);
        }
    }

    @Override // d.a.h0.e.a.l.i.c
    public void destroy() {
        k();
        ExecutorService executorService = this.f45759b;
        if (executorService != null) {
            executorService.shutdownNow();
            this.f45759b = null;
        }
        k = null;
    }

    @Override // d.a.h0.e.a.l.g.c.a
    public void e(DownloadInfo downloadInfo) {
        e.c(downloadInfo.getPath(), false);
        this.f45760c.remove(downloadInfo.getId());
        this.f45761d.remove(downloadInfo);
        q();
    }

    @Override // d.a.h0.e.a.l.i.c
    @AnyThread
    public void f(@NonNull String str, @NonNull Uri uri, @NonNull d<Boolean> dVar) {
        Context appContext = AppRuntime.getAppContext();
        if (e.a(appContext, str)) {
            dVar.a(Boolean.TRUE);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        C0901a c0901a = new C0901a(str, dVar, uri);
        appContext.registerReceiver(c0901a, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new b(dVar, appContext, uri), 60000L);
        this.f45766i.put(uri, c0901a);
        this.j.put(uri, timer);
    }

    @Override // d.a.h0.e.a.l.i.c
    public DownloadInfo g(String str) {
        DownloadInfo downloadInfo;
        Iterator<DownloadInfo> it = this.f45761d.iterator();
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
        return downloadInfo == null ? this.f45764g.c(str) : downloadInfo;
    }

    public final void k() {
        Timer timer = new Timer();
        timer.schedule(new c(timer), 60000L);
    }

    public final void l(Context context, Uri uri) {
        BroadcastReceiver remove = this.f45766i.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.j.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    public boolean n() {
        if (System.currentTimeMillis() - this.f45758a > 500) {
            this.f45758a = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public final void o(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(SwanAdDownloadState.DOWNLOAD_PAUSED.value());
        this.f45760c.remove(downloadInfo.getId());
        this.f45763f.b(downloadInfo);
        q();
    }

    public final void p(DownloadInfo downloadInfo) {
        if (this.f45760c.size() >= this.f45765h.b()) {
            downloadInfo.setStatus(SwanAdDownloadState.WAIT.value());
            this.f45763f.b(downloadInfo);
            return;
        }
        d.a.h0.e.a.l.g.c cVar = new d.a.h0.e.a.l.g.c(this.f45759b, this.f45763f, downloadInfo, this);
        this.f45760c.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(SwanAdDownloadState.PREPARE_DOWNLOAD.value());
        this.f45763f.b(downloadInfo);
        cVar.c();
    }

    public final void q() {
        for (DownloadInfo downloadInfo : this.f45761d) {
            if (downloadInfo.getStatus() == SwanAdDownloadState.WAIT.value()) {
                p(downloadInfo);
                return;
            }
        }
    }
}
