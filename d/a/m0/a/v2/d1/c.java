package d.a.m0.a.v2.d1;

import d.a.m0.a.v2.q0;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes3.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<a> f49176a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    public a f49177b;

    @Override // d.a.m0.a.v2.d1.b
    public void a(a aVar) {
        synchronized (this.f49176a) {
            if (aVar == this.f49177b) {
                e();
            }
        }
    }

    public final void b() {
        synchronized (this.f49176a) {
            if (this.f49177b != null) {
                return;
            }
            e();
        }
    }

    public synchronized void c() {
        if (this.f49177b != null) {
            this.f49177b.a();
            this.f49177b = null;
        }
        this.f49176a.clear();
    }

    public void d(a aVar) {
        if (aVar != null) {
            synchronized (this.f49176a) {
                Queue<a> queue = this.f49176a;
                aVar.b(this);
                queue.offer(aVar);
            }
        }
        b();
    }

    public final void e() {
        synchronized (this.f49176a) {
            this.f49177b = null;
            if (this.f49176a.isEmpty()) {
                return;
            }
            a poll = this.f49176a.poll();
            this.f49177b = poll;
            if (poll == null) {
                e();
            } else {
                q0.X(poll);
            }
        }
    }
}
