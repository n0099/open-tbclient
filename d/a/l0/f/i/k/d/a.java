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
    public long f50389a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f50390b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f50391c;

    /* renamed from: d  reason: collision with root package name */
    public final List<DownloadInfo> f50392d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f50393e;

    /* renamed from: f  reason: collision with root package name */
    public final e f50394f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.l0.f.i.k.f.b f50395g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.l0.f.i.k.c.a f50396h;

    /* renamed from: i  reason: collision with root package name */
    public ConcurrentHashMap<Uri, BroadcastReceiver> f50397i = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Uri, Timer> j = new ConcurrentHashMap<>();

    /* renamed from: d.a.l0.f.i.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1035a extends BroadcastReceiver {
        public final /* synthetic */ d val$listener;
        public final /* synthetic */ String val$packageName;
        public final /* synthetic */ Uri val$uri;

        public C1035a(String str, d dVar, Uri uri) {
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
        public final /* synthetic */ d f50398e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f50399f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Uri f50400g;

        public b(d dVar, Context context, Uri uri) {
            this.f50398e = dVar;
            this.f50399f = context;
            this.f50400g = uri;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f50398e.a(Boolean.FALSE);
            a.this.l(this.f50399f, this.f50400g);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Timer f50402e;

        public c(Timer timer) {
            this.f50402e = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            for (Map.Entry entry : a.this.f50397i.entrySet()) {
                a aVar = a.this;
                aVar.l(aVar.f50393e, (Uri) entry.getKey());
            }
            this.f50402e.cancel();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d<T> {
        public void a(T t) {
        }
    }

    public a(Context context, d.a.l0.f.i.k.c.a aVar) {
        this.f50393e = context;
        if (aVar == null) {
            this.f50396h = new d.a.l0.f.i.k.c.a();
        } else {
            this.f50396h = aVar;
        }
        if (this.f50396h.a() == null) {
            this.f50395g = new d.a.l0.f.i.k.e.a(context, this.f50396h);
        } else {
            this.f50395g = this.f50396h.a();
        }
        this.f50392d = new ArrayList();
        this.f50391c = new ConcurrentHashMap<>();
        this.f50395g.b();
        this.f50390b = Executors.newFixedThreadPool(this.f50396h.b());
        this.f50394f = new d.a.l0.f.i.k.d.b(this.f50395g);
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
        this.f50391c.remove(downloadInfo.getId());
        this.f50392d.remove(downloadInfo);
        this.f50395g.d(downloadInfo);
        this.f50394f.b(downloadInfo);
        new File(downloadInfo.getPath()).delete();
    }

    @Override // d.a.l0.f.i.k.f.d
    public synchronized void c(DownloadInfo downloadInfo) {
        this.f50392d.add(downloadInfo);
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
        if (this.f50395g != null) {
            this.f50395g.close();
        }
        if (this.f50390b != null) {
            this.f50390b.shutdownNow();
            this.f50390b = null;
        }
        k = null;
    }

    @Override // d.a.l0.f.i.k.d.c.a
    public synchronized void e(DownloadInfo downloadInfo) {
        g.c(downloadInfo.getPath(), false);
        this.f50391c.remove(downloadInfo.getId());
        this.f50392d.remove(downloadInfo);
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
        C1035a c1035a = new C1035a(str, dVar, uri);
        appContext.registerReceiver(c1035a, intentFilter);
        Timer timer = new Timer();
        timer.schedule(new b(dVar, appContext, uri), 60000L);
        this.f50397i.put(uri, c1035a);
        this.j.put(uri, timer);
    }

    @Override // d.a.l0.f.i.k.f.d
    public synchronized DownloadInfo g(String str) {
        DownloadInfo downloadInfo;
        downloadInfo = null;
        Iterator<DownloadInfo> it = this.f50392d.iterator();
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
            downloadInfo = this.f50395g.c(str);
        }
        return downloadInfo;
    }

    public final void k() {
        Timer timer = new Timer();
        timer.schedule(new c(timer), 60000L);
    }

    public final void l(Context context, Uri uri) {
        BroadcastReceiver remove = this.f50397i.remove(uri);
        if (remove != null) {
            context.unregisterReceiver(remove);
        }
        Timer remove2 = this.j.remove(uri);
        if (remove2 != null) {
            remove2.cancel();
        }
    }

    public synchronized boolean n() {
        if (System.currentTimeMillis() - this.f50389a > 500) {
            this.f50389a = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public final void o(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(DownloadState.DOWNLOAD_PAUSED.value());
        this.f50391c.remove(downloadInfo.getId());
        this.f50394f.b(downloadInfo);
        q();
    }

    public final void p(DownloadInfo downloadInfo) {
        if (this.f50391c.size() >= this.f50396h.b()) {
            downloadInfo.setStatus(DownloadState.WAIT.value());
            this.f50394f.b(downloadInfo);
            return;
        }
        d.a.l0.f.i.k.d.c cVar = new d.a.l0.f.i.k.d.c(this.f50390b, this.f50394f, downloadInfo, this);
        this.f50391c.put(downloadInfo.getId(), cVar);
        downloadInfo.setStatus(DownloadState.PREPARE_DOWNLOAD.value());
        this.f50394f.b(downloadInfo);
        cVar.c();
    }

    public final void q() {
        for (DownloadInfo downloadInfo : this.f50392d) {
            if (downloadInfo.getStatus() == DownloadState.WAIT.value()) {
                p(downloadInfo);
                return;
            }
        }
    }
}
