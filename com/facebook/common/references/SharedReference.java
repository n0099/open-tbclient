package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> kaT = new IdentityHashMap();
    @GuardedBy("this")
    private T jp;
    private final c<T> kay;
    @GuardedBy("this")
    private int mRefCount = 1;

    public SharedReference(T t, c<T> cVar) {
        this.jp = (T) g.checkNotNull(t);
        this.kay = (c) g.checkNotNull(cVar);
        aE(t);
    }

    private static void aE(Object obj) {
        synchronized (kaT) {
            Integer num = kaT.get(obj);
            if (num == null) {
                kaT.put(obj, 1);
            } else {
                kaT.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aF(Object obj) {
        synchronized (kaT) {
            Integer num = kaT.get(obj);
            if (num == null) {
                com.facebook.common.c.a.f("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                kaT.remove(obj);
            } else {
                kaT.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.jp;
    }

    public synchronized boolean isValid() {
        return this.mRefCount > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void cFp() {
        cFs();
        this.mRefCount++;
    }

    public void cFq() {
        T t;
        if (cFr() == 0) {
            synchronized (this) {
                t = this.jp;
                this.jp = null;
            }
            this.kay.release(t);
            aF(t);
        }
    }

    private synchronized int cFr() {
        cFs();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void cFs() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes2.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
