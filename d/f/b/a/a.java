package d.f.b.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public long f66845b;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f66844a = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public Runnable f66846c = new RunnableC1835a();

    /* renamed from: d.f.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1835a implements Runnable {
        public RunnableC1835a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
            if (a.this.f66844a.get()) {
                e.a().postDelayed(a.this.f66846c, a.this.f66845b);
            }
        }
    }

    public a(long j) {
        this.f66845b = 0 == j ? 300L : j;
    }

    public abstract void b();

    public void c() {
        if (this.f66844a.get()) {
            return;
        }
        this.f66844a.set(true);
        e.a().removeCallbacks(this.f66846c);
        e.a().postDelayed(this.f66846c, c.f().j());
    }

    public void d() {
        if (this.f66844a.get()) {
            this.f66844a.set(false);
            e.a().removeCallbacks(this.f66846c);
        }
    }
}
