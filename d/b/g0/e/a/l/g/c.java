package d.b.g0.e.a.l.g;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import d.b.g0.a.k;
import d.b.g0.e.a.l.e;
import d.b.g0.e.a.l.g.d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class c implements d.a {

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f47993a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.g0.e.a.l.i.d f47994b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f47995c;

    /* renamed from: d  reason: collision with root package name */
    public final a f47996d;

    /* renamed from: e  reason: collision with root package name */
    public long f47997e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f47998f = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public interface a {
        void e(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, d.b.g0.e.a.l.i.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.f47993a = executorService;
        this.f47994b = dVar;
        this.f47995c = downloadInfo;
        this.f47996d = aVar;
    }

    @Override // d.b.g0.e.a.l.g.d.a
    public void a() {
        if (this.f47995c.getProgress() == this.f47995c.getSize()) {
            String d2 = e.d(AppRuntime.getAppContext(), this.f47995c.getPath());
            if (k.f45443a) {
                Log.d("AdDownload", "解析包名" + d2);
            }
            this.f47995c.setPackageName(d2);
            this.f47995c.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.f47994b.b(this.f47995c);
            a aVar = this.f47996d;
            if (aVar != null) {
                aVar.e(this.f47995c);
            }
        }
    }

    @Override // d.b.g0.e.a.l.g.d.a
    public void b() {
        if (this.f47998f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f47998f.get()) {
                this.f47998f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f47997e > 1000) {
                    this.f47994b.b(this.f47995c);
                    this.f47997e = currentTimeMillis;
                }
                this.f47998f.set(false);
            }
        }
    }

    public void c() {
        this.f47993a.submit(new d(this.f47994b, this.f47995c, this));
    }
}
