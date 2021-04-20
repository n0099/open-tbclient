package d.b.c.e.d;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.d.e;
import d.b.c.e.d.l;
/* loaded from: classes.dex */
public class m<T> implements l.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f42201a = false;

    /* renamed from: b  reason: collision with root package name */
    public final k<T> f42202b;

    /* renamed from: c  reason: collision with root package name */
    public final String f42203c;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42204e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l.a f42205f;

        public a(String str, l.a aVar) {
            this.f42204e = str;
            this.f42205f = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: d.b.c.e.d.l$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.f42205f.a(this.f42204e, m.this.get(this.f42204e));
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42207e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f42208f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f42209g;

        public b(String str, Object obj, long j) {
            this.f42207e = str;
            this.f42208f = obj;
            this.f42209g = j;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: d.b.c.e.d.m */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            m.this.e(this.f42207e, this.f42208f, this.f42209g);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42211e;

        public c(String str) {
            this.f42211e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.remove(this.f42211e);
        }
    }

    public m(String str, k<T> kVar) {
        this.f42203c = str;
        this.f42202b = kVar;
    }

    @Override // d.b.c.e.d.l
    public void a(String str, T t) {
        i(str, t, 315532800000L);
    }

    @Override // d.b.c.e.d.l.c
    public void b() {
        this.f42202b.g(this.f42203c);
        l();
    }

    @Override // d.b.c.e.d.l.c
    public k<T> c() {
        return this.f42202b;
    }

    @Override // d.b.c.e.d.l
    public void d(String str) {
        d.b.c.e.m.h.a().b(new c(str));
    }

    @Override // d.b.c.e.d.l
    public void e(String str, T t, long j) {
        if (str != null) {
            if (j <= 315532800000L) {
                j += System.currentTimeMillis();
            }
            long j2 = j;
            if (BdBaseApplication.getInst().isDebugMode() && d.b.c.e.p.l.B()) {
                if (!this.f42201a) {
                    BdLog.detailException("access db in main thread!", new Exception());
                } else {
                    throw new RuntimeException("access db in main thread!");
                }
            }
            if (j2 <= System.currentTimeMillis()) {
                remove(str);
                return;
            } else {
                this.f42202b.f(this.f42203c, str, t, j2);
                return;
            }
        }
        throw new NullPointerException("BdKVCache key cannot be null!");
    }

    @Override // d.b.c.e.d.l
    public void f(String str, l.a<T> aVar) {
        d.b.c.e.m.h.a().b(new a(str, aVar));
    }

    @Override // d.b.c.e.d.l
    public void g(String str, T t) {
        e(str, t, 315532800000L);
    }

    @Override // d.b.c.e.d.l
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && d.b.c.e.p.l.B()) {
            if (!this.f42201a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        return this.f42202b.e(this.f42203c, str);
    }

    @Override // d.b.c.e.d.l
    public l.b<T> h(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && d.b.c.e.p.l.B()) {
            if (!this.f42201a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        return this.f42202b.d(this.f42203c, str);
    }

    @Override // d.b.c.e.d.l
    public void i(String str, T t, long j) {
        d.b.c.e.m.h.a().b(new b(str, t, j));
    }

    @Override // d.b.c.e.d.l.c
    public String j() {
        return this.f42203c;
    }

    public void k() {
        this.f42202b.a(this.f42203c);
    }

    public void l() {
        e b2 = c().b();
        if (b2 instanceof e.b) {
            ((e.b) b2).release();
        }
    }

    @Override // d.b.c.e.d.l
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && d.b.c.e.p.l.B()) {
            if (!this.f42201a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        this.f42202b.c(this.f42203c, str);
    }
}
