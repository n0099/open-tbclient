package d.b.b.e.k;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f41838a;

    /* renamed from: b  reason: collision with root package name */
    public int f41839b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<T> f41840c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f41841d;

    public b(c<T> cVar, int i, int i2) {
        this.f41838a = 10;
        this.f41839b = 0;
        this.f41840c = null;
        this.f41841d = null;
        if (cVar != null && i > 0 && i2 <= i) {
            this.f41841d = cVar;
            this.f41838a = i;
            this.f41839b = i2;
            this.f41840c = new LinkedList<>();
            a(this.f41839b);
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
                    obj = this.f41841d.a(this.f41841d.d());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (obj != null) {
                    this.f41840c.offer(obj);
                }
            }
        }
    }

    public T b() {
        T t;
        synchronized (this) {
            t = null;
            try {
                if (this.f41840c.size() > 0) {
                    t = this.f41841d.a(this.f41840c.poll());
                } else {
                    t = this.f41841d.a(this.f41841d.d());
                }
                a(this.f41839b - this.f41840c.size());
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return t;
    }

    public void c() {
        synchronized (this) {
            this.f41840c.clear();
        }
    }

    public final void d(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.f41841d.b(this.f41840c.poll());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    public void e(T t) {
        synchronized (this) {
            if (this.f41840c.size() < this.f41838a) {
                T t2 = null;
                try {
                    t2 = this.f41841d.c(t);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (t2 != null) {
                    this.f41840c.offer(t2);
                }
            } else {
                this.f41841d.b(t);
            }
        }
    }

    public void f(int i) {
        synchronized (this) {
            if (i < this.f41839b) {
                i = this.f41839b;
            }
            if (i <= 0) {
                i = 1;
            }
            this.f41838a = i;
            d(this.f41840c.size() - this.f41838a);
        }
    }

    public void g(int i) {
        synchronized (this) {
            if (i > this.f41838a) {
                i = this.f41838a;
            }
            this.f41839b = i;
            a(i - this.f41840c.size());
        }
    }
}
