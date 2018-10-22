package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> hXs = new IdentityHashMap();
    private final c<T> hWX;
    @GuardedBy("this")
    private int hXt = 1;
    @GuardedBy("this")
    private T mValue;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.hWX = (c) g.checkNotNull(cVar);
        aq(t);
    }

    private static void aq(Object obj) {
        synchronized (hXs) {
            Integer num = hXs.get(obj);
            if (num == null) {
                hXs.put(obj, 1);
            } else {
                hXs.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void ar(Object obj) {
        synchronized (hXs) {
            Integer num = hXs.get(obj);
            if (num == null) {
                com.facebook.common.c.a.f("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                hXs.remove(obj);
            } else {
                hXs.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.mValue;
    }

    public synchronized boolean isValid() {
        return this.hXt > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void bRS() {
        bRV();
        this.hXt++;
    }

    public void bRT() {
        T t;
        if (bRU() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.hWX.release(t);
            ar(t);
        }
    }

    private synchronized int bRU() {
        bRV();
        g.checkArgument(this.hXt > 0);
        this.hXt--;
        return this.hXt;
    }

    private void bRV() {
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
