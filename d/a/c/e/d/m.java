package d.a.c.e.d;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.d.e;
import d.a.c.e.d.l;
/* loaded from: classes.dex */
public class m<T> implements l.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f39635a = false;

    /* renamed from: b  reason: collision with root package name */
    public final k<T> f39636b;

    /* renamed from: c  reason: collision with root package name */
    public final String f39637c;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f39638e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l.a f39639f;

        public a(String str, l.a aVar) {
            this.f39638e = str;
            this.f39639f = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: d.a.c.e.d.l$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.f39639f.a(this.f39638e, m.this.get(this.f39638e));
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f39641e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f39642f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f39643g;

        public b(String str, Object obj, long j) {
            this.f39641e = str;
            this.f39642f = obj;
            this.f39643g = j;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: d.a.c.e.d.m */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            m.this.e(this.f39641e, this.f39642f, this.f39643g);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f39645e;

        public c(String str) {
            this.f39645e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.remove(this.f39645e);
        }
    }

    public m(String str, k<T> kVar) {
        this.f39637c = str;
        this.f39636b = kVar;
    }

    @Override // d.a.c.e.d.l
    public void a(String str, T t) {
        i(str, t, 315532800000L);
    }

    @Override // d.a.c.e.d.l.c
    public void b() {
        this.f39636b.g(this.f39637c);
        l();
    }

    @Override // d.a.c.e.d.l.c
    public k<T> c() {
        return this.f39636b;
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
                if (!this.f39635a) {
                    BdLog.detailException("access db in main thread!", new Exception());
                } else {
                    throw new RuntimeException("access db in main thread!");
                }
            }
            if (j2 <= System.currentTimeMillis()) {
                remove(str);
                return;
            } else {
                this.f39636b.f(this.f39637c, str, t, j2);
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
            if (!this.f39635a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        return this.f39636b.e(this.f39637c, str);
    }

    @Override // d.a.c.e.d.l
    public l.b<T> h(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && d.a.c.e.p.l.C()) {
            if (!this.f39635a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        return this.f39636b.d(this.f39637c, str);
    }

    @Override // d.a.c.e.d.l
    public void i(String str, T t, long j) {
        d.a.c.e.m.h.a().b(new b(str, t, j));
    }

    @Override // d.a.c.e.d.l.c
    public String j() {
        return this.f39637c;
    }

    public void k() {
        this.f39636b.a(this.f39637c);
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
            if (!this.f39635a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        this.f39636b.c(this.f39637c, str);
    }
}
