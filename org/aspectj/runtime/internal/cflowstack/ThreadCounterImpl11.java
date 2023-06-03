package org.aspectj.runtime.internal.cflowstack;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class ThreadCounterImpl11 implements ThreadCounter {
    public static final int COLLECT_AT = 20000;
    public static final int MIN_COLLECT_AT = 100;
    public Counter cached_counter;
    public Thread cached_thread;
    public Hashtable counters = new Hashtable();
    public int change_count = 0;

    /* loaded from: classes2.dex */
    public static class Counter {
        public int value = 0;
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
    public void removeThreadCounter() {
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
    public void dec() {
        Counter threadCounter = getThreadCounter();
        threadCounter.value--;
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
    public void inc() {
        getThreadCounter().value++;
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
    public boolean isNotZero() {
        if (getThreadCounter().value != 0) {
            return true;
        }
        return false;
    }

    private synchronized Counter getThreadCounter() {
        if (Thread.currentThread() != this.cached_thread) {
            Thread currentThread = Thread.currentThread();
            this.cached_thread = currentThread;
            Counter counter = (Counter) this.counters.get(currentThread);
            this.cached_counter = counter;
            if (counter == null) {
                Counter counter2 = new Counter();
                this.cached_counter = counter2;
                this.counters.put(this.cached_thread, counter2);
            }
            this.change_count++;
            if (this.change_count > Math.max(100, 20000 / Math.max(1, this.counters.size()))) {
                ArrayList<Thread> arrayList = new ArrayList();
                Enumeration keys = this.counters.keys();
                while (keys.hasMoreElements()) {
                    Thread thread = (Thread) keys.nextElement();
                    if (!thread.isAlive()) {
                        arrayList.add(thread);
                    }
                }
                for (Thread thread2 : arrayList) {
                    this.counters.remove(thread2);
                }
                this.change_count = 0;
            }
        }
        return this.cached_counter;
    }
}
