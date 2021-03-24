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
    public final ExecutorService f47600a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.g0.e.a.l.i.d f47601b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f47602c;

    /* renamed from: d  reason: collision with root package name */
    public final a f47603d;

    /* renamed from: e  reason: collision with root package name */
    public long f47604e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f47605f = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public interface a {
        void e(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, d.b.g0.e.a.l.i.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.f47600a = executorService;
        this.f47601b = dVar;
        this.f47602c = downloadInfo;
        this.f47603d = aVar;
    }

    @Override // d.b.g0.e.a.l.g.d.a
    public void a() {
        if (this.f47602c.getProgress() == this.f47602c.getSize()) {
            String d2 = e.d(AppRuntime.getAppContext(), this.f47602c.getPath());
            if (k.f45050a) {
                Log.d("AdDownload", "解析包名" + d2);
            }
            this.f47602c.setPackageName(d2);
            this.f47602c.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.f47601b.b(this.f47602c);
            a aVar = this.f47603d;
            if (aVar != null) {
                aVar.e(this.f47602c);
            }
        }
    }

    @Override // d.b.g0.e.a.l.g.d.a
    public void b() {
        if (this.f47605f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f47605f.get()) {
                this.f47605f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f47604e > 1000) {
                    this.f47601b.b(this.f47602c);
                    this.f47604e = currentTimeMillis;
                }
                this.f47605f.set(false);
            }
        }
    }

    public void c() {
        this.f47600a.submit(new d(this.f47601b, this.f47602c, this));
    }
}
