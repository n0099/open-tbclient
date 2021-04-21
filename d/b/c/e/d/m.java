package d.b.c.e.d;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.d.e;
import d.b.c.e.d.l;
/* loaded from: classes.dex */
public class m<T> implements l.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f42441a = false;

    /* renamed from: b  reason: collision with root package name */
    public final k<T> f42442b;

    /* renamed from: c  reason: collision with root package name */
    public final String f42443c;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42444e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l.a f42445f;

        public a(String str, l.a aVar) {
            this.f42444e = str;
            this.f42445f = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: d.b.c.e.d.l$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.f42445f.a(this.f42444e, m.this.get(this.f42444e));
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42447e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f42448f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f42449g;

        public b(String str, Object obj, long j) {
            this.f42447e = str;
            this.f42448f = obj;
            this.f42449g = j;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: d.b.c.e.d.m */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            m.this.e(this.f42447e, this.f42448f, this.f42449g);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42451e;

        public c(String str) {
            this.f42451e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.remove(this.f42451e);
        }
    }

    public m(String str, k<T> kVar) {
        this.f42443c = str;
        this.f42442b = kVar;
    }

    @Override // d.b.c.e.d.l
    public void a(String str, T t) {
        i(str, t, 315532800000L);
    }

    @Override // d.b.c.e.d.l.c
    public void b() {
        this.f42442b.g(this.f42443c);
        l();
    }

    @Override // d.b.c.e.d.l.c
    public k<T> c() {
        return this.f42442b;
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
                if (!this.f42441a) {
                    BdLog.detailException("access db in main thread!", new Exception());
                } else {
                    throw new RuntimeException("access db in main thread!");
                }
            }
            if (j2 <= System.currentTimeMillis()) {
                remove(str);
                return;
            } else {
                this.f42442b.f(this.f42443c, str, t, j2);
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
            if (!this.f42441a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        return this.f42442b.e(this.f42443c, str);
    }

    @Override // d.b.c.e.d.l
    public l.b<T> h(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && d.b.c.e.p.l.B()) {
            if (!this.f42441a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        return this.f42442b.d(this.f42443c, str);
    }

    @Override // d.b.c.e.d.l
    public void i(String str, T t, long j) {
        d.b.c.e.m.h.a().b(new b(str, t, j));
    }

    @Override // d.b.c.e.d.l.c
    public String j() {
        return this.f42443c;
    }

    public void k() {
        this.f42442b.a(this.f42443c);
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
            if (!this.f42441a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        this.f42442b.c(this.f42443c, str);
    }
}
