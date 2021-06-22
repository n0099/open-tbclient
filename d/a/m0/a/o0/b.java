package d.a.m0.a.o0;

import androidx.annotation.NonNull;
import d.a.m0.a.v2.q0;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public class b implements d.a.m0.a.f1.f.a {

    /* renamed from: b  reason: collision with root package name */
    public Queue<c> f47684b;

    /* renamed from: d.a.m0.a.o0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0841b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f47685a = new b();
    }

    public static b b() {
        return C0841b.f47685a;
    }

    public synchronized void a() {
        this.f47684b.clear();
    }

    public synchronized void c(@NonNull c cVar, String str) {
        while (this.f47684b.size() > 0) {
            c peek = this.f47684b.peek();
            if (peek == null) {
                this.f47684b.remove();
            } else if (peek.a()) {
                break;
            } else {
                this.f47684b.remove();
            }
        }
        int size = this.f47684b.size();
        if (size == 0) {
            this.f47684b.offer(cVar);
            q0.d0(cVar);
        } else {
            c peek2 = this.f47684b.peek();
            this.f47684b.offer(cVar);
            if (size == 1 && peek2 != null && peek2.b(str)) {
                q0.d0(cVar);
            } else {
                q0.q().post(cVar);
            }
        }
    }

    public b() {
        this.f47684b = new ConcurrentLinkedQueue();
    }
}
