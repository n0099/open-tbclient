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
    public static final boolean k = q.f65775b;

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f65710e;

    /* renamed from: f  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f65711f;

    /* renamed from: g  reason: collision with root package name */
    public final d.b.c.b.f.b f65712g;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.c.b.f.d f65713h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f65714i = false;
    public final b j = new b(this);

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Request f65715e;

        public a(Request request) {
            this.f65715e = request;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.f65711f.put(this.f65715e);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Request.c {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<Request<?>>> f65717a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final f f65718b;

        public b(f fVar) {
            this.f65718b = fVar;
        }

        @Override // com.bytedance.sdk.adnet.core.Request.c
        public synchronized void a(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List<Request<?>> remove = this.f65717a.remove(cacheKey);
            if (remove != null && !remove.isEmpty()) {
                if (q.f65775b) {
                    q.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                }
                Request<?> remove2 = remove.remove(0);
                this.f65717a.put(cacheKey, remove);
                remove2.a(this);
                try {
                    this.f65718b.f65711f.put(remove2);
                } catch (InterruptedException e2) {
                    q.d("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    this.f65718b.b();
                }
            }
        }

        @Override // com.bytedance.sdk.adnet.core.Request.c
        public void b(Request<?> request, o<?> oVar) {
            List<Request<?>> remove;
            b.a aVar = oVar.f65767b;
            if (aVar != null && !aVar.a()) {
                String cacheKey = request.getCacheKey();
                synchronized (this) {
                    remove = this.f65717a.remove(cacheKey);
                }
                if (remove != null) {
                    if (q.f65775b) {
                        q.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                    }
                    for (Request<?> request2 : remove) {
                        this.f65718b.f65713h.b(request2, oVar);
                    }
                    return;
                }
                return;
            }
            a(request);
        }

        public final synchronized boolean d(Request<?> request) {
            String cacheKey = request.getCacheKey();
            if (this.f65717a.containsKey(cacheKey)) {
                List<Request<?>> list = this.f65717a.get(cacheKey);
                if (list == null) {
                    list = new ArrayList<>();
                }
                request.addMarker("waiting-for-response");
                list.add(request);
                this.f65717a.put(cacheKey, list);
                if (q.f65775b) {
                    q.c("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                }
                return true;
            }
            this.f65717a.put(cacheKey, null);
            request.a(this);
            if (q.f65775b) {
                q.c("new request, sending to network %s", cacheKey);
            }
            return false;
        }
    }

    public f(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, d.b.c.b.f.b bVar, d.b.c.b.f.d dVar) {
        this.f65710e = blockingQueue;
        this.f65711f = blockingQueue2;
        this.f65712g = bVar;
        this.f65713h = dVar;
    }

    public void b() {
        this.f65714i = true;
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
        b.a a2 = this.f65712g.a(request.getCacheKey());
        if (a2 == null) {
            request.addMarker("cache-miss");
            if (!this.j.d(request)) {
                this.f65711f.put(request);
            }
        } else if (a2.a()) {
            request.addMarker("cache-hit-expired");
            request.setCacheEntry(a2);
            if (!this.j.d(request)) {
                this.f65711f.put(request);
            }
        } else {
            request.addMarker("cache-hit");
            o<?> a3 = request.a(new k(a2.f65791b, a2.f65797h));
            request.addMarker("cache-hit-parsed");
            if (!a2.b()) {
                this.f65713h.b(request, a3);
            } else {
                request.addMarker("cache-hit-refresh-needed");
                request.setCacheEntry(a2);
                a3.f65769d = true;
                if (!this.j.d(request)) {
                    this.f65713h.a(request, a3, new a(request));
                } else {
                    this.f65713h.b(request, a3);
                }
            }
        }
    }

    public final void e() throws InterruptedException {
        c(this.f65710e.take());
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (k) {
            q.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f65712g.a();
        while (true) {
            try {
                e();
            } catch (InterruptedException unused) {
                if (this.f65714i) {
                    Thread.currentThread().interrupt();
                    return;
                }
                q.d("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
