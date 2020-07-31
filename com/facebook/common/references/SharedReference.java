package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    private static final Map<Object, Integer> mRi = new IdentityHashMap();
    private final c<T> mQV;
    @GuardedBy("this")
    private int mRefCount = 1;
    @GuardedBy("this")
    private T mValue;

    public SharedReference(T t, c<T> cVar) {
        this.mValue = (T) g.checkNotNull(t);
        this.mQV = (c) g.checkNotNull(cVar);
        aR(t);
    }

    private static void aR(Object obj) {
        synchronized (mRi) {
            Integer num = mRi.get(obj);
            if (num == null) {
                mRi.put(obj, 1);
            } else {
                mRi.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void aS(Object obj) {
        synchronized (mRi) {
            Integer num = mRi.get(obj);
            if (num == null) {
                com.facebook.common.c.a.l("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                mRi.remove(obj);
            } else {
                mRi.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized T get() {
        return this.mValue;
    }

    public synchronized boolean isValid() {
        return this.mRefCount > 0;
    }

    public static boolean a(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public synchronized void dCK() {
        dCN();
        this.mRefCount++;
    }

    public void dCL() {
        T t;
        if (dCM() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.mQV.release(t);
            aS(t);
        }
    }

    private synchronized int dCM() {
        dCN();
        g.checkArgument(this.mRefCount > 0);
        this.mRefCount--;
        return this.mRefCount;
    }

    private void dCN() {
        if (!a(this)) {
            throw new NullReferenceException();
        }
    }

    /* loaded from: classes12.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }
}
