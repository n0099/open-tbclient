package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> lRW = new IdentityHashMap();
    private final c<T> lRK;
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.lRK = (c) g.checkNotNull(cVar);
        aL(t);
    }

    private static void aL(Object obj) {
        synchronized (lRW) {
            Integer num = lRW.get(obj);
            if (num == null) {
                lRW.put(obj, 1);
            } else {
                lRW.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aM(Object obj) {
        synchronized (lRW) {
            Integer num = lRW.get(obj);
            if (num == null) {
                com.facebook.common.c.a.l("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                lRW.remove(obj);
            } else {
                lRW.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void dnm() {
        dnp();
        this.mRefCount++;
    }

    public void dnn() {
        T t;
        if (dno() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.lRK.release(t);
            aM(t);
        }
    }

    private synchronized int dno() {
        dnp();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void dnp() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes13.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
