package org.aspectj.runtime.internal.cflowstack;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
/* loaded from: classes2.dex */
public class ThreadStackImpl11 implements ThreadStack {
    public static final int COLLECT_AT = 20000;
    public static final int MIN_COLLECT_AT = 100;
    public Stack cached_stack;
    public Thread cached_thread;
    public Hashtable stacks = new Hashtable();
    public int change_count = 0;

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadStack
    public void removeThreadStack() {
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadStack
    public synchronized Stack getThreadStack() {
        if (Thread.currentThread() != this.cached_thread) {
            Thread currentThread = Thread.currentThread();
            this.cached_thread = currentThread;
            Stack stack = (Stack) this.stacks.get(currentThread);
            this.cached_stack = stack;
            if (stack == null) {
                Stack stack2 = new Stack();
                this.cached_stack = stack2;
                this.stacks.put(this.cached_thread, stack2);
            }
            this.change_count++;
            if (this.change_count > Math.max(100, 20000 / Math.max(1, this.stacks.size()))) {
                Stack stack3 = new Stack();
                Enumeration keys = this.stacks.keys();
                while (keys.hasMoreElements()) {
                    Thread thread = (Thread) keys.nextElement();
                    if (!thread.isAlive()) {
                        stack3.push(thread);
                    }
                }
                Enumeration elements = stack3.elements();
                while (elements.hasMoreElements()) {
                    this.stacks.remove((Thread) elements.nextElement());
                }
                this.change_count = 0;
            }
        }
        return this.cached_stack;
    }
}
