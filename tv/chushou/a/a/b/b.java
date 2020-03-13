package tv.chushou.a.a.b;

import android.os.Process;
import android.support.annotation.NonNull;
import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class b implements ThreadFactory {
    private static final AtomicInteger nsP = new AtomicInteger(1);
    private final int nVX;
    private final AtomicInteger nsR = new AtomicInteger(1);
    private final String prefix;

    public b(String str, int i) {
        this.nVX = i;
        this.prefix = "Router thread pool No." + nsP.getAndDecrement() + ", " + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull final Runnable runnable) {
        final int i = this.nVX;
        if (runnable instanceof c) {
            i = ((c) runnable).priority;
        }
        Runnable runnable2 = new Runnable() { // from class: tv.chushou.a.a.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(i);
                } catch (Throwable th) {
                    tv.chushou.a.a.c.a.dQg().e(null, "LinuxPriorityThreadFactory:Process.setThreadPriority failed", th);
                }
                runnable.run();
            }
        };
        String str = this.prefix + ", thread No." + this.nsR.getAndIncrement();
        tv.chushou.a.a.c.a.dQg().i(null, "LinuxPriorityThreadFactory: new Thread, name is [" + str + "]");
        Thread thread = new Thread(runnable2, str);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: tv.chushou.a.a.b.b.2
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread2, Throwable th) {
                tv.chushou.a.a.c.a.dQg().e(null, "LinuxPriorityThreadFactory: UncaughtExceptionHandler! Thread [" + thread2.getName() + "]", th);
            }
        });
        return thread;
    }
}
