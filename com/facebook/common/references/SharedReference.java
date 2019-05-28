package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> jSG = new IdentityHashMap();
    private final c<T> jSl;
    @GuardedBy("this")
    private T jp;
    @GuardedBy("this")
    private int mRefCount = 1;

    public SharedReference(T t, c<T> cVar) {
        this.jp = (T) g.checkNotNull(t);
        this.jSl = (c) g.checkNotNull(cVar);
        aE(t);
    }

    private static void aE(Object obj) {
        synchronized (jSG) {
            Integer num = jSG.get(obj);
            if (num == null) {
                jSG.put(obj, 1);
            } else {
                jSG.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aF(Object obj) {
        synchronized (jSG) {
            Integer num = jSG.get(obj);
            if (num == null) {
                com.facebook.common.c.a.f("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                jSG.remove(obj);
            } else {
                jSG.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.jp;
    }

    public synchronized boolean isValid() {
        return this.mRefCount > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void cBU() {
        cBX();
        this.mRefCount++;
    }

    public void cBV() {
        T t;
        if (cBW() == 0) {
            synchronized (this) {
                t = this.jp;
                this.jp = null;
            }
            this.jSl.release(t);
            aF(t);
        }
    }

    private synchronized int cBW() {
        cBX();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void cBX() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes2.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
