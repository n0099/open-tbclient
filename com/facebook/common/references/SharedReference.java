package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> jAj = new IdentityHashMap();
    @GuardedBy("this")
    private int jAk = 1;
    @GuardedBy("this")
    private T jp;
    private final c<T> jzO;

    public SharedReference(T t, c<T> cVar) {
        this.jp = (T) g.checkNotNull(t);
        this.jzO = (c) g.checkNotNull(cVar);
        aF(t);
    }

    private static void aF(Object obj) {
        synchronized (jAj) {
            Integer num = jAj.get(obj);
            if (num == null) {
                jAj.put(obj, 1);
            } else {
                jAj.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aG(Object obj) {
        synchronized (jAj) {
            Integer num = jAj.get(obj);
            if (num == null) {
                com.facebook.common.c.a.f("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                jAj.remove(obj);
            } else {
                jAj.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.jp;
    }

    public synchronized boolean isValid() {
        return this.jAk > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void ctP() {
        ctS();
        this.jAk++;
    }

    public void ctQ() {
        T t;
        if (ctR() == 0) {
            synchronized (this) {
                t = this.jp;
                this.jp = null;
            }
            this.jzO.release(t);
            aG(t);
        }
    }

    private synchronized int ctR() {
        ctS();
        g.checkArgument(this.jAk > 0);
        this.jAk--;
        return this.jAk;
    }

    private void ctS() {
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
