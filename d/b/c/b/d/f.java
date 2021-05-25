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
    public static final boolean k = q.f65818b;

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f65753e;

    /* renamed from: f  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f65754f;

    /* renamed from: g  reason: collision with root package name */
    public final d.b.c.b.f.b f65755g;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.c.b.f.d f65756h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f65757i = false;
    public final b j = new b(this);

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Request f65758e;

        public a(Request request) {
            this.f65758e = request;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.f65754f.put(this.f65758e);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Request.c {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<Request<?>>> f65760a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final f f65761b;

        public b(f fVar) {
            this.f65761b = fVar;
        }

        @Override // com.bytedance.sdk.adnet.core.Request.c
        public synchronized void a(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List<Request<?>> remove = this.f65760a.remove(cacheKey);
            if (remove != null && !remove.isEmpty()) {
                if (q.f65818b) {
                    q.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                }
                Request<?> remove2 = remove.remove(0);
                this.f65760a.put(cacheKey, remove);
                remove2.a(this);
                try {
                    this.f65761b.f65754f.put(remove2);
                } catch (InterruptedException e2) {
                    q.d("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    this.f65761b.b();
                }
            }
        }

        @Override // com.bytedance.sdk.adnet.core.Request.c
        public void b(Request<?> request, o<?> oVar) {
            List<Request<?>> remove;
            b.a aVar = oVar.f65810b;
            if (aVar != null && !aVar.a()) {
                String cacheKey = request.getCacheKey();
                synchronized (this) {
                    remove = this.f65760a.remove(cacheKey);
                }
                if (remove != null) {
                    if (q.f65818b) {
                        q.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                    }
                    for (Request<?> request2 : remove) {
                        this.f65761b.f65756h.b(request2, oVar);
                    }
                    return;
                }
                return;
            }
            a(request);
        }

        public final synchronized boolean d(Request<?> request) {
            String cacheKey = request.getCacheKey();
            if (this.f65760a.containsKey(cacheKey)) {
                List<Request<?>> list = this.f65760a.get(cacheKey);
                if (list == null) {
                    list = new ArrayList<>();
                }
                request.addMarker("waiting-for-response");
                list.add(request);
                this.f65760a.put(cacheKey, list);
                if (q.f65818b) {
                    q.c("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                }
                return true;
            }
            this.f65760a.put(cacheKey, null);
            request.a(this);
            if (q.f65818b) {
                q.c("new request, sending to network %s", cacheKey);
            }
            return false;
        }
    }

    public f(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, d.b.c.b.f.b bVar, d.b.c.b.f.d dVar) {
        this.f65753e = blockingQueue;
        this.f65754f = blockingQueue2;
        this.f65755g = bVar;
        this.f65756h = dVar;
    }

    public void b() {
        this.f65757i = true;
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
        b.a a2 = this.f65755g.a(request.getCacheKey());
        if (a2 == null) {
            request.addMarker("cache-miss");
            if (!this.j.d(request)) {
                this.f65754f.put(request);
            }
        } else if (a2.a()) {
            request.addMarker("cache-hit-expired");
            request.setCacheEntry(a2);
            if (!this.j.d(request)) {
                this.f65754f.put(request);
            }
        } else {
            request.addMarker("cache-hit");
            o<?> a3 = request.a(new k(a2.f65834b, a2.f65840h));
            request.addMarker("cache-hit-parsed");
            if (!a2.b()) {
                this.f65756h.b(request, a3);
            } else {
                request.addMarker("cache-hit-refresh-needed");
                request.setCacheEntry(a2);
                a3.f65812d = true;
                if (!this.j.d(request)) {
                    this.f65756h.a(request, a3, new a(request));
                } else {
                    this.f65756h.b(request, a3);
                }
            }
        }
    }

    public final void e() throws InterruptedException {
        c(this.f65753e.take());
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (k) {
            q.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f65755g.a();
        while (true) {
            try {
                e();
            } catch (InterruptedException unused) {
                if (this.f65757i) {
                    Thread.currentThread().interrupt();
                    return;
                }
                q.d("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
