package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> ijz = new IdentityHashMap();
    @GuardedBy("this")
    private int ijA = 1;
    private final c<T> ije;
    @GuardedBy("this")
    private T mValue;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.ije = (c) g.checkNotNull(cVar);
        aq(t);
    }

    private static void aq(Object obj) {
        synchronized (ijz) {
            Integer num = ijz.get(obj);
            if (num == null) {
                ijz.put(obj, 1);
            } else {
                ijz.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void ar(Object obj) {
        synchronized (ijz) {
            Integer num = ijz.get(obj);
            if (num == null) {
                com.facebook.common.c.a.f("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                ijz.remove(obj);
            } else {
                ijz.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.mValue;
    }

    public synchronized boolean isValid() {
        return this.ijA > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void bUj() {
        bUm();
        this.ijA++;
    }

    public void bUk() {
        T t;
        if (bUl() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.ije.release(t);
            ar(t);
        }
    }

    private synchronized int bUl() {
        bUm();
        g.checkArgument(this.ijA > 0);
        this.ijA--;
        return this.ijA;
    }

    private void bUm() {
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
