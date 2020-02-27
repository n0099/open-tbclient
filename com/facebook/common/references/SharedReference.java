package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> lIJ = new IdentityHashMap();
    private final c<T> lIx;
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.lIx = (c) g.checkNotNull(cVar);
        aV(t);
    }

    private static void aV(Object obj) {
        synchronized (lIJ) {
            Integer num = lIJ.get(obj);
            if (num == null) {
                lIJ.put(obj, 1);
            } else {
                lIJ.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aW(Object obj) {
        synchronized (lIJ) {
            Integer num = lIJ.get(obj);
            if (num == null) {
                com.facebook.common.c.a.j("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                lIJ.remove(obj);
            } else {
                lIJ.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void dkT() {
        dkW();
        this.mRefCount++;
    }

    public void dkU() {
        T t;
        if (dkV() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.lIx.release(t);
            aW(t);
        }
    }

    private synchronized int dkV() {
        dkW();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void dkW() {
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
