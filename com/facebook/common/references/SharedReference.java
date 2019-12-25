package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes11.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> lEz = new IdentityHashMap();
    @GuardedBy("this")
    private T bA;
    private final c<T> lEn;
    @GuardedBy("this")
    private int mRefCount = 1;

    public SharedReference(T t, c<T> cVar) {
        this.bA = (T) g.checkNotNull(t);
        this.lEn = (c) g.checkNotNull(cVar);
        aT(t);
    }

    private static void aT(Object obj) {
        synchronized (lEz) {
            Integer num = lEz.get(obj);
            if (num == null) {
                lEz.put(obj, 1);
            } else {
                lEz.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aU(Object obj) {
        synchronized (lEz) {
            Integer num = lEz.get(obj);
            if (num == null) {
                com.facebook.common.c.a.j("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                lEz.remove(obj);
            } else {
                lEz.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.bA;
    }

    public synchronized boolean isValid() {
        return this.mRefCount > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void diD() {
        diG();
        this.mRefCount++;
    }

    public void diE() {
        T t;
        if (diF() == 0) {
            synchronized (this) {
                t = this.bA;
                this.bA = null;
            }
            this.lEn.release(t);
            aU(t);
        }
    }

    private synchronized int diF() {
        diG();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void diG() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes11.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
