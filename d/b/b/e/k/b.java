package d.b.b.e.k;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f41837a;

    /* renamed from: b  reason: collision with root package name */
    public int f41838b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<T> f41839c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f41840d;

    public b(c<T> cVar, int i, int i2) {
        this.f41837a = 10;
        this.f41838b = 0;
        this.f41839c = null;
        this.f41840d = null;
        if (cVar != null && i > 0 && i2 <= i) {
            this.f41840d = cVar;
            this.f41837a = i;
            this.f41838b = i2;
            this.f41839c = new LinkedList<>();
            a(this.f41838b);
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
                    obj = this.f41840d.a(this.f41840d.d());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (obj != null) {
                    this.f41839c.offer(obj);
                }
            }
        }
    }

    public T b() {
        T t;
        synchronized (this) {
            t = null;
            try {
                if (this.f41839c.size() > 0) {
                    t = this.f41840d.a(this.f41839c.poll());
                } else {
                    t = this.f41840d.a(this.f41840d.d());
                }
                a(this.f41838b - this.f41839c.size());
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return t;
    }

    public void c() {
        synchronized (this) {
            this.f41839c.clear();
        }
    }

    public final void d(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.f41840d.b(this.f41839c.poll());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    public void e(T t) {
        synchronized (this) {
            if (this.f41839c.size() < this.f41837a) {
                T t2 = null;
                try {
                    t2 = this.f41840d.c(t);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (t2 != null) {
                    this.f41839c.offer(t2);
                }
            } else {
                this.f41840d.b(t);
            }
        }
    }

    public void f(int i) {
        synchronized (this) {
            if (i < this.f41838b) {
                i = this.f41838b;
            }
            if (i <= 0) {
                i = 1;
            }
            this.f41837a = i;
            d(this.f41839c.size() - this.f41837a);
        }
    }

    public void g(int i) {
        synchronized (this) {
            if (i > this.f41837a) {
                i = this.f41837a;
            }
            this.f41838b = i;
            a(i - this.f41839c.size());
        }
    }
}
