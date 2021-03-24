package d.c.c.b.d;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.Request;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f65730a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Request<?>> f65731b;

    /* renamed from: c  reason: collision with root package name */
    public final PriorityBlockingQueue<Request<?>> f65732c;

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<Request<?>> f65733d;

    /* renamed from: e  reason: collision with root package name */
    public final d.c.c.b.f.b f65734e;

    /* renamed from: f  reason: collision with root package name */
    public final d.c.c.b.f.c f65735f;

    /* renamed from: g  reason: collision with root package name */
    public final d.c.c.b.f.d f65736g;

    /* renamed from: h  reason: collision with root package name */
    public final j[] f65737h;
    public f i;
    public final List<b> j;
    public final List<a> k;

    /* loaded from: classes5.dex */
    public interface a {
        void a(Request<?> request, int i);
    }

    @Deprecated
    /* loaded from: classes5.dex */
    public interface b<T> {
        void a(Request<T> request);
    }

    public n(d.c.c.b.f.b bVar, d.c.c.b.f.c cVar, int i, d.c.c.b.f.d dVar) {
        this.f65730a = new AtomicInteger();
        this.f65731b = new HashSet();
        this.f65732c = new PriorityBlockingQueue<>();
        this.f65733d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f65734e = bVar;
        this.f65735f = cVar;
        this.f65737h = new j[i];
        this.f65736g = dVar;
    }

    public <T> Request<T> a(Request<T> request) {
        e(request);
        request.setStartTime();
        request.setRequestQueue(this);
        synchronized (this.f65731b) {
            this.f65731b.add(request);
        }
        request.setSequence(f());
        request.addMarker("add-to-queue");
        c(request, 0);
        if (!request.shouldCache()) {
            this.f65733d.add(request);
            return request;
        }
        this.f65732c.add(request);
        return request;
    }

    public void b() {
        d();
        f fVar = new f(this.f65732c, this.f65733d, this.f65734e, this.f65736g);
        this.i = fVar;
        fVar.setName("tt_pangle_thread_CacheDispatcher");
        this.i.start();
        for (int i = 0; i < this.f65737h.length; i++) {
            j jVar = new j(this.f65733d, this.f65735f, this.f65734e, this.f65736g);
            jVar.setName("tt_pangle_thread_NetworkDispatcher" + i);
            this.f65737h[i] = jVar;
            jVar.start();
        }
    }

    public void c(Request<?> request, int i) {
        synchronized (this.k) {
            for (a aVar : this.k) {
                aVar.a(request, i);
            }
        }
    }

    public void d() {
        j[] jVarArr;
        f fVar = this.i;
        if (fVar != null) {
            fVar.b();
        }
        for (j jVar : this.f65737h) {
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    public <T> void e(Request<T> request) {
        if (request == null || TextUtils.isEmpty(request.getUrl())) {
            return;
        }
        String url = request.getUrl();
        if (d.c.c.b.a.k() != null) {
            String a2 = d.c.c.b.a.k().a(url);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            request.setUrl(a2);
        }
    }

    public int f() {
        return this.f65730a.incrementAndGet();
    }

    public <T> void g(Request<T> request) {
        synchronized (this.f65731b) {
            this.f65731b.remove(request);
        }
        synchronized (this.j) {
            for (b bVar : this.j) {
                bVar.a(request);
            }
        }
        c(request, 5);
    }

    public n(d.c.c.b.f.b bVar, d.c.c.b.f.c cVar, int i) {
        this(bVar, cVar, i, new i(new Handler(Looper.getMainLooper())));
    }

    public n(d.c.c.b.f.b bVar, d.c.c.b.f.c cVar) {
        this(bVar, cVar, 4);
    }
}
