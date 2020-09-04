package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes9.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> nlw = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> nlk;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.nlk = (c) g.checkNotNull(cVar);
        aT(t);
    }

    private static void aT(Object obj) {
        synchronized (nlw) {
            Integer num = nlw.get(obj);
            if (num == null) {
                nlw.put(obj, 1);
            } else {
                nlw.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aU(Object obj) {
        synchronized (nlw) {
            Integer num = nlw.get(obj);
            if (num == null) {
                com.facebook.common.c.a.k("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                nlw.remove(obj);
            } else {
                nlw.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void dOU() {
        dOX();
        this.mRefCount++;
    }

    public void dOV() {
        T t;
        if (dOW() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.nlk.release(t);
            aU(t);
        }
    }

    private synchronized int dOW() {
        dOX();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void dOX() {
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
