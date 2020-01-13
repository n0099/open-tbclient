package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> lHX = new IdentityHashMap();
    private final c<T> lHL;
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.lHL = (c) g.checkNotNull(cVar);
        aT(t);
    }

    private static void aT(Object obj) {
        synchronized (lHX) {
            Integer num = lHX.get(obj);
            if (num == null) {
                lHX.put(obj, 1);
            } else {
                lHX.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aU(Object obj) {
        synchronized (lHX) {
            Integer num = lHX.get(obj);
            if (num == null) {
                com.facebook.common.c.a.j("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                lHX.remove(obj);
            } else {
                lHX.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void djE() {
        djH();
        this.mRefCount++;
    }

    public void djF() {
        T t;
        if (djG() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.lHL.release(t);
            aU(t);
        }
    }

    private synchronized int djG() {
        djH();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void djH() {
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
