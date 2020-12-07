package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes19.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> pcn = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    private final c<T> pcb;
    @GuardedBy("this")
    private T zJ;

    public SharedReference(T t, c<T> cVar) {
        this.zJ = (T) g.checkNotNull(t);
        this.pcb = (c) g.checkNotNull(cVar);
        bd(t);
    }

    private static void bd(Object obj) {
        synchronized (pcn) {
            Integer num = pcn.get(obj);
            if (num == null) {
                pcn.put(obj, 1);
            } else {
                pcn.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void be(Object obj) {
        synchronized (pcn) {
            Integer num = pcn.get(obj);
            if (num == null) {
                com.facebook.common.c.a.k("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                pcn.remove(obj);
            } else {
                pcn.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.zJ;
    }

    public synchronized boolean isValid() {
        return this.mRefCount > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void eqd() {
        eqg();
        this.mRefCount++;
    }

    public void eqe() {
        T t;
        if (eqf() == 0) {
            synchronized (this) {
                t = this.zJ;
                this.zJ = null;
            }
            this.pcb.release(t);
            be(t);
        }
    }

    private synchronized int eqf() {
        eqg();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void eqg() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes19.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
