package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes14.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> ppa = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> poO;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.poO = (c) g.checkNotNull(cVar);
        bd(t);
    }

    private static void bd(Object obj) {
        synchronized (ppa) {
            Integer num = ppa.get(obj);
            if (num == null) {
                ppa.put(obj, 1);
            } else {
                ppa.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void be(Object obj) {
        synchronized (ppa) {
            Integer num = ppa.get(obj);
            if (num == null) {
                com.facebook.common.c.a.h("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                ppa.remove(obj);
            } else {
                ppa.put(obj, Integer.valueOf(num.intValue() - 1));
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
            this.poO.release(t);
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
