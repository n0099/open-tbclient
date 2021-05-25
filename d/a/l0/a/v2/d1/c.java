package d.a.l0.a.v2.d1;

import d.a.l0.a.v2.q0;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes3.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<a> f45394a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    public a f45395b;

    @Override // d.a.l0.a.v2.d1.b
    public void a(a aVar) {
        synchronized (this.f45394a) {
            if (aVar == this.f45395b) {
                e();
            }
        }
    }

    public final void b() {
        synchronized (this.f45394a) {
            if (this.f45395b != null) {
                return;
            }
            e();
        }
    }

    public synchronized void c() {
        if (this.f45395b != null) {
            this.f45395b.a();
            this.f45395b = null;
        }
        this.f45394a.clear();
    }

    public void d(a aVar) {
        if (aVar != null) {
            synchronized (this.f45394a) {
                Queue<a> queue = this.f45394a;
                aVar.b(this);
                queue.offer(aVar);
            }
        }
        b();
    }

    public final void e() {
        synchronized (this.f45394a) {
            this.f45395b = null;
            if (this.f45394a.isEmpty()) {
                return;
            }
            a poll = this.f45394a.poll();
            this.f45395b = poll;
            if (poll == null) {
                e();
            } else {
                q0.X(poll);
            }
        }
    }
}
