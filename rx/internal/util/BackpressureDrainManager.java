package rx.internal.util;

import com.baidu.tieba.j6c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class BackpressureDrainManager extends AtomicLong implements j6c {
    public static final long serialVersionUID = 2826241102729529449L;
    public final a actual;
    public boolean emitting;
    public Throwable exception;
    public volatile boolean terminated;

    /* loaded from: classes2.dex */
    public interface a {
        void a(Throwable th);

        boolean accept(Object obj);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(a aVar) {
        this.actual = aVar;
    }

    public void terminate(Throwable th) {
        if (!this.terminated) {
            this.exception = th;
            this.terminated = true;
        }
    }

    public void terminateAndDrain(Throwable th) {
        if (!this.terminated) {
            this.exception = th;
            this.terminated = true;
            drain();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
        if (r9 == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0036, code lost:
        monitor-enter(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
        r1 = r13.terminated;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
        if (r5.peek() == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003f, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0041, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (get() != Long.MAX_VALUE) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004f, code lost:
        if (r2 != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0051, code lost:
        if (r1 != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0053, code lost:
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0055, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0056, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0057, code lost:
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x005b, code lost:
        r9 = addAndGet(-r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0061, code lost:
        if (r9 == 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0063, code lost:
        if (r2 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0065, code lost:
        if (r1 == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0067, code lost:
        if (r2 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006a, code lost:
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x006d, code lost:
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x006f, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0070, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0071, code lost:
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0073, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0074, code lost:
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        synchronized (this) {
            if (this.emitting) {
                return;
            }
            boolean z = true;
            this.emitting = true;
            boolean z2 = this.terminated;
            long j = get();
            try {
                a aVar = this.actual;
                while (true) {
                    int i = 0;
                    while (true) {
                        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                        try {
                            if (i2 > 0 || z2) {
                                if (z2) {
                                    if (aVar.peek() == null) {
                                        aVar.a(this.exception);
                                        return;
                                    }
                                }
                                Object poll = aVar.poll();
                                if (poll != null) {
                                    if (aVar.accept(poll)) {
                                        return;
                                    }
                                    j--;
                                    i++;
                                }
                            }
                            try {
                                break;
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (!z) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                z = false;
            }
        }
    }

    public boolean isTerminated() {
        return this.terminated;
    }

    public void terminate() {
        this.terminated = true;
    }

    public void terminateAndDrain() {
        this.terminated = true;
        drain();
    }

    @Override // com.baidu.tieba.j6c
    public void request(long j) {
        boolean z;
        if (j == 0) {
            return;
        }
        while (true) {
            long j2 = get();
            boolean z2 = true;
            if (j2 == 0) {
                z = true;
            } else {
                z = false;
            }
            long j3 = Long.MAX_VALUE;
            if (j2 == Long.MAX_VALUE) {
                break;
            }
            if (j == Long.MAX_VALUE) {
                j3 = j;
            } else {
                if (j2 <= Long.MAX_VALUE - j) {
                    j3 = j2 + j;
                }
                z2 = z;
            }
            if (compareAndSet(j2, j3)) {
                z = z2;
                break;
            }
        }
        if (z) {
            drain();
        }
    }
}
