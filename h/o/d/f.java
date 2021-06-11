package h.o.d;

import h.k;
import h.o.d.j.f0;
import h.o.d.j.j;
import h.o.d.j.r;
import java.io.PrintStream;
import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
/* loaded from: classes8.dex */
public class f implements k {

    /* renamed from: g  reason: collision with root package name */
    public static final int f71929g;

    /* renamed from: e  reason: collision with root package name */
    public Queue<Object> f71930e;

    /* renamed from: f  reason: collision with root package name */
    public volatile Object f71931f;

    static {
        int i2 = e.c() ? 16 : 128;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i2 = Integer.parseInt(property);
            } catch (NumberFormatException e2) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e2.getMessage());
            }
        }
        f71929g = i2;
    }

    public f(Queue<Object> queue, int i2) {
        this.f71930e = queue;
    }

    public static f a() {
        if (f0.b()) {
            return new f(true, f71929g);
        }
        return new f();
    }

    public static f b() {
        if (f0.b()) {
            return new f(false, f71929g);
        }
        return new f();
    }

    public Object c(Object obj) {
        return NotificationLite.e(obj);
    }

    public boolean d(Object obj) {
        return NotificationLite.f(obj);
    }

    public boolean e() {
        Queue<Object> queue = this.f71930e;
        return queue == null || queue.isEmpty();
    }

    public void f() {
        if (this.f71931f == null) {
            this.f71931f = NotificationLite.b();
        }
    }

    public void g(Object obj) throws MissingBackpressureException {
        boolean z;
        boolean z2;
        synchronized (this) {
            Queue<Object> queue = this.f71930e;
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
            Queue<Object> queue = this.f71930e;
            if (queue == null) {
                return null;
            }
            Object peek = queue.peek();
            Object obj = this.f71931f;
            if (peek == null && obj != null && queue.peek() == null) {
                peek = obj;
            }
            return peek;
        }
    }

    public Object i() {
        synchronized (this) {
            Queue<Object> queue = this.f71930e;
            if (queue == null) {
                return null;
            }
            Object poll = queue.poll();
            Object obj = this.f71931f;
            if (poll == null && obj != null && queue.peek() == null) {
                this.f71931f = null;
                poll = obj;
            }
            return poll;
        }
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f71930e == null;
    }

    public synchronized void j() {
    }

    @Override // h.k
    public void unsubscribe() {
        j();
    }

    public f(boolean z, int i2) {
        this.f71930e = z ? new j<>(i2) : new r<>(i2);
    }

    public f() {
        this(new h.o.d.i.c(f71929g), f71929g);
    }
}
