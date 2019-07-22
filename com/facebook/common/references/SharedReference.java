package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> jZN = new IdentityHashMap();
    private final c<T> jZs;
    @GuardedBy("this")
    private T jp;
    @GuardedBy("this")
    private int mRefCount = 1;

    public SharedReference(T t, c<T> cVar) {
        this.jp = (T) g.checkNotNull(t);
        this.jZs = (c) g.checkNotNull(cVar);
        aE(t);
    }

    private static void aE(Object obj) {
        synchronized (jZN) {
            Integer num = jZN.get(obj);
            if (num == null) {
                jZN.put(obj, 1);
            } else {
                jZN.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aF(Object obj) {
        synchronized (jZN) {
            Integer num = jZN.get(obj);
            if (num == null) {
                com.facebook.common.c.a.f("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                jZN.remove(obj);
            } else {
                jZN.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void cEU() {
        cEX();
        this.mRefCount++;
    }

    public void cEV() {
        T t;
        if (cEW() == 0) {
            synchronized (this) {
                t = this.jp;
                this.jp = null;
            }
            this.jZs.release(t);
            aF(t);
        }
    }

    private synchronized int cEW() {
        cEX();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void cEX() {
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
