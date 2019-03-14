package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> jAu = new IdentityHashMap();
    @GuardedBy("this")
    private int jAv = 1;
    @GuardedBy("this")
    private T jp;
    private final c<T> jzZ;

    public SharedReference(T t, c<T> cVar) {
        this.jp = (T) g.checkNotNull(t);
        this.jzZ = (c) g.checkNotNull(cVar);
        aG(t);
    }

    private static void aG(Object obj) {
        synchronized (jAu) {
            Integer num = jAu.get(obj);
            if (num == null) {
                jAu.put(obj, 1);
            } else {
                jAu.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aH(Object obj) {
        synchronized (jAu) {
            Integer num = jAu.get(obj);
            if (num == null) {
                com.facebook.common.c.a.f("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                jAu.remove(obj);
            } else {
                jAu.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.jp;
    }

    public synchronized boolean isValid() {
        return this.jAv > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void cuc() {
        cuf();
        this.jAv++;
    }

    public void cud() {
        T t;
        if (cue() == 0) {
            synchronized (this) {
                t = this.jp;
                this.jp = null;
            }
            this.jzZ.release(t);
            aH(t);
        }
    }

    private synchronized int cue() {
        cuf();
        g.checkArgument(this.jAv > 0);
        this.jAv--;
        return this.jAv;
    }

    private void cuf() {
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
