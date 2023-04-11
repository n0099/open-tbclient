package com.yy.gslbsdk.thread;

import com.yy.gslbsdk.util.LogTools;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public enum PreHandleDnsExecutor {
    INSTANCE;
    
    public static ExecutorService sExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.yy.gslbsdk.thread.PreHandleDnsExecutor.DefaultThreadFactory
        public final AtomicInteger threadNumber = new AtomicInteger(1);
        public final ThreadGroup group = Thread.currentThread().getThreadGroup();
        public final String namePrefix = "pre-dns-thread-";

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.group;
            Thread thread = new Thread(threadGroup, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }, new ThreadPoolExecutor.CallerRunsPolicy());
    public String TAG = "PreHandleDnsExecutor";

    PreHandleDnsExecutor() {
    }

    public boolean addTask(ThreadInfo threadInfo) {
        ExecutorService executorService;
        if (threadInfo == null || (executorService = sExecutor) == null) {
            return false;
        }
        executorService.execute(threadInfo);
        LogTools.printDebug(this.TAG, "add task preHandleDns pool success");
        return true;
    }
}
