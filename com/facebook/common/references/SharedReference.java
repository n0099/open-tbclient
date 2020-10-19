package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> nKP = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> nKD;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.nKD = (c) g.checkNotNull(cVar);
        aY(t);
    }

    private static void aY(Object obj) {
        synchronized (nKP) {
            Integer num = nKP.get(obj);
            if (num == null) {
                nKP.put(obj, 1);
            } else {
                nKP.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aZ(Object obj) {
        synchronized (nKP) {
            Integer num = nKP.get(obj);
            if (num == null) {
                com.facebook.common.c.a.k("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                nKP.remove(obj);
            } else {
                nKP.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void dWD() {
        dWG();
        this.mRefCount++;
    }

    public void dWE() {
        T t;
        if (dWF() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.nKD.release(t);
            aZ(t);
        }
    }

    private synchronized int dWF() {
        dWG();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void dWG() {
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
