package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> mnc = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> mmQ;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.mmQ = (c) g.checkNotNull(cVar);
        aQ(t);
    }

    private static void aQ(Object obj) {
        synchronized (mnc) {
            Integer num = mnc.get(obj);
            if (num == null) {
                mnc.put(obj, 1);
            } else {
                mnc.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aR(Object obj) {
        synchronized (mnc) {
            Integer num = mnc.get(obj);
            if (num == null) {
                com.facebook.common.c.a.l("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                mnc.remove(obj);
            } else {
                mnc.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void duR() {
        duU();
        this.mRefCount++;
    }

    public void duS() {
        T t;
        if (duT() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.mmQ.release(t);
            aR(t);
        }
    }

    private synchronized int duT() {
        duU();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void duU() {
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
