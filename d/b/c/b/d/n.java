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
/* loaded from: classes6.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f69635a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Request<?>> f69636b;

    /* renamed from: c  reason: collision with root package name */
    public final PriorityBlockingQueue<Request<?>> f69637c;

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<Request<?>> f69638d;

    /* renamed from: e  reason: collision with root package name */
    public final d.b.c.b.f.b f69639e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.c.b.f.c f69640f;

    /* renamed from: g  reason: collision with root package name */
    public final d.b.c.b.f.d f69641g;

    /* renamed from: h  reason: collision with root package name */
    public final j[] f69642h;

    /* renamed from: i  reason: collision with root package name */
    public f f69643i;
    public final List<b> j;
    public final List<a> k;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Request<?> request, int i2);
    }

    @Deprecated
    /* loaded from: classes6.dex */
    public interface b<T> {
        void a(Request<T> request);
    }

    public n(d.b.c.b.f.b bVar, d.b.c.b.f.c cVar, int i2, d.b.c.b.f.d dVar) {
        this.f69635a = new AtomicInteger();
        this.f69636b = new HashSet();
        this.f69637c = new PriorityBlockingQueue<>();
        this.f69638d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f69639e = bVar;
        this.f69640f = cVar;
        this.f69642h = new j[i2];
        this.f69641g = dVar;
    }

    public <T> Request<T> a(Request<T> request) {
        e(request);
        request.setStartTime();
        request.setRequestQueue(this);
        synchronized (this.f69636b) {
            this.f69636b.add(request);
        }
        request.setSequence(f());
        request.addMarker("add-to-queue");
        c(request, 0);
        if (!request.shouldCache()) {
            this.f69638d.add(request);
            return request;
        }
        this.f69637c.add(request);
        return request;
    }

    public void b() {
        d();
        f fVar = new f(this.f69637c, this.f69638d, this.f69639e, this.f69641g);
        this.f69643i = fVar;
        fVar.setName("tt_pangle_thread_CacheDispatcher");
        this.f69643i.start();
        for (int i2 = 0; i2 < this.f69642h.length; i2++) {
            j jVar = new j(this.f69638d, this.f69640f, this.f69639e, this.f69641g);
            jVar.setName("tt_pangle_thread_NetworkDispatcher" + i2);
            this.f69642h[i2] = jVar;
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
        f fVar = this.f69643i;
        if (fVar != null) {
            fVar.b();
        }
        for (j jVar : this.f69642h) {
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
        return this.f69635a.incrementAndGet();
    }

    public <T> void g(Request<T> request) {
        synchronized (this.f69636b) {
            this.f69636b.remove(request);
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
