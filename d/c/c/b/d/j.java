package d.c.c.b.d;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes5.dex */
public class j extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f66659e;

    /* renamed from: f  reason: collision with root package name */
    public final d.c.c.b.f.c f66660f;

    /* renamed from: g  reason: collision with root package name */
    public final d.c.c.b.f.b f66661g;

    /* renamed from: h  reason: collision with root package name */
    public final d.c.c.b.f.d f66662h;
    public volatile boolean i = false;

    public j(BlockingQueue<Request<?>> blockingQueue, d.c.c.b.f.c cVar, d.c.c.b.f.b bVar, d.c.c.b.f.d dVar) {
        this.f66659e = blockingQueue;
        this.f66660f = cVar;
        this.f66661g = bVar;
        this.f66662h = dVar;
    }

    public void a() {
        this.i = true;
        interrupt();
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    @VisibleForTesting
    public void b(Request<?> request) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        request.a(3);
        try {
            try {
                request.addMarker("network-queue-take");
            } finally {
                request.a(4);
            }
        } catch (VAdError e2) {
            e2.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
            c(request, e2);
            request.e();
        } catch (Exception e3) {
            q.b(e3, "Unhandled exception %s", e3.toString());
            VAdError vAdError = new VAdError(e3, (int) VAdError.NETWORK_DISPATCH_FAIL_CODE);
            vAdError.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f66662h.a(request, vAdError);
            request.e();
        } catch (Throwable th) {
            q.b(th, "NetworkDispatcher Unhandled throwable %s", th.toString());
            VAdError vAdError2 = new VAdError(th, (int) VAdError.NETWORK_DISPATCH_FAIL_CODE);
            vAdError2.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f66662h.a(request, vAdError2);
            request.e();
        }
        if (request.isCanceled()) {
            request.a("network-discard-cancelled");
            request.e();
            return;
        }
        e(request);
        k a2 = this.f66660f.a(request);
        request.setNetDuration(a2.f66668f);
        request.addMarker("network-http-complete");
        if (a2.f66667e && request.hasHadResponseDelivered()) {
            request.a("not-modified");
            request.e();
            return;
        }
        o<?> a3 = request.a(a2);
        request.setNetDuration(a2.f66668f);
        request.addMarker("network-parse-complete");
        if (request.shouldCache() && a3.f66680b != null) {
            this.f66661g.a(request.getCacheKey(), a3.f66680b);
            request.addMarker("network-cache-written");
        }
        request.markDelivered();
        this.f66662h.b(request, a3);
        request.b(a3);
    }

    public final void c(Request<?> request, VAdError vAdError) {
        this.f66662h.a(request, request.a(vAdError));
    }

    public final void d() throws InterruptedException {
        b(this.f66659e.take());
    }

    @TargetApi(14)
    public final void e(Request<?> request) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                d();
            } catch (InterruptedException unused) {
                if (this.i) {
                    Thread.currentThread().interrupt();
                    return;
                }
                q.d("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
