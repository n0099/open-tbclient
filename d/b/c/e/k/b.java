package d.b.c.e.k;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f42575a;

    /* renamed from: b  reason: collision with root package name */
    public int f42576b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<T> f42577c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f42578d;

    public b(c<T> cVar, int i, int i2) {
        this.f42575a = 10;
        this.f42576b = 0;
        this.f42577c = null;
        this.f42578d = null;
        if (cVar != null && i > 0 && i2 <= i) {
            this.f42578d = cVar;
            this.f42575a = i;
            this.f42576b = i2;
            this.f42577c = new LinkedList<>();
            a(this.f42576b);
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
                    obj = this.f42578d.a(this.f42578d.d());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (obj != null) {
                    this.f42577c.offer(obj);
                }
            }
        }
    }

    public T b() {
        T t;
        synchronized (this) {
            t = null;
            try {
                if (this.f42577c.size() > 0) {
                    t = this.f42578d.a(this.f42577c.poll());
                } else {
                    t = this.f42578d.a(this.f42578d.d());
                }
                a(this.f42576b - this.f42577c.size());
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return t;
    }

    public void c() {
        synchronized (this) {
            this.f42577c.clear();
        }
    }

    public final void d(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    this.f42578d.b(this.f42577c.poll());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    public void e(T t) {
        synchronized (this) {
            if (this.f42577c.size() < this.f42575a) {
                T t2 = null;
                try {
                    t2 = this.f42578d.c(t);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (t2 != null) {
                    this.f42577c.offer(t2);
                }
            } else {
                this.f42578d.b(t);
            }
        }
    }

    public void f(int i) {
        synchronized (this) {
            if (i < this.f42576b) {
                i = this.f42576b;
            }
            if (i <= 0) {
                i = 1;
            }
            this.f42575a = i;
            d(this.f42577c.size() - this.f42575a);
        }
    }

    public void g(int i) {
        synchronized (this) {
            if (i > this.f42575a) {
                i = this.f42575a;
            }
            this.f42576b = i;
            a(i - this.f42577c.size());
        }
    }
}
