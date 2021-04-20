package d.b.g0.a.i2.t0;

import d.b.g0.a.i2.k0;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes3.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<a> f45178a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    public a f45179b;

    @Override // d.b.g0.a.i2.t0.b
    public void a(a aVar) {
        synchronized (this.f45178a) {
            if (aVar == this.f45179b) {
                e();
            }
        }
    }

    public final void b() {
        synchronized (this.f45178a) {
            if (this.f45179b != null) {
                return;
            }
            e();
        }
    }

    public synchronized void c() {
        if (this.f45179b != null) {
            this.f45179b.a();
            this.f45179b = null;
        }
        this.f45178a.clear();
    }

    public void d(a aVar) {
        if (aVar != null) {
            synchronized (this.f45178a) {
                Queue<a> queue = this.f45178a;
                aVar.b(this);
                queue.offer(aVar);
            }
        }
        b();
    }

    public final void e() {
        synchronized (this.f45178a) {
            this.f45179b = null;
            if (this.f45178a.isEmpty()) {
                return;
            }
            a poll = this.f45178a.poll();
            this.f45179b = poll;
            if (poll == null) {
                e();
            } else {
                k0.T(poll);
            }
        }
    }
}
