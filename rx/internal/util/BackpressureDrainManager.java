package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes16.dex */
public final class BackpressureDrainManager extends AtomicLong implements rx.f {
    private static final long serialVersionUID = 2826241102729529449L;
    final a actual;
    boolean emitting;
    Throwable exception;
    volatile boolean terminated;

    /* loaded from: classes16.dex */
    public interface a {
        void W(Throwable th);

        boolean cj(Object obj);

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

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
        if (r3 == 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
        monitor-enter(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003f, code lost:
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0041, code lost:
        monitor-enter(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0042, code lost:
        r2 = r13.terminated;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
        if (r6.peek() == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004a, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0057, code lost:
        if (get() != Long.MAX_VALUE) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0059, code lost:
        if (r4 != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005b, code lost:
        if (r2 != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x005f, code lost:
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0061, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0064, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0065, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0066, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0067, code lost:
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x007c, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x007f, code lost:
        r0 = Long.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0084, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0086, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0087, code lost:
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0089, code lost:
        r0 = addAndGet(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0093, code lost:
        if (r0 == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0095, code lost:
        if (r4 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0097, code lost:
        if (r2 == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0099, code lost:
        if (r4 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x009d, code lost:
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x009f, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        synchronized (this) {
            if (!this.emitting) {
                this.emitting = true;
                boolean z = this.terminated;
                long j = get();
                int i = 0;
                try {
                    a aVar = this.actual;
                    while (true) {
                        long j2 = j;
                        int i2 = 0;
                        while (true) {
                            if (j2 > 0 || z) {
                                if (z) {
                                    if (aVar.peek() == null) {
                                        i = 1;
                                        aVar.W(this.exception);
                                        return;
                                    }
                                }
                                Object poll = aVar.poll();
                                if (poll != null) {
                                    if (!aVar.cj(poll)) {
                                        j2--;
                                        i2++;
                                    } else {
                                        return;
                                    }
                                }
                            }
                            try {
                                break;
                            } catch (Throwable th) {
                                th = th;
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
