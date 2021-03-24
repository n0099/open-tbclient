package d.f.b.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public long f65999b;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f65998a = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public Runnable f66000c = new RunnableC1806a();

    /* renamed from: d.f.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1806a implements Runnable {
        public RunnableC1806a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
            if (a.this.f65998a.get()) {
                e.a().postDelayed(a.this.f66000c, a.this.f65999b);
            }
        }
    }

    public a(long j) {
        this.f65999b = 0 == j ? 300L : j;
    }

    public abstract void b();

    public void c() {
        if (this.f65998a.get()) {
            return;
        }
        this.f65998a.set(true);
        e.a().removeCallbacks(this.f66000c);
        e.a().postDelayed(this.f66000c, c.f().j());
    }

    public void d() {
        if (this.f65998a.get()) {
            this.f65998a.set(false);
            e.a().removeCallbacks(this.f66000c);
        }
    }
}
