package d.a.c.e.k;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f39776a;

    /* renamed from: b  reason: collision with root package name */
    public int f39777b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<T> f39778c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f39779d;

    public b(c<T> cVar, int i2, int i3) {
        this.f39776a = 10;
        this.f39777b = 0;
        this.f39778c = null;
        this.f39779d = null;
        if (cVar != null && i2 > 0 && i3 <= i2) {
            this.f39779d = cVar;
            this.f39776a = i2;
            this.f39777b = i3;
            this.f39778c = new LinkedList<>();
            a(this.f39777b);
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
                    obj = this.f39779d.a(this.f39779d.d());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (obj != null) {
                    this.f39778c.offer(obj);
                }
            }
        }
    }

    public T b() {
        T t;
        synchronized (this) {
            t = null;
            try {
                if (this.f39778c.size() > 0) {
                    t = this.f39779d.a(this.f39778c.poll());
                } else {
                    t = this.f39779d.a(this.f39779d.d());
                }
                a(this.f39777b - this.f39778c.size());
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return t;
    }

    public void c() {
        synchronized (this) {
            this.f39778c.clear();
        }
    }

    public final void d(int i2) {
        synchronized (this) {
            for (int i3 = 0; i3 < i2; i3++) {
                try {
                    this.f39779d.b(this.f39778c.poll());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    public void e(T t) {
        synchronized (this) {
            if (this.f39778c.size() < this.f39776a) {
                T t2 = null;
                try {
                    t2 = this.f39779d.c(t);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (t2 != null) {
                    this.f39778c.offer(t2);
                }
            } else {
                this.f39779d.b(t);
            }
        }
    }

    public void f(int i2) {
        synchronized (this) {
            if (i2 < this.f39777b) {
                i2 = this.f39777b;
            }
            if (i2 <= 0) {
                i2 = 1;
            }
            this.f39776a = i2;
            d(this.f39778c.size() - this.f39776a);
        }
    }

    public void g(int i2) {
        synchronized (this) {
            if (i2 > this.f39776a) {
                i2 = this.f39776a;
            }
            this.f39777b = i2;
            a(i2 - this.f39778c.size());
        }
    }
}
