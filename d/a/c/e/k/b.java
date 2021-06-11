package d.a.c.e.k;

import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f42338a;

    /* renamed from: b  reason: collision with root package name */
    public int f42339b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<T> f42340c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f42341d;

    public b(c<T> cVar, int i2, int i3) {
        this.f42338a = 10;
        this.f42339b = 0;
        this.f42340c = null;
        this.f42341d = null;
        if (cVar != null && i2 > 0 && i3 <= i2) {
            this.f42341d = cVar;
            this.f42338a = i2;
            this.f42339b = i3;
            this.f42340c = new LinkedList<>();
            a(this.f42339b);
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
                    obj = this.f42341d.a(this.f42341d.d());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (obj != null) {
                    this.f42340c.offer(obj);
                }
            }
        }
    }

    public T b() {
        T t;
        synchronized (this) {
            t = null;
            try {
                if (this.f42340c.size() > 0) {
                    t = this.f42341d.a(this.f42340c.poll());
                } else {
                    t = this.f42341d.a(this.f42341d.d());
                }
                a(this.f42339b - this.f42340c.size());
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return t;
    }

    public void c() {
        synchronized (this) {
            this.f42340c.clear();
        }
    }

    public final void d(int i2) {
        synchronized (this) {
            for (int i3 = 0; i3 < i2; i3++) {
                try {
                    this.f42341d.b(this.f42340c.poll());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    public void e(T t) {
        synchronized (this) {
            if (this.f42340c.size() < this.f42338a) {
                T t2 = null;
                try {
                    t2 = this.f42341d.c(t);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                if (t2 != null) {
                    this.f42340c.offer(t2);
                }
            } else {
                this.f42341d.b(t);
            }
        }
    }

    public void f(int i2) {
        synchronized (this) {
            if (i2 < this.f42339b) {
                i2 = this.f42339b;
            }
            if (i2 <= 0) {
                i2 = 1;
            }
            this.f42338a = i2;
            d(this.f42340c.size() - this.f42338a);
        }
    }

    public void g(int i2) {
        synchronized (this) {
            if (i2 > this.f42338a) {
                i2 = this.f42338a;
            }
            this.f42339b = i2;
            a(i2 - this.f42340c.size());
        }
    }
}
