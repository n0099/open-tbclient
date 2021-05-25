package d.a.c.e.k;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f38685a;

    /* renamed from: b  reason: collision with root package name */
    public int f38686b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<T> f38687c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f38688d;

    public b(c<T> cVar, int i2, int i3) {
        this.f38685a = 10;
        this.f38686b = 0;
        this.f38687c = null;
        this.f38688d = null;
        if (cVar != null && i2 > 0 && i3 <= i2) {
            this.f38688d = cVar;
            this.f38685a = i2;
            this.f38686b = i3;
            this.f38687c = new LinkedList<>();
            a(this.f38686b);
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
                    obj = this.f38688d.a(this.f38688d.d());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (obj != null) {
                    this.f38687c.offer(obj);
                }
            }
        }
    }

    public T b() {
        T t;
        synchronized (this) {
            t = null;
            try {
                if (this.f38687c.size() > 0) {
                    t = this.f38688d.a(this.f38687c.poll());
                } else {
                    t = this.f38688d.a(this.f38688d.d());
                }
                a(this.f38686b - this.f38687c.size());
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return t;
    }

    public void c() {
        synchronized (this) {
            this.f38687c.clear();
        }
    }

    public final void d(int i2) {
        synchronized (this) {
            for (int i3 = 0; i3 < i2; i3++) {
                try {
                    this.f38688d.b(this.f38687c.poll());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    public void e(T t) {
        synchronized (this) {
            if (this.f38687c.size() < this.f38685a) {
                T t2 = null;
                try {
                    t2 = this.f38688d.c(t);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (t2 != null) {
                    this.f38687c.offer(t2);
                }
            } else {
                this.f38688d.b(t);
            }
        }
    }

    public void f(int i2) {
        synchronized (this) {
            if (i2 < this.f38686b) {
                i2 = this.f38686b;
            }
            if (i2 <= 0) {
                i2 = 1;
            }
            this.f38685a = i2;
            d(this.f38687c.size() - this.f38685a);
        }
    }

    public void g(int i2) {
        synchronized (this) {
            if (i2 > this.f38685a) {
                i2 = this.f38685a;
            }
            this.f38686b = i2;
            a(i2 - this.f38687c.size());
        }
    }
}
