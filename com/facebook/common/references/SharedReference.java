package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> hZc = new IdentityHashMap();
    private final c<T> hYH;
    @GuardedBy("this")
    private int hZd = 1;
    @GuardedBy("this")
    private T mValue;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.hYH = (c) g.checkNotNull(cVar);
        ap(t);
    }

    private static void ap(Object obj) {
        synchronized (hZc) {
            Integer num = hZc.get(obj);
            if (num == null) {
                hZc.put(obj, 1);
            } else {
                hZc.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aq(Object obj) {
        synchronized (hZc) {
            Integer num = hZc.get(obj);
            if (num == null) {
                com.facebook.common.c.a.f("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                hZc.remove(obj);
            } else {
                hZc.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.mValue;
    }

    public synchronized boolean isValid() {
        return this.hZd > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void bRn() {
        bRq();
        this.hZd++;
    }

    public void bRo() {
        T t;
        if (bRp() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.hYH.release(t);
            aq(t);
        }
    }

    private synchronized int bRp() {
        bRq();
        g.checkArgument(this.hZd > 0);
        this.hZd--;
        return this.hZd;
    }

    private void bRq() {
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
