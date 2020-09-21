package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes17.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> nvw = new IdentityHashMap();
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;
    private final c<T> nvk;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.nvk = (c) g.checkNotNull(cVar);
        aV(t);
    }

    private static void aV(Object obj) {
        synchronized (nvw) {
            Integer num = nvw.get(obj);
            if (num == null) {
                nvw.put(obj, 1);
            } else {
                nvw.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aW(Object obj) {
        synchronized (nvw) {
            Integer num = nvw.get(obj);
            if (num == null) {
                com.facebook.common.c.a.k("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                nvw.remove(obj);
            } else {
                nvw.put(obj, Integer.valueOf(num.intValue() - 1));
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

    public synchronized void dSS() {
        dSV();
        this.mRefCount++;
    }

    public void dST() {
        T t;
        if (dSU() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.nvk.release(t);
            aW(t);
        }
    }

    private synchronized int dSU() {
        dSV();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void dSV() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes17.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
