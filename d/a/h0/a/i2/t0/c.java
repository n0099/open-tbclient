package d.a.h0.a.i2.t0;

import d.a.h0.a.i2.k0;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes3.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<a> f42827a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    public a f42828b;

    @Override // d.a.h0.a.i2.t0.b
    public void a(a aVar) {
        synchronized (this.f42827a) {
            if (aVar == this.f42828b) {
                e();
            }
        }
    }

    public final void b() {
        synchronized (this.f42827a) {
            if (this.f42828b != null) {
                return;
            }
            e();
        }
    }

    public synchronized void c() {
        if (this.f42828b != null) {
            this.f42828b.a();
            this.f42828b = null;
        }
        this.f42827a.clear();
    }

    public void d(a aVar) {
        if (aVar != null) {
            synchronized (this.f42827a) {
                Queue<a> queue = this.f42827a;
                aVar.b(this);
                queue.offer(aVar);
            }
        }
        b();
    }

    public final void e() {
        synchronized (this.f42827a) {
            this.f42828b = null;
            if (this.f42827a.isEmpty()) {
                return;
            }
            a poll = this.f42827a.poll();
            this.f42828b = poll;
            if (poll == null) {
                e();
            } else {
                k0.T(poll);
            }
        }
    }
}
