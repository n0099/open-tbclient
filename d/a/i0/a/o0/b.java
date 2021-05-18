package d.a.i0.a.o0;

import androidx.annotation.NonNull;
import d.a.i0.a.v2.q0;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
public class b implements d.a.i0.a.f1.f.a {

    /* renamed from: b  reason: collision with root package name */
    public Queue<c> f43726b;

    /* renamed from: d.a.i0.a.o0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0771b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f43727a = new b();
    }

    public static b b() {
        return C0771b.f43727a;
    }

    public synchronized void a() {
        this.f43726b.clear();
    }

    public synchronized void c(@NonNull c cVar, String str) {
        while (this.f43726b.size() > 0) {
            c peek = this.f43726b.peek();
            if (peek == null) {
                this.f43726b.remove();
            } else if (peek.a()) {
                break;
            } else {
                this.f43726b.remove();
            }
        }
        int size = this.f43726b.size();
        if (size == 0) {
            this.f43726b.offer(cVar);
            q0.d0(cVar);
        } else {
            c peek2 = this.f43726b.peek();
            this.f43726b.offer(cVar);
            if (size == 1 && peek2 != null && peek2.b(str)) {
                q0.d0(cVar);
            } else {
                q0.q().post(cVar);
            }
        }
    }

    public b() {
        this.f43726b = new ConcurrentLinkedQueue();
    }
}
