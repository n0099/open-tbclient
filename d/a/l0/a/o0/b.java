package d.a.l0.a.o0;

import androidx.annotation.NonNull;
import d.a.l0.a.v2.q0;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
public class b implements d.a.l0.a.f1.f.a {

    /* renamed from: b  reason: collision with root package name */
    public Queue<c> f43900b;

    /* renamed from: d.a.l0.a.o0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0782b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f43901a = new b();
    }

    public static b b() {
        return C0782b.f43901a;
    }

    public synchronized void a() {
        this.f43900b.clear();
    }

    public synchronized void c(@NonNull c cVar, String str) {
        while (this.f43900b.size() > 0) {
            c peek = this.f43900b.peek();
            if (peek == null) {
                this.f43900b.remove();
            } else if (peek.a()) {
                break;
            } else {
                this.f43900b.remove();
            }
        }
        int size = this.f43900b.size();
        if (size == 0) {
            this.f43900b.offer(cVar);
            q0.d0(cVar);
        } else {
            c peek2 = this.f43900b.peek();
            this.f43900b.offer(cVar);
            if (size == 1 && peek2 != null && peek2.b(str)) {
                q0.d0(cVar);
            } else {
                q0.q().post(cVar);
            }
        }
    }

    public b() {
        this.f43900b = new ConcurrentLinkedQueue();
    }
}
