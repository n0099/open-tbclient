package com.facebook.common.references;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.PropagatesNullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes.dex */
public final class CloseableReference<T> implements Cloneable, Closeable {
    @GuardedBy("this")
    public boolean mIsClosed = false;
    public final LeakHandler mLeakHandler;
    public final SharedReference<T> mSharedReference;
    public static Class<CloseableReference> TAG = CloseableReference.class;
    public static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser<Closeable>() { // from class: com.facebook.common.references.CloseableReference.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.references.ResourceReleaser
        public void release(Closeable closeable) {
            try {
                Closeables.close(closeable, true);
            } catch (IOException unused) {
            }
        }
    };
    public static final LeakHandler DEFAULT_LEAK_HANDLER = new LeakHandler() { // from class: com.facebook.common.references.CloseableReference.2
        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public void reportLeak(SharedReference<Object> sharedReference) {
            FLog.w(CloseableReference.TAG, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), sharedReference.get().getClass().getName());
        }
    };

    /* loaded from: classes6.dex */
    public interface LeakHandler {
        void reportLeak(SharedReference<Object> sharedReference);
    }

    public CloseableReference(SharedReference<T> sharedReference, LeakHandler leakHandler) {
        this.mSharedReference = (SharedReference) Preconditions.checkNotNull(sharedReference);
        sharedReference.addReference();
        this.mLeakHandler = leakHandler;
    }

    public static void closeSafely(@Nullable CloseableReference<?> closeableReference) {
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/CloseableReference<TT;>; */
    public static CloseableReference of(@PropagatesNullable Closeable closeable) {
        return of(closeable, DEFAULT_CLOSEABLE_RELEASER);
    }

    @Nullable
    public synchronized CloseableReference<T> cloneOrNull() {
        if (isValid()) {
            return m34clone();
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.mIsClosed) {
                return;
            }
            this.mIsClosed = true;
            this.mSharedReference.deleteReference();
        }
    }

    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                this.mLeakHandler.reportLeak(this.mSharedReference);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public synchronized T get() {
        Preconditions.checkState(!this.mIsClosed);
        return this.mSharedReference.get();
    }

    @VisibleForTesting
    public synchronized SharedReference<T> getUnderlyingReferenceTestOnly() {
        return this.mSharedReference;
    }

    public int getValueHash() {
        if (isValid()) {
            return System.identityHashCode(this.mSharedReference.get());
        }
        return 0;
    }

    public synchronized boolean isValid() {
        return !this.mIsClosed;
    }

    public static void closeSafely(@Nullable Iterable<? extends CloseableReference<?>> iterable) {
        if (iterable != null) {
            for (CloseableReference<?> closeableReference : iterable) {
                closeSafely(closeableReference);
            }
        }
    }

    public static boolean isValid(@Nullable CloseableReference<?> closeableReference) {
        return closeableReference != null && closeableReference.isValid();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;Lcom/facebook/common/references/CloseableReference$LeakHandler;)Lcom/facebook/common/references/CloseableReference<TT;>; */
    public static CloseableReference of(@PropagatesNullable Closeable closeable, LeakHandler leakHandler) {
        if (closeable == null) {
            return null;
        }
        return new CloseableReference(closeable, DEFAULT_CLOSEABLE_RELEASER, leakHandler);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public synchronized CloseableReference<T> m34clone() {
        Preconditions.checkState(isValid());
        return new CloseableReference<>(this.mSharedReference, this.mLeakHandler);
    }

    public static <T> CloseableReference<T> of(@PropagatesNullable T t, ResourceReleaser<T> resourceReleaser) {
        return of(t, resourceReleaser, DEFAULT_LEAK_HANDLER);
    }

    @Nullable
    public static <T> CloseableReference<T> cloneOrNull(@Nullable CloseableReference<T> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.cloneOrNull();
        }
        return null;
    }

    public static <T> CloseableReference<T> of(@PropagatesNullable T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler) {
        if (t == null) {
            return null;
        }
        return new CloseableReference<>(t, resourceReleaser, leakHandler);
    }

    public static <T> List<CloseableReference<T>> cloneOrNull(@PropagatesNullable Collection<CloseableReference<T>> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (CloseableReference<T> closeableReference : collection) {
            arrayList.add(cloneOrNull(closeableReference));
        }
        return arrayList;
    }

    public CloseableReference(T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler) {
        this.mSharedReference = new SharedReference<>(t, resourceReleaser);
        this.mLeakHandler = leakHandler;
    }
}
