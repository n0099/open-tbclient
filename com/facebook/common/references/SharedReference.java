package com.facebook.common.references;

import android.graphics.Bitmap;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
@VisibleForTesting
/* loaded from: classes7.dex */
public class SharedReference<T> {
    @GuardedBy("itself")
    public static final Map<Object, Integer> sLiveObjects = new IdentityHashMap();
    @GuardedBy("this")
    public int mRefCount = 1;
    public final ResourceReleaser<T> mResourceReleaser;
    @GuardedBy("this")
    public T mValue;

    /* loaded from: classes7.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }

    private synchronized int decreaseRefCount() {
        boolean z;
        int i;
        ensureValid();
        if (this.mRefCount > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        i = this.mRefCount - 1;
        this.mRefCount = i;
        return i;
    }

    private void ensureValid() {
        if (isValid(this)) {
            return;
        }
        throw new NullReferenceException();
    }

    public static String reportData() {
        return Objects.toStringHelper("SharedReference").add("live_objects_count", sLiveObjects.size()).toString();
    }

    public synchronized void addReference() {
        ensureValid();
        this.mRefCount++;
    }

    public synchronized boolean addReferenceIfValid() {
        if (isValid()) {
            addReference();
            return true;
        }
        return false;
    }

    public void deleteReference() {
        T t;
        if (decreaseRefCount() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.mResourceReleaser.release(t);
            removeLiveReference(t);
        }
    }

    public synchronized boolean deleteReferenceIfValid() {
        if (isValid()) {
            deleteReference();
            return true;
        }
        return false;
    }

    public synchronized T get() {
        return this.mValue;
    }

    public synchronized int getRefCountTestOnly() {
        return this.mRefCount;
    }

    public synchronized boolean isValid() {
        boolean z;
        if (this.mRefCount > 0) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public SharedReference(T t, ResourceReleaser<T> resourceReleaser) {
        this.mValue = (T) Preconditions.checkNotNull(t);
        this.mResourceReleaser = (ResourceReleaser) Preconditions.checkNotNull(resourceReleaser);
        addLiveReference(t);
    }

    public static void addLiveReference(Object obj) {
        if (CloseableReference.useGc() && ((obj instanceof Bitmap) || (obj instanceof HasBitmap))) {
            return;
        }
        synchronized (sLiveObjects) {
            Integer num = sLiveObjects.get(obj);
            if (num == null) {
                sLiveObjects.put(obj, 1);
            } else {
                sLiveObjects.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    public static void removeLiveReference(Object obj) {
        synchronized (sLiveObjects) {
            Integer num = sLiveObjects.get(obj);
            if (num == null) {
                FLog.wtf("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                sLiveObjects.remove(obj);
            } else {
                sLiveObjects.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public static boolean isValid(SharedReference<?> sharedReference) {
        if (sharedReference != null && sharedReference.isValid()) {
            return true;
        }
        return false;
    }
}
