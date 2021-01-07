package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> ptC = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> ptp;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.ptp = (c) g.checkNotNull(cVar);
        bd(t);
    }

    private static void bd(Object obj) {
        synchronized (ptC) {
            Integer num = ptC.get(obj);
            if (num == null) {
                ptC.put(obj, 1);
            } else {
                ptC.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void be(Object obj) {
        synchronized (ptC) {
            Integer num = ptC.get(obj);
            if (num == null) {
                com.facebook.common.c.a.h("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                ptC.remove(obj);
            } else {
                ptC.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void eun() {
        euq();
        this.mRefCount++;
    }

    public void euo() {
        T t;
        if (eup() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.ptp.release(t);
            be(t);
        }
    }

    private synchronized int eup() {
        euq();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void euq() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes3.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
