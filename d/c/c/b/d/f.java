package d.c.c.b.d;

import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.core.Request;
import d.c.c.b.f.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes5.dex */
public class f extends Thread {
    public static final boolean k = q.f65747b;

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f65685e;

    /* renamed from: f  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f65686f;

    /* renamed from: g  reason: collision with root package name */
    public final d.c.c.b.f.b f65687g;

    /* renamed from: h  reason: collision with root package name */
    public final d.c.c.b.f.d f65688h;
    public volatile boolean i = false;
    public final b j = new b(this);

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Request f65689e;

        public a(Request request) {
            this.f65689e = request;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.f65686f.put(this.f65689e);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Request.c {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<Request<?>>> f65691a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final f f65692b;

        public b(f fVar) {
            this.f65692b = fVar;
        }

        @Override // com.bytedance.sdk.adnet.core.Request.c
        public synchronized void a(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List<Request<?>> remove = this.f65691a.remove(cacheKey);
            if (remove != null && !remove.isEmpty()) {
                if (q.f65747b) {
                    q.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                }
                Request<?> remove2 = remove.remove(0);
                this.f65691a.put(cacheKey, remove);
                remove2.a(this);
                try {
                    this.f65692b.f65686f.put(remove2);
                } catch (InterruptedException e2) {
                    q.d("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    this.f65692b.b();
                }
            }
        }

        @Override // com.bytedance.sdk.adnet.core.Request.c
        public void b(Request<?> request, o<?> oVar) {
            List<Request<?>> remove;
            b.a aVar = oVar.f65739b;
            if (aVar != null && !aVar.a()) {
                String cacheKey = request.getCacheKey();
                synchronized (this) {
                    remove = this.f65691a.remove(cacheKey);
                }
                if (remove != null) {
                    if (q.f65747b) {
                        q.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                    }
                    for (Request<?> request2 : remove) {
                        this.f65692b.f65688h.b(request2, oVar);
                    }
                    return;
                }
                return;
            }
            a(request);
        }

        public final synchronized boolean d(Request<?> request) {
            String cacheKey = request.getCacheKey();
            if (this.f65691a.containsKey(cacheKey)) {
                List<Request<?>> list = this.f65691a.get(cacheKey);
                if (list == null) {
                    list = new ArrayList<>();
                }
                request.addMarker("waiting-for-response");
                list.add(request);
                this.f65691a.put(cacheKey, list);
                if (q.f65747b) {
                    q.c("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                }
                return true;
            }
            this.f65691a.put(cacheKey, null);
            request.a(this);
            if (q.f65747b) {
                q.c("new request, sending to network %s", cacheKey);
            }
            return false;
        }
    }

    public f(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, d.c.c.b.f.b bVar, d.c.c.b.f.d dVar) {
        this.f65685e = blockingQueue;
        this.f65686f = blockingQueue2;
        this.f65687g = bVar;
        this.f65688h = dVar;
    }

    public void b() {
        this.i = true;
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
        b.a a2 = this.f65687g.a(request.getCacheKey());
        if (a2 == null) {
            request.addMarker("cache-miss");
            if (!this.j.d(request)) {
                this.f65686f.put(request);
            }
        } else if (a2.a()) {
            request.addMarker("cache-hit-expired");
            request.setCacheEntry(a2);
            if (!this.j.d(request)) {
                this.f65686f.put(request);
            }
        } else {
            request.addMarker("cache-hit");
            o<?> a3 = request.a(new k(a2.f65763b, a2.f65769h));
            request.addMarker("cache-hit-parsed");
            if (!a2.b()) {
                this.f65688h.b(request, a3);
            } else {
                request.addMarker("cache-hit-refresh-needed");
                request.setCacheEntry(a2);
                a3.f65741d = true;
                if (!this.j.d(request)) {
                    this.f65688h.c(request, a3, new a(request));
                } else {
                    this.f65688h.b(request, a3);
                }
            }
        }
    }

    public final void e() throws InterruptedException {
        c(this.f65685e.take());
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (k) {
            q.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f65687g.a();
        while (true) {
            try {
                e();
            } catch (InterruptedException unused) {
                if (this.i) {
                    Thread.currentThread().interrupt();
                    return;
                }
                q.d("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
