package d.b.h0.a.i2.t0;

import d.b.h0.a.i2.k0;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes3.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<a> f45507a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    public a f45508b;

    @Override // d.b.h0.a.i2.t0.b
    public void a(a aVar) {
        synchronized (this.f45507a) {
            if (aVar == this.f45508b) {
                e();
            }
        }
    }

    public final void b() {
        synchronized (this.f45507a) {
            if (this.f45508b != null) {
                return;
            }
            e();
        }
    }

    public synchronized void c() {
        if (this.f45508b != null) {
            this.f45508b.a();
            this.f45508b = null;
        }
        this.f45507a.clear();
    }

    public void d(a aVar) {
        if (aVar != null) {
            synchronized (this.f45507a) {
                Queue<a> queue = this.f45507a;
                aVar.b(this);
                queue.offer(aVar);
            }
        }
        b();
    }

    public final void e() {
        synchronized (this.f45507a) {
            this.f45508b = null;
            if (this.f45507a.isEmpty()) {
                return;
            }
            a poll = this.f45507a.poll();
            this.f45508b = poll;
            if (poll == null) {
                e();
            } else {
                k0.T(poll);
            }
        }
    }
}
