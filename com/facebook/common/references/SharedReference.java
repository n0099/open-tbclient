package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> jzP = new IdentityHashMap();
    @GuardedBy("this")
    private T jp;
    @GuardedBy("this")
    private int jzQ = 1;
    private final c<T> jzu;

    public SharedReference(T t, c<T> cVar) {
        this.jp = (T) g.checkNotNull(t);
        this.jzu = (c) g.checkNotNull(cVar);
        aC(t);
    }

    private static void aC(Object obj) {
        synchronized (jzP) {
            Integer num = jzP.get(obj);
            if (num == null) {
                jzP.put(obj, 1);
            } else {
                jzP.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aD(Object obj) {
        synchronized (jzP) {
            Integer num = jzP.get(obj);
            if (num == null) {
                com.facebook.common.c.a.f("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                jzP.remove(obj);
            } else {
                jzP.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.jp;
    }

    public synchronized boolean isValid() {
        return this.jzQ > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void ctV() {
        ctY();
        this.jzQ++;
    }

    public void ctW() {
        T t;
        if (ctX() == 0) {
            synchronized (this) {
                t = this.jp;
                this.jp = null;
            }
            this.jzu.release(t);
            aD(t);
        }
    }

    private synchronized int ctX() {
        ctY();
        g.checkArgument(this.jzQ > 0);
        this.jzQ--;
        return this.jzQ;
    }

    private void ctY() {
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
