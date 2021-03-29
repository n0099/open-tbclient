package h.o.d;

import h.k;
import h.o.d.k.f0;
import h.o.d.k.j;
import h.o.d.k.r;
import java.io.PrintStream;
import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
/* loaded from: classes7.dex */
public class g implements k {

    /* renamed from: g  reason: collision with root package name */
    public static final int f67935g;

    /* renamed from: e  reason: collision with root package name */
    public Queue<Object> f67936e;

    /* renamed from: f  reason: collision with root package name */
    public volatile Object f67937f;

    static {
        int i = f.c() ? 16 : 128;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e2) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e2.getMessage());
            }
        }
        f67935g = i;
    }

    public g(Queue<Object> queue, int i) {
        this.f67936e = queue;
    }

    public static g a() {
        if (f0.b()) {
            return new g(true, f67935g);
        }
        return new g();
    }

    public static g b() {
        if (f0.b()) {
            return new g(false, f67935g);
        }
        return new g();
    }

    public Object c(Object obj) {
        return NotificationLite.e(obj);
    }

    public boolean d(Object obj) {
        return NotificationLite.f(obj);
    }

    public boolean e() {
        Queue<Object> queue = this.f67936e;
        return queue == null || queue.isEmpty();
    }

    public void f() {
        if (this.f67937f == null) {
            this.f67937f = NotificationLite.b();
        }
    }

    public void g(Object obj) throws MissingBackpressureException {
        boolean z;
        boolean z2;
        synchronized (this) {
            Queue<Object> queue = this.f67936e;
            z = true;
            z2 = false;
            if (queue != null) {
                z2 = !queue.offer(NotificationLite.h(obj));
                z = false;
            }
        }
        if (z) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
        if (z2) {
            throw new MissingBackpressureException();
        }
    }

    public Object h() {
        synchronized (this) {
            Queue<Object> queue = this.f67936e;
            if (queue == null) {
                return null;
            }
            Object peek = queue.peek();
            Object obj = this.f67937f;
            if (peek == null && obj != null && queue.peek() == null) {
                peek = obj;
            }
            return peek;
        }
    }

    public Object i() {
        synchronized (this) {
            Queue<Object> queue = this.f67936e;
            if (queue == null) {
                return null;
            }
            Object poll = queue.poll();
            Object obj = this.f67937f;
            if (poll == null && obj != null && queue.peek() == null) {
                this.f67937f = null;
                poll = obj;
            }
            return poll;
        }
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f67936e == null;
    }

    public synchronized void j() {
    }

    @Override // h.k
    public void unsubscribe() {
        j();
    }

    public g(boolean z, int i) {
        this.f67936e = z ? new j<>(i) : new r<>(i);
    }

    public g() {
        this(new h.o.d.j.c(f67935g), f67935g);
    }
}
