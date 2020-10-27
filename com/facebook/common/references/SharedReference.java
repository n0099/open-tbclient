package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> oCi = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> oBW;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.oBW = (c) g.checkNotNull(cVar);
        bc(t);
    }

    private static void bc(Object obj) {
        synchronized (oCi) {
            Integer num = oCi.get(obj);
            if (num == null) {
                oCi.put(obj, 1);
            } else {
                oCi.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void bd(Object obj) {
        synchronized (oCi) {
            Integer num = oCi.get(obj);
            if (num == null) {
                com.facebook.common.c.a.k("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                oCi.remove(obj);
            } else {
                oCi.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void egB() {
        egE();
        this.mRefCount++;
    }

    public void egC() {
        T t;
        if (egD() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.oBW.release(t);
            bd(t);
        }
    }

    private synchronized int egD() {
        egE();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void egE() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes6.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
