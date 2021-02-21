package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> pzK = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> pzz;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.pzz = (c) g.checkNotNull(cVar);
        bd(t);
    }

    private static void bd(Object obj) {
        synchronized (pzK) {
            Integer num = pzK.get(obj);
            if (num == null) {
                pzK.put(obj, 1);
            } else {
                pzK.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void be(Object obj) {
        synchronized (pzK) {
            Integer num = pzK.get(obj);
            if (num == null) {
                com.facebook.common.c.a.h("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                pzK.remove(obj);
            } else {
                pzK.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void esU() {
        esX();
        this.mRefCount++;
    }

    public void esV() {
        T t;
        if (esW() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.pzz.release(t);
            be(t);
        }
    }

    private synchronized int esW() {
        esX();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void esX() {
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
