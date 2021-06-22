package d.a.m0.f.i.k.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import d.a.m0.f.i.k.d.d;
import d.a.m0.f.i.k.f.e;
import d.a.m0.f.i.r.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class c implements d.a {

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f50515a;

    /* renamed from: b  reason: collision with root package name */
    public final e f50516b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f50517c;

    /* renamed from: d  reason: collision with root package name */
    public final a f50518d;

    /* renamed from: e  reason: collision with root package name */
    public long f50519e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f50520f = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public interface a {
        void e(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, e eVar, DownloadInfo downloadInfo, a aVar) {
        this.f50515a = executorService;
        this.f50516b = eVar;
        this.f50517c = downloadInfo;
        this.f50518d = aVar;
    }

    @Override // d.a.m0.f.i.k.d.d.a
    public void a() {
        if (this.f50517c.getProgress() == this.f50517c.getSize()) {
            this.f50517c.setPackageName(g.d(AppRuntime.getAppContext(), this.f50517c.getPath()));
            this.f50517c.setStatus(DownloadState.DOWNLOADED.value());
            this.f50516b.b(this.f50517c);
            a aVar = this.f50518d;
            if (aVar != null) {
                aVar.e(this.f50517c);
            }
        }
    }

    @Override // d.a.m0.f.i.k.d.d.a
    public void b() {
        if (this.f50520f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f50520f.get()) {
                this.f50520f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f50519e > 1000) {
                    this.f50516b.b(this.f50517c);
                    this.f50519e = currentTimeMillis;
                }
                this.f50520f.set(false);
            }
        }
    }

    public void c() {
        this.f50515a.submit(new d(this.f50516b, this.f50517c, this));
    }
}
