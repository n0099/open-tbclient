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
    public final ExecutorService f46733a;

    /* renamed from: b  reason: collision with root package name */
    public final e f46734b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f46735c;

    /* renamed from: d  reason: collision with root package name */
    public final a f46736d;

    /* renamed from: e  reason: collision with root package name */
    public long f46737e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f46738f = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public interface a {
        void e(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, e eVar, DownloadInfo downloadInfo, a aVar) {
        this.f46733a = executorService;
        this.f46734b = eVar;
        this.f46735c = downloadInfo;
        this.f46736d = aVar;
    }

    @Override // d.a.l0.f.i.k.d.d.a
    public void a() {
        if (this.f46735c.getProgress() == this.f46735c.getSize()) {
            this.f46735c.setPackageName(g.d(AppRuntime.getAppContext(), this.f46735c.getPath()));
            this.f46735c.setStatus(DownloadState.DOWNLOADED.value());
            this.f46734b.b(this.f46735c);
            a aVar = this.f46736d;
            if (aVar != null) {
                aVar.e(this.f46735c);
            }
        }
    }

    @Override // d.a.l0.f.i.k.d.d.a
    public void b() {
        if (this.f46738f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f46738f.get()) {
                this.f46738f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f46737e > 1000) {
                    this.f46734b.b(this.f46735c);
                    this.f46737e = currentTimeMillis;
                }
                this.f46738f.set(false);
            }
        }
    }

    public void c() {
        this.f46733a.submit(new d(this.f46734b, this.f46735c, this));
    }
}
