package d.a.h0.e.a.l.g;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import d.a.h0.a.k;
import d.a.h0.e.a.l.e;
import d.a.h0.e.a.l.g.d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class c implements d.a {

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f45776a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.h0.e.a.l.i.d f45777b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f45778c;

    /* renamed from: d  reason: collision with root package name */
    public final a f45779d;

    /* renamed from: e  reason: collision with root package name */
    public long f45780e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f45781f = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public interface a {
        void e(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, d.a.h0.e.a.l.i.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.f45776a = executorService;
        this.f45777b = dVar;
        this.f45778c = downloadInfo;
        this.f45779d = aVar;
    }

    @Override // d.a.h0.e.a.l.g.d.a
    public void a() {
        if (this.f45778c.getProgress() == this.f45778c.getSize()) {
            String d2 = e.d(AppRuntime.getAppContext(), this.f45778c.getPath());
            if (k.f43101a) {
                Log.d("AdDownload", "解析包名" + d2);
            }
            this.f45778c.setPackageName(d2);
            this.f45778c.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.f45777b.b(this.f45778c);
            a aVar = this.f45779d;
            if (aVar != null) {
                aVar.e(this.f45778c);
            }
        }
    }

    @Override // d.a.h0.e.a.l.g.d.a
    public void b() {
        if (this.f45781f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f45781f.get()) {
                this.f45781f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f45780e > 1000) {
                    this.f45777b.b(this.f45778c);
                    this.f45780e = currentTimeMillis;
                }
                this.f45781f.set(false);
            }
        }
    }

    public void c() {
        this.f45776a.submit(new d(this.f45777b, this.f45778c, this));
    }
}
