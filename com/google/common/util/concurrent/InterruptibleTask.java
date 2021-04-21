package com.google.common.util.concurrent;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes6.dex */
public abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final Runnable f31287e = new b();

    /* renamed from: f  reason: collision with root package name */
    public static final Runnable f31288f = new b();

    /* renamed from: g  reason: collision with root package name */
    public static final Runnable f31289g = new b();

    /* loaded from: classes6.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public abstract void afterRanInterruptibly(T t, Throwable th);

    public final void interruptTask() {
        Runnable runnable = get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, f31288f)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (getAndSet(f31287e) == f31289g) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    public abstract boolean isDone();

    @Override // java.lang.Runnable
    public final void run() {
        T runInterruptibly;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !isDone();
            if (z) {
                try {
                    runInterruptibly = runInterruptibly();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, f31287e)) {
                        Runnable runnable = get();
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            if (runnable != f31288f && runnable != f31289g) {
                                break;
                            }
                            i++;
                            if (i > 1000) {
                                Runnable runnable2 = f31289g;
                                if (runnable == runnable2 || compareAndSet(f31288f, runnable2)) {
                                    z2 = Thread.interrupted() || z2;
                                    LockSupport.park(this);
                                }
                            } else {
                                Thread.yield();
                            }
                            runnable = get();
                        }
                        if (z2) {
                            currentThread.interrupt();
                        }
                    }
                    if (z) {
                        afterRanInterruptibly(null, th);
                        return;
                    }
                    return;
                }
            } else {
                runInterruptibly = null;
            }
            if (!compareAndSet(currentThread, f31287e)) {
                Runnable runnable3 = get();
                boolean z3 = false;
                int i2 = 0;
                while (true) {
                    if (runnable3 != f31288f && runnable3 != f31289g) {
                        break;
                    }
                    i2++;
                    if (i2 > 1000) {
                        Runnable runnable4 = f31289g;
                        if (runnable3 == runnable4 || compareAndSet(f31288f, runnable4)) {
                            z3 = Thread.interrupted() || z3;
                            LockSupport.park(this);
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable3 = get();
                }
                if (z3) {
                    currentThread.interrupt();
                }
            }
            if (z) {
                afterRanInterruptibly(runInterruptibly, null);
            }
        }
    }

    public abstract T runInterruptibly() throws Exception;

    public abstract String toPendingString();

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == f31287e) {
            str = "running=[DONE]";
        } else if (runnable == f31288f) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + StringUtil.ARRAY_ELEMENT_SEPARATOR + toPendingString();
    }
}
