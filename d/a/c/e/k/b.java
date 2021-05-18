package d.a.c.e.k;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f39021a;

    /* renamed from: b  reason: collision with root package name */
    public int f39022b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<T> f39023c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f39024d;

    public b(c<T> cVar, int i2, int i3) {
        this.f39021a = 10;
        this.f39022b = 0;
        this.f39023c = null;
        this.f39024d = null;
        if (cVar != null && i2 > 0 && i3 <= i2) {
            this.f39024d = cVar;
            this.f39021a = i2;
            this.f39022b = i3;
            this.f39023c = new LinkedList<>();
            a(this.f39022b);
            return;
        }
        throw new InvalidParameterException("invalid params");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.LinkedList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(int i2) {
        synchronized (this) {
            for (int i3 = 0; i3 < i2; i3++) {
                Object obj = null;
                try {
                    obj = this.f39024d.a(this.f39024d.d());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (obj != null) {
                    this.f39023c.offer(obj);
                }
            }
        }
    }

    public T b() {
        T t;
        synchronized (this) {
            t = null;
            try {
                if (this.f39023c.size() > 0) {
                    t = this.f39024d.a(this.f39023c.poll());
                } else {
                    t = this.f39024d.a(this.f39024d.d());
                }
                a(this.f39022b - this.f39023c.size());
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return t;
    }

    public void c() {
        synchronized (this) {
            this.f39023c.clear();
        }
    }

    public final void d(int i2) {
        synchronized (this) {
            for (int i3 = 0; i3 < i2; i3++) {
                try {
                    this.f39024d.b(this.f39023c.poll());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    public void e(T t) {
        synchronized (this) {
            if (this.f39023c.size() < this.f39021a) {
                T t2 = null;
                try {
                    t2 = this.f39024d.c(t);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (t2 != null) {
                    this.f39023c.offer(t2);
                }
            } else {
                this.f39024d.b(t);
            }
        }
    }

    public void f(int i2) {
        synchronized (this) {
            if (i2 < this.f39022b) {
                i2 = this.f39022b;
            }
            if (i2 <= 0) {
                i2 = 1;
            }
            this.f39021a = i2;
            d(this.f39023c.size() - this.f39021a);
        }
    }

    public void g(int i2) {
        synchronized (this) {
            if (i2 > this.f39021a) {
                i2 = this.f39021a;
            }
            this.f39022b = i2;
            a(i2 - this.f39023c.size());
        }
    }
}
