package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> jAC = new IdentityHashMap();
    @GuardedBy("this")
    private int jAD = 1;
    private final c<T> jAh;
    @GuardedBy("this")
    private T jp;

    public SharedReference(T t, c<T> cVar) {
        this.jp = (T) g.checkNotNull(t);
        this.jAh = (c) g.checkNotNull(cVar);
        aG(t);
    }

    private static void aG(Object obj) {
        synchronized (jAC) {
            Integer num = jAC.get(obj);
            if (num == null) {
                jAC.put(obj, 1);
            } else {
                jAC.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aH(Object obj) {
        synchronized (jAC) {
            Integer num = jAC.get(obj);
            if (num == null) {
                com.facebook.common.c.a.f("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                jAC.remove(obj);
            } else {
                jAC.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.jp;
    }

    public synchronized boolean isValid() {
        return this.jAD > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void ctZ() {
        cuc();
        this.jAD++;
    }

    public void cua() {
        T t;
        if (cub() == 0) {
            synchronized (this) {
                t = this.jp;
                this.jp = null;
            }
            this.jAh.release(t);
            aH(t);
        }
    }

    private synchronized int cub() {
        cuc();
        g.checkArgument(this.jAD > 0);
        this.jAD--;
        return this.jAD;
    }

    private void cuc() {
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
