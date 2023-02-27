package com.yy.gslbsdk.thread;
/* loaded from: classes8.dex */
public class ThreadInfo implements Runnable {
    public String threadName;
    public ThreadMainOper threadMainOper = null;
    public ThreadEndOper threadEndOper = null;

    /* loaded from: classes8.dex */
    public interface ThreadEndOper {
        void handleOper(String str);
    }

    /* loaded from: classes8.dex */
    public interface ThreadMainOper {
        void handleOper(String str);
    }

    public ThreadInfo(String str) {
        this.threadName = str;
    }

    public void setThreadEndOper(ThreadEndOper threadEndOper) {
        this.threadEndOper = threadEndOper;
    }

    public void setThreadMainOper(ThreadMainOper threadMainOper) {
        this.threadMainOper = threadMainOper;
    }

    public void setThreadName(String str) {
        this.threadName = str;
    }

    public ThreadEndOper getThreadEndOper() {
        return this.threadEndOper;
    }

    public ThreadMainOper getThreadMainOper() {
        return this.threadMainOper;
    }

    public String getThreadName() {
        return this.threadName;
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadMainOper threadMainOper = this.threadMainOper;
        if (threadMainOper != null) {
            threadMainOper.handleOper(this.threadName);
        }
        ThreadEndOper threadEndOper = this.threadEndOper;
        if (threadEndOper != null) {
            threadEndOper.handleOper(this.threadName);
        }
    }

    public String toString() {
        return "GslbThreadInfo{" + this.threadName + '}';
    }
}
