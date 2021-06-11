package d.a.l0.f.i.k.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import d.a.l0.f.i.k.d.d;
import d.a.l0.f.i.k.f.e;
import d.a.l0.f.i.r.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class c implements d.a {

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f50407a;

    /* renamed from: b  reason: collision with root package name */
    public final e f50408b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f50409c;

    /* renamed from: d  reason: collision with root package name */
    public final a f50410d;

    /* renamed from: e  reason: collision with root package name */
    public long f50411e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f50412f = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public interface a {
        void e(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, e eVar, DownloadInfo downloadInfo, a aVar) {
        this.f50407a = executorService;
        this.f50408b = eVar;
        this.f50409c = downloadInfo;
        this.f50410d = aVar;
    }

    @Override // d.a.l0.f.i.k.d.d.a
    public void a() {
        if (this.f50409c.getProgress() == this.f50409c.getSize()) {
            this.f50409c.setPackageName(g.d(AppRuntime.getAppContext(), this.f50409c.getPath()));
            this.f50409c.setStatus(DownloadState.DOWNLOADED.value());
            this.f50408b.b(this.f50409c);
            a aVar = this.f50410d;
            if (aVar != null) {
                aVar.e(this.f50409c);
            }
        }
    }

    @Override // d.a.l0.f.i.k.d.d.a
    public void b() {
        if (this.f50412f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f50412f.get()) {
                this.f50412f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f50411e > 1000) {
                    this.f50408b.b(this.f50409c);
                    this.f50411e = currentTimeMillis;
                }
                this.f50412f.set(false);
            }
        }
    }

    public void c() {
        this.f50407a.submit(new d(this.f50408b, this.f50409c, this));
    }
}
