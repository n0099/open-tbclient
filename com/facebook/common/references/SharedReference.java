package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes9.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> nle = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> nkS;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.nkS = (c) g.checkNotNull(cVar);
        aT(t);
    }

    private static void aT(Object obj) {
        synchronized (nle) {
            Integer num = nle.get(obj);
            if (num == null) {
                nle.put(obj, 1);
            } else {
                nle.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aU(Object obj) {
        synchronized (nle) {
            Integer num = nle.get(obj);
            if (num == null) {
                com.facebook.common.c.a.k("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                nle.remove(obj);
            } else {
                nle.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void dOL() {
        dOO();
        this.mRefCount++;
    }

    public void dOM() {
        T t;
        if (dON() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.nkS.release(t);
            aU(t);
        }
    }

    private synchronized int dON() {
        dOO();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void dOO() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes9.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
