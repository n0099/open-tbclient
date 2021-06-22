package d.a.c.e.k;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f42441a;

    /* renamed from: b  reason: collision with root package name */
    public int f42442b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<T> f42443c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f42444d;

    public b(c<T> cVar, int i2, int i3) {
        this.f42441a = 10;
        this.f42442b = 0;
        this.f42443c = null;
        this.f42444d = null;
        if (cVar != null && i2 > 0 && i3 <= i2) {
            this.f42444d = cVar;
            this.f42441a = i2;
            this.f42442b = i3;
            this.f42443c = new LinkedList<>();
            a(this.f42442b);
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
                    obj = this.f42444d.a(this.f42444d.d());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (obj != null) {
                    this.f42443c.offer(obj);
                }
            }
        }
    }

    public T b() {
        T t;
        synchronized (this) {
            t = null;
            try {
                if (this.f42443c.size() > 0) {
                    t = this.f42444d.a(this.f42443c.poll());
                } else {
                    t = this.f42444d.a(this.f42444d.d());
                }
                a(this.f42442b - this.f42443c.size());
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return t;
    }

    public void c() {
        synchronized (this) {
            this.f42443c.clear();
        }
    }

    public final void d(int i2) {
        synchronized (this) {
            for (int i3 = 0; i3 < i2; i3++) {
                try {
                    this.f42444d.b(this.f42443c.poll());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    public void e(T t) {
        synchronized (this) {
            if (this.f42443c.size() < this.f42441a) {
                T t2 = null;
                try {
                    t2 = this.f42444d.c(t);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (t2 != null) {
                    this.f42443c.offer(t2);
                }
            } else {
                this.f42444d.b(t);
            }
        }
    }

    public void f(int i2) {
        synchronized (this) {
            if (i2 < this.f42442b) {
                i2 = this.f42442b;
            }
            if (i2 <= 0) {
                i2 = 1;
            }
            this.f42441a = i2;
            d(this.f42443c.size() - this.f42441a);
        }
    }

    public void g(int i2) {
        synchronized (this) {
            if (i2 > this.f42441a) {
                i2 = this.f42441a;
            }
            this.f42442b = i2;
            a(i2 - this.f42443c.size());
        }
    }
}
