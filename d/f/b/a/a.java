package d.f.b.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public long f66000b;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f65999a = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public Runnable f66001c = new RunnableC1807a();

    /* renamed from: d.f.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1807a implements Runnable {
        public RunnableC1807a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
            if (a.this.f65999a.get()) {
                e.a().postDelayed(a.this.f66001c, a.this.f66000b);
            }
        }
    }

    public a(long j) {
        this.f66000b = 0 == j ? 300L : j;
    }

    public abstract void b();

    public void c() {
        if (this.f65999a.get()) {
            return;
        }
        this.f65999a.set(true);
        e.a().removeCallbacks(this.f66001c);
        e.a().postDelayed(this.f66001c, c.f().j());
    }

    public void d() {
        if (this.f65999a.get()) {
            this.f65999a.set(false);
            e.a().removeCallbacks(this.f66001c);
        }
    }
}
