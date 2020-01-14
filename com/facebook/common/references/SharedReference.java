package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> lIc = new IdentityHashMap();
    private final c<T> lHQ;
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.lHQ = (c) g.checkNotNull(cVar);
        aT(t);
    }

    private static void aT(Object obj) {
        synchronized (lIc) {
            Integer num = lIc.get(obj);
            if (num == null) {
                lIc.put(obj, 1);
            } else {
                lIc.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aU(Object obj) {
        synchronized (lIc) {
            Integer num = lIc.get(obj);
            if (num == null) {
                com.facebook.common.c.a.j("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                lIc.remove(obj);
            } else {
                lIc.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void djG() {
        djJ();
        this.mRefCount++;
    }

    public void djH() {
        T t;
        if (djI() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.lHQ.release(t);
            aU(t);
        }
    }

    private synchronized int djI() {
        djJ();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void djJ() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes12.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
