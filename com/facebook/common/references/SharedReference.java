package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> oNf = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> oMT;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.oMT = (c) g.checkNotNull(cVar);
        bd(t);
    }

    private static void bd(Object obj) {
        synchronized (oNf) {
            Integer num = oNf.get(obj);
            if (num == null) {
                oNf.put(obj, 1);
            } else {
                oNf.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void be(Object obj) {
        synchronized (oNf) {
            Integer num = oNf.get(obj);
            if (num == null) {
                com.facebook.common.c.a.k("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                oNf.remove(obj);
            } else {
                oNf.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void eko() {
        ekr();
        this.mRefCount++;
    }

    public void ekp() {
        T t;
        if (ekq() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.oMT.release(t);
            be(t);
        }
    }

    private synchronized int ekq() {
        ekr();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void ekr() {
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
