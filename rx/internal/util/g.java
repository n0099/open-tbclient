package rx.internal.util;

import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.a.ae;
import rx.internal.util.a.q;
import rx.k;
/* loaded from: classes2.dex */
public class g implements k {
    public static final int SIZE;
    public volatile Object kap;
    private Queue<Object> queue;
    private final int size;

    static {
        int i = 128;
        if (f.cEs()) {
            i = 16;
        }
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                System.err.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e.getMessage());
            }
        }
        SIZE = i;
    }

    public static g cEw() {
        return ae.cEJ() ? new g(false, SIZE) : new g();
    }

    public static g cEx() {
        return ae.cEJ() ? new g(true, SIZE) : new g();
    }

    private g(Queue<Object> queue, int i) {
        this.queue = queue;
        this.size = i;
    }

    private g(boolean z, int i) {
        this.queue = z ? new rx.internal.util.a.i<>(i) : new q<>(i);
        this.size = i;
    }

    public synchronized void release() {
    }

    @Override // rx.k
    public void unsubscribe() {
        release();
    }

    g() {
        this(new rx.internal.util.atomic.c(SIZE), SIZE);
    }

    public void onNext(Object obj) throws MissingBackpressureException {
        boolean z = true;
        boolean z2 = false;
        synchronized (this) {
            Queue<Object> queue = this.queue;
            if (queue == null) {
                z2 = true;
                z = false;
            } else if (queue.offer(NotificationLite.bm(obj))) {
                z = false;
            }
        }
        if (z2) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
        if (z) {
            throw new MissingBackpressureException();
        }
    }

    public void onCompleted() {
        if (this.kap == null) {
            this.kap = NotificationLite.cDR();
        }
    }

    public boolean isEmpty() {
        Queue<Object> queue = this.queue;
        return queue == null || queue.isEmpty();
    }

    public Object poll() {
        Object obj = null;
        synchronized (this) {
            Queue<Object> queue = this.queue;
            if (queue != null) {
                Object poll = queue.poll();
                obj = this.kap;
                if (poll == null && obj != null && queue.peek() == null) {
                    this.kap = null;
                } else {
                    obj = poll;
                }
            }
        }
        return obj;
    }

    public Object peek() {
        Object obj;
        synchronized (this) {
            Queue<Object> queue = this.queue;
            if (queue == null) {
                obj = null;
            } else {
                Object peek = queue.peek();
                obj = this.kap;
                if (peek != null || obj == null || queue.peek() != null) {
                    obj = peek;
                }
            }
        }
        return obj;
    }

    public boolean bn(Object obj) {
        return NotificationLite.bn(obj);
    }

    public Object bp(Object obj) {
        return NotificationLite.bp(obj);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.queue == null;
    }
}
