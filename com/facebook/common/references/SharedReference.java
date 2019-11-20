package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> kaI = new IdentityHashMap();
    @GuardedBy("this")
    private T bw;
    private final c<T> kan;
    @GuardedBy("this")
    private int mRefCount = 1;

    public SharedReference(T t, c<T> cVar) {
        this.bw = (T) g.checkNotNull(t);
        this.kan = (c) g.checkNotNull(cVar);
        az(t);
    }

    private static void az(Object obj) {
        synchronized (kaI) {
            Integer num = kaI.get(obj);
            if (num == null) {
                kaI.put(obj, 1);
            } else {
                kaI.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aA(Object obj) {
        synchronized (kaI) {
            Integer num = kaI.get(obj);
            if (num == null) {
                com.facebook.common.c.a.h("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                kaI.remove(obj);
            } else {
                kaI.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.bw;
    }

    public synchronized boolean isValid() {
        return this.mRefCount > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void cCZ() {
        cDc();
        this.mRefCount++;
    }

    public void cDa() {
        T t;
        if (cDb() == 0) {
            synchronized (this) {
                t = this.bw;
                this.bw = null;
            }
            this.kan.release(t);
            aA(t);
        }
    }

    private synchronized int cDb() {
        cDc();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void cDc() {
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
