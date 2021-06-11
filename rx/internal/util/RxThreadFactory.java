package rx.internal.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    public static final ThreadFactory NONE = new a();
    public static final long serialVersionUID = -8841098858898482335L;
    public final String prefix;

    /* loaded from: classes8.dex */
    public static class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            throw new AssertionError("No threads allowed.");
        }
    }

    public RxThreadFactory(String str) {
        this.prefix = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.prefix + incrementAndGet());
        thread.setDaemon(true);
        return thread;
    }
}
