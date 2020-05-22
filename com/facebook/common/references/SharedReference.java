package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> mlS = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> mlG;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.mlG = (c) g.checkNotNull(cVar);
        aQ(t);
    }

    private static void aQ(Object obj) {
        synchronized (mlS) {
            Integer num = mlS.get(obj);
            if (num == null) {
                mlS.put(obj, 1);
            } else {
                mlS.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aR(Object obj) {
        synchronized (mlS) {
            Integer num = mlS.get(obj);
            if (num == null) {
                com.facebook.common.c.a.l("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                mlS.remove(obj);
            } else {
                mlS.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void duD() {
        duG();
        this.mRefCount++;
    }

    public void duE() {
        T t;
        if (duF() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.mlG.release(t);
            aR(t);
        }
    }

    private synchronized int duF() {
        duG();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void duG() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes13.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
