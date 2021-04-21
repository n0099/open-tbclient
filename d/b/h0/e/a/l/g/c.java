package d.b.h0.e.a.l.g;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import d.b.h0.a.k;
import d.b.h0.e.a.l.e;
import d.b.h0.e.a.l.g.d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class c implements d.a {

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f48322a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.h0.e.a.l.i.d f48323b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f48324c;

    /* renamed from: d  reason: collision with root package name */
    public final a f48325d;

    /* renamed from: e  reason: collision with root package name */
    public long f48326e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f48327f = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public interface a {
        void e(DownloadInfo downloadInfo);
    }

    public c(ExecutorService executorService, d.b.h0.e.a.l.i.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.f48322a = executorService;
        this.f48323b = dVar;
        this.f48324c = downloadInfo;
        this.f48325d = aVar;
    }

    @Override // d.b.h0.e.a.l.g.d.a
    public void a() {
        if (this.f48324c.getProgress() == this.f48324c.getSize()) {
            String d2 = e.d(AppRuntime.getAppContext(), this.f48324c.getPath());
            if (k.f45772a) {
                Log.d("AdDownload", "解析包名" + d2);
            }
            this.f48324c.setPackageName(d2);
            this.f48324c.setStatus(SwanAdDownloadState.DOWNLOADED.value());
            this.f48323b.b(this.f48324c);
            a aVar = this.f48325d;
            if (aVar != null) {
                aVar.e(this.f48324c);
            }
        }
    }

    @Override // d.b.h0.e.a.l.g.d.a
    public void b() {
        if (this.f48327f.get()) {
            return;
        }
        synchronized (this) {
            if (!this.f48327f.get()) {
                this.f48327f.set(true);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f48326e > 1000) {
                    this.f48323b.b(this.f48324c);
                    this.f48326e = currentTimeMillis;
                }
                this.f48327f.set(false);
            }
        }
    }

    public void c() {
        this.f48322a.submit(new d(this.f48323b, this.f48324c, this));
    }
}
