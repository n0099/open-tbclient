package d.g.b.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public long f66992b;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f66991a = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public Runnable f66993c = new RunnableC1839a();

    /* renamed from: d.g.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1839a implements Runnable {
        public RunnableC1839a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
            if (a.this.f66991a.get()) {
                e.a().postDelayed(a.this.f66993c, a.this.f66992b);
            }
        }
    }

    public a(long j) {
        this.f66992b = 0 == j ? 300L : j;
    }

    public abstract void b();

    public void c() {
        if (this.f66991a.get()) {
            return;
        }
        this.f66991a.set(true);
        e.a().removeCallbacks(this.f66993c);
        e.a().postDelayed(this.f66993c, c.f().j());
    }

    public void d() {
        if (this.f66991a.get()) {
            this.f66991a.set(false);
            e.a().removeCallbacks(this.f66993c);
        }
    }
}
