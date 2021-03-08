package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public final class BackpressureDrainManager extends AtomicLong implements rx.f {
    private static final long serialVersionUID = 2826241102729529449L;
    final a actual;
    boolean emitting;
    Throwable exception;
    volatile boolean terminated;

    /* loaded from: classes4.dex */
    public interface a {
        void Y(Throwable th);

        boolean ce(Object obj);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(a aVar) {
        this.actual = aVar;
    }

    public boolean isTerminated() {
        return this.terminated;
    }

    public void terminate() {
        this.terminated = true;
    }

    public void terminate(Throwable th) {
        if (!this.terminated) {
            this.exception = th;
            this.terminated = true;
        }
    }

    public void terminateAndDrain() {
        this.terminated = true;
        drain();
    }

    public void terminateAndDrain(Throwable th) {
        if (!this.terminated) {
            this.exception = th;
            this.terminated = true;
            drain();
        }
    }

    @Override // rx.f
    public void request(long j) {
        long j2;
        boolean z;
        long j3;
        if (j != 0) {
            do {
                j2 = get();
                z = j2 == 0;
                if (j2 == Long.MAX_VALUE) {
                    break;
                } else if (j == Long.MAX_VALUE) {
                    j3 = j;
                    z = true;
                } else {
                    j3 = j2 > Long.MAX_VALUE - j ? Long.MAX_VALUE : j2 + j;
                }
            } while (!compareAndSet(j2, j3));
            if (z) {
                drain();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0043, code lost:
        monitor-enter(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0044, code lost:
        r2 = r14.terminated;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004a, code lost:
        if (r9.peek() == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004c, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0053, code lost:
        if (get() != Long.MAX_VALUE) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0055, code lost:
        if (r5 != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0057, code lost:
        if (r2 != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x005a, code lost:
        r14.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x005c, code lost:
        monitor-exit(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x005e, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x005f, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0060, code lost:
        monitor-exit(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0061, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0062, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0063, code lost:
        r4 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0078, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x007a, code lost:
        r0 = Long.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x007b, code lost:
        monitor-exit(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x007d, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x007e, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0080, code lost:
        r0 = addAndGet(-r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0088, code lost:
        if (r0 == 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x008a, code lost:
        if (r5 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x008c, code lost:
        if (r2 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x008e, code lost:
        if (r5 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0091, code lost:
        r14.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0093, code lost:
        monitor-exit(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x009b, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        boolean z = false;
        synchronized (this) {
            if (!this.emitting) {
                this.emitting = true;
                boolean z2 = this.terminated;
                long j = get();
                try {
                    a aVar = this.actual;
                    while (true) {
                        int i = 0;
                        long j2 = j;
                        while (true) {
                            if (j2 <= 0 && !z2) {
                                break;
                            }
                            if (z2) {
                                if (aVar.peek() == null) {
                                    try {
                                        aVar.Y(this.exception);
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        z = true;
                                        if (!z) {
                                            synchronized (this) {
                                                this.emitting = false;
                                            }
                                        }
                                        throw th;
                                    }
                                } else if (j2 == 0) {
                                    break;
                                }
                            }
                            Object poll = aVar.poll();
                            if (poll == null) {
                                break;
                            } else if (!aVar.ce(poll)) {
                                j2--;
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }
}
