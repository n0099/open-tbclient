package d.b.c.e.k;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f42335a;

    /* renamed from: b  reason: collision with root package name */
    public int f42336b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<T> f42337c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f42338d;

    public b(c<T> cVar, int i, int i2) {
        this.f42335a = 10;
        this.f42336b = 0;
        this.f42337c = null;
        this.f42338d = null;
        if (cVar != null && i > 0 && i2 <= i) {
            this.f42338d = cVar;
            this.f42335a = i;
            this.f42336b = i2;
            this.f42337c = new LinkedList<>();
            a(this.f42336b);
            return;
        }
        throw new InvalidParameterException("invalid params");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.LinkedList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = null;
                try {
                    obj = this.f42338d.a(this.f42338d.d());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (obj != null) {
                    this.f42337c.offer(obj);
                }
            }
        }
    }

    public T b() {
        T t;
        synchronized (this) {
            t = null;
            try {
                if (this.f42337c.size() > 0) {
                    t = this.f42338d.a(this.f42337c.poll());
                } else {
                    t = this.f42338d.a(this.f42338d.d());
                }
                a(this.f42336b - this.f42337c.size());
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return t;
    }

    public void c() {
        synchronized (this) {
            this.f42337c.clear();
        }
    }

    public final void d(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.f42338d.b(this.f42337c.poll());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    public void e(T t) {
        synchronized (this) {
            if (this.f42337c.size() < this.f42335a) {
                T t2 = null;
                try {
                    t2 = this.f42338d.c(t);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (t2 != null) {
                    this.f42337c.offer(t2);
                }
            } else {
                this.f42338d.b(t);
            }
        }
    }

    public void f(int i) {
        synchronized (this) {
            if (i < this.f42336b) {
                i = this.f42336b;
            }
            if (i <= 0) {
                i = 1;
            }
            this.f42335a = i;
            d(this.f42337c.size() - this.f42335a);
        }
    }

    public void g(int i) {
        synchronized (this) {
            if (i > this.f42335a) {
                i = this.f42335a;
            }
            this.f42336b = i;
            a(i - this.f42337c.size());
        }
    }
}
