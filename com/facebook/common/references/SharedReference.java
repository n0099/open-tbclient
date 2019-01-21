package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> ikH = new IdentityHashMap();
    @GuardedBy("this")
    private int ikI = 1;
    private final c<T> ikm;
    @GuardedBy("this")
    private T mValue;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.ikm = (c) g.checkNotNull(cVar);
        aq(t);
    }

    private static void aq(Object obj) {
        synchronized (ikH) {
            Integer num = ikH.get(obj);
            if (num == null) {
                ikH.put(obj, 1);
            } else {
                ikH.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void ar(Object obj) {
        synchronized (ikH) {
            Integer num = ikH.get(obj);
            if (num == null) {
                com.facebook.common.c.a.f("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                ikH.remove(obj);
            } else {
                ikH.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.mValue;
    }

    public synchronized boolean isValid() {
        return this.ikI > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void bUR() {
        bUU();
        this.ikI++;
    }

    public void bUS() {
        T t;
        if (bUT() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.ikm.release(t);
            ar(t);
        }
    }

    private synchronized int bUT() {
        bUU();
        g.checkArgument(this.ikI > 0);
        this.ikI--;
        return this.ikI;
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
