package d.b.c.b.d;

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
    public final AtomicInteger f65071a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Request<?>> f65072b;

    /* renamed from: c  reason: collision with root package name */
    public final PriorityBlockingQueue<Request<?>> f65073c;

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<Request<?>> f65074d;

    /* renamed from: e  reason: collision with root package name */
    public final d.b.c.b.f.b f65075e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.c.b.f.c f65076f;

    /* renamed from: g  reason: collision with root package name */
    public final d.b.c.b.f.d f65077g;

    /* renamed from: h  reason: collision with root package name */
    public final j[] f65078h;

    /* renamed from: i  reason: collision with root package name */
    public f f65079i;
    public final List<b> j;
    public final List<a> k;

    /* loaded from: classes5.dex */
    public interface a {
        void a(Request<?> request, int i2);
    }

    @Deprecated
    /* loaded from: classes5.dex */
    public interface b<T> {
        void a(Request<T> request);
    }

    public n(d.b.c.b.f.b bVar, d.b.c.b.f.c cVar, int i2, d.b.c.b.f.d dVar) {
        this.f65071a = new AtomicInteger();
        this.f65072b = new HashSet();
        this.f65073c = new PriorityBlockingQueue<>();
        this.f65074d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f65075e = bVar;
        this.f65076f = cVar;
        this.f65078h = new j[i2];
        this.f65077g = dVar;
    }

    public <T> Request<T> a(Request<T> request) {
        e(request);
        request.setStartTime();
        request.setRequestQueue(this);
        synchronized (this.f65072b) {
            this.f65072b.add(request);
        }
        request.setSequence(f());
        request.addMarker("add-to-queue");
        c(request, 0);
        if (!request.shouldCache()) {
            this.f65074d.add(request);
            return request;
        }
        this.f65073c.add(request);
        return request;
    }

    public void b() {
        d();
        f fVar = new f(this.f65073c, this.f65074d, this.f65075e, this.f65077g);
        this.f65079i = fVar;
        fVar.setName("tt_pangle_thread_CacheDispatcher");
        this.f65079i.start();
        for (int i2 = 0; i2 < this.f65078h.length; i2++) {
            j jVar = new j(this.f65074d, this.f65076f, this.f65075e, this.f65077g);
            jVar.setName("tt_pangle_thread_NetworkDispatcher" + i2);
            this.f65078h[i2] = jVar;
            jVar.start();
        }
    }

    public void c(Request<?> request, int i2) {
        synchronized (this.k) {
            for (a aVar : this.k) {
                aVar.a(request, i2);
            }
        }
    }

    public void d() {
        j[] jVarArr;
        f fVar = this.f65079i;
        if (fVar != null) {
            fVar.b();
        }
        for (j jVar : this.f65078h) {
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
        if (d.b.c.b.a.k() != null) {
            String a2 = d.b.c.b.a.k().a(url);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            request.setUrl(a2);
        }
    }

    public int f() {
        return this.f65071a.incrementAndGet();
    }

    public <T> void g(Request<T> request) {
        synchronized (this.f65072b) {
            this.f65072b.remove(request);
        }
        synchronized (this.j) {
            for (b bVar : this.j) {
                bVar.a(request);
            }
        }
        c(request, 5);
    }

    public n(d.b.c.b.f.b bVar, d.b.c.b.f.c cVar, int i2) {
        this(bVar, cVar, i2, new i(new Handler(Looper.getMainLooper())));
    }

    public n(d.b.c.b.f.b bVar, d.b.c.b.f.c cVar) {
        this(bVar, cVar, 4);
    }
}
