package rx.internal.util;

import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.a.ae;
import rx.internal.util.a.q;
import rx.k;
/* loaded from: classes6.dex */
public class g implements k {
    public static final int SIZE;
    public volatile Object nJd;
    private Queue<Object> queue;
    private final int size;

    static {
        int i = 128;
        if (f.isAndroid()) {
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

    public static g dPY() {
        return ae.dQh() ? new g(false, SIZE) : new g();
    }

    public static g dPZ() {
        return ae.dQh() ? new g(true, SIZE) : new g();
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
            } else if (queue.offer(NotificationLite.next(obj))) {
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
        if (this.nJd == null) {
            this.nJd = NotificationLite.dPB();
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
                obj = this.nJd;
                if (poll == null && obj != null && queue.peek() == null) {
                    this.nJd = null;
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
                obj = this.nJd;
                if (peek != null || obj == null || queue.peek() != null) {
                    obj = peek;
                }
            }
        }
        return obj;
    }

    public boolean bU(Object obj) {
        return NotificationLite.bU(obj);
    }

    public Object getValue(Object obj) {
        return NotificationLite.getValue(obj);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.queue == null;
    }
}
