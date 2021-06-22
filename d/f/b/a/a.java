package d.f.b.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public long f69969b;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f69968a = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public Runnable f69970c = new RunnableC1909a();

    /* renamed from: d.f.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1909a implements Runnable {
        public RunnableC1909a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
            if (a.this.f69968a.get()) {
                e.a().postDelayed(a.this.f69970c, a.this.f69969b);
            }
        }
    }

    public a(long j) {
        this.f69969b = 0 == j ? 300L : j;
    }

    public abstract void b();

    public void c() {
        if (this.f69968a.get()) {
            return;
        }
        this.f69968a.set(true);
        e.a().removeCallbacks(this.f69970c);
        e.a().postDelayed(this.f69970c, c.f().j());
    }

    public void d() {
        if (this.f69968a.get()) {
            this.f69968a.set(false);
            e.a().removeCallbacks(this.f69970c);
        }
    }
}
