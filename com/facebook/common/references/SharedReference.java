package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> kbz = new IdentityHashMap();
    @GuardedBy("this")
    private T bY;
    private final c<T> kbe;
    @GuardedBy("this")
    private int mRefCount = 1;

    public SharedReference(T t, c<T> cVar) {
        this.bY = (T) g.checkNotNull(t);
        this.kbe = (c) g.checkNotNull(cVar);
        az(t);
    }

    private static void az(Object obj) {
        synchronized (kbz) {
            Integer num = kbz.get(obj);
            if (num == null) {
                kbz.put(obj, 1);
            } else {
                kbz.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aA(Object obj) {
        synchronized (kbz) {
            Integer num = kbz.get(obj);
            if (num == null) {
                com.facebook.common.c.a.h("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                kbz.remove(obj);
            } else {
                kbz.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.bY;
    }

    public synchronized boolean isValid() {
        return this.mRefCount > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void cDb() {
        cDe();
        this.mRefCount++;
    }

    public void cDc() {
        T t;
        if (cDd() == 0) {
            synchronized (this) {
                t = this.bY;
                this.bY = null;
            }
            this.kbe.release(t);
            aA(t);
        }
    }

    private synchronized int cDd() {
        cDe();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void cDe() {
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
