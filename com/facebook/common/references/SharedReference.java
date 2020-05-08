package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> lSa = new IdentityHashMap();
    private final c<T> lRO;
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.lRO = (c) g.checkNotNull(cVar);
        aM(t);
    }

    private static void aM(Object obj) {
        synchronized (lSa) {
            Integer num = lSa.get(obj);
            if (num == null) {
                lSa.put(obj, 1);
            } else {
                lSa.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aN(Object obj) {
        synchronized (lSa) {
            Integer num = lSa.get(obj);
            if (num == null) {
                com.facebook.common.c.a.l("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                lSa.remove(obj);
            } else {
                lSa.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void dnj() {
        dnm();
        this.mRefCount++;
    }

    public void dnk() {
        T t;
        if (dnl() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.lRO.release(t);
            aN(t);
        }
    }

    private synchronized int dnl() {
        dnm();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void dnm() {
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
