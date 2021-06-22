package d.b.c.b.d;

import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.core.Request;
import d.b.c.b.f.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes6.dex */
public class f extends Thread {
    public static final boolean k = q.f69653b;

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f69588e;

    /* renamed from: f  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f69589f;

    /* renamed from: g  reason: collision with root package name */
    public final d.b.c.b.f.b f69590g;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.c.b.f.d f69591h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f69592i = false;
    public final b j = new b(this);

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Request f69593e;

        public a(Request request) {
            this.f69593e = request;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.f69589f.put(this.f69593e);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Request.c {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<Request<?>>> f69595a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final f f69596b;

        public b(f fVar) {
            this.f69596b = fVar;
        }

        @Override // com.bytedance.sdk.adnet.core.Request.c
        public synchronized void a(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List<Request<?>> remove = this.f69595a.remove(cacheKey);
            if (remove != null && !remove.isEmpty()) {
                if (q.f69653b) {
                    q.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                }
                Request<?> remove2 = remove.remove(0);
                this.f69595a.put(cacheKey, remove);
                remove2.a(this);
                try {
                    this.f69596b.f69589f.put(remove2);
                } catch (InterruptedException e2) {
                    q.d("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    this.f69596b.b();
                }
            }
        }

        @Override // com.bytedance.sdk.adnet.core.Request.c
        public void b(Request<?> request, o<?> oVar) {
            List<Request<?>> remove;
            b.a aVar = oVar.f69645b;
            if (aVar != null && !aVar.a()) {
                String cacheKey = request.getCacheKey();
                synchronized (this) {
                    remove = this.f69595a.remove(cacheKey);
                }
                if (remove != null) {
                    if (q.f69653b) {
                        q.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                    }
                    for (Request<?> request2 : remove) {
                        this.f69596b.f69591h.b(request2, oVar);
                    }
                    return;
                }
                return;
            }
            a(request);
        }

        public final synchronized boolean d(Request<?> request) {
            String cacheKey = request.getCacheKey();
            if (this.f69595a.containsKey(cacheKey)) {
                List<Request<?>> list = this.f69595a.get(cacheKey);
                if (list == null) {
                    list = new ArrayList<>();
                }
                request.addMarker("waiting-for-response");
                list.add(request);
                this.f69595a.put(cacheKey, list);
                if (q.f69653b) {
                    q.c("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                }
                return true;
            }
            this.f69595a.put(cacheKey, null);
            request.a(this);
            if (q.f69653b) {
                q.c("new request, sending to network %s", cacheKey);
            }
            return false;
        }
    }

    public f(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, d.b.c.b.f.b bVar, d.b.c.b.f.d dVar) {
        this.f69588e = blockingQueue;
        this.f69589f = blockingQueue2;
        this.f69590g = bVar;
        this.f69591h = dVar;
    }

    public void b() {
        this.f69592i = true;
        interrupt();
    }

    @VisibleForTesting
    public void c(Request<?> request) throws InterruptedException {
        request.addMarker("cache-queue-take");
        request.a(1);
        try {
        } finally {
            try {
            } finally {
            }
        }
        if (request.isCanceled()) {
            request.a("cache-discard-canceled");
            return;
        }
        b.a a2 = this.f69590g.a(request.getCacheKey());
        if (a2 == null) {
            request.addMarker("cache-miss");
            if (!this.j.d(request)) {
                this.f69589f.put(request);
            }
        } else if (a2.a()) {
            request.addMarker("cache-hit-expired");
            request.setCacheEntry(a2);
            if (!this.j.d(request)) {
                this.f69589f.put(request);
            }
        } else {
            request.addMarker("cache-hit");
            o<?> a3 = request.a(new k(a2.f69669b, a2.f69675h));
            request.addMarker("cache-hit-parsed");
            if (!a2.b()) {
                this.f69591h.b(request, a3);
            } else {
                request.addMarker("cache-hit-refresh-needed");
                request.setCacheEntry(a2);
                a3.f69647d = true;
                if (!this.j.d(request)) {
                    this.f69591h.a(request, a3, new a(request));
                } else {
                    this.f69591h.b(request, a3);
                }
            }
        }
    }

    public final void e() throws InterruptedException {
        c(this.f69588e.take());
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (k) {
            q.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f69590g.a();
        while (true) {
            try {
                e();
            } catch (InterruptedException unused) {
                if (this.f69592i) {
                    Thread.currentThread().interrupt();
                    return;
                }
                q.d("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
