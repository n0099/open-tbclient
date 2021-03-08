package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes4.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> pBP = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> pBE;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.pBE = (c) g.checkNotNull(cVar);
        bf(t);
    }

    private static void bf(Object obj) {
        synchronized (pBP) {
            Integer num = pBP.get(obj);
            if (num == null) {
                pBP.put(obj, 1);
            } else {
                pBP.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void bg(Object obj) {
        synchronized (pBP) {
            Integer num = pBP.get(obj);
            if (num == null) {
                com.facebook.common.c.a.h("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                pBP.remove(obj);
            } else {
                pBP.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void etd() {
        etg();
        this.mRefCount++;
    }

    public void ete() {
        T t;
        if (etf() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.pBE.release(t);
            bg(t);
        }
    }

    private synchronized int etf() {
        etg();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void etg() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes4.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
