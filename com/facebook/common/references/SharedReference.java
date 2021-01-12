package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes14.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> poZ = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> poN;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.poN = (c) g.checkNotNull(cVar);
        bd(t);
    }

    private static void bd(Object obj) {
        synchronized (poZ) {
            Integer num = poZ.get(obj);
            if (num == null) {
                poZ.put(obj, 1);
            } else {
                poZ.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void be(Object obj) {
        synchronized (poZ) {
            Integer num = poZ.get(obj);
            if (num == null) {
                com.facebook.common.c.a.h("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                poZ.remove(obj);
            } else {
                poZ.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void eqt() {
        eqw();
        this.mRefCount++;
    }

    public void equ() {
        T t;
        if (eqv() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.poN.release(t);
            be(t);
        }
    }

    private synchronized int eqv() {
        eqw();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void eqw() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes14.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
