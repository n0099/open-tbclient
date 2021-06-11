package d.a.l0.a.o0;

import androidx.annotation.NonNull;
import d.a.l0.a.v2.q0;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public class b implements d.a.l0.a.f1.f.a {

    /* renamed from: b  reason: collision with root package name */
    public Queue<c> f47576b;

    /* renamed from: d.a.l0.a.o0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0838b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f47577a = new b();
    }

    public static b b() {
        return C0838b.f47577a;
    }

    public synchronized void a() {
        this.f47576b.clear();
    }

    public synchronized void c(@NonNull c cVar, String str) {
        while (this.f47576b.size() > 0) {
            c peek = this.f47576b.peek();
            if (peek == null) {
                this.f47576b.remove();
            } else if (peek.a()) {
                break;
            } else {
                this.f47576b.remove();
            }
        }
        int size = this.f47576b.size();
        if (size == 0) {
            this.f47576b.offer(cVar);
            q0.d0(cVar);
        } else {
            c peek2 = this.f47576b.peek();
            this.f47576b.offer(cVar);
            if (size == 1 && peek2 != null && peek2.b(str)) {
                q0.d0(cVar);
            } else {
                q0.q().post(cVar);
            }
        }
    }

    public b() {
        this.f47576b = new ConcurrentLinkedQueue();
    }
}
