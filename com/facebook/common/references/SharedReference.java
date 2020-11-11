package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> oLB = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> oLp;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.oLp = (c) g.checkNotNull(cVar);
        bc(t);
    }

    private static void bc(Object obj) {
        synchronized (oLB) {
            Integer num = oLB.get(obj);
            if (num == null) {
                oLB.put(obj, 1);
            } else {
                oLB.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void bd(Object obj) {
        synchronized (oLB) {
            Integer num = oLB.get(obj);
            if (num == null) {
                com.facebook.common.c.a.k("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                oLB.remove(obj);
            } else {
                oLB.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.mValue;
    }

    public synchronized boolean isValid() {
        return this.mRefCount > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void ekq() {
        ekt();
        this.mRefCount++;
    }

    public void ekr() {
        T t;
        if (eks() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.oLp.release(t);
            bd(t);
        }
    }

    private synchronized int eks() {
        ekt();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void ekt() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes6.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
