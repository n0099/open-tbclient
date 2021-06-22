package io.reactivex.internal.schedulers;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    public static final long serialVersionUID = -7789753024099756196L;
    public final boolean nonBlocking;
    public final String prefix;
    public final int priority;

    /* loaded from: classes7.dex */
    public static final class RxCustomThread extends Thread implements NonBlockingThread {
        public RxCustomThread(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.prefix + '-' + incrementAndGet();
        Thread rxCustomThread = this.nonBlocking ? new RxCustomThread(runnable, str) : new Thread(runnable, str);
        rxCustomThread.setPriority(this.priority);
        rxCustomThread.setDaemon(true);
        return rxCustomThread;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.prefix + PreferencesUtil.RIGHT_MOUNT;
    }

    public RxThreadFactory(String str, int i2) {
        this(str, i2, false);
    }

    public RxThreadFactory(String str, int i2, boolean z) {
        this.prefix = str;
        this.priority = i2;
        this.nonBlocking = z;
    }
}
