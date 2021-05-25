package d.b.c.b.d;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes6.dex */
public class j extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f65787e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.c.b.f.c f65788f;

    /* renamed from: g  reason: collision with root package name */
    public final d.b.c.b.f.b f65789g;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.c.b.f.d f65790h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f65791i = false;

    public j(BlockingQueue<Request<?>> blockingQueue, d.b.c.b.f.c cVar, d.b.c.b.f.b bVar, d.b.c.b.f.d dVar) {
        this.f65787e = blockingQueue;
        this.f65788f = cVar;
        this.f65789g = bVar;
        this.f65790h = dVar;
    }

    public void a() {
        this.f65791i = true;
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
            this.f65790h.c(request, vAdError);
            request.e();
        } catch (Throwable th) {
            q.b(th, "NetworkDispatcher Unhandled throwable %s", th.toString());
            VAdError vAdError2 = new VAdError(th, (int) VAdError.NETWORK_DISPATCH_FAIL_CODE);
            vAdError2.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f65790h.c(request, vAdError2);
            request.e();
        }
        if (request.isCanceled()) {
            request.a("network-discard-cancelled");
            request.e();
            return;
        }
        e(request);
        k a2 = this.f65788f.a(request);
        request.setNetDuration(a2.f65797f);
        request.addMarker("network-http-complete");
        if (a2.f65796e && request.hasHadResponseDelivered()) {
            request.a("not-modified");
            request.e();
            return;
        }
        o<?> a3 = request.a(a2);
        request.setNetDuration(a2.f65797f);
        request.addMarker("network-parse-complete");
        if (request.shouldCache() && a3.f65810b != null) {
            this.f65789g.a(request.getCacheKey(), a3.f65810b);
            request.addMarker("network-cache-written");
        }
        request.markDelivered();
        this.f65790h.b(request, a3);
        request.b(a3);
    }

    public final void c(Request<?> request, VAdError vAdError) {
        this.f65790h.c(request, request.a(vAdError));
    }

    public final void d() throws InterruptedException {
        b(this.f65787e.take());
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
                if (this.f65791i) {
                    Thread.currentThread().interrupt();
                    return;
                }
                q.d("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
