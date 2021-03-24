package d.b.g0.a.i2.t0;

import d.b.g0.a.i2.k0;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes3.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<a> f44785a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    public a f44786b;

    @Override // d.b.g0.a.i2.t0.b
    public void a(a aVar) {
        synchronized (this.f44785a) {
            if (aVar == this.f44786b) {
                e();
            }
        }
    }

    public final void b() {
        synchronized (this.f44785a) {
            if (this.f44786b != null) {
                return;
            }
            e();
        }
    }

    public synchronized void c() {
        if (this.f44786b != null) {
            this.f44786b.a();
            this.f44786b = null;
        }
        this.f44785a.clear();
    }

    public void d(a aVar) {
        if (aVar != null) {
            synchronized (this.f44785a) {
                Queue<a> queue = this.f44785a;
                aVar.b(this);
                queue.offer(aVar);
            }
        }
        b();
    }

    public final void e() {
        synchronized (this.f44785a) {
            this.f44786b = null;
            if (this.f44785a.isEmpty()) {
                return;
            }
            a poll = this.f44785a.poll();
            this.f44786b = poll;
            if (poll == null) {
                e();
            } else {
                k0.T(poll);
            }
        }
    }
}
