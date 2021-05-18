package d.a.i0.f.i.k.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import d.a.i0.f.i.k.d.d;
import d.a.i0.f.i.k.f.e;
import d.a.i0.f.i.r.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class c implements d.a {

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f46557a;

    /* renamed from: b  reason: collision with root package name */
    public final e f46558b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f46559c;

    /* renamed from: d  reason: collision with root package name */
    public final a f46560d;

    /* renamed from: e  reason: collision with root package name */
    public long f46561e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f46562f = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public interface a {
        void e(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, e eVar, DownloadInfo downloadInfo, a aVar) {
        this.f46557a = executorService;
        this.f46558b = eVar;
        this.f46559c = downloadInfo;
        this.f46560d = aVar;
    }

    @Override // d.a.i0.f.i.k.d.d.a
    public void a() {
        if (this.f46559c.getProgress() == this.f46559c.getSize()) {
            this.f46559c.setPackageName(g.d(AppRuntime.getAppContext(), this.f46559c.getPath()));
            this.f46559c.setStatus(DownloadState.DOWNLOADED.value());
            this.f46558b.b(this.f46559c);
            a aVar = this.f46560d;
            if (aVar != null) {
                aVar.e(this.f46559c);
            }
        }
    }

    @Override // d.a.i0.f.i.k.d.d.a
    public void b() {
        if (this.f46562f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f46562f.get()) {
                this.f46562f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f46561e > 1000) {
                    this.f46558b.b(this.f46559c);
                    this.f46561e = currentTimeMillis;
                }
                this.f46562f.set(false);
            }
        }
    }

    public void c() {
        this.f46557a.submit(new d(this.f46558b, this.f46559c, this));
    }
}
