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
    public static final boolean k = q.f66593b;

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f66531e;

    /* renamed from: f  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f66532f;

    /* renamed from: g  reason: collision with root package name */
    public final d.c.c.b.f.b f66533g;

    /* renamed from: h  reason: collision with root package name */
    public final d.c.c.b.f.d f66534h;
    public volatile boolean i = false;
    public final b j = new b(this);

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Request f66535e;

        public a(Request request) {
            this.f66535e = request;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.f66532f.put(this.f66535e);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Request.c {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<Request<?>>> f66537a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final f f66538b;

        public b(f fVar) {
            this.f66538b = fVar;
        }

        @Override // com.bytedance.sdk.adnet.core.Request.c
        public synchronized void a(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List<Request<?>> remove = this.f66537a.remove(cacheKey);
            if (remove != null && !remove.isEmpty()) {
                if (q.f66593b) {
                    q.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                }
                Request<?> remove2 = remove.remove(0);
                this.f66537a.put(cacheKey, remove);
                remove2.a(this);
                try {
                    this.f66538b.f66532f.put(remove2);
                } catch (InterruptedException e2) {
                    q.d("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    this.f66538b.b();
                }
            }
        }

        @Override // com.bytedance.sdk.adnet.core.Request.c
        public void b(Request<?> request, o<?> oVar) {
            List<Request<?>> remove;
            b.a aVar = oVar.f66585b;
            if (aVar != null && !aVar.a()) {
                String cacheKey = request.getCacheKey();
                synchronized (this) {
                    remove = this.f66537a.remove(cacheKey);
                }
                if (remove != null) {
                    if (q.f66593b) {
                        q.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                    }
                    for (Request<?> request2 : remove) {
                        this.f66538b.f66534h.b(request2, oVar);
                    }
                    return;
                }
                return;
            }
            a(request);
        }

        public final synchronized boolean d(Request<?> request) {
            String cacheKey = request.getCacheKey();
            if (this.f66537a.containsKey(cacheKey)) {
                List<Request<?>> list = this.f66537a.get(cacheKey);
                if (list == null) {
                    list = new ArrayList<>();
                }
                request.addMarker("waiting-for-response");
                list.add(request);
                this.f66537a.put(cacheKey, list);
                if (q.f66593b) {
                    q.c("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                }
                return true;
            }
            this.f66537a.put(cacheKey, null);
            request.a(this);
            if (q.f66593b) {
                q.c("new request, sending to network %s", cacheKey);
            }
            return false;
        }
    }

    public f(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, d.c.c.b.f.b bVar, d.c.c.b.f.d dVar) {
        this.f66531e = blockingQueue;
        this.f66532f = blockingQueue2;
        this.f66533g = bVar;
        this.f66534h = dVar;
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
        b.a a2 = this.f66533g.a(request.getCacheKey());
        if (a2 == null) {
            request.addMarker("cache-miss");
            if (!this.j.d(request)) {
                this.f66532f.put(request);
            }
        } else if (a2.a()) {
            request.addMarker("cache-hit-expired");
            request.setCacheEntry(a2);
            if (!this.j.d(request)) {
                this.f66532f.put(request);
            }
        } else {
            request.addMarker("cache-hit");
            o<?> a3 = request.a(new k(a2.f66609b, a2.f66615h));
            request.addMarker("cache-hit-parsed");
            if (!a2.b()) {
                this.f66534h.b(request, a3);
            } else {
                request.addMarker("cache-hit-refresh-needed");
                request.setCacheEntry(a2);
                a3.f66587d = true;
                if (!this.j.d(request)) {
                    this.f66534h.c(request, a3, new a(request));
                } else {
                    this.f66534h.b(request, a3);
                }
            }
        }
    }

    public final void e() throws InterruptedException {
        c(this.f66531e.take());
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (k) {
            q.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f66533g.a();
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
