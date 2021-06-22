package d.a.c.e.d;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.d.e;
import d.a.c.e.d.l;
/* loaded from: classes.dex */
public class m<T> implements l.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f42300a = false;

    /* renamed from: b  reason: collision with root package name */
    public final k<T> f42301b;

    /* renamed from: c  reason: collision with root package name */
    public final String f42302c;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42303e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l.a f42304f;

        public a(String str, l.a aVar) {
            this.f42303e = str;
            this.f42304f = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: d.a.c.e.d.l$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.f42304f.a(this.f42303e, m.this.get(this.f42303e));
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42306e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f42307f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f42308g;

        public b(String str, Object obj, long j) {
            this.f42306e = str;
            this.f42307f = obj;
            this.f42308g = j;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: d.a.c.e.d.m */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            m.this.e(this.f42306e, this.f42307f, this.f42308g);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42310e;

        public c(String str) {
            this.f42310e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.remove(this.f42310e);
        }
    }

    public m(String str, k<T> kVar) {
        this.f42302c = str;
        this.f42301b = kVar;
    }

    @Override // d.a.c.e.d.l
    public void a(String str, T t) {
        i(str, t, 315532800000L);
    }

    @Override // d.a.c.e.d.l.c
    public void b() {
        this.f42301b.g(this.f42302c);
        l();
    }

    @Override // d.a.c.e.d.l.c
    public k<T> c() {
        return this.f42301b;
    }

    @Override // d.a.c.e.d.l
    public void d(String str) {
        d.a.c.e.m.h.a().b(new c(str));
    }

    @Override // d.a.c.e.d.l
    public void e(String str, T t, long j) {
        if (str != null) {
            if (j <= 315532800000L) {
                j += System.currentTimeMillis();
            }
            long j2 = j;
            if (BdBaseApplication.getInst().isDebugMode() && d.a.c.e.p.l.C()) {
                if (!this.f42300a) {
                    BdLog.detailException("access db in main thread!", new Exception());
                } else {
                    throw new RuntimeException("access db in main thread!");
                }
            }
            if (j2 <= System.currentTimeMillis()) {
                remove(str);
                return;
            } else {
                this.f42301b.f(this.f42302c, str, t, j2);
                return;
            }
        }
        throw new NullPointerException("BdKVCache key cannot be null!");
    }

    @Override // d.a.c.e.d.l
    public void f(String str, l.a<T> aVar) {
        d.a.c.e.m.h.a().b(new a(str, aVar));
    }

    @Override // d.a.c.e.d.l
    public void g(String str, T t) {
        e(str, t, 315532800000L);
    }

    @Override // d.a.c.e.d.l
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && d.a.c.e.p.l.C()) {
            if (!this.f42300a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        return this.f42301b.e(this.f42302c, str);
    }

    @Override // d.a.c.e.d.l
    public l.b<T> h(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && d.a.c.e.p.l.C()) {
            if (!this.f42300a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        return this.f42301b.d(this.f42302c, str);
    }

    @Override // d.a.c.e.d.l
    public void i(String str, T t, long j) {
        d.a.c.e.m.h.a().b(new b(str, t, j));
    }

    @Override // d.a.c.e.d.l.c
    public String j() {
        return this.f42302c;
    }

    public void k() {
        this.f42301b.a(this.f42302c);
    }

    public void l() {
        e b2 = c().b();
        if (b2 instanceof e.b) {
            ((e.b) b2).release();
        }
    }

    @Override // d.a.c.e.d.l
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && d.a.c.e.p.l.C()) {
            if (!this.f42300a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        this.f42301b.c(this.f42302c, str);
    }
}
