package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> ikG = new IdentityHashMap();
    @GuardedBy("this")
    private int ikH = 1;
    private final c<T> ikl;
    @GuardedBy("this")
    private T mValue;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.ikl = (c) g.checkNotNull(cVar);
        aq(t);
    }

    private static void aq(Object obj) {
        synchronized (ikG) {
            Integer num = ikG.get(obj);
            if (num == null) {
                ikG.put(obj, 1);
            } else {
                ikG.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void ar(Object obj) {
        synchronized (ikG) {
            Integer num = ikG.get(obj);
            if (num == null) {
                com.facebook.common.c.a.f("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                ikG.remove(obj);
            } else {
                ikG.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.mValue;
    }

    public synchronized boolean isValid() {
        return this.ikH > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void bUR() {
        bUU();
        this.ikH++;
    }

    public void bUS() {
        T t;
        if (bUT() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.ikl.release(t);
            ar(t);
        }
    }

    private synchronized int bUT() {
        bUU();
        g.checkArgument(this.ikH > 0);
        this.ikH--;
        return this.ikH;
    }

    private void bUU() {
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
