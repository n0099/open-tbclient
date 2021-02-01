package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> pzk = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> pyZ;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.pyZ = (c) g.checkNotNull(cVar);
        bd(t);
    }

    private static void bd(Object obj) {
        synchronized (pzk) {
            Integer num = pzk.get(obj);
            if (num == null) {
                pzk.put(obj, 1);
            } else {
                pzk.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void be(Object obj) {
        synchronized (pzk) {
            Integer num = pzk.get(obj);
            if (num == null) {
                com.facebook.common.c.a.h("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                pzk.remove(obj);
            } else {
                pzk.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void esM() {
        esP();
        this.mRefCount++;
    }

    public void esN() {
        T t;
        if (esO() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.pyZ.release(t);
            be(t);
        }
    }

    private synchronized int esO() {
        esP();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void esP() {
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
