package rx.internal.util;

import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.a.ae;
import rx.internal.util.a.q;
import rx.k;
/* loaded from: classes2.dex */
public class h implements k {
    public static final int SIZE;
    public volatile Object iEQ;
    private Queue<Object> queue;
    private final int size;

    static {
        int i = 128;
        if (g.ccm()) {
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

    public static h ccq() {
        return ae.ccD() ? new h(false, SIZE) : new h();
    }

    public static h ccr() {
        return ae.ccD() ? new h(true, SIZE) : new h();
    }

    private h(Queue<Object> queue, int i) {
        this.queue = queue;
        this.size = i;
    }

    private h(boolean z, int i) {
        this.queue = z ? new rx.internal.util.a.i<>(i) : new q<>(i);
        this.size = i;
    }

    public synchronized void release() {
    }

    @Override // rx.k
    public void unsubscribe() {
        release();
    }

    h() {
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
            } else if (queue.offer(NotificationLite.aX(obj))) {
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
        if (this.iEQ == null) {
            this.iEQ = NotificationLite.cbe();
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
                obj = this.iEQ;
                if (poll == null && obj != null && queue.peek() == null) {
                    this.iEQ = null;
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
                obj = this.iEQ;
                if (peek != null || obj == null || queue.peek() != null) {
                    obj = peek;
                }
            }
        }
        return obj;
    }

    public boolean aY(Object obj) {
        return NotificationLite.aY(obj);
    }

    public Object ba(Object obj) {
        return NotificationLite.ba(obj);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.queue == null;
    }
}
