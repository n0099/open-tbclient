package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes19.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> pcp = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    private final c<T> pcd;
    @GuardedBy("this")
    private T zJ;

    public SharedReference(T t, c<T> cVar) {
        this.zJ = (T) g.checkNotNull(t);
        this.pcd = (c) g.checkNotNull(cVar);
        bd(t);
    }

    private static void bd(Object obj) {
        synchronized (pcp) {
            Integer num = pcp.get(obj);
            if (num == null) {
                pcp.put(obj, 1);
            } else {
                pcp.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void be(Object obj) {
        synchronized (pcp) {
            Integer num = pcp.get(obj);
            if (num == null) {
                com.facebook.common.c.a.k("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                pcp.remove(obj);
            } else {
                pcp.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void eqe() {
        eqh();
        this.mRefCount++;
    }

    public void eqf() {
        T t;
        if (eqg() == 0) {
            synchronized (this) {
                t = this.zJ;
                this.zJ = null;
            }
            this.pcd.release(t);
            be(t);
        }
    }

    private synchronized int eqg() {
        eqh();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void eqh() {
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
