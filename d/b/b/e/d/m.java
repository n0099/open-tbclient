package d.b.b.e.d;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import d.b.b.e.d.e;
import d.b.b.e.d.l;
/* loaded from: classes.dex */
public class m<T> implements l.c<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f41704a = false;

    /* renamed from: b  reason: collision with root package name */
    public final k<T> f41705b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41706c;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41707e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l.a f41708f;

        public a(String str, l.a aVar) {
            this.f41707e = str;
            this.f41708f = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: d.b.b.e.d.l$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.f41708f.a(this.f41707e, m.this.get(this.f41707e));
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41710e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f41711f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f41712g;

        public b(String str, Object obj, long j) {
            this.f41710e = str;
            this.f41711f = obj;
            this.f41712g = j;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: d.b.b.e.d.m */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            m.this.e(this.f41710e, this.f41711f, this.f41712g);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41714e;

        public c(String str) {
            this.f41714e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.remove(this.f41714e);
        }
    }

    public m(String str, k<T> kVar) {
        this.f41706c = str;
        this.f41705b = kVar;
    }

    @Override // d.b.b.e.d.l
    public void a(String str, T t) {
        i(str, t, 315532800000L);
    }

    @Override // d.b.b.e.d.l.c
    public void b() {
        this.f41705b.g(this.f41706c);
        l();
    }

    @Override // d.b.b.e.d.l.c
    public k<T> c() {
        return this.f41705b;
    }

    @Override // d.b.b.e.d.l
    public void d(String str) {
        d.b.b.e.m.h.a().b(new c(str));
    }

    @Override // d.b.b.e.d.l
    public void e(String str, T t, long j) {
        if (str != null) {
            if (j <= 315532800000L) {
                j += System.currentTimeMillis();
            }
            long j2 = j;
            if (BdBaseApplication.getInst().isDebugMode() && d.b.b.e.p.l.B()) {
                if (!this.f41704a) {
                    BdLog.detailException("access db in main thread!", new Exception());
                } else {
                    throw new RuntimeException("access db in main thread!");
                }
            }
            if (j2 <= System.currentTimeMillis()) {
                remove(str);
                return;
            } else {
                this.f41705b.f(this.f41706c, str, t, j2);
                return;
            }
        }
        throw new NullPointerException("BdKVCache key cannot be null!");
    }

    @Override // d.b.b.e.d.l
    public void f(String str, l.a<T> aVar) {
        d.b.b.e.m.h.a().b(new a(str, aVar));
    }

    @Override // d.b.b.e.d.l
    public void g(String str, T t) {
        e(str, t, 315532800000L);
    }

    @Override // d.b.b.e.d.l
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && d.b.b.e.p.l.B()) {
            if (!this.f41704a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        return this.f41705b.e(this.f41706c, str);
    }

    @Override // d.b.b.e.d.l
    public l.b<T> h(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && d.b.b.e.p.l.B()) {
            if (!this.f41704a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        return this.f41705b.d(this.f41706c, str);
    }

    @Override // d.b.b.e.d.l
    public void i(String str, T t, long j) {
        d.b.b.e.m.h.a().b(new b(str, t, j));
    }

    @Override // d.b.b.e.d.l.c
    public String j() {
        return this.f41706c;
    }

    public void k() {
        this.f41705b.a(this.f41706c);
    }

    public void l() {
        e b2 = c().b();
        if (b2 instanceof e.b) {
            ((e.b) b2).release();
        }
    }

    @Override // d.b.b.e.d.l
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && d.b.b.e.p.l.B()) {
            if (!this.f41704a) {
                BdLog.detailException("access db in main thread!", new Exception());
            } else {
                throw new RuntimeException("access db in main thread!");
            }
        }
        this.f41705b.c(this.f41706c, str);
    }
}
