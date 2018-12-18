package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> igp = new IdentityHashMap();
    private final c<T> ifU;
    @GuardedBy("this")
    private int igq = 1;
    @GuardedBy("this")
    private T mValue;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.ifU = (c) g.checkNotNull(cVar);
        aq(t);
    }

    private static void aq(Object obj) {
        synchronized (igp) {
            Integer num = igp.get(obj);
            if (num == null) {
                igp.put(obj, 1);
            } else {
                igp.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void ar(Object obj) {
        synchronized (igp) {
            Integer num = igp.get(obj);
            if (num == null) {
                com.facebook.common.c.a.f("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                igp.remove(obj);
            } else {
                igp.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.mValue;
    }

    public synchronized boolean isValid() {
        return this.igq > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void bTs() {
        bTv();
        this.igq++;
    }

    public void bTt() {
        T t;
        if (bTu() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.ifU.release(t);
            ar(t);
        }
    }

    private synchronized int bTu() {
        bTv();
        g.checkArgument(this.igq > 0);
        this.igq--;
        return this.igq;
    }

    private void bTv() {
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
