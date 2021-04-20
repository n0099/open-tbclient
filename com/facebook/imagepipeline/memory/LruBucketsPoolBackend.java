package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.VisibleForTesting;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public abstract class LruBucketsPoolBackend<T> implements PoolBackend<T> {
    public final Set<T> mCurrentItems = new HashSet();
    public final BucketMap<T> mMap = new BucketMap<>();

    private T maybeRemoveFromCurrentItems(@Nullable T t) {
        if (t != null) {
            synchronized (this) {
                this.mCurrentItems.remove(t);
            }
        }
        return t;
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    @Nullable
    public T get(int i) {
        return maybeRemoveFromCurrentItems(this.mMap.acquire(i));
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    @Nullable
    public T pop() {
        return maybeRemoveFromCurrentItems(this.mMap.removeFromEnd());
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    public void put(T t) {
        boolean add;
        synchronized (this) {
            add = this.mCurrentItems.add(t);
        }
        if (add) {
            this.mMap.release(getSize(t), t);
        }
    }

    @VisibleForTesting
    public int valueCount() {
        return this.mMap.valueCount();
    }
}
