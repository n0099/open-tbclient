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
    public final ExecutorService f47601a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.g0.e.a.l.i.d f47602b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f47603c;

    /* renamed from: d  reason: collision with root package name */
    public final a f47604d;

    /* renamed from: e  reason: collision with root package name */
    public long f47605e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f47606f = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public interface a {
        void e(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, d.b.g0.e.a.l.i.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.f47601a = executorService;
        this.f47602b = dVar;
        this.f47603c = downloadInfo;
        this.f47604d = aVar;
    }

    @Override // d.b.g0.e.a.l.g.d.a
    public void a() {
        if (this.f47603c.getProgress() == this.f47603c.getSize()) {
            String d2 = e.d(AppRuntime.getAppContext(), this.f47603c.getPath());
            if (k.f45051a) {
                Log.d("AdDownload", "解析包名" + d2);
            }
            this.f47603c.setPackageName(d2);
            this.f47603c.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.f47602b.b(this.f47603c);
            a aVar = this.f47604d;
            if (aVar != null) {
                aVar.e(this.f47603c);
            }
        }
    }

    @Override // d.b.g0.e.a.l.g.d.a
    public void b() {
        if (this.f47606f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f47606f.get()) {
                this.f47606f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f47605e > 1000) {
                    this.f47602b.b(this.f47603c);
                    this.f47605e = currentTimeMillis;
                }
                this.f47606f.set(false);
            }
        }
    }

    public void c() {
        this.f47601a.submit(new d(this.f47602b, this.f47603c, this));
    }
}
