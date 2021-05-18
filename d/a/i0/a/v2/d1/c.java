package d.a.i0.a.v2.d1;

import d.a.i0.a.v2.q0;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes3.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<a> f45218a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    public a f45219b;

    @Override // d.a.i0.a.v2.d1.b
    public void a(a aVar) {
        synchronized (this.f45218a) {
            if (aVar == this.f45219b) {
                e();
            }
        }
    }

    public final void b() {
        synchronized (this.f45218a) {
            if (this.f45219b != null) {
                return;
            }
            e();
        }
    }

    public synchronized void c() {
        if (this.f45219b != null) {
            this.f45219b.a();
            this.f45219b = null;
        }
        this.f45218a.clear();
    }

    public void d(a aVar) {
        if (aVar != null) {
            synchronized (this.f45218a) {
                Queue<a> queue = this.f45218a;
                aVar.b(this);
                queue.offer(aVar);
            }
        }
        b();
    }

    public final void e() {
        synchronized (this.f45218a) {
            this.f45219b = null;
            if (this.f45218a.isEmpty()) {
                return;
            }
            a poll = this.f45218a.poll();
            this.f45219b = poll;
            if (poll == null) {
                e();
            } else {
                q0.X(poll);
            }
        }
    }
}
