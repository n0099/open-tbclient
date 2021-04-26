package d.f.b.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public long f65405b;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f65404a = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public Runnable f65406c = new RunnableC1779a();

    /* renamed from: d.f.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1779a implements Runnable {
        public RunnableC1779a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
            if (a.this.f65404a.get()) {
                e.a().postDelayed(a.this.f65406c, a.this.f65405b);
            }
        }
    }

    public a(long j) {
        this.f65405b = 0 == j ? 300L : j;
    }

    public abstract void b();

    public void c() {
        if (this.f65404a.get()) {
            return;
        }
        this.f65404a.set(true);
        e.a().removeCallbacks(this.f65406c);
        e.a().postDelayed(this.f65406c, c.f().j());
    }

    public void d() {
        if (this.f65404a.get()) {
            this.f65404a.set(false);
            e.a().removeCallbacks(this.f65406c);
        }
    }
}
