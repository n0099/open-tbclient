package d.a.c.e.d;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.d.e;
import d.a.c.e.d.l;
/* loaded from: classes.dex */
public class m<T> implements l.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f38880a = false;

    /* renamed from: b  reason: collision with root package name */
    public final k<T> f38881b;

    /* renamed from: c  reason: collision with root package name */
    public final String f38882c;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f38883e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l.a f38884f;

        public a(String str, l.a aVar) {
            this.f38883e = str;
            this.f38884f = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: d.a.c.e.d.l$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.f38884f.a(this.f38883e, m.this.get(this.f38883e));
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f38886e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f38887f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f38888g;

        public b(String str, Object obj, long j) {
            this.f38886e = str;
            this.f38887f = obj;
            this.f38888g = j;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: d.a.c.e.d.m */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            m.this.e(this.f38886e, this.f38887f, this.f38888g);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f38890e;

        public c(String str) {
            this.f38890e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.remove(this.f38890e);
        }
    }

    public m(String str, k<T> kVar) {
        this.f38882c = str;
        this.f38881b = kVar;
    }

    @Override // d.a.c.e.d.l
    public void a(String str, T t) {
        i(str, t, 315532800000L);
    }

    @Override // d.a.c.e.d.l.c
    public void b() {
        this.f38881b.g(this.f38882c);
        l();
    }

    @Override // d.a.c.e.d.l.c
    public k<T> c() {
        return this.f38881b;
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
                if (!this.f38880a) {
                    BdLog.detailException("access db in main thread!", new Exception());
                } else {
                    throw new RuntimeException("access db in main thread!");
                }
            }
            if (j2 <= System.currentTimeMillis()) {
                remove(str);
                return;
            } else {
                this.f38881b.f(this.f38882c, str, t, j2);
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
            if (!this.f38880a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        return this.f38881b.e(this.f38882c, str);
    }

    @Override // d.a.c.e.d.l
    public l.b<T> h(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && d.a.c.e.p.l.C()) {
            if (!this.f38880a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        return this.f38881b.d(this.f38882c, str);
    }

    @Override // d.a.c.e.d.l
    public void i(String str, T t, long j) {
        d.a.c.e.m.h.a().b(new b(str, t, j));
    }

    @Override // d.a.c.e.d.l.c
    public String j() {
        return this.f38882c;
    }

    public void k() {
        this.f38881b.a(this.f38882c);
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
            if (!this.f38880a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        this.f38881b.c(this.f38882c, str);
    }
}
