package d.f.b.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public long f66091b;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f66090a = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public Runnable f66092c = new RunnableC1843a();

    /* renamed from: d.f.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1843a implements Runnable {
        public RunnableC1843a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
            if (a.this.f66090a.get()) {
                e.a().postDelayed(a.this.f66092c, a.this.f66091b);
            }
        }
    }

    public a(long j) {
        this.f66091b = 0 == j ? 300L : j;
    }

    public abstract void b();

    public void c() {
        if (this.f66090a.get()) {
            return;
        }
        this.f66090a.set(true);
        e.a().removeCallbacks(this.f66092c);
        e.a().postDelayed(this.f66092c, c.f().j());
    }

    public void d() {
        if (this.f66090a.get()) {
            this.f66090a.set(false);
            e.a().removeCallbacks(this.f66092c);
        }
    }
}
