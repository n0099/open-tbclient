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
    public final AtomicInteger f66576a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Request<?>> f66577b;

    /* renamed from: c  reason: collision with root package name */
    public final PriorityBlockingQueue<Request<?>> f66578c;

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<Request<?>> f66579d;

    /* renamed from: e  reason: collision with root package name */
    public final d.c.c.b.f.b f66580e;

    /* renamed from: f  reason: collision with root package name */
    public final d.c.c.b.f.c f66581f;

    /* renamed from: g  reason: collision with root package name */
    public final d.c.c.b.f.d f66582g;

    /* renamed from: h  reason: collision with root package name */
    public final j[] f66583h;
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
        this.f66576a = new AtomicInteger();
        this.f66577b = new HashSet();
        this.f66578c = new PriorityBlockingQueue<>();
        this.f66579d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f66580e = bVar;
        this.f66581f = cVar;
        this.f66583h = new j[i];
        this.f66582g = dVar;
    }

    public <T> Request<T> a(Request<T> request) {
        e(request);
        request.setStartTime();
        request.setRequestQueue(this);
        synchronized (this.f66577b) {
            this.f66577b.add(request);
        }
        request.setSequence(f());
        request.addMarker("add-to-queue");
        c(request, 0);
        if (!request.shouldCache()) {
            this.f66579d.add(request);
            return request;
        }
        this.f66578c.add(request);
        return request;
    }

    public void b() {
        d();
        f fVar = new f(this.f66578c, this.f66579d, this.f66580e, this.f66582g);
        this.i = fVar;
        fVar.setName("tt_pangle_thread_CacheDispatcher");
        this.i.start();
        for (int i = 0; i < this.f66583h.length; i++) {
            j jVar = new j(this.f66579d, this.f66581f, this.f66580e, this.f66582g);
            jVar.setName("tt_pangle_thread_NetworkDispatcher" + i);
            this.f66583h[i] = jVar;
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
        for (j jVar : this.f66583h) {
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
        return this.f66576a.incrementAndGet();
    }

    public <T> void g(Request<T> request) {
        synchronized (this.f66577b) {
            this.f66577b.remove(request);
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
